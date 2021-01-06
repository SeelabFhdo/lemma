#!/usr/bin/env python3

from functools import reduce
from pathlib import Path
from read_version_identifier_from_build_file import identifier_from_build_file
from yaml.loader import SafeLoader

import argparse
import os
import pydoc
import re
import subprocess
import sys
import yaml

class BuiltinArgument():
    """A built-in argument originating from LEMMA's Model Processing
    framework."""

    def __init__(self, name, option, destination, type, execution=None,
        required=False, help=None, alwaysAddAsIs=False):
        """Constructor."""

        self.name = name
        self.option = option
        self.destination = destination
        self.type = type
        self.execution = execution
        self.required = required
        self.help = help
        # Always add this built-in argument independent of the passed execution
        # configuration. That is, the argument is not customizable from an
        # execution configuration.
        self.alwaysAddAsIs = alwaysAddAsIs

class FilesystemArgumentInformation():
    """Filesystem-related information about an argument execution."""

    def __init__(self, filesystemElement, isRelativeToBasePath, mustExist,
        parentMustExist):
        """Constructor."""

        self.filesystemElement = filesystemElement
        self.isRelativeToBasePath = isRelativeToBasePath
        self.mustExist = mustExist
        self.parentMustExist = parentMustExist

class ArgumentExecution():
    """Execution information for an argument from the passed execution
    configuration.
    """

    def __init__(self, argument, option, filesystemInformation):
        """Constructor."""

        self.argument = argument
        self.option = option
        self.filesystemInformation = filesystemInformation

    @classmethod
    def fromScalars(self, argument, option, rawScalars):
        """Create an ArgumentExecution instance from a parsed YAML scalar from
        an execution configuration.
        """

        filesystemElement = ''
        isRelativeToBasePath = False
        mustExist = False
        parentMustExist = False

        for s in rawScalars:
            name = list(s.keys())[0].scalar
            value = list(s.values())[0]
            if isinstance(value, YamlLineLoader.ScalarWithLine):
                value = value.scalar

            if name == 'filesystem_element':
                filesystemElement = value
            elif name == 'is_relative_to_base_path':
                isRelativeToBasePath = value
            elif name == 'must_exist':
                mustExist = value
            elif name == 'parent_must_exist':
                parentMustExist = value

        return ArgumentExecution(
                argument,
                option,
                FilesystemArgumentInformation(
                    filesystemElement,
                    isRelativeToBasePath,
                    mustExist,
                    parentMustExist
                )
            )

# Dictionary of all available built-in arguments provided by LEMMA's Model
# Processing framework together with their execution configuration.
BUILTIN_ARGUMENTS = {
    'base_path': BuiltinArgument(
        'base_path',
        '-b',
        'basePath',
        str,
        ArgumentExecution('basePath', '-b',
            FilesystemArgumentInformation('folder', False, True, True)),
        required=True,
        help='base path for all model paths',
        alwaysAddAsIs=True
    ),

    'source_model': BuiltinArgument(
        'source_model',
        '-s',
        'sourceModel',
        str,
        ArgumentExecution('sourceModel', '-s',
            FilesystemArgumentInformation('file', True, True, True)),
    ),

    'intermediate_model': BuiltinArgument(
        'intermediate_model',
        '-i',
        'intermediateModel',
        str,
        ArgumentExecution('intermediateModel', '-i',
            FilesystemArgumentInformation('file', True, True, True)),
    ),

    'target_folder': BuiltinArgument(
        'target_folder',
        '-t',
        'targetFolder',
        str,
        ArgumentExecution('targetFolder', '-t',
            FilesystemArgumentInformation('folder', False, True, True)),
    )
}

class CustomArgument():
    """A custom argument originating from a YAML execution configuration."""

    def __init__(self, name):
        """Constructor."""

        self.name = name
        self.option = None
        self.type = None
        self.action = None
        self.choices = None
        self.default = None
        self.help = None

    def set_option(self, option, line):
        """Set option of argument from a given string or scalar."""

        self.option = self._value_of_type(option, str, line)

    def _value_of_type(self, value, expectedType, line):
        """Verify that the given value, which might be a scalar, is of the given
        expected type. In case the value is not of the type, this method raises
        an exception. Otherwise, it just returns the received value without
        casting it to the expected type.
        """

        if isinstance(value, YamlLineLoader.ScalarWithLine):
            valueToCheck = value.scalar
        else:
            valueToCheck = value

        if isinstance(valueToCheck, expectedType):
            return valueToCheck
        else:
            expectedTypeName = expectedType.__name__
            valueTypeName = type(valueToCheck).__name__
            lineStr = '(Line %d)' % line if line else ''
            raise Exception('Configuration error: Expected type "%s" for ' \
                'value %s but got "%s" %s' % \
                (expectedType, valueToCheck, valueTypeName, lineStr))

    def set_type(self, type, line):
        """Set type of argument from a given string or scalar."""

        self.type = pydoc.locate(self._value_of_type(type, str, line))

    def set_action(self, action):
        """Set action of argument from a given string or scalar."""

        self.action = self._value_of_type(action, str, None)

    def set_choices(self, rawChoices, line):
        """Set choices of argument from the list of rawChoices."""

        if not rawChoices:
            return

        choices = self._value_of_type(rawChoices, list, line)

        # Remove line information from parsing if existent
        lastElement = rawChoices[-1]
        if isinstance(lastElement, tuple) and len(lastElement) > 0:
            if lastElement[0] == '__line__':
                choices = rawChoices[:-1]

        # Construct argument choices as a list of strings, possibly from YAML
        # scalars
        self.choices = [self._value_of_type(c, str, line) for c in choices]

    def set_default(self, default):
        """Set default value of argument from a given string or scalar."""

        self.default = self._value_of_type(default, str, None)

    def set_help(self, help, line):
        """Set help of argument from a given string or scalar."""

        self.help = self._value_of_type(help, str, line)

class YamlLineLoader(SafeLoader):
    """Implementation of a YAML loader that preserves line numbers upon YAML
    parsing."""

    def construct_scalar(self, node):
        """Overridden from super class: Construct a YAML scalar by mapping it to
        a ScalarWithLine instance that holds the scalar together with its line
        in the YAML execution configuration.
        """

        scalar = super(YamlLineLoader, self).construct_scalar(node)
        # Increment line number, because numbering starts at 0
        return self.ScalarWithLine(scalar, node.start_mark.line + 1)

    class ScalarWithLine():
        """Representation of a YAML scalar with line information."""

        def __init__(self, scalar, line):
            """Constructor."""

            self.scalar = scalar
            self.line = line

        def lower(self):
            """Scalar method as expected by SafeLoader implementation of
            PyYAML."""

            return self.scalar.lower()

        def replace(self, s1, s2):
            """Scalar method as expected by SafeLoader implementation of
            PyYAML."""

            return self.scalar.replace(s1, s2)

    def construct_sequence(self, node, deep=False):
        """Overridden from super class: Construct a YAML sequence as a list and
        extend it with the ("__line__", LINE) tuple to identify the line of the
        sequence in the YAML execution configuration.
        """

        sequence = super(YamlLineLoader, self).construct_sequence(node,
            deep=deep)
        # Add line information if sequence does not only contain empty
        # collections, e.g., dictionaries. PyYAML will return empty collections
        # for scalars.
        if list(filter(None, sequence)):
            sequence.append(('__line__', node.start_mark.line + 1))
        return sequence

    def construct_mapping(self, node, deep=False):
        """Overridden from super class: Construct a YAML mapping as a dictionary
        and extend it with the ["__line__", LINE] entry to identify the line of
        the mapping in the YAML execution configuration.
        """

        mapping = super(YamlLineLoader, self).construct_mapping(node, deep=deep)
        mapping['__line__'] = node.start_mark.line + 1
        return mapping

class Configuration():
    """Class for parsing a YAML execution configuration and providing access to
    it configuration entries.
    """

    def __init__(self, filepath):
        """Constructor."""

        self.filepath = filepath
        self._entryCache = {}
        self._load_configuration(filepath)

    def _load_configuration(self, filepath):
        """Load YAML execution configuration from the given file path."""

        with open(filepath) as fd:
            self._parsed_yaml = yaml.load(fd, YamlLineLoader)

    def get_entry_or(self, orValue, *args):
        """Get one or more YAML execution configuration entries from the given
        arguments. The arguments identify the path of nested configuration
        entries in the parsed YAML file from which to retrieve one or more
        configuration entries. For instance, the arguments
            ['required_args', 'builtin']
        will retrieve all configuration entries in the nested "builtin" section
        of the top-level "required_args" section. In case the path does not
        exist, the method will return the given orValue.
        """

        result = self.get_entry(*args)
        if result is not None:
            return result
        else:
            return orValue

    def get_entry(self, *args):
        """Get one or more YAML execution configuration entries from the given
        arguments. The arguments identify the path of nested configuration
        entries in the parsed YAML file from which to retrieve one or more
        configuration entries. For instance, the arguments
            ['required_args', 'builtin']
        will retrieve all configuration entries in the nested "builtin" section
        of the top-level "required_args" section. In case the path does not
        exist, the method will return None.
        """

        entryKey = '$$$'.join(args)
        if entryKey in self._entryCache:
            return self._entryCache[entryKey]

        result = self._search_entry(self._parsed_yaml, *args)
        self._entryCache[entryKey] = result
        return result

    def _search_entry(self, collection, *args):
        """Search for the YAML execution configuration entries from the given
        arguments. The arguments identify the path of nested configuration
        entries in the parsed YAML file where to search for the path arguments.
        The method expects a collection from which to start searching (usually
        the parsed YAML execution configuration for the method's first
        invocation). The method will recursively search through all nested
        configuration entry collections until it found the given path or return
        None when a segment of the path could not be found.
        """

        nextCollection = collection

        for keyPart in args:
            if isinstance(nextCollection, list):
                nextCollection = self._search_entry_list(nextCollection,
                    keyPart)
            elif isinstance(nextCollection, dict):
                nextCollection = self._search_entry_dict(nextCollection,
                    keyPart)

        return nextCollection

    def _search_entry_list(self, l, keyPart):
        """Search a list of YAML execution configuration entries for the given
        key part of YAML path arguments, e.g., "builtin".
        """

        for entry in l:
            if self._get_comparable_yaml_value(entry) == keyPart:
                return entry
            elif isinstance(entry, list) or isinstance(entry, dict):
                result = self._search_entry(entry, keyPart)
                if result is not None:
                    return result

        return None

    def _get_comparable_yaml_value(self, entry):
        """Map a YAML execution configuration entry to a comparable value."""

        if isinstance(entry, YamlLineLoader.ScalarWithLine):
            return entry.scalar
        else:
            return entry

    def _search_entry_dict(self, d, keyPart):
        """Search a dictionary of YAML execution configuration entries for the
        given key part of YAML path arguments, e.g., "builtin".
        """

        for key, value in d.items():
            if self._get_comparable_yaml_value(key) == keyPart:
                return value

        return None

    def get_value_and_line(self, entry):
        """Get a value and line of the given YAML execution configuration
        entry.
        """

        if isinstance(entry, YamlLineLoader.ScalarWithLine):
            return (entry.scalar, entry.line)
        elif isinstance(entry, dict) and '__line__' in entry:
            return (entry, entry['__line__'])
        elif isinstance(entry, list):
            lineTuples = list(filter(lambda e:
                    isinstance(e, tuple) \
                        and len(e) > 0 \
                        and e[0] == '__line__',
                    entry
                ))
            if lineTuples:
                return (entry, lineTuples[0])
        else:
            return (entry, None)

class CommandLineParser(argparse.ArgumentParser):
    """Commandline parser for model processor execution based on YAML
    configuration files.
    """

    def __init__(self, config):
        """Constructor."""

        self._config = config
        self.builtinArguments = {'required': [], 'optional': []}
        self.customArguments = {'required': [], 'optional': []}
        self.positionalArguments = {}

        # Initialize superclass with program description from execution
        # configuration
        description = config.get_entry_or('', 'processor_info', 'description')
        super().__init__(description=description)

        # Setup commandline arguments from built-in arguments and parsed YAML
        # configuration file
        self._add_non_customizable_builtin_arguments()
        self._add_arguments('builtin', self._add_builtin_argument)
        self._add_arguments('custom', self._add_custom_argument)

    def _add_non_customizable_builtin_arguments(self):
        """Add built-in arguments, which are not customizable from execution
        configurations.
        """

        nonCustomizableArgs = list(
                filter(lambda a: a.alwaysAddAsIs, BUILTIN_ARGUMENTS.values())
            )
        for arg in nonCustomizableArgs:
            self.add_argument(arg.option, dest=arg.destination, type=arg.type,
                required=arg.required, help=arg.help)

    def _add_arguments(self, kind, handler):
        """Add arguments of the given kind from the parsed execution
        configuration leveraging the given handler. The kind of an argument
        corresponds to the subsections of the "required_args" and
        "optional_args" sections in the parsed YAML execution configuration,
        e.g., "custom" and "builtin".
        """

        args = self._config.get_entry_or([], 'required_args', kind)
        for arg in args:
            handler(arg, True)

        args = self._config.get_entry_or([], 'optional_args', kind)
        for arg in args:
            handler(arg, False)

    def _add_builtin_argument(self, arg, required):
        """Handler to add a built-in argument to the commandline parser."""

        (argName, help, line) = self._parse_builtin_argument(arg)
        if not argName:
            return

        if not argName in BUILTIN_ARGUMENTS:
            raise Exception('Configuration error: Unknown built-in argument ' \
                '"%s" (Line %d)' % (argName, line))

        builtinArg = BUILTIN_ARGUMENTS[argName]
        if builtinArg.alwaysAddAsIs:
            raise Exception('Configuration error: Configuration of built-in ' \
                'argument "%s" is not customizable (Line %d)' % (argName, line))

        self.add_argument(
            builtinArg.option,
            dest=builtinArg.destination,
            type=builtinArg.type,
            required=required,
            help=help
        )

        builtinArgInfo = {
            'argName': builtinArg.destination,
            'execution': builtinArg.execution
        }

        if required:
            self.builtinArguments['required'].append(builtinArgInfo)
        else:
            self.builtinArguments['optional'].append(builtinArgInfo)

    def _parse_builtin_argument(self, arg):
        """Retrieve the value, help text, and line of a built-in argument
        from the execution configuration.
        """

        value, line = self._config.get_value_and_line(arg)
        if isinstance(value, dict):
            argName, help = list(value.items())[0]
            return (argName.scalar, help.scalar, line)
        elif line:
            return (value, '', line)
        else:
            return (None, None, None)

    def _add_custom_argument(self, arg, required):
        """Handler to add a custom argument to the commandline parser."""

        value, _ = self._config.get_value_and_line(arg)
        argName, config = list(value.items())[0]
        customArg = CustomArgument(argName.scalar)

        executionInfo = None
        executionEntryValue = None
        for entry in config:
            entryScalar, entryValue = list(entry.items())[0]
            entryName = entryScalar.scalar
            entryLine = entryScalar.line
            if entryName == 'option':
                customArg.set_option(entryValue, entryLine)
            elif entryName == 'type':
                customArg.set_type(entryValue, entryLine)
            elif entryName == 'action':
                customArg.set_action(entryValue)
            elif entryName == 'choices':
                customArg.set_choices(entryValue, entryLine)
            elif entryName == 'default':
                customArg.set_default(entryValue)
            elif entryName == 'help':
                customArg.set_help(entryValue, entryLine)
            elif entryName == 'execution':
                executionEntryValue = entryValue

        # We treat all custom arguments, which do not have a type, as positional
        # arguments. That is, the commandline parser expects them without a
        # value assignmentm, e.g., "--my_arg" instead of "--my_arg=val".
        if customArg.type is None:
            # Gather positional arguments for subsequent access by callers
            self.positionalArguments[customArg.option] = customArg.name

            self.add_argument(
                    customArg.option,
                    dest=customArg.name,
                    action='store_true',
                    help=customArg.help
                )
        else:
            self.add_argument(
                    customArg.option,
                    dest=customArg.name,
                    type=customArg.type,
                    action=customArg.action,
                    choices=customArg.choices,
                    default=customArg.default,
                    help=customArg.help
                )


        # Parse execution information from custom argument if the argument
        # configuration has an "execution" subsection
        if executionEntryValue:
            executionInfo = ArgumentExecution.fromScalars(
                    customArg.option,
                    customArg.name,
                    executionEntryValue
                )

        customArgInfo = {
            'argName': customArg.name,
            'execution': executionInfo
        }

        if required:
            self.customArguments['required'].append(customArgInfo)
        else:
            self.customArguments['optional'].append(customArgInfo)

class ExecutionPlan():
    """Execution plan for a model processor."""

    class Opcode():
        """An execution plan consists of a set of opcodes, which represent
        actions for the validation of model processor argument validation or
        execution.
        """

        def __init__(self, name, isValidationOpcode=False):
            """Constructor."""

            self.name = name
            self.isValidationOpcode = isValidationOpcode

    # Opcodes for model processor argument validation
    ## Validate if argument points to a folder
    OC_VALIDATE_ISFOLDER = Opcode('VALIDATE_ISFOLDER', True)
    ## Validate if the parent of the argument, which must represent a file path,
    ## points to a folder
    OC_VALIDATE_PARENT_ISFOLDER = Opcode('VALIDATE_PARENT_ISFOLDER', True)
    ## Validate if argument points to a file
    OC_VALIDATE_ISFILE = Opcode('VALIDATE_ISFILE', True)

    # Opcodes for model processor argument addition
    ## Add argument to model processor call as it is
    OC_ADD_AS_EXECUTION_ARG = \
        Opcode('ADD_AS_EXECUTION_ARG')
    ## Add optional argument to model processor call as it is when it was passed
    OC_ADD_AS_EXECUTION_ARG_WHEN_NOT_EMPTY = \
        Opcode('ADD_AS_EXECUTION_ARG_WHEN_NOT_EMPTY')
    ## Add argument to model processor call with an additional value in the form
    ## "myArgument valueForMyArgument"
    OC_ADD_AS_EXECUTION_ARG_WITH_VALUE = \
        Opcode('ADD_AS_EXECUTION_ARG_WITH_VALUE')
    ## Add argument to model processor call with an additional value assignment
    ## in the form "myArgument=valueForMyArgument"
    OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT = \
        Opcode('ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT')
    ## Add optional argument to model processor call with an additional value
    ## assignment when the argument was passed
    OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_WHEN_NOT_EMPTY = \
        Opcode('ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_WHEN_NOT_EMPTY')
    ## Add a repeatable argument to model processor call with an additional
    ## value assignment
    OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_REPEAT = \
        Opcode('ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_REPEAT')
    ## Add all remainder, i.e., non-recognized, arguments as they occur on the
    ## parsed commandline
    OC_ADD_REMAINDER = \
        Opcode('ADD_REMAINDER')

    def __init__(self, config, builtinArguments, customArguments):
        """Constructor."""

        self._config = config
        self._builtinArguments = \
            self._unpack_argument_information(builtinArguments)
        self._customArguments = \
            self._unpack_argument_information(customArguments)
        self.steps = self._calculate_execution_steps()
        self.dockerInformation = self._parse_docker_information()

    def _unpack_argument_information(self, args):
        """Unpack argument information from the commandline parser.

        The parser yields argument information in the form
            {kind: [{"argName": name, "argExecution": execution}]}
        with kind being one of the strings "required" or "optional". This method
        turns the argument information dictionary into a "flattened" dictionary
        of the form
            {name: execution}
        which is sufficient for the creation of an execution plan.
        """

        unpackedArgs = {}
        argInfoList = list(reduce(lambda l, nl: l+nl, args.values()))
        for argInfo in argInfoList:
            unpackedArgs[argInfo['argName']] = argInfo['execution']
        return unpackedArgs

    def _calculate_execution_steps(self):
        """Calculate the steps in the execution plan.

        The basic layout of the steps is as follows:
            1. Validate built-in arguments.
            2. Validate custom arguments.
            3. Add built-in execution steps.
            4. Add execution steps from YAML execution configuration.
        """

        steps = self._argument_validation_steps(self._builtinArguments)
        steps += self._argument_validation_steps(self._customArguments)
        steps += self._builtin_execution_steps()
        steps += self._configured_execution_steps()
        return steps

    def _argument_validation_steps(self, args):
        """Derive validating execution steps for the given argument
        dictionary.
        """

        validationSteps = []

        for (argName, argExecution) in args.items():
            if argExecution:
                validationStep = self._build_argument_validation_step(argName,
                    argExecution)
                if validationStep:
                    validationSteps.append(validationStep)

        return validationSteps

    def _build_argument_validation_step(self, argName, argExecution):
        """Derive validating execution step for the given argument and its
        execution information.
        """

        # Argument validation currently only targets the existence of filesystem
        # elements
        filesysInfo = argExecution.filesystemInformation
        if not filesysInfo.mustExist and not filesysInfo.parentMustExist:
            return

        # Determine validation opcode
        opcode = None
        if filesysInfo.filesystemElement == 'folder' and filesysInfo.mustExist:
            opcode = self.OC_VALIDATE_ISFOLDER
        elif filesysInfo.filesystemElement == 'file' and filesysInfo.mustExist:
            opcode = self.OC_VALIDATE_ISFILE
        ## If folder or file must exist, their parent must also implicitly exist
        elif filesysInfo.parentMustExist:
            # Parents of filesystem objects can only be folders
            opcode = self.OC_VALIDATE_PARENT_ISFOLDER

        if opcode:
            return self.Step(argName, argExecution, argExecution.option, opcode)

    def _builtin_execution_steps(self):
        """Derive execution steps for built-in arguments."""

        steps = []

        for arg, execution in self._builtinArguments.items():
            steps.append(self.Step(
                    arg,
                    execution,
                    execution.option,
                    # Currently, all built-in arguments are of the form
                    # "myArgument valueForMyArgument"
                    self.OC_ADD_AS_EXECUTION_ARG_WITH_VALUE
                ))

        return steps

    def _configured_execution_steps(self):
        """Derive execution steps from YAML execution configuration."""

        # Get steps from YAML configuration ordered by their linewise
        # appearance in the configuration file
        rawSteps = self._config.get_entry_or([], 'processor', 'execution_steps')
        scalars = list(filter(
                lambda s: isinstance(s, YamlLineLoader.ScalarWithLine),
                rawSteps
            ))
        scalarByLine = {s.line:s.scalar for s in scalars}

        # Derive the actual execution steps
        orderedSteps = []
        for line in sorted(list(scalarByLine.keys())):
            step = scalarByLine[line]
            orderedSteps.append(
                    self.Step.fromRawStep(step, line, self._builtinArguments,
                        self._customArguments)
                )

        return orderedSteps

    class Step():
        """An execution step in an execution plan."""

        _WHEN_NOT_EMPTY_CHAR = '?'
        _STEP_ASSIGNMENT_REGEX = re.compile(
            r"(?P<option>.+)\=\S*args\S*\.(?P<arg>\w+)" + \
                r"((?P<whenNotEmpty>\%s)|(?P<repeat>\*))?$" % \
                _WHEN_NOT_EMPTY_CHAR
        )

        def __init__(self, argument, execution, option, opcode, line=None,
            whenNotEmpty=False, repeat=False):
            """Constructor."""

            self.argument = argument
            self.execution = execution
            self.option = option
            self.opcode = opcode
            self.line = line
            self.whenNotEmpty = whenNotEmpty
            self.repeat = repeat

        @classmethod
        def fromRawStep(self, step, line, builtinArguments, customArguments):
            """Derive a Step instance from a "raw" execution step entry in the
            YAML execution configuration.
            """

            assignmentMatch = self._STEP_ASSIGNMENT_REGEX.match(step)

            # Raw step has the basic form "myArgument=valueForMyArgument"
            if assignmentMatch:
                # Check if "myArgument" does actually refer to a built-in or
                # custom argument. If so, set execution information; otherwise
                # yield an exception.
                argument = assignmentMatch.group('arg')
                execution = self._ensure_is_arg_and_get_execution(
                        argument,
                        line,
                        builtinArguments,
                        customArguments
                    )

                # Set option
                option = assignmentMatch.group('option')

                # Set flag whether argument is only to apply if the user passed
                # a value for it for model processor execution
                whenNotEmpty = assignmentMatch.group('whenNotEmpty') is not None

                # Set flag whether argument is repeatable
                repeat = assignmentMatch.group('repeat') is not None

                # Set opcode
                if whenNotEmpty:
                    opcode = \
                        ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_WHEN_NOT_EMPTY
                elif repeat:
                    opcode = \
                        ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_REPEAT
                else:
                    opcode = \
                        ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT

            # Raw step has the form "args.remainder"
            elif step == 'args.remainder':
                argument = step
                execution = None
                option = None
                whenNotEmpty = False
                repeat = False
                opcode = ExecutionPlan.OC_ADD_REMAINDER

            # Raw step does not have "assignment" and "remainder" form. For
            # example, the step may just constitute a positional argument, e.g.,
            # "--activate_certain_processing_mode".
            else:
                # Only apply argument when the user explicitly passed it to the
                # script for model processor execution
                if step.endswith(self._WHEN_NOT_EMPTY_CHAR):
                    argument = step[:-1]
                    opcode = ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WHEN_NOT_EMPTY
                # Always add argument
                else:
                    argument = step
                    opcode = ExecutionPlan.OC_ADD_AS_EXECUTION_ARG
                execution = None
                option = None
                whenNotEmpty = False
                repeat = False

            return ExecutionPlan.Step(argument, execution, option, opcode, line,
                whenNotEmpty, repeat)

        @classmethod
        def _ensure_is_arg_and_get_execution(self, argName, line,
            builtinArguments, customArguments):
            """Check that the given argument is an existing built-in or custom
            argument. If so, return its execution information; otherwise raise
            exception.
            """

            if argName in builtinArguments:
                return builtinArguments[argName]
            elif argName in customArguments:
                return customArguments[argName]
            else:
                raise Exception('Execution specification error: Unknown ' \
                    'argument "%s" (Line %d)' % (argName, line))

        def __str__(self):
            """Get string representation of Step instance."""

            s = 'Execute "%s" on argument "%s"' % \
                (self.opcode.name, self.argument)
            if self.option:
                s += ' and option "%s"' % self.option
            return s

    def _parse_docker_information(self):
        """Parse Docker information from YAML execution configuration."""

        image = self._parse_mandatory_config_entry(
                'processor',
                'docker',
                'image'
            )
        repository = self._parse_mandatory_config_entry(
                'processor',
                'docker',
                'repository'
            )
        lemmaVersionFile = self._parse_mandatory_config_entry(
                'processor',
                'docker',
                'lemma_version_file'
            )

        #
        buildscript = self._config.get_entry_or(
                None,
                'processor',
                'docker',
                'buildscript'
            )

        return self.DockerInformation(image, repository, buildscript,
            self._config.filepath, lemmaVersionFile)

    def _parse_mandatory_config_entry(self, *args):
        """Helper to parse a mandatory configuration entry.

        Raise an exception in case the entry does not exist.
        """

        entry = self._config.get_entry_or(None, *args)
        if not entry:
            entryPath = '/'.join(args)
            raise Exception('Configuration error: Mandatory configuration ' \
                'entry "%s" is missing' % entryPath)

        return entry

    class DockerInformation():
        """Docker information from YAML execution configuration."""

        _DEFAULT_BUILDSCRIPT = 'build.sh'

        def __init__(self, image, repository, buildscript, configFilePath,
            lemmaVersionFile):
            """Constructor."""

            self.image = image.scalar
            self.repository = repository.scalar
            self.imageFullPath = '%s/%s' % (self.repository, self.image)

            # Turn file information into absolute representations
            self.lemmaVersionFile = self._to_absolute_path(configFilePath,
                lemmaVersionFile.scalar)

            if buildscript:
                self.buildscript = self._to_absolute_path(configFilePath,
                    buildscript.scalar)
            else:
                self.buildscript = self._to_absolute_path(configFilePath,
                    self._DEFAULT_BUILDSCRIPT)

        def _to_absolute_path(self, rawBasepath, filepath):
            """Helper to make the given filepath absolute based on the given raw
            base path, which may point to a file or folder.
            """

            if Path(filepath).is_absolute():
                return filepath

            if os.path.isdir(rawBasepath):
                basepath = rawBasepath
            else:
                basepath = Path(rawBasepath).parent

            return os.path.normpath(os.path.join(basepath, filepath))

class ModelProcessorExecutor():
    """Executor for model processors in Docker containers based on passed
    commandline arguments and following a given execution plan.
    """

    _ENVIRONMENT_VARIABLE_REGEX = re.compile(
            '(?P<variable>[^ =]+)=(?P<value>.*)'
        )
    _LOCAL_IMAGE_NAME_ENVIRONMENT_VARIABLE = 'LEMMA_DOCKER_IMAGE_TAG'
    _LEMMA_VERSION_ENVIRONMENT_VARIABLE = 'LEMMA_VERSION'

    def __init__(self, commandLineParser, executionPlan):
        """Constructor."""

        self._commandLineParser = commandLineParser
        self._executionSteps = executionPlan.steps
        self._dockerInformation = executionPlan.dockerInformation

    def run(self, rawArgs):
        """Run a model processor in a Docker image with applying the given
        commandline arguments.
        """

        # Ensure that the configured Docker image exists locally
        self._ensure_docker_image()

        # Parse the commandline arguments
        argsNs, remainder = self._commandLineParser.parse_known_args(rawArgs)
        argsDict = vars(argsNs)

        # Validate the parsed arguments and also get all folders, which were
        # verified to exist during the validation
        existingFolders = self._validate_args_and_get_existing_folders(argsDict)

        # Build Docker arguments and run the model processor inside a container
        # for the given Docker image
        dockerArgs = self._build_docker_run_arguments(argsDict, remainder,
            existingFolders)
        self._run_processor_in_docker_container(dockerArgs)

    def _ensure_docker_image(self):
        """Ensure that the configured Docker image exists locally."""

        self.image = self._local_docker_image()
        if not self.image:
            self.image = self._retrieve_docker_image()

    def _local_docker_image(self):
        """Check if the Docker image for the model processor exists locally and
        return either its simple name (without repository) or its fullname
        (including the repository) depending on which "version" of the image
        exists locally. Otherwise, return None.
        """

        if self._docker_image_query(self._dockerInformation.image):
            return self._dockerInformation.image
        elif self._docker_image_query(self._dockerInformation.imageFullPath):
            return self._dockerInformation.imageFullPath
        else:
            return None

    def _docker_image_query(self, image):
        """Query the local existence of a Docker image."""

        return subprocess.check_output(['docker', 'images', '-q', image])

    def _retrieve_docker_image(self):
        """Build or download a Docker image from a local buildscript or a
        remote repository, respectively. The user decides, how she wants to
        retrieve the image.
        """

        image = self._dockerInformation.image
        imageFullPath = self._dockerInformation.imageFullPath
        buildscript = self._dockerInformation.buildscript

        getDockerImage = input('Required docker image "%s" does not exist ' \
            'locally. Do you want to ' \
            '\n\t- build it locally via build script "%s" [b],' \
            '\n\t- pull it from the remote registry "%s" [p], or' \
            '\n\t- abort [a]? ' % (image, buildscript, imageFullPath))

        if getDockerImage == 'b':
            return self._build_docker_image_locally(buildscript, image)
        elif getDockerImage == 'p':
            self._pull_image(imageFullPath)
            return imageFullPath
        else:
            exit('Image retrieval aborted. Exiting.')

    def _build_docker_image_locally(self, buildscript, expectedImage):
        """Build a Docker image locally by means of the given buildscript. The
        method also checks that the buildscript actually yields the expected
        image.
        """

        artifactVersionFile = self._dockerInformation.lemmaVersionFile

        try:
            # We pass the LEMMA version identifier for the model processor to
            # the buildscript. It is required by model processor Dockerfiles to
            # copy the JAR archive of the model processor to the image. To
            # get the version identifier from build management files like Maven
            # POMs or Gradle scripts, we import the identifier_from_build_file
            # function from the "read_version_identifier_from_build_file.py"
            # Python script. To this end, the Python script must exist in the
            # same folder as this script.
            artifactVersion = identifier_from_build_file(artifactVersionFile)
        except Exception as err:
            raise Exception('Local Docker image build: Could not read '\
                'artifact version from file "%s": %s' % \
                (artifactVersionFile, str(err)))

        # Set the parsed LEMMA version identifier as a variable in the
        # environment of the subshell, which will execute the image buildscript
        buildscriptEnv = {
            self._LEMMA_VERSION_ENVIRONMENT_VARIABLE: artifactVersion
        }

        # Execute the buildscript, and retrieve its exit code and the
        # environment variables after the script's execution. From the resulting
        # environment variables, we retrieve the name of the built image.
        (exitcode, resultEnv) = self._execute_shellscript(buildscript,
            buildscriptEnv)
        if exitcode != 0:
            sys.exit(exitcode)

        # Check that the buildscript yielded the expected Docker image
        image = resultEnv[self._LOCAL_IMAGE_NAME_ENVIRONMENT_VARIABLE]
        if image != expectedImage:
            raise Exception('Local Docker image build: Build script "%s" ' \
                'returned image name "%s", which differs from the expected ' \
                'image name "%s"' % (buildscript, image, expectedImage))

        return image

    def _execute_shellscript(self, script, additionalEnvEntries):
        """Execute a shell script by incorporating additional environment
        variable entries into its execution environment.
        """

        scriptEnv = {**os.environ.copy(), **additionalEnvEntries}
        scriptPath = Path(script).absolute()
        scriptFolder = Path(scriptPath).parent
        # We must invoke the shell script with the POSIX "." command, because
        # otherwise we will not have access to the exported environment
        # variables via the "env" command. However, "." does by default not pass
        # arguments to the called script, which is the reason why we expect the
        # executed scripts to also read its arguments from environment
        # variable entries.
        pipe = subprocess.Popen(
            '. "%s" ; env' % scriptPath,
            shell=True,
            stdout=subprocess.PIPE,
            universal_newlines=True,
            cwd=scriptFolder,
            # Extended execution environment for the script with potential
            # arguments
            env=scriptEnv
        )
        scriptOutput = pipe.communicate()[0]

        # Parse the resulting environment variables yielded by the script
        env = {}
        for line in scriptOutput.split('\n'):
            variableMatch = self._ENVIRONMENT_VARIABLE_REGEX.match(line)
            if variableMatch:
                variable = variableMatch.group('variable')
                value = variableMatch.group('value')
                env[variable] = value
            # Read output does not constitute an environment variable. Thus, we
            # assume that the output is a regular output of the script and just
            # print it to STDOUT.
            else:
                print(line)

        return (pipe.returncode, env)

    def _pull_image(self, remoteImage):
        """Pull the given Docker remote image."""

        subprocess.call('docker pull ' + remoteImage, shell=True)

    def _validate_args_and_get_existing_folders(self, argsDict):
        """Validate the given arguments depending on their execution opcodes.

        For convenience reasons, this method will also return all filesystem
        folders, whose existence was validated from the given arguments and their
        execution opcodes.
        """

        existingFolders = []

        for step in self._executionSteps:
            if not step.opcode.isValidationOpcode:
                continue

            argValue = argsDict[step.argument]
            if not argValue:
                continue

            # Validate that the argument is an existing folder or list of
            # existing folders
            if step.opcode == ExecutionPlan.OC_VALIDATE_ISFOLDER:
                if not isinstance(argValue, list):
                    folderpath = self._with_basepath_if_relative(argValue,
                        argsDict, step)
                    self._validate_is_folder(folderpath)
                    existingFolders.append(folderpath)
                else:
                    for v in argValue:
                        folderpath = self._with_basepath_if_relative(v,
                            argsDict, step)
                        self._validate_is_folder(folderpath)
                        existingFolders.append(folderpath)

            # Validate that the parent of the argument is an existing folder
            # or that the parents of all arguments in a list of arguments are
            # existing folders
            elif step.opcode == ExecutionPlan.OC_VALIDATE_PARENT_ISFOLDER:
                if not isinstance(argValue, list):
                    fullpath = self._with_basepath_if_relative(argValue,
                        argsDict, step)
                    parentpath = self._validate_parent_is_folder(fullpath)
                    existingFolders.append(parentpath)
                else:
                    for v in argValue:
                        fullpath = self._with_basepath_if_relative(v, argsDict,
                            step)
                        parentpath = self._validate_parent_is_folder(fullpath)
                        existingFolders.append(parentpath)

            # Validate that the argument is an existing file or list of
            # existing files
            elif step.opcode == ExecutionPlan.OC_VALIDATE_ISFILE:
                if not isinstance(argValue, list):
                    filepath = self._with_basepath_if_relative(argValue,
                        argsDict, step)
                    self._validate_is_file(filepath)
                else:
                    for v in argValue:
                        filepath = self._with_basepath_if_relative(v,
                            argsDict, step)
                        self._validate_is_file(filepath)

        return existingFolders

    def _with_basepath_if_relative(self, path, argsDict, step):
        """Prepend the given path with the passed base path in case the
        corresponding argument shall be relative to the base path.
        """

        if step.execution.filesystemInformation.isRelativeToBasePath:
            basepath = self._get_builtin_argument_value(argsDict, 'base_path')
            return Path(os.path.join(basepath, path))

        return path

    def _get_builtin_argument_value(self, argsDict, argKey):
        """Get the passed value of a built-in argument."""

        destination = BUILTIN_ARGUMENTS[argKey].destination
        if destination in argsDict:
            return argsDict[destination]
        else:
            None

    def _validate_is_folder(self, path):
        """Validate that the given path is an existing folder. If not, raise an
        exception.
        """

        if not Path(path).is_dir():
            raise Exception('Path specification "%s" does not point to an ' \
                'existing folder' % path)

    def _validate_parent_is_folder(self, path):
        """Validate that the parent of the given path is an existing folder. If
        not, raise an exception.
        """

        parentpath = Path(path).parent
        if not Path(parentpath).is_dir():
            raise Exception('Parent path "%s" of path specification "%s" ' \
                'does not point to an existing folder' % (parentpath, path))

        return parentpath

    def _validate_is_file(self, path):
        """Validate that the given path is an existing file. If not, raise an
        exception.
        """

        if not Path(path).is_file():
            raise Exception('Path specification "%s" does not point to an ' \
                'existing file' % path)

    def _build_docker_run_arguments(self, argsDict, remainder, existingFolders):
        """Build arguments string for the execution of the model processor in a
        Docker container of the configured image.
        """

        # Basic arguments: Mapped volumes, user, and image
        basepath = self._get_builtin_argument_value(argsDict, 'base_path')
        dockerArgs = ['-v "%s":"%s"' % (basepath, basepath)]

        for folder in existingFolders:
            dockerArgs += ['-v "%s":"%s"' % (folder, folder)]
        ## We let the image run with the ID of the current user so that produced
        ## files do not have root permission in mapped volumes pointing to the
        ## user's filesystem
        dockerArgs += ['-u $(id -u ${USER}):$(id -g ${USER})']
        dockerArgs += ['%s' % self.image]

        # Custom arguments: Build configured custom arguments from identified
        # opcodes
        for step in self._executionSteps:
            if step.opcode.isValidationOpcode:
                continue

            # Add argument as-is to Docker call
            if step.opcode == ExecutionPlan.OC_ADD_AS_EXECUTION_ARG:
                dockerArgs += ['%s' % step.argument]

            # Add argument as-is to Docker call when the user passed a value for
            # it
            elif step.opcode == \
                ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WHEN_NOT_EMPTY:
                argDest = \
                    self._commandLineParser.positionalArguments[step.argument]
                argValue = argsDict[argDest] if argDest in argsDict else None
                if argValue:
                    dockerArgs += ['%s' % step.argument]

            # Add argument in the form "myArgument valueForMyArgument" to Docker
            # call
            elif step.opcode == \
                ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_VALUE:
                argValue = self._get_docker_run_argument_value(argsDict, step)
                dockerArgs += ['%s "%s"' % (step.option, argValue)]

            # Add argument in the form "myArgument=valueForMyArgument" to Docker
            # call
            elif step.opcode == \
                ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT:
                argValue = self._get_docker_run_argument_value(argsDict, step)
                dockerArgs += ['%s="%s"' % (step.option, argValue)]

            # Add argument in the form "myArgument=valueForMyArgument" to Docker
            # call when "valueForMyArgument" was passed
            elif step.opcode == \
                ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_WHEN_NOT_EMPTY:
                argValue = self._get_docker_run_argument_value(argsDict, step)
                if argValue:
                    dockerArgs += ['%s="%s"' % (step.option, argValue)]

            # Add repeatable argument in the form
            # "myArgument=valueForMyArgument" to Docker call
            elif step.opcode == \
                ExecutionPlan.OC_ADD_AS_EXECUTION_ARG_WITH_ASSIGNMENT_REPEAT:
                argValue = self._get_docker_run_argument_value(argsDict, step)
                if argValue:
                    for v in argValue:
                        dockerArgs += ['%s="%s"' % (step.option, v)]

            # Add remainder arguments to Docker call
            elif step.opcode == ExecutionPlan.OC_ADD_REMAINDER and remainder:
                dockerArgs += remainder

        return ' \\\n'.join(dockerArgs)

    def _get_docker_run_argument_value(self, argsDict, step):
        """Get value of an execution step's argument to pass it to an argument
        for a Docker call.
        """

        if not step.argument in argsDict:
            return None

        argValue = argsDict[step.argument]
        if not argValue:
            return None

        # Consider filesystem information in argument execution information of
        # step
        if step.execution:
            filesystemInformation = step.execution.filesystemInformation
            isRelativeToBasePath = filesystemInformation.isRelativeToBasePath
        else:
            isRelativeToBasePath = False

        # Make argument value absolute to given base path if necessary
        if isRelativeToBasePath:
            basepath = self._get_builtin_argument_value(argsDict, 'base_path')

            # In case the argument value is a list, the resulting value will
            # also be a list with all of its entries being absolute to the
            # base path
            if isinstance(argValue, list):
                argValue = list(
                        map(lambda v: os.path.join(basepath, v), argValue)
                    )
            else:
                argValue = os.path.join(basepath, argValue)

        return argValue

    def _run_processor_in_docker_container(self, dockerArgs):
        """Run the model processor in a Docker container with the given
        arguments.
        """

        subprocess.call('docker run -i ' + dockerArgs, shell=True)

def error_and_die(msg):
    """Leave script with error exit code."""

    exit(msg, 1)

def exit(msg, status=0):
    """Exit script with a given message and possibly exit code.

    The default exit code is 0.
    """

    print(msg)
    sys.exit(status)

if __name__ == '__main__':
    """Entrypoint logic."""

    if len(sys.argv) <= 1:
        error_and_die('Missing command line argument: Execution configuration '\
            'file')

    try:
        configFilepath = sys.argv[1]
        processorArgs = sys.argv[2:]

        config = Configuration(configFilepath)
        commandLineParser = CommandLineParser(config)
        executionPlan = ExecutionPlan(
                config,
                commandLineParser.builtinArguments,
                commandLineParser.customArguments,
            )
        executor = ModelProcessorExecutor(commandLineParser, executionPlan)
        executor.run(processorArgs)
    except Exception as err:
        error_and_die(str(err))
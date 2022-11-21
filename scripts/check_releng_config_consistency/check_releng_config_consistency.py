#!/usr/bin/env python3

# Helper script to check LEMMA's various Releng configuration files for
# consistency with LEMMA's modules in the filesystem.

import os
import ntpath
import posixpath
import re
import sys

from lxml import etree
from os.path import abspath
from os.path import basename
from os.path import dirname
from os.path import isdir
from os.path import isfile
from os.path import join
from typing import List, Set

GRADLE_PROJECT_FILES = ['settings.gradle.kts']
GRADLE_PROJECT_NAME_REGEX = re.compile(
        'rootProject\.name\s*=\s*("|\')(?P<name>.+)("|\').*'
    )
MAVEN_POM_FILES = ['pom.xml']
MAVEN_POM_NAMESPACE = 'http://maven.apache.org/POM/4.0.0'
MAVEN_POM_MODULES = '/{{{0}}}modules/{{{0}}}module'\
    .format(MAVEN_POM_NAMESPACE)
MODULE_DIR_PREFIX = 'de.fhdo.lemma'
PLUGIN_IDENTIFYING_FILES = ['plugin.xml']
RELATIVE_BUILD_CONFIG_FILEPATH_FROM_MODULE_DIR = join('build',
    'lemma-build-modules.txt')
RELATIVE_DEPLOYMENT_CONFIG_FILEPATH_FROM_MODULE_DIR = join('build', 'deploy',
    'lemma-deployment-modules.txt')
RELATIVE_UPDATESITE_CONFIG_FILEPATH_FROM_MODULE_DIR = join(
        'build',
        'updatesite',
        'lemma-build-updatesite-modules.txt'
    )
RELATIVE_UPDATESITE_FEATURE_FILEPATH_FROM_MODULE_DIR = join(
        'de.fhdo.lemma.eclipse.updatesite.feature',
        'feature.xml'
    )
RELATIVE_WINDOWS_BUILD_CONFIG_FILEPATH_FROM_MODULE_DIR = join('build',
    'lemma.bat')
WINDOWS_BUILD_MODULE_REGEX = re.compile('set\s+modules\s*=\s*(%modules%;)?'\
    '"?(?P<name>[^"]+)"?')

def _error_and_die(errorMessage):
    """Print an error and leave the program a non-zero status code."""

    print(errorMessage, file=sys.stderr)
    sys.exit(1)

def _find_module_files(rootDir: str, simpleFilenames: List[str])\
    -> Set[str]:
    """Find all files in LEMMA modules that match the simple names in the given
    list of module identifier files. The rootDir parameter is expected to point
    to the root hierarchy of LEMMA modules in the filesystem.
    """

    moduleFiles = set()

    for root, dirs, _ in os.walk(rootDir):
        for dirObj in dirs:
            dir = str(dirObj)
            if not dir.startswith(MODULE_DIR_PREFIX):
                continue

            dirPath = join(root, dir)
            moduleFile = _any_file_exists(dirPath, simpleFilenames)
            if moduleFile:
                moduleFiles.add(moduleFile)

    return moduleFiles

def _any_file_exists(rootDir: str, filenames: List[str]) -> str:
    """Returns the full path to the first existing file in the given root
    directory and with a name from the given list of filenames. In case no file
    with one of the given names exist in the root directory, the function
    returns None.
    """

    for file in filenames:
        fullFilepath = join(rootDir, file)
        if isfile(fullFilepath):
            return fullFilepath
    return None

class ModuleInfo:
    """Cluster information about a LEMMA module in the filesystem."""

    def __init__(self, moduleDir: str, filepath: str, children: Set[str]):
        """Constructor."""

        self._filepath = filepath
        fileDir = dirname(filepath)
        # Module name is the path to the module relative to the module directory
        # (e.g., "de.fhdo.lemma.analyzer" or
        # "code generators/de.fhdo.lemma.ddd")
        self._name = fileDir[len(moduleDir)+1:]
        self._children = children
        self._parent = None

    def get_filepath(self) -> str:
        return self._filepath

    def get_name(self) -> str:
        return self._name

    def get_children(self) -> Set[str]:
        return self._children

    def set_parent(self, parent: str):
        self._parent = parent

    def get_parent(self) -> str:
        return self._parent

def _parse_pom_files(moduleDir: str, pomFilepaths: Set[str])\
    -> List[ModuleInfo]:
    """Parse all given Maven POM files into corresponding ModuleInfo instances.
    """

    moduleInfo = []

    for filepath in pomFilepaths:
        pomXml = etree.parse(filepath)
        childrenXml = pomXml.findall(MAVEN_POM_MODULES)

        if childrenXml:
            children = {basename(m.text) for m in childrenXml}
        else:
            children = set()

        moduleInfo.append(ModuleInfo(moduleDir, filepath, children))

    return moduleInfo

def _parse_gradle_files(moduleDir: str, gradleFilepaths: Set[str])\
    -> List[ModuleInfo]:
    """Parse all given Gradle settings files into corresponding ModuleInfo
    instances.
    """

    moduleInfo = []

    for filepath in gradleFilepaths:
        with open(filepath, 'r') as f:
            for l in f:
                line = l.strip()
                if line and GRADLE_PROJECT_NAME_REGEX.match(l):
                    moduleInfo.append(ModuleInfo(moduleDir, filepath, set()))
                    break

    return moduleInfo

def _distribute_parent_info(moduleInfo: List[ModuleInfo]):
    """Add information about parent modules to the given ModuleInfo instances
    based on the previously parsed children of the modules.
    """

    for i in moduleInfo:
        parentInfo = _find_parent(i, moduleInfo)
        if parentInfo:
            i.set_parent(parentInfo.get_name())

def _find_parent(child: ModuleInfo, potentialParents: List[ModuleInfo])\
    -> ModuleInfo:
    """Find the parent ModuleInfo for the given child from the given list of
    potential parent ModuleInfo instances.
    """

    return next(
        (p for p in potentialParents if child.get_name() in p.get_children()),
        None
    )

def _parse_modules_from_lemma_config(configFilepath: str) -> Set[str]:
    """Parse module names from a LEMMA configuration which is a simple text file
    consisting of lines with module names, empty lines, and comment lines
    starting with the hashtag character #.
    """

    modules = set()

    with open(configFilepath, 'r') as f:
        for l in f:
            line = l.strip()
            if not line or line.startswith('#'):
                continue

            modules.add(line)

    return modules

def _parse_modules_from_windows_config(configFilepath: str) -> Set[str]:
    """Parse module names from a LEMMA Windows configuration which is a Batch
    file that declares an array variable called "modules" that gets
    consecutively populated with additional entries, each of which is the name
    of a LEMMA module.
    """

    modules = set()

    with open(configFilepath, 'r') as f:
        for l in f:
            line = l.strip()
            if not line or line.startswith('REM'):
                continue
            
            m = WINDOWS_BUILD_MODULE_REGEX.match(l)
            if m:
                modules.add(m.group('name').strip())
    
    return modules

def _posix_seps(path: str):
    """Convert a given path to a POSIX representation in which separators of the
    current OS are replaced by POSIX separators."""

    if not path:
        return None
    elif os.sep != posixpath.sep:
        return path.replace(os.sep, posixpath.sep)
    else:
        return path

def _module_and_parent(module: str, parent: str):
    """Build a string consisting of a LEMMA module name and the name of its
    parent if it has one."""

    if parent:
        return '"%s" or parent "%s"' % (module, parent)
    else:
        return '"%s"' % module

def _windows_seps(path: str):
    """Convert a given path to a Windows representation in which separators of
    the current OS are replaced by Windows separators."""

    if not path:
        return None
    elif os.sep != ntpath.sep:
        return path.replace(os.sep, ntpath.sep)
    else:
        return path

def _filter_eclipse_plugins(moduleInfo: List[ModuleInfo]) -> List[ModuleInfo]:
    """Filter the given list of ModuleInfo instances by those that represent
    Eclipse plugins.
    """

    pluginInfo = {}

    for i in moduleInfo:
        dir = dirname(i.get_filepath())
        # We identify Eclipse plugins by the existence of certain files.
        # However, we also return the "sibling" modules of the plugins which
        # enables to check their configuration, e.g., in the Eclipse Updatesite
        # feature. For example, the "de.fhdo.lemma.servicedsl.metamodel" module
        # exhibits the "plugin.xml" file identifying it as an Eclipse plugin.
        # The parent module of the "metamodel" module is
        # "de.fhdo.lemma.servicedsl.parent" and one of its children is the
        # "de.fhdo.lemma.servicedsl.extractor". The "extractor" module is thus a
        # sibling of the "metamodel" module since both modules have the same
        # parent.
        if _any_file_exists(dir, PLUGIN_IDENTIFYING_FILES):
            pluginInfo[i.get_name()] = i
            pluginParent = _find_parent(i, moduleInfo)
            pluginSiblings = filter(
                    lambda c: c.get_name() in pluginParent.get_children(),
                    moduleInfo
                ) if pluginParent else {}
            pluginSiblings = {c.get_name(): c for c in pluginSiblings}
            pluginInfo = {**pluginInfo, **pluginSiblings}

    return pluginInfo.values()

def _parse_plugins_from_updatesite_feature(configFilepath: str) -> Set[str]:
    """Parse Eclipse plugin names from the given feature configuration which is
    expected to be specified in XML following Eclipse's format for Updatesite
    feature configurations.
    """

    featureXml = etree.parse(configFilepath)
    return {e.attrib['id'] for e in featureXml.findall('plugin')}

if __name__ == '__main__':
    if len(sys.argv) <= 1:
        _error_and_die('Missing module directory. Exiting.')

    moduleDir = sys.argv[1]
    if not isdir(moduleDir):
        _error_and_die('Module directory "%s" does not exist. Exiting.' %
            moduleDir)

    # Check the consistency of LEMMA build and deployment configurations with
    # existing filesystem modules
    pomFiles = _find_module_files(moduleDir, MAVEN_POM_FILES)
    pomInfo = _parse_pom_files(moduleDir, pomFiles)

    gradleFiles = _find_module_files(moduleDir, GRADLE_PROJECT_FILES)
    gradleInfo = _parse_gradle_files(moduleDir, gradleFiles)

    completeBuildInfo = pomInfo + gradleInfo
    _distribute_parent_info(completeBuildInfo)

    buildConfigFile = abspath(join(moduleDir,
        RELATIVE_BUILD_CONFIG_FILEPATH_FROM_MODULE_DIR))
    configuredBuildModules = _parse_modules_from_lemma_config(buildConfigFile)

    deploymentConfigFile = abspath(join(moduleDir,
        RELATIVE_DEPLOYMENT_CONFIG_FILEPATH_FROM_MODULE_DIR))
    configuredDeploymentModules = _parse_modules_from_lemma_config(
            deploymentConfigFile
        )

    windowsConfigFile = abspath(join(moduleDir,
        RELATIVE_WINDOWS_BUILD_CONFIG_FILEPATH_FROM_MODULE_DIR))
    configuredWindowsBuildModules = _parse_modules_from_windows_config(
            windowsConfigFile
        )

    messages = []
    for i in completeBuildInfo:
        posixModule = _posix_seps(i.get_name())
        posixParent = _posix_seps(i.get_parent())
        if posixModule not in configuredBuildModules\
            and posixParent not in configuredBuildModules:
            messages.append('No build config entry: %s' %
                _module_and_parent(posixModule, posixParent))

        if posixModule not in configuredDeploymentModules\
            and posixParent not in configuredDeploymentModules:
            messages.append('No deployment config entry: %s' %
                _module_and_parent(posixModule, posixParent))

        windowsModule = _windows_seps(i.get_name())
        windowsParent = _windows_seps(i.get_parent())
        if windowsModule not in configuredWindowsBuildModules\
            and windowsParent not in configuredWindowsBuildModules:
            messages.append('No Windows build config entry: %s' %
                _module_and_parent(windowsModule, windowsParent))

    # Check the consistency of LEMMA's Eclipse Updatesite configuration with
    # existing filesystem modules
    eclipsePluginProjects = _filter_eclipse_plugins(completeBuildInfo)

    updatesiteConfigFile = abspath(join(moduleDir,
        RELATIVE_UPDATESITE_CONFIG_FILEPATH_FROM_MODULE_DIR))
    configuredUpdatesitePlugins = _parse_modules_from_lemma_config(
            updatesiteConfigFile
        )

    featureFile = abspath(join(moduleDir,
        RELATIVE_UPDATESITE_FEATURE_FILEPATH_FROM_MODULE_DIR))
    configuredUpdatesiteFeaturePlugins = _parse_plugins_from_updatesite_feature(
            featureFile
        )

    for p in eclipsePluginProjects:
        pluginName = p.get_name()
        pluginParent = p.get_parent()

        if pluginName not in configuredUpdatesitePlugins\
            and pluginParent not in configuredUpdatesitePlugins:
            print('No corresponding Updatesite config: %s' %
                _module_and_parent(pluginName, pluginParent))

        if pluginName not in configuredUpdatesiteFeaturePlugins:
            messages.append('No corresponding Updatesite feature: %s' %
                pluginName)

    # Print out error messages and exit with a corresponding status code
    if messages:
        messages.sort()
        _error_and_die('\n'.join(messages))
#!/usr/bin/env python3

# Helper script to read the version identifier from build tool files like Maven
# POMs or Gradle properties.

import os
import re
import sys

from lxml import etree

ERROR_RETURN_VALUE = 1
GRADLE_PROPERTIES_VERSION_REGEX = r'version\s*=\s*(?P<version>.+)'
MAVEN_POM_NAMESPACE = 'http://maven.apache.org/POM/4.0.0'

def identifier_from_gradle_properties(filepath):
    """Read version identifier from Gradle properties."""

    with open(filepath, 'r') as f:
        for l in f:
            versionMatch = re.match(GRADLE_PROPERTIES_VERSION_REGEX, l)
            if versionMatch:
                return versionMatch.group('version')
    return None

def identifier_from_maven_pom(filepath):
    """Read version identifier from Maven POM."""

    pomXml = etree.parse(filepath)

    try:
        return pomXml.findall('/{%s}version' % MAVEN_POM_NAMESPACE)[0].text
    except IndexError:
        raise IndexError('"version" XML element not found in POM file' % \
            withNamespace)

def find_parser_function(filepath):
    """Find parser function for given filepath."""

    function = find_parser_function_by_filename(filepath)
    if function:
        return function

    function = find_parser_function_by_extension(filepath)
    if function:
        return function

    raise Exception('No parser function found for file "%s"' % filepath)

def find_parser_function_by_filename(filepath):
    """Try to find parser function by filename."""

    filenameFunctions = {
        filename:function for (filename,function) in PARSER_FUNCTIONS.items()
            if not filename.startswith('*')
    }

    try:
        filename = os.path.basename(filepath)
        return filenameFunctions[filename]
    except KeyError:
        return None

def find_parser_function_by_extension(filepath):
    """Try to find parser function by file extension."""

    extensionFunctions = {
        ext[1:]:function for (ext,function) in PARSER_FUNCTIONS.items()
            if ext.startswith('*')
    }

    try:
        _, extension = os.path.splitext(filepath)
        return extensionFunctions[extension]
    except KeyError:
        return None

def error_and_die(errorMessage, returnValue=ERROR_RETURN_VALUE):
    """Print an error and leave program with the given return value."""

    print(errorMessage, file=sys.stderr)
    sys.exit(returnValue)

PARSER_FUNCTIONS = {
    '*.properties': identifier_from_gradle_properties,
    'pom.xml': identifier_from_maven_pom
}

if __name__ == '__main__':
    if len(sys.argv) <= 1:
        error_and_die('Missing filename. Exiting.')

    try:
        filepath = sys.argv[1]
        parserFunction = find_parser_function(filepath)
        versionIdentifier = parserFunction(filepath)
        if not versionIdentifier:
            error_and_die(ex)
        print(versionIdentifier)
    except Exception as ex:
        error_and_die(ex)
#!/usr/bin/env python3

# Adapt Maven "settings.xml" to store the credentials and IDs for Maven
# snapshots and releases servers

import os
import sys

from lxml import etree

MAVEN_SETTINGS_NAMESPACE = 'http://maven.apache.org/SETTINGS/1.0.0'

def err_and_die(*args, **kwargs):
    """Print an error message and exit the script with status code 1."""

    print(*args, file=sys.stderr, **kwargs)
    if exit:
        sys.exit(1)

def env_or_die(varname):
    """Check if environment variable received a value.

    Otherwise print an error message and exit the script with error code.
    """

    value = os.getenv(varname)
    if not value:
        err_and_die('Environment variable %s not set' % varname)
    return value

def adapt_maven_settings(settingsFilepath, user, password, snapshotsServerId,
    releasesServerId):
    """Adapt an existing Maven "settings.xml" file.

    The method adds the <servers> element to the file, as well as two <server>
    elements. The first <server> element will receive the ID of the Maven
    snapshots server to be used for deployments, and the second <server> element
    will receive the ID of the releases server. Moreover, the credentials for
    both servers are added to the elements. Currently, the snapshots and
    releases credentials are identical.
    """

    try:
        settingsXml = etree.parse(settingsFilepath)
    except Exception as err:
        err_and_die('Could not parse Maven settings file "%s" (original ' \
            'error was: %s)' % (settingsFilepath, str(err)))

    serversElement = servers_element(settingsXml)
    add_server(serversElement, snapshotsServerId, user, password)
    add_server(serversElement, releasesServerId, user, password)
    settingsXml.write(settingsFilepath, pretty_print=True)

def servers_element(settingsXml):
    """Get or create the <servers> element from the passed "settings.xml"."""

    try:
        serversElement = firstElement(settingsXml, '/{%(ns)s}servers')
    except IndexError:
        serversElement = etree.Element('servers')
        settingsXml.getroot().append(serversElement)

    return serversElement

def firstElement(xmlTree, elementSelector):
    """Find the first matching element for the given XPath selector from an XML
    tree.
    """

    withNamespace = with_namespace(elementSelector)

    try:
        return xmlTree.findall(withNamespace)[0]
    except IndexError as err:
        raise IndexError('No element found for selector "%s"' % withNamespace)

def with_namespace(elementSelector, namespaceArg='ns'):
    """Add namespace to XPath selector."""

    return elementSelector % {namespaceArg: MAVEN_SETTINGS_NAMESPACE}

def add_server(serversElement, id, username, password):
    """Add <server> XML element to <servers> element.

    The new element also comprises the <id>, <username>, and <password> sub-
    elements with the specified values.
    """

    serverElement = etree.Element('server')

    idElement = etree.Element('id')
    idElement.text = id
    serverElement.append(idElement)

    usernameElement = etree.Element('username')
    usernameElement.text = username
    serverElement.append(usernameElement)

    passwordElement = etree.Element('password')
    passwordElement.text = password
    serverElement.append(passwordElement)

    serversElement.append(serverElement)

if __name__ == '__main__':
    if len(sys.argv) <= 1:
        err_and_die('You need to pass the path to Maven\'s settings.xml as ' \
            'argument')
    settingsFilepath = sys.argv[1]

    serverUser = env_or_die('DEPLOY_MAVEN_USER')
    serverPassword = env_or_die('DEPLOY_MAVEN_PASSWORD')
    snapshotsServerId = env_or_die('DEPLOY_MAVEN_ID_SNAPSHOTS')
    releasesServerId = env_or_die('DEPLOY_MAVEN_ID_RELEASES')

    adapt_maven_settings(settingsFilepath, serverUser, serverPassword,
        snapshotsServerId, releasesServerId)
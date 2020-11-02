#!/usr/bin/env python3

# Helper script to facilitate the usage of LEMMA's Java generator via Docker.
# The script expects the following arguments:
#   -b: Base path. This is the base path for all model files. It will be mounted
#       as a volume in the Docker container.
#   -s: Source model. This is the source model file. It must be stated relative
#       to the base path.
#   -i: Intermediate model: This is the intermediate model file. It must be
#       stated relative to the base path.
#   -t: Target folder. Target folder for generated artifacts. It must be stated
#       absolute and exist on the hard drive on which this script is executed.
# Optional arguments:
#   -a: Alternative intermediate service model. If stated, microservices will be
#       generated based on this file, while domain concepts will be generated
#       from the passed intermediate model. The alternative model must be stated
#       relative to the base path.)
#   -p: Generation pattern. Must be any of the values "extended-generation-gap",
#       "generation-gap", or "plain". Defaults to "extended-generation-gap".

import argparse
import os
import pathlib
import re
import subprocess
import sys

DEFAULT_PATTERN = 'extended-generation-gap'
IMAGE_NAME = 'lemma/java_generator:latest'
IMAGE_REPOSITORY = 'repository.seelab.fh-dortmund.de:51900'
IMAGE_FULL_PATH = IMAGE_REPOSITORY + '/' + IMAGE_NAME
JAVA_GENERATOR_PATH = '../../' \
    'de.fhdo.lemma.model_processing.code_generation.java_base'
VERSION_REGEX = r'version\s*=\s*(?P<version>.+)'

def exists_docker_image():
    """Verify if the Java generator Docker image is present."""
    result = subprocess.check_output(['docker', 'images', '-q',
        IMAGE_FULL_PATH])
    return len(result) > 0

def build_image_locally(buildScript):
    """Build the Java generator Docker image locally."""
    gradlePropertiesPath = JAVA_GENERATOR_PATH + os.sep + 'gradle.properties'
    try:
        javaGeneratorVersion = read_java_generator_version(gradlePropertiesPath)
    except FileNotFoundError:
        print('Could not read Java Generator version from file "%s". Does it ' \
            'exist?' % gradlePropertiesPath)
        sys.exit(1)

    subprocess.call('"%s" "%s"' % (buildScript, javaGeneratorVersion),
        shell=True)

def read_java_generator_version(gradlePropertiesPath):
    """Read the version of the Java Base Generator."""
    with open(gradlePropertiesPath, 'r') as f:
        for l in f:
            versionMatch = re.match(VERSION_REGEX, l)
            if versionMatch:
                return versionMatch.group('version')
    return None

def pull_image(remoteImage):
    """Pull the Java generator Docker image from our repository."""
    subprocess.call('docker pull ' + remoteImage, shell=True)

def parse_commandline():
    """Parse commandline."""
    parser = argparse.ArgumentParser(
        description='Run LEMMA Java Generator.')
    parser.add_argument(
        '-b',
        dest='basePath',
        type=str,
        required=True,
        help='base path for all model paths')
    parser.add_argument(
        '-s',
        dest='sourceModel',
        type=str,
        required=True,
        help='path to source service or mapping model (must be relative to ' \
            'model base path)')
    parser.add_argument(
        '-i',
        dest='intermediateModel',
        type=str,
        required=True,
        help='path to intermediate service or mapping model (must be ' \
            'relative to model base path)')
    parser.add_argument(
        '-t',
        dest='targetFolder',
        type=str,
        required=True,
        help='path to generation target folder')
    parser.add_argument(
        '-p',
        dest='pattern',
        type=str,
        choices=['extended-generation-gap', 'generation-gap', 'plain'],
        default=DEFAULT_PATTERN,
        help='code generation pattern (default: %s)' % DEFAULT_PATTERN)
    parser.add_argument(
        '-a',
        dest='alternativeIntermediateServiceModel',
        type=str,
        help='alternative intermediate service model (microservice generation '
            'will happen based on this model, while for domain concept '
            'generation the passed intermediate model will be used; path ' \
            'must be relative to model base path)')
    return parser.parse_args()

def run_generator_in_container(args):
    """Run the Java generator in a Docker container based on the present
    image.
    """
    subprocess.call('docker run -i ' + build_docker_run_arguments(args),
        shell=True)

def build_docker_run_arguments(args):
    """Build run arguments for the Docker container.

    These arguments will
        (i) mount the base path passed to the script as a volume with the same
            path in the container. Hence, we will not run into trouble when
            the source model URI in an intermediate model is an absolute file
            path.
        (ii) mount the target folder path to the /home/target path in the
             container.
        (iii) specify the container to run as the same user as the one who
              invoked the script. Otherwise the files written to the target
              folder will have the UID root.
        (iv) pass the source and intermediate model to the entrypoint of the
             container (i.e., to the Java Base Generator inside the container).
             The absolute paths of both models result from prefixing their paths
             passed to the script by the base path, which was mounted in (i) as
             a volume in the container.
        (v) pass the mounted target folder as /home/target to the generator.
        (vi) pass the code generation pattern to the generator.
        (vii) pass a possible alternative intermediate service model to the
              generator. Its path will be calculcated as for the other models in
              (iv).
    """

    smContainerPath = get_existing_path_from(args.basePath, args.sourceModel)
    imContainerPath = get_existing_path_from(args.basePath,
        args.intermediateModel)
    targetFolderPath = get_existing_path_from('', args.targetFolder, False)

    if args.alternativeIntermediateServiceModel:
        amContainerPath = get_existing_path_from(args.basePath,
            args.alternativeIntermediateServiceModel)
    else:
        amContainerPath = None

    dockerArgs = ('-v "%s":"%s" ' % (args.basePath, args.basePath)) + \
        ('-v "%s":/home/target ' % targetFolderPath) + \
        '-u $(id -u ${USER}):$(id -g ${USER}) ' + \
        ('%s ' % IMAGE_FULL_PATH) + \
        ('-s "%s" ' % smContainerPath) + \
        ('-i "%s" ' % imContainerPath) + \
        '-t /home/target ' + \
        'code_generation main ' + \
        ('--code_generation_serializer=%s' % args.pattern)

    if amContainerPath:
        dockerArgs += ' --alternative_intermediate_service_model="%s"' % \
            amContainerPath

    return dockerArgs

def get_existing_path_from(basePath, relPath, checkIsFile=True):
    """Helper to check if a relative path exists in a given base path. The
    function returns the absolute path if it exists. Otherwise, it exits the
    script.
    """

    path = pathlib.Path(os.path.join(basePath, relPath))
    if checkIsFile and path.is_file():
        return path
    elif not checkIsFile and path.is_dir():
        return path
    else:
        print('Path specification "%s" does not point to an existing file or ' \
            'folder. Exiting.' % path)
        sys.exit(1)

if __name__ == '__main__':
    # Make sure that the Docker image exists locally
    if not exists_docker_image():
        localBuildScript = './build_locally.sh'
        getDockerImage = input('Required docker image "%s" does not exist ' \
            'locally. Do you want to ' \
            '\n\t- build it locally via build script "%s" [b],' \
            '\n\t- pull it from the remote registry "%s" [p], or' \
            '\n\t- abort [a]? ' % \
                (IMAGE_NAME, localBuildScript, IMAGE_FULL_PATH)
            )
        if getDockerImage == 'b':
            build_image_locally(localBuildScript)
        elif getDockerImage == 'p':
            pull_image(IMAGE_FULL_PATH)
        else:
            print('Image retrieval aborted. Exiting.')
            sys.exit(0)

    # Run the generator inside the Docker container
    args = parse_commandline()
    run_generator_in_container(args)
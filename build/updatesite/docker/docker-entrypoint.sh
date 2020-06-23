#!/bin/bash

# Create Maven repository directory
mkdir -p /root/.m2

# Delegate to default entrypoint
exec /usr/local/bin/mvn-entrypoint.sh "$@"
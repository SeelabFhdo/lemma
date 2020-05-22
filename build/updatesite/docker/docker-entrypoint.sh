#!/bin/bash

mkdir -p /root/.m2
exec /usr/local/bin/mvn-entrypoint.sh "$@"
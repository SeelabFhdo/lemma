#!/usr/bin/env bash

SCRIPTPATH="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

docker build -t "lemma/check_releng_config_consistency" $SCRIPTPATH

LEMMA_MODULE_DIR=$(realpath "$SCRIPTPATH/../..")

docker run \
    -v "$LEMMA_MODULE_DIR":"$LEMMA_MODULE_DIR" \
    lemma/check_releng_config_consistency:latest "$LEMMA_MODULE_DIR"
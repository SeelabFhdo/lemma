# LEMMA Live Validation Server Docker Image
The `lemma/live_validation_server` Docker image bundles LEMMA's
[Live Validation server](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.live_validation/server)
in an executable form.

## Building the Image
You can build the image locally by running the `build.sh` script included in
this source code folder. The script requires the
[Live Validation server to have been built locally](https://github.com/SeelabFhdo/lemma/blob/main/de.fhdo.lemma.live_validation/server/README.md)
and its LEMMA version as first argument, e.g., `./build.sh 0.8.5-SNAPSHOT`.

## Executing the Image
You can execute the image by running `docker-compose up` from this source code
folder. This command will start the Live Validation server as part of your host
network with the default commandline values (cf. the
[README of the Live Validation server](https://github.com/SeelabFhdo/lemma/blob/main/de.fhdo.lemma.live_validation/server/README.md)).

To specify values for the Live Validation server's [commandline options](https://github.com/SeelabFhdo/lemma/blob/main/de.fhdo.lemma.live_validation/server/README.md),
use `docker-compose run server` to pass those values to the server. For example,
`docker-compose run server --port 51966` determines a port of the server
instance that differs from the
[default value](https://github.com/SeelabFhdo/lemma/blob/main/de.fhdo.lemma.live_validation/server/README.md).
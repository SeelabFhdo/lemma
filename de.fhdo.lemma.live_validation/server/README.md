# LEMMA Live Validation Server
LEMMA's Live Validation server enables to connect LEMMA model processors, which implement a
[Source Model Validation phase](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.model_processing/src/main/kotlin/de/fhdo/lemma/model_processing/builtin_phases/source_model_validation),
with a running instance of a LEMMA-enabled Eclipse IDE to receive and display source model validation issues leveraging
the [Language Server Protocol](https://microsoft.github.io/language-server-protocol).

A Live Validation server can be started by building the server component as a local, standalone executable JAR file
using Gradle (cf. the `../build.sh` or `../build.bat` script).

The standalone executable server JAR file ends up in the `server/build/libs` folder and has the `runnable` classifier.
It supports the following commandline options:
- `--debug`: Activate debug messages at server runtime.
- `-h, --hostname`: The server hostname. Defaults to `localhost`.
- `-p, --port`: The server port. Defaults to `44203`.
- `--quiet`: Do not print any messages at server runtime (will be overridden by `--debug`).
- `--timeout_threshold`: Threshold (in milliseconds) up to which validation clients must send a response. Defaults to
  `500`, i.e., 0.5 seconds.
- `--trace`: Trace messages exchanged between server and validation clients.
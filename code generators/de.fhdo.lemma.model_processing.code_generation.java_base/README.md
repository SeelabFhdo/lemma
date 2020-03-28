# Building this Module
This module requires Java 11 or greater for its build. To transparently increase your Java version any time you build this module, create a file called `set_java_home.sh` in this folder within your local copy of the [LEMMA](https://github.com/SeelabFhdo/lemma/) repository.

This file should export a value for the `JAVA_HOME` environment variable that points to the root folder of your Java 11 (or greater) installation. A valid `set_java_home.sh` file could look like this:

```bash
#!/usr/bin/env bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

The `build.sh` script of the module recognizes the existence of a potential `set_java_home.sh` file, and loads and runs it prior to the module build.

# Generating the models without the wizard

```
tools/reconstruct.sh --target <folder>
```

Reads the database MRF filled and writes the LEMMA models into the folder, the
way the reconstruction wizard does — same generators, same writer, same technology
models. No Eclipse has to be open and no dialog is answered.

```
Compiling the Xtend of the extractor and the reconstruction bundle...
  de.fhdo.lemma.servicedsl.extractor compiled
  de.fhdo.lemma.reconstruction compiled
Read from localhost:27017 - 4 context(s), 4 microservice(s), 11 operation node(s)
Copied 3 technology model(s) into technology/
Left out 4 node(s) that deploy no microservice: CustomerManagementFrontendContainer, …
Wrote 9 model(s):
  <target>/domain/CustomerCore.data
  …
  <target>/operation/architecture.operation
  <target>/service/CustomerCore.services
```

## Options

| Option | Default |
|---|---|
| `--target <folder>` | required |
| `--host <host>` | `localhost` |
| `--port <port>` | `27017` |
| `--technology-folder <name>` | `technology` |
| `--no-technology-models` | copies them |
| `--no-build` | compiles first |
| `--help` | |

`--no-build` reuses the last compile, which is worth having while trying options
out and wrong as soon as a source file has changed. The default is to compile,
because a stale build has cost this project more than a few seconds ever will.

## What it does, and why it has to

The entry point is
`de.fhdo.lemma.reconstruction.cli.HeadlessReconstruction`. It can also be started
from the IDE with **Run As → Java Application**, with this bundle as the working
directory and `--target` in the arguments; the script exists because outside the
IDE there is no classpath to run it with.

**The classpath comes from an Eclipse installation.** This repository has no
headless build: the bundles are OSGi plug-in projects that resolve their
dependencies from a target platform, and Tycho would have to download one. An
installation that already contains Xtext and Xtend has every jar needed, so the
script takes them from there. Set `LEMMA_ECLIPSE` to point at another one:

```
LEMMA_ECLIPSE=/path/to/Eclipse/Contents/Eclipse tools/reconstruct.sh --target out
```

Only the language, modelling and runtime bundles are taken, not every plugin of
the installation: unrelated ones register service providers that take over the
JVM's file system or logging and make the Xtend compiler fail before it starts.

**The working directory is this bundle.** Without an Eclipse there is no OSGi
bundle to read the technology models from, so `TechnologyTypes` and
`copyTechnologyModels` fall back to the working directory — which is also what
lets `ReconstructionRegressionTest` run. The script sets it; if you start the
entry point yourself, set it too, or no technology model is read or copied and
every import of a generated model dangles.

**Everything in the database is generated.** The wizard offers a selection; this
does not. Point `--host`/`--port` at the database you mean, and use MRF's
`--replace` if it should hold one system only.

## Differences from the wizard

| | Wizard | Script |
|---|---|---|
| Selection of contexts, services and nodes | per dialog | everything found |
| Target folder | directory chooser | `--target` |
| Database endpoint | dialog | `--host`, `--port` |
| Missing technology model | warning dialog | warning on stdout |
| Nodes left out of the operation model | results dialog | listed on stdout |

The models themselves are the same: both run `LemmaDomainGenerator`,
`LemmaServiceGenerator` and `LemmaOperationGenerator`, and write through
`ReconstructionModelWriter` including its extraction and masking.

## Build output

`.headless/` holds the compiled classes and a log per bundle; both are ignored by
git. A failure of either compiler stops the run with a non-zero status rather than
generating from whatever was compiled last — the Xtend compiler reports an error
and still exits zero, so what it produced is what gets checked.

## Noise you can ignore

```
WARNUNG: SLF4J not found on the classpath. Logging is disabled for the
         'org.mongodb.driver' component
```

The MongoDB driver looks for a logging implementation and finds none. Adding
`slf4j.api` without a provider only turns one line into three, so it is left out.

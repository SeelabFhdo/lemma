# Diagram common

What the LEMMA diagram bundles share.

| | |
|---|---|
| `PlantUmlRenderer` | runs PlantUML on a `.puml` and reports its absence |
| `tools/check-bundle-requires.py` | resolves a bundle's imports against its `Require-Bundle` |

Required by `de.fhdo.lemma.data.datadsl.diagram`,
`de.fhdo.lemma.servicedsl.diagram` and `de.fhdo.lemma.operationdsl.diagram`.

## Why this bundle exists

It did not, until there were three consumers. `PlantUmlRenderer` lived in the
data model diagram bundle, and the service diagram bundle required that bundle
for it alone — which made a diagram bundle a utility host for an unrelated one.
Two consumers did not justify a bundle of its own; three do.

## Rendering

```sh
brew install plantuml graphviz
```

PlantUML is run as a command rather than linked: the jar is some twelve
megabytes, third-party jars here are resolved by Maven rather than committed,
and a research repository is the wrong place for a binary that large. It is
looked for in `$PLANTUML`, then on the `PATH`, then in the usual Homebrew and
`/usr/local` locations — an Eclipse started from the Finder inherits a minimal
`PATH`, so the `PATH` alone would find nothing however well PlantUML is
installed.

Without it a diagram's `.puml` is still written, and the caller is given
`installationHint` to show.

## Checking a bundle's dependencies

```sh
python3 tools/check-bundle-requires.py ../de.fhdo.lemma.servicedsl.diagram
```

It resolves every package a bundle's sources import against the
`Export-Package` of the bundles its manifest requires, following
`visibility:=reexport` as Eclipse does, and fails on one that nothing exports.

This exists because the headless build cannot catch a missing `Require-Bundle`
entry: it compiles against a flat classpath of every jar of the Eclipse
installation, which ignores OSGi boundaries, so a bundle can compile headlessly
and still fail to resolve inside Eclipse. That is how `org.eclipse.core.runtime`
came to be missing from the first diagram bundle.

## A wart

This bundle is a module of `de.fhdo.lemma.data.datadsl.parent`, which is where
it was extracted from. It belongs to no language family, and the repository has
no root aggregator and no parent for bundles that belong to none — so the choice
was that, a parent of its own for a single bundle, or replicating the Xtend build
configuration in a standalone pom as `de.fhdo.lemma.utils` does. The parentage is
wrong and the build is right; a root aggregator would fix it properly.

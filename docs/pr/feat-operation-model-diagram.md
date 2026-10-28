## Summary

The third and last diagram family: operation models. Every model kind the
reconstruction produces now has a picture. Plus a shared bundle, because the
renderer now has three consumers.

```text
de.fhdo.lemma.diagram.common/            # new: PlantUmlRenderer and the
│                                        # OSGi dependency check
├── required by de.fhdo.lemma.data.datadsl.diagram
├── required by de.fhdo.lemma.servicedsl.diagram      (its dependency on the
│                                                      data bundle goes away)
└── required by de.fhdo.lemma.operationdsl.diagram    # new
    ├── OperationModelReader.xtend       # follows "import nodes", resolves and
    │                                    # de-duplicates relations
    ├── OperationGraph.xtend             # nodes, artifacts, edges, configuration
    ├── TopologyDiagramGenerator.xtend   # what is deployed where
    ├── NodeDetailDiagramGenerator.xtend # how each node is configured
    └── GenerateOperationDiagramHandler.xtend
```

Select `.operation` files, **Generate PlantUML diagrams**:

```text
── topology ───────────────────────────  ── nodes ──────────────────────────────
node "CommandSideContainer" <<Docker>> { class "Broker" <<Kafka, infrastructure>> {
    artifact "…CommandSide"                  brokerId = 1
}                                            listeners = "PLAINTEXT_HOST://0.0.0.0:9092"
node "Broker" <<Kafka>>                      … 13 more
node "MongoDB" <<MongoDB>>                   ..
                                             hostname("broker")
CommandSideContainer --> Broker              port(9092)
CommandSideContainer --> MongoDB         }
```

A container is a node, what it deploys are artifacts inside it, an
infrastructure node is a node beside it — a UML deployment diagram, which is
what an operation model describes. Every node is a `node` stereotyped with the
technology the model names, rather than one of PlantUML's semantic shapes:
mapping `MongoDB` onto a database is a guess from a name that an unknown
technology silently loses.

## Evidence

**Relations are de-duplicated, which the models force.** The same relation is
stated from both ends, in different files:

```text
Infrastructure.operation  APIGateway used by nodes CommandSideNodes::CommandSideContainer
command-side.operation    CommandSideContainer depends on nodes Infrastructure::APIGateway
```

```diff
-25 edges   both forms drawn as written
+19 edges   one per relation, for charging-station-management
```

Neither direction can be dropped instead — measured: `Broker used by nodes
CommandSideContainer` has **no** mirror in the container's own model.

`used by services` names a microservice rather than a node, and resolves through
the container that deploys it. **No model of this repository uses it**, so it is
exercised by a fixture rather than left to chance — the gap that let
`required interfaces` sit untested in the service bundle until a mutation proved
the check could not fail.

**Simpler than the service diagrams in one way:** an operation node carries no
version and its name is a single identifier, so none of the
`qualifiedNameParts`, abbreviation or longest-prefix handling is needed.

**An alias never carries the model's path**, although the reader identifies a
node that way internally. The path is absolute and machine-specific, and a
generated diagram has to be the same on every machine to be diffable and
reproducible. A name two models share is disambiguated with the model's file
name, and the sweep asserts no alias holds a path separator.

**One defect found by rendering, and the check that missed it matters more than
the fix.** The stub declarations for unresolved relations were emitted *after*
the arrows:

```diff
-n_MissingTarget ..> n_NotThere
-node "NotThere" as n_NotThere <<unresolved>>     # redefinition: rejected
+node "NotThere" as n_NotThere <<unresolved>>
+n_MissingTarget ..> n_NotThere
```

An arrow to an undeclared alias makes PlantUML create the shape there and then,
so declaring it afterwards is a redefinition and the whole diagram is rejected.
**The sweep did not notice**, because it asked whether the output was valid SVG
and PlantUML answers a rejected diagram with a *picture of the error*, which is.

```text
before:  Error line 20 in file: 0-app-topology.puml      "40 of 40 rendered" ✓
after:   plantuml errors 0 | svgs with a syntax error 0  40 of 40 rendered
```

The sweep now reads PlantUML's own verdict, the test asserts the ordering
without needing PlantUML at all, and **the two merged bundles' 232 diagrams were
re-checked under the stronger test — all clean.** Those earlier claims hold;
only the check was weak.

**Checks.** 60 for this bundle, 96 for the service bundle unbroken by the
extraction, no database and no Eclipse for either:

```text
operation:  60 check(s), 0 failed
service:    96 check(s), 0 failed
OSGi dependency check: OK on all four bundles
```

Every decision is defended by a mutation that turns it red:

| Decision | Reversed to | Red |
|---|---|---|
| one edge per relation | add every statement | 6 |
| `used by` is kept | honour `depends on` only | 7 |
| `used by` is inverted | left as written | 7 |
| `used by services` resolves via the container | drawn to the node alone | 3 |
| a shape is declared before its first arrow | stubs after the arrows | 2 |

**Sweep over every operation model:**

```text
20 models | 129 nodes | 64 artifacts | 165 edges | 159 resolved
undeclared arrow ends 0 | duplicate edges 0 | blank 0
machine-specific aliases 0 | failed 0
40 diagrams rendered | 0 rejected by PlantUML
```

The six unresolved edges are the deliberately unresolvable ones in
`test/fixtures`. **Confirmed in Eclipse**: the diagrams render and read
reasonably from the context menu.

## Merge Danger

**Door:** two-way for the new bundle. The extraction is a **move**, so it
touches two bundles already on `dev`.

**Blast Radius:** the two existing diagram bundles, and the Project Explorer
context menu

`PlantUmlRenderer` moves from `de.fhdo.lemma.data.datadsl.diagram` to
`de.fhdo.lemma.diagram.common`. Anything outside this repository importing it
from its old package breaks; nothing in this repository does, and both callers
are updated here. The service bundle's `Require-Bundle` entry for the data
bundle is removed, because the renderer was all it ever used from it — so the
data bundle stops being a dependency of the service bundle entirely.

`de.fhdo.lemma.diagram.common` is a module of
`de.fhdo.lemma.data.datadsl.parent`, which is **the wrong parent** — it belongs
to no language family. The repository has no root aggregator and no parent for
bundles that belong to none, so the alternatives were a parent for a single
bundle or replicating the Xtend build configuration in a standalone pom as
`de.fhdo.lemma.utils` does. Its README says so. A root aggregator would fix it
properly.

The new menu entry is contributed at `popup:org.eclipse.ui.popup.any` and
guarded by `<visibleWhen>` on a selection that is entirely `.operation` files,
so it cannot appear beside the other two diagram commands. The command writes
beside the model and overwrites a `-topology` or `-nodes` file of its own making
without asking; the diagrams are written beside the **first** selected model, so
selecting across folders puts them in the first one's folder.

None of the four bundles has been built by Tycho; the headless compile and the
Eclipse workspace build are what they have been through.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

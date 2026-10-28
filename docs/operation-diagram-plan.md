# Operation model diagrams

Plan for two visualisations of a LEMMA operation model: the deployment topology,
and the configuration of each node. Decided with Philip Wizenty on 2026-10-09;
the four choices his answers settled are marked **[decided]**.

The third diagram family, after `de.fhdo.lemma.data.datadsl.diagram` and
`de.fhdo.lemma.servicedsl.diagram`. It completes the set: every model kind the
reconstruction produces would then have a picture.

## 1. What is being drawn

An operation model declares two kinds of node and four kinds of relation
between them:

```
container CommandSideContainer                     ← Container
    deployment technology DeploymentBase::_deployment.Docker
    deploys CommandSideServices::de.puls.ChargingStationManagementCommandSide
    depends on nodes Infrastructure::APIGateway, …

Broker is Kafka::_infrastructure.Kafka             ← InfrastructureNode
    depends on nodes BrokerCoordinator
    used by nodes CommandSideNodes::CommandSideContainer, …
```

and per node: aspects with values, `default values`, endpoints, an operation
environment, and a `ServiceDeploymentSpecification` per deployed service.

The corpus, measured:

| | |
|---|---|
| operation models | 18 |
| containers | 15 |
| `depends on nodes` | 24 |
| `used by nodes` | 9 |
| `used by services` | **0** — see §5 |
| `import nodes from` | 34 |

## 2. Decisions

**A topology diagram and a detail diagram** **[decided]**. The same split as the
service diagrams, for the same reason: the Kafka broker in
`examples/charging-station-management` carries fifteen `default values` and three
aspects, so one diagram holding everything is dominated by whichever node is
configured most.

**One arrow per fact, de-duplicated** **[decided]**. See §3 — this is the
decision the models force.

**A deployed microservice is nested in its container as an artifact**
**[decided]**, which is what makes this a UML deployment diagram rather than a
node graph.

**A uniform `node`, stereotyped with the technology the model names**
**[decided]**. Not PlantUML's semantic shapes (`database`, `queue`): mapping
`MongoDB` onto a database is a name-based guess that an unknown technology
silently loses. The stereotype says what the model says.

**Scope follows `import nodes` transitively**, like the dependency diagrams and
for the same reason — a node relation crosses model files, 34 times in this
corpus. Not put to a decision because the alternative does not work: the
topology of `charging-station-management` is split across three files.

## 3. The decision the models force

`depends on nodes` and `used by nodes` are two directions of one relation, and
the corpus states the same fact from both ends in different files:

```
Infrastructure.operation   APIGateway  used by nodes  CommandSideNodes::CommandSideContainer
command-side.operation     CommandSideContainer  depends on nodes  Infrastructure::APIGateway
```

Drawing both forms as drawn would give **seven arrows for four facts** between
`CommandSideContainer` and its neighbours. So both are normalised to one
direction and each pair drawn once.

Neither direction can simply be dropped, which is the measured part:
`Broker used by nodes CommandSideContainer` has **no** mirror in the container's
own model. A reader that honoured only `depends on` would lose it.

De-duplication needs node identity across files: the node written
`Infrastructure::APIGateway` has to be recognised as the node named `APIGateway`
declared in `Infrastructure.operation`. That is the alias-and-name resolution the
service reader already does — and simpler here, because an operation node has no
`version`, so its qualified name is its own single identifier. No
`qualifiedNameParts`, no abbreviation, no longest-prefix match.

## 4. The constraint, unchanged

**Cross-model references do not resolve outside a running Xtext.** Measured on
`ChargingStationManagementCommandSide.operation`:

```
deployment technology: PROXY   written=DeploymentBase::_deployment.Docker
deploys:               PROXY   written=CommandSideServices::de.puls.ChargingStationManagementCommandSide
depends on:            PROXY   written=Infrastructure::APIGateway
default value:         property=PROXY  written=clientPort = 2181
```

| Available natively | Only as parse-tree text |
|---|---|
| import alias, type, URI | the deployment and infrastructure technology |
| container and node name | `deploys`, `depends on nodes`, `used by nodes` |
| endpoint addresses | aspects and their values |
| operation environment | `default values` |

The written form is directly usable: `clientPort = 2181` is what the detail
diagram wants to print, and `CommandSideServices::de.puls.Charging…CommandSide`
yields the artifact name without loading the service model at all. This bundle
therefore needs no dependency on `de.fhdo.lemma.servicedsl.diagram`.

What it gives up by not loading it: a `deploys` naming a microservice no service
model declares is drawn as written rather than reported as unresolvable. Worth
adding later by reusing `ServiceModelReader`; not worth the coupling now.

## 5. Two hazards, both measured

**A multi-line aspect value.** `Infrastructure.operation` carries

```
DockerCompose::_aspects.command('
    - bash
    - -c
    - |
    lenses-cli provision --wait-for-lenses \
    …
');
```

Its parse-tree text is an embedded shell script. Printed as read it would wreck
the diagram, so an aspect value has its whitespace collapsed and is truncated,
with the truncation visible.

**`used by services` appears nowhere in the corpus.** Zero occurrences in 18
models. That is the shape of the gap that let `required interfaces` go
unexercised in the service bundle until a mutation proved the check could not
fail — so this one gets a fixture of its own from the start, not after.

## 6. Structure

A new bundle `de.fhdo.lemma.operationdsl.diagram`, laid out as the other two:
pure generators, a thin Eclipse shell, output checkable headlessly.

```
de.fhdo.lemma.operationdsl.diagram/
├── src/de/fhdo/lemma/operationdsl/diagram/
│   ├── OperationModelReader.xtend        # loads, follows node imports,
│   │                                     # resolves and de-duplicates relations
│   ├── OperationGraph.xtend              # nodes, artifacts, edges, configuration
│   ├── TopologyDiagramGenerator.xtend    # OperationGraph -> PlantUML
│   ├── NodeDetailDiagramGenerator.xtend  # the configuration per node
│   └── GenerateOperationDiagramHandler.xtend
└── README.md
```

## 7. Steps

1. **Extract `de.fhdo.lemma.diagram.common`** — `PlantUmlRenderer` and
   `tools/check-bundle-requires.py`, with the two existing diagram bundles
   repointed at it. This is the trigger condition named in the data bundle's
   README and in `../microservice-reconstruction-framework/docs/backlog.md` D4:
   two consumers did not justify a bundle, a third does. Doing it first keeps
   the new bundle from deepening a dependency that is about to move.
2. **`OperationModelReader` and `OperationGraph`** — read both node kinds, follow
   `import nodes` transitively with a visited set, resolve every node reference,
   and normalise `depends on`/`used by` into one de-duplicated set of edges.
   Fixtures: the both-ends duplication of §3, a `used by` with no mirror, a
   `used by services` (§5), a cyclic node import — which is **real** here, as
   `Infrastructure` and `command-side` import each other.
3. **`TopologyDiagramGenerator`** — nodes stereotyped with their technology,
   deployed services nested as artifacts, one arrow per relation.
4. **`NodeDetailDiagramGenerator`** — per node: technology, operation
   environment, `default values`, aspects, endpoints, and the per-service
   deployment specifications.
5. **The Eclipse shell and the sweep** — one context-menu command on a
   `.operation` selection. The sweep over all 18 models asserts what the other
   two sweeps learned to assert, plus the one this diagram needs: **no duplicate
   edge** between a pair of nodes, and every declared relation drawn exactly
   once.

## 8. Deliberately not in this plan

- Resolving `deploys` into the service models, per §4.
- Operation **environments** as a grouping — drawing containers of one
  environment together. The corpus sets `operationEnvironment` rarely enough
  that it would be untestable.
- Anything the security smell will add (`tlsEnabled`, mesh facts): those are not
  in the operation models yet. See backlog **A**.
- Linking a container's artifact to its interface diagram, which would mean one
  picture spanning two model kinds.

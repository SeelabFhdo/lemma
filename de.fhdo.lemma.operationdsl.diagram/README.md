# Operation model diagrams

Draws LEMMA operation models. Select one or more `.operation` files in the
Project Explorer, **Generate PlantUML diagrams** from the context menu, and you
get the deployment topology and the configuration of every node, as `.puml` and
`.svg`. The first image is opened, so the command ends in a diagram rather than
in a file.

```
select Infrastructure.operation

  Infrastructure-topology.puml / .svg      what is deployed where
  Infrastructure-nodes.puml    / .svg      how each node is configured
```

Both cover everything reachable through `import nodes`, not only what was
selected: a node relation crosses model files — 34 times in this repository —
and the topology of `examples/charging-station-management` is split across
three. The files are written beside the **first** selected model, because
neither diagram belongs to a single one of them.

Rendering reuses `PlantUmlRenderer` from `de.fhdo.lemma.diagram.common`.

## The topology

```
node "CommandSideContainer" as n_CommandSideContainer <<Docker>> {
    artifact "ChargingStationManagementCommandSide" as n_CommandSideContainer__…
}
node "Broker" as n_Broker <<Kafka>>
node "MongoDB" as n_MongoDB <<MongoDB>>

n_CommandSideContainer --> n_Broker
n_CommandSideContainer --> n_MongoDB
```

A container is a node, the microservices it deploys are artifacts inside it, an
infrastructure node is a node beside it, and a relation is an arrow. That is a
UML deployment diagram, which is what an operation model describes.

Every node is a `node` stereotyped with the technology the model names, rather
than one of PlantUML's semantic shapes. Mapping `MongoDB` onto a database and
`Kafka` onto a queue is a guess from a name: an unknown technology would
silently lose its shape and a renamed one would lose it without saying so.

## The node configuration

```
class "Broker" as n_Broker <<Kafka, infrastructure>> {
    brokerId = 1
    listeners = "PLAINTEXT_HOST://0.0.0.0:9092"
    … 13 more
    ..
    hostname("broker")
    port(9092)
}
```

Separate from the topology because the Kafka broker of
`examples/charging-station-management` carries fifteen `default values` and
three aspects, and one diagram holding both is dominated by whichever node is
configured most.

Drawn with class shapes rather than deployment nodes: a PlantUML `node` nests
elements, not lines of text, and this diagram is lines of text. `hide circle`
takes the class marker away again.

An aspect is shown by name and values — `hostname("broker")`, not
`DockerCompose::_aspects.hostname("broker");` — because the alias and the path
are the same on every line and say nothing about the node. A value longer than a
line is cut visibly: the `command` aspect of
`examples/charging-station-management` holds an embedded shell script.

## How a relation is resolved

`depends on nodes` and `used by nodes` are two directions of one relation, and
the models state the same one from both ends in different files:

```
Infrastructure.operation  APIGateway used by nodes CommandSideNodes::CommandSideContainer
command-side.operation    CommandSideContainer depends on nodes Infrastructure::APIGateway
```

Both are normalised to one direction and each pair drawn once — **19 edges
rather than 25** for that system. Neither direction can be dropped instead:
`Broker used by nodes CommandSideContainer` has no mirror in the container's own
model, so honouring only `depends on` would lose the relation entirely.

`used by services` names a microservice rather than a node. The service is an
artifact of some container, so that container is the other end of the relation.
**No model of this repository uses it**, so it is exercised by a fixture rather
than left to chance.

An operation node carries no version and its name is a single identifier, so
there is no qualified name to take apart — none of the version, abbreviation or
longest-prefix handling the service diagram bundle needs. The name is still
matched against the nodes that were read rather than assumed to exist.

## Why the parse tree is read

A cross-reference of an operation model does not resolve outside a running
Xtext. Measured:

```
deployment technology: PROXY   written=DeploymentBase::_deployment.Docker
deploys:               PROXY   written=CommandSideServices::de.puls.…CommandSide
depends on:            PROXY   written=Infrastructure::APIGateway
default value:         property=PROXY  written=clientPort = 2181
```

Local features come from EMF and cross-references from the parse tree. The
written form is directly usable — `clientPort = 2181` is what the detail diagram
prints — and a `deploys` reference holds the microservice's name, so **no
service model is loaded**: this bundle needs no dependency on
`de.fhdo.lemma.servicedsl.diagram`.

What that gives up: a `deploys` naming a microservice no service model declares
is drawn as written rather than reported as unresolvable.

An alias never contains the path of the model that declared it, although the
reader identifies a node that way internally. The path is absolute and
machine-specific, and a generated diagram has to be the same on every machine to
be diffable and reproducible. A name two models share is disambiguated with the
model's file name instead.

## Checking it

```sh
# in this bundle, "Run As -> Java Application" on OperationGraphTest, or:
java de.fhdo.lemma.operationdsl.diagram.test.OperationGraphTest

python3 ../de.fhdo.lemma.diagram.common/tools/check-bundle-requires.py .
```

60 checks, no database and no running Eclipse. A sweep over every operation
model of the repository backs them up:

```
20 models | 129 nodes | 64 artifacts | 165 edges | 159 resolved
undeclared arrow ends 0 | duplicate edges 0 | blank 0
machine-specific aliases 0 | failed 0
40 diagrams rendered, 0 rejected by PlantUML
```

Every decision is defended by a mutation that turns it red:

| Decision | Reversed to | Checks that go red |
|---|---|---|
| one edge per relation | add every statement | 6 |
| `used by` is kept | honour `depends on` only | 7 |
| `used by` is inverted | left as written | 7 |
| `used by services` resolves via the container | drawn to the node alone | 3 |
| a shape is declared before its first arrow | stubs after the arrows | 2 |

That last one is why this list exists. PlantUML answers a rejected diagram with
a **picture of the error**, which is still a valid SVG — so the sweep's original
check, that every file is valid SVG, passed while two diagrams were broken. The
sweep now reads PlantUML's own verdict, and the test asserts the ordering
without needing PlantUML at all.

## What only Eclipse can confirm

Whether the menu entry appears on a `.operation` selection and whether the
handler resolves in a running workbench is what an Eclipse build shows and a
headless one cannot. The pipeline behind it was exercised headlessly with the
real reader, the real generators and the real renderer, and produced the two
diagrams and two images with no problems reported.

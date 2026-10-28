# Service model diagrams

Draws LEMMA service models. Select one or more `.services` files in the Project
Explorer, **Generate PlantUML diagrams** from the context menu, and you get the
interfaces of each selected model plus the dependencies of the whole selection,
as `.puml` and `.svg` beside the models. The first image is opened, so the
command ends in a diagram rather than in a file.

```
select CustomerSelfService.services, CustomerManagement.services, PolicyManagement.services

  CustomerSelfService-interfaces.puml / .svg        one per selected model
  CustomerManagement-interfaces.puml / .svg
  PolicyManagement-interfaces.puml  / .svg
  CustomerSelfService-dependencies.puml / .svg        once, for the selection
  CustomerSelfService-dependencies-detail.puml / .svg
```

The dependency diagrams are written beside the **first** selected model, because
they belong to no single one of them.

Rendering needs PlantUML, and reuses `PlantUmlRenderer` from
`de.fhdo.lemma.data.datadsl.diagram`, which this bundle requires. Without
PlantUML the `.puml` files are still written and the dialog says what to install:

```sh
brew install plantuml graphviz
```

## What it does

```
ServiceModelReader.read(Paths.get("CustomerSelfService.services"))
  │
  ├─ loads the model, follows "import microservices" transitively
  ├─ reads what resolves from EMF, the rest from the parse tree
  └─ resolves every "required" entry onto the microservice it names
         │
         └─> ServiceGraph
               services      [CustomerSelfService, CustomerCore]
               dependencies  CustomerSelfService -> CustomerCore (MICROSERVICE)
               problems      []
```

`ServiceGraph` exists so that no generator parses anything. Resolving a
dependency across model files is the hard part of drawing a service model; it
happens once, it is testable on its own, and a further diagram needs no further
reading.

## The interface diagram

```
package "CustomerCore" {
    interface "CustomerInformationHolder" as com_…_CustomerCore_CustomerInformationHolder <<rest>> {
        /customers
        ..
        GET getCustomers(filter : string, limit : int) : PaginatedCustomerResponseDto
        GET /{ids} getCustomer(ids : string) : CustomersResponseDto
        PUT /{customerId} updateCustomer(customerId : CustomerId, …) : CustomerResponseDto
        POST createCustomer(requestDto : CustomerProfileUpdateRequestDto) : CustomerResponseDto
    }
}
```

An interface is an interface, an operation a method, its incoming parameters the
method's parameters and its outgoing one the result. What makes it a REST
interface rather than an abstract one is the verb and the path, so those are on
every operation that has them.

| In the model | In the diagram |
|---|---|
| `microservice` | a package, labelled with its simple name |
| `interface` | an interface, stereotyped with the protocol of its endpoints |
| `@endpoints(…rest:"/customers";)` | the path, on the interface or the operation |
| `@…_aspects.GetMapping` | `GET` in front of the operation |
| `sync in` parameter | a parameter of the method |
| `sync out` parameter | the result; several become a named tuple |
| `fault` parameter | `{fault T}`, never the result |
| `async` parameter | `{async}` |
| `?` | `name? : T` |
| `noimpl` | `<<noimpl>>` |
| a microservice that is not `public functional` | `<<internal, utility>>` on the package |

Three things it deliberately does not do:

- **`RequestMapping` gets no verb.** It carries the verb in a property rather
  than in its name, so claiming `GET` would state something the model does not.
- **It draws the model that was opened, not the models it imports.** The reader
  follows imports because the dependency diagram needs them, so the graph of
  `CustomerSelfService` holds `CustomerCore` too. A reader who opens one service
  model is asking what *that* service offers; drawing everything reachable made
  this diagram two packages at four times as wide as high.
- **A parameter's type is shown by its simple name.** In a service model every
  complex type is imported, so the alias and the context would be on every
  parameter and say nothing about the interface.

`skinparam wrapWidth 500` is emitted because PlantUML does not wrap a class
member by itself, and an operation with several parameters, several results and a
fault runs past 240 characters. The widest reconstructed interface came out
4786x1010 without it and 2638x1504 with it. A model that declares several
microservices in one file is still wide — `examples/parking-spaces` draws five
packages side by side at 2745x188 — because that is what the model holds.

## The dependency diagrams

Two, because the levels LEMMA offers answer two questions, and they are
alternatives rather than layers: Lakeside Mutual declares `required operations`
for `CustomerManagement` and `required microservices` for the others.

**The overview** aggregates every dependency to one arrow and answers who calls
whom, labelled with what backs it where the model is more specific than the
arrow:

```
[CustomerSelfService] --> [CustomerCore]
[CustomerManagement]  --> [CustomerCore] : 3 ops
[PolicyManagement]    --> [CustomerCore]
```

**The detail diagram** answers through what, drawing each required interface or
operation inside the package of the service that offers it:

```
[CustomerSelfService] --> [CustomerCore]
package "CustomerCore" {
    [CustomerCore]
    [CustomerInformationHolder.getCustomer]
    [CustomerInformationHolder.getCustomers]
    [CustomerInformationHolder.updateCustomer]
}
[CustomerManagement] --> [CustomerInformationHolder.getCustomer]
```

A whole-service dependency is drawn here too, rather than left out: a reader
would otherwise take `CustomerSelfService` to require nothing. A service nothing
is required *of* by name is a plain component, not a package holding one
component of its own name.

Unlike the interface diagram, both draw everything the reader reached. A
dependency crosses model files, so a diagram of one file could never show the
system.

A dependency that cannot be followed is drawn dashed, marked `<<unresolved>>`,
labelled with the whole name the model wrote, and the detail diagram carries the
reason as a note. The whole name and not its last part: where the microservice
name ends is exactly what could not be worked out, and `find` would read as an
operation.

## How a required name is resolved

```
CustomerCore :: com.lakesidemutual.customercore.CustomerCore . CustomerInformationHolder . getCustomer
└─ alias ──┘    └──────────── microservice ───────────────┘   └──── interface ───────┘   └── op ──┘
```

Everything is matched against what was read, never counted off by position.
Three things the models forced:

- **A version prefixes the name.** `microservice de.fhdo.APIGateways version v01`
  is referred to as `v01.de.fhdo.APIGateways`. The rule is the metamodel's own
  `qualifiedNameParts`, not something a reader can assemble from the name.
  Counting name parts instead made every dependency of the three versioned
  `e-vehicle-charging` models unresolvable.
- **A reference may abbreviate.** Inside one model
  `required microservices { DiscoveryService }` names
  `v01.de.fhdo.DiscoveryService`. Every dot-boundary suffix of a qualified name
  is a form it may be named by, and the longest matching form wins.
- **An ambiguous abbreviation resolves to neither.** Two microservices whose
  names end the same way, named by that ending, name neither: a guess drawn as
  an arrow is worse than an arrow drawn as unresolved.

Resolution across the repository went from 24 of 44 dependencies to 45 of 49 as
these came out. The four that remain are the deliberately unresolvable ones in
`test/fixtures`.

## Why the parse tree is read

A cross-reference of a service model does not resolve outside a running Xtext.
Measured on the four Lakeside Mutual models, loaded into one `XtextResourceSet`
with `ServicePackage`, `DataPackage` and `TechnologyPackage` registered:

```
required microservice -> MicroserviceImpl  proxy=true  name=null
```

Linking across models needs the index that only a running Xtext provides. The
node model is the parse tree of the file, so what the model wrote is still there
— and what it wrote is enough, because it wrote the qualified name.

| Read from EMF | Read from the parse tree |
|---|---|
| import alias, type, URI | the `required` entries |
| microservice name, visibility, type | service aspects, and so the HTTP verb |
| interface name, `noimpl` | a parameter's imported type |
| endpoint addresses | |
| operation name | |
| parameter name, `sync`/`async`, `in`/`out` | |
| a parameter's primitive type | |

The alias is looked up in the imports **of the model it was written in**, and
matching rather than splitting is what detects a name nothing declares:
splitting `com.example.orders.Nonexistent.Queries.find` from the end yields the
plausible triple (`Nonexistent`, `Queries`, `find`) and reports a dependency on
a microservice that does not exist.

## Checking it

```sh
# in this bundle, "Run As -> Java Application" on ServiceGraphTest, or:
java de.fhdo.lemma.servicedsl.diagram.test.ServiceGraphTest

python3 ../de.fhdo.lemma.diagram.common/tools/check-bundle-requires.py .
```

`ServiceGraphTest` needs no database and no running Eclipse, which is the point
of keeping the reader and the generator free of both. 90 checks over the fixtures
in `test/` and the reconstructed Lakeside Mutual models.

Sweeps over every service model of the repository back them up:

```
interface diagrams   33 models | 100 interfaces | 234 operations
                     nothing silently empty | no alias collisions
dependency diagrams  33 models | 49 dependencies | 45 resolved
                     every arrow end declared | every dependency drawn
                     nothing blank | 66 diagrams, all valid SVG
```

**Every decision it defends was mutation-tested** — a check that cannot fail
proves nothing, and two of these did not fail until the fixture was rewritten to
isolate them:

| Decision | Reversed to | Checks that go red |
|---|---|---|
| the match ends on a dot | `startsWith(name)` | 2 |
| the longest match wins | the first match wins | 4 |
| match what was read | split from the end of the name | 1 |
| a visited set when following imports | follow unconditionally | 1 |
| an interface alias is scoped to its service | the interface name alone | 2 |
| `RequestMapping` claims no verb | mapped to `GET` | 1 |
| a fault is not the result | counted as outgoing | 1 |
| every outgoing value is shown | only the first | 1 |
| an outgoing parameter is not a call parameter | listed as one | 7 |
| a version prefixes the qualified name | the name as written | 5 |
| an abbreviated reference resolves | only the full name matches | 2 |
| an ambiguous abbreviation resolves to neither | to the first candidate | 2 |
| an interface is matched by name | the first interface | 3 |
| every arrow end is declared | only coarse targets | 2 |
| an aggregated edge says what backs it | no label | 2 |
| the interface count is kept | dropped | 1 |
| the detail diagram keeps coarse dependencies | drops them | 2 |
| only named requirements make a package | every target does | 2 |
| an unresolved arrow is dashed | drawn solid | 1 |
| a stub keeps the whole written name | its last part | 2 |

Two of these were added because a mutation went **uncaught**: no model of this
repository uses `required interfaces`, so the whole interface level of the
resolution was unexercised until a fixture declared one, and the check that
every arrow end is declared was only ever applied to a system where the bug
could not show.

`tools/check-bundle-requires.py` resolves every imported package against the
bundles the manifest requires. It is here because a headless compile cannot see a
missing `Require-Bundle` entry: it uses a flat classpath of every jar of the
Eclipse installation, which ignores OSGi boundaries.

## What only Eclipse can confirm

`ServiceGraphTest` and the sweeps cover the reader and both generators, which is
everything that decides what a diagram contains. They cannot cover the context
menu: whether the entry appears on a `.services` selection, and whether the
handler resolves inside a running workbench, is what an Eclipse build shows and
a headless one cannot. The pipeline the handler runs - the same reads, the same
generators, the same file names, the same renderer - was exercised headlessly
and produced the five diagrams above with no problems reported.

`PlantUmlRenderer` and `tools/check-bundle-requires.py` come from
`de.fhdo.lemma.diagram.common`, which this bundle requires. They moved there when
the operation model diagrams became their third consumer, which is the trigger
condition this file used to name.

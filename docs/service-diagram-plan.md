# Service model diagrams

Plan for two visualisations of a LEMMA service model: one of the interfaces a
microservice offers, one of the dependencies between microservices. Decided with
Philip Wizenty on 2026-10-06; the four choices his answers settled are marked
**[decided]**.

## 1. What is being drawn

A `.services` model holds a microservice, its interfaces, their operations and
each operation's parameters, with endpoints and technology aspects attached at
every level. The reconstruction already fills all of it - see
`de.fhdo.lemma.reconstruction/test/expected/lakeside-mutual/service`.

Two diagrams, because the two questions a reader brings are different:

| Diagram | Answers |
|---|---|
| Interface diagram | What does this service offer, and how do I call it? |
| Dependency diagram | Who calls whom, and through which operations? |

## 2. Decisions

**Interfaces are drawn as a UML class diagram** **[decided]**. An interface is a
class, an operation is a method with its parameters and result. This matches
`de.fhdo.lemma.data.datadsl.diagram`, so the two diagram families read alike and
an operation's parameter type can name the data structure it refers to.

**A dependency diagram follows imports from the selection** **[decided]**.
Dependencies cross model files, so a per-file diagram could never show the
system. Selecting one `.services` file pulls in every model it imports,
transitively, and draws the reachable system.

**Both an overview and a detail diagram** **[decided]**. Lakeside Mutual mixes
granularities - `CustomerManagement` declares `required operations`,
`PolicyManagement` declares `required microservices`, because LEMMA treats the
three `required` forms as alternatives rather than layers. The overview
aggregates every dependency to one service-to-service arrow labelled with how
many operations back it; the detail diagram draws operation-level arrows where
the model declares them.

**Annotated with the HTTP verb and the endpoint path, and nothing else**
**[decided]**. Transport security on the edges, `PreAuthorize` on operations and
the parameter aspects were all considered and declined: the security smell is
deliberately later work, and the parameter aspects are the detail most likely to
crowd the picture. Section 7 keeps them as the obvious extension.

## 3. The constraint that shapes the implementation

**Cross-model references do not resolve outside a running Xtext.** Measured, not
assumed: loading all four Lakeside Mutual service models into one
`XtextResourceSet` with `ServicePackage`, `DataPackage` and `TechnologyPackage`
registered still gives

```
required microservice -> MicroserviceImpl  proxy=true  name=null
```

This is the same wall the data diagram hit on imported types, and linking across
models needs the index that only a running Xtext provides.

What resolves and what does not is therefore the first thing the design has to
respect:

| Available natively | Only as parse-tree text |
|---|---|
| import alias, type, URI | `required` entries |
| microservice name, visibility, type | service aspects (so: the HTTP verb) |
| interface name, `noimpl` | a parameter's imported type |
| endpoint addresses | |
| operation name | |
| parameter name, `sync`/`async`, `in`/`out` | |
| a parameter's primitive type | |

The parse tree holds exactly what the model wrote:

```
@javaWithSpring::_aspects.GetMapping
CustomerCore::com.lakesidemutual.customercore.CustomerCore.CustomerInformationHolder.getCustomer
CustomerManagement::CustomerManagement.NotificationDtoList
```

So: read local features from EMF, read cross-references from the node model via
`NodeModelUtils` - the pattern already proven in the data diagram. The generator
resolves dependencies itself, by matching an alias against the imports and the
qualified name against the microservices of the imported file.

## 4. Resolving a required name

A microservice name is itself qualified, so a required operation reads

```
CustomerCore :: com.lakesidemutual.customercore.CustomerCore . CustomerInformationHolder . getCustomer
└─ alias ──┘    └──────────── microservice ───────────────┘   └──── interface ───────┘   └── op ──┘
```

The name is matched as the **longest prefix** against the microservice names
actually found in the imported file, the match ending on a dot, and only the
remainder read as interface and operation.

**A correction to an earlier draft of this plan.** It claimed that splitting the
name positionally is wrong "because the number of dots in a microservice name is
not fixed". That is not true of splitting from the *end*: given the level, the
interface and operation are the last one or two segments, so dropping them yields
the microservice name deterministically. The argument only holds against
splitting from the front, which nobody would write.

The real reason to match against what was read is that it **detects a name
nothing declares**. Splitting from the end of
`com.example.orders.Nonexistent.Queries.find` yields the plausible triple
(`Nonexistent`, `Queries`, `find`) and reports a dependency on a microservice
that does not exist. Matching cannot: there is nothing to match. Measured by
mutating the reader to do exactly that, which turns one check red.

Three decisions, each defended by a check that fails when the decision is
reversed:

| Decision | Reversed | Checks that go red |
|---|---|---|
| Match ends on a dot | `startsWith(name)` | 2 |
| Longest match wins | first match wins | 4 |
| Match what was read | split from the end | 1 |
| Visited set when following imports | follow unconditionally | 1 |

An alias that no import declares, or a qualified name no imported model holds, is
drawn as an unresolved stub rather than dropped: a dependency the diagram cannot
follow is a fact about the model, not nothing.

## 5. Structure

A new bundle `de.fhdo.lemma.servicedsl.diagram`, laid out as the data one is -
pure generators, a thin Eclipse shell, so the output is checkable headlessly.

```
de.fhdo.lemma.servicedsl.diagram/
├── src/de/fhdo/lemma/servicedsl/diagram/
│   ├── ServiceModelReader.xtend          # loads a model, reads the parse tree,
│   │                                     # resolves imports transitively
│   ├── ServiceGraph.xtend                # the resolved system: services,
│   │                                     # interfaces, operations, edges
│   ├── InterfaceDiagramGenerator.xtend   # ServiceGraph -> PlantUML
│   ├── DependencyDiagramGenerator.xtend  # ServiceGraph -> PlantUML, 2 diagrams
│   └── GenerateServiceDiagramHandler.xtend
├── tools/check-bundle-requires.py        # the OSGi check, see below
└── README.md
```

`ServiceGraph` exists so neither generator parses anything: resolution happens
once, is testable on its own, and a third diagram later needs no new reading.

## 6. Steps

1. **`ServiceModelReader` and `ServiceGraph`** - load a `.services` file, read
   its own structure from EMF and its cross-references from the node model,
   follow `import microservices` transitively with a visited set against cycles,
   and resolve every `required` entry by longest-prefix matching. Tests: the
   trap of §4, a cyclic import, an unresolvable alias.
2. **`InterfaceDiagramGenerator`** - one diagram per selected model: a package
   per microservice, an interface as a class stereotyped with its protocol,
   operations as methods carrying the verb and path, parameter and result types
   named. Verb comes from the aspect name (`GetMapping` → `GET`); an operation's
   own endpoint path appends to its interface's.
3. **`DependencyDiagramGenerator`** - the overview and the detail diagram from
   the same graph.
4. **The Eclipse shell** - one context-menu command on a `.services` selection,
   reusing `PlantUmlRenderer` from the data diagram bundle, which already
   renders and opens an SVG.
5. **Verification** - the headless sweep over all 19 example and 22 fixture
   models, asserting what the data sweep learned to assert: a model that
   declares an interface draws one, no two classes share an alias, every
   declared dependency appears as an edge or an explicit stub. Plus
   `tools/check-bundle-requires.py` on the new bundle, because a headless
   compile cannot see a missing `Require-Bundle`.

## 7. Deliberately not in this plan

- Transport security on the edges, and `PreAuthorize` on operations - declined
  for now; both are one annotation each on top of the graph once the security
  smell work resumes.
- Parameter aspects (`RequestParam`, `PathVariable`, `RequestBody`).
- Linking an operation's parameter type to the class in the data diagram, which
  would mean one picture spanning both model kinds.
- Operation models: containers, deployment, `default values`.
- A sequence diagram of a call chain, which would need the order of calls -
  something the reconstruction does not recover.

## 8. Reuse

`PlantUmlRenderer` and `tools/check-bundle-requires.py` live in
`de.fhdo.lemma.data.datadsl.diagram` and are wanted by both. They move to a
shared place only when a third bundle needs them; until then the service bundle
requires the data diagram bundle, which it does anyway for the data types an
operation refers to.

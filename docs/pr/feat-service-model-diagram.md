## Summary

A second diagram bundle, for service models. Select `.services` files,
**Generate PlantUML diagrams**, and get the interfaces of each selected model
and the dependencies of the whole selection as `.puml` and `.svg` beside them.

```text
de.fhdo.lemma.servicedsl.diagram/
├── ServiceModelReader.xtend            # loads models, follows imports,
│                                       # resolves every "required" entry
├── ServiceGraph.xtend                  # the resolved system, drawn from twice
├── InterfaceDiagramGenerator.xtend     # what a service offers
├── DependencyDiagramGenerator.xtend    # who calls whom, and through what
└── GenerateServiceDiagramHandler.xtend # the Eclipse shell
```

Three diagrams, because the questions differ:

```text
── interfaces, per selected model ──────────────────────────────────
package "CustomerCore" {
    interface "CustomerInformationHolder" as …_CustomerInformationHolder <<rest>> {
        /customers
        ..
        GET getCustomers(filter : string, limit : int) : PaginatedCustomerResponseDto
        GET /{ids} getCustomer(ids : string) : CustomersResponseDto
        PUT /{customerId} updateCustomer(customerId : CustomerId, …) : CustomerResponseDto
    }
}

── dependencies, overview, for the selection ───────────────────────
[CustomerSelfService] --> [CustomerCore]
[CustomerManagement]  --> [CustomerCore] : 3 ops
[PolicyManagement]    --> [CustomerCore]

── dependencies, detail ────────────────────────────────────────────
[CustomerSelfService] --> [CustomerCore]
package "CustomerCore" {
    [CustomerCore]
    [CustomerInformationHolder.getCustomer]
    [CustomerInformationHolder.getCustomers]
    [CustomerInformationHolder.updateCustomer]
}
[CustomerManagement] --> [CustomerInformationHolder.getCustomer]
```

The interface diagram is scoped to the selection, the dependency diagrams to
everything reachable from it. LEMMA's three `required` forms are alternatives
rather than layers and Lakeside Mutual uses two of them, so the overview reads
evenly across such a system while the detail diagram shows the evidence where
the model carries it.

`PlantUmlRenderer` is reused by requiring `de.fhdo.lemma.data.datadsl.diagram`
rather than by moving it to a bundle of its own. Two consumers do not justify a
third bundle; a third would.

## Evidence

**Cross-model references do not resolve outside a running Xtext.** Measured
before designing around it — all four Lakeside Mutual models in one
`XtextResourceSet`, `ServicePackage`, `DataPackage` and `TechnologyPackage`
registered:

```text
required microservice -> MicroserviceImpl  proxy=true  name=null
```

So local features are read from EMF and cross-references from the parse tree,
and the reader resolves dependencies itself. **Three things the models taught it,
each found by generating rather than by reasoning:**

```diff
 # a version prefixes the qualified name: qualifiedNameParts, not the name
-de.fhdo.APIGateways                 # every dependency of the three versioned
+v01.de.fhdo.APIGateways            # e-vehicle-charging models was unresolvable

 # a reference may abbreviate to a dot-boundary suffix
-required microservices { v01.de.fhdo.DiscoveryService }
+required microservices { DiscoveryService }        # as the examples write it

 # so the remainder is matched, never counted off by position
-if (remainder.size !== 2) unresolved(…)            # an interface may be versioned too
+val match = longest interface name the required name begins with
```

```text
dependency resolution across the repository
  24 of 44   as first written
  33 of 44   with the version rule
  41 of 44   with abbreviation
  44 of 49   final — and all five unresolved are deliberate fixtures,
             so every dependency of every real model resolves
```

**Three generator defects that only generating would have shown:** the overview
declared only microservice-level targets, so PlantUML invented a component and
labelled it with the raw alias; the detail diagram wrapped every service of a
coarse-grained system in a package holding one component of its own name; and a
note came out with its `end note` indented.

**Checks, and what each would catch.** 96 of them, no database and no Eclipse:

```text
96 check(s), 0 failed
```

Every decision is defended by a mutation that turns it red — 20 of them, all
caught. The ones worth naming:

| Decision | Reversed to | Red |
|---|---|---|
| the match ends on a dot | `startsWith(name)` | 2 |
| the longest match wins | the first match wins | 4 |
| match what was read | split from the end of the name | 1 |
| a version prefixes the qualified name | the name as written | 5 |
| an ambiguous abbreviation resolves to neither | to the first candidate | 2 |
| an interface is matched by name | the first interface | 3 |
| `RequestMapping` claims no verb | mapped to `GET` | 1 |
| a fault is not the result | counted as outgoing | 1 |
| an outgoing parameter is not a call parameter | listed as one | 7 |
| one reader serves several reads | a new resource every time | 3 |

**Four of those checks could not fail when first written, and that is reported
rather than quietly fixed.** Two prefix-matching checks passed under both
mutations because the fixture did not isolate them. No model in this repository
uses `required interfaces`, so that whole branch was unexercised until a fixture
declared one — `interfaces.head` left everything green. And the check that every
arrow end is declared had only been applied to a system where the omission
cannot show, because something requires `CustomerCore` as a whole there anyway.

**Sweeps over every service model**, asserting what the data diagram sweep had to
learn to assert:

```text
interface diagrams   33 models | 100 interfaces | 234 operations
                     silently empty 0 | alias collisions 0 | failed 0
dependency diagrams  33 models | 49 dependencies | 44 resolved
                     undeclared arrow ends 0 | missing arrows 0 | blank 0
rendered             99 diagrams, every one valid SVG
```

The OSGi dependency check passes on both diagram bundles.

**What this cannot show.** Whether the context-menu entry appears on a
`.services` selection, and whether the handler resolves inside a running
workbench, is what an Eclipse build shows and a headless one cannot — the
classpath ignores OSGi boundaries, which is how `org.eclipse.core.runtime` came
to be missing from the first bundle. The pipeline behind the handler was
exercised headlessly with the real reader, the real generators, the real file
names and the real renderer:

```text
CustomerSelfService-interfaces.puml / .svg          one per selected model
CustomerManagement-interfaces.puml  / .svg
PolicyManagement-interfaces.puml    / .svg
CustomerSelfService-dependencies.puml / .svg           once, for the selection
CustomerSelfService-dependencies-detail.puml / .svg
problems: []
```

## Merge Danger

**Door:** two-way. A new bundle, one `<module>` line in
`de.fhdo.lemma.servicedsl.parent/pom.xml`, and one `Require-Bundle` entry added
to nothing — `de.fhdo.lemma.data.datadsl.diagram` is unchanged by this branch.
No existing behaviour changes.

**Blast Radius:** one new bundle, and the Project Explorer context menu

The entry is contributed at `popup:org.eclipse.ui.popup.any` and guarded by
`<visibleWhen>` on a selection that is entirely `.services` files, so it cannot
appear beside the data model entry or where it would do nothing. The command
writes beside the model and overwrites a `-interfaces`, `-dependencies` or
`-dependencies-detail` file of its own making without asking; a hand-edited
`.puml` of one of those names would be lost, which is why the header says not to
edit it. The dependency diagrams are written beside the **first** selected
model, so selecting across folders puts them in the first one's folder.

The bundle requires `de.fhdo.lemma.data.datadsl.diagram`, which makes that
bundle a dependency of this one rather than a leaf — worth knowing before either
is moved or renamed. Neither has been built by Tycho; the headless compile and
the Eclipse workspace build are what they have been through.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

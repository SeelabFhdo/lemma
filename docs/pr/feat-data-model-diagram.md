## Summary

A new bundle that draws a LEMMA data model. Right-click one or more `.data`
files, **Generate PlantUML diagram**, and a `.puml` and an `.svg` land beside
each model; the first image opens, so the command ends in a diagram rather than
in a file.

```text
de.fhdo.lemma.data.datadsl.diagram/
├── DataModelDiagramGenerator.xtend   # DataModel -> PlantUML. A function of the
│                                     # model and nothing else: no file system,
│                                     # no workspace, no Eclipse
├── PlantUmlRenderer.xtend            # runs PlantUML, reports its absence
├── GenerateDataModelDiagramHandler.xtend
└── tools/check-bundle-requires.py    # resolves imports against Require-Bundle
```

```text
context CustomerManagement {              package "CustomerManagement" {
    structure CustomerDto {        ->       class "CustomerDto" as CM_CustomerDto {
        string customerId,                      customerId : string
        CustomerProfileDto profile            }
    }                                       }
}                                         CM_CustomerDto --> CM_CustomerProfileDto : profile
```

A structure is a class, a primitive field an attribute, a field whose type is
another structure an association. The DDD features a structure carries —
`<entity>`, `<valueObject>`, `<aggregate>` — are what a class diagram calls
stereotypes.

PlantUML is run as a command rather than linked: the jar is twelve megabytes and
third-party jars here are resolved by Maven rather than committed. Without it the
`.puml` is still written and the dialog says what to install.

## Evidence

**Rendering the whole corpus found two defects in the generated diagram.**

Versioned models were drawn blank. `DataDsl.xtext:12` reads
`versions+ | contexts+ | complexTypes+` — alternatives — and only the latter two
were read, so all 18 versioned models produced a header and nothing else:

```diff
 package "v01" <<version>> {
     package "Common" {
+        class "Address" as v01_Common_Address {
+            city : string
+            zipCode : int
+        }
     }
 }
```

Two structures were merged into one box. PlantUML identifies a class by name
whatever package it sits in, and `examples/food-to-go/Restaurant/Restaurant.data`
declares `RestaurantCreated` in both `context Events` and `context API`:

```diff
-class "RestaurantCreated" { … }          # Events and API, drawn as one class
-class "RestaurantCreated" { … }          # holding the fields of both
+class "RestaurantCreated" as Events_RestaurantCreated { … }
+class "RestaurantCreated" as API_RestaurantCreated { … }
```

**Neither was caught by the first sweep, and that is the point.** It watched for
exceptions, and an empty diagram raises none — so it reported success for every
versioned model while drawing nothing. A check that cannot fail proves nothing.
The sweep now asserts that a model declaring a type draws one, and that no two
classes share an alias:

```text
                      before fix   after fix
models                  133          133
ok                      133          133
silently empty           18            0     <- versioned models
alias collisions          1            0     <- food-to-go
failed                    0            0
classes                 502          682
associations            198          359
rendered                  -          133     all valid SVG
```

The 12 remaining collisions are all `Duplicate*` DSL test fixtures, which declare
the same type twice *in one context* — invalid models, where one box is the
honest drawing.

**A missing `Require-Bundle` entry is invisible to a headless build.**
`org.eclipse.core.runtime` was absent from the manifest and
`NullProgressMonitor` would not resolve in Eclipse, while the headless compile
passed — it uses a flat classpath of every jar of the installation, which ignores
OSGi boundaries. `tools/check-bundle-requires.py` closes that gap:

```text
without the fix:  !! org.eclipse.core.runtime  -> add org.eclipse.core.runtime   exit=1
with the fix:     OK: every imported package is reachable                        exit=0

across all 52 bundles of the repository: 51 OK, 1 reported
  de.fhdo.lemma.service.openapi — 45 Bundle-ClassPath jars are not on disk,
  so what they hold cannot be checked (the tool says so rather than guessing)
```

Getting it there cost four rounds of false positives — static-member imports,
`org.w3c.dom` being a JRE package, `Import-Package` as the other declaration
mechanism, and qualified names inside string literals (`de.fhdo.lemma.data.DataDsl`
is an editor id in `LemmaUiUtils.xtend:41`, not an import). No upstream bug behind
any of them.

`docs/service-diagram-plan.md` plans the same treatment for service models, and
records the constraint measured for it: cross-model references do not resolve
outside a running Xtext, so that generator will read local features from EMF and
cross-references from the parse tree.

## Merge Danger

**Door:** two-way. A new bundle plus one `<module>` line in
`de.fhdo.lemma.data.datadsl.parent/pom.xml`; nothing existing changes behaviour.

**Blast Radius:** one new bundle, and the Project Explorer context menu

The menu entry is contributed at `popup:org.eclipse.ui.popup.any` and guarded by
`<visibleWhen>` on a selection that is entirely `.data` files, so it does not
appear where it would do nothing. The generator writes beside the model and
overwrites a `<name>.puml` or `<name>.svg` of its own making without asking — a
hand-edited `.puml` next to a data model would be lost, which is why the header
says not to edit it.

The bundle is not in the Tycho reactor build of the parent beyond that module
entry, and it has not been built by Tycho — the headless compile and the Eclipse
workspace build are what it has been through.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

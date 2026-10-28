## Summary

The technology information MRF reconstructs from a REST controller now reaches
the service model:

```diff
+@endpoints(javaWithSpring::_protocols.rest:"/customers";)
 interface CustomerInformationHolder {
+    @endpoints(javaWithSpring::_protocols.rest:"/{customerId}";)
+    @javaWithSpring::_aspects.PutMapping
     updateCustomer(
-        @…PathVariable sync in customerId : …, @…Valid @…RequestBody sync in requestDto : …,  sync out …);
+        @javaWithSpring::_aspects.PathVariable sync in customerId : …,
+        @javaWithSpring::_aspects.Valid @javaWithSpring::_aspects.RequestBody sync in requestDto : …,
+        sync out customerResponseDto : …
+    );
 }
```

`TechnologyAspects` reads which aspects `spring.technology` declares, for which
join points and with which properties, so only declared names are emitted and
`@RequestParam`'s `required` — which the model declares no property for — is
dropped. Adding an annotation is a declaration in the model, not a change here.

**Three gaps had to be closed first.** `ServiceDslExtractor` wrote neither the
endpoints nor the aspects of an interface, and wrote an aspect without its
property values, so an aspect with a mandatory property was inexpressible; its
operation aspects also had no separator, which no model had shown because no
operation carried one. `TechnologyTypes` and `copyTechnologyModels` both gave up
without an OSGi bundle, which is how the regression test runs — so the test
compared models in which every foreign type was `unspecified` and no technology
model was ever copied, while the wizard produced models that had them. And
`generateInterfaceFrom` iterated with `forall`, a short-circuiting predicate that
worked only because `List.add` returns `true`.

The second commit puts one parameter per line, since an operation of a
reconstructed REST interface ran past five hundred characters, and removes a
pre-existing `,  sync out` double space and the trailing whitespace on separator
lines.

## Evidence

Both bundles compiled with the Xtend batch compiler; `ReconstructionRegressionTest`
run headlessly — both systems match their accepted models, which now carry the
aspects, the endpoints and `javaWithSpring::_types.ResponseEntity` where the type
was `unspecified` before. `test/expected/*/technology/` holds the technology
models the accepted models import, which the README documented but which never
actually happened.

The two formatting branches no fixture reaches were checked directly: `ping();`
stays on one line, `noimpl mystery(` indents its parameter.

**Not covered:** whether the editor reports no problem. The masking in the writer
only rewrites names that collide with a keyword, and a standalone Xtext validator
proved useless — it flags unresolved imports even on LEMMA's own
`examples/food-to-go/Accounting/Account.services`.

## Merge Danger

**Door:** two-way. Additive.

**Blast Radius:** every extracted service model

`ServiceDslExtractor` is a bundle of the language, not of the reconstruction, so
its changes reach anything that extracts a service model — though each only adds
output where it previously wrote nothing. Requires the matching MRF branch.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

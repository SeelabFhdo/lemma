## Summary

Two independent changes, one commit each.

### 1. A service states what it requires of the others

```diff
 import datatypes from "../domain/CustomerManagement.data" as CustomerManagement
+import microservices from "CustomerCore.services" as CustomerCore

 public functional microservice com.lakesidemutual.customermanagement.CustomerManagement {
+    required operations {
+        CustomerCore::…CustomerCore.CustomerInformationHolder.getCustomer,
+        CustomerCore::…CustomerCore.CustomerInformationHolder.getCustomers,
+        CustomerCore::…CustomerCore.CustomerInformationHolder.updateCustomer
+    }
```

`ServiceDependencies` chooses **one level per callee, the finest that resolves**.
An endpoint the client declares is matched against the callee's interfaces and
operations — the interface's address joined with the operation's, both normalised,
because each side of a call names its path variables for itself — and the
operation it identifies is what gets required. A client that declares no endpoint
yields the service instead.

The three levels are **alternatives, not layers**: the validation reports an
operation whose interface or microservice is also required as redundant. So it
falls back — to the interface when the match is ambiguous or no operation answers
under that verb and path, to the microservice when not even that resolves.

**A `noimpl` operation cannot be required at all.** `Microservice.canRequire`
demands `!isEffectivelyNotImplemented()` and the scope provider consults it, so
such a reference would not resolve. The generator marks an operation `noimpl` when
a parameter's type stays unresolved, and that condition is repeated in
`ServiceDependencies` because the callee's model is not generated when the
caller's is — the coupling is named in the code.

The generator takes the other microservices as a third argument; the two-argument
form delegates with none, so nothing that called it before changes. The extractor
printed none of the three `required` blocks and now prints them in the grammar's
order.

### 2. The models without the wizard

```
tools/reconstruct.sh --target <folder>
```

Same generators, same writer, same technology models; what the wizard asks for in
a dialog comes from the command line, and everything the database holds is
generated. `HeadlessReconstruction` also runs from the IDE as a Java application.

The script exists because outside the IDE there is no classpath: this repository
has no headless build, the bundles resolve their dependencies from a target
platform, and an Eclipse installation that already has Xtext and Xtend holds every
jar needed. Only the language, modelling and runtime bundles are taken —
unrelated plugins register service providers that take over the JVM's file system
or logging and stop the Xtend compiler before it starts. `LEMMA_ECLIPSE` points
elsewhere. The working directory is the bundle, because without OSGi the
technology models are read and copied relative to it.

## Evidence

**The headless output is byte-identical to the wizard's.** Same live database, all
twelve files, same checksum:

```text
System   (wizard,   16:31)  54ed6ab5d1e2d308
System2  (headless, 16:44)  54ed6ab5d1e2d308
diff -r  reports nothing
```

Both bundles compiled with the Xtend batch compiler; `ReconstructionRegressionTest`
run headlessly — three systems, all matching. On Lakeside Mutual each service lands
at the level its own sources support:

| Service | Level | Why |
|---|---|---|
| CustomerManagement | `required operations` | its Feign client declares three endpoints, each matching one operation |
| CustomerSelfService | `required microservices` | `RestTemplate`, no endpoint declared |
| PolicyManagement | `required microservices` | the same |
| CustomerCore | none | calls no other service |

Every emitted reference was checked to name an operation, interface and
microservice that exist in the callee's generated model.

A deliberately broken source was used to confirm the script fails with a non-zero
status rather than generating from the last successful compile — the first version
swallowed that, because the Xtend compiler reports an error and still exits zero.

**Not covered:** whether the editor resolves the new references. The masking in the
writer only rewrites names that collide with a keyword, and a standalone Xtext
validator is useless here — it flags unresolved imports even on LEMMA's own
`examples/food-to-go` models.

## Merge Danger

**Door:** two-way. The dependency is emitted only where the reconstruction reports
a call; the script adds files and touches nothing that runs in Eclipse.

**Blast Radius:** service models of systems reconstructed with the Communication plugin

**Merge after the matching MRF branch** — the fixture's documents come from that
reconstruction, and the expected models assume its facts.

`ServiceDslExtractor` is a bundle of the language, so printing the `required`
blocks reaches anything that extracts a service model — though it only adds output
where nothing was written before.

Also here: `LemmaReconstructionHandler.generateModels` guarded only the first of
its three calls, because the condition was written without braces. Each generator
already does nothing on an empty selection, so the condition is gone and the
behaviour is unchanged.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

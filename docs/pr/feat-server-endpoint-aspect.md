## Summary

The LEMMA half of MRF's backlog item **A1**. The reconstruction writes one
`ServerEndpoint` record per connector; this makes it visible in the generated
service model, which is what ADR-0009 asks of a step.

```diff
 @technology(javaWithSpring)
 @javaWithSpring::_aspects.ServiceCommunicationTransport(transport = "plaintext")
+@javaWithSpring::_aspects.ServerEndpoint(connector = "server", port = "8090", protocol = "http", tlsEnabled = false)
 public functional microservice com.lakesidemutual.policymanagement.PolicyManagement {
```

The caller's half and the callee's half now sit on the same microservice, which
is what the smell rule will read.

**No generator change.** `assignAspects` already looks a reconstructed fact up
by name against the technology model and emits whatever properties it declares,
so declaring the aspect is the whole of it:

```text
aspect ServerEndpoint for microservices {
    string connector;
    string port;
    string protocol;
    boolean tlsEnabled;
    string clientAuth;
}
```

## Evidence

**Declared without `<singleval>`, and that part was looked up rather than
assumed.** `ServiceDslValidator.checkUniqueAspects` rejects a repeated
single-valued aspect and returns early for one that is not:

```xtend
def checkUniqueAspects(ImportedServiceAspect aspect) {
    if (!aspect.importedAspect.isSingleValued) {
        return                                  // ← non-single-valued: repeatable
    }
    …
    error("Aspect may be specified at most once", …)
}
```

A service with a TLS main connector and a plaintext management connector
therefore carries the aspect twice. A single-valued declaration — the obvious
first guess, and what every neighbouring aspect uses — would have made the
second connector unrepresentable.

**No property is `<mandatory>`.** A database written by an older reconstruction
then yields a model with fewer values rather than a generation that fails. That
failure mode is not hypothetical: a `<mandatory>` `springApplicationName` once
produced a validation error that looked like an over-strict technology model and
was really a stale database.

**`valueSource` is deliberately left out of the aspect.** The database keeps the
file a fact came from; a file path on every microservice is noise in a model.

**`tlsEnabled` comes out as a boolean, not the string the seam carries:**

```text
@javaWithSpring::_aspects.ServerEndpoint(connector = "server", port = "8110",
    protocol = "http", tlsEnabled = false)
```

**The regression test, against the fixture documents:**

```text
=== customer-core ===      ok
=== lakeside-mutual ===    ok    4 models gain one line each
=== risk-management ===    ok
=== station-service ===    ok
All systems match their expected models.
```

**And against the real database**, reconstructed with `-r` and all six plugins,
then generated from the command line:

```text
Read from localhost:27017 - 5 context(s), 5 microservice(s), 11 operation node(s)
Wrote 11 model(s)
ServerEndpoint on all four Spring services, every one plaintext
```

`RiskManagement` has no `ServerEndpoint`, which is right rather than missing: it
is the gRPC/Node service with no `application.properties`, and MRF reports
nothing rather than claiming Spring's default port for a service that is not
Spring.

## Merge Danger

**Door:** two-way. One aspect declaration in a technology model, plus the
expected models and the fixture documents that follow from it.

**Blast Radius:** every generated service model whose microservice carries the
fact

The aspect is additive: a microservice without a `ServerEndpoint` record is
generated exactly as before. The technology model is copied into each generated
system's folder, so regenerated systems pick it up automatically — and the
copies under `test/expected/*/technology/` are inputs rather than compared
output, which is why they change here too.

`CustomerSelfService.services` also gains a trailing newline it was missing.

**Order matters when regenerating**: MRF must run before this, because the
aspect only appears for documents that carry the fact. A stale database yields a
model without it, which looks like this change not working.

The MRF side is a separate pull request against
`pwizenty/microservice-reconstruction-framework`.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

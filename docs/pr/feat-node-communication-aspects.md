## Summary

**A technology model is a closed vocabulary.** An aspect it does not declare
cannot be referred to, so the generator drops the fact rather than emit a
reference that would not resolve — silently, and by design, because a dangling
reference is worse than a visible gap.

`GrpcServer` and `MessageQueue` were reconstructed and dropped exactly that way.
Lakeside Mutual's Risk Management server stood in the generated service models
with **no communication fact at all**, while every Java service carried its
connectors and its channels:

```diff
 @technology(javaWithSpring)
+@javaWithSpring::_aspects.GrpcServer(host = "0.0.0.0", port = "50051", transportSecurity = "plaintext")
+@javaWithSpring::_aspects.MessageQueue(broker = "activemq", host = "localhost", port = "61613", queue = "newpolicies", scheme = "stomp", credentialsConfigured = "true", transportSecurity = "plaintext")
 public functional microservice riskmanagement.RiskManagement {
     interface RiskManagement {
```

Two aspects, declared in `spring.technology` for microservices, in the four
systems' technology models and the reconstruction's own:

```text
aspect GrpcServer for microservices {
    string host; string port; string transportSecurity; string clientAuth;
}
aspect MessageQueue for microservices {
    string broker; string host; string port; string queue; string scheme;
    string credentialsConfigured; string transportSecurity;
}
```

**Neither is `<singleval>`.** A service may bind more than one endpoint and may
be configured for several queues, and `checkUniqueAspects` would make the second
one unrepresentable.

**`valueSource` stays undeclared**, as it is for `ServerEndpoint`. The
reconstruction records the path it read the evidence from, which is absolute for
a real run, and a generated model has to be identical on every machine. The
evidence stays in the database where a finding can look it up.

`clientAuth` is `need` where the server requires and verifies a client
certificate, the same word `ServerEndpoint` uses, and `transportSecurity` is
`plaintext`, `tls` or `unresolved` — the words of the client-side transport, so
that one spelling is compared against everywhere.

## Evidence

```text
ReconstructionRegressionTest    all 4 systems match their expected models
```

The `risk-management` fixture is reconstructed with the Node plugin in the
selection, so it now carries the pair, and its `expected_model.json` carries the
two aspect references the generator writes for it. **The other three systems are
unchanged** — `customer-core`, `lakeside-mutual` and `station-service` gained
the declarations and produce the same models as before, which is what shows the
declaration adds vocabulary rather than output.

```diff
 de.fhdo.lemma.reconstruction/
   test/fixtures/risk-management/documents.json          + 22   the two facts, as MRF persists them
   test/expected/risk-management/service/RiskManagement.services  + 2   the two aspect references
```

### What this does not do

- **It judges nothing.** The aspects are vocabulary; whether a plaintext gRPC
  endpoint is a finding is decided in `de.fhdo.lemma.servicedsl.smells`, which
  the next branch in this stack teaches to read them. Merged alone, this branch
  moves the finding count from 9 to 9.
- **It needs its MRF counterpart.** The facts come from
  `feat/node-transport-evidence` there; without it `transportSecurity` is
  `UNRESOLVED` for every Node service and the aspects carry a word that says
  nothing.

## Merge Danger

**Door:** two-way. Five technology models, one fixture, one expected model, one
README.

**Blast Radius:** every generated service model of a system reconstructed with
the Node plugin

- **Adding an aspect to a technology model cannot invalidate an existing
  model**: nothing references the new names until a reconstruction produces the
  facts, and the three systems that do not were regenerated to show it.
- **The same declaration was added to four technology models by hand**, because
  each system carries its own copy. They are identical; a divergence would show
  as a model that faults on a reference the others resolve.
- A model written against the previous `spring.technology` still parses — the
  change is additive, and no existing aspect was renamed or made single-valued.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

## Summary

A fixture whose models come from a gRPC contract rather than from annotated Java,
and the only automated proof that the path works at all.

```text
test/fixtures/risk-management/documents.json     reconstructed with -p Protobuf
test/expected/risk-management/
├── domain/RiskManagement.data
└── service/RiskManagement.services
```

```
import datatypes from "../domain/RiskManagement.data" as RiskManagement
…
    Trigger(
        sync in triggerRequest : RiskManagement::RiskManagement.TriggerRequest,
        sync out triggerReply : RiskManagement::RiskManagement.TriggerReply
    );
```

It guards what no fixture did before: that a reconstruction from a proto file
produces models whose references resolve — the data model is named after the
context its structures are qualified under, and the service model's import of it
resolves.

## Evidence

`ReconstructionRegressionTest` run headlessly: four systems, all matching.

Two properties of the fixture are deliberate and recorded in `test/README.md`,
because both would otherwise read as a regression.

**The interface carries no `@endpoints`.** A gRPC service is addressed by its
qualified name, and MRF reports that under a name of its own rather than as an
`Endpoint` — because an endpoint is generated under the only protocol the service
generator knows, `rest`, and `spring.technology` declares no `grpc`. An earlier
version of the MRF side did report it as an endpoint, and the model then stated
that a gRPC service is reached over REST.

**`sync out triggerReply` although the rpc returns a `stream`.** MRF reports the
parameter as asynchronous; `LemmaServiceGenerator.deriveCommunicationType` maps
`asynchronous` onto `CommunicationType.SYNCHRONOUS`, so it arrives as `sync`:

```xtend
case "synchronous": CommunicationType.SYNCHRONOUS
case "asynchronous": CommunicationType.SYNCHRONOUS   // both
```

That is a defect of the generator and **this is the first model to show it** — no
Spring service of the other fixtures has an asynchronous parameter. Left as it is
rather than fixed here, so the fixture records the current behaviour and the fix
is a change of its own.

## Merge Danger

**Door:** two-way. Test material only; no generator, extractor or technology
model changes.

**Blast Radius:** the regression test

Requires the matching MRF branch, whose reconstruction the fixture's documents
come from.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

## Summary

A parameter the reconstruction reported as asynchronous arrived as synchronous,
so the model stated the opposite of the sources.

```diff
 case "synchronous": CommunicationType.SYNCHRONOUS
-case "asynchronous": CommunicationType.SYNCHRONOUS
+case "asynchronous": CommunicationType.ASYNCHRONOUS
+default: CommunicationType.SYNCHRONOUS
```

```diff
 Trigger(                                    # rpc Trigger (…) returns (stream TriggerReply)
     sync in triggerRequest : …,
-    sync out triggerReply : …
+    async out triggerReply : …
 );
```

**Nothing showed it until a gRPC contract was reconstructed.** The Spring plugin
reports every parameter as synchronous, so a streaming rpc is the first
asynchronous one in any system here — which is why one model changes and why
`risk-management` is the only fixture that guards the fix.

`deriveExchangePattern` had the same shape of trap and gets the same treatment: a
switch with no `default` returns null for an unknown value, and the extractor
fails on null with `Type null is not supported`. Both fall back now rather than
return nothing.

## Evidence

**Checked before changing it, not after.** `checkEffectiveProtocols` demands an
asynchronous protocol of a microservice with an asynchronous parameter, either
explicitly through `@async(…)` or as a default of an assigned technology.
`spring.technology` declares

```
async amqp data formats "application/json"
    default with format "application/json";
```

and the Technology DSL's `Protocol` rule reads that `default` as marking the
protocol itself — `(default?='default' 'with' 'format' defaultFormat=…)` — so
`getEffectiveDefaultProtocol` finds it and the generated model validates.

Bundle compiled with the Xtend batch compiler; `ReconstructionRegressionTest` run
headlessly:

```text
=== customer-core ===      ok
=== lakeside-mutual ===    ok      no Spring-derived model moves
=== risk-management ===    1 line  sync out -> async out
=== station-service ===    ok
All systems match their expected models.
```

`test/README.md` documented the bug as expected behaviour of the fixture and is
corrected in the same change.

## Merge Danger

**Door:** two-way. Two `switch` arms.

**Blast Radius:** any model with an asynchronous parameter

Today that is one: `risk-management`. Every other model is produced from Spring
sources, which report synchronous throughout, so the change is invisible to them —
asserted by the regression test rather than assumed. A system reconstructed
before this with an asynchronous parameter has a model that says `sync` where the
sources say otherwise, and should be regenerated rather than compared.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

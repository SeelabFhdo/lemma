## Summary

LEMMA can now say that a system has the security smell **Non-Secured
Service-to-Service Communications** — Ponce et al. (2022) §3.7 — in the model
editor and from the command line. Per ADR-0009 the facts come from MRF and the
decision is made here.

```text
de.fhdo.lemma.servicedsl.smells.validation/      # the rule, and only the rule
├── ChannelVerdict.xtend                         #   plain values in, verdict out
└── NonSecuredCommunicationValidator.xtend       #   @Check -> editor warning

de.fhdo.lemma.servicedsl.smells/                 # everything around it
├── NonSecuredCommunicationDetector.xtend        #   over a parsed model
├── Finding.xtend / SmellReport.xtend            #   what was found, as Markdown
├── DetectSmellsHandler.xtend + plugin.xml       #   right-click a .services file
├── cli/SmellDetectionCli.xtend                  #   exit 1 findings / 0 none / 2 unreadable
├── tools/detect-smells.sh                       #   no Eclipse needed
└── test/ (28 checks)

de.fhdo.lemma.servicedsl/ServiceDslValidator     # + one line
```

**Two ways of detecting it, one rule.** The editor and the CLI reach the same
verdict because neither of them contains it: `ChannelVerdict` takes plain
strings and returns an `Outcome`, and both call it.

```diff
 ServiceDslValidator
+  @ComposedChecks(validators = #[NonSecuredCommunicationValidator])
+    checkNonSecuredCommunication(Microservice)
+      ChannelVerdict.ofCall / ofQueue      ← the rule
 NonSecuredCommunicationDetector
-  (its own copy of the rule)
+  ChannelVerdict.ofCall / ofQueue          ← the same rule
```

The rule is in a bundle of its own because the alternative is a cycle. The
warning has to be raised from `ServiceDslValidator`, which lives in
`de.fhdo.lemma.servicedsl`; the detector lives in the smells bundle, which
requires the Service DSL. A rule in the smells bundle could therefore never be
reached from the validator. `…smells.validation` requires only the metamodels,
so it cycles with nothing, and the Service DSL's own change is **one line** plus
two imports:

```diff
+@ComposedChecks(validators = #[NonSecuredCommunicationValidator])
 class ServiceDslValidator extends AbstractServiceDslValidator {
```

An `Outcome` is one of four, and the two that are not findings are not merged:

| Outcome | Meaning |
|---|---|
| `SMELL` | a channel the models show as unprotected |
| `PROTECTED` | a channel the models show as protected |
| `UNDECIDED` | the models do not say — reported separately, never as safe |
| `NOT_APPLICABLE` | not a channel between two microservices |

`UNDECIDED` exists so the report cannot flatter a system. A consumer with
nothing at the other end, or a broker whose transport did not resolve, is
counted in its own column rather than quietly dropped into "protected".

### What a model had to gain first

Three per-link aspects, because the old facts could not support the rule.
`ServiceCommunicationTransport` says what a service's calls use *together* —
enough to see that a service has a problem, not enough to see which link. The
smell judges a *pair*, so it needs the link:

```diff
 @javaWithSpring::_aspects.ServiceCommunicationTransport(transport = "plaintext")
+@javaWithSpring::_aspects.ServiceCall(target = "CustomerCore", targetKind = "SERVICE", scheme = "http", ^technology = "Feign")
+@javaWithSpring::_aspects.ServiceCallEndpoint(target = "CustomerCore", verb = "GetMapping", path = "/customers", method = "getCustomers")
+@javaWithSpring::_aspects.MessageChannel(role = "producer", queue = "newpolicies", target = "RiskManagement", broker = "activemq", scheme = "tcp", transport = "plaintext")
```

All three are declared **without** `<singleval>`, so a service that calls three
others carries the aspect three times. `checkUniqueAspects` rejects a repeated
single-valued aspect, and — worth knowing — *returns early* for a non-single-valued
one, so getting this wrong fails loudly in one direction and silently in the other.

There is no aspect join point for a `required` dependency (the Technology DSL
offers types, fields, domainOperations, domainParameters, microservices,
interfaces, operations, parameters), so a per-link fact can only be an aspect on
the *calling* microservice that names its target. The rule joins `target` back
to the `required` entry.

The aspects deliberately carry **no `file` and no `line`**. The reconstruction
knows them, but they are absolute paths on the machine that ran it, and a
generated model has to be identical on every machine to be diffable. The
evidence stays in the database, where a finding can look it up.

### `protocol` and `technology` are keywords

Declaring a property named after a DSL keyword produces a model that does not
parse — *"no viable alternative at input 'protocol'"*. Escaping it needs **three**
places, and doing only the first two is worse than doing none:

| Place | Change |
|---|---|
| `spring.technology` | `string ^protocol;`, `string ^technology;` |
| `ServiceDslExtractor.generateValues` | `«v.property.name.escaped»`, against a `KEYWORDS` set taken from `ServiceDsl.xtext` |
| `TechnologyAspects.PROPERTY` / `AspectReference` | regex gains `\^?`; a leading caret is stripped when parsing |

Escaping the declaration alone made the values **silently disappear** from
generated models: `TechnologyAspects`' regex read the name as `^protocol`,
matched nothing, and emitted the aspect without them. No test failed. It was
caught by regenerating the models and reading them.

## Evidence

**Before:** no rule, and no editor or CLI could express the smell.

**After:** all six bundles compile against the declared `JavaSE-11`, and four
suites pass.

```console
$ build-diagrams.sh                       # Xtend batch compiler + javac --release 11
  compiled de.fhdo.lemma.diagram.common
  compiled de.fhdo.lemma.data.datadsl.diagram
  compiled de.fhdo.lemma.servicedsl.diagram
  compiled de.fhdo.lemma.operationdsl.diagram
  compiled de.fhdo.lemma.servicedsl.smells.validation
  compiled de.fhdo.lemma.servicedsl.smells

$ SmellDetectionTest        28 check(s), 0 failed
$ ServiceGraphTest          96 check(s), 0 failed
$ OperationGraphTest        60 check(s), 0 failed
$ ReconstructionRegressionTest
=== customer-core ===      ok (2 models)
=== lakeside-mutual ===    ok (8 models)
=== risk-management ===    ok (2 models)
=== station-service ===    ok (2 models)
All systems match their expected models.
```

The regression test is what guards the escaping: it runs the same generators,
extractor, validation and masking as the reconstruction wizard and compares the
models **as text**, so a property that silently vanishes shows up as a diff.
The four `lakeside-mutual` service models in `expected/` were reviewed and
accepted as part of this change rather than regenerated to make a test pass.

End to end on Lakeside Mutual, from reconstructed models:

```console
$ tools/detect-smells.sh ~/Entwicklung/Promotion/generated-models --report smells.md
5 model(s) read.
9 finding(s), 0 channel(s) judged protected, 0 not decidable from the models.
CustomerManagement -> CustomerCore (call to CustomerCore)
    the call uses http, which does not protect the channel
CustomerSelfService -> PolicyManagement (queue insurance-quote-request-event-queue)
    the broker is reached over tcp, which does not protect the channel
… 7 more

$ echo $?
1
```

Exit codes are the contract and were checked separately, not assumed:

```console
findings  -> exit 1
no models -> exit 2
```

**The finding count is a lower bound.** Nine findings is what the *models* state;
the system may be worse. gRPC clients are not reconstructed (MRF backlog A8b),
nor is weakened TLS verification (A2) or per-profile configuration (A6).

**Not mesh false positives.** The smell holds "even if they are within the same
network", but a service mesh terminating TLS transparently would still make these
findings wrong. `kubernetes/manifests` was checked: no mesh, no TLS, no ingress.

## Merge Danger

**Door:** two-way for the code, **one-way for the generated models.**

Two new bundles, a one-line `@ComposedChecks`, and one `Require-Bundle` entry —
all trivially revertible. The accepted models under `test/expected/` are not:
they are reviewed artefacts, and reverting the extractor without reverting them
leaves the regression test comparing new expectations against old output.

**Blast Radius:** every service model, and every editor that opens one

- **The warning appears on existing models.** A composed check runs for every
  `.services` file in the workspace, so a model reconstructed earlier that
  carries the new aspects will show a warning the moment this is installed. It
  is a *warning*, not an error: the model is not wrong, it faithfully describes a
  system that has the smell. Nothing stops building.
- **The warning sits on the microservice's name.** A channel is evidenced across
  two files, so there is no single wrong line to underline. The message names the
  channel and the reason.
- **Every generated service model's text changes.** `^protocol` instead of
  `protocol`, plus the new aspects. A model generated before this parses as
  before, but comparing old and new output of the same system shows diffs that
  are the escaping, not a reconstruction change.
- **A technology model with a keyword-named property now behaves differently.**
  Before, such a property made the generated model unparseable; now it is
  escaped. Any workaround that renamed a property to dodge this is no longer
  needed, and `KEYWORDS` is a snapshot of `ServiceDsl.xtext` — a keyword added to
  the grammar later has to be added here too.

This depends on MRF's `feat/async-communication` for the `MessageChannel` facts.
Merging this first is harmless — a model without those aspects simply yields no
asynchronous findings — but the nine findings above need both.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

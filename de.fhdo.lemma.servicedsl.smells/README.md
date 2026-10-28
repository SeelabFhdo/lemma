# Security smells in service models

**How to run it: [`docs/smell-resolution-guide.md`](../docs/smell-resolution-guide.md)** — the Eclipse route, the shell route, verification, and what to do when it goes wrong.

Detects **Non-Secured Service-to-Service Communications** — §3.7 of Ponce et
al. (2022) — in LEMMA service models. Select one or more `.services` files,
**Detect security smells** from the context menu, and a Markdown report lands
beside the first of them and opens.

```
Findings                            9
Channels judged protected           0
Channels that could not be judged   0

### CustomerManagement → CustomerCore
- Channel: call to CustomerCore
- Why: the call uses http, which does not protect the channel
- Refactoring: Use Mutual TLS
- Evidence, as the models state it:
  - @javaWithSpring::_aspects.ServiceCall(target = "CustomerCore", …, scheme = "http", …)
  - @javaWithSpring::_aspects.ServerEndpoint(connector = "server", port = "8110", …, tlsEnabled = false)
```

A report rather than editor markers: a finding is about a **pair** of
microservices declared in two different files, so there is no single line to
mark — and the evidence is worth more than a squiggle.

## Where the decision belongs

ADR-0009 of the reconstruction framework puts the split: **MRF collects facts,
LEMMA decides the smell.** So nothing MRF writes is named `insecure` and nothing
carries a severity; this bundle reads the facts a model carries and judges them.

A finding carries no severity either. The literature does not rank these smells,
and inventing a ranking would put a judgement in the tool that belongs to
whoever reads it.

## What the rule decides

For every interaction between two microservices **of the application**:

| Channel | Judged from |
|---|---|
| A synchronous call | the scheme the caller uses, **and** whether the callee's connector accepts plaintext |
| A channel through a queue | the transport of the broker |

Four things it deliberately does:

- **A call to a third party is not this smell.** The paper's smell is about two
  microservices of the application, so an external target is neither a finding
  nor something this rule can clear.
- **A TLS call to a callee that also accepts plaintext is still a finding.** The
  smell is about the channel: a callee with a plaintext management connector can
  be reached over plaintext however this caller calls it.
- **A queue is judged once, from the producer's end.** Both ends carry the fact
  — it is one interaction, and judging both would double every asynchronous
  finding.
- **What cannot be decided is reported as undecided, never as secure.** A system
  that does not smell and a system whose facts were never reconstructed must not
  look alike. That is the difference between a rule and a guess.

Where TLS is in place but `clientAuth` is not `need`, the finding says so: the
paper's refactoring is *mutual* TLS because it also authenticates the peers,
which is what additionally mitigates §3.8 Unauthenticated traffic.

## What it found in Lakeside Mutual

```
3 synchronous calls   CustomerManagement, CustomerSelfService, PolicyManagement → CustomerCore
6 queue channels      CustomerSelfService ↔ PolicyManagement (5), PolicyManagement → RiskManagement
1 gRPC endpoint       RiskManagement serves 0.0.0.0:50051 bound with createInsecure
1 leg to the broker   RiskManagement consumes newpolicies over STOMP
                      ─────
                      11 findings, 0 protected, 0 undecided, 0 services unjudged
2 deployment nodes    SpringBootAdmin and Proxy deploy no reconstructed
                      microservice, so no channel of theirs was judged
```

Every one plaintext, over 4 root causes: the connectors of CustomerCore (3), the
broker over TCP (6), the connectors of RiskManagement (1), the broker over STOMP
(1).

The queue channel to RiskManagement is cross-technology: a Java producer and a
Node consumer, paired by queue name. The last two findings are the Node
consumer's own facts, and they were invisible until the technology model
declared an aspect for them — the service appeared in the models with no
communication fact at all, so **the count was 9 and nothing said that two
channels had not been looked at**. The gRPC endpoint is the sharper of the two:
the proposal guided by the models never touched it, and the unguided run
secured it, which is a difference no gate could see while the detector could
not either.

## Where its view ends

Counting services with no communication fact catches a service the
reconstruction read and left without one. It does not catch a client that has no
service model at all, and Lakeside Mutual has two: the monitoring server, which
MRF skips as infrastructure, and an NGINX load-balancing demonstration, which it
does not read. Both are real clients of the Customer Core's connector — a
refactoring given the sources secured them, one given only the models did not.

So the detection answers the coverage question from the deployment instead:

```sh
tools/detect-smells.sh <models> --deployment <models>/operation
```

Every operation node that deploys no microservice a read service model declares
is reported as a **potential unmodelled client** — not as a finding. Nothing
there says such a node communicates, let alone insecurely; it says the detection
cannot see whether it does, which is what a report has to admit rather than
imply by silence.

## Checking it

```sh
# in this bundle, "Run As -> Java Application" on SmellDetectionTest, or:
java de.fhdo.lemma.servicedsl.smells.test.SmellDetectionTest

python3 ../de.fhdo.lemma.diagram.common/tools/check-bundle-requires.py .
```

176 checks, no database and no running Eclipse. The fixtures under `test/` carry
what no sample system has — TLS anywhere, a TLS broker, a callee with both kinds
of connector — because **neither Lakeside Mutual nor park-and-charge configures
TLS at all**. So the rule's *negative* case is fixture-only.

Every decision is defended by a mutation that turns it red:

| Decision | Reversed to | Checks that go red |
|---|---|---|
| a protected channel is cleared | report every call | 2 |
| the callee's connectors count | judge the caller's scheme alone | 2 |
| undecided is not secure | assume secure | 1 |
| a queue is judged once | judge both ends | 1 |
| a third party is not this smell | report it too | 1 |

## Structure

`NonSecuredCommunicationDetector` is a function of a `ServiceGraph` and nothing
else: no file system, no workspace, no Eclipse. `SmellReport` is a function of
the result. `DetectSmellsHandler` is the shell that finds the selection, writes
the report and opens it.

The `ServiceGraph` and its reader come from `de.fhdo.lemma.servicedsl.diagram`,
which this bundle requires. That makes a diagram bundle the host of the service
model reader, which is the shape of coupling `PlantUmlRenderer` had before it
moved to `de.fhdo.lemma.diagram.common` — two consumers do not justify
extracting it, a third would.

## What only Eclipse can confirm

Whether the menu entry appears on a `.services` selection and whether the
handler resolves in a running workbench. The detector and the report were
exercised headlessly against the models generated from the real database, and
produced the nine findings above.

## The second way: a warning in the model editor

`de.fhdo.lemma.servicedsl.smells.validation` warns in the editor where a
microservice interacts with another over an unprotected channel:

```
Non-Secured Service-to-Service Communications (Ponce et al. (2022) §3.7):
the call to CustomerCore is not secured - the call uses http, which does not
protect the channel. Suggested refactoring: Use Mutual TLS.
```

It is composed into the Service DSL's own validator, which is the **one line**
it needs of that bundle:

```xtend
@ComposedChecks(validators = #[NonSecuredCommunicationValidator])
class ServiceDslValidator extends AbstractServiceDslValidator {
```

The validation bundle requires only the metamodels, so nothing cycles — had the
rule lived here instead, the Service DSL would have had to require this bundle,
which requires it.

### Why the two ways cannot drift apart

Both decide with `ChannelVerdict`, a function of plain values with no model, no
EMF and no Xtext in it. The editor arrives there with facts read from resolved
cross-references; the command line arrives with facts read from parse trees. The
verdict is the same code.

### Why the editor judges better, not merely sooner

Inside a running Xtext a cross-reference resolves. So the validator follows
`required microservices` to the callee itself and reads its `ServerEndpoint`
aspects, where the command line has to match the target by name against what
the models wrote.

### Why a warning and not an error

The model is not wrong; the architecture has a risk. Ponce et al. do not rank
their smells, so the severity is a presentation choice rather than a finding —
which is also why a `Finding` from the command line carries none.

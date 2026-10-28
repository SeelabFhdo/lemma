## Summary

**The detector read `ServiceCall` and `MessageChannel` and nothing else**, so a
service whose only facts were `GrpcServer` and `MessageQueue` was walked past in
silence. Lakeside Mutual's Risk Management server is such a service, and the
report said *nine findings* with no hint that two channels had not been looked
at:

```diff
 3 synchronous calls   CustomerManagement, CustomerSelfService, PolicyManagement → CustomerCore
 6 queue channels      CustomerSelfService ↔ PolicyManagement (5), PolicyManagement → RiskManagement
+1 gRPC endpoint       RiskManagement serves 0.0.0.0:50051 bound with createInsecure
+1 leg to the broker   RiskManagement consumes newpolicies over STOMP
                       ─────
-                      9 findings, 0 protected, 0 undecided
+                      11 findings, 0 protected, 0 undecided, 0 services unjudged
```

Eleven findings over **four** root causes: the connectors of `CustomerCore` (3),
the broker over TCP (6), the connectors of `RiskManagement` (1), the broker over
STOMP (1).

**A listener is judged from the server's end.** The peer need not be a
microservice the reconstruction knows — the caller of that endpoint is a command
line tool nothing deploys — and that does not make a plaintext listener
protected: §3.7 holds "even if within the same network". The finding says so in
its own reason, so nothing is claimed that was not read, and its cause is the
connectors of the service that serves it, which is the cause a plaintext *call*
to it would have had.

**The leg to the broker is not the queue channel seen from the other side.** A
broker offers one connector per transport, and the two ends of one queue may use
different ones — TCP for the Java producers, STOMP for the Node consumer — so
protecting one leaves the other open and the queue readable there. Two legs, two
causes keyed by scheme, two patches, which is what the recorded proposals had to
write.

```text
de.fhdo.lemma.servicedsl.smells.validation/…/
├── ChannelVerdict                 # shared by the rule and the report
└── NonSecuredCommunicationValidator  # the editor's warning, now on both aspects

de.fhdo.lemma.servicedsl.smells/…/
├── NonSecuredCommunicationDetector   # judgeListener, judgeBrokerConnection
├── Finding                           # carries the cause id and its label
└── SmellReport                       # + services carrying no channel fact
```

Rule and report **share `ChannelVerdict`** so the two tools cannot drift: a
cause id keyed on a qualified name in one and a simple name in the other would
have split one cause in two.

The report gains the count that was missing: **services carrying no fact about
any channel of theirs.** An undecided channel was seen and could not be judged;
these were never looked at, and a report that cannot tell the two apart lets a
blind spot pass for a clean system.

### Four defects of the verification script, all found by running it

None was reachable by reading it; each was found by running the four gates
against the recorded proposals.

| | What it did | Fixed by |
|---|---|---|
| The start gate compared *whether* the base logged an unreachable peer, not *what* | It skipped on the first patch it saw, while that patch had broken a second channel and said so in the log it was reading | error kinds compared as **sets**; only a kind the base lacks is the patch's doing. On rc1 that isolates `certificate_unknown`, `SSLException`, `SSLHandshakeException` and "unable to find valid certification path", all from `spring-boot-admin`; the shared `ECONNREFUSED` is ignored |
| Coming up was taken for working | A compose stack reports every container up while a client inside it fails every connection attempt — the broker moved to TLS, the Node consumer's own configuration had not, and only a hand-run probe found it | the stack settles, then the logs are read for an unreachable peer. Only what is logged **after** the settle period counts, so a client that retries through a starting broker is not punished; `LEMMA_SETTLE_SECONDS` for a slower machine |
| Any newly unreachable peer would have failed every correct patch | Mutual TLS on actuator endpoints does stop an admin server holding no client certificate — every proposal here does that | the gate checks whether the loss was **declared** in `REFACTORING-NOTES.md`. Declared, it passes and says which; undeclared, it fails and names them. Two of three proposals describe the consequence in detail and one does not mention it — a difference that was invisible to every gate |
| The certificate script was looked for one directory deep, and the control tree got no key material | One proposal ships `scripts/generate-certificates.sh`, so nothing was found, the system could not come up, and the gate blamed the patch while the server logged the real reason. rc3's base is rc1 applied, so a control without certificates logged none of rc1's TLS errors and **rc3 was charged with its base's failure** | the lookup goes two levels; one function generates material for whichever tree is brought up, and the inplace gate uses it too |

The kinds are kept in a file rather than a variable: several contain spaces, and
word splitting had turned "unable to find valid certification path" into six
separate kinds.

**The extent of a patch is measured beside the gates** — files changed, lines
added and removed. Not a gate, because no number of files is the right one. It
is counted because the claim that model-level input bounds a refactoring is a
claim about extent, and this work's unguided run changed 38 files where its
guided ones changed 33 between them.

## Evidence

```text
java de.fhdo.lemma.servicedsl.smells.test.SmellDetectionTest
    160 check(s), 0 failed          # 28 before this branch
```

No database and no running Eclipse. The fixtures under `test/` carry what no
sample system has — TLS anywhere, a TLS broker, a callee with both kinds of
connector — because **neither Lakeside Mutual nor park-and-charge configures TLS
at all**, so the rule's negative case is fixture-only.
`test/fixtures/node-channels.services` adds a secured listener, a plaintext
listener, a listener whose transport the model does not state, and a plaintext
leg to a broker.

Live, against the generated baseline models:

```text
5 model(s) read.
11 finding(s), 0 protected, 0 encrypted but not mutually authenticated,
             0 not decidable from the models.
an unidentified peer -> RiskManagement (gRPC endpoint on 0.0.0.0:50051)
    the endpoint is bound without TLS, so it is reached over plaintext by
    whatever is on the network with it, and no reconstructed microservice
    calls it
RiskManagement -> the activemq broker (queue newpolicies over stomp)
    the service reaches the broker over stomp, which does not protect the channel
```

**Detecting a finding is not the same as being able to ask for its
resolution.** The gRPC endpoint went through three proposals unresolved because
it reached no model, hence no cause, hence no request — so checks that stop at
the report would have missed the gap that mattered. The last six checks follow
both Node causes to the end of the chain: one request per cause, the plaintext
listener's request valid and carrying its finding, and its prompt naming the
endpoint's address and the `GrpcServer` aspect it has to act on.

Every decision is defended by a mutation that turns it red:

| Decision | Reversed to | Checks that go red |
|---|---|---|
| a protected channel is cleared | report every call | 2 |
| the callee's connectors count | judge the caller's scheme alone | 2 |
| undecided is not secure | assume secure | 1 |
| a queue is judged once | judge both ends | 1 |
| a third party is not this smell | report it too | 1 |

## Merge Danger

**Door:** two-way for the detection. One-way for nothing here — the script
writes only inside throwaway worktrees and the target checkout it is pointed at.

**Blast Radius:** every recorded finding count, and `verify-refactoring.sh`

- **The finding count of this sample system changes from 9 to 11.** Any earlier
  record that quotes nine is now describing a detector that could not see two
  channels, which is why `3b0f0c52` rewrites the README's figure rather than
  leaving both numbers in circulation.
- **A proposal that breaks a channel and does not say so now fails gate 4.**
  That is the intent, and it means a previously passing patch can fail
  re-verification — one of the recorded ones does.
- **`LEMMA_SETTLE_SECONDS` defaults to a value tuned on this machine.** A slower
  one needs it raised, and a value too low makes the start gate report a peer
  that was merely still booting.
- The editor's validator judges two more aspects. A model carrying neither is
  unaffected; a model carrying one gets a warning where it previously got
  silence.

Worth stating rather than implying:

- **There is no CI in this repository.** The 160 checks were run by hand, with
  the Xtend compiled by the batch compiler, and so was the live detection.
- **The gate cannot decide which lost channel is acceptable**, only whether the
  loss was declared. Whether breaking a monitoring scrape is a fair price is the
  reviewer's call, and the next branch in this stack is what stops that call
  being hidden behind the word *passed*.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

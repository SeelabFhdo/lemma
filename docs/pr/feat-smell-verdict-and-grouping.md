## Summary

The shared rule learns to tell *mutual* TLS from TLS, and findings learn what
causes them.

```diff
 enum Outcome {
   SMELL
   PROTECTED
+  PROTECTED_NOT_MUTUAL     encrypted, peers not authenticated
   UNDECIDED
   NOT_APPLICABLE
 }
+RootCause.ofCall(callee) / ofQueue(broker, scheme)    9 findings → 2 causes
```

The rule judged **transport alone**, so TLS without client authentication read
as fully protected — and a verifier built on that would certify a weaker
refactoring than the paper cites. `PROTECTED_NOT_MUTUAL` is deliberately **not**
a finding: plain TLS does secure the channel, which is what §3.7 is about. It is
where §3.8 *Unauthenticated traffic* begins, and the hook for detecting that
smell from facts already reconstructed.

`clientAuth=want` counts as not mutual — it requests a certificate then serves
the request without one. Absent is Spring's `none`, and the reconstruction
records absence rather than defaulting it.

A `MessageChannel` carries no client-authentication fact, so a TLS queue stays
`PROTECTED`, not guessed at in either direction. The queue switch has the new
arm anyway, so adding the fact later is a change to the rule rather than a
silent fall-through.

**A call's cause is keyed by its callee, not its caller** — three services
calling one plaintext connector are one repair, and mutual TLS has to reach both
ends of every channel at once.

## Evidence

The warning also moves onto the aspect, with the repository's **first issue
code** (0 of 262 validator calls previously passed one) and issue data:

- **Before:** `PolicyManagement` showed five identical squiggles on its own name
- **After:** each unprotected channel underlines the line that states it, and a
  quickfix can tell which one it was invoked on

```console
$ SmellDetectionTest       48 check(s), 0 failed      # was 28
$ ServiceGraphTest         96 check(s), 0 failed
$ OperationGraphTest       60 check(s), 0 failed
$ ReconstructionRegressionTest   all 4 systems match
```

On Lakeside Mutual the CLI now computes what was previously an assertion:

```text
| Findings                | 9 |
| Root causes behind them | 2 |

### What has to change
- **the connectors of CustomerCore** — 3 finding(s)
- **the activemq broker, reached over tcp** — 6 finding(s)
```

**Mutation-tested, not trusted.** Treating non-mutual TLS as protected fails 4
checks; keying a call's cause by the caller fails 1.

The detector's `addMutualTlsNote` is **deleted**. It had grown its own mutuality
reasoning as an evidence string — exactly the drift the shared rule exists to
prevent — and now reads the fact and hands it to the verdict, as the validator
does.

## Merge Danger

**Door:** two-way. No persisted artefact changes shape.

**Blast Radius:** every service model opened in the editor, and the CLI's report format

- **The warning's location changes.** Anyone used to seeing it on the
  microservice name will find it on the aspect line. Still a warning, not an
  error: the model is not wrong, it faithfully describes a system that smells.
- **The CLI's report gains two rows and a section.** A script parsing
  `| Findings |` is unaffected; one parsing the whole table may not be.
- **A TLS-but-not-mutual channel stops counting as protected.** No system here
  has one, so no reported number moves — asserted by the suites rather than
  assumed — but a system that does will see its "protected" count fall and a new
  category appear. That is the point, not a regression.
- `tools/detect-smells.sh` had a real classpath defect found only by running it:
  it took the rule bundle from its prebuilt `bin/` and put fresh output last, so
  it type-checked the detector against the **old** rule. Fixed here.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

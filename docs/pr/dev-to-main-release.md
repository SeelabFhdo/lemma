## Summary

**`dev` into `main`, after three and a half years.** `main` last moved on
2023-03-24; `dev` carries 144 commits and 25 merges since, and nothing on `main`
is absent from `dev`.

```text
1 100 files changed, 36 884 insertions, 800 053 deletions
```

**Read the deletion figure before anything else.** 815 of those 1 100 files are
generated Xtext and Xtend output — `src-gen/`, `xtend-gen/`, `emf-gen/`, `bin/` —
which `main` still tracks and `dev` does not. `e19c466d` removed them on
2025-05-09 and `.gitignore` has covered them since. **No hand-written source is
deleted by this merge**; `main` is losing build output it should never have
carried, and anyone who had been reading those directories from a `main`
checkout must build the workspace in Eclipse instead.

What `main` gains, in the order it was built:

| Merged | What it added |
|---|---|
| #1, #2 | **Operation models** — the LEMMA side of the third reconstruction phase, and the technology models that go with it |
| #3, #4, #5 | **Communication aspects** — the transport of a channel as a declared aspect, deployment configuration, and service dependencies |
| #6, #7 | A protobuf fixture, and asynchronous communication corrected |
| #8, #9, #10 | **Three diagram families** — data, service and operation models rendered with PlantUML, each verified in Eclipse |
| #11 | **`ServerEndpoint`** — the ports a service answers on, as a non-single-valued aspect so a second connector is representable |
| #12, #13 | **Security smell detection** — §3.7 *Non-secured service-to-service communications* of Ponce et al. (2022), as a model validation and a command-line report, with findings grouped by root cause |
| #14, #15, #16 | **The refactoring machinery** — a prompt built from the models, a proposal recorded as a folder, and the four gates that decide whether it resolved anything |
| #17, #18 | Operation environments on `eclipse-temurin`, and a preference page for the refactoring |
| #19 | **Review and apply a proposal from the editor**, and the smell gate asking whether the addressed cause is gone rather than only whether the count fell |
| #20–#24 | **The Node channels** — two communication aspects declared, both judged, four verdicts instead of one, and the deployment coverage report |

The through-line: **MRF collects facts, LEMMA decides the smell** (MRF's
ADR-0009). This repository holds the judgement, and this release is the first
time that judgement exists on `main` at all.

### What the detection says now

```text
3 synchronous calls   CustomerManagement, CustomerSelfService, PolicyManagement → CustomerCore
6 queue channels      CustomerSelfService ↔ PolicyManagement (5), PolicyManagement → RiskManagement
1 gRPC endpoint       RiskManagement serves 0.0.0.0:50051 bound with createInsecure
1 leg to the broker   RiskManagement consumes newpolicies over STOMP
                      ─────
                      11 findings, 0 protected, 0 undecided, 0 services unjudged
2 deployment nodes    SpringBootAdmin and Proxy deploy no reconstructed
                      microservice, so no channel of theirs was judged
```

Eleven findings over four root causes, and **the last two were invisible until
the technology model declared an aspect for them** — the count was nine, and
nothing said two channels had not been looked at. The two deployment nodes are
reported as *potential unmodelled clients*, never as findings: nothing says they
communicate, only that the detection cannot see whether they do.

## Evidence

Run at this tip, with the Xtend compiled by the batch compiler:

```text
java de.fhdo.lemma.servicedsl.smells.test.SmellDetectionTest
    176 check(s), 0 failed

python3 ../de.fhdo.lemma.diagram.common/tools/check-bundle-requires.py .
    required: 14 bundles, 39 resolved with re-exports
    OK: every imported package is reachable through Require-Bundle
```

```text
tools/detect-smells.sh <models> --deployment <models>/operation
    5 model(s) read.
    11 finding(s), 0 protected, 0 encrypted but not mutually authenticated,
                 0 not decidable from the models.
    2 deployment node(s) deploy no reconstructed microservice
```

Every decision in the rule is defended by a mutation that turns it red — clear a
protected channel and 2 checks fail, judge the caller's scheme alone and 2 fail,
assume an undecided channel secure and 1 fails, judge both ends of a queue and 1
fails, report a third party and 1 fails.

The fixtures under `test/` carry what **no sample system has** — TLS anywhere, a
TLS broker, a callee with both kinds of connector — because neither Lakeside
Mutual nor park-and-charge configures TLS at all. So the rule's negative case is
fixture-only, and this release does not pretend otherwise.

### What this release does not claim

- **There is no CI and no headless build in this repository.** Every number
  above was produced by hand: the Xtend compiled with the batch compiler, the
  test run from the shell, the diagrams verified by opening them in Eclipse.
  `ReconstructionRegressionTest` is run the same way.
- **Nothing in `…servicedsl.ui` is covered by an automated test.** The headless
  suite stops at the `RefactoringProposer` seam by design, so the dialogs are
  covered by compilation and by having been run.
- **A gate cannot decide which lost channel is acceptable**, only whether the
  loss was declared. Mutual TLS on a service's actuator endpoints does stop an
  admin server that holds no client certificate from scraping them, and every
  proposal of this work does that.
- `de.fhdo.lemma.servicedsl.extractor`'s `build.properties` and its committed
  `.classpath` contradict each other on the output folder. Backlog E3, and it
  travels to `main` unfixed.

## Merge Danger

**Door:** one-way in the sense that matters — `main` is what other checkouts and
the upstream comparison take as the published state, and it has been still since
2023. A revert is a new commit, not an undo of what people have pulled.

**Blast Radius:** every `main` checkout of this workspace, and the diff against
upstream

- **815 generated files disappear from `main`.** A checkout that built from them
  without running Xtext's generator will not compile until the workspace is
  built in Eclipse. This is the single change most likely to surprise someone.
- **`upstream` is `SeelabFhdo/lemma` and this is a fork.** After this merge the
  fork's `main` diverges from upstream's by the whole of the work above; any
  future upstream sync is a merge rather than a fast-forward.
- **The technology models gained aspects**, additively. A model written against
  the previous `spring.technology` still parses; an aspect a technology model
  does not declare is still dropped silently, which is the behaviour the Node
  work had to work around rather than change.
- **`verify-refactoring.sh` exits 0, 4, 1 or 3** for REPAIR COMPLETE, REPAIR
  PARTIAL, GATE FAILED and NOT MEASURED. Any script wrapping it that treats
  "non-zero means broken" now treats a declared partial repair as a failure.
- **`LEMMA_SETTLE_SECONDS` defaults to a value tuned on one machine.** A slower
  one needs it raised, or the start gate reports a peer that was merely still
  booting.
- The editor now shows a warning on models carrying the communication aspects.
  A model carrying none is unaffected.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

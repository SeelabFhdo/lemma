## Summary

Three things a verification could not say, and now says.

**1. Where the detector's view ends.** "Services with no fact about a channel"
catches a service the reconstruction read and left without one. It does not
catch a client that has **no service model at all**, and Lakeside Mutual has
two: the monitoring server, which MRF skips as infrastructure, and an NGINX
load-balancing demonstration, which it does not read. Both are real clients of
the Customer Core's connector — the proposal given the sources secured them, the
one given only the models did not, and no count of facts said anything about
either.

```sh
tools/detect-smells.sh <models> --deployment <models>/operation
```

```text
2 deployment node(s) deploy no reconstructed microservice, so no channel of
  theirs was judged:
    `SpringBootAdmin` — infrastructure node, SpringBootAdmin, eclipse-temurin:21-jre
    `Proxy` — infrastructure node, Proxy, nginx
```

`DeploymentCoverage` compares the operation models, read with the existing
`OperationModelReader`, against the service models. **These are not findings.**
Nothing there says such a node communicates at all, let alone insecurely; it
says the detection cannot see whether it does — which is what a report has to
admit rather than imply by silence. The option is optional because the detection
does not need a deployment to judge anything; it needs one to state where it
stops.

**2. That a declared loss is not a clean repair.** The declared-loss rule stops
gate 4 failing every correct patch, but it made two different results read
alike: rc1 loses the monitoring scrape and declares it, the facts-withheld
ablation loses nothing, and **both printed the same word**. Four verdicts now:

```text
REPAIR COMPLETE   every gate passed and no peer was lost          exit 0
REPAIR PARTIAL    every gate passed, a peer is gone and was declared   exit 4
GATE FAILED       a gate failed                                   exit 1
NOT MEASURED      a gate was skipped, which is not a gate that passed  exit 3
```

Declaring a loss is what keeps a patch from *failing* gate 4. It is not what
makes the repair *complete*. `RecordedProposal` reads the new words, still
accepts `GATES PASSED` and `VERIFIED` from records written before the rename,
and reports the distinction through `isPartialRepair` — so the editor can show
it without re-running anything.

**3. What test coverage a patch gives up.** `test coverage lost:` is read from
the proposal's own `REFACTORING-NOTES.md`, by sentence rather than by line,
because the notes are wrapped prose. **Nothing detects it**: a proposal that
declares nothing reads `none declared`, which is a statement about the notes and
not about the tests, and the record says so in those words.

And a recipe the skill was missing: the **gRPC endpoint** became a cause of its
own once its transport was reconstructed, and the guided path would otherwise
have been asked to resolve the one cause with no recipe while every other cause
had one. The recipe says what the detection actually reads — the third argument
of `ServerCredentials.createSsl` is what makes the channel mutual, reported as
`GrpcServer.clientAuth`, so TLS without it stays distinguishable from the
refactoring the paper prescribes — and what no gate here can see, namely that
the caller is not in `docker-compose.yml`, so the build and the human review
carry the client half.

### Two defects the first real runs exposed

| | What it did | Fixed by |
|---|---|---|
| The coverage statement was cut at a fixed length | Records read `"…without opening a network socke"` | the limit stays, the cut moves to the last space, and `[...]` says it was cut |
| The declaration was read from the **tree** | rc4 is applied on top of rc1 and rc2, and `REFACTORING-NOTES.md` is cumulative there, so rc4 was credited with the in-VM transport **rc2** declared — while rc4's own notes say the two Node projects have no test suite at all | the field reads the lines the **patch** adds to that file |

Measured over the six records after the fix: rc2 and rc3 declare the in-VM
transport; rc1, rc4 and both ablations declare nothing.

## Evidence

```text
java de.fhdo.lemma.servicedsl.smells.test.SmellDetectionTest
    176 check(s), 0 failed          # 160 before this branch

python3 ../de.fhdo.lemma.diagram.common/tools/check-bundle-requires.py .
    required: 14 bundles, 39 resolved with re-exports
    OK: every imported package is reachable through Require-Bundle
```

Live, against the generated baseline models, with the deployment compared:

```text
5 model(s) read.
11 finding(s), 0 protected, 0 encrypted but not mutually authenticated,
             0 not decidable from the models.
…
2 deployment node(s) deploy no reconstructed microservice, so no channel of
  theirs was judged:
    `SpringBootAdmin` — infrastructure node, SpringBootAdmin, eclipse-temurin:21-jre
    `Proxy` — infrastructure node, Proxy, nginx
```

**The eleven findings and four causes are unchanged** — adding the coverage
question answers it without moving a single judgement, which is the point:
coverage is reported beside the findings, never mixed into them.

`MANIFEST.MF` gains one import, for the operation-model reader the coverage
check uses; `check-bundle-requires.py` is what confirms the new import is
reachable through `Require-Bundle` rather than only on the IDE classpath.

### One correction this branch carries

The bundle README said **167 checks** where the suite reports **176**. The
figure was stale by the nine checks the coverage-declaration work added, and a
stale check count is the one number in a README that a reader can falsify in a
second.

## Merge Danger

**Door:** two-way. One new class, four extended, one script, one skill
reference.

**Blast Radius:** the exit status of `verify-refactoring.sh`, and every recorded
verdict

- **Exit 4 is new.** A caller that treated any non-zero status as failure now
  treats a partial repair as one; a caller that treated only 1 as failure now
  misses nothing, because 3 and 4 were already not success. Any script wrapping
  this needs reading once.
- **Two of the five proposals of this work move from "passed" to REPAIR
  PARTIAL.** Nothing about them changed; what changed is that the verdict no
  longer hides the loss. The records are append-only, so the earlier wording
  stays visible beneath the new one.
- **`--deployment` is opt-in** and reads operation models with a reader that
  already existed. Without it the detection behaves exactly as before, and
  `SmellReport.write` keeps its two-argument form.
- A node that deploys nothing at all is reported as a potential unmodelled
  client too. That is deliberate — the detection cannot tell an empty node from
  an unread one — and it means the count is an upper bound on blind spots, not a
  list of clients.

Worth stating rather than implying:

- **There is no CI in this repository.** The 176 checks, the bundle check and
  the live detection were run by hand, with the Xtend compiled by the batch
  compiler.
- **`test coverage lost:` is as honest as the notes it reads.** A proposal that
  silently changes what transport a test exercises still passes every gate; the
  prompt asks for the declaration and this field reports whether one was made,
  which is a weaker claim than detection and is written as one.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

## Summary

Everything between a finding and a verdict: the proposer, the quickfix that
offers it, and the gate that decides whether it worked.

```text
…smells/refactoring/
├── RefactoringRequests   one request per cause, told what the others are
├── PromptBuilder         invariant constraints + the finding; deterministic
├── RefactoringProposer   ── the seam ──
│   ├── ClaudeCliProposer   worktree, CLI, diff; no decisions
│   └── RecordedProposer    a canned patch, for the suite
├── PatchGuard            instruction checked, not trusted
├── ProposalRecord        the artefact folder ADR-0010 requires
└── Preconditions         refuse before spawning, and name the condition

…servicedsl.ui/quickfix/   @Fix → background Job → patch on disk
…smells/tools/verify-refactoring.sh   four gates
```

**It proposes; it never applies.** The smell is in the system, not the model, so
a fix that edited the model would only stop the model describing the system —
and the next reconstruction truncates it anyway (ADR-0010). `Ctrl+1` offers
*"Propose mutual TLS for the connectors of CustomerCore (AI — review required)"*,
and the label says so because a nondeterministic proposal presented as a fix
would misstate what happened.

The fix acts on the **cause**, not the clicked channel: clicking any of
CustomerCore's three callers proposes for all three.

## Evidence

```console
$ SmellDetectionTest       108 check(s), 0 failed      # 28 when this work began
$ ServiceGraphTest          96 check(s), 0 failed
$ OperationGraphTest        60 check(s), 0 failed
$ ReconstructionRegressionTest    all 4 systems match
$ all 7 bundles compile at --release 11
```

End to end on Lakeside Mutual, measured:

```text
baseline: 9 finding(s)
PASS  clean    applies to a clean checkout and builds there
PASS  inplace  builds once key material exists
PASS  smell    findings fell from 9 to 0
PASS  starts   the system comes up with the patch applied
VERIFIED — 4 passed, 0 failed, 0 skipped
```

**`clean` and `inplace` are separate on purpose**, and running them proved why:
the two proposals differ on exactly that axis and nothing else distinguished
them. A single build gate would have called them equal.

**Each gate that can be confounded has a control.** `smell` takes a baseline;
`starts` runs an *unpatched* control on failure. That second one was added after
the gate produced a **false finding** — it blamed a patch for a system that does
not start unpatched either, because `openjdk:21-slim-buster` has been withdrawn
from Docker Hub.

Four operational facts are built in rather than remembered:

- **`is_error` decides, not `subtype`** — a usage limit returns
  `subtype: "success"` with `is_error: true` and no edits
- the allowlist carries **`bash` and `chmod`**, or the model cannot run the
  script it just generated
- the patch is **staged before diffing**, so created files are in it
- `PatchGuard` scans **added lines only, and not prose** — it rejected a correct
  patch for documenting the constraints it had honoured

## Merge Danger

**Door:** two-way for the code. **One-way for anything it writes.**

Nothing here applies a patch, so the reversible part is total. But a proposal
spawns a subprocess that costs **$6–11 and 13–25 minutes**, and the verify gate
builds nine Docker images.

**Blast Radius:** a new external dependency, and every `.services` editor

- **The `claude` CLI becomes a dependency**, which must be installed and
  authenticated. The quickfix refuses before spawning anything when it is not,
  naming the condition.
- **The source root must be configured.** A model carries no source paths by
  design, so this is the one thing that cannot be inferred; the quickfix refuses
  and names the preference.
- **The UI bundle gains four `Require-Bundle` entries**, including
  `org.eclipse.core.runtime` and `…resources` stated explicitly rather than
  inherited — the first bug in this whole effort was a missing `Require-Bundle`
  the headless build cannot see.
- **`de.fhdo.lemma.servicedsl.smells` exports a new package.**

Two honest limits:

- **The quickfix has never run in a live Eclipse.** It compiles against the real
  Xtext and Eclipse APIs, but that the entry appears under `Ctrl+1`, that issue
  data arrives in the order the validator writes it, and that the Job reports as
  intended are **unverified**. It needs launching, as the diagram bundles did.
- **The gate is generic in structure and was specific in configuration.**
  `--plugins` and `--build-command` are now options; what remains specific is the
  default Maven walk, `docker-compose.yml` at the root, and the certificate
  script's name pattern — all of which now **skip with a reason rather than
  passing**. A non-Maven system used to report `PASS` without building anything.

**Merge order:** this branch contains `feat/smell-verdict-and-grouping`'s commit,
so that branch goes **first** — or merge this one alone and the other becomes a
no-op. It also expects `feat/resolve-smell-skill`, without which the proposer
runs on its constraints alone.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

# Resolving the non-secured communication smell

How to detect security smell **§3.7, Non-Secured Service-to-Service
Communications** (Ponce et al. 2022) in LEMMA service models, propose a
refactoring for it, and decide whether the refactoring worked — from the
Eclipse editor or from a shell.

Measured end to end on Lakeside Mutual: **9 findings → 0**, with the system
still running.

## What this does, and what it does not

| | |
|---|---|
| Detects the smell | deterministically, from the models |
| Proposes a refactoring | with an AI, in a throwaway copy of your sources |
| **Applies the refactoring** | **never.** You get a patch and apply it yourself |
| Decides whether it worked | by re-reconstructing and re-detecting |

**Nothing writes to your source tree.** A proposal is produced in a
`git worktree` of the commit you point it at; the worktree is removed
afterwards and the result is a `patch.diff` on disk. This is not caution, it is
the condition on which ADR-0010 admits an AI into the toolchain at all: the
model is a *reconstruction*, so a fix that edited the model would only make the
model stop describing the system.

## Prerequisites

| | Needed for |
|---|---|
| MongoDB (`docker start mrf-mongo`) | reconstruction |
| MRF checked out, `uv` installed | reconstruction |
| Eclipse DSL with the LEMMA bundles | the editor route, and the shell tools' classpath |
| `claude` CLI, installed and authenticated | proposing |
| Docker | the *system starts* verification gate |

Detection needs none of the AI parts. You can stop after detection.

---

# Route A — from the Eclipse editor

## A1. Start Eclipse so it can see the CLI

**This is the step that otherwise wastes an afternoon.** A desktop application
does not inherit your shell `PATH`: on macOS one started from the Dock sees
only `/etc/paths`, so a tool under `/opt/homebrew/bin` is invisible to it. A
runtime workbench inherits from whatever started the IDE, so a Dock-started IDE
passes the Dock's `PATH` down.

Any one of these fixes it:

- give the **absolute path** in the preferences (A2) — no restart needed
- start Eclipse from a terminal:
  `"/Applications/Eclipse DSL.app/Contents/MacOS/eclipse" &`
- `sudo ln -s "$(which claude)" /usr/local/bin/claude` — `/usr/local/bin` *is*
  in `/etc/paths`, so this fixes every GUI application at once

## A2. Configure it once

**Window → Preferences → ServiceDsl → Security Smell Refactoring**

| Field | |
|---|---|
| **Source root** | the git checkout the open models were reconstructed from. **Required** — a model carries no source paths, so this cannot be inferred |
| Command line | `claude`, or its absolute path (see A1) |
| Model | recorded with every proposal |
| Give up after | 45 minutes by default; runs take 13–25 |
| Keep proposals in | empty → beside the source root |

Preferences are per workspace. Set them in the **runtime** workbench, not in
the IDE you launched it from.

## A3. Find a finding

Open a `.services` model. Warnings appear **on the aspect lines**, not on the
microservice name:

```text
@javaWithSpring::_aspects.ServiceCall(target = "CustomerCore", …)
⚠ Non-Secured Service-to-Service Communications (Ponce et al. (2022) §3.7):
  the call to CustomerCore is not secured - the call uses http, which does not
  protect the channel. Suggested refactoring: Use Mutual TLS -
  the connectors of CustomerCore need it.
```

## A4. Invoke it

`Ctrl+1` on a warned line offers, for example:

> **Propose mutual TLS for the connectors of CustomerCore (AI — review required)**

It returns immediately. A background job runs for 13–25 minutes, then reports
where the patch was written. **It acts on the cause, not the line you clicked**
— picking any of CustomerCore's three callers proposes for all three, because
mutual TLS needs both ends of every channel.

## A5. What you get

```text
<date>-<cause>-<timestamp>/
├── request.md       what was asked
├── constraints.md   the invariant rules
├── skill.md         the refactoring procedure, verbatim
├── patch.diff       the proposal — applied nowhere
├── notes.md         the AI's own account, including what it could not verify
├── model.txt        model, CLI version, turns, duration, cost, commit SHAs
└── result.json      the CLI's raw output
```

Read `notes.md` first: its *"what could not be verified"* section is usually
the most informative part. Then verify (section C).

---

# Route B — from a shell

## B1. Reconstruct and generate

```sh
docker start mrf-mongo

cd <mrf>
uv run mrf -r -p Java Spring Communication Docker Protobuf Node -t <system>

cd <lemma>
de.fhdo.lemma.reconstruction/tools/reconstruct.sh --target <models>
```

`-r` matters: MRF upserts on `qualified_name` and never clears its target, so
without it a stale document survives a run that no longer produces it.

## B2. Detect

```sh
cd <lemma>/de.fhdo.lemma.servicedsl.smells
tools/detect-smells.sh <models> --report smells.md
```

Exit **1** findings · **0** none · **2** nothing readable. The report leads with
*what has to change* — the findings grouped by root cause, which is the list of
repairs rather than the list of symptoms.

## B3. Propose — by hand

**There is no command-line entry point for proposing.** The quickfix is the
only wiring, so from a shell you run the CLI yourself. This is exactly what the
Eclipse route does internally:

```sh
# a throwaway copy, so your tree is never touched
git -C <system> worktree add --detach /tmp/proposal HEAD

cd /tmp/proposal && claude -p \
  --model claude-opus-5 \
  --add-dir /tmp/proposal \
  --plugin-dir <lemma>/de.fhdo.lemma.servicedsl.smells/refactoring-plugin \
  --allowedTools "Read,Edit,Write,Grep,Glob,TodoWrite,Bash(./mvnw:*),Bash(keytool:*),Bash(openssl:*),Bash(bash:*),Bash(chmod:*),Bash(npm:*),Bash(node:*),Bash(git diff:*)" \
  --permission-mode acceptEdits \
  --output-format json \
  < request.md > result.json

# the patch, including files the proposal created
git -C /tmp/proposal add -A
git -C /tmp/proposal diff --cached --binary > patch.diff
git -C /tmp/proposal reset
git -C <system> worktree remove --force /tmp/proposal
```

Write `request.md` yourself: name the smell, the root cause, the findings it
covers, the evidence as the models state it, and what is **out of scope**. Tell
it to use the skill `lemma-smell-refactoring:resolve-non-secured-communication`.

Two traps worth knowing before you read `result.json`:

- **`is_error` decides, not `subtype`.** A usage limit returns
  `subtype: "success"` with `is_error: true` and no edits.
- The allowlist must include **`bash` and `chmod`**, or the AI cannot run the
  certificate script it generates and ships it without the executable bit.

---

# C. Verify — the step that makes a patch evidence

```sh
cd <lemma>/de.fhdo.lemma.servicedsl.smells
tools/verify-refactoring.sh \
    --proposal <proposal-folder> \
    --source <system> \
    --models <models> \
    --mrf <mrf> \
    [--base <ref>] [--plugins "<list>"] [--build-command "<cmd>"]
```

Four gates, all of which must pass:

| Gate | |
|---|---|
| `clean` | the patch applies to a clean checkout and the build is green **with no generated key material** |
| `inplace` | the build is green once the material is generated |
| `smell` | **the finding count fell**, against a baseline taken first |
| `starts` | the system still comes up |

Verdict is `VERIFIED` · `PARTIAL` · `NOT VERIFIED`, with exit codes 0 · 3 · 1,
and it is appended to `verification.md` in the proposal folder.

**`clean` and `inplace` are separate on purpose.** A patch whose tests read a
key store from disk passes the second and fails the first — nothing but a
clean-room build finds it.

**A skipped gate is not a passed one.** `PARTIAL` means the refactoring has not
been shown to resolve the smell, only that nothing checked contradicts it.

Useful options:

- `--base <ref>` — the commit the patch is measured against. Needed when the
  patch depends on a prerequisite
- `--plugins "<list>"` — the MRF selection for *your* system. **Getting this
  wrong is the one mistake the script cannot catch**: the `smell` gate would
  compare a baseline against a reconstruction of a different fact set and still
  print a number
- `--build-command "<cmd>"` — for a system that is not per-service Maven.
  Without it, a system with nothing recognisable to build **skips** the build
  gates rather than passing them

---

# D. Resolving more than one cause

Findings group by cause, and **a cause is the unit a refactoring acts on**. On
Lakeside Mutual nine findings come from two: one microservice's plaintext
connector, and one broker reached over `tcp://`.

**Resolve them in sequence, not in parallel.** Two proposals generated
independently against the same commit **do not compose** — measured: they
overlapped in five files and each invented its own CA and certificate script.

So:

1. propose for cause 1, verify, and **commit** it to a branch
2. point **Source root** at that branch
3. propose for cause 2 — `Ctrl+1` on a *queue* warning, labelled
   *"the activemq broker, reached over tcp"*
4. verify the combined result

Told what the first proposal established, the second extends its certificate
infrastructure instead of duplicating it. That is how **9 → 0** was reached.

---

# E. When it goes wrong

| Symptom | Cause |
|---|---|
| `Cannot run "claude"` | `PATH`. See A1. The message quotes what it tried, so a bare `claude` means the preference is not in use |
| *No source root is configured* | not set, or set in the wrong workspace. The dialog offers to open the page |
| *the skill could not be located* | `refactoring-plugin/` missing from the launched bundle |
| No quickfix in `Ctrl+1` | the warning is on the **aspect line**, not the microservice name |
| `the proposer changed nothing` | usually a usage limit — check `is_error` in `result.json`. The work may be resumable with `claude --resume <session-id>` |
| `starts` gate always skips | the system does not come up unpatched either. The gate refuses to blame the patch for that |
| Findings unchanged after applying a patch | the models still describe the old sources. Re-run B1 |

## Known limits

- **Only §3.7.** The other nine smells of the paper have no detection.
- **Only application-level configuration.** A service-mesh refactoring is
  excluded because MRF does not read Kubernetes manifests, so it could not be
  verified.
- **Mutuality is not assessable for a queue.** A `MessageChannel` carries no
  client-authentication fact, so a TLS broker is reported protected without a
  claim about mutuality.
- **Proposals are not reproducible.** Detection is. Every proposal is recorded
  instead — prompt, skill, patch, model, cost, commit SHAs.
- **A proposal costs $6–11 and 13–25 minutes** at the models used so far.

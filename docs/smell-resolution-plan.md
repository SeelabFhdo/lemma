# Resolving the non-secured communication smell

Plan for an Eclipse quickfix that resolves security smell **Non-Secured
Service-to-Service Communications** (Ponce et al. 2022, §3.7) by having an AI
author a patch against the reconstructed system, which the toolchain then
verifies. Decided with Philip Wizenty on 2026-10-13; every choice his answers
settled is marked **[decided]**. The decision itself is recorded as
**ADR-0010** in the MRF repository.

## 1. What is being built

Detection exists: `ChannelVerdict` judges a channel, `NonSecuredCommunicationValidator`
warns in the editor, `SmellDetectionCli` reports from the command line, and on
Lakeside Mutual both paths agree on **9 findings** across 5 microservices.

What does not exist is the fourth step ADR-0009 named: turning a finding into a
refactoring. This plan builds it, and the single most important thing it builds
is a *boundary*:

| | |
|---|---|
| The quickfix | proposes a patch, and never applies one |
| The verify step | decides whether the proposal worked |
| The model | is never edited, in either step |

## 2. Decisions

**"Resolve" means an AI implements the refactoring the paper prescribes**
**[decided]**, not a model edit. A quickfix that rewrote `scheme = "http"` to
`"https"` would make the model contradict the system, and
`ReconstructionModelWriter` would truncate the edit on the next reconstruction
anyway - all three of its write methods use plain `Files.write`, i.e.
`TRUNCATE_EXISTING`, with no merge, prompt or protected region.

**The output is a reviewable patch; the sources are never written directly**
**[decided]**. The AI works in a throwaway `git worktree` of the source
repository at `HEAD`, and the patch is `git diff` of that worktree. This also
removes any need for a clean source tree - a worktree materialises the commit,
so uncommitted work in the sample system is simply invisible to the run.

**Resolution is application-level configuration only** **[decided]**, never a
service mesh. Not a preference: MRF does not read `kubernetes/manifests`
(backlog A4), so a mesh change would leave the finding count unmoved and make
success indistinguishable from failure.

**One invocation covers a root cause, not a channel** **[decided]**. Lakeside
Mutual's 9 findings reduce to 2 root causes, and mutual TLS needs both ends of
a channel anyway, so a per-channel fix would be both repetitive and incoherent.

**No quickfix is offered on an `UNDECIDED` channel** **[decided]**. Undecided
means the models do not say; letting an AI change code there would launder a
gap in the reconstruction into a source edit.

**A proposal counts only when verified** **[decided]**, and verification
requires all four of: the finding count dropped, the build green **on a clean
checkout of the patch**, the build green in place, **and the system starts**.
The third and fourth are load-bearing - see §5 and §7.

**The AI sits strictly downstream of deterministic detection** **[decided]**.
Detection stays reproducible; resolution is explicitly not part of the
reproducible pipeline, and every proposal is recorded instead.

## 3. The constraint that shapes the implementation

**The model has been deliberately stripped of what the AI needs.** A generated
`.services` model contains no source path at all - the `ServiceCall`,
`ServerEndpoint` and `MessageChannel` aspects carry no `file`, `line` or
`valueSource`, because those are absolute paths and a generated model has to be
identical on every machine. MongoDB *does* hold them, exactly.

So the decision that made models reproducible is the decision that blinds a
model-side quickfix to the code it must fix. Both choices were right; they
collide here.

**Resolution** **[decided]**: the source root is an Eclipse preference, the AI
is handed the channel facts from the model, and it locates the files itself. No
MongoDB client is added to an OSGi bundle, and no model/database staleness
problem arises. Imprecision is self-correcting: if the AI edits the wrong
thing, the finding count does not drop.

**The second constraint is that MRF must be able to see the change**, which is
what fixes the definition of done in §5 to MRF's own recognition rules.

## 4. How the AI is instructed

Three layers, each varying at a different rate **[decided]**:

| Layer | Mechanism | Varies | Enforced |
|---|---|---|---|
| Invariant constraints | `--append-system-prompt-file` | never | yes, and by verification |
| The refactoring procedure | **a skill** | once per smell | no - instruction only |
| The finding | stdin prompt | every call | n/a, it is data |

The split matters: a skill can be ignored, so nothing load-bearing may depend on
it. "Remove the plaintext connector" belongs in the system prompt and is
ultimately settled by the verify step.

**One skill per smell** **[decided]**, but only §3.7's is written now - it is the
only smell that can be detected, so the only one with findings to act on. Named
action-first with the section cited in its description, matching the MRF
convention (`write-adr`, `add-golden-fixture`):

```
de.fhdo.lemma.servicedsl.smells/refactoring-plugin/
├── .claude-plugin/plugin.json
└── skills/resolve-non-secured-communication/
    ├── SKILL.md                      # cites Ponce et al. (2022) §3.7
    └── references/                   # spring-rest, activemq-openwire,
                                      # activemq-stomp, keytool
```

A plugin directory rather than a plain `.claude/skills/` folder, because a
repository-root skills folder only auto-loads when the working directory *is*
that repository - and here it will be a worktree of the sample system.
`--plugin-dir` injects it for the one session. It is additionally symlinked
into LEMMA's `.claude/skills/` **[decided]** so the skill can be iterated on
from a terminal without an Eclipse round trip.

Invocation:

```bash
cd <worktree> && claude -p \
  --model <pinned, configurable> \
  --add-dir <worktree> \
  --plugin-dir <…>/refactoring-plugin \
  --allowedTools "Read,Edit,Write,Grep,Glob,Bash(./mvnw:*),Bash(git diff:*)" \
  --permission-mode acceptEdits \
  --output-format json \
  --append-system-prompt-file constraints.md \
  < request.md
```

`acceptEdits` scoped to a throwaway worktree, never
`--dangerously-skip-permissions`. The build is allowed **[decided]** so the AI
catches its own compile and config errors before the patch is ever reviewed.

Two things step 2 established about this invocation. **`--output-format json`
buffers everything until the process exits**, so the background Job should use
`stream-json` instead if the quickfix is to show progress rather than sit
silent for the ten to twenty-five minutes a proposal takes. And **a hit usage
limit returns `subtype: "success"` with `is_error: true`** - so the machinery
must test `is_error`, or it will file an empty patch as a successful proposal.
The allowlist also has to include `bash` and `chmod`: without them `rc1` could
not run its own generated script and committed it without the executable bit.

## 5. The two root causes, and done

Expressed in MRF's recognition rules, so that "the AI believes it is finished"
and "the toolchain measures it as finished" cannot drift apart:

| Root cause | Covers | Done when MRF reconstructs |
|---|---|---|
| **RC-1** `CustomerCore`'s connector | `CustomerCore` + its 3 callers (Feign, 2× RestTemplate) | every `ServerEndpoint` with `tlsEnabled = true` and `clientAuth = need`; all three `ServiceCall` with `scheme = "https"` |
| **RC-2** the embedded ActiveMQ broker | the broker, 2 Java producers, 1 Node consumer | a connector scheme in `{ssl, stomp+ssl}` with **no plaintext connector left**; Java `broker-url` on `ssl://`; `stompit` on TLS |

Three traps the paper's text would never reveal, all of which belong in the
skill's pitfalls section:

- **Least protected wins.** `broker_of` takes the least protected connector, so
  adding `ssl://` beside the existing `tcp://` clears nothing. The plaintext
  connector has to go.
- **This broker has two plaintext connectors, not one.**
  `MessagingConfiguration` adds `stomp://0.0.0.0:61613` *and*
  `tcp://0.0.0.0:61616`. The Java clients use OpenWire; `risk-management-server`
  is Node and uses `stompit` over STOMP, configured from `config.json`.
- **TLS without `client-auth` is not mutual TLS.** It would clear the finding
  while implementing something weaker than §3.7 cites - which is why
  `ChannelVerdict` gains a fifth outcome.

The Node consumer is included **[decided]** even though it contributes no
finding of its own: switching the broker to TLS while leaving `stompit` on
`stomp://` would clear six findings and leave the system unable to run. That is
the exact failure mode the "system starts" verification condition exists to
catch.

**Certificates** **[decided]**: the patch includes a committed `keytool` script
that generates development certificates; the generated key material itself is
gitignored. Without it the patched system cannot start, and the verify loop
would degrade into a check that configuration text changed.

## 6. Structure

| Where | What |
|---|---|
| `…smells.validation` | a fifth `Outcome` (TLS but not mutual), the first issue code in the repository, the warning re-anchored onto the aspect with issue data, and root-cause grouping shared with the CLI |
| `…smells` | the refactoring machinery: prompt builder, `RefactoringProposer` behind an interface, patch and record writer, and the skill plugin |
| `…servicedsl.ui` | the `@Fix` method, one new `Require-Bundle` entry, the source-root preference |
| MRF `refactorings/` | one artefact folder per proposal |

The `@Fix` runs on the UI thread, so the CLI is spawned from a background
Eclipse `Job` **[decided]**; the quickfix returns immediately and notifies when
the patch is ready. Its label names the AI and the scope **[decided]**, e.g.
*"Propose mutual TLS for CustomerCore and its 3 callers (AI — review required)"*.

`RefactoringProposer` is an interface so the CLI can be faked in headless tests
**[decided]**: grouping, prompt construction and patch handling stay
deterministically covered, and the only untested class spawns a process and
contains no logic.

Each artefact folder holds the request, the constraints, **a verbatim copy of
the skill**, the model ID and CLI version, both repositories' commit SHAs, the
patch, and the verification result **[decided]**. The copy is what makes the
record readable without checking out two repositories at the right revisions.

Preconditions are checked before anything is spawned, and a failure changes
nothing, names the cause and prints the manual command **[decided]**: CLI
absent or unauthenticated, no source root configured, source root not a git
repository, or the root cause not resolvable from the model.

## 7. Steps

1. ADR-0010 in MRF and this plan — **done**
2. The skill and its references, symlinked for manual use. Provable from a
   terminal against a worktree, with no Eclipse work at all
3. `ChannelVerdict`'s fifth outcome, the coded and re-anchored warning, and
   root-cause grouping — then re-run all four suites
4. The refactoring machinery in `…smells`
5. The `@Fix` and the source-root preference in `…servicedsl.ui`
6. The verify script: branch, apply, reconstruct, detect, compose health check.
   Four gates, and **"builds in the working tree" and "builds on a clean
   checkout" are separate ones** - a patch whose tests read generated key
   material passes the first and fails the second. Measured in step 2: `rc2`
   satisfied every other criterion and still produced
   `FileNotFoundException: ../certs/policy-management-backend.p12`,
   `BUILD FAILURE`, when applied to a fresh worktree. Nothing but a clean-room
   build found it - not the proposal's own notes, not any constraint check
7. A TLS-positive fixture, for the case where there is nothing to resolve

**All seven are done.** What the last four established, beyond compiling:

| | |
|---|---|
| Step 3 | 9 findings reduce to 2 causes, computed rather than asserted |
| Step 4 | the AI sits behind one interface; 91 checks cover everything else |
| Step 5 | the quickfix compiles against the real APIs, but has **not** been exercised in a running Eclipse |
| Step 6 | **rc1 verifies PARTIAL: findings fell from 9 to 6** |
| Step 7 | the clean verdict exists at all, which no sample system could show |

The 9-to-6 reduction is the result this plan exists to produce, and it is the
predicted one: `rc1` resolves the three synchronous findings and leaves the six
asynchronous ones, which are `rc2`'s cause.

Two limits stand. The *system starts* gate can only skip until Lakeside
Mutual's Dockerfiles leave `openjdk:21-slim-buster`, withdrawn from Docker Hub
(MRF backlog E5), so **no refactoring can reach a full VERIFIED verdict here**.
And the quickfix itself needs launching in Eclipse before anyone should believe
the `Ctrl+1` entry appears.

**Step 2 is the one that matters first.** If the AI cannot produce a working
mutual-TLS patch for Lakeside Mutual, that is known before any of steps 3-7 is
paid for - and it is the question the whole feature rests on.

**Step 2 is done, and the answer is yes.** Both root causes were run against a
worktree of Lakeside Mutual on 2026-10-13, recorded under `refactorings/` in
the MRF repository:

| | rc1 CustomerCore | rc2 ActiveMQ broker |
|---|---|---|
| Turns / duration / cost | 144 / 25 min / $10.62 | 100 / 13 min / $6.55 |
| Patch | 17 files, applies clean | 12 files, applies clean |
| Constraints | none violated | none violated |
| Mutual, not merely TLS | `client-auth=need` | `needClientAuth=true`, both connectors |
| Suite in the worktree | 26 pass | 19 pass |
| Suite on a clean checkout | passes | **fails** - see step 6 |

Three findings worth carrying forward. `rc1` handled **Spring relaxed binding**
in `docker-compose.yml`, which MRF cannot yet resolve (backlog A3), so the
patch was more complete than the toolchain could verify. `rc2` converted both
plaintext connectors rather than supplementing them, which is the pitfall the
skill was written for and the one most likely to yield a patch that clears
findings while changing nothing. And the two proposals **disagreed** about
whether the build may depend on generated key material - the skill now settles
it.

Step 3 changes code merged on 2026-10-13, so the CLI's report format moves with
it and the 28 / 96 / 60 checks plus the reconstruction regression all have to be
re-run.

## 8. Deliberately not in this plan

- **The other nine smells.** One skill per smell is the shape, but only §3.7 is
  detectable, so the rest would be unexercised files.
- **§3.8 Unauthenticated traffic**, even though the fifth outcome is exactly its
  hook. Its detection does not exist yet.
- **Service-mesh refactoring**, until MRF reads manifests (backlog A4).
- **Applying a patch from the IDE.** The verify script applies it to a dedicated
  branch **[decided]**; git already does this well and nothing reaches `master`.
- **Any change to the Technology DSL.** Since the patch targets source
  configuration and no model is edited, no secured protocol and no new aspect
  are needed - `spring.technology`'s lack of a TLS-bearing protocol is moot.

## 9. What could make this fail

- **Mutual TLS between containers with generated development certificates** is
  the hardest practical part, and the "system starts" condition puts it on the
  critical path rather than at the edges.
- **Nondeterminism is contained, not solved.** No claim about a refactoring is
  admissible without its before/after counts and a green regression.
- **A skill is advice.** If the pitfalls in §5 turn out to be ignored in
  practice, they have to move into the system prompt or into a pre-flight check
  on the patch, not be restated more loudly in the skill.

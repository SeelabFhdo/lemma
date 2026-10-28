## Summary

**A proposal can now be read and applied from the editor.** Until this branch
it was a folder path in a notification: to see what it would change you opened
669 lines of unified diff in a text editor, and to apply it you typed git
commands.

```text
notification ──► [ Review… ]
LEMMA ▸ Security Smells ▸ Review a Proposal...     (any proposal, any time)
              │
              ▼
┌─ cause · files · base commit · target · model · its own notes ──────┐
│ ⚠ Not verified. A patch is not evidence that the smell is resolved. │
│   [ Show the changes… ]  [ Verify… ]  [ Apply… ]  [ Close ]         │
└─────────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─ Apply 13 file(s) to the checkout ──────────────────────────────────┐
│ Target: …/LakesideMutual     Base: ef73ae1                          │
│ ☑ Commit to branch refactoring/endpoint-customercore                │
│ ☑ Run generate-certificates.sh                                      │
└─────────────────────────────────────────────────────────────────────┘
```

The split is the usual one, and it is what makes any of this testable:

```text
de.fhdo.lemma.servicedsl.smells/…/refactoring/
├── ProposalApplication   # the judgements — no git, no files, no UI
├── RecordedProposal      # reads a proposal folder back, without its session
└── ProposalApplier       # does what was decided; contains nothing to argue about

de.fhdo.lemma.servicedsl.ui/…/quickfix/
├── ReviewProposal        # one entry point, both routes
├── ReviewProposalDialog  # says NOT VERIFIED where it is read
├── ProposalCompareInput  # Eclipse's compare viewer, before and after
└── ApplyProposalDialog   # what will happen, before it happens
```

**The base commit became a recorded fact.** It was inferred afterwards from the
target's git state, which can answer *does this still apply* but never *which
commit was this patch for* — the question a reader has precisely when it does
not. A mismatch now refuses and names both commits, because two proposals
generated independently against the same commit **do not compose**: measured on
Lakeside Mutual, they overlapped in five files and each invented its own
certificate authority.

**The *after* side of the comparison is produced by applying the patch in a
throwaway worktree**, not by interpreting the diff. git already knows how to
apply a patch; a viewer showing a subtly different result from what applying
produces would be worse than no viewer.

### Four defects, all found by running it

None of them was reachable from the headless build, and the last two cost the
user real cleanup.

| | Found | Fixed by |
|---|---|---|
| Two menus labelled **LEMMA** in the menu bar | first launch | contributing into `lemmaMenu` **by id** — a label is not an identity |
| Compare root built with `NO_CHANGE` | first review | `CHANGE`; a single-file proposal opens straight onto its diff |
| `git add -A` swept **three unrelated files** into the commit | first apply | stage the patch's paths and nothing else |
| A worktree left registered in the user's repository | `git worktree list` | sweep both prefixes, before a review *and* before a proposal |

**I had the worktree leak diagnosed wrong at first.** I assumed the compare
viewer. The leaked directory was named `lemma-refactoring…`, which is the
**proposer's** prefix — a proposal runs up to 25 minutes, and a run that ends
any other way than by returning (a usage limit, a closed workbench) never
reaches the clause that removes it. Two of the four proposal runs in this work
did die on usage limits. The compare input's disposal race is real too and is
fixed here, but it was not the cause.

## Evidence

```console
$ build-diagrams.sh
  compiled de.fhdo.lemma.diagram.common
  compiled de.fhdo.lemma.data.datadsl.diagram
  compiled de.fhdo.lemma.servicedsl.diagram
  compiled de.fhdo.lemma.operationdsl.diagram
  compiled de.fhdo.lemma.servicedsl.smells.validation
  compiled de.fhdo.lemma.servicedsl.smells
  compiled de.fhdo.lemma.servicedsl.ui          (all 7, at --release 11)

$ smell-test.sh          134 check(s), 0 failed      (was 108 on dev)
$ svc-test.sh             96 check(s), 0 failed
$ op-test.sh              60 check(s), 0 failed
$ regression.sh          All systems match their expected models.   (4 systems)
```

**Before and after, on the defect that mattered most.** The user applied a
proposal from the editor to their own checkout:

```diff
- commit 12bc7d8  "Mutual TLS for the Customer Core and its callers"
-   13 files from the patch
-   DataLoader.java          ← the user's own edit
-   SECURITY_REVIEW.md       ← the user's own notes
-   seucity-smell.md         ← the user's own notes

+ commit ef73ae1  "Mutual TLS for the Customer Core and its callers"
+   13 files from the patch, and nothing else
```

The three files are back as uncommitted work in that checkout, where they
belong. `git worktree list` there now shows three entries, all of them
deliberate, and none with a temporary prefix.

**The new checks test which paths are handed to git**, because that is where
the decision is — how to stage them is not:

```text
ok    the patch's paths are what gets staged
ok    and they are the patch's, not the directory's
ok    nothing the patch does not mention is included
ok    the branch is named after the cause, not the date
ok    a patch shipping no script offers none
```

Two mutations confirm the earlier batch bites: comparing commits as exact
strings fails 3 checks, skipping the base check fails 3. The second **crashed
rather than failed** at first — it dereferenced a refusal that had become
null — so those checks are guarded now. Third time in this work that a test's
failure *mode* was wrong rather than its logic.

### Added after this body was written: the smell gate asks about the cause

`07d049e8` is on the branch and not in the text above, because it arrived after
it. **A falling finding count is a weak condition.** It holds while the cause
the proposal was asked to resolve still has findings, and it holds when the
reconstruction simply stopped seeing a channel. The smell gate now reads the
cause id from the record's own statement of intent and fails unless *that* cause
has no finding left **and** the total fell.

So the report has to quote an id a gate can look for: every cause bullet carries
it beside the label, and the section renders whenever a cause exists rather than
only when findings outnumber causes.

**Only a real id counts.** A record may carry prose where the cause goes — the
ablation's says that none was given — and taking the first word regardless made
the gate announce a cause of `(none` and then dutifully check for it.

The verdicts were renamed to say what they measure: `GATES PASSED`,
`GATE FAILED`, `PARTIAL`, instead of `VERIFIED`, which claimed more than four
gates can establish. `RecordedProposal` accepts both spellings, because records
written before the rename carry the old one.

The prompt gains the one constraint the gates cannot enforce: a test moved off
the network still builds and still asserts, so a proposal that changes what
transport a test exercises has to say so, and say what coverage is lost.


## Merge Danger

**Door:** two-way for everything except one case. Six new classes, two
`plugin.xml` extensions, one field on a record.

The exception: **`Apply…` writes to a checkout outside this repository** — it
creates a branch, applies a patch, commits, and runs a shell script from the
patch. That is deliberate and it is the point of the feature, but it is the
first thing in this toolchain that does so, and it is not undone by reverting
this branch.

**Blast Radius:** the LEMMA menu, and whatever checkout the source-root
preference points at

- **The menu contribution now targets an id this bundle does not own.** If
  `de.fhdo.lemma.eclipse.ui` is absent or renames `lemmaMenu`, the Security
  Smells submenu silently does not appear. Preferable to the alternative, which
  was two menus with the same label.
- **Applying refuses rather than guesses** on a base mismatch, a non-checkout,
  or a patch that will not apply; it warns on a dirty tree and continues only
  if told to. Every path that writes is reported as it happens.
- **Proposals predating the `base` field still work** — they apply if they fit
  and say they record no base if they do not.
- **A sweep removes worktrees whose path contains `lemma-review` or
  `lemma-refactoring`** from the target repository. It runs only at moments
  when nothing of ours can legitimately be in use, but it is a `--force`
  removal in the user's repository, and a worktree they made themselves with
  one of those names in its path would be removed.

Still unverified, and worth stating rather than implying:

- **No automated test covers the dialogs.** The headless suite stops at the
  `RefactoringProposer` seam by design, so everything in `…servicedsl.ui` is
  covered by compilation and by having been run. There is no CI in this
  repository at all — the ~290 checks above were run by hand.
- **Applying has run live exactly once**, and it is the run that exposed two of
  the four defects. The fixes are tested headlessly; the fixed *dialog* has not
  been through Eclipse again.
- **Proposing is still Eclipse-only.** No command-line entry point; the shell
  route runs `claude -p` by hand.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

## Summary

**The refactoring now runs from the Eclipse editor.** It did, for the first
time, on the way to this branch — 127 turns, 18 minutes, a 669-line patch for
`CustomerCore`'s connector and its three callers, applied nowhere.

Three changes, all of them found by running it rather than by reading it:

```diff
+ Window → Preferences → ServiceDsl → Security Smell Refactoring
      Source root · Command line · Model · Give up after · Keep proposals in
- .metadata/.plugins/org.eclipse.core.runtime/.settings/*.prefs   edited by hand

+ RefactoringRequest.cliCommand        an absolute path, not a bare name
- Preconditions: "not on the PATH, or is not authenticated"       it cannot know that

+ docs/smell-resolution-guide.md       both routes, end to end
```

**A preference page**, because the one setting the feature cannot work without
had no user interface: the source root was an instance-scope preference whose
only route was editing a `.prefs` file by hand, in the right workspace, before
launching. It has **no default** on purpose — a reconstructed model carries no
source paths, so there is nothing to guess from, and a wrong guess would aim a
proposal at the wrong checkout.

**The command line is configurable**, because a bare name is resolved against
the `PATH` of the process that spawns it, and Eclipse does not inherit a shell
`PATH`. On macOS one started from the Dock sees only `/etc/paths`, so a tool
under `/opt/homebrew/bin` is invisible to it — and a runtime workbench inherits
from whatever started the IDE. An absolute path sidesteps the whole question.
It travels on the `RefactoringRequest`, so the smells bundle keeps no UI
dependency.

**A guide**, because none of the above is discoverable.

## Evidence

The run that produced this branch:

```text
2026-10-15-endpoint-customercore-…/
  model.txt   claude-opus-5 · 127 turns · 1056 s · $8.29 · patch produced
  patch.diff  669 lines, 13 files
```

**It independently reproduced `rc1`** — same 13 files, the Feign client in
`CustomerCoreClientConfiguration`, both `DefaultAuthenticatedRestTemplateClient`s,
the test-profile properties, a `generate-certificates.sh`. A different session
reaching the same engineering answer is a useful reproducibility signal for a
method whose output is not reproducible by construction.

```console
$ build-diagrams.sh          all 7 bundles compile at --release 11
$ SmellDetectionTest         108 check(s), 0 failed
$ ReconstructionRegressionTest   all 4 systems match
$ git -C <source-root> status --porcelain     (empty — nothing was touched)
```

**What the first live run proved, and what it broke:**

| | |
|---|---|
| Preference page opens, under `ServiceDsl` | ✅ |
| Issue code reaches the editor; warning on the aspect line | ✅ |
| Quickfix offers itself with the cause's label | ✅ |
| Precondition check runs and refuses cleanly | ✅ |
| Background job, patch written, source untouched | ✅ |
| Finding the CLI | ❌ — the only failure, fixed here |

**The old message asserted something it cannot know.** The check runs
`--version`, which says nothing about authentication: an unauthenticated CLI
reports its version happily and then refuses the work. It now explains the
`PATH` mechanism, names the macOS case, quotes the command it actually tried —
so a bare `claude` in the message tells you the preference is not in use — and
offers the two real fixes.

Every command, flag and field label in the guide was checked against the code:
the four scripts exist, `--base`/`--plugins`/`--build-command` are real flags,
and the five field labels match the page.

One Java level slip the build caught: `String.stripIndent()` is Java 12 and
this bundle declares `JavaSE-11`. Same shape as the `List.getLast()` slip
earlier in this work, and again **only `--release 11` reports it**.

## Merge Danger

**Door:** two-way. A page, an initializer, two `plugin.xml` extensions, one
field on a data class, and documentation.

**Blast Radius:** the preference dialog, and the proposer's spawn

- **A new page appears** under `ServiceDsl` for anyone with the bundle, used or
  not.
- **An initializer contributes defaults** into the
  `de.fhdo.lemma.servicedsl.ui` instance node. It sets only `cliCommand`,
  `model` and `timeoutMinutes`, and touches nothing Xtext owns — but it is a new
  contribution to a node the language also uses.
- **Hand-edited `.prefs` files keep working**: the page reads and writes the
  same keys.
- **`RefactoringRequest` gains a field with a default of `"claude"`**, so any
  caller that does not set it behaves exactly as before.

What is **still** unverified, and worth stating rather than implying:

- The `starts` verification gate and the full four-gate run have not been
  exercised **from this branch**; they were verified earlier by hand.
- **No automated test covers the page or the quickfix.** The headless suite
  stops at the `RefactoringProposer` seam by design, so everything in
  `…servicedsl.ui` is covered by compilation and one manual run. There is no CI
  in this repository at all.
- **Proposing is Eclipse-only.** There is no command-line entry point, which
  the guide says plainly rather than leaving to be discovered — the shell route
  runs `claude -p` by hand.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

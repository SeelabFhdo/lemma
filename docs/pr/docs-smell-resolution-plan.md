## Summary

The plan the resolution work was built from, and what each step established.

```text
docs/smell-resolution-plan.md
  1 what is being built        the boundary: propose, never apply
  2 decisions                  every settled choice marked [decided]
  3 the constraint             the model carries no source paths, by design
  4 how the AI is instructed   three layers, only one of them a skill
  5 the two root causes        done, in MRF's own recognition rules
  6 structure                  which bundle holds what
  7 steps 1–7                  all done, with the outcome table
  8 deliberately not in it
  9 what could make this fail
```

Matches the shape of `service-diagram-plan.md`: decided choices marked, the
constraint that forces the design given its own section, and the risks stated
rather than discovered.

## Evidence

The plan is a record of decisions, so the evidence is that it says what was
actually decided and measured — including where reality contradicted it.

**§3 names the collision the design has to live with:** a generated model
carries **no source path at all**, because those are absolute and a model has to
be identical on every machine to be diffable. MongoDB has them exactly. So *the
decision that made models reproducible is the decision that blinds a model-side
quickfix to the code it must fix.* Both choices were right; they collide here.

**§5 states "done" in MRF's recognition rules**, not in prose, so that "the AI
believes it is finished" and "the toolchain measures it as finished" cannot
drift apart. It also carries the three traps the paper's text cannot reveal —
least-protected-connector-wins, two plaintext connectors rather than one, and
TLS without client-auth not being mutual.

**§7's outcome table is measured, with a correction in it:**

| Step | Established |
|---|---|
| 3 | 9 findings reduce to 2 causes, computed not asserted |
| 4 | the AI behind one interface; everything else covered |
| 5 | compiles against the real APIs — **not** exercised in a live Eclipse |
| 6 | **rc1 verifies: findings fell from 9 to 6** |
| 7 | the clean verdict exists at all, which no sample system could show |

The second commit records that step 2's own estimate was wrong: the two
proposals **disagreed** about whether the build may depend on generated key
material, and the plan had no rule about it. The gate was split in two as a
result, and `rc2`'s failure is quoted verbatim.

## Merge Danger

**Door:** two-way. One new file; nothing executes.

**Blast Radius:** none

No bundle, suite or model is touched.

One caveat on reading it: **§4 and §6 describe code that lands on other
branches** — `feat/smell-verdict-and-grouping`, `feat/resolve-smell-skill` and
`feat/refactoring-machinery`. Merged alone, this plan describes a feature `dev`
does not yet have. That is the normal order for a plan, and the file is written
in the present tense of its own design rather than claiming the code is there.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

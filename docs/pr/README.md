# Pull request bodies

One file per feature branch, named after it, and one for the release of
`dev` into `main`. Written when the branch was ready
and kept so the text survives the session it was written in.

They are a record of what a change claimed and what it was verified against, so
a later reader can check the claim rather than take it. The evidence sections
name the exact commands and their output - which matters here, because this
repository has no headless build and the verification was done by compiling the
Xtend with the batch compiler and running `ReconstructionRegressionTest` by hand.

At the repository root rather than inside a bundle: these changes span several
of them - `de.fhdo.lemma.reconstruction` and `de.fhdo.lemma.servicedsl.extractor`
for the reconstruction work, the `*.diagram` bundles for the visualisations, and
`de.fhdo.lemma.servicedsl.smells*` for the smell detection.

The first three arrived together on the branch `feat/communication-aspect`, which
contains the commits of the other two; the earlier branches are left alone so
their own diffs stay free of files describing themselves.

| File | Branch | Into |
|---|---|---|
| `feat-deployment-configuration.md` | `feat/deployment-configuration` | `dev` |
| `feat-rest-technology-information.md` | `feat/rest-technology-information` | `dev` |
| `feat-communication-aspect.md` | `feat/communication-aspect` | `dev` |
| `feat-service-dependencies.md` | `feat/service-dependencies` | `dev` |
| `feat-protobuf-fixture.md` | `feat/protobuf-fixture` | `dev` |
| `fix-asynchronous-communication.md` | `fix/asynchronous-communication` | `dev` |
| `feat-data-model-diagram.md` | `feat/data-model-diagram` | `dev` |
| `feat-service-model-diagram.md` | `feat/service-model-diagram` | `dev` |
| `feat-operation-model-diagram.md` | `feat/operation-model-diagram` | `dev` |
| `feat-server-endpoint-aspect.md` | `feat/server-endpoint-aspect` | `dev` |
| `feat-security-smell-detection.md` | `feat/security-smell-detection` | `dev` |
| `feat-smell-verdict-and-grouping.md` | `feat/smell-verdict-and-grouping` | `dev` |
| `feat-resolve-smell-skill.md` | `feat/resolve-smell-skill` | `dev` |
| `feat-refactoring-machinery.md` | `feat/refactoring-machinery` | `dev` |
| `docs-smell-resolution-plan.md` | `docs/smell-resolution-plan` | `dev` |
| `fix-temurin-operation-environments.md` | `fix/temurin-operation-environments` | `dev` |
| `feat-smell-refactoring-preference-page.md` | `feat/smell-refactoring-preference-page` | `dev` |
| `feat-review-and-apply-a-proposal.md` | `feat/review-and-apply-a-proposal` | `dev` |
| `feat-node-communication-aspects.md` | `feat/node-communication-aspects` | `feat/review-and-apply-a-proposal` |
| `feat-judge-node-channels.md` | `feat/judge-node-channels` | `feat/node-communication-aspects` |
| `feat-detection-coverage-report.md` | `feat/detection-coverage-report` | `feat/judge-node-channels` |
| `dev-to-main-release.md` | `dev` | `main` |

The last four are a **stack**, each branch containing the commits of the one
above it, so they merge in the order listed and nothing else:

```text
dev
└── feat/review-and-apply-a-proposal      review and apply, from the editor
    └── feat/node-communication-aspects   the two aspects a technology model has to declare
        └── feat/judge-node-channels      the detector judges them: 9 findings -> 11
            └── feat/detection-coverage-report  where its view ends, and four verdicts
```

Reviewing them in that order is also how the numbers read as a sequence: the
finding count of Lakeside Mutual is 9 before the stack, 9 after the aspects are
declared, 11 once they are judged, and 11 with the coverage question answered
beside them. `feat/node-communication-aspects` needs MRF's
`feat/node-transport-evidence` merged beside it, because the facts it declares a
vocabulary for are produced there.

Merge order matters for `feat/communication-aspect`: it contains the commits of
`feat/rest-technology-information`, so that branch goes first. Most also need
their counterpart in the MRF repository - neither side produces visible output
alone. The `*.diagram` branches are the exception: they read models that already
exist and depend on nothing in MRF.

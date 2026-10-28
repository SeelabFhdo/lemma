## Summary

An `OperationEnvironment` is an **enumerated reference**, so a value the
technology model does not declare cannot resolve:

```text
Couldn't resolve reference to OperationEnvironment 'eclipse-temurin:21-jdk'.
```

Lakeside Mutual's Dockerfiles had to move off `openjdk:21-slim-buster`, which
Docker Hub withdrew. The reconstruction duly reported the new image, and **three
declarations did not list it**:

```diff
 operation environments = "openjdk:11-jdk-slim" default,
     "openjdk:21-slim-buster",
+    "eclipse-temurin:21-jdk",
+    "eclipse-temurin:21-jre",
     "node:16",
+    "nginx:stable-alpine",
     "nginx";
```

in `deployment_base.technology`, `deployment_base_relaxed.technology`, and
`spring.technology`'s `SpringBootAdmin` block — which is the very service whose
Dockerfile changed.

**The `openjdk` entries stay.** A model reconstructed before that image was
withdrawn is still a valid model; removing them would only break it.

`nginx:stable-alpine` is declared **pre-emptively and labelled as such**. The
Docker plugin reports it for the frontends now that it reads the final `FROM`,
but the frontends are deliberately kept out of generated operation models, so
nothing references it today.

## Evidence

Verified by generating Lakeside Mutual's models and cross-checking every
environment the models reference against every environment the technology
models declare:

```console
referenced by the generated models:
   OK   eclipse-temurin:21-jre
   OK   nginx
   OK   node:16

unresolvable: none — every environment resolves
```

```console
$ SmellDetectionTest       108 check(s), 0 failed
$ ServiceGraphTest          96 check(s), 0 failed
$ OperationGraphTest        60 check(s), 0 failed
$ ReconstructionRegressionTest   all 4 systems match
```

**Two things found while checking this, both corrected in `test/README.md`
rather than left to mislead:**

- It claimed the technology copies under `test/expected` are *"overwritten on
  every run"*. **They are not.** A comparing run generates into a temporary
  folder and copies the models beside *that*, so only `--update` refreshes
  them. They had drifted from the source models and are now back in step.
- **Nothing in the regression exercises this.** No expected folder contains
  `operation/` models, so `deployment_base.technology` and the environments it
  declares are untested there. That is why the broken reference reached the
  editor rather than a test run.

## Merge Danger

**Door:** two-way. Declarations only; no Xtend changes.

**Blast Radius:** nothing existing breaks

Declaring an environment only widens what resolves. No previously valid model
becomes invalid, which is why the withdrawn images are kept.

**This is one half of a pair.** MRF's `fix/runtime-operation-environment` makes
the Docker plugin read the *runtime* stage of a multi-stage Dockerfile instead
of the build stage, so it reports `eclipse-temurin:21-jre` where it used to
report `…-jdk`. The two want merging together:

| Merged alone | Consequence |
|---|---|
| this branch only | harmless but inert — nothing reports the new images yet |
| the MRF branch only | **the original error returns**, for `-jre` instead of `-jdk` |

Nothing in either repository enforces that coupling, which is worth knowing
rather than remembering: a technology model is the closed vocabulary for what
the reconstruction may say, and the two are only kept in step by hand.

The 16 changed files are 3 source technology models, `test/README.md`, and the
12 copies under `test/expected/*/technology/` brought back into step.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

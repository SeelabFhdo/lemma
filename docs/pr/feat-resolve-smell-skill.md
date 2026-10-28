## Summary

The mutual-TLS refactoring, encoded as a versioned skill rather than a prompt
built at runtime.

```text
de.fhdo.lemma.servicedsl.smells/refactoring-plugin/
├── .claude-plugin/plugin.json
└── skills/resolve-non-secured-communication/
    ├── SKILL.md                     cites Ponce et al. (2022) §3.7
    └── references/
        ├── spring-rest.md           server + Feign + RestTemplate
        ├── activemq-openwire.md     the embedded broker's SslContext
        ├── activemq-stomp.md        the Node stompit client
        └── certificates.md          one CA, one trust store, per-service keys
.claude/skills/resolve-non-secured-communication  → symlink, for terminal use
```

A refactoring procedure is **static knowledge**, so it belongs in a reviewed
file rather than string-built per call. That also makes a proposal attributable:
the record names the skill's commit, so output traces to a specific encoded
procedure rather than to an ad-hoc prompt.

**A plugin directory, not a plain `.claude/skills/`** — a repository-root skills
folder only auto-loads when the working directory *is* that repository, and the
proposer runs in a worktree of the system being refactored. `--plugin-dir`
injects it for one session.

## Evidence

The recipes are written against the **actual sources**, which changed several
things I would have got wrong generically:

| Found | Consequence |
|---|---|
| Spring Boot **3.3.4** / Java 21 | SSL bundles exist; MRF already treats a bundle as implying TLS |
| all three callers hold `customercore.baseURL`, **plus a fourth copy** in `src/test/resources` | the skill distinguishes test *configuration* (fair game) from test *code* (not) |
| the Feign client already names `CustomerCoreClientConfiguration` | the TLS client has a natural home |
| `customer-self-service` reaches the broker via `policymanagement.tcpBrokerBindAddress` | a property that **reads like server config** — recorded as a pitfall, since assuming `spring.activemq.broker-url` misses the client |
| `stompit` passes connect options straight to `tls.connect` | the Node change is `ssl: true` + `ca`/`key`/`cert` |

The pitfalls are where this toolchain's own knowledge lives — things the paper
cannot say:

- **the least protected connector wins**, so adding `ssl://` beside `tcp://`
  clears nothing
- this broker has **two** plaintext connectors, not one
- TLS without client authentication is not mutual TLS
- the suite must pass on a **clean checkout**, which is invisible from inside the
  worktree because the key material is already there

That last one was **learned from a proposal that got it wrong** and is the second
commit here. `rc1` built its `SSLContext` inside the client beans deliberately,
keeping `./mvnw test` green with no key material; `rc2` pointed its test broker
at a PKCS#12 file on disk and failed for anyone applying the patch:

```text
java.io.FileNotFoundException: ../certs/policy-management-backend.p12
Tests run: 2, Errors: 2 — RiskManagementMessageProducerTests
BUILD FAILURE
```

Nothing but a clean-room build found it — not the proposal's notes, not any
mechanical check. So it is now both a pitfall **and** a done-criterion.

**Verified that the plugin loads:** the skill resolves as
`lemma-smell-refactoring:resolve-non-secured-communication`.

## Merge Danger

**Door:** two-way. New files plus one `bin.includes` entry.

**Blast Radius:** nothing at runtime, until the machinery lands

No Xtend compiles differently and no suite changes. The skill is inert text
until `feat/refactoring-machinery` invokes it.

Three things to know:

- **A skill is instruction, not enforcement.** It can be ignored, so nothing
  load-bearing depends on it — the constraints repeat what must hold and the
  verification step settles it. That split is deliberate.
- **`refactoring-plugin/` is added to `bin.includes`**, unlike `tools/`, because
  the running plugin passes the directory to the CLI and it must exist in an
  *installed* bundle. Forward-looking for the machinery; revert if you would
  rather package it then.
- **`certificates.md` tells the AI to run the script and read the errors** rather
  than trust the shell it provides. `keytool -gencert` and `-ext san=` are fiddly
  and version-sensitive, and a chain that imports cleanly can still fail at
  handshake time. I would rather the skill admit that than present untested shell
  as authoritative.

Only §3.7's skill is written. One per smell is the shape, but the other nine have
no detection, so they would be unexercised files.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

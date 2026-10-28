## Summary

The transport a service uses to call the other services of a system, as a
technology aspect on the microservice:

```diff
 @technology(javaWithSpring)
+@javaWithSpring::_aspects.ServiceCommunicationTransport(transport = "plaintext")
 public functional microservice com.lakesidemutual.customermanagement.CustomerManagement {
```

A fact about the channel, not a finding about it: deciding the smell
*Non-Secured Service-to-Service Communications* additionally needs what the
callee accepts and whether a service mesh protects the channel, so the decision
stays with the validation.

**The mechanism needed nothing new.** `TechnologyAspects` already reads which
aspects a technology model declares, for which join points and with which
properties, and the generator emits only what is declared — so the `public` and
`functional` meta-data a microservice also carries are dropped without a further
rule. Two places only had no microservice aspect yet: the generator did not call
`assignAspects` for it, and the extractor did not print the aspects of a
microservice, the same gap an interface had. Three additions in total, one of
them the declaration in `spring.technology`.

## Evidence

Both bundles compiled with the Xtend batch compiler; `ReconstructionRegressionTest`
run headlessly — three systems, twelve models, all matching.

New fixture `lakeside-mutual`, all four services reconstructed together, with
machine-independent paths:

```text
CustomerManagement.services   1 × ServiceCommunicationTransport(plaintext)
CustomerSelfService.services  1 ×
PolicyManagement.services     1 ×
CustomerCore.services         0 ×   calls no other service
```

The whole system rather than one service on purpose: a fact about communication
between services only arises when both ends are in scope — against one backend
alone, its call has no known callee and is classified as leaving the application.
That pair, the aspect where a call was found and nowhere else, is what the
fixture guards.

Confirmed in the wizard against a live MongoDB as well.

## Merge Danger

**Door:** two-way. Additive; the aspect is emitted only where the reconstruction
reports the meta-datum.

**Blast Radius:** service models of systems reconstructed with the Communication
plugin

**Merge after `feat/rest-technology-information`** — this branch contains its two
commits, because the aspect is emitted through the mechanism they introduced.

Requires the matching MRF branch and a run with `-p … Communication`; without it
no microservice carries the meta-datum and no aspect appears. The wizard
overwrites `spring.technology` in the output folder, so a stale copy there is the
likeliest reason for an unresolved aspect reference.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

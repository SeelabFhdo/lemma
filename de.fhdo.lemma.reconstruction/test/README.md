# Regression test for the LEMMA model generation

`de.fhdo.lemma.reconstruction.test.ReconstructionRegressionTest` generates
LEMMA models from recorded reconstruction output and compares them against
models that were reviewed and accepted before. It needs neither a database nor
a running Eclipse application: run it from the IDE with **Run As → Java
Application**, with this bundle as the working directory.

```
test/
  fixtures/<system>/documents.json           input: the documents MRF writes to MongoDB
  expected/<system>/domain/*.data            accepted domain models
  expected/<system>/service/*.services       accepted service models
  expected/<system>/technology/*.technology  copied beside them, never compared
```

A generated model imports its technology model by a relative path, so the
technology models are copied into every system's folder, exactly as the wizard
copies them into the folder it writes to. Without them the imports of an
accepted model do not resolve and the folder shows errors although the models
are right. They are inputs rather than output, so the comparison ignores
them. **They are refreshed by `--update`, not by a comparing run**: a comparing
run generates into a temporary folder and copies the technology models beside
*that*, so a change under `models/technology/` does not reach these copies by
itself. Keep them in step by hand, or with `--update`, or an expected folder
opened in Eclipse shows unresolved imports although the models are right.

Note also what is **not** compared here: there are no `operation/` models in any
expected folder, so nothing in this test exercises `deployment_base.technology`
or the operation environments it declares. A change there has to be checked by
generating a system's models and opening them.

The technology models are also what decides which types and service aspects a
generated model may refer to, which the generators read from the model itself.
Outside a running Eclipse there is no bundle to read it from, so both the
reading and the copying fall back to the working directory - which is why this
test has to run with the bundle as its working directory. Without that fallback
the test would accept models in which every foreign type is `unspecified` and
no annotation of a REST controller is carried over, while the wizard produces
models that have them.

The test runs the same generators (`LemmaDomainGenerator`,
`LemmaServiceGenerator`) and the same writer (`ReconstructionModelWriter`,
including extraction, validation and masking) as the reconstruction wizard, so
a difference here is a difference in the wizard's output.

It compares the models as text. Masking only rewrites a name that collides with
a keyword, so a model that is accepted here is one whose text is right, not one
the editor has reported no problem on. Open the generated folder in Eclipse for
that.

## Accepting new models

`--update` writes the generated models into `expected/` instead of comparing
them. Only ever run it after reading the reported difference and deciding that
the new models are the better ones. An expected model is a reviewed artefact,
not a recording of whatever the generator currently produces.

## Fixtures

A fixture holds exactly the documents the Microservice Reconstruction Framework
writes into the collections `context` and `microservice`:

```json
{ "context": [ … ], "microservice": [ … ] }
```

They can be exported from a MongoDB that MRF has filled, or produced without a
database by transforming the reconstruction result with
`mrf.repositories.domain.data.transform_context_for_database` and
`mrf.repositories.service.service.transform_microservice_for_database`.

### station-service

`de.dmsa.parkandcharge.station.StationService`, exported from the MongoDB that
MRF filled. Its expected models are the ones the reconstruction wizard produced
from those very documents, so this system also guards the test itself: if the
test and the wizard ever disagree, this is where it shows.

### lakeside-mutual

All four services of Lakeside Mutual, reconstructed together with

```
uv run mrf -p Java Spring Communication -t <LakesideMutual>
```

and the paths in the documents made relative to the system root so the fixture
is machine independent.

The whole system rather than one service, because a fact about the communication
between services only arises when both ends are in scope: run against
`customer-management-backend` alone, its call to `customer-core` has no known
callee and is classified as leaving the application. Here the three backends that
call `customer-core` each carry

```
@javaWithSpring::_aspects.ServiceCommunicationTransport(transport = "plaintext")
```

and `CustomerCore`, which calls no other service, carries none. That pair is what
the fixture guards: the aspect appears where a call was found and nowhere else.

It guards the dependency levels in the same way. Each service states what it
requires of `customer-core` at the finest level its own sources allow:

| Service | Level | Why |
|---|---|---|
| `CustomerManagement` | `required operations` | its Feign client declares the three endpoints it addresses, and each matches one operation of the callee |
| `CustomerSelfService` | `required microservices` | it calls through `RestTemplate`, which assembles its path in the call expression, so no endpoint is stated |
| `PolicyManagement` | `required microservices` | the same |
| `CustomerCore` | none | it calls no other service |

So one fixture covers both outcomes of the resolution, and a change that pushed
the Feign caller down to the service level - or the others up without the sources
saying so - shows up here.

### risk-management

`risk-management-server` of Lakeside Mutual, reconstructed from its
`riskmanagement.proto` with

```
uv run mrf -p Protobuf Node -t <LakesideMutual>
```

The one component of that system written in Node rather than Java, and the only
fixture whose models come from a gRPC contract instead of from annotated Java.
It guards what no fixture did before: that a reconstruction from a proto file
produces models whose references resolve.

```
import datatypes from "../domain/RiskManagement.data" as RiskManagement
…
    Trigger(
        sync in triggerRequest : RiskManagement::RiskManagement.TriggerRequest,
        sync out triggerReply : RiskManagement::RiskManagement.TriggerReply
    );
```

**It carries the two communication facts of a Node service**, since the Node
plugin joined the selection:

```
@javaWithSpring::_aspects.GrpcServer(host = "0.0.0.0", port = "50051", transportSecurity = "plaintext")
@javaWithSpring::_aspects.MessageQueue(broker = "activemq", host = "localhost", port = "61613", queue = "newpolicies", scheme = "stomp", credentialsConfigured = "true", transportSecurity = "plaintext")
```

That is the pair the smell detection was blind to. The facts were reconstructed
before, and `spring.technology` declared no aspect for either, so the generator
dropped them and this service appeared in the models with no communication fact
at all - which is how a plaintext gRPC endpoint and a plaintext queue consumer
stayed out of every report.

`transportSecurity` is read from `index.js`, by the name of the call that opens
the channel, so the fixture also guards that: a service that binds with
`createInsecure` says `plaintext`, and one that binds with `createSsl` says
`tls` and, where the third argument requires a client certificate, carries
`clientAuth = "need"` as well. `valueSource` is reconstructed and **not**
generated, as with `ServerEndpoint`: the recorded path is absolute for a real
run, and a generated model has to be the same on every machine.

Two further things about it are deliberate and worth knowing before a difference
here is read as a regression.

**The interface carries no `@endpoints`.** A gRPC service is addressed by its
qualified name, and the reconstruction reports that address under a name of its
own rather than as an `Endpoint` - because an endpoint is generated under the
only protocol the service generator knows, `rest`, and `spring.technology`
declares no `grpc`. An earlier version did report it as an endpoint, and the
generated model then said a gRPC service is reached over REST.

**`async out triggerReply`, because the rpc returns a `stream`.** This is the
only model with an asynchronous parameter: the Spring plugin reports every
parameter as synchronous, so a streaming rpc is the first one. It is also what
showed that `deriveCommunicationType` mapped `asynchronous` onto
`CommunicationType.SYNCHRONOUS` and the model stated the opposite of the
sources; the fixture guards the fix.

### customer-core

The `customer-core` service of Lakeside Mutual
(`https://github.com/Microservice-API-Patterns/LakesideMutual`) at commit
`357ca2d`. Its documents carry the technology information of its REST
interfaces - the endpoints of the controllers and of their methods, and the
annotations of the methods and their parameters - so this system covers what a
service model says about the technology beside what it says about the
operations.

Two of its files contribute nothing to the documents:

```
src/main/java/com/lakesidemutual/customercore/application/DataLoader.java
src/main/java/com/lakesidemutual/customercore/domain/city/CityLookupService.java
```

Both fail to parse with the Java parser MRF uses, on a nested generic local
variable inside a try-with-resources body
(`MappingIterator<Map<String, String>> readValues = …`), and MRF skips a file
it cannot read with a warning. Neither is an entity or a REST controller — both
are `@Component` — so skipping them does not change what the reconstruction
finds.

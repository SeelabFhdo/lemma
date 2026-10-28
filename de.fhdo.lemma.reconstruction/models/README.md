# Technology models for the reconstruction

LEMMA models that reconstructed models reference. They are written by hand: the
Microservice Reconstruction Framework does not reconstruct technology models,
it reconstructs what the sources of the analysed system state and leaves the
LEMMA concepts to LEMMA (ADR-0008 of the reconstruction framework).

| Model | Technology | Used by |
|---|---|---|
| `technology/deployment_base.technology` | `DeploymentBase` | operation models |
| `technology/deployment_base_relaxed.technology` | `DeploymentBaseRelaxed` | kept for models written by hand without service values |
| `technology/spring.technology` | `javaWithSpring` | service models, once they are enhanced with technology |

## What a technology model decides

It is not only a reference target, it is the vocabulary of everything an
operation model may say:

- **`operation environments`** is a closed list. A base image the reconstruction
  reads from a `Dockerfile` can only reach the operation model when it is
  declared here. The list therefore names the images of the analysed systems -
  currently those of Lakeside Mutual: `openjdk:21-slim-buster` for the Java
  services, `node:16` for the frontends, `nginx` for the proxy.
- **`service properties`** declares which keys a `default values { … }` block
  may use, and which of them are mandatory.

## Why there are two deployment models

`OperationDslValidator.checkMandatoryPropertiesHaveValues` reports an error when
a node deploys more services than it has deployment specifications while a
mandatory service property has no value:

```xtend
hasMissingSpecifications =
    operationNode.deploymentSpecifications.size < operationNode.deployedServices.size
```

For a reconstructed container that is `0 < 1`. With `DeploymentBase`, where
`springApplicationName` and `serverPort` are mandatory, every container that
deploys a microservice is therefore an error until the reconstruction reads
those values from the `application.properties` of its service.

`DeploymentBaseRelaxed` drops the two `<mandatory>` markers and changes nothing
else. Both declare the deployment technology as `Kubernetes`, so moving from one
to the other changes the import, not the references into it.

**The generated models reference `DeploymentBase`.** The reconstruction reads
`spring.application.name` and `server.port` from the `application.properties` of
a container's service and assigns them as its default values, so the mandatory
properties have values and the strict model is the one that applies. The relaxed
model is kept for a model written by hand, and for a system whose services
carry no such configuration - a container without the two values is an error
against the strict model, which is the point of marking them mandatory.

The values are not carried over to an infrastructure node. Its service
properties are declared by its infrastructure technology, which names them
differently: `SpringBootAdmin` declares `applicationName` and `port` where a
deployment technology declares `springApplicationName` and `serverPort`.

An infrastructure node is unaffected either way: it deploys nothing, so the
check reads `0 < 0`.

## Infrastructure technologies

`spring.technology` declares one per kind of infrastructure the reconstruction
recognises, and **the name matters**: the generator assigns a node the
technology of the node's own name, so `Eureka` becomes
`javaWithSpring::_infrastructure.Eureka`. Supporting another kind of
infrastructure is therefore a declaration here rather than a change to the
generator.

| Technology | Role |
|---|---|
| `SpringBootAdmin` | monitoring |
| `Eureka` | service discovery |
| `Zuul` | API gateway |
| `Proxy` | reverse proxy |

`Eureka` and `Zuul` follow the technology models of LEMMA's own examples, which
declare the same properties. `Proxy` does not: nothing in the examples covers a
reverse proxy, and one is declared here only because the reconstruction
recognises nginx in Lakeside Mutual and an infrastructure node must name a
technology. Its properties are a guess.

**No service property of an infrastructure technology is mandatory**, for the
same reason `DeploymentBaseRelaxed` exists: the reconstruction reads none of
their values yet, and a mandatory property without a value is a validation
error on a node that is otherwise right. The examples of LEMMA declare them as
mandatory, so restoring the markers is what to do once the values are
reconstructed.

The properties of the aspects and protocols earlier in the model **stay
mandatory**. They belong to an aspect a model applies deliberately, not to a
node the reconstruction emits, so nothing the reconstruction produces trips
over them - the same division `deployment_base_relaxed.technology` keeps, where
the aspects also kept theirs.

A node whose name no technology matches yields a reference that does not
resolve, which the editor reports on the generated model. That is deliberate:
it names the declaration that is missing, rather than silently assigning the
wrong technology.

# LEMMA Charging Station Management Example

This example for the
[Language Ecosystem for Modeling Microservice Architecture (LEMMA)](https://github.com/SeelabFhdo/lemma/)
models two microservices of a management system for charging stations of
electric vehicles. You can find more information about the system in the
following publications:

- Rademacher, Florian, et al. ["Towards an Extensible Approach for Generative Microservice Development and Deployment Using LEMMA"](https://link.springer.com/chapter/10.1007/978-3-031-15116-3_12) Software Architecture (ECSA 2021). Springer, 2022.

- Rademacher, Florian, et al. ["Towards Holistic Modeling of Microservice Architectures Using LEMMA"](http://ceur-ws.org/Vol-2978/mde4sa-paper2.pdf) Companion Proceedings of the 15th European Conference on Software Architecture 2021. CEUR-WS, 2021.

In the following, we briefly describe the models of the example, and the source
code generated from them by LEMMA's Java Base Generator, its technology-specific
Genlets, and LEMMA's Deployment Base Generator. All models are located in the
example's `models` folder, whereas all generated source code resides in the
`src` folder.

## Domain Models

The example comprises a single domain model that is used by both modeled
microservices. The domain model can be found in the file
`/models/domain/ChargingStationManagement.data`.

## Technology Models

The example clusters a broad set of technology models supported by LEMMA's
Java Base Generator, its Genlets, and LEMMA's Deployment Base Generator. The
folder `/models/technology` stores these models.

## Service and Mapping Models

The example follows the approach of *type-focused technology mapping*. That is,
service models exhibit, next to technology-independent API definitions, all
technology information required to generate executable microservices.
Consequently, mapping models are only responsible for assigning technology
information to types that originate from domain models imported by service
models.

The service and mapping models are located in the example folders
`/models/microservices/command-side` (for the physical command side microservice
of the logical Charging Station Management Microservice following
[CQRS](https://www.martinfowler.com/bliki/CQRS.html)) and
`/models/microservices/query-side` (for the physical query side microservice of
the logical Charging Station Management Microservice).

### Avro Schema Definition Files

Next to service and mapping models, the folders
`/models/microservices/command-side` and `/models/microservices/query-side` also
cluster files that define [Avro](https://avro.apache.org) schemas. Those files
are recognizable from the extension `avsc`. Each file comprises the Avro schema
representation of a certain domain concept from the example's domain model (see
above). For instance, the file `ParkingAreaCreatedEvent.avsc` contains the Avro
representation of the domain event `ParkingAreaCreatedEvent` used by the
command side microservice to signal the query side microservice the creation of
parking areas with charging stations for electric vehicles.

## Operation Models

Each microservice receives its own LEMMA operation model (cf. the files
`ChargingStationManagementCommandSide.operation` and
`ChargingStationManagementQuerySide.operation` in the `/models/operation`
folder). While these service-specific operation models configure the
container-based deployment of the microservices, the additional
`Infrastructure.operation` model defines all infrastructure nodes required for
the microservices to run, e.g., a [Kafka](https://kafka.apache.org) message
broker and an
[Avro schema registry](https://docs.confluent.io/platform/current/schema-registry).

# Generated Source Code

Within the example's `src` folder, each microservice exhibits its own compilable
and executable codebase produced by LEMMA's Java Base Generator, its
technology-specific Genlets, and LEMMA's Deployment Base Generator :

- `de/puls/ChargingStationManagementCommandSide`: This folder gathers the
generated source code for the physical command side microservice of the logical
Charging Station Management Microservice.

- `de/puls/ChargingStationManagementQuerySide`: This folder gathers the
generated source code for the physical query side microservice of the logical
Charging Station Management Microservice.
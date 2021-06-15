# LEMMA Restaurant Example

This modeling example for the [Language Ecosystem for Modeling Microservice Architecture (LEMMA)](https://github.com/SeelabFhdo/lemma/) contains models that reconstruct \[1\] the software architecture of [FTGO](https://github.com/microservices-patterns/ftgo-application/). FTGO is an example application centered around a food company named 'Food To Go' created and used by [Chris Richards](https://www.chrisrichardson.net/) in his book [Microservices Patterns](https://www.manning.com/books/microservices-patterns) \[2\] to illustrate various concepts and methods regarding the microservice architecture style. The models are based on the latest master branch commit [#a835e](https://github.com/microservices-patterns/ftgo-application/commit/a835e23bb0f3bc92dd712ff48a1510496ecb10fa) as of April 2021.

## Purpose

The presented models of the FTGO system aim to demonstrate how LEMMA can be used to incorporate specific technologies not directly supported by LEMMA into the modeling process by using LEMMA's aspect mechanism and customized technology models. In detail, FTGO supports not only synchronous REST calls but also asynchronous communication through the [Eventuate framework](https://eventuate.io/) which, e.g., enables communication patterns such as SAGAs.
In order to cope with such a custom framework, this LEMMA example shows how to create a separate technology model, in this case for Eventuate (see `TechnologyModels/Eventuate.technology`). This technology model is used for describing the asynchronous aspects in the service models (see `*.services` files) as well as to extend the data types from the domain data models with technology-specific properties (see `*.mapping` files).

## Scope

Although it would be possible with LEMMA, this modeling example of the FTGO application does not show the modeling of deployment and operational aspects. In addition, Chris Richardson shows several alternative approaches to data storage and communication in his [Microservices Patterns](https://www.manning.com/books/microservices-patterns) book \[2\], which can naturally also be found in the reconstructed FTGO sample application. These include, for example, Kafka or storing in different databases. However, the modeling example in the current version focuses only on RESTful HTTP as a synchronous and Eventuate as an asynchronous communication option. Details about persistence in database systems were deliberately omitted.

The domain data as well as service models of the following components of FTGO were reconstructed leveraging LEMMA:
- `accounting-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-accounting-service)
- `consumer-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-consumer-service)
- `delivery-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-delivery-service)
- `kitchen-service`  [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-kitchen-service)
- `order-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-order-service)
- `restaurant-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-restaurant-service)

Moreover, technology models were created with LEMMA's Technology Modeling Language \[3\] for the following technologies being employed by the FTGO Restaurant example:

- [Java](https://www.java.com/)
- [Java/Spring](https://www.spring.io)
- [Eventuate](https://eventuate.io/)


## References
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["A Modeling Method for Systematic Architecture Reconstruction of Microservice-Based Software Systems."](https://link.springer.com/chapter/10.1007/978-3-030-49418-6_21) Enterprise, Business-Process and Information Systems Modeling. Springer, Cham, 2020. 311-326.
- Richardson, Chris. ["Microservices patterns"](https://www.manning.com/books/microservices-patterns). Manning Publications Company. 2018.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Aspect-oriented modeling of technology heterogeneity in microservice architecture."](https://ieeexplore.ieee.org/abstract/document/8703913) 2019 IEEE International Conference on Software Architecture (ICSA). IEEE, 2019.
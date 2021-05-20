# LEMMA Insurance Company Example

This modeling example for the [Language Ecosystem for Modeling Microservice Architecture (LEMMA)](https://github.com/SeelabFhdo/lemma/) contains models that reconstruct [1] the software architecture of [FTGO](https://github.com/microservices-patterns/ftgo-application/). FTGO is an example application centered around a food company named 'Food To Go' created and used by [Chris Richards](https://www.chrisrichardson.net/) in his book [Microservices Patterns](https://www.manning.com/books/microservices-patterns) [2] to illustrate various concepts and methods regarding the microservice architecture style. The models are based on the latest master branch commit [#a835e](https://github.com/microservices-patterns/ftgo-application/commit/a835e23bb0f3bc92dd712ff48a1510496ecb10fa) as of April 2021.

The following components of FTGO were reconstructed leveraging LEMMA:
- `accounting-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-accounting-service)
- `consumer-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-consumer-service)
- `delivery-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-delivery-service)
- `kitchen-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-kitchen-service)
- `order-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-order-service)
- `order-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-order-service)
- `restaurant-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-restaurant-service)

Moreover, technology models were created with LEMMA's Technology Modeling Language [3] for the following technologies being employed by Lakeside Mutual:
- [ActiveMQ](https://activemq.apache.org/)
- [Docker](https://www.docker.com/)
- [Embedded Architectural Decision Records](https://adr.github.io/e-adr/)
- [Eureka](https://www.github.com/Netflix/eureka)
- [Hystrix](https://github.com/Netflix/Hystrix)
- [Java/Spring](https://www.spring.io)
- [Microservice API Patterns](https://microservice-api-patterns.org/)

## References
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["A Modeling Method for Systematic Architecture Reconstruction of Microservice-Based Software Systems."](https://link.springer.com/chapter/10.1007/978-3-030-49418-6_21) Enterprise, Business-Process and Information Systems Modeling. Springer, Cham, 2020. 311-326.
- Richardson, Chris. ["Microservices patterns"](https://www.manning.com/books/microservices-patterns). Manning Publications Company. 2018.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Aspect-oriented modeling of technology heterogeneity in microservice architecture."](https://ieeexplore.ieee.org/abstract/document/8703913) 2019 IEEE International Conference on Software Architecture (ICSA). IEEE, 2019.
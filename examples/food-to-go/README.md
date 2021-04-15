# LEMMA Insurance Company Example

This modeling example for the [Language Ecosystem for Modeling Microservice Architecture (LEMMA)](https://github.com/SeelabFhdo/lemma/) contains models that reconstruct [1] the software architecture of [FTGO](https://github.com/microservices-patterns/ftgo-application/). FTGO is an example application created and used by [Chris Richards](https://www.chrisrichardson.net/) in his book [Microservices Patterns](https://www.manning.com/books/microservices-patterns) [2]. The models are based on the latest master branch commit [#a835e](https://github.com/microservices-patterns/ftgo-application/commit/a835e23bb0f3bc92dd712ff48a1510496ecb10fa) from April 2021.

The following components of Lakeside Mutual were reconstructed leveraging LEMMA:
- `restaurant-service` [link](https://github.com/microservices-patterns/ftgo-application/tree/master/ftgo-restaurant-service/src/main/java/net/chrisrichardson/ftgo/restaurantservice)

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
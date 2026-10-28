# Mutual TLS for ActiveMQ over OpenWire, from Java

This is the harder of the two broker recipes, because an **embedded** broker
configures its TLS in Java rather than in properties.

## Find the broker first

A broker may be embedded in one of the services rather than run separately. Look
for a `BrokerService` bean and its `addConnector` calls; the addresses are
usually injected from properties. In Lakeside Mutual the broker lives inside
`policy-management-backend` as `MessagingConfiguration`, with two connectors:

```properties
policymanagement.stompBrokerBindAddress=stomp://0.0.0.0:61613
policymanagement.tcpBrokerBindAddress=tcp://0.0.0.0:61616
```

**Both are plaintext, and both must change.** See the STOMP recipe for the
first; this file covers the second.

## Converting the connector

```properties
policymanagement.tcpBrokerBindAddress=ssl://0.0.0.0:61616
```

The scheme is what MRF reads, but changing the scheme alone will not start: an
`ssl://` connector needs an SSL context on the broker. For an embedded
`BrokerService`, set it on the broker before the connectors are added:

```java
SslContext sslContext = new SslContext();
sslContext.setKeyStore("./certs/broker.p12");
sslContext.setKeyStorePassword("changeit");
sslContext.setTrustStore("./certs/truststore.p12");
sslContext.setTrustStorePassword("changeit");
broker.setSslContext(sslContext);
```

Mutual TLS then requires the broker to demand a client certificate, which for
an ActiveMQ SSL transport is a transport option on the connector address rather
than a property:

```
ssl://0.0.0.0:61616?transport.needClientAuth=true
```

`needClientAuth=true` is the mutual part. `wantClientAuth` is not sufficient,
for the same reason `want` is not sufficient on the Spring side.

Check the ActiveMQ version in the project's `pom.xml`: the `SslContext` class
and the `transport.*` option names are stable across 5.x, but confirm rather
than assume.

## The clients

A client's broker address may **not** be `spring.activemq.broker-url`. In
Lakeside Mutual it is not set anywhere; `customer-self-service-backend` instead
reaches the broker through a property that reads like server configuration:

```properties
policymanagement.tcpBrokerBindAddress=tcp://localhost:61616
```

Change the scheme there too, and give the client a key store and trust store so
it can present a certificate. For a Spring Boot client that means an
`ActiveMQConnectionFactory` configured with the stores, since
`spring.activemq.*` properties alone do not carry them.

## What MRF will read afterwards

`broker_of` resolves the broker address and takes the scheme: `ssl` and
`stomp+ssl` are protected, `tcp` and `stomp` are not. It takes the **least
protected** connector the broker offers, so leaving either of the two
plaintext connectors in place leaves the finding exactly where it was.

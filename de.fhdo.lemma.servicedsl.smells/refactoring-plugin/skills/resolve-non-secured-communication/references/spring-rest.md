# Mutual TLS for a Spring REST server and its callers

Verify the Spring Boot version before choosing between the two server styles
below; SSL bundles need Boot 3.1 or newer. Lakeside Mutual is on Boot 3.3 with
Java 21, so bundles are available there.

## The server

Preferred on Boot 3.1+, because it keeps the store configuration in one place
and MRF recognises a bundle as implying TLS:

```properties
spring.ssl.bundle.jks.server.keystore.location=file:./certs/server.p12
spring.ssl.bundle.jks.server.keystore.password=changeit
spring.ssl.bundle.jks.server.keystore.type=PKCS12
spring.ssl.bundle.jks.server.truststore.location=file:./certs/truststore.p12
spring.ssl.bundle.jks.server.truststore.password=changeit
spring.ssl.bundle.jks.server.truststore.type=PKCS12

server.ssl.bundle=server
server.ssl.client-auth=need
```

The classic form, equivalent and valid on any version:

```properties
server.ssl.enabled=true
server.ssl.key-store=file:./certs/server.p12
server.ssl.key-store-password=changeit
server.ssl.key-store-type=PKCS12
server.ssl.trust-store=file:./certs/truststore.p12
server.ssl.trust-store-password=changeit
server.ssl.client-auth=need
```

`client-auth=need` is what makes this *mutual*. `want` is not sufficient: it
requests a client certificate and proceeds without one.

The port does not have to change, and changing it costs more than it is worth -
every caller's address and every deployment descriptor would move with it.

## The callers

Two edits per caller.

**1. The address.** Callers normally hold it in one property, and the scheme is
the whole point:

```properties
customercore.baseURL=https://localhost:8110
```

Search for the property across `src/main/resources` *and*
`src/test/resources` - a test profile commonly carries its own copy, and
leaving it on `http` breaks the build while the main configuration is correct.
Updating that property is part of the refactoring; disabling the test is not.

**2. A client that presents a certificate.** Plain TLS needs only trust;
*mutual* TLS means the client must send its own certificate, so the HTTP client
has to be built from both stores.

For `RestTemplate` on Boot 3.2+, the bundle can be handed to the builder
directly - verify the method exists in the version in use:

```java
@Bean
RestTemplate restTemplate(RestTemplateBuilder builder, SslBundles bundles) {
    return builder.sslBundle(bundles.getBundle("client")).build();
}
```

For `@FeignClient`, the TLS-capable client belongs in the `configuration` class
the annotation already names - in Lakeside Mutual that is
`CustomerCoreClientConfiguration`, so there is a natural home for it. Provide a
`feign.Client` backed by an HTTP client whose `SSLContext` is built from the
key store and the trust store. Whether Spring Cloud OpenFeign can consume an
`SslBundle` directly depends on its version; check before relying on it, and
fall back to building the `SSLContext` by hand.

## What MRF will read afterwards

- `server.ssl.enabled`, or a key store, or an SSL bundle → `tlsEnabled = true`
- `server.ssl.client-auth` → `clientAuth`
- the caller's resolved address scheme → `ServiceCall(scheme = "https")`

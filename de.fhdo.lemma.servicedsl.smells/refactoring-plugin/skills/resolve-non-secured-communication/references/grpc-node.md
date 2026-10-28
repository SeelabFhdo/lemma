# Mutual TLS for a gRPC endpoint served from Node

The endpoint a service binds, and the client that calls it. Unlike the broker
legs, this channel's caller may be a component the deployment does not run at
all - which changes what can be verified, not what has to be changed.

## The server

The plaintext form binds the port with credentials that authenticate nobody:

```js
server.bindAsync(
  `${config.host}:${config.port}`,
  grpc.ServerCredentials.createInsecure(),
  callback,
)
```

Mutual TLS replaces those credentials:

```js
server.bindAsync(
  `${config.host}:${config.port}`,
  grpc.ServerCredentials.createSsl(
    fs.readFileSync(config.caFile),                  // the authority to verify clients against
    [{
      private_key: fs.readFileSync(config.keyFile),  // this server's key pair
      cert_chain: fs.readFileSync(config.certFile),
    }],
    true,                                            // require a client certificate
  ),
  callback,
)
```

**The third argument is the mutual part.** `createSsl` without it, or with
`false`, encrypts the channel and authenticates only the server - which is TLS,
not mutual TLS, and a weaker refactoring than §3.7 cites. MRF reads that
argument and reports it as `GrpcServer.clientAuth`, so a channel secured
without it is reconstructed as TLS without client authentication and remains
distinguishable from the refactoring the paper prescribes.

The first argument must be the CA certificate, not this server's own
certificate: it is what incoming client certificates are verified against.

## The client

```js
const credentials = grpc.credentials.createSsl(
  fs.readFileSync(config.caFile),    // verify the server
  fs.readFileSync(config.keyFile),   // present this client's key pair
  fs.readFileSync(config.certFile),
)
const client = new proto.SomeService(`${config.host}:${config.port}`, credentials)
```

All three arguments are needed. `createSsl()` with none of them verifies the
server against the system roots and presents nothing, so the server rejects the
call once it requires a certificate.

**The address must match a name the certificate carries.** gRPC verifies the
server's host name, so a client addressing `localhost` needs `localhost` among
the certificate's `subjectAltName` entries - `references/certificates.md`
generates them for the compose service name, the short name, `localhost` and
`127.0.0.1` for exactly this reason. Do not disable verification to work around
a name mismatch; fix the name or the certificate.

## Paths belong in configuration

Add the three paths to the service's own configuration file, as the STOMP
recipe does - in Lakeside Mutual that is `config.json`, read through `nconf` -
rather than hardcoding them in the source.

## What the gates can and cannot see here

If the caller is not part of `docker-compose.yml`, the *starts* gate exercises
the server's binding but never the call. The build and the human review carry
that half, so state in the notes what you changed on the client and what you
could not exercise.

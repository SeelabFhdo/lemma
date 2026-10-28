# Mutual TLS for ActiveMQ over STOMP, from Node

The second connector of the broker, and the one easiest to forget because the
client is not a Java service and contributes no finding of its own.

## The broker side

```properties
policymanagement.stompBrokerBindAddress=stomp+ssl://0.0.0.0:61613?transport.needClientAuth=true
```

`stomp+ssl` is the TLS form of the STOMP transport and is what MRF recognises.
The broker's `SslContext` is shared with the OpenWire connector - see
`activemq-openwire.md`; configure it once.

## The Node client

A `stompit` client is configured from plain connect options. The plaintext form
looks like this:

```js
const connectOptions = {
  host: mq_config.host,
  port: mq_config.port,
  connectHeaders: { host: '/', login: ..., passcode: ... },
}
const connectFailover = new stompit.ConnectFailover([connectOptions])
```

TLS needs `ssl: true`, which makes `stompit` connect through Node's `tls`
module instead of `net`, plus the material for mutual authentication. The
remaining keys are passed through to `tls.connect`:

```js
const connectOptions = {
  host: mq_config.host,
  port: mq_config.port,
  ssl: true,
  ca: [fs.readFileSync(mq_config.caFile)],
  key: fs.readFileSync(mq_config.keyFile),
  cert: fs.readFileSync(mq_config.certFile),
  connectHeaders: { host: '/', login: ..., passcode: ... },
}
```

`key` and `cert` are the mutual part: without them the broker rejects the
connection once `needClientAuth` is set. Add the three paths to the service's
own configuration file rather than hardcoding them - in Lakeside Mutual that is
`config.json`'s `activemq` block, read through `nconf`.

**Do not set `rejectUnauthorized: false`.** It makes the connection succeed
while verifying nothing, which is a different security smell and defeats the
refactoring.

Confirm against the installed `stompit` version that `ssl` is the option name;
it is a thin wrapper over `tls.connect`, so the TLS keys themselves follow
Node's documentation.

## Why this matters even though it reports no finding

The Node consumer holds no `MessageChannel` aspect of its own, so no finding
points at it. But converting the broker and leaving this client on plaintext
STOMP clears six findings and leaves the system unable to run - which is
precisely what the verification step's "the system starts" condition exists to
catch.

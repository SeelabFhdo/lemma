# Development certificates for mutual TLS

Mutual TLS needs PKI material that cannot be invented: every peer needs a key
pair signed by a CA the other peer trusts. For a sample system being refactored
for evaluation, a throwaway CA is the right answer.

## Rules

- **Commit the script, never the output.** The generated stores and keys are
  build products, not source. Add them to `.gitignore` in the same patch.
- **One CA, one trust store, one key store per service.** A shared trust store
  holding the CA certificate is enough for every peer to verify every other.
- **Use the service name as the certificate's subject and a SAN.** Mutual TLS
  verifies hostnames; a certificate issued for `localhost` fails the moment the
  system runs under Docker Compose where peers address each other by service
  name. Include both.
- These certificates are for development only. Say so in the script's header,
  so the next reader does not mistake them for anything else.

## Shape of the script

Place it where the system's other scripts live and make it idempotent, so a
second run does not fail on existing files.

```bash
#!/usr/bin/env bash
# Generates throwaway certificates for mutual TLS between the services.
# DEVELOPMENT ONLY - the CA key is created here and trusted by every service.
set -euo pipefail

PASS=changeit
OUT=certs
SERVICES="customer-core policy-management customer-self-service risk-management"

mkdir -p "$OUT"

# One CA for the whole system.
keytool -genkeypair -alias ca -keyalg RSA -keysize 2048 -validity 365 \
    -dname "CN=Lakeside Mutual Dev CA" -ext bc:c \
    -keystore "$OUT/ca.p12" -storetype PKCS12 \
    -storepass "$PASS" -keypass "$PASS"

keytool -exportcert -alias ca -rfc \
    -keystore "$OUT/ca.p12" -storetype PKCS12 -storepass "$PASS" \
    -file "$OUT/ca.crt"

# A trust store every peer uses to verify the others.
keytool -importcert -noprompt -alias ca -file "$OUT/ca.crt" \
    -keystore "$OUT/truststore.p12" -storetype PKCS12 -storepass "$PASS"

for service in $SERVICES; do
    # Key pair, with the service name and localhost as subject alternatives.
    keytool -genkeypair -alias "$service" -keyalg RSA -keysize 2048 \
        -validity 365 -dname "CN=$service" \
        -ext "san=dns:$service,dns:localhost,ip:127.0.0.1" \
        -keystore "$OUT/$service.p12" -storetype PKCS12 \
        -storepass "$PASS" -keypass "$PASS"

    # Sign it with the CA, then import the chain back.
    keytool -certreq -alias "$service" \
        -keystore "$OUT/$service.p12" -storetype PKCS12 -storepass "$PASS" \
        -file "$OUT/$service.csr"

    keytool -gencert -alias ca -infile "$OUT/$service.csr" \
        -ext "san=dns:$service,dns:localhost,ip:127.0.0.1" \
        -keystore "$OUT/ca.p12" -storetype PKCS12 -storepass "$PASS" \
        -rfc -outfile "$OUT/$service.crt"

    keytool -importcert -noprompt -alias ca -file "$OUT/ca.crt" \
        -keystore "$OUT/$service.p12" -storetype PKCS12 -storepass "$PASS"
    keytool -importcert -noprompt -alias "$service" -file "$OUT/$service.crt" \
        -keystore "$OUT/$service.p12" -storetype PKCS12 -storepass "$PASS"
done
```

Run it and read the errors rather than trusting the shape above: `keytool`'s
`-gencert` and `-ext san=` syntax is fiddly and version-sensitive, and a chain
that imports without complaint can still fail at handshake time.

## For the Node client

`stompit` wants PEM files, not a PKCS#12 store, so export what it needs:

```bash
openssl pkcs12 -in certs/risk-management.p12 -passin pass:changeit \
    -nocerts -nodes -out certs/risk-management.key
openssl pkcs12 -in certs/risk-management.p12 -passin pass:changeit \
    -clcerts -nokeys -out certs/risk-management.crt
```

The CA certificate it verifies against is `certs/ca.crt`, already in PEM form.

## Verify before declaring success

A handshake either completes or it does not, and configuration that looks right
frequently does not handshake. Check one peer directly:

```bash
openssl s_client -connect localhost:8110 \
    -cert certs/policy-management.crt -key certs/policy-management.key \
    -CAfile certs/ca.crt
```

Mutual TLS is working when the server requests a certificate, accepts the one
presented, and the handshake returns `Verify return code: 0`.

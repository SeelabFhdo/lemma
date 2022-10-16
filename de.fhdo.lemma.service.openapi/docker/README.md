# LEMMA2OpenAPI Generator Docker Image
The `lemma/openapi_generator` Docker image bundles LEMMA's
[LEMMA2OpenAPI Generator](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.service.openapi)
in an executable form.

## Example Usage
The example concerns the generation of LEMMA models in the folder
`/home/user/generated models` from an OpenAPI specification file residing in the
filesystem at `/home/user/openapi.json`:
```bash
docker run -i \
    -v "/home/user":"/home/user" \
    -v "/home/user/generated models":"/home/user/generated models" \
    -u $(id -u ${USER}):$(id -g ${USER}) \
    lemma/openapi_generator:latest \
        -u "file:/home/user/openapi.json" \
        -d "DomainModelName" \
        -s "ServiceModelName" \
        -p "org.example" \
        -t "OpenApi" \
        -f "/home/user/generated models"
```

All commandline parameters of the LEMMA2OpenAPI Generator are mandatory and have
the following semantics:
- `-u, --url=<fetchUrl>`: URL pointing to the OpenAPI specification file
("file:/" or "https://" URI).
- `-d, --data_model_name=<dataModelName>`: Name for the generated LEMMA data
model.
- `-s, --service_model_name=<serviceModelName>`: Name for the generated LEMMA
service model.
- `-p, --service_qualifier=<serviceQualifier>`: Qualifier for generated LEMMA
microservice definitions in Java package notation.
- `-t, --technology_model_name=<technologyModelName>`: Name for the generated
LEMMA technology model.
- `-f, --target_folder=<targetFolder>`: Path to the folder where the generated
LEMMA models shall be saved.
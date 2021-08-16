# LEMMA Java Generator Docker Image
The `lemma/java_generator` Docker image bundles LEMMA's
[Java Base Generator](https://github.com/SeelabFhdo/lemma/tree/main/code%20generators/de.fhdo.lemma.model_processing.code_generation.java_base)
and its [Genlets](https://github.com/SeelabFhdo/lemma/tree/main/code%20generators)
in an executable form.

## Using the `run_model_processor.py` Script to Execute the Image
To facilitate the usage of the image, we provide the `run_model_processor.py`
Python script located in the `/scripts` folder of LEMMA's repository. The Python
script generalizes the execution of LEMMA model processors from the command line
and therefore expects as its first argument the path to a model processor
execution specification in the YAML file format.

When executed with such a specification, the script will first take care of the
local availability of the `lemma/java_generator` Docker image and guide the user
to install it, if it does not exist already. Furthermore, the script simplifies
the command line invocation of the Java Base Generator. To this end, the script
is executable from the command line with Python 3 and expects the following
arguments:
- `-b`: Base path. This is the base path for all model files. It will be mounted
        as a volume in the Docker container.
- `-s`: Source model. This is the source model file. It must be stated relative
        to the base path.
- `-i`: Intermediate model: This is the intermediate model file. It must be
        stated relative to the base path.
- `-t`: Target folder. Target folder for generated artifacts. It must be stated
        absolute and exist on the hard drive on which this script is executed.

Optional command line arguments:
- `-a`: Alternative intermediate service model. If stated, microservices will be
        generated based on this file, while domain concepts will be generated
        from the passed intermediate model. The alternative model must be stated
        relative to the base path.
- `-p`: Generation pattern. Must be any of the values `extended-generation-gap`,
        `generation-gap`, or `plain`. Defaults to `extended-generation-gap`.

### Example Usage
The example concerns the generation of microservices from a mapping model that
specifies technologies for domain concepts, and a service model that assigns
technology directly to microservices and their elements. Suppose the following
file system structure on the host that executes the script:
- Source mapping model: `/home/user/models/Mapping.mapping`
- Intermediate mapping model for domain concepts:
    `/home/user/intermediate models/mapping models/Mapping.xmi`
- Intermediate service model:
    `/home/user/intermediate models/service models/Service.xmi`

Execution of the script to generate microservices in folder
`/home/user/generated code`:
```bash
/scripts/run_model_processor.py \
    /code generators/de.fhdo.lemma.model_processing.code_generation.java_base/docker/execution.yaml \
    -b "/home/user" \
        -s "models/Mapping.mapping" \
        -i "intermediate models/mapping models/Mapping.xmi" \
        -a "intermediate models/service models/Service.xmi" \
    -t "/home/user/generated code"
```

The script will derive a `docker run -i` command from the above command line
parameters as follows:
```bash
docker run -i \
    -v "/home/user":"/home/user" \
    -v "/home/user/generated code":"/home/user/generated code" \
    -u $(id -u ${USER}):$(id -g ${USER}) \
    lemma/java_generator:latest \
        -s "/home/user/models/Mapping.mapping" \
        -i "/home/user/intermediate models/mapping models/Mapping.xmi" \
        -t "/home/user/generated code" \
        code_generation main \
            --code_generation_serializer=extended-generation-gap \
            --alternative_intermediate_service_model=/home/user/intermediate models/service models/Service.xmi
```
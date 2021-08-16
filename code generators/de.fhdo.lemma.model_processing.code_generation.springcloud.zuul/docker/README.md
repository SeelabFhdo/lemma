# LEMMA Spring Cloud Zuul Generator Docker Image
The `lemma/zuul_generator` Docker image bundles LEMMA's
[Spring Cloud Zuul Generator](https://github.com/SeelabFhdo/lemma/tree/main/code%20generators/de.fhdo.lemma.model_processing.code_generation.springcloud.zuul)
in an executable form.

## Using the `run_model_processor.py` Script to Execute the Image
To facilitate the usage of the image, we provide the `run_model_processor.py`
Python script located in the `/scripts` folder of LEMMA's repository. The Python
script generalizes the execution of LEMMA model processors from the command line
and therefore expects as its first argument the path to a model processor
execution specification in the YAML file format.

When executed with such a specification, the script will first take care of the
local availability of the `lemma/zuul_generator` Docker image and guide the
user to install it, if it does not exist already. Furthermore, the script
simplifies the command line invocation of the Spring Cloud Zuul Generator. To
this end, the script is executable from the command line with Python 3 and
expects the following arguments:
- `-b`: Base path. This is the base path for all model files. It will be mounted
        as a volume in the Docker container.
- `-s`: Source model. This is the source model file. It must be stated relative
        to the base path and cluster a LEMMA operation model.
- `-i`: Intermediate model: This is the intermediate model file. It must be
        stated relative to the base path and cluster a LEMMA intermediate
        operation model.
- `-t`: Target folder. Target folder for generated artifacts. It must be stated
        absolute and exist on the hard drive on which this script is executed.

### Example Usage
The example concerns the generation of artifacts with the image from a LEMMA
operation model and its intermediate representation. Suppose the following file
system structure on the host that executes the script:
- Source operation model: `/home/user/models/Operation.operation`
- Intermediate operation model:
    `/home/user/intermediate models/operation models/Operation.xmi`

Execution of the script to generate artifacts in folder
`/home/user/generated artifacts`:
```bash
/scripts/run_model_processor.py \
    /code generators/de.fhdo.lemma.model_processing.code_generation.springcloud.zuul/docker/execution.yaml \
    -b "/home/user" \
        -s "models/Operation.operation" \
        -i "intermediate models/operation models/Operation.xmi" \
    -t "/home/user/generated code"
```

The script will derive a `docker run -i` command from the above command line
parameters as follows:
```bash
docker run -i \
    -v "/home/user":"/home/user" \
    -v "/home/user/generated artifacts":"/home/user/generated artifacts" \
    -u $(id -u ${USER}):$(id -g ${USER}) \
    lemma/zuul_generator:latest \
        -s "/home/user/models/Operation.operation" \
        -i "/home/user/intermediate models/operation models/Operation.xmi" \
        -t "/home/user/generated code"
```
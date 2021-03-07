# LEMMA Static Analyzer Docker Image
The `lemma/static_analyzer` Docker image bundles LEMMA's
[Static Analyzer](https://github.com/SeelabFhdo/lemma/tree/master/de.fhdo.lemma.analyzer)
in an executable form.

## Using the `run_model_processor.py` Script to Execute the Image
To facilitate the usage of the image, we provide the `run_model_processor.py` Python
script located in the `/scripts` folder of LEMMA's repository. The Python script generalizes the execution of LEMMA model processors from the command line and therefore expects as its first argument the path to a model processor execution specification in the YAML file format.

When executed with such a specification, the script will first take care of the local availability of the `lemma/static_analyzer` Docker image and guide
the user to install it, if it does not exist already. Furthermore, the script
simplifies the command line invocation of the Static Analyzer. To this end,
the script is executable from the command line with Python 3 and expects the
following arguments:
- `-b`: Base path. This is the base path for all model files. It will be mounted
        as a volume in the Docker container.
- `-i`: Intermediate model: This is the intermediate model file. It must be
        stated relative to the base path. All static analyses basically happen on this file.

Optional command line arguments:
- `--additional_intermediate_model`: Additional intermediate model file to consider for static
                                     analysis. The argument excepts the assignment of the
                                     additional intermediate model file relative to the given base
                                     path. The argument may occur more than once for different
                                     intermediate model files.
- `--analysis_module`: Module for the static analysis to execute. By default, the Static Analyzer
                       executes all modules being applicable to the given intermediate model files.
                       The argument may occur more than once for different analysis modules.
- `--csv_file`: Absolute path to a CSV file that shall receive the results of a static analysis.
- `--csv_column_prefix`: Additional prefix for columns in the CSV file.
- `--csv_variable_separator`: Separator for variable parts of a CSV column, e.g., the name of a
                              microservice. Defaults to an underscore. This argument does **not**
                              impact the separator for CSV values, which is always a semicolon.
- `--print_value_store`: Print the contents of the store of collected analysis values (for
                         debugging purposes).

### Example Usage
The example concerns the analysis of two microservices from two different service models. Suppose the following file system structure on the host that executes the script:
- Intermediate service model for Microservice 1:
    `/home/user/intermediate models/service models/Service1.xmi`
- Intermediate service model for Microservice 2:
    `/home/user/intermediate models/service models/Service2.xmi`

Execution of the script to analyze the microservices and store the results in the CSV file `/tmp/analysis.csv`:
```bash
/scripts/run_model_processor.py \
    /de.fhdo.lemma.analyzer/docker/execution.yaml \
    -b "/home/user" \
        -i "intermediate models/service models/Service1.xmi" \
        --additional_intermediate_model="intermediate models/service models/Service2.xmi" \
    --csv_file="/tmp/analysis.csv"
```

The script will derive a `docker run -i` command from the above command line
parameters as follows:
```bash
docker run -i \
    -v "/home/user":"/home/user" \
    -v "/tmp":"/tmp" \
    -u $(id -u ${USER}):$(id -g ${USER}) \
    lemma/static_analyzer:latest \
        -i "/home/user/intermediate models/service models/Service1.xmi" \
        --additional_intermediate_model="/home/user/intermediate models/service models/Service2.xmi" \
        --csv_file="/tmp/analysis.csv"
```
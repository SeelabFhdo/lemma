# Example LEMMA Code Generator

This project illustrates the implementation of code generators using
[LEMMA's model processing framework](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.model_processing).
In general, this framework aims to facilitate the implementation of processors (e.g., code generators but also static
analyzers or visualizers) for LEMMA models.

## Included Example LEMMA Models
The example code generator expects a LEMMA service model and its
[intermediate representation](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.service.intermediate.metamodel/doc/build/html)
as input. Therefore, the project clusters the [`example models`](example%20models) folder, which stores two LEMMA
service models ([`Order.services`](example%20models/microservices/Order.services) and
[`Restaurant.services`](example%20models/microservices/Restaurant.services)) as well as their intermediate
representations ([`Order.xmi`](example%20models/intermediate/service%20models/Order.xmi) and
[`Restaurant.xmi`](example%20models/intermediate/service%20models/Restaurant.xmi)).

## Build and Execution
To invoke the example code generator, you first need to build its standalone JAR application using the provided
[`build.sh`](build.sh) script. Next, you can run the code generator on the
[`Order.services`](example%20models/microservices/Order.services) model and its intermediate representation
[`Order.xmi`](example%20models/intermediate/service%20models/Order.xmi) leveraging the [`run.sh`](run.sh) script. To
execute the generator for the [`Restaurant.services`](example%20models/microservices/Restaurant.services) model and
its intermediate representation [`Restaurant.xmi`](example%20models/intermediate/service%20models/Restaurant.xmi) you
can change the arguments of the `--source_model` and `--intermediate_model` commandline options in the
[`run.sh`](run.sh) script to point to the [`Restaurant.services`](example%20models/microservices/Restaurant.services)
and [`Restaurant.xmi`](example%20models/intermediate/service%20models/Restaurant.xmi) files, respectively. Please note
that both the build and execution of the code generator require Java 11 or higher.

## Source Code
The code of the generator comprises extensive comments to foster the understanding of code generation implementation
using LEMMA's model processing framework. However, for a facilitated comprehension of the source code it is advisable to
study its files in the following order:
1. [`build.gradle.kts`](build.gradle.kts): This file identifies the necessary dependencies for the development of model
  processors based on LEMMA's model processing framework.
2. [`ExampleModelProcessor.java`](src/main/java/de/fhdo/lemma/examples/model_processing/ExampleModelProcessor.java):
  This class implements the entrypoint of the example code generator.
3. [`LanguageDescriptions.java`](src/main/java/de/fhdo/lemma/examples/model_processing/LanguageDescriptions.java): This
  class illustrates how modeling languages are registered to provide LEMMA's model processing framework with the
  required information to parse input models.
4. [`SourceServiceModelValidator.java`](src/main/java/de/fhdo/lemma/examples/model_processing/SourceServiceModelValidator.java):
  This class realizes a source model validator as expected by LEMMA's model processing framework. A source model
  validator is capable of checking LEMMA models
  [that were constructed with the Eclipse IDE](https://seelabfhdo.github.io/lemma-docs/getting-started/tour/index.html)
  for their compliance with a model processor's expectations. In the case of the example code generator, the model
  processing framework will invoke the validator for an input model with the ".services" extension, e.g.,
  [`Order.services`](example%20models/microservices/Order.services) or
  [`Restaurant.services`](example%20models/microservices/Restaurant.services).
5. [`IntermediateServiceModelValidator.java`](src/main/java/de/fhdo/lemma/examples/model_processing/IntermediateServiceModelValidator.java):
  This class realizes an intermediate model validator as expected by LEMMA's model processing framework. By contrast to
  source model validators, intermediate model validators can perform LEMMA model checking based on intermediate
  representations and thus make use of the facilitated access to modeled information. In the case of the example code
  generator, the model processing framework will invoke the validator for an input model in the
  [XMI format](https://www.omg.org/spec/XMI/2.5.1/About-XMI/), e.g.,
  [`Order.xmi`](example%20models/intermediate/service%20models/Order.xmi) or
  [`Restaurant.xmi`](example%20models/intermediate/service%20models/Restaurant.xmi).
6. [`ExampleCodeGenerationModule.java`](src/main/java/de/fhdo/lemma/examples/model_processing/ExampleCodeGenerationModule.java):
  This class implements a code generation module that produces a text file from a given intermediate model. More
  specifically, the module generates the `results.txt` file in the `generated code` folder of the example code generator
  project (cf. the argument of the `--target_folder` commandline option in the [`run.sh`](run.sh) script).

## Generating Code from Other Models Than the Included Example LEMMA Models
In case you have [constructed your own LEMMA service models with the Eclipse IDE](https://seelabfhdo.github.io/lemma-docs/getting-started/tour/index.html)
and want to execute the example code generator on them, you first have to produce corresponding intermediate
representations for them. With the intermediate representations we aim to facilitate the processing of LEMMA models in a
similar fashion as Java with its bytecode format and the Java Virtual Machine. Consequently, if you want to write your
LEMMA model processor, you should have a look at the intermediate specifications for the various modeling languages of
LEMMA. You can find the specifications in LEMMA's source code repository:
- [Specification for LEMMA domain models (constructed with LEMMA's Domain Data Modeling Language)](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.data.intermediate.metamodel/doc/build/html)
- [Specification for LEMMA service models (constructed with LEMMA's Service Modeling Language)](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.service.intermediate.metamodel/doc/build/html)
- [Specification for LEMMA operation models (constructed with LEMMA's Operation Modeling Language)](https://github.com/SeelabFhdo/lemma/tree/main/de.fhdo.lemma.operation.intermediate.metamodel/doc/build/html)

You can produce intermediate representations for your own models using your
[LEMMA Eclipse installation](https://seelabfhdo.github.io/lemma-docs/getting-started/index.html):
1. Right click on the service or operation model for which you want to acquire its intermediate representation, and in
  the opening context menu select the entry "Generate Intermediate X Models" (where X is either "Service" or
  "Operation").
2. In the opening dialog hit the button "Select all models and continue".
3. In the following dialog tick the checkbox "Convert absolute URIs in models to relative URIs" to make the intermediate
  models portable and hit the button "OK".

The last step results in a folder called `intermediate` in the root directory of your LEMMA Eclipse project (cf., e.g.,
the [`intermediate` folder](example%20models/intermediate) for the example models provided with the example code
generator). With the intermediate models at hand, you can adapt the arguments for the `--source_model` and
`--intermediate_model` commandline options in the [`run.sh`](run.sh) script to point to a source service model (e.g.,
`/PATH_TO_YOUR_ECLIPSE_PROJECT/microservices/MyService.services`) and its intermediate representation (e.g.,
`/PATH_TO_YOUR_ECLIPSE_PROJECT/intermediate/service models/MyService.xmi`), respectively.
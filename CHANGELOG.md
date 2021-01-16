# Changelog
All notable changes to [LEMMA](https://github.com/SeelabFhdo/lemma/) will be documented in this file.

## [0.8.0] - 2021-01-16
### Added
- Data DSL: Enable other complex types besides data structures to become Parts of an Aggregate.
- Data DSL: Add extractor plugin.
- Data DSL: Enable DDD feature specification for enumerations.
- Documentation: Enable Docker build of documentations for intermediate metamodels.
- Intermediate Model Transformations: Add intermediate operation model transformation (contributed by [Philip Wizenty](github.com/pwizenty)).
- Java Base Generator: Add support for Java's `UUID` type.
- Java Base Generator: Dockerize the generator to make it portable.
- Java Base Generator: Accompany the generator with a Python script to facilitate its Docker-based execution.
- Java Base Generator: Support plain serialization of enumerations.
- Java Base Generator: Add events to inform Genlets that they were loaded and that the overall code generation was finished.
- Java Base Generator: Add explicitly invoked code generation module `shared` to enable generation of shared libraries from a set of intermediate domain models.
- Java Base Generator: Add support for custom constructors, deactivation of initializing constructors and adaptation of their visibility.
- Live Validation Framework: Introduce `--timeout_threshold` commandline option to configure the maximum response time of validation clients.
- Mapping DSL: Add extractor plugin.
- Model Processing Framework: Enable implementers to access arguments of validation phases.
- Model Processing Framework: Introduce `@BeforeCheck` annotation to influence the execution of `@Check` methods in intermediate model validators.
- Model Processing Framework: Introduce `@RethrowExceptions` annotation for intermediate model validator debugging.
- Operation DSL: Integrate import concept for operation models (contributed by [Philip Wizenty](github.com/pwizenty)).
- Releng: Add build scripts for Windows.
- Releng: Enable Maven build of Eclipse updatesite.
- Releng: Enable LEMMA modules to provide their own Docker images, e.g., for code generator execution.
- Service DSL: Allow numbers with trailing periods in API comments.
- Spring Cloud Genlet: Add `AttributeOverride` as synonym for the `AttributeOverrideColumn` aspect.
- Spring Cloud Genlet: Generate corresponding Spring annotations for data structure features `Entity`, `Repository`, and `Service`.
- Spring Cloud Genlet: Add support for `Access`, `Enumerated`, `Transactional`, and `Version` aspects.
- Spring Cloud Genlet: Add support for `CrudRepository` interfaces.
- Spring Cloud Genlet: Add `spring-boot-starter-data-jpa` dependency for data structures with `Entity` feature.
- Spring Cloud Genlet: Add support for new `Application` aspect, which combines Spring Boot application name and port.
- Spring Cloud Genlet: Add Domain Events sub-Genlet.
- Spring Cloud Genlet: Add CQRS sub-Genlet.
- UI: Enable execution of intermediate operation model transformations (contributed by [Philip Wizenty](github.com/pwizenty)).
- Add code generator to automatically derive Docker containers from operation models (contributed by [Philip Wizenty](github.com/pwizenty)).
- Add code generator for MariaDB (contributed by [Philip Wizenty](github.com/pwizenty)).
- Add code generator for MongoDB (contributed by [Philip Wizenty](github.com/pwizenty)).
- Add code generator for Spring Cloud Zuul (contributed by [Philip Wizenty](github.com/pwizenty)).
- Add code generator for Spring Cloud Eureka (contributed by [Philip Wizenty](github.com/pwizenty)).
- Add plugin to generate Apache Avro schema specifications from LEMMA models and vice versa.
- Add Python script to facilitate the execution of LEMMA model processors within Docker containers.
- Add Spring Cloud Kafka Genlet.
- Add Static Analyzer Library and standalone executable Static Analyzer.
- Support MIME types as data formats.

### Changed
- Data DSL: Fix range check for Double and Float values in metamodel.
- DDD Genlet: If target node is interface, extend it with tagging interface.
- Example 3: Add a more comprehensive and updated version of the example models.
- Examples: Reorganize and give each example a sensible name.
- Intermediate Model Transformations: Add missing assignment of `ENUMERATION` kind to intermediate complex types.
- Intermediate Model Transformations: Remove preceding `#` from enumeration literals when converting them to strings.
- Intermediate Model Transformations: Preserve original type of parameters in `IntermediateParameter` instances.
- Java Base Generator: Let Maven dependency serializer also generate `maven.compiler.source` and `maven.compiler.target` properties in `pom.xml`.
- Java Base Generator: Throw exception when no Java microservice could be found in intermediate service model.
- Java Base Generator: Don't generate new artifact version in Maven dependency serializer, if passed version is already a valid Maven version.
- Java Base Generator: Make code generation serializers aware of getter and setter imports in composite classes generated from parameter lists.
- Java Base Generator: Add event to inform Genlets that the next intermediate `EObject` is about to get processed.
- Java Base Generator: Let Generation Gap/Extended Generation Gap serializers plain-serialize interfaces.
- Java Base Generator: Consider imports in Generation Gap/Extended Generation Gap serializers when merging callables of existing classes.
- Java Base Generator: Don't let serializers add `throw` statement to non-`void` methods if they already contain a `throw` statement.
- Java Base Generator: Methods of DDD factories become static by default.
- Java Base Generator: Add support for merging `"repositories` elements from different POM files to Maven serializer.
- Java Base Generator: Enable Genlets to store and retrieve arbitrary, Genlet-specific values at runtime.
- Java Base Generator: Enable Genlets to add arbitrary information to generated nodes. Added information are shared across all Genlets.
- Java Base Generator: Automatically convert relative import URIs to absolute URIs
- Java Base Generator: Recognize aspects with name `ApplicationProperty` as providers for custom application properties.
- Mapping DSL: Add missing scoping for types in data operation parameter mappings.
- Mapping DSL: Fix multiplicity of endpoints in microservice mappings.
- Mapping DSL: Fix scoping of enumeration fields.
- Model Processing Framework: Change check for microservice technology to be case-insensitive by default.
- Model Processing Framework: Introduce `@ExplicitlyInvokedCodeGenerationModule` annotation for code generation modules that need to be explicitly invoked from the commandline.
- Operation DSL: An operation node may now either be dependent on or used by the same operation node but not both (contributed by [Philip Wizenty](github.com/pwizenty)).
- Releng: Dockerize LEMMA builds.
- Releng: Don't clone LEMMA repository twice during builds.
- Releng: Fix errorlevel checking of batch scripts in Windows build.
- Releng: Use LEMMA version as actual version of modules.
- Releng: Enable continuous deployment with Jenkins.
- Service, Mapping, and Operation DSLs: Fix validations of aspect uniqueness.
- Spring Cloud Genlet: Support aspects with `Spring` qualifier.
- Spring Cloud Genlet: Always specify `scanBasePackages` element for `SpringBootApplication` annotations.
- Spring Cloud Genlet: Always add `spring-boot-starter-web dependency` for generated microservice.
- UI: Fix information text in service model selection dialog.
- UI: Enable intermediate model generation in Package Explorer and for Java Projects.
- UI: Consider file extension when starting intermediate model generation from single model file.
- Upgrade plugins to Eclipse 4.15 (2020-03) and enable Java 11 Maven/Gradle builds for all projects.
- Lots of minor technical bugfixes.

### Removed
- Intermediate Model Transformations: Remove dependencies of intermediate service model on Data, Service, and Technology metamodels.

## [0.7.0] - 2020-04-04
### Added
- Data DSL: Add primitive type `unspecified` for modeling the intended absence of an explicit type information on data fields.
- Intermediate Model Transformations: Add missing metamodel element descriptions to documentation.
- Intermediate Model Transformations: Add `qualifiedName` to `IntermediateImportedAspect`.
- Intermediate Model Transformations: Support transformations within Eclipse projects whose files are not physically located within the current workspace's root.
- Model Processing: Add model processing and Java/Spring code generation frameworks.
- Service DSL: Enable modeling of versions on interfaces.
- UI: Add action to context menu of Project Explorer to enable generation of intermediate models from selected resources only.
- UI: Add convenience "Select all models and continue" button to model selection dialog.
### Changed
- Data DSL: Change supported `date` formats to ISO date, time, and datetime.
- Intermediate Model Transformations: Fix handling of Windows file separators.
- Intermediate Model Transformations: Fix transformation when service and corresponding mapping model are transformed together.
- Intermediate Model Transformations: Always assign `originalType` in intermediate data models according to the documentation.
- Mapping DSL: Turn error on duplicate endpoints into a warning and thus introduce consistency with Service and Operation DSL.
- Operation DSL: Fix checking of mandatory property values on infrastructure nodes that do not deploy services.
- Releng: Fix build scripts (contributed by [Philip Wizenty](github.com/pwizenty)).
- Releng: Rename `build/languages.sh` to `build/lemma.sh`.
- Technology DSL: Fix checking of technology-specific primitive type mappings when first technology-specific type mapping is not a default mapping.
- UI: Display erroneous models in model selection dialog again. They will be filtered and not displayed in the transformation target path specification dialog.
- UI: Change transformation target path specification dialog to prevent the selection of erroneous models imported by correct models.
- UI: The "Generate Intermediate Models..." menu entries now use resources selected in the Project Explorer to determine the model files to be transformed to intermediate models. In case no resources were selected, all models from the workspace are considered potential model files for the transformation (same behavior as before).
- Several minor technical bugfixes.
### Removed
- Remove Xtext-generated `.java._trace` and `.xtendbin` files from tree.

## [0.6.0] - 2019-08-28
### Added
- Data DSL: Enable modeling of operations (functions and procedures) within data structures.
- Data DSL: Enable specification of prescribed features for data structures, data fields, and data operations. The initial set of supported features comprises patterns from [Domain-driven Design (DDD)](https://www.domainlanguage.com). Constraint violations of pattern specifications are checked and shown as warnings in the Data DSL editor according to our [2018 paper](http://fmse.di.unimi.it/faacs2017/papers/paperMSE1.pdf). Furthermore, the initial set of provided features includes the ```neverEmpty``` feature, which allows to express that a data field should never be empty, i.e., always provide a value to callers.
- Data DSL: Enable specification of immutable data fields.
- Data DSL: Enable modeling of initialization values for data fields in data structures.
- Mapping DSL: Enable mapping of complex types. Aspects may now be assigned to complex types and their fields. Moreover, fields of complex types may be "re-typed" now with technology-specific types.
- Mapping DSL: Aspects can now be assigned to enumeration fields.
- Mapping DSL: Improve grammar consistency: All aspect specifications now need to be completed with a semicolon.
- Mapping DSL: Extend the built-in ```@technology``` annotation with a flag (```typedef```) to explicitly specify the default type definition technology of mapped complex types and microservices.
- Operation DSL: Infrastructure nodes may now be modeled as being dependent on other infrastructure nodes and containers. Furthermore, it may now be distinguished between the usage of an infrastructure node by a service, or a whole infrastructure node or container.
- Operation DSL: Improve grammar consistency: All aspect specifications now need to be completed with a semicolon.
- Operation DSL: Restrict scope of aspect technologies to those annotated on an operation node.
- Operation DSL: Provide alternative, "call-like" notation for property value assignment. Next to ```property = value```, it is now also possible to write ```property(value)```.
- Service DSL: Provide alternative, "call-like" notation for property value assignment. Next to ```property = value```, it is now also possible to write ```property(value)```.
- Service DSL: Extend the built-in ```@technology``` annotation with a flag (```typedef```) to explicitly specify the default type definition technology of a microservice.
- Service DSL: Enable API commenting. API comments can be placed above service operations as the first element (i.e., above possible built-in or technology aspect annotations and the operation name). API comments are enclosed in a pair of three subsequent dashes (```---```) and start with a text describing the service operation as part of the API. After the description text, parameters of the operation may be commented leveraging the following pattern: ```@[API_PARAM_SPEC] [parameterName] [parameterDescriptionText]``` with ```API_PARAM_SPEC``` being either ```param``` (optional parameters) or ```required``` (required parameters).
- Technology DSL: Enable specification of prescribed features for service and operation aspects. The ```singleval``` feature allows for modeling that an aspect may only be assigned once to a target element.
- Technology DSL: Enable specification of prescribed features for aspect, service, and operation properties. The  ```mandatory``` feature allows for specifying that the property needs to receive a value. The ```singleval``` feature allows for specifying that the property may receive a value exactly once.
- Technology DSL: Provide ```technology``` pointcut selector for operation aspects.

### Changed
- Rename the project from "Domain-driven Microservice Modeling (DDMM)" to "Language Ecosystem for Modeling Microservice Architecture (LEMMA)".
- Data DSL: Don't consider technology-specific types in scoping of imported complex types.
- Data DSL: Fixed scoping of local and imported complex types.
- Mapping DSL: The emptyness check of mapping models now considers mapped data fields.
- Mapping DSL: Fixed validation of non-existing aspect properties.
- Mapping DSL: Fixed assignment of more than one property value.
- Mapping DSL: Prevent import leaking.
- Mapping DSL: Don't show a type incompatibility warning for complex types.
- Mapping DSL: Consider existing endpoints in service models when checking for duplicate endpoints.
- Mapping DSL: Duplicate endpoint addresses now produce warnings instead of errors.
- Intermediate Model Transformations: Fix mapping model transformation so that it correctly relates service models and corresponding mapping models.
- Intermediate Model Transformations: Fix simultaneous transformation of service and mapping models that map elements from the service models.
- Operation DSL: Consider protocols when validating if technology models are usable in operation models.
- Service DSL: Fixed scoping of aspects that specify protocol and data format selectors.
- Service DSL: Fixed scoping of aspects on first operation of an interface.
- Service DSL: Duplicate endpoint addresses now produce warnings instead of errors.
- Technology DSL: Fix validation of default primitive types.
- Technology DSL: Don't highlight pointcuts in selectors as keywords.
- Technology DSL: Allow specification of protocols for only one communication type.
- Technology DSL: Aspect pointcut selectors will only be applied to a join point, if all of their pointcuts are applicable to that join point. For instance, the selector ```protocol=rest, exchange_pattern=in``` will not apply to microservices, because this join point does not support the ```exchange_pattern``` pointcut. Instead, an additional selector would need to be specified for the microservices join point with ```protocol=rest``` alone.
- Transformation: Only produce intermediate endpoints for all protocol/format combinations, if the protocol does not specify a default data format in its technology model. Applies to intermediate service model transformations.
- Tooling: The Maven buildscript now shows notifications when the build of a module has finished.
- UI: Add keyword highlighting for boolean values.
- UI: Don't allow transformation of erroneous models.

### Removed
- Service DSL: It is not possible anymore to use single-quotes (```'```) to enclose strings. Instead, double-quotes (```"```) must be used. If double-quotes must be included in strings as literals, they can be escaped to ```\"```. Consequently, the string ```'Beware the Jubjub bird, and shun the frumious "Bandersnatch"!'``` must be transformed to ```"Beware the Jubjub bird, and shun the frumious 'Bandersnatch'!"``` or ```"Beware the Jubjub bird, and shun the frumious \"Bandersnatch\"!"```.

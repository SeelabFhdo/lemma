# Changelog
All notable changes to [LEMMA](https://github.com/SeelabFhdo/lemma/) will be documented in this file.

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
- Releng: Fix build scripts (kudos to [Philip Wizenty](github.com/pwizenty)).
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

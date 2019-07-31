# Changelog
All notable changes to [LEMMA](https://github.com/SeelabFhdo/lemma/) will be documented in this file.

## [0.6.0] - 2019-MM-DD
### Added
- Data DSL: Enable modeling of operations (functions and procedures) within data structures.
- Data DSL: Enable specification of prescribed features for data structures, data fields, and data operations. The initial set of supported features comprises patterns from [Domain-driven Design (DDD)](https://www.domainlanguage.com). Constraint violations of pattern specifications are checked and shown as warnings in the Data DSL editor according to our [2018 paper](http://fmse.di.unimi.it/faacs2017/papers/paperMSE1.pdf). Furthermore, the initial set of provided features includes the ```neverEmpty``` feature, which allows to express that a data field should never be empty, i.e., always provide a value to callers.
- Data DSL: Enable specification of immutable data fields.
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
- Operation DSL: Consider protocols when validating if technology models are usable in operation models.
- Service DSL: Fixed scoping of aspects that specify protocol and data format selectors.
- Service DSL: Fixed scoping of aspects on first operation of an interface.
- Service DSL: Duplicate endpoint addresses now produce warnings instead of errors.
- Technology DSL: Fix validation of default primitive types.
- Technology DSL: Don't highlight pointcuts in selectors as keywords.
- Technology DSL: Allow specification of protocols for only one communication type.
- Transformation: Only produce intermediate endpoints for all protocol/format combinations, if the protocol does not specify a default data format in its technology model. Applies to intermediate service model transformations.
- Tooling: The Maven buildscript now shows notifications when the build of a module has finished.
- UI: Add keyword highlighting for boolean values.
- UI: Don't allow transformation of erroneous models.

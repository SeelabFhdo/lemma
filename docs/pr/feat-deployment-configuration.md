## Summary

A reconstructed container carries the configuration MRF read from its
`application.properties`, so the operation model states it as `default values`:

```diff
 container CustomerCoreContainer
     @technology(deploymentBase)
     deployment technology deploymentBase::_deployment.Kubernetes
+    default values {
+        springApplicationName = "customer-core"
+        serverPort = 8110
+    }
     deploys CustomerCore::…CustomerCore
```

The model switches from `deployment_base_relaxed.technology` to the strict
`deployment_base.technology`, which marks `springApplicationName` and
`serverPort` as mandatory. That is met because a container that deploys a
microservice carries both, and one that deploys none is left out of the model
anyway.

Values are not carried to an infrastructure node: `SpringBootAdmin` declares
`applicationName` and `port` where a deployment technology declares
`springApplicationName` and `serverPort`, so the reconstructed keys would name
properties that do not exist.

## Evidence

Generated into `LakesideMutual/System`, five containers each with both values,
`architecture.operation` importing the strict model.

`checkMandatoryPropertiesHaveValues` (`OperationDslValidator.xtend:367`) would
fault a container missing both; no such container is generated. The infrastructure
side is safe because every `service properties` block of `spring.technology` is
free of `<mandatory>`.

The value shape was the part most likely to be wrong, so it was traced: the
writer extracts to text **before** `maskIssues` re-parses, and the extractor
prints `numericValue` bare and `stringValue` quoted, so the file reads
`serverPort = 8110` and `springApplicationName = "customer-core"` and type-checks
against `int` and `string`.

Includes two corrections found by running it: `nullOrEmpty` is not defined on
`Map`, and Xtend compiles an unresolved call into a statement that throws when
reached rather than failing the build — so it surfaced as a wizard exception on
the first container instead of a build error.

## Merge Danger

**Door:** two-way. Additive; no file deleted.

**Blast Radius:** operation models

Requires the matching MRF branch; without it a container carries no
`ServiceProperties` meta-data and the strict technology model would fault every
container that deploys a service.

🤖 Generated with [Claude Code](https://claude.com/claude-code)

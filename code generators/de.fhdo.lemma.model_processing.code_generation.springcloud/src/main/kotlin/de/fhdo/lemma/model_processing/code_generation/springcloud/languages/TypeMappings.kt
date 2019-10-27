package de.fhdo.lemma.model_processing.code_generation.springcloud.languages

import de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.TypeMappingDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.primitiveTypeMappings

/**
 * Genlet-specific type mappings.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val genletTypeMappings = primitiveTypeMappings {
    technology {
        (
            "AuthenticationException"
                    withImport "org.springframework.security.core.AuthenticationException"
                    withDependency "org.springframework.security:spring-security-core:5.1.6.RELEASE"
        )
        (
            "GrantedAuthorities" mapsTo "List<GrantedAuthority>"
                    withImport "org.springframework.security.core.GrantedAuthority" andImport "java.util.List"
                    withDependency "org.springframework.security:spring-security-core:5.1.6.RELEASE"
        )
            "HttpServletRequest" withImport "javax.servlet.http.HttpServletRequest"
    }
}

/**
 * Convenience function to get a [TypeMappingDescription] from an [IntermediateType] instance. This first tries to find
 * the mapping from [genletTypeMappings], before it calls [getTypeMapping] from the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateType.getGenletTypeMapping() : TypeMappingDescription?
    = if (this is IntermediateImportedTechnologySpecificType)
            genletTypeMappings[this] ?: getTypeMapping()
        else
            getTypeMapping()
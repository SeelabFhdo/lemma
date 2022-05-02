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
            ("AuthenticationException" to "org.springframework.security.core.AuthenticationException")
                .mapsToSelfWithImportForFullyQualifiedName()
                withDependency "org.springframework.security:spring-security-core:5.1.6.RELEASE"
        )
        (
            "GrantedAuthorities" mapsTo "Collection<? extends GrantedAuthority>"
                withImport "org.springframework.security.core.GrantedAuthority" andImport "java.util.Collection"
                withDependency "org.springframework.security:spring-security-core:5.1.6.RELEASE"
        )
            ("HttpServletRequest" to "javax.servlet.http.HttpServletRequest")
                .mapsToSelfWithImportForFullyQualifiedName()
        (
            "UserDetails" mapsTo "UserDetails"
                    withImport "org.springframework.security.core.userdetails.UserDetails"
                    withDependency "org.springframework.security:spring-security-core:5.1.6.RELEASE"
        )
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

/**
 * Check if there exists a Genlet-specific mapping for the given [type].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun existsTechnologySpecificMappingForType(type: String)
    = genletTypeMappings.getTechnologySpecificMapping(type) != null

/**
 * Get Genlet-specific mapping for the given [type] if it exists.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun getTechnologySpecificMappingForType(type: String) = genletTypeMappings.getTechnologySpecificMapping(type)
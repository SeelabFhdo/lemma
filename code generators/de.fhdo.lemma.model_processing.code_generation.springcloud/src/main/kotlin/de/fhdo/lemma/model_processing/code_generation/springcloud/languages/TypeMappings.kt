package de.fhdo.lemma.model_processing.code_generation.springcloud.languages

import de.fhdo.lemma.model_processing.code_generation.java_base.languages.primitiveTypeMappings

private val primitiveTypeMappings = primitiveTypeMappings {
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
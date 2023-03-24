package de.fhdo.lemma.analyzer.lib.impl.antipattern

enum class AntipatternType(val displayName: String) {
    API_VERSIONING("API-Versioning"),
    CYCLIC_DEPENDENCY("Cyclic Dependencies"),
    USAGE_ESB("Usage Enterprise Service Bus"),
    HARDCODED_ENDPOINTS("Hardcoded Endpoints"),
    NO_API_GATEWAY("No API-Gateway"),
    SHARED_PERSISTENCE("Shared Persistence"),
    LOCAL_LOGGING("Local Logging"),
    NO_MONITORING("Missing Monitoring"),
}

data class Antipattern(val type: AntipatternType, val message: String)


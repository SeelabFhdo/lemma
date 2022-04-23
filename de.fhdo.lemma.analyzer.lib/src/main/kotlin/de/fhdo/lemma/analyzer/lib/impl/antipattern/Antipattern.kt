package de.fhdo.lemma.analyzer.lib.impl.antipattern

enum class AntipatternType(val displayName: String) {
    API_VERSIONING("API-Versioning"),
    CYCLIC_DEPENDENCY("Zyklische Abhängigkeiten"),
    USAGE_ESB("Verwendung eines Enterprise Service"),
    HARDCODED_ENDPOINTS("Hardcodierte Endpoints"),
    NO_API_GATEWAY("Kein API-Gateway"),
    SHARED_PERSISTENCE("Geteilte Persistenz"),
    LOCAL_LOGGING("Lokales Logging"),
    NO_MONITORING("Mangelndes Monitoring"),
}

data class Antipattern(val type: AntipatternType, val message: String)


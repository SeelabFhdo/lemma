package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

internal object Context {
    object State {
        private var currentApplicationPropertiesFile: PropertyFile? = null


        fun initialize(currentIntermediateMicroservice: IntermediateMicroservice) {
            currentApplicationPropertiesFile = openPropertyFile(
                GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH,
                "application.properties")
        }
        fun reset() {
            currentApplicationPropertiesFile = null
        }

        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
            val value = when(property.name) {
                "currentApplicationPropertiesFile" -> currentApplicationPropertiesFile
                else -> throw IllegalArgumentException("State does not comprise property ${property.name}")
            }
            return value as T
        }
    }
}

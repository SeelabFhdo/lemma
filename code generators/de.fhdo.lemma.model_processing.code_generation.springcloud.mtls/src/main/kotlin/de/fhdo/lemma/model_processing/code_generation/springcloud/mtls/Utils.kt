package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

internal fun EObject.getAspectValueOrDefault(fullyQualifiedName: String): List<Pair<String, String>> {
    val listOfProperties = mutableListOf<Pair<String, String>>()
    this.getAllAspects(fullyQualifiedName).forEach { aspect ->
        aspect.properties.forEach { property ->
            listOfProperties.add(
                Pair(
                    property.name,
                    aspect.propertyValues.findValue(property.name) ?: property.defaultValue
                )
            )
        }
    }
    return listOfProperties
}

private fun EList<IntermediateAspectPropertyValue>.findValue(name: String) =
    find { it.property.name.equals(name) }?.value

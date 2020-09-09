package de.fhdo.lemma.model_processing.code_generation.ddd

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.*

internal fun ClassOrInterfaceDeclaration.getDddElementsForFeatures(features: Set<String>) : DddTaggingElements {
    val taggingInterfaces = mutableMapOf<String, String>()
    features.forEach {
        val taggingInterface = determineTaggingInterface(it)
        if (taggingInterface != null)
            taggingInterfaces[taggingInterface.first] = taggingInterface.second
    }

    return DddTaggingElements(taggingInterfaces)
}

internal class DddTaggingElements(val interfaces: Map<String, String> = mutableMapOf(),
    val annotations: Map<String, String> = mutableMapOf())

private fun determineTaggingInterface(feature: String) : Pair<String, String>? {
    val interfaceName = when(feature) {
        "AGGREGATE" -> "DddAggregate"
        "APPLICATION_SERVICE" -> "DddApplicationService"
        "DOMAIN_EVENT" -> "DddDomainEvent"
        "DOMAIN_SERVICE" -> "DddDomainService"
        "ENTITY" -> "DddEntity"
        "FACTORY" -> "DddFactory"
        "INFRASTRUCTURE_SERVICE" -> "DddInfrastructureService"
        "REPOSITORY" -> "DddRepository"
        "SERVICE" -> "DddService"
        "SPECIFICATION" -> "DddSpecification"
        "VALUE_OBJECT" -> "DddValueObject"
        else -> null
    } ?: return null

    return interfaceName to "de.fhdo.lemma.ddd.structure.$interfaceName"
}

internal fun EnumDeclaration.getDddElementsForFeatures(features: Set<String>) : DddTaggingElements {
    val taggingInterfaces = mutableMapOf<String, String>()
    features.forEach {
        val taggingInterface = determineTaggingInterface(it)
        if (taggingInterface != null)
            taggingInterfaces[taggingInterface.first] = taggingInterface.second
    }

    return DddTaggingElements(taggingInterfaces)
}

internal fun FieldDeclaration.getDddElementsForFeatures(features: Set<String>) : DddTaggingElements {
    val annotations = mutableMapOf<String, String>()
    features.forEach {
        val annotation = determineAnnotation(it, this)
        if (annotation != null)
            annotations[annotation.first] = annotation.second
    }

    return DddTaggingElements(emptyMap(), annotations)
}

private fun determineAnnotation(feature: String, targetNode: Node) : Pair<String, String>? {
    val annotationNameAndPackage = when(targetNode) {
        is FieldDeclaration -> when(feature) {
            "IDENTIFIER" -> "DddIdentifier" to "de.fhdo.lemma.ddd.structure"
            "PART" -> "DddPart" to "de.fhdo.lemma.ddd.structure"
            else -> null
        }

        is MethodDeclaration -> when(feature) {
            "CLOSURE" -> "DddClosure" to "de.fhdo.lemma.ddd.behavior"
            "IDENTIFIER" -> "DddIdentifier" to "de.fhdo.lemma.ddd.behavior"
            "SIDE_EFFECT_FREE" -> "DddSideEffectFree" to "de.fhdo.lemma.ddd.behavior"
            "VALIDATOR" -> "DddValidator" to "de.fhdo.lemma.ddd.behavior"
            else -> null
        }

        else -> null
    } ?: return null

    val (annotation, annotationPackage) = annotationNameAndPackage
    return annotation to "$annotationPackage.$annotation"
}

internal fun MethodDeclaration.getDddElementsForFeatures(features: Set<String>) : DddTaggingElements {
    val annotations = mutableMapOf<String, String>()
    features.forEach {
        val annotation = determineAnnotation(it, this)
        if (annotation != null)
            annotations[annotation.first] = annotation.second
    }

    return DddTaggingElements(emptyMap(), annotations)
}
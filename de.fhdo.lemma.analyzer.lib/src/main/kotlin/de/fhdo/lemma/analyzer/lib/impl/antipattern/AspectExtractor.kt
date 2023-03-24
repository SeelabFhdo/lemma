package de.fhdo.lemma.analyzer.lib.impl.antipattern

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import org.eclipse.emf.common.util.EList

/**
 * Encapsulated logic for information extraction in aspects
 * Created in context of antipattern analysis
 */
object AspectExtractor {
    fun isArchitecturePatternDefined(aspects: EList<IntermediateImportedAspect>, architectureName: String): Boolean {
        val names = aspects.filter { it.name.equals("ArchitecturePattern") }.flatMap { it.propertyValues }
            .filter { it.property.name.equals("name") }
        for (name in names) {
            if (architectureName.equals(name.value)) {
                return true
            }
        }
        return false
    }
}
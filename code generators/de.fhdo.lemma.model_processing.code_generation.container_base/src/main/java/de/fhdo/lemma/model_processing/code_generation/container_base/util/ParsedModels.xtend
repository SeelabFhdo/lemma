package de.fhdo.lemma.model_processing.code_generation.container_base.util

import org.eclipse.emf.ecore.resource.Resource
import static de.fhdo.lemma.model_processing.UtilKt.*
import static de.fhdo.lemma.model_processing.utils.UtilsKt.*
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.data.intermediate.IntermediateImport

/**
 * Access to models that need to be parsed by the Container Base Generator, instead of LEMMA's
 * Model Processing Framework, during an execution.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ParsedModels {
    static val PARSED_MODEL_ROOTS = <String, EObject>newHashMap

    /**
     * Parse the root of a model that is imported by the given importingModelResource via the given
     * intermediateImport. In case the root has already been parsed, the method returns its cached
     * version from previous parsing.
     */
    static def <T extends EObject> Pair<String, T> getOrParseImportedModelRoot(
        Resource importingModelResource,
        IntermediateImport intermediateImport
    ) {
        val importUri = intermediateImport.importUri
        val importPath = importUri.getAbsoluteImportPath(importingModelResource)
        var modelRoot = PARSED_MODEL_ROOTS.get(importPath)
        if (modelRoot === null) {
            modelRoot = loadModelRoot(importPath)
            PARSED_MODEL_ROOTS.put(importPath, modelRoot)
        }

        return importPath -> modelRoot as T
    }

    /**
     * Helper to derive the absolute path of the given importUri based on the absolute path of the
     * importingModelResource that uses the URI in a model import
     */
    private static def getAbsoluteImportPath(String importUri, Resource importingModelResource) {
        val importingModelAbsolutePath = absoluteBasePath(importingModelResource)
        val importPath = removeFileUri(importUri)
        val absoluteImportUri = LemmaUtils.convertToAbsoluteFileUri(importPath,
            importingModelAbsolutePath)

        return removeFileUri(absoluteImportUri)
    }
}
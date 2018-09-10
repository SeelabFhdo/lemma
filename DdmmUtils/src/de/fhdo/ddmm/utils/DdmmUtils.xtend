package de.fhdo.ddmm.utils

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.emf.ecore.EObject
import java.nio.file.Files
import java.nio.file.Paths
import com.google.common.base.Function
import java.util.ArrayDeque
import java.util.List
import com.google.common.base.Predicate
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.impl.MapBasedScope
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.scoping.Scopes

/**
 * This class collects _static_ utility methods to be used across DSLs' implementations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
final class DdmmUtils {
    /**
     * Get direct contents, i.e., EObjects that are direct children on the first level, of a
     * resource represented by an import URI that points to a file
     */
    def static getImportedModelContents(Resource context, String importUri) {
        if (context === null || importUri === null || importUri.empty)
            return null

        var EList<EObject> importedContents = null
        var importResource = EcoreUtil2.getResource(context, importUri)

        // Might happen if the resource could not be found, e.g., when the "file://" scheme is
        // missing
        if (importResource !== null)
            importedContents = importResource.contents

        // Try again to get imported model contents with "file://" scheme
        else if (importResource === null || importedContents.empty) {
            importResource = EcoreUtil2.getResource(context, convertToFileUri(importUri))
            if (importResource === null)  // still no chance to retrieve contents
                return null

            importedContents = importResource.contents
        }

        return importedContents
    }

    /**
     * Add "file://" scheme to URI string. If the string already has a scheme, replace it with
     * "file://".
     */
    def static convertToFileUri(String uri) {
        val scheme = URI.createURI(uri).scheme
        if (scheme !== null) {
            val uriWithoutScheme = uri.substring(scheme.length + 1)
            return "file://" + uriWithoutScheme
        } else {
            return "file://" + uri
        }
    }

    /**
     * Check if an imported file represented by its URI exists. The URI may be project-relative or
     * absolute.
     */
    def static importFileExists(Resource context, String importUri) {
        if (importUri === null || importUri.empty)
            return false

        // Cover project-specific relative paths, i.e., import is a resource
        var projectResource = EcoreUtil2.getResource(context, importUri)
        if (projectResource === null) {
            val uriWithFileScheme = convertToFileUri(importUri)
            projectResource = EcoreUtil2.getResource(context, uriWithFileScheme)
        }

        if (projectResource !== null)
            return true

        // URI does not point to a project resource, so maybe its an absolute path in the
        // filesystem
        val importFilePath = Paths.get(importUri)
        return Files.exists(importFilePath)
    }

    /**
     * Detect cycles in inheritance relationships of arbitrary EObjects. The method takes a
     * functional argument to retrieve the next super concept.
     */
    def static <INHERITING_CONCEPT extends EObject>
        hasCyclicInheritance(
            INHERITING_CONCEPT inheritingConcept,
            Function<INHERITING_CONCEPT, INHERITING_CONCEPT> getNextSuperConcept
        ) {
        var INHERITING_CONCEPT nextSuperConcept = getNextSuperConcept.apply(inheritingConcept)

        while (nextSuperConcept !== null) {
            // The given inheriting concept reoccurs somewhere in the upper inheritance
            // hierarchy and hence is part of a cycle
            if (nextSuperConcept == inheritingConcept)
                return true

            // Climb up inheritance hierarchy
            nextSuperConcept = getNextSuperConcept.apply(nextSuperConcept)
        }

        return false
    }

    /**
     * Check if an import is cyclic, i.e., if two files vice versa import each other.
     *
     * The method takes the following type arguments:
     *     - IMPORT_CONCEPT: The EObject-based concept that enables imports.
     *     - ROOT_CONCEPT: The EObject-based root concept that encapsulates the IMPORT_CONCEPT,
     *                     e.g., DataModel for ComplexTypeImport.
     *
     * The function argument of the method must for a given ROOT_CONCEPT instance return the
     * imported resources.
     */
    def static <IMPORT_CONCEPT extends EObject, ROOT_CONCEPT extends EObject>
        isCyclicImport(
            IMPORT_CONCEPT ^import,
            Class<ROOT_CONCEPT> rootConceptClazz,
            Function<ROOT_CONCEPT, List<Resource>> getImportedResources
        ) {
        if (import === null ||
            import.eResource === null ||
            import.eResource.URI === null)
            return false

        // Try to get the root of the importing model
        val modelRoot = EcoreUtil2.getContainerOfType(import, rootConceptClazz)
        if (modelRoot === null)
            return false

        /*
         * Detect import cycles by visiting all resources being imported by the importing model
         * recursively leveraging a stack. A cycle exists if we come back to the importing model at
         * some point, i.e., if the importing model is imported by on of the resources it directly
         * or indirectly (transitively) imports.
         */
        val resourceUri = import.eResource.URI.toString
        val resourcesToCheck = new ArrayDeque<Resource>(getImportedResources.apply(modelRoot))

        while (!resourcesToCheck.empty) {
            val resourceToCheck = resourcesToCheck.pop()
            val toCheckUri = resourceToCheck.URI.toString

            if (toCheckUri === resourceUri)
                return true

            val toCheckContents = getImportedModelContents(resourceToCheck, toCheckUri)
            if (toCheckContents !== null && !toCheckContents.empty)
                try {
                    val toCheckModelRoot = toCheckContents.get(0) as ROOT_CONCEPT
                    resourcesToCheck.addAll(getImportedResources.apply(toCheckModelRoot))
                } catch (ClassCastException ex) {
                    // NOOP
                }
        }

        return false
    }

    /**
     * Filter a list of imports by the types of the root models. It will collect and return all
     * imports from the list, whose resources' root models are of one of the given types.
     *
     * The method takes a function argument that enables it to retrieve the URI of an import from
     * the list.
     */
    def static <IMPORT_CONCEPT extends EObject>
        getImportsOfModelTypes(
            List<IMPORT_CONCEPT> allImports,
            Function<IMPORT_CONCEPT, String> getImportUri,
            Class<? extends EObject>... rootConceptClasses
        ) {
            val validImports = allImports.filter[
                val importUri = getImportUri.apply(it)
                if (importUri === null || importUri.empty)
                    return false

                val importedModelContents = getImportedModelContents(it.eResource, importUri)
                if (importedModelContents === null || importedModelContents.empty)
                    return false

                // Check if model root of imported resource is of one of the given types
                val modelRoot = importedModelContents.get(0)
                if (modelRoot === null)
                    return false

                return rootConceptClasses.exists[it.isInstance(modelRoot)]
            ]

            return validImports
    }

    /**
     * Calculate parts of a concept's name relative to another concept's name. Take for example the
     * following excerpt in Data DSL:
     *     version V1 {
     *         context C1 { structure S1 { int someField } }
     *         context C2 { structure S2 { char someOtherField, C1.S1 structureS1 } }
     *     }
     * The full qualified name of S1 is V1.C1.S1. However, when using this method to calculate its
     * relative name, C1.S1 may be used (like with field structureS1 of S2 in the example) when the
     * using data field is part of a structure in the same version, but in a different context. That
     * is, the V1 part gets removed from the FQN of S1 for structures defined in V1 contexts.
     *
     * The method takes the following type arguments:
     *     - NAMED_CONCEPT: Type of the concept for which a relative FQN should be calculated.
     *     - ROOT_CONCEPT: Type of the concept's root model concept.
     */
    def static <NAMED_CONCEPT extends EObject, ROOT_CONCEPT extends EObject>
        calculateRelativeQualifiedNameParts(
            // Instance of the concept to name, list of the parts of its qualified name and class of
            // its model root
            NAMED_CONCEPT conceptToName,
            List<String> conceptToNameQualifyingParts,
            Class<ROOT_CONCEPT> rootConceptToNameClazz,
            // Instance of the concept to which the concept's name shall be calculated relatively,
            // list of the parts of its qualified name and class of its model root
            NAMED_CONCEPT relativeToConcept,
            List<String> relativeToConceptQualifyingParts,
            Class<ROOT_CONCEPT> rootRelativeToClazz
        ) {
        val toNameRoot = EcoreUtil2.getContainerOfType(conceptToName, rootConceptToNameClazz)
        if (toNameRoot === null)
            return null

        val relativeToRoot = EcoreUtil2.getContainerOfType(relativeToConcept, rootRelativeToClazz)
        if (relativeToRoot === null)
            return null

        if (conceptToNameQualifyingParts === null || conceptToNameQualifyingParts.empty)
            return null

        /*
         * If the concepts (the one to name and the one it's being relative to) have different model
         * roots, one of the concepts is imported and we always need to return the full qualified
         * name
         */
        if (toNameRoot != relativeToRoot)
            return conceptToNameQualifyingParts

        if (relativeToConceptQualifyingParts === null || relativeToConceptQualifyingParts.empty)
            return null

        /*
         * In case both concepts have the same model roots, i.e., are defined in the same model, we
         * remove those qualifying parts of their names that are equal to determine the relative
         * name.
         *
         * Suppose both concepts were Operations and defined in the same Microservice but in
         * different Interfaces. Thus, the relative name for the operation to name is its full
         * qualified name without the Microservice name part. Take for example a Microservice named
         * "ManageCustomers" in version 2 with two Interfaces: The "ReadCustomer" interface has an
         * operation called "get", the "ManageCustomer" interface has an operation named "create".
         * In that case, if "create" wanted to refer to "get", the name of "get" relative to
         * "create" would be "ReadCustomer.get" instead of "v2.ManageCustomers.ReadCustomer.get".
         */
        var differenceFound = false
        var differenceIndex = 0
        while (differenceIndex < conceptToNameQualifyingParts.size &&
            differenceIndex < relativeToConceptQualifyingParts.size &&
            !differenceFound) {
            val toNamePart = conceptToNameQualifyingParts.get(differenceIndex)
            val relativeToNamePart = relativeToConceptQualifyingParts.get(differenceIndex)
            differenceFound = toNamePart != relativeToNamePart
            if (!differenceFound)
                differenceIndex++
        }

        if (differenceFound)
            return conceptToNameQualifyingParts
                .subList(differenceIndex, conceptToNameQualifyingParts.size)
                .toList
        else
            // If no difference could be found, i.e. the concept to name shall be named relatively
            // to itself, we return the last part of its qualifying name, of which we assume that
            // it is always, by convention, the name of the concept instance itself
            return newArrayList(conceptToNameQualifyingParts.last)
    }

    /**
     * Build scope for possibly imported concepts with relative qualified names. Such a concept may
     * either originate from the model (it is then considered "local") or be imported into the model
     * from another model.
     *
     * This method takes the following type parameters:
     *     - CONTAINER: Type of the EObject that contains the possibly imported concepts. For local
     *                  concepts this is commonly the type of the root model concept, e.g.,
     *                  DataModel. For imported concepts this is the import concept, e.g.,
     *                  ComplexTypeImport.
     *     - ROOT_CONCEPT: Type of the import concept's root model concept, e.g., DataModel for
     *                     ComplexTypeImport.
     *     - IMPORT_CONCEPT: Type of the concept that enables importing, e.g., ComplexTypeImport.
     *
     * This method takes the following function parameters:
     *     - getImportedConcepts: Get imported concepts from an instance of the root concept.
     *     - getConceptNameParts: Get qualifying name parts of an imported concept.
     */
    def static <
            CONTAINER extends EObject,
            ROOT_CONCEPT extends EObject,
            IMPORT_CONCEPT extends EObject
        > getScopeForPossiblyImportedConcept(
            CONTAINER container,
            List<String> containerNameParts,
            Class<ROOT_CONCEPT> rootConceptClazz,
            String importUri,
            Function<ROOT_CONCEPT, List<IMPORT_CONCEPT>> getImportedConcepts,
            Function<IMPORT_CONCEPT, List<String>> getConceptNameParts,
            Predicate<IMPORT_CONCEPT>... predicates
        ) {
        /*
         * Get the root model from which concepts shall be imported. This is either the root of the
         * current local model (importURI is null or empty) or the root of an imported model.
         */
        val rootModelConcept =
            if (importUri === null || importUri.empty)
                EcoreUtil2.getContainerOfType(container, rootConceptClazz)
            else {
                val importedModelContents = getImportedModelContents(container.eResource,
                    importUri)

                if (importedModelContents !== null && !importedModelContents.empty)
                    try {
                        importedModelContents.get(0) as ROOT_CONCEPT
                    } catch (ClassCastException ex) {
                        null
                    }
                else
                    null
            }

        /* Could not retrieve root model concept */
        if (rootModelConcept === null)
            return IScope.NULLSCOPE

        /*
         * Build scope for the imported concepts. The concepts' names within the scope are relative
         * to the specified container.
         */
        return DdmmUtils.getScopeWithRelativeQualifiedNames(
            getImportedConcepts.apply(rootModelConcept),
            getConceptNameParts,
            container,
            containerNameParts,
            rootConceptClazz,
            predicates
        )
    }

    /**
     * Convenience method to build a scope with relative qualified names if necessary. Predicates
     * may be used to exclude concepts from the scope. All predicates must apply on a concept to
     * lead to its inclusion in the scope. If relative naming is not necessary, the relative to
     * concept parameter or the parameter representing the list of its naming parts may be left null
     * or empty. In that case, the names of the scope elements will be fully qualified as returned
     * by the function parameter.
     *
     * The method takes the following type parameters:
     *     - CONCEPT_TO_NAME: Type of the concepts to name.
     *     - RELATIVE_TO_CONCEPT: Type of the concept relative to whose name passed concepts shall
     *                            be named.
     *     - ROOT_CONCEPT: Type of the root model concept of both, the concepts to name and the
     *                     relative concept.
     *
     * The method takes a function parameter to retrieve the qualifying name parts of a concept to
     * name.
     */
    def static <
            CONCEPT_TO_NAME extends EObject,
            RELATIVE_TO_CONCEPT extends EObject,
            ROOT_CONCEPT extends EObject
        > getScopeWithRelativeQualifiedNames(
            List<CONCEPT_TO_NAME> conceptsToName,
            Function<CONCEPT_TO_NAME, List<String>> getConceptNameParts,
            RELATIVE_TO_CONCEPT relativeToConcept,
            List<String> relativeToNameParts,
            Class<ROOT_CONCEPT> rootConceptClazz,
            Predicate<CONCEPT_TO_NAME>... predicates
        ) {
        if (rootConceptClazz === null)
            return IScope.NULLSCOPE

        /*
         * Collect relevant concepts to name by filtering out those concepts to which not all
         * predicates apply. We also calculate the relative names of the relevant concept if
         * necessary.
         */
        val doPredicateFiltering = predicates !== null && !predicates.empty
        val scopeElements = <IEObjectDescription> newArrayList
        conceptsToName
            .filter[concept |
                if (doPredicateFiltering)
                    !predicates.exists[!it.apply(concept)]
                else
                    true
            ]
            .forEach[concept |
                var conceptNameParts = getConceptNameParts.apply(concept)

                if (conceptNameParts !== null &&
                    !conceptNameParts.empty &&
                    relativeToConcept !== null &&
                    relativeToNameParts !== null &&
                    !relativeToNameParts.empty)
                    conceptNameParts = calculateRelativeQualifiedNameParts(
                        concept, conceptNameParts, rootConceptClazz,
                        relativeToConcept, relativeToNameParts, rootConceptClazz
                    )

                if (conceptNameParts !== null && !conceptNameParts.empty) {
                    val conceptName = QualifiedName.create(conceptNameParts)
                    scopeElements.add(EObjectDescription.create(conceptName, concept))
                }
            ]

        return MapBasedScope.createScope(IScope.NULLSCOPE, scopeElements)
    }

    /**
     * Get index of first duplicate entry from a list, or -1 if list does not contain duplicates
     */
    def static <T, S> getDuplicateIndex(List<T> list, Function<T, S> getCompareValue,
        Predicate<T>... compareValueFilterPredicates) {
        if (list === null || getCompareValue === null)
            throw new IllegalArgumentException("List and compare property must not be null")

        val doFiltering = compareValueFilterPredicates !== null &&
            !compareValueFilterPredicates.empty

        for (entryIndex : 0..<list.size) {
            val entry = list.get(entryIndex)
            val ignoreEntry = doFiltering && compareValueFilterPredicates.exists[!apply(entry)]
            val entryValue = getCompareValue.apply(entry)

            var compareIndex = entryIndex+1
            while (!ignoreEntry && compareIndex < list.size) {
                val entryToCompare = list.get(compareIndex)
                val ignoreEntryToCompare = doFiltering &&
                    compareValueFilterPredicates.exists[!apply(entryToCompare)]
                val valueToCompare = getCompareValue.apply(entryToCompare)

                if (!ignoreEntryToCompare && entryValue == valueToCompare)
                    return compareIndex

                compareIndex++
            }
        }

        return -1
    }

    /**
     * Merge an arbitrary number of scopes by building a new scope that contains all elements of the
     * given scopes
     */
    def static mergeScopes(IScope... scopes) {
        if (scopes === null || scopes.empty)
            return IScope::NULLSCOPE

        val mergedScopeElements = <EObject> newArrayList
        scopes.forEach[mergedScopeElements.addAll(allElements.map[EObjectOrProxy])]
        return Scopes::scopeFor(mergedScopeElements)
    }

    /**
     * Check that an imported resource is of a given type
     */
    def static <T extends EObject> isImportOfType(Resource context, String importUri,
        Class<T> expectedRootType) {
        val modelContents = getImportedModelContents(context, importUri)
        if (modelContents === null || modelContents.empty)
            return false

        val rootElement = modelContents.get(0)
        if (rootElement === null)
            return false

        return rootElement.class.interfaces.contains(expectedRootType)
    }

    /**
     * Check if a string corresponds to the terminal rule ID as defined in the grammar
     * org.eclipse.xtext.common.Terminals
     */
    def static matchesId(String string) {
        if (string === null)
            return false

        return string.matches("\\^?[a-zA-Z_]\\w*")
    }
}
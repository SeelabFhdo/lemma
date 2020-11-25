package de.fhdo.lemma.utils

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
import org.eclipse.xtext.scoping.Scopes
import java.io.File
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.core.resources.IFile
import java.util.Properties
import org.eclipse.core.resources.IProject
import java.util.regex.Pattern

/**
 * This class collects _static_ utility methods to be used across DSLs' implementations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LemmaUtils {
    /**
     * Get the current version of LEMMA as a printable String
     */
    def static getLemmaVersionAsString() {
        val propertyFile = LemmaUtils.getResourceAsStream("/version.properties")
        if (propertyFile === null)
            return ""

        try {
            val versionInfo = new Properties()
            versionInfo.load(propertyFile)
            val major = versionInfo.getProperty("major")
            val minor = versionInfo.getProperty("minor")
            val patch = versionInfo.getProperty("patch")

            if (major === null || minor === null || patch === null)
                return ""

            val versionString = '''«major».«minor».«patch»'''
            val extra = versionInfo.getProperty("extra")
            return if (extra !== null)
                    versionString + extra
                else
                    versionString
        } catch(Exception ex) {
            return ""
        }
    }

    /**
     * Get direct contents, i.e., EObjects that are direct children on the first level, of a
     * resource represented by an import URI that points to a file
     */
    def static getImportedModelContents(Resource context, String importUri) {
        if (context === null || importUri === null || importUri.empty)
            return null

        var importResource = EcoreUtil2.getResource(context, importUri)
        var importedContents = importResource?.contents ?: emptyList

        // The imported contents may be empty, e.g., when the "file" scheme is missing. Try again
        // with "file" scheme.
        if (importedContents.empty) {
            importResource = EcoreUtil2.getResource(context, convertToFileUri(importUri))
            importedContents = importResource?.contents
        }

        return importedContents
    }

    /**
     * Get root of an imported model
     */
    def static <T extends EObject> T getImportedModelRoot(Resource context, String importUri,
        Class<T> rootType) {
        val modelContents = getImportedModelContents(context, importUri)
        if (modelContents === null || modelContents.empty)
            return null

        val modelRoot = modelContents.get(0)
        if (!rootType.isAssignableFrom(modelRoot.class))
            return null

        return modelRoot as T
    }

    /**
     * Remove extension from filename and return filename without extension. The extension starts at
     * the last occurrence of a dot (".") in the filename.
     */
    def static removeExtension(String filename) {
        if (filename === null)
            return null

        return filename.substring(0, filename.lastIndexOf("."))
    }

    /**
     * Join segments to a path specifier separated by the OS-specific file separator. This method is
     * also capable of dealing with segments that themselves contain OS-specific file separators.
     * All separators of the resulting joined path will automatically be harmonized.
     */
    def static joinPathSegments(String... segments) {
        if (segments === null)
            return null
        else if (segments.empty)
            return ""

        val joinedPath = segments.join(File.separator)
        return if (isFileUri(joinedPath) && windowsOs)
                joinedPath.replace(File.separator, "/")
            else if (windowsOs)
                joinedPath.replace("/", File.separator)
            else
                joinedPath
    }

    /**
     * Convert a relative file path to an absolute file path that is based on an absolute base path
     */
    def static convertToAbsolutePath(String relativeFilePath, String absoluteBaseFilePath) {
        // Don't convert if the given relative file path isn't relative at all
        val relativeFilePathWithoutScheme = removeFileUri(relativeFilePath)
        if (relativeFilePathWithoutScheme.representsAbsolutePath)
            return relativeFilePathWithoutScheme

        val absoluteBaseFile = new File(absoluteBaseFilePath)
        val absoluteBaseFolder = new File(absoluteBaseFile.getParent())
        val absoluteFile = new File(absoluteBaseFolder, relativeFilePathWithoutScheme)
        return absoluteFile.getCanonicalPath()
    }

    /**
     * Check if a path is absolute
     */
    def static representsAbsolutePath(String path) {
        return Paths.get(path).absolute
    }

    /**
     * Check if a URI exhibits the "file" scheme
     */
    def static isFileUri(String uri) {
        if (uri === null)
            return false

        return uri.startsWith("file://")
    }

    /**
     * Add "file" scheme to URI string. If the string already has a scheme, replace it with "file".
     */
    def static convertToFileUri(String uri) {
        if (uri === null)
            return null

        val scheme = getUriScheme(uri)
        val fileUri = if (scheme !== null) {
            val uriWithoutScheme = uri.substring(scheme.length + 1)
            "file://" + uriWithoutScheme
        } else
            "file://" + uri

        return if (!isWindowsOs)
                fileUri
            else
                // As opposed to Windows, a URI uses slashes instead of backslashes to separate
                // paths
                fileUri.replace(File.separator, "/")
    }

    /**
     * Determine scheme of a URI considering OS-specifics
     */
    def static getUriScheme(String uri) {
        // Windows paths with drive letters look like at URIs (at least for
        // org.eclipse.emf.common.util.URI), because they start with a letter followed by a colon.
        // That is, URI.scheme will return "c" for a path "C:\Users\mymodel.model", i.e., the drive
        // letter will disappear, which makes the path invalid.
        return if (uri === null || startsWithWindowsDriveLetter(uri))
                null
            else
                URI.createURI(uri).scheme
    }

    /**
     * Helper to determine if a URI starts with a Windows drive letter
     */
    def static startsWithWindowsDriveLetter(String uri) {
        if (uri === null || !isWindowsOs)
            return false

        // Windows drive letters come in two different shapes (at least in Eclipse):
        //    (1) A capital letter, followed by a colon and a backslash.
        //    (2) A capital letter, followed by a colon and a *slash*. This case occurs, e.g., when
        //        the URI was retrieved from an Ecore Resource instance. For instance, the URI
        //        representation of a file "C:\Users\mymodel.model" on a Windows machine will be
        //        "C:/Users/mymodel.model". Unfortunately, this collides with the URI specification
        //        of a scheme. RFC 3986 defines a scheme to start with a single letter that may or
        //        may not be followed by additional letters. However, most schemes consists of more
        //        than one letter, in particular the "file" scheme, which is of most interest to us.
        //        That is, we take the risk of recognizing a URI beginning with a single-letter
        //        scheme and recognizing it falsely positive as a URI starting with a Windows drive
        //        letter for now.
        return uri.matches("[A-Z]:\\\\.*") || uri.matches("[A-Z]:/([^/].*)?")
    }

    /**
     * Helper to determine if we're on Windows
     */
    def static isWindowsOs() {
        val osName = System.getProperty("os.name")
        return osName.toLowerCase.startsWith("windows")
    }

    /**
     * Remove "file" scheme from URI string, leaving any preceding slashes untouched
     */
    def static removeFileUri(String uri) {
        if (!isFileUri(uri))
            return uri

        val scheme = getUriScheme(uri)
        val uriWithoutScheme = uri.substring(scheme.length + 1)
        return if (isWindowsOs && uriWithoutScheme.startsWith("//"))
               uriWithoutScheme.substring(2)
           else
               uriWithoutScheme
    }

    /**
     * Get IFile object from Resource
     */
    def static getFileForResource(Resource resource) {
        if (resource === null)
            return null

        val resourceUri = resource.URI.toString
        val workspace = ResourcesPlugin.workspace.root
        val file = if (resource.URI.isPlatform)
            workspace.getFile(new Path(resource.URI.toPlatformString(true)))
        else if (isFileUri(resourceUri)) {
            val fullFilePath = removeFileUri(resourceUri)
            workspace.getFileForLocation(new Path(fullFilePath))
        } else {
            val resourceWorkspaceMember = workspace.findMember(new Path(resourceUri))
            if (resourceWorkspaceMember instanceof IFile)
                resourceWorkspaceMember as IFile
            else
                null
        }

        return file
    }

    /**
     * Convenience method to convert a relative path to an absolute "file" URI
     */
    def static convertToAbsoluteFileUri(String relativeFilePath, String absoluteBaseFilePath) {
        return if (!isFileUri(relativeFilePath))
                convertToFileUri(convertToAbsolutePath(relativeFilePath, absoluteBaseFilePath))
            else
                relativeFilePath
    }

    /**
     * Convenience method to convert a relative path to an absolute "file" URI by using an IFile as
     * basis
     */
    def static convertToAbsoluteFileUri(String relativeFilePath, IFile file) {
        return if (isFileUri(relativeFilePath))
            relativeFilePath
        else
            convertToAbsoluteFileUri(relativeFilePath, file.absolutePath)
    }

    /**
     * Convenience method to convert a relative path to an absolute "file" URI by using a Resource
     * as basis
     */
    def static convertToAbsoluteFileUri(String relativeFilePath, Resource basis) {
        return if (isFileUri(relativeFilePath))
            relativeFilePath
        else if (isFileUri(basis.URI.toString))
            convertToAbsoluteFileUri(relativeFilePath, basis.URI.toString)
        else
            convertToAbsoluteFileUri(relativeFilePath, getFileForResource(basis))
    }

    /**
     * Convert a path, which points to a file in a workspace's project, to an absolute file URI.
     * Besides the containing project, neither the file nor any of its parent paths need to exist.
     * Furthermore, the project may not even exist in the same folder as the workspace root. This
     * may happen, e.g., when a project is imported without being copied to the workspace. The
     * method will return the absolute path of the project as a URI and simply append all following
     * (possibly non-existing) segments. This behavior is expected by callers like
     * IntermediateDataModelTransformation.populateOutputModelWithImportTargetPaths(), where an
     * import path might not exist as a physical file in the workspace. This is, for instance, the
     * case when a model gets transformed prior to the models it imports.
     */
    def static convertProjectPathToAbsoluteFileUri(String path) {
        if (path.representsAbsolutePath)
            convertToFileUri(path)

        // Find the project segment in the given path
        val segments = new ArrayDeque(path.removePrefix("/", true).split("/"))
        var absolutePath = ""
        var absoluteProjectPathFound = false
        var nonMemberDetected = false
        while (!segments.empty && !absoluteProjectPathFound && !nonMemberDetected) {
            val currentSegment = segments.pop
            absolutePath += "/" + currentSegment
            val workspaceMember = ResourcesPlugin.workspace.root.findMember(absolutePath)
            if (workspaceMember === null)
                nonMemberDetected = true
            else if (workspaceMember instanceof IProject) {
                absoluteProjectPathFound = true
                // rawLocation() returns null if it wants us to call location() instead
                absolutePath = (workspaceMember.rawLocation ?: workspaceMember.location).toString
            }
        }

        if (!absoluteProjectPathFound)
            throw new IllegalArgumentException('''Project-relative path "«path»" could not be ''' +
                "converted to absolute path. Is this really a path relative to a project in the " +
                "current workspace?")

        // Join remaining segments, i.e., sub-folders and file of the found project
        if (!segments.empty)
            absolutePath += "/" + segments.join("/")
        return convertToFileUri(absolutePath)
    }

    /**
     * Remove prefix from String. If allOccurrences is set to true, remove all occurrences of a
     * prefix from String.
     */
    def static removePrefix(String s, String prefix, boolean allOccurrences) {
        if (!s.startsWith(prefix))
            return s

        var noPrefixes = s.substring(prefix.length())
        if (!allOccurrences)
            return noPrefixes

        while (noPrefixes.startsWith(prefix))
            noPrefixes = noPrefixes.substring(prefix.length())
        return noPrefixes
    }

    /**
     * Retrieve the absolute path of an IFile
     */
    def static getAbsolutePath(IFile file) {
        return file.rawLocation.makeAbsolute.toString
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

        var importFilePath = try {
            getFileForResource(projectResource)?.absolutePath
        } catch (Exception ex) {
            // Since importFileExists() is called from language validators only, this exception will
            // occur when the validators are executed headless, i.e., outside Eclipse. Headless
            // validator execution happens, e.g., in standalone model processors. The reason for the
            // exception to occur is the unavailability of ResourcesPlugin (which is used by
            // getFileForResource()) in headless validator execution. The concrete Exception
            // instance is an IllegalStateException and the message will probably be "Workspace is
            // closed."
            null
        }

        // URI does not point to a project resource, so maybe its an absolute path in the
        // filesystem
        if (importFilePath === null) {
            importFilePath = try {
                new File(new java.net.URI(importUri)).path
            } catch (Exception ex) {
                // A conversion to a file path may not be possible via java.net.URI, if the import
                // URI does not point an absolute path. The same exception occurs, if the URI has an
                // "inconstistent" format like "file:///foo bar/baz", where the space between "foo"
                // and "bar" is not encoded by "%20".
                removeFileUri(importUri)
            }
        }

        return Files.exists(Paths.get(importFilePath))
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
     * The fully qualified name of S1 is V1.C1.S1. However, when using this method to calculate its
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
        return getScopeWithRelativeQualifiedNames(
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
            .filter[concept | !doPredicateFiltering || !predicates.exists[!it.apply(concept)]]
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

            if (!ignoreEntry) {
                val entryValue = getCompareValue.apply(entry)

                for (compareIndex : entryIndex+1..< list.size) {
                    val entryToCompare = list.get(compareIndex)
                    val ignoreEntryToCompare = doFiltering &&
                        compareValueFilterPredicates.exists[!apply(entryToCompare)]

                    if (!ignoreEntryToCompare) {
                        val valueToCompare = getCompareValue.apply(entryToCompare)
                        if (entryValue == valueToCompare)
                            return compareIndex
                    }
                }
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
     * Get the short name for a service. Transforms for example "de.demo.demoservice" to
     * "demoservice".
     */
    static def String getShortNameService(String fullname) {
        fullname.substring(fullname.lastIndexOf('.'), fullname.length).replace('.', '')
    }

    /**
     * Get the build path from the qualified name of a deployed microservice.
     * Transformation of "v1.de.demo.demoservice" to "v1.de.demo". This function is needed to
     * fit the filesystem structure of the java base code generator.
     */
    static def String buildPathFromQualifiedName (String qualifedName) {
        val stringBuilder = new StringBuilder
        qualifedName.split("\\.").forEach[p |
            if(p != getShortNameService(qualifedName)) {
                stringBuilder.append(p)
                stringBuilder.append(File.separator)
            }
        ]
        return stringBuilder.toString
    }

    /**
     * Get the specific port form the address string.
     */
    static def String getPortFromAddress(String address) {
        var part = ""
        val pattern = Pattern.compile("(:[0-9]+)")

        val matcher = pattern.matcher(address)
        while(matcher.find)
           part = matcher.group.replace(':', '')

        return part
    }

    /**
     * Get a file from a specific file path
     */
    static def File asFile(String filePath) {
        return new File(Files.readAllLines(Paths.get(filePath)).toString)
    }

    /**
     * Remove line with a given indicator at the beginning of the line
     */
    static def String removeLineFromString(String content, String indicator) {
        var String[] lines = content.split(System.getProperty("line.separator"));
        lines.drop(1).join(System.getProperty("line.separator"))
    }
}
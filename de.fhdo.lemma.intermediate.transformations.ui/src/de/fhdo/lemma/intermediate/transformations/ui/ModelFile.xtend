package de.fhdo.lemma.intermediate.transformations.ui

import org.eclipse.core.resources.IFile
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.diagnostics.Severity
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils

/**
 * Wrapper for model files. It encapsulates the IFile instance and further, model-specific
 * information being gathered during the intermediate transformation process.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelFile implements Comparable<ModelFile> {
    @Accessors
    IFile file

    @Accessors(PUBLIC_GETTER)
    ModelFileTypeDescription fileTypeDescription

    @Accessors
    Object parent

    @Accessors
    String importAlias

    @Accessors
    List<ModelFile> children = newArrayList

    @Accessors
    boolean scannedForChildren

    XtextResource xtextResource

    boolean xtextResourceLoaded

    @Accessors(PUBLIC_SETTER)
    Boolean hasErrors

    @Accessors(PUBLIC_SETTER)
    Boolean hasWarnings

    List<Issue> issues

    boolean scannedForIssues

    @Accessors
    boolean selectedForTransformation

    @Accessors
    String transformationTargetPath

    /**
     * Convenience constructor
     */
    new(IFile file, ModelFileTypeDescription fileTypeDescription) {
        this(file, fileTypeDescription, null, null)
    }

    /**
     * Constructor with parent and import alias
     */
    new(IFile file, ModelFileTypeDescription fileTypeDescription, Object parent,
        String importAlias) {
        if (file === null)
            throw new IllegalArgumentException("File must not be null")
        else if (fileTypeDescription === null)
            throw new IllegalArgumentException("File type must not be null")

        this.file = file
        this.fileTypeDescription = fileTypeDescription
        this.parent = parent
        this.importAlias = importAlias
    }

    /**
     * Get Xtext resource of the encapsulated file or load it on demand
     */
    def XtextResource getXtextResource() {
        if (xtextResource === null && !xtextResourceLoaded) {
            xtextResource = LemmaUiUtils.loadXtextResource(file)
            xtextResourceLoaded = true  // Try to load resource exactly once
        }

        return xtextResource
    }

    /**
     * Check if Xtext resource has errors
     */
    def hasErrors() {
        if (hasErrors === null)
            hasErrors = hasIssuesOfSeverity(Severity.ERROR)

        return hasErrors
    }

    /**
     * Check if Xtext resource has warnings
     */
    def hasWarnings() {
        if (hasWarnings === null)
            hasWarnings = hasIssuesOfSeverity(Severity.WARNING)

        return hasWarnings
    }

    /**
     * Internal helper to scan the Xtext resource related to the file for issues of a given severity
     */
    private def hasIssuesOfSeverity(Severity severity) {
        var boolean result

        if (issues === null && !scannedForIssues) {
            val xtextResource = getXtextResource()
            if (xtextResource !== null)
                issues = LemmaUiUtils.validateXtextResource(xtextResource)
            else
                result = false

            scannedForIssues = true
        }

        if (issues !== null)
            result = issues.exists[it.severity === severity]
        else
            result = false

        return result
    }

    /**
     * Compare two model files based on their project-relative path strings
     */
    override compareTo(ModelFile o) {
        val otherModelFile = o as ModelFile
        return file.fullPath.toString.compareTo(otherModelFile.file.fullPath.toString)
    }

    /**
     * Equality comparison
     */
    override equals(Object o) {
        if (!(o instanceof ModelFile))
            return false

        return compareTo(o as ModelFile) === 0
    }
}
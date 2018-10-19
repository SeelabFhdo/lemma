package de.fhdo.ddmm.eclipse.ui

import org.eclipse.core.resources.IFile
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import org.eclipse.xtext.resource.XtextResource
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.diagnostics.Severity

/**
 * Wrapper for model files. It encapsulates the IFile instance and further, model-specific
 * information being gathered during the intermediate transformation process.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelFile implements Comparable<ModelFile> {
    @Accessors
    private IFile file

    @Accessors(PUBLIC_GETTER)
    private ModelFileTypeDescription fileTypeDescription

    @Accessors
    private Object parent

    @Accessors
    private String importAlias

    @Accessors
    private List<ModelFile> children = newArrayList

    @Accessors
    private boolean scannedForChildren

    private XtextResource xtextResource

    private boolean xtextResourceLoaded

    @Accessors(PUBLIC_SETTER)
    private Boolean hasErrors

    @Accessors(PUBLIC_SETTER)
    private Boolean hasWarnings

    private List<Issue> issues

    private boolean scannedForIssues

    @Accessors
    private boolean selectedForTransformation

    @Accessors
    private String transformationTargetPath

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
    public def XtextResource getXtextResource() {
        if (xtextResource === null && !xtextResourceLoaded) {
            xtextResource = DdmmUiUtils.loadXtextResource(file)
            xtextResourceLoaded = true  // Try to load resource exactly once
        }

        return xtextResource
    }

    /**
     * Check if Xtext resource has errors
     */
    public def hasErrors() {
        if (hasErrors === null)
            hasErrors = hasIssuesOfSeverity(Severity.ERROR)

        return hasErrors
    }

    /**
     * Check if Xtext resource has warnings
     */
    public def hasWarnings() {
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
                issues = DdmmUiUtils.validateXtextResource(xtextResource)
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
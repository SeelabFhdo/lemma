package de.fhdo.lemma.intermediate.transformations.ui;

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Wrapper for model files. It encapsulates the IFile instance and further, model-specific
 * information being gathered during the intermediate transformation process.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelFile implements Comparable<ModelFile> {
  @Accessors
  private IFile file;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ModelFileTypeDescription fileTypeDescription;
  
  @Accessors
  private Object parent;
  
  @Accessors
  private String importAlias;
  
  @Accessors
  private List<ModelFile> children = CollectionLiterals.<ModelFile>newArrayList();
  
  @Accessors
  private boolean scannedForChildren;
  
  private XtextResource xtextResource;
  
  private boolean xtextResourceLoaded;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Boolean hasErrors;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Boolean hasWarnings;
  
  private List<Issue> issues;
  
  private boolean scannedForIssues;
  
  @Accessors
  private boolean selectedForTransformation;
  
  @Accessors
  private String transformationTargetPath;
  
  /**
   * Convenience constructor
   */
  public ModelFile(final IFile file, final ModelFileTypeDescription fileTypeDescription) {
    this(file, fileTypeDescription, null, null);
  }
  
  /**
   * Constructor with parent and import alias
   */
  public ModelFile(final IFile file, final ModelFileTypeDescription fileTypeDescription, final Object parent, final String importAlias) {
    if ((file == null)) {
      throw new IllegalArgumentException("File must not be null");
    } else {
      if ((fileTypeDescription == null)) {
        throw new IllegalArgumentException("File type must not be null");
      }
    }
    this.file = file;
    this.fileTypeDescription = fileTypeDescription;
    this.parent = parent;
    this.importAlias = importAlias;
  }
  
  /**
   * Get Xtext resource of the encapsulated file or load it on demand
   */
  public XtextResource getXtextResource() {
    if (((this.xtextResource == null) && (!this.xtextResourceLoaded))) {
      this.xtextResource = LemmaUiUtils.loadXtextResource(this.file);
      this.xtextResourceLoaded = true;
    }
    return this.xtextResource;
  }
  
  /**
   * Check if Xtext resource has errors
   */
  public Boolean hasErrors() {
    if ((this.hasErrors == null)) {
      this.hasErrors = Boolean.valueOf(this.hasIssuesOfSeverity(Severity.ERROR));
    }
    return this.hasErrors;
  }
  
  /**
   * Check if Xtext resource has warnings
   */
  public Boolean hasWarnings() {
    if ((this.hasWarnings == null)) {
      this.hasWarnings = Boolean.valueOf(this.hasIssuesOfSeverity(Severity.WARNING));
    }
    return this.hasWarnings;
  }
  
  /**
   * Internal helper to scan the Xtext resource related to the file for issues of a given severity
   */
  private boolean hasIssuesOfSeverity(final Severity severity) {
    boolean result = false;
    if (((this.issues == null) && (!this.scannedForIssues))) {
      final XtextResource xtextResource = this.getXtextResource();
      if ((xtextResource != null)) {
        this.issues = LemmaUiUtils.validateXtextResource(xtextResource);
      } else {
        result = false;
      }
      this.scannedForIssues = true;
    }
    if ((this.issues != null)) {
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf((_severity == severity));
      };
      result = IterableExtensions.<Issue>exists(this.issues, _function);
    } else {
      result = false;
    }
    return result;
  }
  
  /**
   * Compare two model files based on their project-relative path strings
   */
  @Override
  public int compareTo(final ModelFile o) {
    final ModelFile otherModelFile = ((ModelFile) o);
    return this.file.getFullPath().toString().compareTo(otherModelFile.file.getFullPath().toString());
  }
  
  /**
   * Equality comparison
   */
  @Override
  public boolean equals(final Object o) {
    if ((!(o instanceof ModelFile))) {
      return false;
    }
    int _compareTo = this.compareTo(((ModelFile) o));
    return (_compareTo == 0);
  }
  
  @Pure
  public IFile getFile() {
    return this.file;
  }
  
  public void setFile(final IFile file) {
    this.file = file;
  }
  
  @Pure
  public ModelFileTypeDescription getFileTypeDescription() {
    return this.fileTypeDescription;
  }
  
  @Pure
  public Object getParent() {
    return this.parent;
  }
  
  public void setParent(final Object parent) {
    this.parent = parent;
  }
  
  @Pure
  public String getImportAlias() {
    return this.importAlias;
  }
  
  public void setImportAlias(final String importAlias) {
    this.importAlias = importAlias;
  }
  
  @Pure
  public List<ModelFile> getChildren() {
    return this.children;
  }
  
  public void setChildren(final List<ModelFile> children) {
    this.children = children;
  }
  
  @Pure
  public boolean isScannedForChildren() {
    return this.scannedForChildren;
  }
  
  public void setScannedForChildren(final boolean scannedForChildren) {
    this.scannedForChildren = scannedForChildren;
  }
  
  public void setHasErrors(final Boolean hasErrors) {
    this.hasErrors = hasErrors;
  }
  
  public void setHasWarnings(final Boolean hasWarnings) {
    this.hasWarnings = hasWarnings;
  }
  
  @Pure
  public boolean isSelectedForTransformation() {
    return this.selectedForTransformation;
  }
  
  public void setSelectedForTransformation(final boolean selectedForTransformation) {
    this.selectedForTransformation = selectedForTransformation;
  }
  
  @Pure
  public String getTransformationTargetPath() {
    return this.transformationTargetPath;
  }
  
  public void setTransformationTargetPath(final String transformationTargetPath) {
    this.transformationTargetPath = transformationTargetPath;
  }
}

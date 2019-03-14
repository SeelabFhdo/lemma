package de.fhdo.ddmm.utils;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * This class collects _static_ utility methods to be used across DSLs' implementations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class DdmmUtils {
  /**
   * Get direct contents, i.e., EObjects that are direct children on the first level, of a
   * resource represented by an import URI that points to a file
   */
  public static EList<EObject> getImportedModelContents(final Resource context, final String importUri) {
    if ((((context == null) || (importUri == null)) || importUri.isEmpty())) {
      return null;
    }
    EList<EObject> importedContents = null;
    Resource importResource = EcoreUtil2.getResource(context, importUri);
    if ((importResource != null)) {
      importedContents = importResource.getContents();
    } else {
      if (((importResource == null) || importedContents.isEmpty())) {
        importResource = EcoreUtil2.getResource(context, DdmmUtils.convertToFileUri(importUri));
        if ((importResource == null)) {
          return null;
        }
        importedContents = importResource.getContents();
      }
    }
    return importedContents;
  }
  
  /**
   * Get root of an imported model
   */
  public static <T extends EObject> T getImportedModelRoot(final Resource context, final String importUri, final Class<T> rootType) {
    final EList<EObject> modelContents = DdmmUtils.getImportedModelContents(context, importUri);
    if (((modelContents == null) || modelContents.isEmpty())) {
      return null;
    }
    final EObject modelRoot = modelContents.get(0);
    boolean _isAssignableFrom = rootType.isAssignableFrom(modelRoot.getClass());
    boolean _not = (!_isAssignableFrom);
    if (_not) {
      return null;
    }
    return ((T) modelRoot);
  }
  
  /**
   * Convert a relative file path to an absolute file path that is based on an absolute base path
   */
  public static String convertToAbsolutePath(final String relativeFilePath, final String absoluteBaseFilePath) {
    try {
      final File absoluteBaseFile = new File(absoluteBaseFilePath);
      String _parent = absoluteBaseFile.getParent();
      final File absoluteBaseFolder = new File(_parent);
      final File absoluteFile = new File(absoluteBaseFolder, relativeFilePath);
      return absoluteFile.getCanonicalPath();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Check if a URI exhibits the "file://" scheme
   */
  public static boolean isFileUri(final String uri) {
    if ((uri == null)) {
      return false;
    }
    return uri.startsWith("file://");
  }
  
  /**
   * Add "file://" scheme to URI string. If the string already has a scheme, replace it with
   * "file://".
   */
  public static String convertToFileUri(final String uri) {
    if ((uri == null)) {
      return null;
    }
    final String scheme = URI.createURI(uri).scheme();
    if ((scheme != null)) {
      int _length = scheme.length();
      int _plus = (_length + 1);
      final String uriWithoutScheme = uri.substring(_plus);
      return ("file://" + uriWithoutScheme);
    } else {
      return ("file://" + uri);
    }
  }
  
  /**
   * Remove "file://" scheme from URI string
   */
  public static String removeFileUri(final String uri) {
    boolean _isFileUri = DdmmUtils.isFileUri(uri);
    boolean _not = (!_isFileUri);
    if (_not) {
      return uri;
    }
    final String scheme = URI.createURI(uri).scheme();
    int _length = scheme.length();
    int _plus = (_length + 1);
    return uri.substring(_plus);
  }
  
  /**
   * Get IFile object from Resource
   */
  public static IFile getFileForResource(final Resource resource) {
    if ((resource == null)) {
      return null;
    }
    final String resourceUri = resource.getURI().toString();
    final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
    IFile _xifexpression = null;
    boolean _isPlatform = resource.getURI().isPlatform();
    if (_isPlatform) {
      String _platformString = resource.getURI().toPlatformString(true);
      Path _path = new Path(_platformString);
      _xifexpression = workspace.getFile(_path);
    } else {
      IFile _xifexpression_1 = null;
      boolean _isFileUri = DdmmUtils.isFileUri(resourceUri);
      if (_isFileUri) {
        IFile _xblockexpression = null;
        {
          final String fullFilePath = DdmmUtils.removeFileUri(resourceUri);
          Path _path_1 = new Path(fullFilePath);
          _xblockexpression = workspace.getFileForLocation(_path_1);
        }
        _xifexpression_1 = _xblockexpression;
      } else {
        IFile _xblockexpression_1 = null;
        {
          Path _path_1 = new Path(resourceUri);
          final IResource resourceWorkspaceMember = workspace.findMember(_path_1);
          IFile _xifexpression_2 = null;
          if ((resourceWorkspaceMember instanceof IFile)) {
            _xifexpression_2 = ((IFile) resourceWorkspaceMember);
          } else {
            _xifexpression_2 = null;
          }
          _xblockexpression_1 = _xifexpression_2;
        }
        _xifexpression_1 = _xblockexpression_1;
      }
      _xifexpression = _xifexpression_1;
    }
    final IFile file = _xifexpression;
    return file;
  }
  
  /**
   * Convenience method to convert a relative path to an absolute "file://" URI
   */
  public static String convertToAbsoluteFileUri(final String relativeFilePath, final String absoluteBaseFilePath) {
    String _xifexpression = null;
    boolean _isFileUri = DdmmUtils.isFileUri(relativeFilePath);
    boolean _not = (!_isFileUri);
    if (_not) {
      _xifexpression = DdmmUtils.convertToFileUri(DdmmUtils.convertToAbsolutePath(relativeFilePath, absoluteBaseFilePath));
    } else {
      _xifexpression = relativeFilePath;
    }
    return _xifexpression;
  }
  
  /**
   * Convenience method to convert a relative path to an absolute "file://" URI by using a
   * Resource as base
   */
  public static String convertToAbsoluteFileUri(final String relativeFilePath, final Resource base) {
    String _xifexpression = null;
    boolean _isFileUri = DdmmUtils.isFileUri(relativeFilePath);
    if (_isFileUri) {
      _xifexpression = relativeFilePath;
    } else {
      String _xifexpression_1 = null;
      boolean _isFileUri_1 = DdmmUtils.isFileUri(base.getURI().toString());
      if (_isFileUri_1) {
        _xifexpression_1 = DdmmUtils.convertToAbsoluteFileUri(relativeFilePath, base.getURI().toString());
      } else {
        String _xblockexpression = null;
        {
          final String absoluteResourceFilePath = DdmmUtils.getFileForResource(base).getRawLocation().makeAbsolute().toString();
          _xblockexpression = DdmmUtils.convertToAbsoluteFileUri(relativeFilePath, absoluteResourceFilePath);
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Check if an imported file represented by its URI exists. The URI may be project-relative or
   * absolute.
   */
  public static boolean importFileExists(final Resource context, final String importUri) {
    if (((importUri == null) || importUri.isEmpty())) {
      return false;
    }
    Resource projectResource = EcoreUtil2.getResource(context, importUri);
    if ((projectResource == null)) {
      final String uriWithFileScheme = DdmmUtils.convertToFileUri(importUri);
      projectResource = EcoreUtil2.getResource(context, uriWithFileScheme);
    }
    if ((projectResource != null)) {
      return true;
    }
    final java.nio.file.Path importFilePath = Paths.get(importUri);
    return Files.exists(importFilePath);
  }
  
  /**
   * Detect cycles in inheritance relationships of arbitrary EObjects. The method takes a
   * functional argument to retrieve the next super concept.
   */
  public static <INHERITING_CONCEPT extends EObject> boolean hasCyclicInheritance(final INHERITING_CONCEPT inheritingConcept, final Function<INHERITING_CONCEPT, INHERITING_CONCEPT> getNextSuperConcept) {
    INHERITING_CONCEPT nextSuperConcept = getNextSuperConcept.apply(inheritingConcept);
    while ((nextSuperConcept != null)) {
      {
        boolean _equals = Objects.equal(nextSuperConcept, inheritingConcept);
        if (_equals) {
          return true;
        }
        nextSuperConcept = getNextSuperConcept.apply(nextSuperConcept);
      }
    }
    return false;
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
  public static <IMPORT_CONCEPT extends EObject, ROOT_CONCEPT extends EObject> boolean isCyclicImport(final IMPORT_CONCEPT import_, final Class<ROOT_CONCEPT> rootConceptClazz, final Function<ROOT_CONCEPT, List<Resource>> getImportedResources) {
    if ((((import_ == null) || 
      (import_.eResource() == null)) || 
      (import_.eResource().getURI() == null))) {
      return false;
    }
    final ROOT_CONCEPT modelRoot = EcoreUtil2.<ROOT_CONCEPT>getContainerOfType(import_, rootConceptClazz);
    if ((modelRoot == null)) {
      return false;
    }
    final String resourceUri = import_.eResource().getURI().toString();
    List<Resource> _apply = getImportedResources.apply(modelRoot);
    final ArrayDeque<Resource> resourcesToCheck = new ArrayDeque<Resource>(_apply);
    while ((!resourcesToCheck.isEmpty())) {
      {
        final Resource resourceToCheck = resourcesToCheck.pop();
        final String toCheckUri = resourceToCheck.getURI().toString();
        if ((toCheckUri == resourceUri)) {
          return true;
        }
        final EList<EObject> toCheckContents = DdmmUtils.getImportedModelContents(resourceToCheck, toCheckUri);
        if (((toCheckContents != null) && (!toCheckContents.isEmpty()))) {
          try {
            EObject _get = toCheckContents.get(0);
            final ROOT_CONCEPT toCheckModelRoot = ((ROOT_CONCEPT) _get);
            resourcesToCheck.addAll(getImportedResources.apply(toCheckModelRoot));
          } catch (final Throwable _t) {
            if (_t instanceof ClassCastException) {
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    }
    return false;
  }
  
  /**
   * Filter a list of imports by the types of the root models. It will collect and return all
   * imports from the list, whose resources' root models are of one of the given types.
   * 
   * The method takes a function argument that enables it to retrieve the URI of an import from
   * the list.
   */
  public static <IMPORT_CONCEPT extends EObject> Iterable<IMPORT_CONCEPT> getImportsOfModelTypes(final List<IMPORT_CONCEPT> allImports, final Function<IMPORT_CONCEPT, String> getImportUri, final Class<? extends EObject>... rootConceptClasses) {
    final Function1<IMPORT_CONCEPT, Boolean> _function = (IMPORT_CONCEPT it) -> {
      final String importUri = getImportUri.apply(it);
      if (((importUri == null) || importUri.isEmpty())) {
        return Boolean.valueOf(false);
      }
      final EList<EObject> importedModelContents = DdmmUtils.getImportedModelContents(it.eResource(), importUri);
      if (((importedModelContents == null) || importedModelContents.isEmpty())) {
        return Boolean.valueOf(false);
      }
      final EObject modelRoot = importedModelContents.get(0);
      if ((modelRoot == null)) {
        return Boolean.valueOf(false);
      }
      final Function1<Class<? extends EObject>, Boolean> _function_1 = (Class<? extends EObject> it_1) -> {
        return Boolean.valueOf(it_1.isInstance(modelRoot));
      };
      return Boolean.valueOf(IterableExtensions.<Class<? extends EObject>>exists(((Iterable<Class<? extends EObject>>)Conversions.doWrapArray(rootConceptClasses)), _function_1));
    };
    final Iterable<IMPORT_CONCEPT> validImports = IterableExtensions.<IMPORT_CONCEPT>filter(allImports, _function);
    return validImports;
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
  public static <NAMED_CONCEPT extends EObject, ROOT_CONCEPT extends EObject> List<String> calculateRelativeQualifiedNameParts(final NAMED_CONCEPT conceptToName, final List<String> conceptToNameQualifyingParts, final Class<ROOT_CONCEPT> rootConceptToNameClazz, final NAMED_CONCEPT relativeToConcept, final List<String> relativeToConceptQualifyingParts, final Class<ROOT_CONCEPT> rootRelativeToClazz) {
    final ROOT_CONCEPT toNameRoot = EcoreUtil2.<ROOT_CONCEPT>getContainerOfType(conceptToName, rootConceptToNameClazz);
    if ((toNameRoot == null)) {
      return null;
    }
    final ROOT_CONCEPT relativeToRoot = EcoreUtil2.<ROOT_CONCEPT>getContainerOfType(relativeToConcept, rootRelativeToClazz);
    if ((relativeToRoot == null)) {
      return null;
    }
    if (((conceptToNameQualifyingParts == null) || conceptToNameQualifyingParts.isEmpty())) {
      return null;
    }
    boolean _notEquals = (!Objects.equal(toNameRoot, relativeToRoot));
    if (_notEquals) {
      return conceptToNameQualifyingParts;
    }
    if (((relativeToConceptQualifyingParts == null) || relativeToConceptQualifyingParts.isEmpty())) {
      return null;
    }
    boolean differenceFound = false;
    int differenceIndex = 0;
    while ((((differenceIndex < conceptToNameQualifyingParts.size()) && 
      (differenceIndex < relativeToConceptQualifyingParts.size())) && 
      (!differenceFound))) {
      {
        final String toNamePart = conceptToNameQualifyingParts.get(differenceIndex);
        final String relativeToNamePart = relativeToConceptQualifyingParts.get(differenceIndex);
        boolean _notEquals_1 = (!Objects.equal(toNamePart, relativeToNamePart));
        differenceFound = _notEquals_1;
        if ((!differenceFound)) {
          differenceIndex++;
        }
      }
    }
    if (differenceFound) {
      return IterableExtensions.<String>toList(conceptToNameQualifyingParts.subList(differenceIndex, conceptToNameQualifyingParts.size()));
    } else {
      return CollectionLiterals.<String>newArrayList(IterableExtensions.<String>last(conceptToNameQualifyingParts));
    }
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
  public static <CONTAINER extends EObject, ROOT_CONCEPT extends EObject, IMPORT_CONCEPT extends EObject> IScope getScopeForPossiblyImportedConcept(final CONTAINER container, final List<String> containerNameParts, final Class<ROOT_CONCEPT> rootConceptClazz, final String importUri, final Function<ROOT_CONCEPT, List<IMPORT_CONCEPT>> getImportedConcepts, final Function<IMPORT_CONCEPT, List<String>> getConceptNameParts, final Predicate<IMPORT_CONCEPT>... predicates) {
    ROOT_CONCEPT _xifexpression = null;
    if (((importUri == null) || importUri.isEmpty())) {
      _xifexpression = EcoreUtil2.<ROOT_CONCEPT>getContainerOfType(container, rootConceptClazz);
    } else {
      ROOT_CONCEPT _xblockexpression = null;
      {
        final EList<EObject> importedModelContents = DdmmUtils.getImportedModelContents(container.eResource(), importUri);
        ROOT_CONCEPT _xifexpression_1 = null;
        if (((importedModelContents != null) && (!importedModelContents.isEmpty()))) {
          ROOT_CONCEPT _xtrycatchfinallyexpression = null;
          try {
            EObject _get = importedModelContents.get(0);
            _xtrycatchfinallyexpression = ((ROOT_CONCEPT) _get);
          } catch (final Throwable _t) {
            if (_t instanceof ClassCastException) {
              _xtrycatchfinallyexpression = null;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          _xifexpression_1 = _xtrycatchfinallyexpression;
        } else {
          _xifexpression_1 = null;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    final ROOT_CONCEPT rootModelConcept = _xifexpression;
    if ((rootModelConcept == null)) {
      return IScope.NULLSCOPE;
    }
    return DdmmUtils.<IMPORT_CONCEPT, CONTAINER, ROOT_CONCEPT>getScopeWithRelativeQualifiedNames(
      getImportedConcepts.apply(rootModelConcept), getConceptNameParts, container, containerNameParts, rootConceptClazz, predicates);
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
  public static <CONCEPT_TO_NAME extends EObject, RELATIVE_TO_CONCEPT extends EObject, ROOT_CONCEPT extends EObject> IScope getScopeWithRelativeQualifiedNames(final List<CONCEPT_TO_NAME> conceptsToName, final Function<CONCEPT_TO_NAME, List<String>> getConceptNameParts, final RELATIVE_TO_CONCEPT relativeToConcept, final List<String> relativeToNameParts, final Class<ROOT_CONCEPT> rootConceptClazz, final Predicate<CONCEPT_TO_NAME>... predicates) {
    if ((rootConceptClazz == null)) {
      return IScope.NULLSCOPE;
    }
    final boolean doPredicateFiltering = ((predicates != null) && (!((List<Predicate<CONCEPT_TO_NAME>>)Conversions.doWrapArray(predicates)).isEmpty()));
    final ArrayList<IEObjectDescription> scopeElements = CollectionLiterals.<IEObjectDescription>newArrayList();
    final Function1<CONCEPT_TO_NAME, Boolean> _function = (CONCEPT_TO_NAME concept) -> {
      return Boolean.valueOf(((!doPredicateFiltering) || (!IterableExtensions.<Predicate<CONCEPT_TO_NAME>>exists(((Iterable<Predicate<CONCEPT_TO_NAME>>)Conversions.doWrapArray(predicates)), ((Function1<Predicate<CONCEPT_TO_NAME>, Boolean>) (Predicate<CONCEPT_TO_NAME> it) -> {
        boolean _apply = it.apply(concept);
        return Boolean.valueOf((!_apply));
      })))));
    };
    final Consumer<CONCEPT_TO_NAME> _function_1 = (CONCEPT_TO_NAME concept) -> {
      List<String> conceptNameParts = getConceptNameParts.apply(concept);
      if ((((((conceptNameParts != null) && 
        (!conceptNameParts.isEmpty())) && 
        (relativeToConcept != null)) && 
        (relativeToNameParts != null)) && 
        (!relativeToNameParts.isEmpty()))) {
        conceptNameParts = DdmmUtils.<EObject, ROOT_CONCEPT>calculateRelativeQualifiedNameParts(concept, conceptNameParts, rootConceptClazz, relativeToConcept, relativeToNameParts, rootConceptClazz);
      }
      if (((conceptNameParts != null) && (!conceptNameParts.isEmpty()))) {
        final QualifiedName conceptName = QualifiedName.create(conceptNameParts);
        scopeElements.add(EObjectDescription.create(conceptName, concept));
      }
    };
    IterableExtensions.<CONCEPT_TO_NAME>filter(conceptsToName, _function).forEach(_function_1);
    return MapBasedScope.createScope(IScope.NULLSCOPE, scopeElements);
  }
  
  /**
   * Get index of first duplicate entry from a list, or -1 if list does not contain duplicates
   */
  public static <T extends Object, S extends Object> Integer getDuplicateIndex(final List<T> list, final Function<T, S> getCompareValue, final Predicate<T>... compareValueFilterPredicates) {
    if (((list == null) || (getCompareValue == null))) {
      throw new IllegalArgumentException("List and compare property must not be null");
    }
    final boolean doFiltering = ((compareValueFilterPredicates != null) && 
      (!((List<Predicate<T>>)Conversions.doWrapArray(compareValueFilterPredicates)).isEmpty()));
    int _size = list.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer entryIndex : _doubleDotLessThan) {
      {
        final T entry = list.get((entryIndex).intValue());
        final boolean ignoreEntry = (doFiltering && IterableExtensions.<Predicate<T>>exists(((Iterable<Predicate<T>>)Conversions.doWrapArray(compareValueFilterPredicates)), ((Function1<Predicate<T>, Boolean>) (Predicate<T> it) -> {
          boolean _apply = it.apply(entry);
          return Boolean.valueOf((!_apply));
        })));
        if ((!ignoreEntry)) {
          final S entryValue = getCompareValue.apply(entry);
          int _size_1 = list.size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(((entryIndex).intValue() + 1), _size_1, true);
          for (final Integer compareIndex : _doubleDotLessThan_1) {
            {
              final T entryToCompare = list.get((compareIndex).intValue());
              final boolean ignoreEntryToCompare = (doFiltering && 
                IterableExtensions.<Predicate<T>>exists(((Iterable<Predicate<T>>)Conversions.doWrapArray(compareValueFilterPredicates)), ((Function1<Predicate<T>, Boolean>) (Predicate<T> it) -> {
                  boolean _apply = it.apply(entryToCompare);
                  return Boolean.valueOf((!_apply));
                })));
              if ((!ignoreEntryToCompare)) {
                final S valueToCompare = getCompareValue.apply(entryToCompare);
                boolean _equals = Objects.equal(entryValue, valueToCompare);
                if (_equals) {
                  return compareIndex;
                }
              }
            }
          }
        }
      }
    }
    return Integer.valueOf((-1));
  }
  
  /**
   * Merge an arbitrary number of scopes by building a new scope that contains all elements of the
   * given scopes
   */
  public static IScope mergeScopes(final IScope... scopes) {
    if (((scopes == null) || ((List<IScope>)Conversions.doWrapArray(scopes)).isEmpty())) {
      return IScope.NULLSCOPE;
    }
    final ArrayList<EObject> mergedScopeElements = CollectionLiterals.<EObject>newArrayList();
    final Consumer<IScope> _function = (IScope it) -> {
      final Function1<IEObjectDescription, EObject> _function_1 = (IEObjectDescription it_1) -> {
        return it_1.getEObjectOrProxy();
      };
      Iterables.<EObject>addAll(mergedScopeElements, IterableExtensions.<IEObjectDescription, EObject>map(it.getAllElements(), _function_1));
    };
    ((List<IScope>)Conversions.doWrapArray(scopes)).forEach(_function);
    return Scopes.scopeFor(mergedScopeElements);
  }
  
  /**
   * Check that an imported resource is of a given type
   */
  public static <T extends EObject> boolean isImportOfType(final Resource context, final String importUri, final Class<T> expectedRootType) {
    final EList<EObject> modelContents = DdmmUtils.getImportedModelContents(context, importUri);
    if (((modelContents == null) || modelContents.isEmpty())) {
      return false;
    }
    final EObject rootElement = modelContents.get(0);
    if ((rootElement == null)) {
      return false;
    }
    return ((List<Class<?>>)Conversions.doWrapArray(rootElement.getClass().getInterfaces())).contains(expectedRootType);
  }
  
  /**
   * Trim path by another. For example, calling this method with
   *   pathToTrim = "/home/user/folder/file.txt" and
   *   by = "/home/user/anotherFolder/anotherFile.dat"
   * will result in
   *   "/anotherFolder/anotherFile.dat"
   */
  public static String trimPathBy(final String pathToTrim, final String by) {
    final String[] toTrimSegments = pathToTrim.split(File.separator);
    final String[] bySegments = by.split(File.separator);
    int equalToIndex = (-1);
    int currentIndex = 0;
    while ((((currentIndex < toTrimSegments.length) && (currentIndex < bySegments.length)) && 
      Objects.equal(toTrimSegments[currentIndex], bySegments[currentIndex]))) {
      {
        equalToIndex = currentIndex;
        currentIndex++;
      }
    }
    if (((equalToIndex > (-1)) && (equalToIndex < (toTrimSegments.length - 1)))) {
      String trimmedPath = "";
      int n = (equalToIndex + 1);
      while ((n < toTrimSegments.length)) {
        {
          String _trimmedPath = trimmedPath;
          String _get = toTrimSegments[n];
          String _plus = (File.separator + _get);
          trimmedPath = (_trimmedPath + _plus);
          n++;
        }
      }
      return trimmedPath;
    } else {
      return pathToTrim;
    }
  }
}

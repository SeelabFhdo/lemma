/**
 * generated by Xtext 2.12.0
 */
package de.fhdo.lemma.data.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.ImportedComplexType;
import de.fhdo.lemma.data.Version;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Scope provider for data models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DataDslScopeProvider extends AbstractDataDslScopeProvider {
  /**
   * Build scope for a given context and reference
   */
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _switchResult = null;
    boolean _matched = false;
    if (context instanceof DataModel) {
      _matched=true;
      _switchResult = this.getScope(((DataModel)context), reference);
    }
    if (!_matched) {
      if (context instanceof ImportedComplexType) {
        _matched=true;
        _switchResult = this.getScope(((ImportedComplexType)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof DataStructure) {
        _matched=true;
        _switchResult = this.getScope(((DataStructure)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof CollectionType) {
        _matched=true;
        _switchResult = this.getScope(((CollectionType)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof DataField) {
        _matched=true;
        _switchResult = this.getScope(((DataField)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof DataOperation) {
        _matched=true;
        _switchResult = this.getScope(((DataOperation)context), reference);
      }
    }
    final IScope scope = _switchResult;
    if ((scope != null)) {
      return scope;
    } else {
      if ((scope == null)) {
        return super.getScope(context, reference);
      }
    }
    return null;
  }

  /**
   * Build scope for the given reference in the context of a data model
   */
  private IScope getScope(final DataModel dataModel, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, DataPackage.Literals.DATA_FIELD__COMPLEX_TYPE)) {
      _matched=true;
      return this.getScopeForPossiblyImportedComplexTypes(dataModel, null);
    }
    return null;
  }

  /**
   * Build scope for the given reference in the context of an imported complex type
   */
  private IScope getScope(final ImportedComplexType complexType, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, DataPackage.Literals.IMPORTED_COMPLEX_TYPE__IMPORT)) {
      _matched=true;
      final DataModel dataModel = EcoreUtil2.<DataModel>getContainerOfType(complexType, DataModel.class);
      return Scopes.scopeFor(dataModel.getComplexTypeImports());
    }
    if (!_matched) {
      if (Objects.equal(reference, DataPackage.Literals.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE)) {
        _matched=true;
        ComplexTypeImport _import = complexType.getImport();
        String _importURI = null;
        if (_import!=null) {
          _importURI=_import.getImportURI();
        }
        return this.getScopeForPossiblyImportedComplexTypes(complexType, _importURI);
      }
    }
    return null;
  }

  /**
   * Convenience method to create a scope for imported complex types of certain types
   */
  private IScope getScopeForPossiblyImportedComplexTypes(final EObject context, final String importUri) {
    EObject container = null;
    List<String> qualifiedNameParts = null;
    final Context containingContext = EcoreUtil2.<Context>getContainerOfType(context, Context.class);
    final Version containingVersion = EcoreUtil2.<Version>getContainerOfType(context, Version.class);
    final DataModel containingDataModel = EcoreUtil2.<DataModel>getContainerOfType(context, DataModel.class);
    if ((containingContext != null)) {
      container = containingContext;
      qualifiedNameParts = containingContext.getQualifiedNameParts();
    } else {
      if ((containingVersion != null)) {
        container = containingVersion;
        qualifiedNameParts = containingVersion.getQualifiedNameParts();
      } else {
        if ((containingDataModel != null)) {
          container = containingDataModel;
          qualifiedNameParts = null;
        }
      }
    }
    final Function<DataModel, List<ComplexType>> _function = (DataModel it) -> {
      return this.allComplexTypesDefinedIn(it);
    };
    final Function<ComplexType, List<String>> _function_1 = (ComplexType it) -> {
      return it.getQualifiedNameParts();
    };
    return LemmaUtils.<EObject, DataModel, ComplexType>getScopeForPossiblyImportedConcept(container, qualifiedNameParts, 
      DataModel.class, importUri, _function, _function_1);
  }

  /**
   * Helper to get all complex types being defined in a data model
   */
  private List<ComplexType> allComplexTypesDefinedIn(final DataModel dataModel) {
    final ArrayList<ComplexType> allComplexTypes = CollectionLiterals.<ComplexType>newArrayList();
    final Consumer<Version> _function = (Version it) -> {
      final Function1<Context, EList<ComplexType>> _function_1 = (Context it_1) -> {
        return it_1.getComplexTypes();
      };
      allComplexTypes.addAll(IterableExtensions.<ComplexType>toList(Iterables.<ComplexType>concat(ListExtensions.<Context, EList<ComplexType>>map(it.getContexts(), _function_1))));
      allComplexTypes.addAll(it.getComplexTypes());
    };
    dataModel.getVersions().forEach(_function);
    final Function1<Context, EList<ComplexType>> _function_1 = (Context it) -> {
      return it.getComplexTypes();
    };
    allComplexTypes.addAll(IterableExtensions.<ComplexType>toList(Iterables.<ComplexType>concat(ListExtensions.<Context, EList<ComplexType>>map(dataModel.getContexts(), _function_1))));
    allComplexTypes.addAll(dataModel.getComplexTypes());
    return allComplexTypes;
  }

  /**
   * Build scope for the given reference in the context of a data structure
   */
  private IScope getScope(final DataStructure structure, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, DataPackage.Literals.DATA_STRUCTURE__SUPER)) {
      _matched=true;
      return this.getScopeForSuperStructures(structure);
    }
    if (!_matched) {
      if (Objects.equal(reference, DataPackage.Literals.IMPORTED_COMPLEX_TYPE__IMPORT)) {
        _matched=true;
        final DataModel dataModel = EcoreUtil2.<DataModel>getContainerOfType(structure, DataModel.class);
        return Scopes.scopeFor(dataModel.getComplexTypeImports());
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, DataPackage.Literals.DATA_FIELD__COMPLEX_TYPE)) {
        _matched=true;
        return this.getScopeForPossiblyImportedComplexTypes(structure, null);
      }
    }
    return null;
  }

  /**
   * Convenience method to create a scope for super structures
   */
  private IScope getScopeForSuperStructures(final DataStructure structure) {
    final DataModel modelRoot = EcoreUtil2.<DataModel>getContainerOfType(structure, DataModel.class);
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      return Boolean.valueOf(((it instanceof DataStructure) && (!Objects.equal(it, structure))));
    };
    final Iterable<ComplexType> localStructures = IterableExtensions.<ComplexType>filter(this.allComplexTypesDefinedIn(modelRoot), _function);
    final Function<ComplexType, List<String>> _function_1 = (ComplexType it) -> {
      return it.getQualifiedNameParts();
    };
    return LemmaUtils.<ComplexType, DataStructure, DataModel>getScopeWithRelativeQualifiedNames(
      IterableExtensions.<ComplexType>toList(localStructures), _function_1, structure, 
      structure.getQualifiedNameParts(), 
      DataModel.class);
  }

  /**
   * Build scope for the given reference in the context of a data structure
   */
  private IScope getScope(final CollectionType collectionType, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, DataPackage.Literals.IMPORTED_COMPLEX_TYPE__IMPORT)) {
      _matched=true;
      final DataModel dataModel = EcoreUtil2.<DataModel>getContainerOfType(collectionType, DataModel.class);
      return Scopes.scopeFor(dataModel.getComplexTypeImports());
    }
    if (!_matched) {
      if (Objects.equal(reference, DataPackage.Literals.DATA_FIELD__COMPLEX_TYPE)) {
        _matched=true;
        return this.getScopeForPossiblyImportedComplexTypes(collectionType, null);
      }
    }
    return null;
  }

  /**
   * Build scope for the given reference in the context of a data field
   */
  private IScope getScope(final DataField field, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, DataPackage.Literals.IMPORTED_COMPLEX_TYPE__IMPORT)) {
      _matched=true;
      final DataModel dataModel = EcoreUtil2.<DataModel>getContainerOfType(field, DataModel.class);
      return Scopes.scopeFor(dataModel.getComplexTypeImports());
    }
    if (!_matched) {
      if (Objects.equal(reference, DataPackage.Literals.DATA_FIELD__COMPLEX_TYPE)) {
        _matched=true;
        return this.getScopeForPossiblyImportedComplexTypes(field, null);
      }
    }
    return null;
  }

  /**
   * Build scope for the given reference in the context of a data operation
   */
  private IScope getScope(final DataOperation operation, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, DataPackage.Literals.IMPORTED_COMPLEX_TYPE__IMPORT)) {
      _matched=true;
      final DataModel dataModel = EcoreUtil2.<DataModel>getContainerOfType(operation, DataModel.class);
      return Scopes.scopeFor(dataModel.getComplexTypeImports());
    }
    if (!_matched) {
      if (Objects.equal(reference, DataPackage.Literals.DATA_OPERATION_PARAMETER__COMPLEX_TYPE)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(reference, DataPackage.Literals.DATA_OPERATION__COMPLEX_RETURN_TYPE)) {
          _matched=true;
        }
      }
      if (_matched) {
        return this.getScopeForPossiblyImportedComplexTypes(operation, null);
      }
    }
    return null;
  }
}

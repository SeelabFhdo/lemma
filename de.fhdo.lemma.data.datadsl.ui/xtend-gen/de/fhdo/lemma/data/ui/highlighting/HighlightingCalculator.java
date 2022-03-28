package de.fhdo.lemma.data.ui.highlighting;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.PrimitiveValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Provide custom syntax highlighting for certain elements.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class HighlightingCalculator implements ISemanticHighlightingCalculator {
  /**
   * Provide highlighting
   */
  @Override
  public void provideHighlightingFor(final XtextResource resource, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    this.provideHighlightingForBooleanConstants(resource, acceptor);
    this.provideHighlightingForFeatures(resource, acceptor);
  }
  
  /**
   * Provide highlighting for boolean values
   */
  private void provideHighlightingForBooleanConstants(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      boolean _xblockexpression = false;
      {
        final PrimitiveValue value = ((DataField) it).getInitializationValue();
        _xblockexpression = ((value != null) && (value.getBooleanValue() != null));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    Pair<Function1<EObject, Boolean>, EReference> _mappedTo = Pair.<Function1<EObject, Boolean>, EReference>of(_function, DataPackage.Literals.DATA_FIELD__INITIALIZATION_VALUE);
    Pair<Class<DataField>, List<Pair<Function1<EObject, Boolean>, EReference>>> _mappedTo_1 = Pair.<Class<DataField>, List<Pair<Function1<EObject, Boolean>, EReference>>>of(DataField.class, Collections.<Pair<Function1<EObject, Boolean>, EReference>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, Boolean>, EReference>>newArrayList(_mappedTo)));
    final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
      boolean _xblockexpression = false;
      {
        final PrimitiveValue value = ((EnumerationField) it).getInitializationValue();
        _xblockexpression = ((value != null) && (value.getBooleanValue() != null));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    Pair<Function1<EObject, Boolean>, EReference> _mappedTo_2 = Pair.<Function1<EObject, Boolean>, EReference>of(_function_1, DataPackage.Literals.ENUMERATION_FIELD__INITIALIZATION_VALUE);
    Pair<Class<EnumerationField>, List<Pair<Function1<EObject, Boolean>, EReference>>> _mappedTo_3 = Pair.<Class<EnumerationField>, List<Pair<Function1<EObject, Boolean>, EReference>>>of(EnumerationField.class, Collections.<Pair<Function1<EObject, Boolean>, EReference>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, Boolean>, EReference>>newArrayList(_mappedTo_2)));
    final HashMap<Class<? extends EObject>, List<Pair<Function1<EObject, Boolean>, EReference>>> booleanConcepts = CollectionLiterals.<Class<? extends EObject>, List<Pair<Function1<EObject, Boolean>, EReference>>>newHashMap(_mappedTo_1, _mappedTo_3);
    final Procedure1<EObject> _function_2 = (EObject eObject) -> {
      final Function1<Class<? extends EObject>, Boolean> _function_3 = (Class<? extends EObject> it) -> {
        return Boolean.valueOf(it.isInstance(eObject));
      };
      final Class<? extends EObject> matchingBooleanConcept = IterableExtensions.<Class<? extends EObject>>findFirst(booleanConcepts.keySet(), _function_3);
      if ((matchingBooleanConcept != null)) {
        final List<Pair<Function1<EObject, Boolean>, EReference>> primitiveValueGetters = booleanConcepts.get(matchingBooleanConcept);
        final Consumer<Pair<Function1<EObject, Boolean>, EReference>> _function_4 = (Pair<Function1<EObject, Boolean>, EReference> it) -> {
          final Function1<EObject, Boolean> isBooleanValue = it.getKey();
          final EReference feature = it.getValue();
          Boolean _apply = isBooleanValue.apply(eObject);
          if ((_apply).booleanValue()) {
            final Consumer<INode> _function_5 = (INode it_1) -> {
              acceptor.addPosition(it_1.getOffset(), it_1.getLength(), 
                HighlightingConfiguration.KEYWORD_ID);
            };
            NodeModelUtils.findNodesForFeature(eObject, feature).forEach(_function_5);
          }
        };
        primitiveValueGetters.forEach(_function_4);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function_2);
  }
  
  /**
   * Provide highlighting for features
   */
  private void provideHighlightingForFeatures(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Procedure1<EObject> _function = (EObject it) -> {
      final Consumer<INode> _function_1 = (INode it_1) -> {
        acceptor.addPosition(it_1.getOffset(), it_1.getLength(), HighlightingConfiguration.FEATURE_ID);
      };
      this.getNodesWithFeatures(it).forEach(_function_1);
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
  }
  
  /**
   * Get feature nodes on EObjects that support feature specification
   */
  private List<INode> getNodesWithFeatures(final EObject eObject) {
    List<INode> _switchResult = null;
    boolean _matched = false;
    if (eObject instanceof ComplexType) {
      _matched=true;
      _switchResult = NodeModelUtils.findNodesForFeature(eObject, 
        DataPackage.Literals.COMPLEX_TYPE__FEATURES);
    }
    if (!_matched) {
      if (eObject instanceof DataField) {
        _matched=true;
        _switchResult = NodeModelUtils.findNodesForFeature(eObject, 
          DataPackage.Literals.DATA_FIELD__FEATURES);
      }
    }
    if (!_matched) {
      if (eObject instanceof DataOperation) {
        _matched=true;
        _switchResult = NodeModelUtils.findNodesForFeature(eObject, 
          DataPackage.Literals.DATA_OPERATION__FEATURES);
      }
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<INode>emptyList();
    }
    return _switchResult;
  }
}

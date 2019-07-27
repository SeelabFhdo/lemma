package de.fhdo.lemma.operationdsl.ui.highlighting;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.operation.ImportedOperationAspect;
import de.fhdo.lemma.operation.OperationNode;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operationdsl.ui.highlighting.HighlightingConfiguration;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;
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
    this.provideHighlightingForAnnotations(resource, acceptor);
    this.provideHighlightingForBooleanConstants(resource, acceptor);
  }
  
  /**
   * Provide highlighting for annotations
   */
  private void provideHighlightingForAnnotations(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof OperationNode));
    };
    final Procedure1<EObject> _function_1 = (EObject it) -> {
      final List<INode> nodes = NodeModelUtils.findNodesForFeature(it, 
        OperationPackage.Literals.OPERATION_NODE__TECHNOLOGIES);
      final Consumer<INode> _function_2 = (INode it_1) -> {
        INode currentSibling = it_1.getPreviousSibling();
        boolean annotationBeginReached = false;
        while (((currentSibling != null) && (!annotationBeginReached))) {
          {
            String _text = currentSibling.getText();
            boolean _equals = Objects.equal(_text, "@");
            if (_equals) {
              annotationBeginReached = true;
            }
            String _text_1 = currentSibling.getText();
            boolean _notEquals = (!Objects.equal(_text_1, "("));
            if (_notEquals) {
              acceptor.addPosition(currentSibling.getOffset(), currentSibling.getLength(), 
                HighlightingConfiguration.ANNOTATION_ID);
            }
            currentSibling = currentSibling.getPreviousSibling();
          }
        }
      };
      nodes.forEach(_function_2);
    };
    IteratorExtensions.<EObject>forEach(IteratorExtensions.<EObject>filter(resource.getAllContents(), _function), _function_1);
  }
  
  /**
   * Provide highlighting for boolean values
   */
  private void provideHighlightingForBooleanConstants(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Function1<EObject, PrimitiveValue> _function = (EObject it) -> {
      return ((ImportedOperationAspect) it).getSinglePropertyValue();
    };
    Pair<Function1<EObject, PrimitiveValue>, EReference> _mappedTo = Pair.<Function1<EObject, PrimitiveValue>, EReference>of(_function, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE);
    Pair<Class<ImportedOperationAspect>, List<Pair<Function1<EObject, PrimitiveValue>, EReference>>> _mappedTo_1 = Pair.<Class<ImportedOperationAspect>, List<Pair<Function1<EObject, PrimitiveValue>, EReference>>>of(ImportedOperationAspect.class, Collections.<Pair<Function1<EObject, PrimitiveValue>, EReference>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, PrimitiveValue>, EReference>>newArrayList(_mappedTo)));
    final Function1<EObject, PrimitiveValue> _function_1 = (EObject it) -> {
      return ((TechnologySpecificPropertyValueAssignment) it).getValue();
    };
    Pair<Function1<EObject, PrimitiveValue>, EReference> _mappedTo_2 = Pair.<Function1<EObject, PrimitiveValue>, EReference>of(_function_1, TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE);
    Pair<Class<TechnologySpecificPropertyValueAssignment>, List<Pair<Function1<EObject, PrimitiveValue>, EReference>>> _mappedTo_3 = Pair.<Class<TechnologySpecificPropertyValueAssignment>, List<Pair<Function1<EObject, PrimitiveValue>, EReference>>>of(TechnologySpecificPropertyValueAssignment.class, Collections.<Pair<Function1<EObject, PrimitiveValue>, EReference>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, PrimitiveValue>, EReference>>newArrayList(_mappedTo_2)));
    final HashMap<Class<? extends EObject>, List<Pair<Function1<EObject, PrimitiveValue>, EReference>>> booleanConcepts = CollectionLiterals.<Class<? extends EObject>, List<Pair<Function1<EObject, PrimitiveValue>, EReference>>>newHashMap(_mappedTo_1, _mappedTo_3);
    final Procedure1<EObject> _function_2 = (EObject eObject) -> {
      final Function1<Class<? extends EObject>, Boolean> _function_3 = (Class<? extends EObject> it) -> {
        return Boolean.valueOf(it.isInstance(eObject));
      };
      final Class<? extends EObject> matchingBooleanConcept = IterableExtensions.<Class<? extends EObject>>findFirst(booleanConcepts.keySet(), _function_3);
      if ((matchingBooleanConcept != null)) {
        final List<Pair<Function1<EObject, PrimitiveValue>, EReference>> primitiveValueGetters = booleanConcepts.get(matchingBooleanConcept);
        final Consumer<Pair<Function1<EObject, PrimitiveValue>, EReference>> _function_4 = (Pair<Function1<EObject, PrimitiveValue>, EReference> it) -> {
          final Function1<EObject, PrimitiveValue> getter = it.getKey();
          final EReference feature = it.getValue();
          final PrimitiveValue primitiveValue = getter.apply(eObject);
          if (((primitiveValue != null) && (primitiveValue.getBooleanValue() != null))) {
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
}

package de.fhdo.lemma.ui.highlighting;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.ProtocolSpecification;
import de.fhdo.lemma.service.ReferredOperation;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
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
    this.provideHighlightingForDefaultTypeDefinitionFlag(resource, acceptor);
    this.provideHighlightingForBooleanConstants(resource, acceptor);
    this.provideHighlightingForApiComments(resource, acceptor);
  }
  
  /**
   * Provide highlighting for annotations
   */
  private void provideHighlightingForAnnotations(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    Pair<EReference, Boolean> _mappedTo = Pair.<EReference, Boolean>of(ServicePackage.Literals.MICROSERVICE__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<Microservice>, List<Pair<EReference, Boolean>>> _mappedTo_1 = Pair.<Class<Microservice>, List<Pair<EReference, Boolean>>>of(Microservice.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo)));
    Pair<EReference, Boolean> _mappedTo_2 = Pair.<EReference, Boolean>of(ServicePackage.Literals.TECHNOLOGY_REFERENCE__TECHNOLOGY, Boolean.valueOf(false));
    Pair<Class<TechnologyReference>, List<Pair<EReference, Boolean>>> _mappedTo_3 = Pair.<Class<TechnologyReference>, List<Pair<EReference, Boolean>>>of(TechnologyReference.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_2)));
    Pair<EReference, Boolean> _mappedTo_4 = Pair.<EReference, Boolean>of(ServicePackage.Literals.INTERFACE__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<Interface>, List<Pair<EReference, Boolean>>> _mappedTo_5 = Pair.<Class<Interface>, List<Pair<EReference, Boolean>>>of(Interface.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_4)));
    Pair<EReference, Boolean> _mappedTo_6 = Pair.<EReference, Boolean>of(ServicePackage.Literals.OPERATION__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<Operation>, List<Pair<EReference, Boolean>>> _mappedTo_7 = Pair.<Class<Operation>, List<Pair<EReference, Boolean>>>of(Operation.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_6)));
    Pair<EReference, Boolean> _mappedTo_8 = Pair.<EReference, Boolean>of(ServicePackage.Literals.REFERRED_OPERATION__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<ReferredOperation>, List<Pair<EReference, Boolean>>> _mappedTo_9 = Pair.<Class<ReferredOperation>, List<Pair<EReference, Boolean>>>of(ReferredOperation.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_8)));
    Pair<EReference, Boolean> _mappedTo_10 = Pair.<EReference, Boolean>of(ServicePackage.Literals.PROTOCOL_SPECIFICATION__PROTOCOL, Boolean.valueOf(false));
    Pair<Class<ProtocolSpecification>, List<Pair<EReference, Boolean>>> _mappedTo_11 = Pair.<Class<ProtocolSpecification>, List<Pair<EReference, Boolean>>>of(ProtocolSpecification.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_10)));
    Pair<EReference, Boolean> _mappedTo_12 = Pair.<EReference, Boolean>of(ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT, Boolean.valueOf(true));
    Pair<Class<ImportedServiceAspect>, List<Pair<EReference, Boolean>>> _mappedTo_13 = Pair.<Class<ImportedServiceAspect>, List<Pair<EReference, Boolean>>>of(ImportedServiceAspect.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_12)));
    final Map<Class<? extends EObject>, List<Pair<EReference, Boolean>>> annotatableConcepts = Collections.<Class<? extends EObject>, List<Pair<EReference, Boolean>>>unmodifiableMap(CollectionLiterals.<Class<? extends EObject>, List<Pair<EReference, Boolean>>>newHashMap(_mappedTo_1, _mappedTo_3, _mappedTo_5, _mappedTo_7, _mappedTo_9, _mappedTo_11, _mappedTo_13));
    final BiConsumer<Class<? extends EObject>, List<Pair<EReference, Boolean>>> _function = (Class<? extends EObject> concept, List<Pair<EReference, Boolean>> featureDescriptions) -> {
      final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
        return Boolean.valueOf(concept.isInstance(it));
      };
      final Procedure1<EObject> _function_2 = (EObject it) -> {
        final Consumer<Pair<EReference, Boolean>> _function_3 = (Pair<EReference, Boolean> featureDescription) -> {
          final EReference feature = featureDescription.getKey();
          final Boolean highlightImmediately = featureDescription.getValue();
          final Consumer<INode> _function_4 = (INode it_1) -> {
            INode nodeToHighlight = it_1;
            if ((!(highlightImmediately).booleanValue())) {
              while ((this.hasNextNode(nodeToHighlight) && 
                (!this.nextNodeIsOpeningAspectBracket(nodeToHighlight)))) {
                nodeToHighlight = nodeToHighlight.getPreviousSibling();
              }
            }
            if ((nodeToHighlight != null)) {
              final Function<INode, INode> _function_5 = (INode it_2) -> {
                return it_2.getPreviousSibling();
              };
              this.highlightUntil(nodeToHighlight, _function_5, "@", acceptor, 
                HighlightingConfiguration.ANNOTATION_ID, true);
            }
          };
          NodeModelUtils.findNodesForFeature(it, feature).forEach(_function_4);
        };
        featureDescriptions.forEach(_function_3);
      };
      IteratorExtensions.<EObject>forEach(IteratorExtensions.<EObject>filter(resource.getAllContents(), _function_1), _function_2);
    };
    annotatableConcepts.forEach(_function);
  }
  
  /**
   * Check if the given node has a next sibling
   */
  private boolean hasNextNode(final INode node) {
    return ((node != null) && (node.getNextSibling() != null));
  }
  
  /**
   * Check if the next sibling of the given node is the opening bracket of an aspect string
   */
  private boolean nextNodeIsOpeningAspectBracket(final INode node) {
    return (Objects.equal(node.getNextSibling().getText(), "(") || Objects.equal(node.getNextSibling().getText(), "({"));
  }
  
  /**
   * Provide highlighting for default type definition flag of built-in @technology annotation
   */
  private void provideHighlightingForDefaultTypeDefinitionFlag(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    List<EObject> _list = IteratorExtensions.<EObject>toList(resource.getAllContents());
    for (final EObject eObject : _list) {
      {
        final List<INode> relevantFeatures = NodeModelUtils.findNodesForFeature(eObject, 
          ServicePackage.Literals.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY);
        boolean _isEmpty = relevantFeatures.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          INode currentNode = relevantFeatures.get(0).getPreviousSibling();
          boolean typedefKeywordColored = false;
          while (((currentNode != null) && (!typedefKeywordColored))) {
            String _keywordValue = this.keywordValue(currentNode);
            boolean _equals = Objects.equal("typedef", _keywordValue);
            if (_equals) {
              acceptor.addPosition(currentNode.getOffset(), currentNode.getLength(), 
                HighlightingConfiguration.DEFAULT_ID);
              typedefKeywordColored = true;
            } else {
              currentNode = currentNode.getPreviousSibling();
            }
          }
        }
      }
    }
  }
  
  /**
   * Helper to return the value of a Keyword INode. Returns an empty string if the passed node is
   * not a Keyword.
   */
  private String keywordValue(final INode node) {
    final EObject grammarElement = node.getGrammarElement();
    String _xifexpression = null;
    if ((grammarElement instanceof Keyword)) {
      _xifexpression = ((Keyword)grammarElement).getValue();
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  /**
   * Provide highlighting for boolean values
   */
  private void provideHighlightingForBooleanConstants(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      boolean _xblockexpression = false;
      {
        final PrimitiveValue value = ((ImportedServiceAspect) it).getSinglePropertyValue();
        _xblockexpression = ((value != null) && (value.getBooleanValue() != null));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    Pair<Function1<EObject, Boolean>, EReference> _mappedTo = Pair.<Function1<EObject, Boolean>, EReference>of(_function, ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE);
    Pair<Class<ImportedServiceAspect>, List<Pair<Function1<EObject, Boolean>, EReference>>> _mappedTo_1 = Pair.<Class<ImportedServiceAspect>, List<Pair<Function1<EObject, Boolean>, EReference>>>of(ImportedServiceAspect.class, Collections.<Pair<Function1<EObject, Boolean>, EReference>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, Boolean>, EReference>>newArrayList(_mappedTo)));
    final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
      boolean _xblockexpression = false;
      {
        final PrimitiveValue value = ((TechnologySpecificPropertyValueAssignment) it).getValue();
        _xblockexpression = ((value != null) && (value.getBooleanValue() != null));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    Pair<Function1<EObject, Boolean>, EReference> _mappedTo_2 = Pair.<Function1<EObject, Boolean>, EReference>of(_function_1, TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE);
    Pair<Class<TechnologySpecificPropertyValueAssignment>, List<Pair<Function1<EObject, Boolean>, EReference>>> _mappedTo_3 = Pair.<Class<TechnologySpecificPropertyValueAssignment>, List<Pair<Function1<EObject, Boolean>, EReference>>>of(TechnologySpecificPropertyValueAssignment.class, Collections.<Pair<Function1<EObject, Boolean>, EReference>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, Boolean>, EReference>>newArrayList(_mappedTo_2)));
    final Function1<EObject, Boolean> _function_2 = (EObject it) -> {
      return Boolean.valueOf(true);
    };
    Pair<Function1<EObject, Boolean>, EAttribute> _mappedTo_4 = Pair.<Function1<EObject, Boolean>, EAttribute>of(_function_2, ServicePackage.Literals.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY);
    Pair<Class<TechnologyReference>, List<Pair<Function1<EObject, Boolean>, EAttribute>>> _mappedTo_5 = Pair.<Class<TechnologyReference>, List<Pair<Function1<EObject, Boolean>, EAttribute>>>of(TechnologyReference.class, Collections.<Pair<Function1<EObject, Boolean>, EAttribute>>unmodifiableList(CollectionLiterals.<Pair<Function1<EObject, Boolean>, EAttribute>>newArrayList(_mappedTo_4)));
    final HashMap<Class<? extends EObject>, List<? extends Pair<Function1<EObject, Boolean>, ? extends EStructuralFeature>>> booleanConcepts = CollectionLiterals.<Class<? extends EObject>, List<? extends Pair<Function1<EObject, Boolean>, ? extends EStructuralFeature>>>newHashMap(_mappedTo_1, _mappedTo_3, _mappedTo_5);
    final Procedure1<EObject> _function_3 = (EObject eObject) -> {
      final Function1<Class<? extends EObject>, Boolean> _function_4 = (Class<? extends EObject> it) -> {
        return Boolean.valueOf(it.isInstance(eObject));
      };
      final Class<? extends EObject> matchingBooleanConcept = IterableExtensions.<Class<? extends EObject>>findFirst(booleanConcepts.keySet(), _function_4);
      if ((matchingBooleanConcept != null)) {
        final List<? extends Pair<Function1<EObject, Boolean>, ? extends EStructuralFeature>> primitiveValueGetters = booleanConcepts.get(matchingBooleanConcept);
        final Consumer<Pair<Function1<EObject, Boolean>, ? extends EStructuralFeature>> _function_5 = (Pair<Function1<EObject, Boolean>, ? extends EStructuralFeature> it) -> {
          final Function1<EObject, Boolean> isBooleanValue = it.getKey();
          final EStructuralFeature feature = it.getValue();
          Boolean _apply = isBooleanValue.apply(eObject);
          if ((_apply).booleanValue()) {
            final Consumer<INode> _function_6 = (INode it_1) -> {
              acceptor.addPosition(it_1.getOffset(), it_1.getLength(), 
                HighlightingConfiguration.KEYWORD_ID);
            };
            NodeModelUtils.findNodesForFeature(eObject, feature).forEach(_function_6);
          }
        };
        primitiveValueGetters.forEach(_function_5);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function_3);
  }
  
  /**
   * Provide highlighting for API operation comments
   */
  private void provideHighlightingForApiComments(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Procedure1<EObject> _function = (EObject it) -> {
      final List<INode> commentFeatures = NodeModelUtils.findNodesForFeature(it, ServicePackage.Literals.API_OPERATION_COMMENT__COMMENT);
      boolean _isEmpty = commentFeatures.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Consumer<INode> _function_1 = (INode it_1) -> {
          acceptor.addPosition(it_1.getOffset(), it_1.getLength(), HighlightingConfiguration.API_OPERATION_ID);
        };
        commentFeatures.forEach(_function_1);
        final Function<INode, INode> _function_2 = (INode it_1) -> {
          return it_1.getPreviousSibling();
        };
        this.highlightUntil(commentFeatures.get(0), _function_2, "---", acceptor, 
          HighlightingConfiguration.API_OPERATION_ID, false);
        final Function<INode, INode> _function_3 = (INode it_1) -> {
          return it_1.getNextSibling();
        };
        this.highlightUntil(commentFeatures.get(0), _function_3, "---", acceptor, 
          HighlightingConfiguration.API_OPERATION_ID, false);
      }
      final List<INode> parameterFeatures = NodeModelUtils.findNodesForFeature(it, ServicePackage.Literals.API_PARAMETER_COMMENT__PARAMETER);
      boolean _isEmpty_1 = parameterFeatures.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        final Function<INode, INode> _function_4 = (INode it_1) -> {
          return it_1.getPreviousSibling();
        };
        this.highlightUntil(commentFeatures.get(0).getPreviousSibling(), _function_4, "@", acceptor, HighlightingConfiguration.TASK_ID, false);
        final Consumer<INode> _function_5 = (INode it_1) -> {
          acceptor.addPosition(it_1.getOffset(), it_1.getLength(), HighlightingConfiguration.API_PARAMETER_ID);
        };
        parameterFeatures.forEach(_function_5);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
  }
  
  /**
   * Helper to iteratively highlight nodes until a node with a certain text was reached
   */
  private void highlightUntil(final INode startNode, final Function<INode, INode> getNextNode, final String until, final IHighlightedPositionAcceptor acceptor, final String highlightId, final boolean colorStartNode) {
    if (colorStartNode) {
      acceptor.addPosition(startNode.getOffset(), startNode.getLength(), highlightId);
    }
    String _text = startNode.getText();
    boolean _equals = Objects.equal(until, _text);
    if (_equals) {
      return;
    }
    INode nextNode = startNode;
    boolean endReached = false;
    do {
      {
        nextNode = getNextNode.apply(nextNode);
        if ((nextNode != null)) {
          acceptor.addPosition(nextNode.getOffset(), nextNode.getLength(), highlightId);
          String _text_1 = nextNode.getText();
          boolean _equals_1 = Objects.equal(until, _text_1);
          endReached = _equals_1;
        }
      }
    } while(((nextNode != null) && (!endReached)));
  }
}

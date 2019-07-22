package de.fhdo.ddmm.technology.mappingdsl.ui.highlighting;

import com.google.common.base.Objects;
import de.fhdo.ddmm.service.ServicePackage;
import de.fhdo.ddmm.service.TechnologyReference;
import de.fhdo.ddmm.technology.mapping.ComplexTypeMapping;
import de.fhdo.ddmm.technology.mappingdsl.ui.highlighting.HighlightingConfiguration;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
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
  }
  
  /**
   * Provide highlighting for annotations
   */
  private void provideHighlightingForAnnotations(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf(((it instanceof ComplexTypeMapping) || (it instanceof TechnologyReference)));
    };
    final Procedure1<EObject> _function_1 = (EObject it) -> {
      final List<INode> nodes = NodeModelUtils.findNodesForFeature(it, 
        ServicePackage.Literals.TECHNOLOGY_REFERENCE__TECHNOLOGY);
      final Consumer<INode> _function_2 = (INode it_1) -> {
        INode nodeToHighlight = it_1;
        while ((((nodeToHighlight != null) && 
          (nodeToHighlight.getNextSibling() != null)) && 
          (!Objects.equal(nodeToHighlight.getNextSibling().getText(), "(")))) {
          nodeToHighlight = nodeToHighlight.getPreviousSibling();
        }
        if ((nodeToHighlight != null)) {
          do {
            {
              acceptor.addPosition(nodeToHighlight.getOffset(), nodeToHighlight.getLength(), 
                HighlightingConfiguration.ANNOTATION_ID);
              nodeToHighlight = nodeToHighlight.getPreviousSibling();
            }
          } while((((nodeToHighlight != null) && 
            (nodeToHighlight.getNextSibling() != null)) && 
            (!Objects.equal(nodeToHighlight.getNextSibling().getText(), "@"))));
        }
      };
      nodes.forEach(_function_2);
    };
    IteratorExtensions.<EObject>forEach(IteratorExtensions.<EObject>filter(resource.getAllContents(), _function), _function_1);
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
}

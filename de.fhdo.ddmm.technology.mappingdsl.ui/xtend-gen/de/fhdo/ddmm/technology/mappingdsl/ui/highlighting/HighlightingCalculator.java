package de.fhdo.ddmm.technology.mappingdsl.ui.highlighting;

import com.google.common.base.Objects;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mappingdsl.ui.highlighting.HighlightingConfiguration;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
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
  }
  
  /**
   * Provide highlighting for annotations
   */
  private void provideHighlightingForAnnotations(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof MicroserviceMapping));
    };
    final Procedure1<EObject> _function_1 = (EObject it) -> {
      final List<INode> nodes = NodeModelUtils.findNodesForFeature(it, 
        MappingPackage.Literals.MICROSERVICE_MAPPING__TECHNOLOGIES);
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
}

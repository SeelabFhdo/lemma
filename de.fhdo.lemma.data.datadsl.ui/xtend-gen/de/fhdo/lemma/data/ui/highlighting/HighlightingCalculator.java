package de.fhdo.lemma.data.ui.highlighting;

import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.PrimitiveValue;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
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
    final Procedure1<EObject> _function = (EObject it) -> {
      boolean _and = false;
      if (!(it instanceof EnumerationField)) {
        _and = false;
      } else {
        PrimitiveValue _initializationValue = ((EnumerationField) it).getInitializationValue();
        Boolean _booleanValue = null;
        if (_initializationValue!=null) {
          _booleanValue=_initializationValue.getBooleanValue();
        }
        boolean _tripleNotEquals = (_booleanValue != null);
        _and = _tripleNotEquals;
      }
      final boolean booleanInitializedEnumerationField = _and;
      if (booleanInitializedEnumerationField) {
        final Consumer<INode> _function_1 = (INode it_1) -> {
          acceptor.addPosition(it_1.getOffset(), it_1.getLength(), 
            DefaultHighlightingConfiguration.KEYWORD_ID);
        };
        NodeModelUtils.findNodesForFeature(it, 
          DataPackage.Literals.ENUMERATION_FIELD__INITIALIZATION_VALUE).forEach(_function_1);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
  }
}

package de.fhdo.ddmm.ui.highlighting;

import com.google.common.base.Objects;
import de.fhdo.ddmm.service.ImportedServiceAspect;
import de.fhdo.ddmm.service.Interface;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.Operation;
import de.fhdo.ddmm.service.ProtocolSpecification;
import de.fhdo.ddmm.service.ReferredOperation;
import de.fhdo.ddmm.service.ServicePackage;
import de.fhdo.ddmm.ui.highlighting.HighlightingConfiguration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
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
  }
  
  /**
   * Provide highlighting for annotations
   */
  private void provideHighlightingForAnnotations(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    Pair<EReference, Boolean> _mappedTo = Pair.<EReference, Boolean>of(ServicePackage.Literals.MICROSERVICE__TECHNOLOGY, Boolean.valueOf(false));
    Pair<EReference, Boolean> _mappedTo_1 = Pair.<EReference, Boolean>of(ServicePackage.Literals.MICROSERVICE__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<Microservice>, List<Pair<EReference, Boolean>>> _mappedTo_2 = Pair.<Class<Microservice>, List<Pair<EReference, Boolean>>>of(Microservice.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo, _mappedTo_1)));
    Pair<EReference, Boolean> _mappedTo_3 = Pair.<EReference, Boolean>of(ServicePackage.Literals.INTERFACE__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<Interface>, List<Pair<EReference, Boolean>>> _mappedTo_4 = Pair.<Class<Interface>, List<Pair<EReference, Boolean>>>of(Interface.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_3)));
    Pair<EReference, Boolean> _mappedTo_5 = Pair.<EReference, Boolean>of(ServicePackage.Literals.OPERATION__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<Operation>, List<Pair<EReference, Boolean>>> _mappedTo_6 = Pair.<Class<Operation>, List<Pair<EReference, Boolean>>>of(Operation.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_5)));
    Pair<EReference, Boolean> _mappedTo_7 = Pair.<EReference, Boolean>of(ServicePackage.Literals.REFERRED_OPERATION__ENDPOINTS, Boolean.valueOf(false));
    Pair<Class<ReferredOperation>, List<Pair<EReference, Boolean>>> _mappedTo_8 = Pair.<Class<ReferredOperation>, List<Pair<EReference, Boolean>>>of(ReferredOperation.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_7)));
    Pair<EReference, Boolean> _mappedTo_9 = Pair.<EReference, Boolean>of(ServicePackage.Literals.PROTOCOL_SPECIFICATION__PROTOCOL, Boolean.valueOf(false));
    Pair<Class<ProtocolSpecification>, List<Pair<EReference, Boolean>>> _mappedTo_10 = Pair.<Class<ProtocolSpecification>, List<Pair<EReference, Boolean>>>of(ProtocolSpecification.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_9)));
    Pair<EReference, Boolean> _mappedTo_11 = Pair.<EReference, Boolean>of(ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT, Boolean.valueOf(true));
    Pair<Class<ImportedServiceAspect>, List<Pair<EReference, Boolean>>> _mappedTo_12 = Pair.<Class<ImportedServiceAspect>, List<Pair<EReference, Boolean>>>of(ImportedServiceAspect.class, Collections.<Pair<EReference, Boolean>>unmodifiableList(CollectionLiterals.<Pair<EReference, Boolean>>newArrayList(_mappedTo_11)));
    final Map<Class<? extends EObject>, List<Pair<EReference, Boolean>>> annotatableConcepts = Collections.<Class<? extends EObject>, List<Pair<EReference, Boolean>>>unmodifiableMap(CollectionLiterals.<Class<? extends EObject>, List<Pair<EReference, Boolean>>>newHashMap(_mappedTo_2, _mappedTo_4, _mappedTo_6, _mappedTo_8, _mappedTo_10, _mappedTo_12));
    final BiConsumer<Class<? extends EObject>, List<Pair<EReference, Boolean>>> _function = (Class<? extends EObject> concept, List<Pair<EReference, Boolean>> featureDescriptions) -> {
      final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
        return Boolean.valueOf(concept.isInstance(it));
      };
      final Procedure1<EObject> _function_2 = (EObject it) -> {
        final Consumer<Pair<EReference, Boolean>> _function_3 = (Pair<EReference, Boolean> featureDescription) -> {
          final EReference feature = featureDescription.getKey();
          final Boolean highlightImmediately = featureDescription.getValue();
          final Consumer<INode> _function_4 = (INode it_1) -> {
            INode _xifexpression = null;
            if ((highlightImmediately).booleanValue()) {
              _xifexpression = it_1;
            } else {
              _xifexpression = it_1.getPreviousSibling();
            }
            INode currentSibling = _xifexpression;
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
          NodeModelUtils.findNodesForFeature(it, feature).forEach(_function_4);
        };
        featureDescriptions.forEach(_function_3);
      };
      IteratorExtensions.<EObject>forEach(IteratorExtensions.<EObject>filter(resource.getAllContents(), _function_1), _function_2);
    };
    annotatableConcepts.forEach(_function);
  }
}

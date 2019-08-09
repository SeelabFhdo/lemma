package de.fhdo.lemma.technology.ui.highlighting;

import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.technology.OperationAspectPointcut;
import de.fhdo.lemma.technology.ServiceAspectPointcut;
import de.fhdo.lemma.technology.TechnologyAspect;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificProperty;
import de.fhdo.lemma.technology.ui.highlighting.HighlightingConfiguration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
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
    this.provideHighlightingForPointcuts(resource, acceptor);
    this.provideHighlightingForBooleanConstants(resource, acceptor);
    this.provideHighlightingForFeatures(resource, acceptor);
  }
  
  /**
   * Provide highlighting for aspects' pointcuts
   */
  private void provideHighlightingForPointcuts(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    Pair<Class<ServiceAspectPointcut>, List<EAttribute>> _mappedTo = Pair.<Class<ServiceAspectPointcut>, List<EAttribute>>of(ServiceAspectPointcut.class, Collections.<EAttribute>unmodifiableList(CollectionLiterals.<EAttribute>newArrayList(TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE, TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT, TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN, TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL, TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN, TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE)));
    Pair<Class<OperationAspectPointcut>, List<EAttribute>> _mappedTo_1 = Pair.<Class<OperationAspectPointcut>, List<EAttribute>>of(OperationAspectPointcut.class, Collections.<EAttribute>unmodifiableList(CollectionLiterals.<EAttribute>newArrayList(TechnologyPackage.Literals.OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY)));
    final Map<Class<? extends EObject>, List<EAttribute>> pointcuts = Collections.<Class<? extends EObject>, List<EAttribute>>unmodifiableMap(CollectionLiterals.<Class<? extends EObject>, List<EAttribute>>newHashMap(_mappedTo, _mappedTo_1));
    final Function1<EObject, Boolean> _function = (EObject eObject) -> {
      final Function1<Class<? extends EObject>, Boolean> _function_1 = (Class<? extends EObject> it) -> {
        return Boolean.valueOf(it.isInstance(eObject));
      };
      return Boolean.valueOf(IterableExtensions.<Class<? extends EObject>>exists(pointcuts.keySet(), _function_1));
    };
    final Function1<EObject, EObject> _function_1 = (EObject it) -> {
      return it;
    };
    final Function1<EObject, List<EAttribute>> _function_2 = (EObject eObject) -> {
      List<EAttribute> _xblockexpression = null;
      {
        final Function1<Class<? extends EObject>, Boolean> _function_3 = (Class<? extends EObject> it) -> {
          return Boolean.valueOf(it.isInstance(eObject));
        };
        final Class<? extends EObject> pointcut = IterableExtensions.<Class<? extends EObject>>findFirst(pointcuts.keySet(), _function_3);
        _xblockexpression = pointcuts.get(pointcut);
      }
      return _xblockexpression;
    };
    final Map<EObject, List<EAttribute>> modeledPointcutsWithHighlightingFeatures = IteratorExtensions.<EObject, EObject, List<EAttribute>>toMap(IteratorExtensions.<EObject>filter(resource.getAllContents(), _function), _function_1, _function_2);
    final BiConsumer<EObject, List<EAttribute>> _function_3 = (EObject pointcut, List<EAttribute> features) -> {
      final Consumer<EAttribute> _function_4 = (EAttribute feature) -> {
        final List<INode> currentPointcutFeatures = NodeModelUtils.findNodesForFeature(pointcut, feature);
        boolean _isEmpty = currentPointcutFeatures.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final INode currentNode = currentPointcutFeatures.get(0);
          acceptor.addPosition(currentNode.getOffset(), currentNode.getLength(), 
            DefaultHighlightingConfiguration.DEFAULT_ID);
        }
      };
      features.forEach(_function_4);
    };
    modeledPointcutsWithHighlightingFeatures.forEach(_function_3);
  }
  
  /**
   * Provide highlighting for boolean values
   */
  private void provideHighlightingForBooleanConstants(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final Procedure1<EObject> _function = (EObject it) -> {
      boolean _and = false;
      if (!(it instanceof TechnologySpecificProperty)) {
        _and = false;
      } else {
        PrimitiveValue _defaultValue = ((TechnologySpecificProperty) it).getDefaultValue();
        Boolean _booleanValue = null;
        if (_defaultValue!=null) {
          _booleanValue=_defaultValue.getBooleanValue();
        }
        boolean _tripleNotEquals = (_booleanValue != null);
        _and = _tripleNotEquals;
      }
      final boolean booleanDefaultValue = _and;
      if (booleanDefaultValue) {
        final Consumer<INode> _function_1 = (INode it_1) -> {
          acceptor.addPosition(it_1.getOffset(), it_1.getLength(), 
            DefaultHighlightingConfiguration.KEYWORD_ID);
        };
        NodeModelUtils.findNodesForFeature(it, 
          TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE).forEach(_function_1);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
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
    if (eObject instanceof TechnologyAspect) {
      _matched=true;
      _switchResult = NodeModelUtils.findNodesForFeature(eObject, 
        TechnologyPackage.Literals.TECHNOLOGY_ASPECT__FEATURES);
    }
    if (!_matched) {
      _matched=true;
      if (!_matched) {
        if (eObject instanceof TechnologySpecificProperty) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = NodeModelUtils.findNodesForFeature(eObject, 
          TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES);
      }
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<INode>emptyList();
    }
    return _switchResult;
  }
}

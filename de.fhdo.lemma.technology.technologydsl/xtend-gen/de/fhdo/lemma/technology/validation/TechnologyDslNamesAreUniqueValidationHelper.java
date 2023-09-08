package de.fhdo.lemma.technology.validation;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.TechnologyAspect;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificProperty;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * Implementation of NamesAreUniqueValidationHelper to produce custom error messages for duplicated
 * names in a technology definition.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TechnologyDslNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {
  /**
   * Set cluster types explicitly
   */
  @Override
  public ImmutableSet<EClass> getClusterTypes() {
    return ImmutableSet.<EClass>of(
      TechnologyPackage.Literals.DEPLOYMENT_TECHNOLOGY, 
      TechnologyPackage.Literals.INFRASTRUCTURE_TECHNOLOGY);
  }

  /**
   * Hook to perform the actual duplication check for a certain concept
   */
  @Override
  public void checkDescriptionForDuplicatedName(final IEObjectDescription description, final Map<EClass, Map<QualifiedName, IEObjectDescription>> clusterTypeToName, final ValidationMessageAcceptor acceptor) {
    final EObject descriptionObject = description.getEObjectOrProxy();
    if (((((descriptionObject instanceof OperationEnvironment) || 
      (descriptionObject instanceof TechnologySpecificPropertyValueAssignment)) || 
      (descriptionObject instanceof TechnologySpecificProperty)) || 
      (descriptionObject instanceof TechnologyAspect))) {
      return;
    }
    super.checkDescriptionForDuplicatedName(description, clusterTypeToName, acceptor);
  }

  /**
   * Build a custom error message for duplicated names of certain technology model concepts
   */
  @Override
  public String getDuplicateNameErrorMessage(final IEObjectDescription description, final EClass clusterType, final EStructuralFeature feature) {
    final String duplicateName = description.getName().getLastSegment();
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(clusterType, TechnologyPackage.Literals.TECHNOLOGY_IMPORT)) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Duplicate import alias ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(duplicateName);
      _switchResult = (_builder.toString() + _builder_1);
    }
    if (!_matched) {
      if (Objects.equal(clusterType, DataPackage.Literals.TYPE)) {
        _matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Duplicate type ");
        _builder_2.append(duplicateName);
        _switchResult = _builder_2.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(clusterType, TechnologyPackage.Literals.PROTOCOL)) {
        _matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("Duplicate protocol ");
        _builder_3.append(duplicateName);
        _switchResult = _builder_3.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(clusterType, TechnologyPackage.Literals.DEPLOYMENT_TECHNOLOGY)) {
        _matched=true;
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("Duplicate deployment technology ");
        _builder_4.append(duplicateName);
        _switchResult = _builder_4.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(clusterType, TechnologyPackage.Literals.INFRASTRUCTURE_TECHNOLOGY)) {
        _matched=true;
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("Duplicate infrastructure technology ");
        _builder_5.append(duplicateName);
        _switchResult = _builder_5.toString();
      }
    }
    if (!_matched) {
      _switchResult = super.getDuplicateNameErrorMessage(description, clusterType, feature);
    }
    return _switchResult;
  }
}

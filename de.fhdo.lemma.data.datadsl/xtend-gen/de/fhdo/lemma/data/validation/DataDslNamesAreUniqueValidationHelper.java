package de.fhdo.lemma.data.validation;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.DataPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;

/**
 * Implementation of NamesAreUniqueValidationHelper to produce custom error messages for duplicated
 * names in a data model.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DataDslNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {
  /**
   * Build a custom error message for duplicated names of certain data model concepts
   */
  @Override
  public String getDuplicateNameErrorMessage(final IEObjectDescription description, final EClass clusterType, final EStructuralFeature feature) {
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(clusterType, DataPackage.Literals.VERSION)) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Duplicate version ");
      QualifiedName _name = description.getName();
      _builder.append(_name);
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (Objects.equal(clusterType, DataPackage.Literals.CONTEXT)) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Duplicate context ");
        QualifiedName _name_1 = description.getName();
        _builder_1.append(_name_1);
        _switchResult = _builder_1.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(clusterType, DataPackage.Literals.TYPE)) {
        _matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Duplicate type ");
        QualifiedName _name_2 = description.getName();
        _builder_2.append(_name_2);
        _switchResult = _builder_2.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(clusterType, DataPackage.Literals.DATA_FIELD)) {
        _matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("Duplicate data field ");
        QualifiedName _name_3 = description.getName();
        _builder_3.append(_name_3);
        _switchResult = _builder_3.toString();
      }
    }
    if (!_matched) {
      _switchResult = super.getDuplicateNameErrorMessage(description, clusterType, feature);
    }
    return _switchResult;
  }
}

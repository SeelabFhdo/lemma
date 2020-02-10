/**
 */
package de.fhdo.lemma.data.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.PrimitiveBoolean;
import de.fhdo.lemma.data.PrimitiveByte;
import de.fhdo.lemma.data.PrimitiveCharacter;
import de.fhdo.lemma.data.PrimitiveDate;
import de.fhdo.lemma.data.PrimitiveDouble;
import de.fhdo.lemma.data.PrimitiveFloat;
import de.fhdo.lemma.data.PrimitiveInteger;
import de.fhdo.lemma.data.PrimitiveLong;
import de.fhdo.lemma.data.PrimitiveShort;
import de.fhdo.lemma.data.PrimitiveString;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveTypeConstants;
import de.fhdo.lemma.data.PrimitiveUnspecified;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.PrimitiveTypeImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.PrimitiveTypeImpl#getTypeSize <em>Type Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PrimitiveTypeImpl extends TypeImpl implements PrimitiveType {
    /**
     * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeName()
     * @generated
     * @ordered
     */
    protected static final String TYPE_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getTypeSize() <em>Type Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeSize()
     * @generated
     * @ordered
     */
    protected static final Integer TYPE_SIZE_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PrimitiveTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.PRIMITIVE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTypeName() {
        String _switchResult = null;
        boolean _matched = false;
        if (this instanceof PrimitiveBoolean) {
            _matched=true;
            _switchResult = PrimitiveTypeConstants.BOOLEAN.getLiteral();
        }
        if (!_matched) {
            if (this instanceof PrimitiveByte) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.BYTE.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveCharacter) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.CHARACTER.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveDate) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.DATE.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveDouble) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.DOUBLE.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveFloat) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.FLOAT.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveInteger) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.INTEGER.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveLong) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.LONG.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveShort) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.SHORT.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveString) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.STRING.getLiteral();
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveUnspecified) {
                _matched=true;
                _switchResult = PrimitiveTypeConstants.UNSPECIFIED.getLiteral();
            }
        }
        if (!_matched) {
            _switchResult = null;
        }
        return _switchResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Integer getTypeSize() {
        Integer _switchResult = null;
        boolean _matched = false;
        if (this instanceof PrimitiveBoolean) {
            _matched=true;
            _switchResult = Integer.valueOf(PrimitiveTypeConstants.BOOLEAN.getValue());
        }
        if (!_matched) {
            if (this instanceof PrimitiveByte) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.BYTE.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveCharacter) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.CHARACTER.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveDate) {
                _matched=true;
                _switchResult = null;
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveDouble) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.DOUBLE.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveFloat) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.FLOAT.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveInteger) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.INTEGER.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveLong) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.LONG.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveShort) {
                _matched=true;
                _switchResult = Integer.valueOf(PrimitiveTypeConstants.SHORT.getValue());
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveUnspecified) {
                _matched=true;
                _switchResult = null;
            }
        }
        if (!_matched) {
            if (this instanceof PrimitiveString) {
                _matched=true;
                _switchResult = null;
            }
        }
        if (!_matched) {
            _switchResult = null;
        }
        return _switchResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int sizeCompare(final PrimitiveType typeToCompare) {
        if ((typeToCompare == null)) {
            return 1;
        }
        if (((this.getTypeName() != null) && Objects.equal(this.getTypeName(), typeToCompare.getTypeName()))) {
            return 0;
        }
        final Integer typeToCompareSize = typeToCompare.getTypeSize();
        Integer _typeSize = this.getTypeSize();
        boolean _tripleEquals = (_typeSize == null);
        if (_tripleEquals) {
            if ((typeToCompareSize == null)) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            if ((typeToCompareSize == null)) {
                return (-1);
            }
            else {
                Integer _typeSize_1 = this.getTypeSize();
                boolean _greaterThan = (_typeSize_1.compareTo(typeToCompareSize) > 0);
                if (_greaterThan) {
                    return 1;
                }
                else {
                    Integer _typeSize_2 = this.getTypeSize();
                    boolean _lessThan = (_typeSize_2.compareTo(typeToCompareSize) < 0);
                    if (_lessThan) {
                        return (-1);
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isCompatibleWith(final PrimitiveType typeToCheck) {
        if (((this instanceof PrimitiveUnspecified) || (typeToCheck instanceof PrimitiveUnspecified))) {
            return false;
        }
        if (((typeToCheck != null) && Objects.equal(typeToCheck.getTypeName(), this.getTypeName()))) {
            return true;
        }
        if ((typeToCheck instanceof PrimitiveByte)) {
            boolean _matched = false;
            if (this instanceof PrimitiveShort) {
                _matched=true;
            }
            if (!_matched) {
                if (this instanceof PrimitiveInteger) {
                    _matched=true;
                }
            }
            if (!_matched) {
                if (this instanceof PrimitiveLong) {
                    _matched=true;
                }
            }
            if (!_matched) {
                if (this instanceof PrimitiveFloat) {
                    _matched=true;
                }
            }
            if (!_matched) {
                if (this instanceof PrimitiveDouble) {
                    _matched=true;
                }
            }
            if (_matched) {
                return true;
            }
        }
        else {
            if ((typeToCheck instanceof PrimitiveShort)) {
                boolean _matched_1 = false;
                if (this instanceof PrimitiveInteger) {
                    _matched_1=true;
                }
                if (!_matched_1) {
                    if (this instanceof PrimitiveLong) {
                        _matched_1=true;
                    }
                }
                if (!_matched_1) {
                    if (this instanceof PrimitiveFloat) {
                        _matched_1=true;
                    }
                }
                if (!_matched_1) {
                    if (this instanceof PrimitiveDouble) {
                        _matched_1=true;
                    }
                }
                if (_matched_1) {
                    return true;
                }
            }
            else {
                if ((typeToCheck instanceof PrimitiveCharacter)) {
                    boolean _matched_2 = false;
                    if (this instanceof PrimitiveInteger) {
                        _matched_2=true;
                    }
                    if (!_matched_2) {
                        if (this instanceof PrimitiveLong) {
                            _matched_2=true;
                        }
                    }
                    if (!_matched_2) {
                        if (this instanceof PrimitiveFloat) {
                            _matched_2=true;
                        }
                    }
                    if (!_matched_2) {
                        if (this instanceof PrimitiveDouble) {
                            _matched_2=true;
                        }
                    }
                    if (!_matched_2) {
                        if (this instanceof PrimitiveString) {
                            _matched_2=true;
                        }
                    }
                    if (_matched_2) {
                        return true;
                    }
                }
                else {
                    if ((typeToCheck instanceof PrimitiveInteger)) {
                        boolean _matched_3 = false;
                        if (this instanceof PrimitiveLong) {
                            _matched_3=true;
                        }
                        if (!_matched_3) {
                            if (this instanceof PrimitiveFloat) {
                                _matched_3=true;
                            }
                        }
                        if (!_matched_3) {
                            if (this instanceof PrimitiveDouble) {
                                _matched_3=true;
                            }
                        }
                        if (_matched_3) {
                            return true;
                        }
                    }
                    else {
                        if ((typeToCheck instanceof PrimitiveLong)) {
                            boolean _matched_4 = false;
                            if (this instanceof PrimitiveFloat) {
                                _matched_4=true;
                            }
                            if (!_matched_4) {
                                if (this instanceof PrimitiveDouble) {
                                    _matched_4=true;
                                }
                            }
                            if (_matched_4) {
                                return true;
                            }
                        }
                        else {
                            if ((typeToCheck instanceof PrimitiveFloat)) {
                                boolean _matched_5 = false;
                                if (this instanceof PrimitiveDouble) {
                                    _matched_5=true;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Class<?>> getBuiltinPrimitiveTypes() {
        final ArrayList<Class<?>> primitiveTypes = CollectionLiterals.<Class<?>>newArrayList();
        primitiveTypes.add(PrimitiveBoolean.class);
        primitiveTypes.add(PrimitiveByte.class);
        primitiveTypes.add(PrimitiveCharacter.class);
        primitiveTypes.add(PrimitiveDate.class);
        primitiveTypes.add(PrimitiveDouble.class);
        primitiveTypes.add(PrimitiveFloat.class);
        primitiveTypes.add(PrimitiveInteger.class);
        primitiveTypes.add(PrimitiveLong.class);
        primitiveTypes.add(PrimitiveShort.class);
        primitiveTypes.add(PrimitiveString.class);
        primitiveTypes.add(PrimitiveUnspecified.class);
        return ECollections.<Class<?>>asEList(primitiveTypes);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DataPackage.PRIMITIVE_TYPE__TYPE_NAME:
                return getTypeName();
            case DataPackage.PRIMITIVE_TYPE__TYPE_SIZE:
                return getTypeSize();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case DataPackage.PRIMITIVE_TYPE__TYPE_NAME:
                return TYPE_NAME_EDEFAULT == null ? getTypeName() != null : !TYPE_NAME_EDEFAULT.equals(getTypeName());
            case DataPackage.PRIMITIVE_TYPE__TYPE_SIZE:
                return TYPE_SIZE_EDEFAULT == null ? getTypeSize() != null : !TYPE_SIZE_EDEFAULT.equals(getTypeSize());
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case DataPackage.PRIMITIVE_TYPE___SIZE_COMPARE__PRIMITIVETYPE:
                return sizeCompare((PrimitiveType)arguments.get(0));
            case DataPackage.PRIMITIVE_TYPE___IS_COMPATIBLE_WITH__PRIMITIVETYPE:
                return isCompatibleWith((PrimitiveType)arguments.get(0));
            case DataPackage.PRIMITIVE_TYPE___GET_BUILTIN_PRIMITIVE_TYPES:
                return getBuiltinPrimitiveTypes();
        }
        return super.eInvoke(operationID, arguments);
    }

} //PrimitiveTypeImpl

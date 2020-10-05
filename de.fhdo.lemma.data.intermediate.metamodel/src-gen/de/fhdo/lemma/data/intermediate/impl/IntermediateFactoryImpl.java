/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntermediateFactoryImpl extends EFactoryImpl implements IntermediateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IntermediateFactory init() {
		try {
			IntermediateFactory theIntermediateFactory = (IntermediateFactory)EPackage.Registry.INSTANCE.getEFactory(IntermediatePackage.eNS_URI);
			if (theIntermediateFactory != null) {
				return theIntermediateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IntermediateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IntermediatePackage.INTERMEDIATE_DATA_MODEL: return createIntermediateDataModel();
			case IntermediatePackage.INTERMEDIATE_IMPORT: return createIntermediateImport();
			case IntermediatePackage.INTERMEDIATE_VERSION: return createIntermediateVersion();
			case IntermediatePackage.INTERMEDIATE_CONTEXT: return createIntermediateContext();
			case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE: return createIntermediatePrimitiveType();
			case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE: return createIntermediateComplexType();
			case IntermediatePackage.INTERMEDIATE_IMPORTED_COMPLEX_TYPE: return createIntermediateImportedComplexType();
			case IntermediatePackage.INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE: return createIntermediateImportedTechnologySpecificType();
			case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE: return createIntermediateDataStructure();
			case IntermediatePackage.INTERMEDIATE_DATA_OPERATION: return createIntermediateDataOperation();
			case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE: return createIntermediateDataOperationReturnType();
			case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER: return createIntermediateDataOperationParameter();
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE: return createIntermediateListType();
			case IntermediatePackage.INTERMEDIATE_DATA_FIELD: return createIntermediateDataField();
			case IntermediatePackage.INTERMEDIATE_ENUMERATION: return createIntermediateEnumeration();
			case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD: return createIntermediateEnumerationField();
			case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT: return createIntermediateImportedAspect();
			case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY: return createIntermediateAspectProperty();
			case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE: return createIntermediateAspectPropertyValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case IntermediatePackage.INTERMEDIATE_TYPE_KIND:
				return createIntermediateTypeKindFromString(eDataType, initialValue);
			case IntermediatePackage.INTERMEDIATE_TYPE_ORIGIN:
				return createIntermediateTypeOriginFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case IntermediatePackage.INTERMEDIATE_TYPE_KIND:
				return convertIntermediateTypeKindToString(eDataType, instanceValue);
			case IntermediatePackage.INTERMEDIATE_TYPE_ORIGIN:
				return convertIntermediateTypeOriginToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDataModel createIntermediateDataModel() {
		IntermediateDataModelImpl intermediateDataModel = new IntermediateDataModelImpl();
		return intermediateDataModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateImport createIntermediateImport() {
		IntermediateImportImpl intermediateImport = new IntermediateImportImpl();
		return intermediateImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateVersion createIntermediateVersion() {
		IntermediateVersionImpl intermediateVersion = new IntermediateVersionImpl();
		return intermediateVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateContext createIntermediateContext() {
		IntermediateContextImpl intermediateContext = new IntermediateContextImpl();
		return intermediateContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediatePrimitiveType createIntermediatePrimitiveType() {
		IntermediatePrimitiveTypeImpl intermediatePrimitiveType = new IntermediatePrimitiveTypeImpl();
		return intermediatePrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateComplexType createIntermediateComplexType() {
		IntermediateComplexTypeImpl intermediateComplexType = new IntermediateComplexTypeImpl();
		return intermediateComplexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateImportedComplexType createIntermediateImportedComplexType() {
		IntermediateImportedComplexTypeImpl intermediateImportedComplexType = new IntermediateImportedComplexTypeImpl();
		return intermediateImportedComplexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateImportedTechnologySpecificType createIntermediateImportedTechnologySpecificType() {
		IntermediateImportedTechnologySpecificTypeImpl intermediateImportedTechnologySpecificType = new IntermediateImportedTechnologySpecificTypeImpl();
		return intermediateImportedTechnologySpecificType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDataStructure createIntermediateDataStructure() {
		IntermediateDataStructureImpl intermediateDataStructure = new IntermediateDataStructureImpl();
		return intermediateDataStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDataOperation createIntermediateDataOperation() {
		IntermediateDataOperationImpl intermediateDataOperation = new IntermediateDataOperationImpl();
		return intermediateDataOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDataOperationReturnType createIntermediateDataOperationReturnType() {
		IntermediateDataOperationReturnTypeImpl intermediateDataOperationReturnType = new IntermediateDataOperationReturnTypeImpl();
		return intermediateDataOperationReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDataOperationParameter createIntermediateDataOperationParameter() {
		IntermediateDataOperationParameterImpl intermediateDataOperationParameter = new IntermediateDataOperationParameterImpl();
		return intermediateDataOperationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateListType createIntermediateListType() {
		IntermediateListTypeImpl intermediateListType = new IntermediateListTypeImpl();
		return intermediateListType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDataField createIntermediateDataField() {
		IntermediateDataFieldImpl intermediateDataField = new IntermediateDataFieldImpl();
		return intermediateDataField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateEnumeration createIntermediateEnumeration() {
		IntermediateEnumerationImpl intermediateEnumeration = new IntermediateEnumerationImpl();
		return intermediateEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateEnumerationField createIntermediateEnumerationField() {
		IntermediateEnumerationFieldImpl intermediateEnumerationField = new IntermediateEnumerationFieldImpl();
		return intermediateEnumerationField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateImportedAspect createIntermediateImportedAspect() {
		IntermediateImportedAspectImpl intermediateImportedAspect = new IntermediateImportedAspectImpl();
		return intermediateImportedAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateAspectProperty createIntermediateAspectProperty() {
		IntermediateAspectPropertyImpl intermediateAspectProperty = new IntermediateAspectPropertyImpl();
		return intermediateAspectProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateAspectPropertyValue createIntermediateAspectPropertyValue() {
		IntermediateAspectPropertyValueImpl intermediateAspectPropertyValue = new IntermediateAspectPropertyValueImpl();
		return intermediateAspectPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateTypeKind createIntermediateTypeKindFromString(EDataType eDataType, String initialValue) {
		IntermediateTypeKind result = IntermediateTypeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntermediateTypeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateTypeOrigin createIntermediateTypeOriginFromString(EDataType eDataType, String initialValue) {
		IntermediateTypeOrigin result = IntermediateTypeOrigin.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntermediateTypeOriginToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediatePackage getIntermediatePackage() {
		return (IntermediatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IntermediatePackage getPackage() {
		return IntermediatePackage.eINSTANCE;
	}

} //IntermediateFactoryImpl

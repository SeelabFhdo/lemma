/**
 */
package de.fhdo.lemma.data.util;

import de.fhdo.lemma.data.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.data.DataPackage
 * @generated
 */
public class DataAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DataPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = DataPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataSwitch<Adapter> modelSwitch =
        new DataSwitch<Adapter>() {
            @Override
            public Adapter caseDataModel(DataModel object) {
                return createDataModelAdapter();
            }
            @Override
            public Adapter caseComplexTypeImport(ComplexTypeImport object) {
                return createComplexTypeImportAdapter();
            }
            @Override
            public Adapter caseVersion(Version object) {
                return createVersionAdapter();
            }
            @Override
            public Adapter caseContext(Context object) {
                return createContextAdapter();
            }
            @Override
            public Adapter caseType(Type object) {
                return createTypeAdapter();
            }
            @Override
            public Adapter casePrimitiveType(PrimitiveType object) {
                return createPrimitiveTypeAdapter();
            }
            @Override
            public Adapter casePrimitiveBoolean(PrimitiveBoolean object) {
                return createPrimitiveBooleanAdapter();
            }
            @Override
            public Adapter casePrimitiveByte(PrimitiveByte object) {
                return createPrimitiveByteAdapter();
            }
            @Override
            public Adapter casePrimitiveCharacter(PrimitiveCharacter object) {
                return createPrimitiveCharacterAdapter();
            }
            @Override
            public Adapter casePrimitiveDate(PrimitiveDate object) {
                return createPrimitiveDateAdapter();
            }
            @Override
            public Adapter casePrimitiveDouble(PrimitiveDouble object) {
                return createPrimitiveDoubleAdapter();
            }
            @Override
            public Adapter casePrimitiveFloat(PrimitiveFloat object) {
                return createPrimitiveFloatAdapter();
            }
            @Override
            public Adapter casePrimitiveInteger(PrimitiveInteger object) {
                return createPrimitiveIntegerAdapter();
            }
            @Override
            public Adapter casePrimitiveLong(PrimitiveLong object) {
                return createPrimitiveLongAdapter();
            }
            @Override
            public Adapter casePrimitiveShort(PrimitiveShort object) {
                return createPrimitiveShortAdapter();
            }
            @Override
            public Adapter casePrimitiveString(PrimitiveString object) {
                return createPrimitiveStringAdapter();
            }
            @Override
            public Adapter casePrimitiveUnspecified(PrimitiveUnspecified object) {
                return createPrimitiveUnspecifiedAdapter();
            }
            @Override
            public Adapter caseComplexType(ComplexType object) {
                return createComplexTypeAdapter();
            }
            @Override
            public Adapter caseImportedComplexType(ImportedComplexType object) {
                return createImportedComplexTypeAdapter();
            }
            @Override
            public Adapter caseDataStructure(DataStructure object) {
                return createDataStructureAdapter();
            }
            @Override
            public Adapter caseDataOperation(DataOperation object) {
                return createDataOperationAdapter();
            }
            @Override
            public Adapter caseDataOperationParameter(DataOperationParameter object) {
                return createDataOperationParameterAdapter();
            }
            @Override
            public Adapter caseCollectionType(CollectionType object) {
                return createCollectionTypeAdapter();
            }
            @Override
            public Adapter caseDataField(DataField object) {
                return createDataFieldAdapter();
            }
            @Override
            public Adapter caseEnumeration(Enumeration object) {
                return createEnumerationAdapter();
            }
            @Override
            public Adapter caseEnumerationField(EnumerationField object) {
                return createEnumerationFieldAdapter();
            }
            @Override
            public Adapter casePrimitiveValue(PrimitiveValue object) {
                return createPrimitiveValueAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.DataModel <em>Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.DataModel
     * @generated
     */
    public Adapter createDataModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.ComplexTypeImport <em>Complex Type Import</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.ComplexTypeImport
     * @generated
     */
    public Adapter createComplexTypeImportAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.Version <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.Version
     * @generated
     */
    public Adapter createVersionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.Context
     * @generated
     */
    public Adapter createContextAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.Type
     * @generated
     */
    public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveType
     * @generated
     */
    public Adapter createPrimitiveTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveBoolean <em>Primitive Boolean</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveBoolean
     * @generated
     */
    public Adapter createPrimitiveBooleanAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveByte <em>Primitive Byte</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveByte
     * @generated
     */
    public Adapter createPrimitiveByteAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveCharacter <em>Primitive Character</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveCharacter
     * @generated
     */
    public Adapter createPrimitiveCharacterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveDate <em>Primitive Date</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveDate
     * @generated
     */
    public Adapter createPrimitiveDateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveDouble <em>Primitive Double</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveDouble
     * @generated
     */
    public Adapter createPrimitiveDoubleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveFloat <em>Primitive Float</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveFloat
     * @generated
     */
    public Adapter createPrimitiveFloatAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveInteger <em>Primitive Integer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveInteger
     * @generated
     */
    public Adapter createPrimitiveIntegerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveLong <em>Primitive Long</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveLong
     * @generated
     */
    public Adapter createPrimitiveLongAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveShort <em>Primitive Short</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveShort
     * @generated
     */
    public Adapter createPrimitiveShortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveString <em>Primitive String</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveString
     * @generated
     */
    public Adapter createPrimitiveStringAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveUnspecified <em>Primitive Unspecified</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveUnspecified
     * @generated
     */
    public Adapter createPrimitiveUnspecifiedAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.ComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.ComplexType
     * @generated
     */
    public Adapter createComplexTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.ImportedComplexType <em>Imported Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.ImportedComplexType
     * @generated
     */
    public Adapter createImportedComplexTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.DataStructure <em>Structure</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.DataStructure
     * @generated
     */
    public Adapter createDataStructureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.DataOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.DataOperation
     * @generated
     */
    public Adapter createDataOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.DataOperationParameter <em>Operation Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.DataOperationParameter
     * @generated
     */
    public Adapter createDataOperationParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.CollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.CollectionType
     * @generated
     */
    public Adapter createCollectionTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.DataField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.DataField
     * @generated
     */
    public Adapter createDataFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.Enumeration <em>Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.Enumeration
     * @generated
     */
    public Adapter createEnumerationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.EnumerationField <em>Enumeration Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.EnumerationField
     * @generated
     */
    public Adapter createEnumerationFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.data.PrimitiveValue <em>Primitive Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.data.PrimitiveValue
     * @generated
     */
    public Adapter createPrimitiveValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //DataAdapterFactory

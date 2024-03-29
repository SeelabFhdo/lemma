/*
 * generated by Xtext 2.26.0
 */
package de.fhdo.lemma.serializer;

import com.google.inject.Inject;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.ImportedComplexType;
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
import de.fhdo.lemma.data.PrimitiveUnspecified;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.data.Version;
import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.ApiParameterComment;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.PossiblyImportedInterface;
import de.fhdo.lemma.service.PossiblyImportedMicroservice;
import de.fhdo.lemma.service.PossiblyImportedOperation;
import de.fhdo.lemma.service.ProtocolSpecification;
import de.fhdo.lemma.service.ReferredOperation;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.services.ServiceDslGrammarAccess;
import de.fhdo.lemma.technology.CompatibilityMatrixEntry;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.DeploymentTechnology;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.OperationAspectPointcut;
import de.fhdo.lemma.technology.OperationAspectPointcutSelector;
import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.ServiceAspectPointcut;
import de.fhdo.lemma.technology.ServiceAspectPointcutSelector;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyImport;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificCollectionType;
import de.fhdo.lemma.technology.TechnologySpecificDataStructure;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;
import de.fhdo.lemma.technology.TechnologySpecificProperty;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;
import de.fhdo.lemma.technology.serializer.TechnologyDslSemanticSequencer;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ServiceDslSemanticSequencer extends TechnologyDslSemanticSequencer {

    @Inject
    private ServiceDslGrammarAccess grammarAccess;

    @Override
    public void sequence(ISerializationContext context, EObject semanticObject) {
        EPackage epackage = semanticObject.eClass().getEPackage();
        ParserRule rule = context.getParserRule();
        Action action = context.getAssignedAction();
        Set<Parameter> parameters = context.getEnabledBooleanParameters();
        if (epackage == DataPackage.eINSTANCE)
            switch (semanticObject.eClass().getClassifierID()) {
            case DataPackage.COLLECTION_TYPE:
                sequence_CollectionType(context, (CollectionType) semanticObject);
                return;
            case DataPackage.COMPLEX_TYPE_IMPORT:
                sequence_ComplexTypeImport(context, (ComplexTypeImport) semanticObject);
                return;
            case DataPackage.CONTEXT:
                sequence_Context(context, (Context) semanticObject);
                return;
            case DataPackage.DATA_FIELD:
                sequence_DataField(context, (DataField) semanticObject);
                return;
            case DataPackage.DATA_MODEL:
                sequence_DataModel(context, (DataModel) semanticObject);
                return;
            case DataPackage.DATA_OPERATION:
                sequence_DataOperation(context, (DataOperation) semanticObject);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER:
                sequence_DataOperationParameter(context, (DataOperationParameter) semanticObject);
                return;
            case DataPackage.DATA_STRUCTURE:
                sequence_DataStructure(context, (DataStructure) semanticObject);
                return;
            case DataPackage.ENUMERATION:
                sequence_Enumeration(context, (Enumeration) semanticObject);
                return;
            case DataPackage.ENUMERATION_FIELD:
                sequence_EnumerationField(context, (EnumerationField) semanticObject);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE:
                sequence_ImportedComplexType(context, (ImportedComplexType) semanticObject);
                return;
            case DataPackage.PRIMITIVE_BOOLEAN:
                sequence_PrimitiveType(context, (PrimitiveBoolean) semanticObject);
                return;
            case DataPackage.PRIMITIVE_BYTE:
                sequence_PrimitiveType(context, (PrimitiveByte) semanticObject);
                return;
            case DataPackage.PRIMITIVE_CHARACTER:
                sequence_PrimitiveType(context, (PrimitiveCharacter) semanticObject);
                return;
            case DataPackage.PRIMITIVE_DATE:
                sequence_PrimitiveType(context, (PrimitiveDate) semanticObject);
                return;
            case DataPackage.PRIMITIVE_DOUBLE:
                sequence_PrimitiveType(context, (PrimitiveDouble) semanticObject);
                return;
            case DataPackage.PRIMITIVE_FLOAT:
                sequence_PrimitiveType(context, (PrimitiveFloat) semanticObject);
                return;
            case DataPackage.PRIMITIVE_INTEGER:
                sequence_PrimitiveType(context, (PrimitiveInteger) semanticObject);
                return;
            case DataPackage.PRIMITIVE_LONG:
                sequence_PrimitiveType(context, (PrimitiveLong) semanticObject);
                return;
            case DataPackage.PRIMITIVE_SHORT:
                sequence_PrimitiveType(context, (PrimitiveShort) semanticObject);
                return;
            case DataPackage.PRIMITIVE_STRING:
                sequence_PrimitiveType(context, (PrimitiveString) semanticObject);
                return;
            case DataPackage.PRIMITIVE_UNSPECIFIED:
                sequence_PrimitiveType(context, (PrimitiveUnspecified) semanticObject);
                return;
            case DataPackage.PRIMITIVE_VALUE:
                sequence_PrimitiveValue(context, (PrimitiveValue) semanticObject);
                return;
            case DataPackage.VERSION:
                sequence_Version(context, (Version) semanticObject);
                return;
            }
        else if (epackage == ServicePackage.eINSTANCE)
            switch (semanticObject.eClass().getClassifierID()) {
            case ServicePackage.API_OPERATION_COMMENT:
                sequence_ApiOperationComment(context, (ApiOperationComment) semanticObject);
                return;
            case ServicePackage.API_PARAMETER_COMMENT:
                sequence_ApiParameterComment(context, (ApiParameterComment) semanticObject);
                return;
            case ServicePackage.ENDPOINT:
                sequence_Endpoint(context, (Endpoint) semanticObject);
                return;
            case ServicePackage.IMPORT:
                sequence_Import(context, (Import) semanticObject);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT:
                sequence_ImportedProtocolAndDataFormat(context, (ImportedProtocolAndDataFormat) semanticObject);
                return;
            case ServicePackage.IMPORTED_SERVICE_ASPECT:
                sequence_ImportedServiceAspect(context, (ImportedServiceAspect) semanticObject);
                return;
            case ServicePackage.IMPORTED_TYPE:
                sequence_ImportedType(context, (ImportedType) semanticObject);
                return;
            case ServicePackage.INTERFACE:
                sequence_Interface(context, (Interface) semanticObject);
                return;
            case ServicePackage.MICROSERVICE:
                sequence_Microservice(context, (Microservice) semanticObject);
                return;
            case ServicePackage.OPERATION:
                sequence_Operation(context, (Operation) semanticObject);
                return;
            case ServicePackage.PARAMETER:
                sequence_Parameter(context, (de.fhdo.lemma.service.Parameter) semanticObject);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_INTERFACE:
                sequence_PossiblyImportedInterface(context, (PossiblyImportedInterface) semanticObject);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE:
                sequence_PossiblyImportedMicroservice(context, (PossiblyImportedMicroservice) semanticObject);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_OPERATION:
                sequence_PossiblyImportedOperation(context, (PossiblyImportedOperation) semanticObject);
                return;
            case ServicePackage.PROTOCOL_SPECIFICATION:
                sequence_ProtocolSpecification(context, (ProtocolSpecification) semanticObject);
                return;
            case ServicePackage.REFERRED_OPERATION:
                sequence_ReferredOperation(context, (ReferredOperation) semanticObject);
                return;
            case ServicePackage.SERVICE_MODEL:
                sequence_ServiceModel(context, (ServiceModel) semanticObject);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE:
                sequence_TechnologyReference(context, (TechnologyReference) semanticObject);
                return;
            }
        else if (epackage == TechnologyPackage.eINSTANCE)
            switch (semanticObject.eClass().getClassifierID()) {
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY:
                sequence_CompatibilityMatrixEntry(context, (CompatibilityMatrixEntry) semanticObject);
                return;
            case TechnologyPackage.DATA_FORMAT:
                sequence_DataFormat(context, (DataFormat) semanticObject);
                return;
            case TechnologyPackage.DEPLOYMENT_TECHNOLOGY:
                sequence_DeploymentTechnology(context, (DeploymentTechnology) semanticObject);
                return;
            case TechnologyPackage.INFRASTRUCTURE_TECHNOLOGY:
                sequence_InfrastructureTechnology(context, (InfrastructureTechnology) semanticObject);
                return;
            case TechnologyPackage.OPERATION_ASPECT:
                sequence_OperationAspect(context, (OperationAspect) semanticObject);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT:
                sequence_OperationAspectPointcut(context, (OperationAspectPointcut) semanticObject);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR:
                sequence_OperationAspectPointcutSelector(context, (OperationAspectPointcutSelector) semanticObject);
                return;
            case TechnologyPackage.OPERATION_ENVIRONMENT:
                sequence_OperationEnvironment(context, (OperationEnvironment) semanticObject);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE:
                sequence_PossiblyImportedTechnologySpecificType(context, (PossiblyImportedTechnologySpecificType) semanticObject);
                return;
            case TechnologyPackage.PROTOCOL:
                sequence_Protocol(context, (Protocol) semanticObject);
                return;
            case TechnologyPackage.SERVICE_ASPECT:
                sequence_ServiceAspect(context, (ServiceAspect) semanticObject);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT:
                sequence_ServiceAspectPointcut(context, (ServiceAspectPointcut) semanticObject);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR:
                sequence_ServiceAspectPointcutSelector(context, (ServiceAspectPointcutSelector) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY:
                sequence_Technology(context, (Technology) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY_IMPORT:
                sequence_TechnologyImport(context, (TechnologyImport) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_COLLECTION_TYPE:
                sequence_TechnologySpecificCollectionType(context, (TechnologySpecificCollectionType) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_DATA_STRUCTURE:
                sequence_TechnologySpecificDataStructure(context, (TechnologySpecificDataStructure) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE:
                sequence_TechnologySpecificPrimitiveType(context, (TechnologySpecificPrimitiveType) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY:
                sequence_TechnologySpecificProperty(context, (TechnologySpecificProperty) semanticObject);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT:
                sequence_PropertyValueAssignment(context, (TechnologySpecificPropertyValueAssignment) semanticObject);
                return;
            }
        if (errorAcceptor != null)
            errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
    }

    /**
     * <pre>
     * Contexts:
     *     ApiOperationComment returns ApiOperationComment
     *
     * Constraint:
     *     (comment=Anything parameterComments+=ApiParameterComment*)
     * </pre>
     */
    protected void sequence_ApiOperationComment(ISerializationContext context, ApiOperationComment semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ApiParameterComment returns ApiParameterComment
     *
     * Constraint:
     *     ((required?='@required' | required?='@requires' | returned?='@returned' | returned?='@returns')? parameter=[Parameter|ID] comment=Anything)
     * </pre>
     */
    protected void sequence_ApiParameterComment(ISerializationContext context, ApiParameterComment semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     Endpoint returns Endpoint
     *
     * Constraint:
     *     (protocols+=ImportedProtocolAndDataFormat protocols+=ImportedProtocolAndDataFormat* addresses+=STRING addresses+=STRING*)
     * </pre>
     */
    protected void sequence_Endpoint(ISerializationContext context, Endpoint semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     Import returns Import
     *
     * Constraint:
     *     (importType=ImportType importURI=STRING name=ID)
     * </pre>
     */
    protected void sequence_Import(ISerializationContext context, Import semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.IMPORT__IMPORT_TYPE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.IMPORT__IMPORT_TYPE));
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.IMPORT__IMPORT_URI) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.IMPORT__IMPORT_URI));
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.IMPORT__NAME) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.IMPORT__NAME));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0(), semanticObject.getImportType());
        feeder.accept(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_3_0(), semanticObject.getImportURI());
        feeder.accept(grammarAccess.getImportAccess().getNameIDTerminalRuleCall_5_0(), semanticObject.getName());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ImportedProtocolAndDataFormat returns ImportedProtocolAndDataFormat
     *
     * Constraint:
     *     (import=[Import|ID] importedProtocol=[Protocol|QualifiedName] dataFormat=[DataFormat|STRING]?)
     * </pre>
     */
    protected void sequence_ImportedProtocolAndDataFormat(ISerializationContext context, ImportedProtocolAndDataFormat semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ImportedServiceAspect returns ImportedServiceAspect
     *
     * Constraint:
     *     (
     *         import=[Import|ID]
     *         importedAspect=[ServiceAspect|QualifiedName]
     *         (singlePropertyValue=PrimitiveValue | (values+=PropertyValueAssignment values+=PropertyValueAssignment*))?
     *     )
     * </pre>
     */
    protected void sequence_ImportedServiceAspect(ISerializationContext context, ImportedServiceAspect semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ImportedType returns ImportedType
     *
     * Constraint:
     *     (import=[Import|ID] type=[Type|QualifiedName])
     * </pre>
     */
    protected void sequence_ImportedType(ISerializationContext context, ImportedType semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.IMPORTED_TYPE__IMPORT) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.IMPORTED_TYPE__IMPORT));
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.IMPORTED_TYPE__TYPE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.IMPORTED_TYPE__TYPE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getImportedTypeAccess().getImportImportIDTerminalRuleCall_0_0_1(), semanticObject.eGet(ServicePackage.Literals.IMPORTED_TYPE__IMPORT, false));
        feeder.accept(grammarAccess.getImportedTypeAccess().getTypeTypeQualifiedNameParserRuleCall_2_0_1(), semanticObject.eGet(ServicePackage.Literals.IMPORTED_TYPE__TYPE, false));
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     Interface returns Interface
     *
     * Constraint:
     *     (
     *         (protocols+=ProtocolSpecification protocols+=ProtocolSpecification?)?
     *         endpoints+=Endpoint*
     *         endpoints+=Endpoint*
     *         aspects+=ImportedServiceAspect*
     *         notImplemented?='noimpl'?
     *         visibility=Visibility?
     *         name=ID
     *         version=ID?
     *         referredOperations+=ReferredOperation*
     *         operations+=Operation*
     *     )
     * </pre>
     */
    protected void sequence_Interface(ISerializationContext context, Interface semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     Microservice returns Microservice
     *
     * Constraint:
     *     (
     *         technologyReferences+=TechnologyReference*
     *         (protocols+=ProtocolSpecification protocols+=ProtocolSpecification?)?
     *         endpoints+=Endpoint*
     *         endpoints+=Endpoint*
     *         aspects+=ImportedServiceAspect*
     *         visibility=Visibility?
     *         type=MicroserviceType
     *         name=QualifiedNameWithAtLeastOneLevel
     *         version=ID?
     *         (requiredMicroservices+=PossiblyImportedMicroservice requiredMicroservices+=PossiblyImportedMicroservice*)?
     *         (requiredInterfaces+=PossiblyImportedInterface requiredInterfaces+=PossiblyImportedInterface*)?
     *         (requiredOperations+=PossiblyImportedOperation requiredOperations+=PossiblyImportedOperation*)?
     *         interfaces+=Interface+
     *     )
     * </pre>
     */
    protected void sequence_Microservice(ISerializationContext context, Microservice semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     Operation returns Operation
     *
     * Constraint:
     *     (
     *         apiOperationComment=ApiOperationComment?
     *         (protocols+=ProtocolSpecification protocols+=ProtocolSpecification?)?
     *         endpoints+=Endpoint*
     *         endpoints+=Endpoint*
     *         aspects+=ImportedServiceAspect*
     *         notImplemented?='noimpl'?
     *         visibility=Visibility?
     *         name=ID
     *         parameters+=Parameter?
     *         parameters+=Parameter*
     *     )
     * </pre>
     */
    protected void sequence_Operation(ISerializationContext context, Operation semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     Parameter returns Parameter
     *
     * Constraint:
     *     (
     *         aspects+=ImportedServiceAspect*
     *         communicationType=CommunicationType
     *         exchangePattern=ExchangePattern?
     *         communicatesFault?='fault'?
     *         name=ID
     *         optional?='?'?
     *         (primitiveType=PrimitiveType | importedType=ImportedType)
     *         initializedByOperation=PossiblyImportedOperation?
     *     )
     * </pre>
     */
    protected void sequence_Parameter(ISerializationContext context, de.fhdo.lemma.service.Parameter semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     PossiblyImportedInterface returns PossiblyImportedInterface
     *
     * Constraint:
     *     (import=[Import|ID]? interface=[Interface|QualifiedName])
     * </pre>
     */
    protected void sequence_PossiblyImportedInterface(ISerializationContext context, PossiblyImportedInterface semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     PossiblyImportedMicroservice returns PossiblyImportedMicroservice
     *
     * Constraint:
     *     (import=[Import|ID]? microservice=[Microservice|QualifiedName])
     * </pre>
     */
    protected void sequence_PossiblyImportedMicroservice(ISerializationContext context, PossiblyImportedMicroservice semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     PossiblyImportedOperation returns PossiblyImportedOperation
     *
     * Constraint:
     *     (import=[Import|ID]? operation=[Operation|QualifiedName])
     * </pre>
     */
    protected void sequence_PossiblyImportedOperation(ISerializationContext context, PossiblyImportedOperation semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     PropertyValueAssignment returns TechnologySpecificPropertyValueAssignment
     *
     * Constraint:
     *     ((property=[TechnologySpecificProperty|ID] value=PrimitiveValue) | (property=[TechnologySpecificProperty|ID] value=PrimitiveValue))
     * </pre>
     */
    protected void sequence_PropertyValueAssignment(ISerializationContext context, TechnologySpecificPropertyValueAssignment semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ProtocolSpecification returns ProtocolSpecification
     *
     * Constraint:
     *     (communicationType=CommunicationType protocol=ImportedProtocolAndDataFormat)
     * </pre>
     */
    protected void sequence_ProtocolSpecification(ISerializationContext context, ProtocolSpecification semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE));
            if (transientValues.isValueTransient(semanticObject, ServicePackage.Literals.PROTOCOL_SPECIFICATION__PROTOCOL) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ServicePackage.Literals.PROTOCOL_SPECIFICATION__PROTOCOL));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0(), semanticObject.getCommunicationType());
        feeder.accept(grammarAccess.getProtocolSpecificationAccess().getProtocolImportedProtocolAndDataFormatParserRuleCall_3_0(), semanticObject.getProtocol());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ReferredOperation returns ReferredOperation
     *
     * Constraint:
     *     (
     *         (protocols+=ProtocolSpecification protocols+=ProtocolSpecification?)?
     *         endpoints+=Endpoint*
     *         endpoints+=Endpoint*
     *         aspects+=ImportedServiceAspect*
     *         operation=[Operation|QualifiedName]
     *     )
     * </pre>
     */
    protected void sequence_ReferredOperation(ISerializationContext context, ReferredOperation semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ServiceModel returns ServiceModel
     *
     * Constraint:
     *     (imports+=Import* microservices+=Microservice+)
     * </pre>
     */
    protected void sequence_ServiceModel(ISerializationContext context, ServiceModel semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     TechnologyReference returns TechnologyReference
     *
     * Constraint:
     *     (technology=[Import|ID] isTypeDefinitionTechnology=BOOLEAN?)
     * </pre>
     */
    protected void sequence_TechnologyReference(ISerializationContext context, TechnologyReference semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


}

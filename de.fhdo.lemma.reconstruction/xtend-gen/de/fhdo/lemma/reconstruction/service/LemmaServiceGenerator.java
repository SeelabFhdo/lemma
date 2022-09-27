package de.fhdo.lemma.reconstruction.service;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.ListType;
import de.fhdo.lemma.reconstruction.domain.ClassType;
import de.fhdo.lemma.reconstruction.domain.ComplexType;
import de.fhdo.lemma.reconstruction.domain.PrimitiveType;
import de.fhdo.lemma.reconstruction.util.Util;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.ServiceFactory;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.Visibility;
import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.ExchangePattern;
import java.io.File;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class LemmaServiceGenerator {
  private static final ServiceFactory SERVICE_FACTORY = ServiceFactory.eINSTANCE;
  
  private static final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  private final ServiceModel model = LemmaServiceGenerator.SERVICE_FACTORY.createServiceModel();
  
  public ServiceModel generateModelFrom(final Microservice reconstructedMicroservice) {
    final de.fhdo.lemma.service.Microservice microservice = this.generateMicroserviceFrom(reconstructedMicroservice);
    this.model.getMicroservices().add(microservice);
    return this.model;
  }
  
  private de.fhdo.lemma.service.Microservice generateMicroserviceFrom(final Microservice reconstructedMicroservice) {
    final de.fhdo.lemma.service.Microservice microservice = LemmaServiceGenerator.SERVICE_FACTORY.createMicroservice();
    microservice.setName(reconstructedMicroservice.getName());
    microservice.setVersion(reconstructedMicroservice.getVersion());
    microservice.setVisibility(this.deriveLemmaVisibility(reconstructedMicroservice.getVisibility()));
    microservice.setType(this.deriveMicroserviceType(reconstructedMicroservice.getType()));
    final Consumer<Interface> _function = (Interface it) -> {
      microservice.getInterfaces().add(this.generateInterfaceFrom(it));
    };
    reconstructedMicroservice.getInterfaces().forEach(_function);
    return microservice;
  }
  
  private MicroserviceType deriveMicroserviceType(final String type) {
    MicroserviceType _switchResult = null;
    String _lowerCase = type.toLowerCase();
    if (_lowerCase != null) {
      switch (_lowerCase) {
        case "functional":
          _switchResult = MicroserviceType.FUNCTIONAL;
          break;
        case "utility":
          _switchResult = MicroserviceType.UTILITY;
          break;
        case "infrastructure":
          _switchResult = MicroserviceType.INFRASTRUCTURE;
          break;
        default:
          _switchResult = MicroserviceType.FUNCTIONAL;
          break;
      }
    } else {
      _switchResult = MicroserviceType.FUNCTIONAL;
    }
    return _switchResult;
  }
  
  private de.fhdo.lemma.service.Interface generateInterfaceFrom(final Interface generatedInterface) {
    final de.fhdo.lemma.service.Interface interfaze = LemmaServiceGenerator.SERVICE_FACTORY.createInterface();
    interfaze.setName(IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(generatedInterface.getName().split("\\W")))));
    interfaze.setVersion(generatedInterface.getVersion());
    interfaze.setVisibility(this.deriveLemmaVisibility(generatedInterface.getVersion()));
    final Function1<Operation, Boolean> _function = (Operation it) -> {
      return Boolean.valueOf(interfaze.getOperations().add(this.generateOperationFrom(it)));
    };
    IterableExtensions.<Operation>forall(generatedInterface.getOperations(), _function);
    return interfaze;
  }
  
  private Visibility deriveLemmaVisibility(final String visibility) {
    Visibility _switchResult = null;
    String _lowerCase = visibility.toLowerCase();
    if (_lowerCase != null) {
      switch (_lowerCase) {
        case "internal":
          _switchResult = Visibility.INTERNAL;
          break;
        case "in_model":
          _switchResult = Visibility.IN_MODEL;
          break;
        case "architecture":
          _switchResult = Visibility.ARCHITECTURE;
          break;
        case "public":
          _switchResult = Visibility.PUBLIC;
          break;
        default:
          _switchResult = Visibility.NONE;
          break;
      }
    } else {
      _switchResult = Visibility.NONE;
    }
    return _switchResult;
  }
  
  private de.fhdo.lemma.service.Operation generateOperationFrom(final Operation reconstructedOperation) {
    final de.fhdo.lemma.service.Operation operation = LemmaServiceGenerator.SERVICE_FACTORY.createOperation();
    operation.setName(reconstructedOperation.getName());
    final Consumer<Parameter> _function = (Parameter reconstructedParameter) -> {
      final Function1<de.fhdo.lemma.service.Parameter, Boolean> _function_1 = (de.fhdo.lemma.service.Parameter param) -> {
        String _lowerCase = param.getName().toLowerCase();
        String _lowerCase_1 = reconstructedParameter.getName().toLowerCase();
        return Boolean.valueOf(Objects.equal(_lowerCase, _lowerCase_1));
      };
      de.fhdo.lemma.service.Parameter parameter = IterableExtensions.<de.fhdo.lemma.service.Parameter>findFirst(operation.getParameters(), _function_1);
      if ((parameter != null)) {
        parameter.setExchangePattern(ExchangePattern.INOUT);
        operation.getParameters().add(parameter);
      } else {
        parameter = this.generateParameterFrom(reconstructedParameter);
        operation.getParameters().add(parameter);
      }
    };
    reconstructedOperation.getParameters().forEach(_function);
    return operation;
  }
  
  private de.fhdo.lemma.service.Parameter generateParameterFrom(final Parameter reconstructedParameter) {
    final de.fhdo.lemma.service.Parameter parameter = LemmaServiceGenerator.SERVICE_FACTORY.createParameter();
    parameter.setName(StringExtensions.toFirstLower(reconstructedParameter.getName()));
    String _name = parameter.getName();
    boolean _equals = Objects.equal(_name, "list");
    if (_equals) {
      parameter.setName("dataList");
    }
    parameter.setExchangePattern(this.deriveExchangePattern(reconstructedParameter.getExchangePattern().toString()));
    parameter.setCommunicationType(this.deriveCommunicationType(reconstructedParameter.getCommunicationType().toString()));
    PrimitiveType _primitiveType = reconstructedParameter.getPrimitiveType();
    boolean _tripleNotEquals = (_primitiveType != null);
    if (_tripleNotEquals) {
      parameter.setPrimitiveType(Util.getPrimitiveFrom(reconstructedParameter.getPrimitiveType().getName()));
    } else {
      ClassType _classType = reconstructedParameter.getComplexType().getClassType();
      boolean _tripleEquals = (_classType == ClassType.UNSPECIFIED);
      if (_tripleEquals) {
        parameter.setPrimitiveType(LemmaServiceGenerator.DATA_FACTORY.createPrimitiveUnspecified());
      } else {
        ImportedType _deriveImportedType = this.deriveImportedType(reconstructedParameter.getComplexType());
        parameter.setImportedType(((ImportedType) _deriveImportedType));
      }
    }
    return parameter;
  }
  
  private ExchangePattern deriveExchangePattern(final String pattern) {
    ExchangePattern _switchResult = null;
    String _lowerCase = pattern.toLowerCase();
    if (_lowerCase != null) {
      switch (_lowerCase) {
        case "in":
          _switchResult = ExchangePattern.IN;
          break;
        case "out":
          _switchResult = ExchangePattern.OUT;
          break;
        case "inout":
          _switchResult = ExchangePattern.INOUT;
          break;
      }
    }
    return _switchResult;
  }
  
  private CommunicationType deriveCommunicationType(final String type) {
    CommunicationType _switchResult = null;
    String _lowerCase = type.toLowerCase();
    if (_lowerCase != null) {
      switch (_lowerCase) {
        case "synchronous":
          _switchResult = CommunicationType.SYNCHRONOUS;
          break;
        case "asynchronous":
          _switchResult = CommunicationType.SYNCHRONOUS;
          break;
      }
    }
    return _switchResult;
  }
  
  private ImportedType deriveImportedType(final ComplexType complexType) {
    final ImportedType importedType = LemmaServiceGenerator.SERVICE_FACTORY.createImportedType();
    final Import import_ = this.getOrCreateImport(complexType);
    importedType.setImport(import_);
    final de.fhdo.lemma.data.ComplexType type = this.deriveType(complexType);
    final Context context = LemmaServiceGenerator.DATA_FACTORY.createContext();
    context.setName(Util.getContextNameFromQualifedName(complexType.getQualifiedName()));
    type.setContext(context);
    importedType.setType(type);
    return importedType;
  }
  
  private Import getOrCreateImport(final ComplexType complexType) {
    final String contextName = Util.getContextNameFromQualifedName(complexType.getQualifiedName());
    final Function1<Import, Boolean> _function = (Import it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, contextName));
    };
    Import import_ = IterableExtensions.<Import>findFirst(this.model.getImports(), _function);
    if ((import_ == null)) {
      import_ = LemmaServiceGenerator.SERVICE_FACTORY.createImport();
      import_.setName(contextName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("..");
      _builder.append(File.separator);
      _builder.append("domain");
      _builder.append(File.separator);
      _builder.append(contextName);
      _builder.append(".data");
      import_.setImportURI(_builder.toString());
      import_.setImportType(ImportType.DATATYPES);
      this.model.getImports().add(import_);
      return import_;
    }
    return import_;
  }
  
  private de.fhdo.lemma.data.ComplexType deriveType(final ComplexType type) {
    de.fhdo.lemma.data.ComplexType _switchResult = null;
    ClassType _classType = type.getClassType();
    if (_classType != null) {
      switch (_classType) {
        case COLLECTION:
          _switchResult = this.handleCollectionType(type);
          break;
        case DATA_STRUCTURE:
          _switchResult = this.handleDataStructureType(type);
          break;
        case ENUMERATION:
          _switchResult = this.handleEnumerationType(type);
          break;
        case MAP:
          _switchResult = this.handleCollectionType(type);
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  private ListType handleCollectionType(final ComplexType type) {
    final ListType collection = LemmaServiceGenerator.DATA_FACTORY.createListType();
    String _firstUpper = StringExtensions.toFirstUpper(type.getName());
    String _plus = ("data" + _firstUpper);
    collection.setName(_plus);
    return collection;
  }
  
  private DataStructure handleDataStructureType(final ComplexType type) {
    final DataStructure structure = LemmaServiceGenerator.DATA_FACTORY.createDataStructure();
    structure.setName(type.getName());
    return structure;
  }
  
  private Enumeration handleEnumerationType(final ComplexType type) {
    final Enumeration enum_ = LemmaServiceGenerator.DATA_FACTORY.createEnumeration();
    enum_.setName(type.getName());
    return enum_;
  }
}

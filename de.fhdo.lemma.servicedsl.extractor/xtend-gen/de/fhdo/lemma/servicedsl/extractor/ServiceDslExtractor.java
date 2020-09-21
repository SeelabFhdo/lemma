package de.fhdo.lemma.servicedsl.extractor;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.Visibility;
import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.ExchangePattern;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ServiceDslExtractor {
  private static final ArrayList<String> IMPORTED_TECH_ALIASES = CollectionLiterals.<String>newArrayList();
  
  private static final String ID_PATTERN = "(\\^?)([a-zA-Z_])\\w*";
  
  private static final String QUALIFIED_NAME_PATTERN = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(ServiceDslExtractor.ID_PATTERN);
      _builder.append("(\\.");
      _builder.append(ServiceDslExtractor.ID_PATTERN);
      _builder.append(")*");
      return _builder.toString();
    }
  }.apply();
  
  private static final String QUALIFIED_NAME_WITH_AT_LEAST_ONE_LEVEL_PATTERN = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(ServiceDslExtractor.ID_PATTERN);
      _builder.append("\\.");
      String _plus = (_builder.toString() + 
        ServiceDslExtractor.QUALIFIED_NAME_PATTERN);
      return _plus;
    }
  }.apply();
  
  /**
   * Extract ServiceModel
   */
  public String extractToString(final ServiceModel serviceModel) {
    final ArrayList<String> imports = CollectionLiterals.<String>newArrayList();
    final Consumer<Import> _function = (Import it) -> {
      imports.add(this.generate(it));
    };
    serviceModel.getImports().forEach(_function);
    String _xifexpression = null;
    boolean _isEmpty = imports.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _join = String.join("\n", imports);
      _xifexpression = (_join + "\n\n");
    } else {
      _xifexpression = "";
    }
    final String importStatements = _xifexpression;
    final Function1<Microservice, String> _function_1 = (Microservice it) -> {
      return this.generate(it);
    };
    final String microservices = String.join("\n\n", ListExtensions.<Microservice, String>map(serviceModel.getMicroservices(), _function_1));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(importStatements);
    _builder.append(microservices);
    return _builder.toString();
  }
  
  private String generate(final Import import_) {
    String _switchResult = null;
    ImportType _importType = import_.getImportType();
    if (_importType != null) {
      switch (_importType) {
        case DATATYPES:
          _switchResult = "datatypes";
          break;
        case MICROSERVICES:
          _switchResult = "microservices";
          break;
        case TECHNOLOGY:
          _switchResult = "technology";
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    final String importTypeKeyword = _switchResult;
    if ((importTypeKeyword == "technology")) {
      ServiceDslExtractor.IMPORTED_TECH_ALIASES.add(import_.getName());
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(importTypeKeyword);
    _builder.append(" from \"");
    String _importURI = import_.getImportURI();
    _builder.append(_importURI);
    _builder.append("\" as ");
    String _name = import_.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  private String generate(final Microservice service) {
    final String techImports = this.generateTechAnnotation(service);
    StringConcatenation _builder = new StringConcatenation();
    String _generate = this.generate(service.getVisibility());
    _builder.append(_generate);
    _builder.append(" ");
    String _generate_1 = this.generate(service.getType());
    _builder.append(_generate_1);
    final String preamble = _builder.toString();
    final Function1<Interface, Boolean> _function = (Interface it) -> {
      boolean _isEmpty = it.getOperations().isEmpty();
      return Boolean.valueOf((!_isEmpty));
    };
    final boolean hasInterfaceOperations = IterableExtensions.<Interface>exists(service.getInterfaces(), _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(techImports);
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(preamble);
    _builder_1.append(" microservice ");
    String _lemmaName = this.lemmaName(service);
    _builder_1.append(_lemmaName);
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    {
      if (hasInterfaceOperations) {
        {
          EList<Interface> _interfaces = service.getInterfaces();
          for(final Interface iface : _interfaces) {
            _builder_1.append("    ");
            String _generate_2 = this.generate(iface);
            _builder_1.append(_generate_2, "    ");
            _builder_1.newLineIfNotEmpty();
          }
        }
      } else {
        _builder_1.append("    ");
        _builder_1.append("[DEFINE_OPERATIONS]");
        _builder_1.newLine();
      }
    }
    _builder_1.append("}");
    return _builder_1.toString();
  }
  
  private String lemmaName(final Microservice service) {
    String _xifexpression = null;
    boolean _matches = service.getName().matches(ServiceDslExtractor.QUALIFIED_NAME_WITH_AT_LEAST_ONE_LEVEL_PATTERN);
    if (_matches) {
      _xifexpression = service.getName();
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("ADD_QUALIFYING_PART.");
      String _name = service.getName();
      _builder.append(_name);
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  private String generate(final Visibility visibility) {
    String _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case INTERNAL:
          _switchResult = "internal";
          break;
        case PUBLIC:
          _switchResult = "public";
          break;
        default:
          _switchResult = "architecture";
          break;
      }
    } else {
      _switchResult = "architecture";
    }
    return _switchResult;
  }
  
  private String generate(final MicroserviceType type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case FUNCTIONAL:
          _switchResult = "functional";
          break;
        case INFRASTRUCTURE:
          _switchResult = "infrastructure";
          break;
        case UTILITY:
          _switchResult = "utility";
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
  
  private String generate(final Interface iface) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface ");
    String _name = iface.getName();
    _builder.append(_name);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Operation> _operations = iface.getOperations();
      for(final Operation o : _operations) {
        _builder.append("    ");
        String _generate = this.generate(o);
        _builder.append(_generate, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    return _builder.toString();
  }
  
  private String generate(final Endpoint endpoint) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ImportedProtocolAndDataFormat> _protocols = endpoint.getProtocols();
      boolean _hasElements = false;
      for(final ImportedProtocolAndDataFormat ep : _protocols) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("; ", "");
        }
        _builder.newLineIfNotEmpty();
        String _generate = this.generate(ep.getImportedProtocol());
        _builder.append(_generate);
        _builder.append(":");
      }
    }
    {
      EList<String> _addresses = endpoint.getAddresses();
      boolean _hasElements_1 = false;
      for(final String ea : _addresses) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("\"");
        _builder.append(ea);
        _builder.append("\"");
      }
    }
    _builder.append(";");
    return _builder.toString();
  }
  
  private String generate(final Operation operation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@endpoints(");
    {
      EList<Endpoint> _endpoints = operation.getEndpoints();
      for(final Endpoint e : _endpoints) {
        String _generate = this.generate(e);
        _builder.append(_generate);
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    final String endpoint = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      EList<ImportedServiceAspect> _aspects = operation.getAspects();
      for(final ImportedServiceAspect a : _aspects) {
        String _generate_1 = this.generate(a);
        _builder_1.append(_generate_1);
      }
    }
    _builder_1.newLineIfNotEmpty();
    final String aspects = _builder_1.toString();
    final Function1<Parameter, String> _function = (Parameter it) -> {
      return this.generate(it);
    };
    final String parameters = String.join(", ", ListExtensions.<Parameter, String>map(operation.getParameters(), _function));
    String _xifexpression = null;
    ApiOperationComment _apiOperationComment = operation.getApiOperationComment();
    boolean _tripleNotEquals = (_apiOperationComment != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("---");
      _builder_2.newLine();
      String _comment = operation.getApiOperationComment().getComment();
      _builder_2.append(_comment);
      _builder_2.newLineIfNotEmpty();
      {
        final Function1<Parameter, Boolean> _function_1 = (Parameter it) -> {
          boolean _isOptional = it.isOptional();
          return Boolean.valueOf((!_isOptional));
        };
        Iterable<Parameter> _filter = IterableExtensions.<Parameter>filter(operation.getParameters(), _function_1);
        for(final Parameter param : _filter) {
          _builder_2.append("@required ");
          String _name = param.getName();
          _builder_2.append(_name);
          _builder_2.newLineIfNotEmpty();
        }
      }
      _builder_2.append("---");
      _builder_2.newLine();
      _xifexpression = _builder_2.toString();
    }
    final String comment = _xifexpression;
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(comment);
    _builder_3.append(" ");
    _builder_3.append(endpoint);
    _builder_3.append(" ");
    _builder_3.append(aspects);
    _builder_3.append(" ");
    String _name_1 = operation.getName();
    _builder_3.append(_name_1);
    _builder_3.append("(");
    _builder_3.append(parameters);
    _builder_3.append(");");
    return _builder_3.toString();
  }
  
  private String generate(final Parameter parameter) {
    final ArrayList<String> preamble = CollectionLiterals.<String>newArrayList();
    preamble.add(this.generate(parameter.getCommunicationType()));
    preamble.add(this.generate(parameter.getExchangePattern()));
    StringConcatenation _builder = new StringConcatenation();
    String _join = String.join(" ", preamble);
    _builder.append(_join);
    _builder.append(" ");
    String _name = parameter.getName();
    _builder.append(_name);
    _builder.append(" : ");
    String _generateType = this.generateType(parameter);
    _builder.append(_generateType);
    return _builder.toString();
  }
  
  private String generate(final CommunicationType type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case ASYNCHRONOUS:
          _switchResult = "async";
          break;
        case SYNCHRONOUS:
          _switchResult = "sync";
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
  
  private String generate(final ExchangePattern pattern) {
    String _switchResult = null;
    if (pattern != null) {
      switch (pattern) {
        case IN:
          _switchResult = "in";
          break;
        case OUT:
          _switchResult = "out";
          break;
        case INOUT:
          _switchResult = "inout";
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
  
  private String generate(final ImportedServiceAspect aspect) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    ServiceAspect _importedAspect = aspect.getImportedAspect();
    Technology _technology = null;
    if (_importedAspect!=null) {
      _technology=_importedAspect.getTechnology();
    }
    String _name = null;
    if (_technology!=null) {
      _name=_technology.getName();
    }
    _builder.append(_name);
    _builder.append("::");
    {
      EList<String> _qualifiedNameParts = aspect.getImportedAspect().getQualifiedNameParts(false, true);
      boolean _hasElements = false;
      for(final String s : _qualifiedNameParts) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(".", "");
        }
        _builder.append(s);
      }
    }
    return _builder.toString();
  }
  
  private String generateType(final Parameter parameter) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = parameter.getPrimitiveType();
    boolean _tripleNotEquals = (_primitiveType != null);
    if (_tripleNotEquals) {
      PrimitiveType _primitiveType_1 = parameter.getPrimitiveType();
      _xifexpression = this.generate(((PrimitiveType) _primitiveType_1));
    } else {
      _xifexpression = this.generate(parameter.getImportedType());
    }
    return _xifexpression;
  }
  
  private String generate(final PrimitiveType type) {
    return type.getTypeName();
  }
  
  private String generateTechAnnotation(final Microservice service) {
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<Import, Boolean> _function = (Import it) -> {
        ImportType _importType = it.getImportType();
        return Boolean.valueOf(Objects.equal(_importType, ImportType.TECHNOLOGY));
      };
      Iterable<Import> _filter = IterableExtensions.<Import>filter(service.getServiceModel().getImports(), _function);
      for(final Import tech : _filter) {
        _builder.append("@technology(");
        String _name = tech.getName();
        _builder.append(_name);
        _builder.append(")");
      }
    }
    return _builder.toString();
  }
  
  private String generate(final Protocol protocol) {
    String _elvis = null;
    Technology _technology = protocol.getTechnology();
    String _name = null;
    if (_technology!=null) {
      _name=_technology.getName();
    }
    if (_name != null) {
      _elvis = _name;
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[PROTOCOL TECHNOLOGY URI NOT DEFINED]");
      _elvis = _builder.toString();
    }
    final String techName = _elvis;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(techName);
    _builder_1.append("::");
    {
      EList<String> _qualifiedNameParts = protocol.getQualifiedNameParts();
      boolean _hasElements = false;
      for(final String p : _qualifiedNameParts) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder_1.appendImmediate(".", "");
        }
        _builder_1.append(p);
      }
    }
    return _builder_1.toString();
  }
  
  private String generate(final ImportedType importedType) {
    ImportType _importType = importedType.getImport().getImportType();
    if (_importType != null) {
      switch (_importType) {
        case TECHNOLOGY:
          StringConcatenation _builder = new StringConcatenation();
          String _name = importedType.getImport().getName();
          _builder.append(_name);
          _builder.append("::");
          Type _type = importedType.getType();
          _builder.append(_type);
          return _builder.toString();
        case DATATYPES:
          Type _type_1 = importedType.getType();
          final String importedTypeName = ((ComplexType) _type_1).buildQualifiedName(".");
          StringConcatenation _builder_1 = new StringConcatenation();
          String _name_1 = importedType.getImport().getName();
          _builder_1.append(_name_1);
          _builder_1.append("::");
          _builder_1.append(importedTypeName);
          return _builder_1.toString();
        default:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("[COULD NOT MATCH IMPORTED TYPE]");
          return _builder_2.toString();
      }
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("[COULD NOT MATCH IMPORTED TYPE]");
      return _builder_2.toString();
    }
  }
}

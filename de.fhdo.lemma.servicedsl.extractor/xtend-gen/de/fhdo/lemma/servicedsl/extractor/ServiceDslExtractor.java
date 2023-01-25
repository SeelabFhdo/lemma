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
import de.fhdo.lemma.technology.Technology;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Model-to-text extractor for the Service DSL.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class ServiceDslExtractor {
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
  
  private ArrayList<String> importedTechnologyAliases = CollectionLiterals.<String>newArrayList();
  
  /**
   * Extract ServiceModel
   */
  public String extractToString(final ServiceModel serviceModel) {
    String _xblockexpression = null;
    {
      final Function1<Import, String> _function = (Import it) -> {
        return this.generate(it);
      };
      final List<String> imports = ListExtensions.<Import, String>map(serviceModel.getImports(), _function);
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
      final Function1<Microservice, CharSequence> _function_1 = (Microservice it) -> {
        return this.generate(it);
      };
      final String microservices = String.join("\n\n", ListExtensions.<Microservice, CharSequence>map(serviceModel.getMicroservices(), _function_1));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(importStatements);
      _builder.append(microservices);
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Imports
   */
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
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Type ");
          ImportType _importType_1 = import_.getImportType();
          _builder.append(_importType_1);
          _builder.append(" is not ");
          String _plus = (_builder.toString() + 
            "supported");
          throw new IllegalArgumentException(_plus);
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      ImportType _importType_1 = import_.getImportType();
      _builder.append(_importType_1);
      _builder.append(" is not ");
      String _plus = (_builder.toString() + 
        "supported");
      throw new IllegalArgumentException(_plus);
    }
    final String importTypeKeyword = _switchResult;
    boolean _equals = Objects.equal(importTypeKeyword, "technology");
    if (_equals) {
      this.importedTechnologyAliases.add(import_.getName());
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import ");
    _builder_1.append(importTypeKeyword);
    _builder_1.append(" from \"");
    String _importURI = import_.getImportURI();
    _builder_1.append(_importURI);
    _builder_1.append("\" as ");
    String _name = import_.getName();
    _builder_1.append(_name);
    return _builder_1.toString();
  }
  
  /**
   * Extract Microservice
   */
  private CharSequence generate(final Microservice service) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      String _generate = this.generate(service.getVisibility());
      _builder.append(_generate);
      _builder.append(" ");
      String _generate_1 = this.generate(service.getType());
      _builder.append(_generate_1);
      final String preamble = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _generateTechAnnotation = this.generateTechAnnotation(service);
      _builder_1.append(_generateTechAnnotation);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append(preamble);
      _builder_1.append(" microservice ");
      String _lemmaName = this.lemmaName(service);
      _builder_1.append(_lemmaName);
      _builder_1.append(" {");
      _builder_1.newLineIfNotEmpty();
      {
        final Function1<Interface, Boolean> _function = (Interface it) -> {
          boolean _isEmpty = it.getOperations().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        boolean _exists = IterableExtensions.<Interface>exists(service.getInterfaces(), _function);
        if (_exists) {
          {
            EList<Interface> _interfaces = service.getInterfaces();
            for(final Interface iface : _interfaces) {
              _builder_1.append("    ");
              CharSequence _generate_2 = this.generate(iface);
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
      _xblockexpression = _builder_1;
    }
    return _xblockexpression;
  }
  
  /**
   * Extracts the name of a Microservice
   */
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
  
  /**
   * Extract Visibility of a Microservice
   */
  private String generate(final Visibility visibility) {
    String _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case ARCHITECTURE:
          _switchResult = "architecture";
          break;
        case INTERNAL:
          _switchResult = "internal";
          break;
        case PUBLIC:
          _switchResult = "public";
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Type ");
          _builder.append(visibility);
          _builder.append(" is not supported.");
          throw new IllegalArgumentException(_builder.toString());
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      _builder.append(visibility);
      _builder.append(" is not supported.");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  /**
   * Extract MicroserviceType of a Microservice
   */
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
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Type ");
          _builder.append(type);
          _builder.append(" is not supported.");
          throw new IllegalArgumentException(_builder.toString());
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      _builder.append(type);
      _builder.append(" is not supported.");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  /**
   * Extract Interface
   */
  private CharSequence generate(final Interface iface) {
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
        CharSequence _generate = this.generate(o);
        _builder.append(_generate, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    return _builder;
  }
  
  /**
   * Extract Endpoint
   */
  private CharSequence generate(final Endpoint endpoint) {
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
    return _builder;
  }
  
  /**
   * Extract Operation
   */
  public CharSequence generate(final Operation operation) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      ApiOperationComment _apiOperationComment = operation.getApiOperationComment();
      boolean _tripleNotEquals = (_apiOperationComment != null);
      if (_tripleNotEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("---");
        _builder.newLine();
        String _comment = operation.getApiOperationComment().getComment();
        _builder.append(_comment);
        _builder.newLineIfNotEmpty();
        {
          final Function1<Parameter, Boolean> _function = (Parameter it) -> {
            boolean _isOptional = it.isOptional();
            return Boolean.valueOf((!_isOptional));
          };
          Iterable<Parameter> _filter = IterableExtensions.<Parameter>filter(operation.getParameters(), _function);
          for(final Parameter param : _filter) {
            _builder.append("@required ");
            String _name = param.getName();
            _builder.append(_name);
            _builder.append(" [INSERT PARAMETER DESC HERE]");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          final Function1<Parameter, Boolean> _function_1 = (Parameter it) -> {
            return Boolean.valueOf(it.isOptional());
          };
          Iterable<Parameter> _filter_1 = IterableExtensions.<Parameter>filter(operation.getParameters(), _function_1);
          for(final Parameter param_1 : _filter_1) {
            _builder.append("@param ");
            String _name_1 = param_1.getName();
            _builder.append(_name_1);
            _builder.append(" [INSERT PARAMETER DESC HERE]");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("---");
        _builder.newLine();
        _xifexpression = _builder.toString();
      }
      final String comment = _xifexpression;
      String endpoints = "";
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(operation.getEndpoints());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("@endpoints(");
        {
          EList<Endpoint> _endpoints = operation.getEndpoints();
          for(final Endpoint e : _endpoints) {
            CharSequence _generate = this.generate(e);
            _builder_1.append(_generate);
          }
        }
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        endpoints = _builder_1.toString();
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      {
        EList<ImportedServiceAspect> _aspects = operation.getAspects();
        for(final ImportedServiceAspect a : _aspects) {
          CharSequence _generate_1 = this.generate(a);
          _builder_2.append(_generate_1);
        }
      }
      _builder_2.newLineIfNotEmpty();
      final String aspects = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      {
        EList<Parameter> _parameters = operation.getParameters();
        boolean _hasElements = false;
        for(final Parameter parameter : _parameters) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_3.appendImmediate(",", "");
          }
          CharSequence _generate_2 = this.generate(parameter);
          _builder_3.append(_generate_2);
        }
      }
      final String parameters = _builder_3.toString();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append(comment);
      _builder_4.append(endpoints);
      _builder_4.append(aspects);
      String _name_2 = operation.getName();
      _builder_4.append(_name_2);
      _builder_4.append("(");
      _builder_4.append(parameters);
      _builder_4.append(");");
      _xblockexpression = _builder_4;
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Parameter
   */
  private CharSequence generate(final Parameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ImportedServiceAspect> _aspects = parameter.getAspects();
      boolean _hasElements = false;
      for(final ImportedServiceAspect a : _aspects) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("\n\t");
        } else {
          _builder.appendImmediate("\n\t", "");
        }
        CharSequence _generate = this.generate(a);
        _builder.append(_generate);
      }
      if (_hasElements) {
        _builder.append("\n");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generate_1 = this.generate(parameter.getCommunicationType());
    _builder.append(_generate_1);
    _builder.append(" ");
    String _generate_2 = this.generate(parameter.getExchangePattern());
    _builder.append(_generate_2);
    _builder.append(" ");
    String _name = parameter.getName();
    _builder.append(_name);
    _builder.append(" : ");
    String _generateType = this.generateType(parameter);
    _builder.append(_generateType);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * Extract CommunicationType
   */
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
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Type ");
          _builder.append(type);
          _builder.append(" is not supported.");
          throw new IllegalArgumentException(_builder.toString());
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      _builder.append(type);
      _builder.append(" is not supported.");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  /**
   * Extract ExchangePattern
   */
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
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Type ");
          _builder.append(pattern);
          _builder.append(" is not supported.");
          throw new IllegalArgumentException(_builder.toString());
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      _builder.append(pattern);
      _builder.append(" is not supported.");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  /**
   * Extract ImportedServiceAspect
   */
  private CharSequence generate(final ImportedServiceAspect aspect) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    String _name = aspect.getImportedAspect().getTechnology().getName();
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
    return _builder;
  }
  
  /**
   * Extract Parameter
   */
  private String generateType(final Parameter parameter) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = parameter.getPrimitiveType();
    boolean _tripleNotEquals = (_primitiveType != null);
    if (_tripleNotEquals) {
      _xifexpression = this.generate(parameter.getPrimitiveType());
    } else {
      String _xifexpression_1 = null;
      ImportedType _importedType = parameter.getImportedType();
      boolean _tripleNotEquals_1 = (_importedType != null);
      if (_tripleNotEquals_1) {
        _xifexpression_1 = this.generate(parameter.getImportedType());
      } else {
        _xifexpression_1 = null;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Extract PrimitiveType
   */
  private String generate(final PrimitiveType type) {
    return type.getTypeName();
  }
  
  /**
   * Extract Technology Annotations of a Microservice
   */
  private CharSequence generateTechAnnotation(final Microservice service) {
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
    return _builder;
  }
  
  /**
   * Extract Protocol
   */
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
  
  /**
   * Extract ImportedType
   */
  private String generate(final ImportedType importedType) {
    final Type type = importedType.getType();
    String _switchResult = null;
    boolean _matched = false;
    if (type instanceof PrimitiveType) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _name = importedType.getImport().getName();
      _builder.append(_name);
      _builder.append("::");
      String _typeName = ((PrimitiveType)type).getTypeName();
      _builder.append(_typeName);
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (type instanceof ComplexType) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = importedType.getImport().getName();
        _builder.append(_name);
        _builder.append("::");
        String _buildQualifiedName = ((ComplexType)type).buildQualifiedName(".");
        _builder.append(_buildQualifiedName);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      String _simpleName = type.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" is not ");
      String _plus = (_builder.toString() + 
        "supported");
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }
}

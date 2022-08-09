package de.fhdo.lemma.service.openapi;

import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.technologydsl.extractor.TechnologyDslExtractor;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * This class collects _static_ utility methods for the OpenAPI plugin.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public final class OpenApiUtil {
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private static final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  public static String removeInvalidCharsFromName(final String s) {
    final String ret = s.replaceAll("[^a-zA-Z0-9_]", "");
    String _xifexpression = null;
    boolean _isAlphabetic = Character.isAlphabetic(ret.charAt(0));
    boolean _not = (!_isAlphabetic);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("v");
      _builder.append(ret);
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = ret;
    }
    return _xifexpression;
  }
  
  /**
   * Serialize a LEMMA data or mapping model to the given file path. Returns true if the file path
   * and the contents extracted from the model's root are not empty.
   */
  public static boolean writeModel(final EObject modelRoot, final String filepath) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(filepath);
    if (_isNullOrEmpty) {
      return false;
    }
    String _switchResult = null;
    boolean _matched = false;
    if (modelRoot instanceof DataModel) {
      _matched=true;
      _switchResult = new DataDslExtractor().extractToString(((DataModel)modelRoot));
    }
    if (!_matched) {
      if (modelRoot instanceof Technology) {
        _matched=true;
        _switchResult = new TechnologyDslExtractor().extractToString(((Technology)modelRoot));
      }
    }
    if (!_matched) {
      if (modelRoot instanceof ServiceModel) {
        _matched=true;
        _switchResult = new ServiceDslExtractor().extractToString(((ServiceModel)modelRoot));
      }
    }
    final String content = _switchResult;
    return OpenApiUtil.writeFile(filepath, content);
  }
  
  /**
   * Write string contents to the given file path. Returns true if the file path and the contents
   * are not empty.
   */
  private static boolean writeFile(final String filepath, final String content) {
    if ((StringExtensions.isNullOrEmpty(filepath) || StringExtensions.isNullOrEmpty(content))) {
      return false;
    }
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _xblockexpression = false;
      {
        new File(filepath).getParentFile().mkdirs();
        Files.write(Paths.get(filepath), content.getBytes());
        _xblockexpression = true;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        _xtrycatchfinallyexpression = false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public static PrimitiveType deriveIntType(final String typeDesc) {
    PrimitiveType _switchResult = null;
    if (typeDesc != null) {
      switch (typeDesc) {
        case "int32":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveInteger();
          break;
        case "int64":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveLong();
          break;
        default:
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveInteger();
          break;
      }
    } else {
      _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveInteger();
    }
    return _switchResult;
  }
  
  public static PrimitiveType deriveNumberType(final String typeDesc) {
    PrimitiveType _switchResult = null;
    if (typeDesc != null) {
      switch (typeDesc) {
        case "double":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveDouble();
          break;
        case "float":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveFloat();
          break;
        default:
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveDouble();
          break;
      }
    } else {
      _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveDouble();
    }
    return _switchResult;
  }
  
  public static PrimitiveType deriveStringType(final String typeDesc) {
    PrimitiveType _switchResult = null;
    if (typeDesc != null) {
      switch (typeDesc) {
        case "binary":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveString();
          break;
        case "byte":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveString();
          break;
        case "date":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveDate();
          break;
        case "date-time":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveDate();
          break;
        case "password":
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveString();
          break;
        default:
          _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveString();
          break;
      }
    } else {
      _switchResult = OpenApiUtil.DATA_FACTORY.createPrimitiveString();
    }
    return _switchResult;
  }
}

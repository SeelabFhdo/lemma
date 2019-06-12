/**
 * generated by Xtext 2.12.0
 */
package de.fhdo.ddmm.technology.mappingdsl.formatting2;

import com.google.inject.Inject;
import de.fhdo.ddmm.formatting2.ServiceDslFormatter;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.technology.mapping.ImportedMicroservice;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.TechnologyMapping;
import de.fhdo.ddmm.technology.mappingdsl.services.MappingDslGrammarAccess;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class MappingDslFormatter extends ServiceDslFormatter {
  @Inject
  @Extension
  private MappingDslGrammarAccess _mappingDslGrammarAccess;
  
  protected void _format(final TechnologyMapping technologyMapping, @Extension final IFormattableDocument document) {
    EList<Import> _imports = technologyMapping.getImports();
    for (final Import _import : _imports) {
      document.<Import>format(_import);
    }
    EList<MicroserviceMapping> _serviceMappings = technologyMapping.getServiceMappings();
    for (final MicroserviceMapping microserviceMapping : _serviceMappings) {
      document.<MicroserviceMapping>format(microserviceMapping);
    }
  }
  
  protected void _format(final MicroserviceMapping microserviceMapping, @Extension final IFormattableDocument document) {
    document.<ImportedMicroservice>format(microserviceMapping.getMicroservice());
  }
  
  public void format(final Object microserviceMapping, final IFormattableDocument document) {
    if (microserviceMapping instanceof XtextResource) {
      _format((XtextResource)microserviceMapping, document);
      return;
    } else if (microserviceMapping instanceof ServiceModel) {
      _format((ServiceModel)microserviceMapping, document);
      return;
    } else if (microserviceMapping instanceof MicroserviceMapping) {
      _format((MicroserviceMapping)microserviceMapping, document);
      return;
    } else if (microserviceMapping instanceof TechnologyMapping) {
      _format((TechnologyMapping)microserviceMapping, document);
      return;
    } else if (microserviceMapping instanceof EObject) {
      _format((EObject)microserviceMapping, document);
      return;
    } else if (microserviceMapping == null) {
      _format((Void)null, document);
      return;
    } else if (microserviceMapping != null) {
      _format(microserviceMapping, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(microserviceMapping, document).toString());
    }
  }
}

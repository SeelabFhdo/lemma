package de.fhdo.lemma;

import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * Custom qualified name provider.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ServiceDslQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
  /**
   * Consider possible version as prefix of a microservice's name
   */
  public QualifiedName qualifiedName(final Microservice microservice) {
    return QualifiedName.create(microservice.getQualifiedNameParts());
  }
  
  /**
   * Consider possible version as prefix of an interface's name
   */
  public QualifiedName qualifiedName(final Interface iface) {
    return QualifiedName.create(iface.getQualifiedNameParts());
  }
}

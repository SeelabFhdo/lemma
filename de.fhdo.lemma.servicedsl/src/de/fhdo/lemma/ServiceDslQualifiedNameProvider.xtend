package de.fhdo.lemma

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import de.fhdo.lemma.service.Microservice
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.lemma.service.Interface

/**
 * Custom qualified name provider.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServiceDslQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
    /**
     * Consider possible version as prefix of a microservice's name
     */
    def qualifiedName(Microservice microservice) {
        return QualifiedName.create(microservice.qualifiedNameParts)
    }

    /**
     * Consider possible version as prefix of an interface's name
     */
    def qualifiedName(Interface iface) {
        return QualifiedName.create(iface.qualifiedNameParts)
    }
}
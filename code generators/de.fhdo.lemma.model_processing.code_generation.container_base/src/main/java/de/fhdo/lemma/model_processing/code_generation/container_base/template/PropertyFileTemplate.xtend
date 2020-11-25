package de.fhdo.lemma.model_processing.code_generation.container_base.template

import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue

/**
 * Template class for generating Spring-based application.propertiers files.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class PropertyFileTemplate {
    /**
     * Build the application.properties file.
     */
    static def String getPropertiesForServiceConfiguration(
        IntermediateTechnologySpecificPropertyValue[] serviceProperties) '''
        «FOR property : serviceProperties»
            «IF 'springapplicationname' == property.technologySpecificProperty.name.toLowerCase»
                spring.application.name=«property.value.toLowerCase»
                spring.main.allow-bean-definition-overriding=true
            «ENDIF»
            «IF 'springapplicationname' == property.technologySpecificProperty.name.toLowerCase»
                spring.application.name=«property.value.toLowerCase»
                spring.main.allow-bean-definition-overriding=true
            «ENDIF»
            «IF 'serverport' == property.technologySpecificProperty.name.toLowerCase»
                server.port=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatasourceurl' == property.technologySpecificProperty.name.toLowerCase»
                spring.datasource.url=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatasourceusername' == property.technologySpecificProperty.name.toLowerCase»
                spring.datasource.username=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatasourcepassword' == property.technologySpecificProperty.name.toLowerCase»
                spring.datasource.password=«property.value.toLowerCase»
                spring.jpa.hibernate.ddl-auto=update
            «ENDIF»
            «IF 'eurekaclientserviceurldefaultzone' == property.technologySpecificProperty.name.toLowerCase»
                eureka.client.service-url.defaultZone=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbhost' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.host=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbport' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.port=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodburi' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.uri=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbdatabase' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.database=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbusername' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.username=«property.value.toLowerCase»
            «ENDIF»
            «IF 'stringdatamongodbpassword' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.password=«property.value.toLowerCase»
            «ENDIF»
        «ENDFOR»
    '''
}
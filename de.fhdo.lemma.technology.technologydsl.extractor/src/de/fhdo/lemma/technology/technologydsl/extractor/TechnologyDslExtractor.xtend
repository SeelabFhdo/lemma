package de.fhdo.lemma.technology.technologydsl.extractor

import de.fhdo.lemma.technology.DataFormat
import de.fhdo.lemma.technology.Protocol
import de.fhdo.lemma.technology.Technology
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.JoinPointType
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType
import de.fhdo.lemma.technology.ServiceAspect

/**
 * Model-to-text extractor for the Technology DSL.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class TechnologyDslExtractor {
    /**
     * Used as seperator to list, e.g., protocols and types
     */
    static val LINE_SEP = System.getProperty("line.separator")

    /**
     * Extract TechnologyModel
     */
    def extractToString(Technology techModel) {
        val types = if (!techModel.primitiveTypes.isNullOrEmpty) {
            // Currently only supports primitiveTypes for generation
            '''
            types {
                «FOR pt : techModel.primitiveTypes SEPARATOR LINE_SEP»«pt.extractToString»«ENDFOR»
            }
            '''
        }

        val protocols = if (!techModel.protocols.isNullOrEmpty) {
            '''
            protocols {
                «FOR pr : techModel.protocols SEPARATOR LINE_SEP»«pr.extractToString»«ENDFOR»
            }
            '''
        }

        val aspects = if (!techModel.serviceAspects.isNullOrEmpty) {
            '''
            service aspects {
                «FOR sa : techModel.serviceAspects SEPARATOR LINE_SEP»«sa.extractToString»«ENDFOR»
            }
            '''
        }

        '''
        technology «techModel.name» {
            «types»
            «IF !types.empty»«"\n"»«ENDIF»
            «protocols»
            «IF !protocols.empty»«"\n"»«ENDIF»
            «aspects»
        }
        '''.toString
    }

    /**
     * Extract Protocol
     */
    def extractToString(Protocol protocol) {
        // Break before closing guillemet is intentional because of Xtend's string template engine
        val comm = '''«IF (protocol.communicationType == CommunicationType.SYNCHRONOUS)»sync «ELSE
            »async «ENDIF»'''

        // Break after opening guillemet is intentional because of Xtend's string template engine
        val formats = '''«FOR df : protocol.dataFormats SEPARATOR ', '»"«
            df.extractToString»"«ENDFOR»'''

        // Break before closing guillemet is intentional because of Xtend's string template engine
        val defaultFormat = '''«IF (protocol.defaultFormat !== null)
            » default with format "«protocol.defaultFormat.formatName»"«ENDIF»'''

        '''«comm»«protocol.name» data formats «formats»«defaultFormat»;'''
    }

    /**
     * Extract Aspect
     */
    def extractToString(ServiceAspect aspect) {
        // Break after FOR is intentional because of Xtend's string template engine
        '''aspect «aspect.name»«IF aspect.isSingleValued»<singleval>«ENDIF» for «FOR
            jp : aspect.joinPoints SEPARATOR ', '»«jp.extractToString»«ENDFOR»;'''
    }

    /**
     * Extract DataFormat
     */
    def extractToString(DataFormat dataformat) {
        dataformat.formatName
    }

    /**
     * Extract JointPointType
     */
    def extractToString(JoinPointType jpt) {
        jpt.getName().toLowerCase
    }

    /**
     * Extract TechnologySpecificPrimitiveType
     */
    def extractToString(TechnologySpecificPrimitiveType type) {
        // Break before opening guillemet is intentional because of Xtend's string template engine
        val basicTypes = '''«FOR bbp : type.basicBuiltinPrimitiveTypes SEPARATOR ', '
            »«bbp.typeName»«ENDFOR»'''

        '''primitive type «type.name» based on «basicTypes»«IF type.^default» default«ENDIF»;'''
    }
}

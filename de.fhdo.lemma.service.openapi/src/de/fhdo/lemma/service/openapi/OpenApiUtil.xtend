package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor
import de.fhdo.lemma.data.DataModel
import org.eclipse.emf.ecore.EObject
import java.nio.file.Files
import java.nio.file.Paths
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor
import de.fhdo.lemma.technology.Technology
import de.fhdo.lemma.technology.technologydsl.extractor.TechnologyDslExtractor
import de.fhdo.lemma.data.DataFactory
import java.io.File
import de.fhdo.lemma.data.PrimitiveType

/**
 * This class collects _static_ utility methods for the OpenAPI plugin.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
final class OpenApiUtil {
    /* Factory to actually create and manipulate a LEMMA DataModel */
    static val DATA_FACTORY = DataFactory.eINSTANCE

    static def String removeInvalidCharsFromName(String s) {
        val ret = s.replaceAll("[^a-zA-Z0-9_]", "")

        if (s.isNullOrEmpty)
            return ""
        else if (!Character.isAlphabetic(ret.charAt(0)))
                return '''v«ret»'''
            else
                return ret
    }

    /**
     * Serialize a LEMMA data or mapping model to the given file path. Returns true if the file path
     * and the contents extracted from the model's root are not empty.
     */
    static def boolean writeModel(EObject modelRoot, String filepath) {
        if (filepath.nullOrEmpty)
            return false

        val content = switch(modelRoot) {
            DataModel: new DataDslExtractor().extractToString(modelRoot)
            Technology: new TechnologyDslExtractor().extractToString(modelRoot)
            ServiceModel: new ServiceDslExtractor().extractToString(modelRoot)
        }

        return filepath.writeFile(content)
    }

     /**
     * Write string contents to the given file path. Returns true if the file path and the contents
     * are not empty.
     */
    private static def boolean writeFile(String filepath, String content) {
        if (filepath.nullOrEmpty || content.nullOrEmpty)
            return false

        return try {
            // Create potentially missing parent folders before trying to write the file
            new File(filepath).parentFile.mkdirs()
            Files.write(Paths.get(filepath), content.bytes)
            true
        } catch (Exception ex) {
            false
        }
    }

    /**
     * Derive a LEMMA integer type from the given OpenAPI type description
     */
    def static PrimitiveType deriveIntType(String typeDesc) {
        return switch (typeDesc) {
            case "int32": DATA_FACTORY.createPrimitiveInteger
            case "int64": DATA_FACTORY.createPrimitiveLong
            default: DATA_FACTORY.createPrimitiveInteger
       }
    }

    /**
     * Derive a LEMMA number type from the given OpenAPI type description
     */
    def static PrimitiveType deriveNumberType(String typeDesc) {
        return switch (typeDesc) {
            case "double": DATA_FACTORY.createPrimitiveDouble
            case "float": DATA_FACTORY.createPrimitiveFloat
            default: DATA_FACTORY.createPrimitiveDouble
        }
    }

    /**
     * Derive a LEMMA string type from the given OpenAPI type description. This also includes the
     * OpenAPI date and date-time formats which do not represent dedicated types but only formats of
     * OpenAPI's string type.
     */
    def static PrimitiveType deriveStringType(String typeDesc) {
        return switch (typeDesc) {
            case "binary": DATA_FACTORY.createPrimitiveString
            case "byte": DATA_FACTORY.createPrimitiveString
            case "date": DATA_FACTORY.createPrimitiveDate
            case "date-time": DATA_FACTORY.createPrimitiveDate
            case "password": DATA_FACTORY.createPrimitiveString
            default: DATA_FACTORY.createPrimitiveString
        }
    }

}
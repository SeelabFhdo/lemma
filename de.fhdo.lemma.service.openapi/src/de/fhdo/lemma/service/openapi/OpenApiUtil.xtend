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
import de.fhdo.lemma.data.PrimitiveType
import java.io.File

/**
 * This class collects _static_ utility methods for the OpenAPI plugin.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
final class OpenApiUtil {
    /** Factory to actually create and manipulate a LEMMA DataModel */
    static val DATA_FACTORY = DataFactory.eINSTANCE
    static def String removeInvalidCharsFromName(String str) {
        var ret = str;
        ret = ret.replaceAll("[^a-zA-Z0-9_]", "");
        if(!Character.isAlphabetic(ret.charAt(0)))
            ret = "v"+ret;
         return ret
    }

    /**
     * Serialize a LEMMA data or mapping model to the given file path. Returns true if the file path
     * and the contents extracted from the model's root are not empty.
     */
    static def boolean writeModel(EObject modelRoot, String filepath) {
        if (filepath.nullOrEmpty)
            return false
        //if modelRoot is a DataModel, serialize it as a string
        val content = switch(modelRoot) {
            DataModel: new DataDslExtractor().extractToString(modelRoot)
            ServiceModel: new ServiceDslExtractor().extractToString(modelRoot)
            Technology: new TechnologyDslExtractor().extractToString(modelRoot)
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

    def static PrimitiveType deriveIntType(String typeDesc) {
            return switch (typeDesc) {
                    case "int32": DATA_FACTORY.createPrimitiveInteger
                    case "int64": DATA_FACTORY.createPrimitiveLong
                    default: DATA_FACTORY.createPrimitiveInteger
           }
        }
    def static PrimitiveType deriveNumberType(String typeDesc) {
                return switch (typeDesc) {
                    case "float": DATA_FACTORY.createPrimitiveFloat
                    case "double": DATA_FACTORY.createPrimitiveDouble
                    default: DATA_FACTORY.createPrimitiveDouble
                }
        }
    def static PrimitiveType deriveStringType(String typeDesc) {
                return switch (typeDesc) {
                    case "byte": DATA_FACTORY.createPrimitiveString
                    case "binary": DATA_FACTORY.createPrimitiveString
                    case "date": DATA_FACTORY.createPrimitiveDate
                    case "date-time": DATA_FACTORY.createPrimitiveDate
                    case "password": DATA_FACTORY.createPrimitiveString
                    default: DATA_FACTORY.createPrimitiveString
                }
        }



}
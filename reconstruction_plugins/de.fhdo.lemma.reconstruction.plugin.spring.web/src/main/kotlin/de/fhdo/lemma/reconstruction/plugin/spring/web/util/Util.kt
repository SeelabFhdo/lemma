package de.fhdo.lemma.reconstruction.plugin.spring.web.util

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.util.getApplicationClazzFromAbstractParseTree
import de.fhdo.reconstruction.framework.modules.service.getServiceReconstructionFilesAndParseTrees
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import java.io.File

/**
 * Compare qualified names based on part separator and hierarchy level
 */
fun compareFullQualifiedNames(service: String, identifier: String, partSeparator: String, level: Int): Boolean {
    val serviceParts = service.split(partSeparator)
    val identifierParts = identifier.split(partSeparator)

    return serviceParts.subList(0, level) == identifierParts.subList(0, level)
}

internal fun getMicroserviceNameForInterface(path: String): String {
    val filesAndTrees = getServiceReconstructionFilesAndParseTrees()
    var tree = filesAndTrees.filter {
        path.startsWith(it.key.replaceAfterLast(File.separator, ""))
    }
    if (tree.isEmpty()) {
        tree = filesAndTrees.filter { path.startsWith(it.key.replaceAfterLast("/src/", "")) &&
                getApplicationClazzFromAbstractParseTree(it.value) !== null}
    }
    return getServiceNameFromParseTree(tree.values.first())
}

internal fun getMicroserviceNameForInterfaceOld(interfaceName: String): String {
    val filesAndTrees = getServiceReconstructionFilesAndParseTrees()
    filesAndTrees.forEach{
        val rootPackage = it.key.replaceAfterLast(File.separator, "")
        if (interfaceName.startsWith(rootPackage)) {
            val parseTree = it.value as JavaParseTree
            return getServiceNameFromParseTree(parseTree)
        }
    }
    return "unknown"
}

private fun getServiceNameFromParseTree(tree: AbstractParseTree): String {
    val parseTree = tree as JavaParseTree
    val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
        { !it.isInterface }.orElse(null)

    if (clazz != null && clazz.hasAnnotation("SpringBootApplication")) {
        return clazz.nameAsString
    }
    return "unknown"
}

internal fun testString() {
    val interfaceName = "/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/api"
    val serviceFile =  "/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/BookingServiceCommandApplication.java"
    val rootPackage = serviceFile.replaceAfterLast(File.separator, "")
    println()
}

internal fun testStringForImports() {
    val importName = "de.fhdo.puls.booking_service.common.commands.CreateParkBookingCommand"
    val serviceFile =  "/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/BookingServiceCommandApplication.java"
    val rootPackage = serviceFile.replaceAfterLast(File.separator, "")

    val root =
        println()

}
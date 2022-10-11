package de.fhdo.lemma.reconstruction.plugin.spring.web.service.`interface`

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.service.`interface`.ReconstructionInterfaceFactory
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.plugin.spring.web.util.getMicroserviceNameForInterface

internal fun findInterfaces(parseTree: JavaParseTree): List<AbstractReconstructionElement> {
    val reconstructionElements = mutableListOf<AbstractReconstructionElement>()
    val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
    { !it.isInterface }?.orElse(null)

    if (clazz != null && clazz.hasAnnotation("RestController")) {
        val interfaceName = "${clazz.getPackageName()}.${clazz.nameAsString}"
        val interFace = ReconstructionInterfaceFactory()
            .createInterface(interfaceName)
        val path = parseTree.compilationUnit.storage.get().directory.toString()

        interFace.microserviceName = getMicroserviceNameForInterface(path)
        interFace.version = "v01"
        interFace.visibility = "public"
        reconstructionElements.add(interFace)
    }
    return reconstructionElements
}

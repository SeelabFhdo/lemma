package de.fhdo.lemma.reconstruction.plugin.spring.web.service

import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.getJavaParseTree
import de.fhdo.lemma.reconstruction.plugin.spring.web.service.`interface`.findInterfaces
import de.fhdo.lemma.reconstruction.plugin.spring.web.service.microservice.findMicroservices
import de.fhdo.lemma.reconstruction.plugin.spring.web.service.operation.findOperations
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType

@ReconstructionModule(ReconstructionStage.Service)
class MicroserviceReconstruction : AbstractReconstructionModule() {

    override fun execute(abstractParseTree: AbstractParseTree): List<AbstractReconstructionElement> {
        val reconstructedElements = mutableListOf<AbstractReconstructionElement>()
        val parseTree = abstractParseTree as JavaParseTree
        reconstructedElements.addAll(findMicroservices(parseTree))
        reconstructedElements.addAll(findInterfaces(parseTree))
        reconstructedElements.addAll(findOperations(parseTree))
        return reconstructedElements
    }

    override fun getParseTree(path: String): Pair<ParsingResultType, AbstractParseTree> {
        return getJavaParseTree(path)
    }

    override fun getSupportFileExtensions() = listOf("java")
}
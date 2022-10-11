package de.fhdo.lemma.reconstruction.plugin.spring.data.domain

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.lemma.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.getJavaParseTree
import de.fhdo.lemma.reconstruction.plugin.spring.data.domain.context.findContext
import de.fhdo.lemma.reconstruction.plugin.spring.data.domain.data_structure.findDataStructure


@ReconstructionModule(ReconstructionStage.Domain)
class DomainReconstruction: AbstractReconstructionModule() {
    override fun execute(abstractParseTree: AbstractParseTree): List<AbstractReconstructionElement> {
        val parseTree = abstractParseTree as JavaParseTree
        val reconstructedElements = mutableListOf<AbstractReconstructionElement>()
        reconstructedElements.addAll(findContext(parseTree))
        reconstructedElements.addAll(findDataStructure(parseTree))
        return reconstructedElements
    }

    override fun getParseTree(path: String): Pair<ParsingResultType, AbstractParseTree> {
        return getJavaParseTree(path)
    }

    override fun getSupportFileExtensions() = listOf("java")
}


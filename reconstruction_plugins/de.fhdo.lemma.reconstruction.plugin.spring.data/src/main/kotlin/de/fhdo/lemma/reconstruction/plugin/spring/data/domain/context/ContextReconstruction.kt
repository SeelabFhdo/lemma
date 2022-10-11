package de.fhdo.lemma.reconstruction.plugin.spring.data.domain.context

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.domain.context.ReconstructionContextFactory
import de.fhdo.lemma.reconstruction.framework.modules.domain.context.checkContextForExistence
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.util.extractContextTerm

internal fun findContext(parseTree: JavaParseTree): List<AbstractReconstructionElement> {
    val reconstructionElements = mutableListOf<AbstractReconstructionElement>()

    val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
        { !it.isInterface }.orElse(null)

    if (clazz != null ) {
        if (clazz.hasAnnotation("SpringBootApplication")) {
            val contextName = clazz.nameAsString.extractContextTerm()
            val qualifiedContextName = "${clazz.getPackageName()}.${contextName.lowercase()}"
            val context = ReconstructionContextFactory().createContext(qualifiedContextName, contextName)
            if (!checkContextForExistence(context))
                reconstructionElements.add(context)
        }
    }
    return reconstructionElements
}


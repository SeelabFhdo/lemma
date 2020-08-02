package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.state

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import java.io.File

/**
 * Singleton to manage event groups and their interfaces.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object EventGroups {
    private const val PARENT_PACKAGE_NAME = "events"

    private val groupInterfaces = mutableListOf<ClassOrInterfaceDeclaration>()
    private val eventGroups = mutableMapOf<String, ClassOrInterfaceDeclaration>()

    /**
     * Reset Singleton
     */
    fun reset() {
        groupInterfaces.clear()
        eventGroups.clear()
    }

    /**
     * Add and retrieve a new event group interface or retrieve an existing one from the list of already created event
     * group interfaces for the given event [group] and [domainPackage]
     */
    fun addOrGetGroupInterface(group: String, domainPackage: String) : ClassOrInterfaceDeclaration {
        if (group in eventGroups)
            return eventGroups[group]!!

        val iface = newJavaClassOrInterface("$domainPackage.$PARENT_PACKAGE_NAME", "${group.capitalize()}EventGroup",
            true)
        eventGroups[group] = iface
        groupInterfaces.add(iface)
        return iface
    }

    /**
     * Get all created event group interfaces in the form of [GenletGeneratedNode] instances as expected by the Java
     * Base Generator
     */
    fun getGeneratedNodes() : Set<GenletGeneratedNode> {
        val generatedNodes = mutableSetOf<GenletGeneratedNode>()
        groupInterfaces.forEach { iface -> generatedNodes.add(
            GenletGeneratedNode(
                GenletPathSpecifier.CURRENT_DOMAIN_GENERATION_TARGET_PATH,
                "${PARENT_PACKAGE_NAME}${File.separator}${iface.nameAsString}.java",
                iface
            )
        ) }

        return generatedNodes
    }
}
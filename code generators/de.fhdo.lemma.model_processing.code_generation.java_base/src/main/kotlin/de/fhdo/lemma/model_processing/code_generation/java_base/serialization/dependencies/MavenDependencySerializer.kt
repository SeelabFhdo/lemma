package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies;

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.utils.countLines
import de.fhdo.lemma.model_processing.utils.isNumeric
import org.koin.core.KoinComponent
import org.redundent.kotlin.xml.Node
import org.redundent.kotlin.xml.PrintOptions
import org.redundent.kotlin.xml.TextElement
import org.redundent.kotlin.xml.XmlVersion
import org.redundent.kotlin.xml.node
import org.redundent.kotlin.xml.xml
import java.io.File
import java.util.regex.Pattern

/**
 * [DependencySerializerI] implementation for Maven's XML-based Project Object Models (POM). Delegates to
 * [MavenDependencySerializerBase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class MavenDependencySerializer(override val dependencyType: DependencyType = DependencyType.MAVEN)
    : DependencySerializerI<Node, Node> {
    private val delegate: MavenDependencySerializerBase = MavenDependencySerializerBase()

    /**
     * Build internal dependency model
     */
    override fun buildModel(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>)
        = delegate.buildModel(artifactIdentifier, dependencyDescriptions)

    /**
     * Serialize the given dependency model
     */
    override fun serialize(model: Node, targetFolderPath: String, targetFilePath: String)
        = delegate.serialize(model, targetFolderPath, targetFilePath)

    /**
     * Determine [DependencyFragmentProviderI] implementation to allow Genlets to add dependency fragments
     */
    override fun fragmentProviderClass() = delegate.fragmentProviderClass()

    /**
     * Add the provided dependency fragment to the given dependency model
     */
    override fun addFragment(model: Node, fragment: Node) = delegate.addFragment(model, fragment)
}

/**
 * [DependencySerializerI] implementation for Maven's XML-based Project Object Models (POM) that supports line counting.
 * Delegates to [MavenDependencySerializerBase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class CountingMavenDependencySerializer(override val dependencyType: DependencyType = DependencyType.MAVEN)
    : DependencySerializerI<Node, Node> {
    private val delegate: MavenDependencySerializerBase = MavenDependencySerializerBase()

    /**
     * Build internal dependency model
     */
    override fun buildModel(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>)
        = delegate.buildModel(artifactIdentifier, dependencyDescriptions)

    /**
     * Serialize the given dependency model and count the resulting lines
     */
    override fun serialize(model: Node, targetFolderPath: String, targetFilePath: String) : Pair<String, String> {
        val (serializationFilePath, generatedContent) = delegate.serialize(model, targetFolderPath, targetFilePath)
        MainState.addOrUpdateGeneratedLineCountInfo(
            LineCountInfo(serializationFilePath, generatedContent.countLines(forFile = serializationFilePath))
        )
        return serializationFilePath to generatedContent
    }

    /**
     * Determine [DependencyFragmentProviderI] implementation to allow Genlets to add dependency fragments
     */
    override fun fragmentProviderClass() = delegate.fragmentProviderClass()

    /**
     * Add the provided dependency fragment to the given dependency model
     */
    override fun addFragment(model: Node, fragment: Node) = delegate.addFragment(model, fragment)
}

/**
 * Reusable [DependencySerializerI] implementation for Maven's XML-based Project Object Models (POM).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class MavenDependencySerializerBase : KoinComponent {
    private val JAVA_VERSION = "12"
    private val DEFAULT_VERSION = "0.0.1-SNAPSHOT"
    private val VERSION_PATTERN = Pattern.compile(".*v(?<version>((\\p{Alnum}+_)+\\p{Alnum}+)|\\p{Alnum}+)")
    private val VALID_MAVEN_VERSION_PATTERN = Pattern.compile("\\p{Alnum}+(\\.\\p{Alnum}+){0,2}(-\\p{Alnum}+)*")

    /**
     * Build internal dependency model, i.e., the XML tree for the resulting pom.xml file
     */
    fun buildModel(artifactIdentifier : String, dependencyDescriptions : Set<DependencyDescription>) : Node {
        val (group, artifact, version) = DependencyDescription.fromString(artifactIdentifier)
        val root = createRoot()
        root merge projectIdentifier(group, artifact, version ?: DEFAULT_VERSION)
        root merge properties()

        if (dependencyDescriptions.isNotEmpty())
            root merge dependencies(dependencyDescriptions)

        root.addPlugins()

        return root
    }

    /**
     * Create the root of the XML tree
     */
    private fun createRoot() =
        xml("project", "UTF-8", XmlVersion.V10) {
            xmlns = "http://maven.apache.org/POM/4.0.0"

            attribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
            attribute(
                "xsi:schemaLocation",
                "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
            )

            "modelVersion" { -"4.0.0" }
        }

    /**
     * Create the project identifier as expected by the POM
     */
    private fun projectIdentifier(group: String, artifact: String, version: String) =
        elements {
            "groupId" { -group }
            "artifactId" { -artifact.toMavenArtifactId() }
            "version" { -if (version != DEFAULT_VERSION) version.toMavenVersion() else version }
        }

    /**
     * Helper to transform a String into a representation that is a valid Maven artifact ID. For instance, underscores
     * get replaced with dashes and all characters become lowercase.
     */
    private fun String.toMavenArtifactId() : String {
        var artifactId = ""

        val adjusted = trimStart('^').replace('_', '-')
        var previousChar: Char? = null
        for (currentChar in adjusted) {
            if (currentChar.isUpperCase() && previousChar != null && previousChar != '-')
                artifactId += "-"
            artifactId += currentChar.toLowerCase()
            previousChar = currentChar
        }

        return artifactId
    }

    /**
     * Helper to transform a String that starts with a "v" into a representation that is a valid Maven version. For
     * instance, underscores are replaced with dots and in case the version string's last fragment is not numeric, it is
     * appended to the Maven version with a dash. That is, the version string "v0_0_1_SNAPSHOT" becomes
     * "0.0.1-SNAPSHOT".
     */
    private fun String.toMavenVersion() : String {
        if (this.matches(VALID_MAVEN_VERSION_PATTERN.toRegex()))
            return this

        var versionId = ""
        val matcher = VERSION_PATTERN.matcher(this)
        if (matcher.matches()) {
            val versionParts = matcher.group("version").split("_")
            versionId = versionParts[0]
            for (i in 1 until versionParts.lastIndex)
                versionId += ".${versionParts[i]}"

            if (versionParts.size > 1) {
                versionId += if (!versionParts.last().isNumeric()) "-" else "."
                versionId += versionParts.last()
            }
        }
        return versionId
    }

    /**
     * Add pre-defined properties to the XML tree
     */
    private fun properties() =
        node("properties") {
            "project.build.sourceEncoding" { -"UTF-8" }
            "project.reporting.outputEncoding" { -"UTF-8" }
            "java.version" { -JAVA_VERSION }
            "maven.compiler.source" { -JAVA_VERSION }
            "maven.compiler.target" { -JAVA_VERSION }
        }

    /**
     * Create the dependencies-part of the XML tree as expected by the POM
     */
    private fun dependencies(dependencyDescriptions : Set<DependencyDescription>) : Node {
        val dependencyRoot = node("dependencies")
        dependencyDescriptions.forEach { dependencyRoot.addNode(dependency(it)) }
        return dependencyRoot
    }

    /**
     * Helper to transform a [DependencyDescription] instance into a POM-conforming XML dependency element
     */
    private fun dependency(dependencyDescription: DependencyDescription) : Node {
        val dependencyNode = node("dependency") {
            "groupId" { -dependencyDescription.group }
            "artifactId" { -dependencyDescription.artifact }
        }

        if (dependencyDescription.version != null)
            dependencyNode.addNode(
                node("version") { -dependencyDescription.version }
            )

        return dependencyNode
    }

    /**
     * Add pre-defined plugins to the XML tree
     */
    private fun Node.addPlugins() {
        this merge
            elements {
                "properties" {
                    "maven.compiler.plugin.version" { -"3.8.0" }
                }
            }

        this merge
            elements {
                "build" {
                    "plugins" {
                        "plugin" {
                            "groupId" { -"org.apache.maven.plugins" }
                            "artifactId" { -"maven-compiler-plugin" }
                            "version" { -"\${maven.compiler.plugin.version}" }
                        }
                    }
                }
            }
    }

    /**
     * Serialize the given dependency model
     */
    fun serialize(model: Node, targetFolderPath: String, targetFilePath: String) : Pair<String, String> {
        val serializationTargetFilePath = "$targetFolderPath${File.separator}$targetFilePath"
        val serializationModel = if (serializationTargetFilePath.asFile().exists()) {
            // In case the target file exists, we merge the dependency model created by us into it, so that manual
            // changes don't get lost during code generation
            val existingModel = XmlParser.parse(serializationTargetFilePath)
            if (existingModel != null) {
                existingModel.mergeWithModel(model)
                existingModel
            } else
                model
        } else
            model

        val generatedContent = serializationModel.toString(PrintOptions(singleLineTextElements = true))
        return serializationTargetFilePath to generatedContent
    }

    /**
     * Merge a dependency model, represented by its root [Node], into this [Node], which itself represents the root
     * [Node] of a dependency model
     */
    private fun Node.mergeWithModel(otherModel: Node) {
        mergeParentFromModel(otherModel)
        mergeRepositoriesFromOtherModel(otherModel)
        mergePropertiesFromModel(otherModel)
        mergeDependenciesFromModel(otherModel)
        mergePluginsFromModel(otherModel)
    }

    /**
     * Helper to merge the "parent" XML element (possibly added as a fragment by a Genlet) of the [otherModel] into this
     * [Node]
     */
    private fun Node.mergeParentFromModel(otherModel: Node) {
        val otherParentNode = otherModel.childNodes.find { it.nodeName == "parent" } ?: return
        val thisParentNode = childNodes.find { it.nodeName == "parent" }
        if (thisParentNode != null) {
            // If the "parent" XML element already exists, merge missing sub-nodes into it
            val thisSubNodes = thisParentNode.childNodes.map { it.nodeName }
            val missingSubNodes = otherParentNode.childNodes.filter { it.nodeName !in thisSubNodes }
            missingSubNodes.forEach { thisParentNode merge it }
        } else
            this merge otherParentNode
    }

    /**
     * Helper to merge the "repositories" XML element of the [otherModel] into this [Node]
     */
    private fun Node.mergeRepositoriesFromOtherModel(otherModel: Node) {
        val otherRepositoriesNode = otherModel.childNodes.find { it.nodeName == "repositories" } ?: return
        val thisRepositoriesNode = childNodes.find { it.nodeName == "repositories" }
        if (thisRepositoriesNode != null) {
            // If the "repositories" XML element already exists, merge missing sub-nodes into it
            val thisSubNodes = thisRepositoriesNode.childNodes.map { it.nodeName }
            val missingSubNodes = otherRepositoriesNode.childNodes.filter { it.nodeName !in thisSubNodes }
            missingSubNodes.forEach { thisRepositoriesNode merge it }
        } else
            this merge otherRepositoriesNode
    }

    /**
     * Helper to merge the "properties" XML element (cf. [properties]) of the [otherModel] into this [Node]
     */
    private fun Node.mergePropertiesFromModel(otherModel: Node) {
        val otherPropertiesNode = otherModel.childNodes.find { it.nodeName == "properties" } ?: return
        val thisPropertiesNode = childNodes.find { it.nodeName == "properties" }
        if (thisPropertiesNode != null) {
            // If the "properties" XML element already exists, merge missing sub-nodes into it
            val thisSubNodes = thisPropertiesNode.childNodes.map { it.nodeName }
            val missingSubNodes = otherPropertiesNode.childNodes.filter { it.nodeName !in thisSubNodes }
            missingSubNodes.forEach { thisPropertiesNode merge it }
        } else
            this merge otherPropertiesNode
    }

    /**
     * Helper to merge the "dependencies" XML element (cf. [dependencies]) of the [otherModel] into this [Node]
     */
    private fun Node.mergeDependenciesFromModel(otherModel: Node) {
        val otherDependenciesNode = otherModel.childNodes.find { it.nodeName == "dependencies" } ?: return
        val thisDependenciesNode = childNodes.find { it.nodeName == "dependencies" }
        if (thisDependenciesNode != null) {
            // If the "dependencies" XML element already exists, merge missing dependency nodes into it. Note that for
            // identifying missing dependency nodes, only their group and artifact IDs (not their versions) are used.
            val thisDependencies = thisDependenciesNode.childNodes.map {
                it.joinChildNodeValues("groupId", "artifactId")
            }
            val missingDependencies = otherDependenciesNode.childNodes
                .filter { it.joinChildNodeValues("groupId", "artifactId") !in thisDependencies }
            missingDependencies.forEach { thisDependenciesNode merge it }
        } else
            this merge otherDependenciesNode
    }

    /**
     * Helper to join the text values of child nodes of this [Node]. For instance, calling this function on an XML node
     * such as
     *      <foo>
     *          <bar>text1</bar>
     *          <baz>text2</baz>
     *      </foo>
     * will result in "text1:text2".
     */
    private fun Node.joinChildNodeValues(vararg filterNodeNames: String)
        = childNodes
            .filter { if (filterNodeNames.isNotEmpty()) it.nodeName in filterNodeNames else true }
            .joinToString(":") { child -> (child.children.find { it is TextElement } as? TextElement)?.text ?: "" }

    /**
     * Helper to merge the "plugins" XML element (cf. [addPlugins]) of the [otherModel] into this [Node]
     */
    private fun Node.mergePluginsFromModel(otherModel: Node) {
        val otherBuildNode = otherModel.childNodes.find { it.nodeName == "build" } ?: return
        val otherPluginsNode = otherBuildNode.childNodes.find { it.nodeName == "plugins" } ?: return

        val thisBuildNode = childNodes.find { it.nodeName == "build" }
        val thisPluginsNode = thisBuildNode?.childNodes?.find { it.nodeName == "plugins" }
        when {
            // If the "plugins" XML element already exists, merge missing plugin nodes into it
            thisPluginsNode != null -> {
                val thisPlugins = thisPluginsNode.childNodes.map {
                    it.joinChildNodeValues("groupId", "artifactId", "version")
                }
                val missingPlugins = otherPluginsNode.childNodes
                    .filter { it.joinChildNodeValues("groupId", "artifactId", "version") !in thisPlugins }
                missingPlugins.forEach { thisPluginsNode merge it }
            }
            // If the parent "build" XML element (which is the parent element of the "plugin" element according to the
            // POM) does not exist, merge it completely and implicitly create the "plugin" element
            thisBuildNode != null -> thisBuildNode merge otherBuildNode

            // The "build" XML element exists, but the "plugin" element does not yet
            else -> this merge otherBuildNode
        }
    }

    /**
     * Determine [DependencyFragmentProviderI] implementation
     */
    fun fragmentProviderClass() = MavenDependencyFragmentProviderI::class.java

    /**
     * Add the provided dependency fragment to the given dependency model
     */
    fun addFragment(model: Node, fragment: Node) : Node {
        model merge fragment
        return model
    }
}

/**
 * Maven-specific [DependencyFragmentProviderI] implementation to be used by Genlets for providing fragments to a
 * generated POM file.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface MavenDependencyFragmentProviderI :
    DependencyFragmentProviderI<Node, Node> {
    override fun dependencyType() = DependencyType.MAVEN
}
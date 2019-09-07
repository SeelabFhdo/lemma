package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies;

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
import org.redundent.kotlin.xml.XmlVersion
import org.redundent.kotlin.xml.node
import org.redundent.kotlin.xml.xml
import java.io.File
import java.util.regex.Pattern

internal class MavenDependencySerializer(override val dependencyType: DependencyType = DependencyType.MAVEN)
    : DependencySerializerI<Node, Node> {
    private val delegate: MavenDependencySerializerBase = MavenDependencySerializerBase()

    override fun buildModel(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>)
        = delegate.buildModel(artifactIdentifier, dependencyDescriptions)

    override fun serialize(model: Node, targetFolderPath: String, targetFilePath: String)
        = delegate.serialize(model, targetFolderPath, targetFilePath)

    override fun fragmentProviderClass() = delegate.fragmentProviderClass()

    override fun addFragment(model : Node, fragment : Node) = delegate.addFragment(model, fragment)
}

internal class CountingMavenDependencySerializer(override val dependencyType: DependencyType = DependencyType.MAVEN)
    : DependencySerializerI<Node, Node> {
    private val delegate: MavenDependencySerializerBase = MavenDependencySerializerBase()

    override fun buildModel(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>)
        = delegate.buildModel(artifactIdentifier, dependencyDescriptions)

    override fun serialize(model: Node, targetFolderPath: String, targetFilePath: String) : Pair<String, String> {
        val (serializationFilePath, generatedContent) = delegate.serialize(model, targetFolderPath, targetFilePath)
        MainState.addOrUpdateGeneratedLineCountInfo(LineCountInfo(serializationFilePath, generatedContent.countLines()))
        return serializationFilePath to generatedContent
    }

    override fun fragmentProviderClass() = delegate.fragmentProviderClass()

    override fun addFragment(model : Node, fragment : Node) = delegate.addFragment(model, fragment)
}

private class MavenDependencySerializerBase : KoinComponent {
    private val DEFAULT_VERSION = "0.0.1-SNAPSHOT"
    private val VERSION_PATTERN = Pattern.compile(".*v(?<version>((\\p{Alnum}+_)+\\p{Alnum}+)|\\p{Alnum}+)")

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

    private fun createRoot() =
        xml("project", "UTF-8", XmlVersion.V10) {
            xmlns="http://maven.apache.org/POM/4.0.0"

            attribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
            attribute(
                "xsi:schemaLocation",
                "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
            )

            "modelVersion" { -"4.0.0" }
        }

    private fun projectIdentifier(group: String, artifact: String, version: String) =
        elements {
            "groupId" { -group }
            "artifactId" { -artifact.toMavenArtifactId() }
            "version" { -if (version != DEFAULT_VERSION) version.toMavenVersionId() else version }
        }

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

    private fun String.toMavenVersionId() : String {
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

    private fun properties() =
        node("properties") {
            "project.build.sourceEncoding" { -"UTF-8" }
            "project.reporting.outputEncoding" { -"UTF-8" }
            "java.version" { -"12" }
        }

    private fun dependencies(dependencyDescriptions : Set<DependencyDescription>) : Node {
        val dependencyRoot = node("dependencies")
        dependencyDescriptions.forEach {
            dependencyRoot.addNode(dependency(it))
        }
        return dependencyRoot
    }

    private fun dependency(dependencyDescription: DependencyDescription) : Node {
        val dependencyNode = node("dependency") {
            "groupId" { -dependencyDescription.group }
            "artifactId" { -dependencyDescription.artifact }
        }

        if (dependencyDescription.version != null)
            dependencyNode.addNode(
                node("version") { dependencyDescription.version }
            )

        return dependencyNode
    }

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

    fun serialize(model : Node, targetFolderPath : String, targetFilePath : String) : Pair<String, String> {
        val serializationTargetFilePath = "$targetFolderPath${File.separator}$targetFilePath"
        val generatedContent = model.toString(PrintOptions(singleLineTextElements = true))
        return serializationTargetFilePath to generatedContent
    }

    fun fragmentProviderClass() = MavenDependencyFragmentProviderI::class.java

    fun addFragment(model : Node, fragment : Node) : Node {
        model merge fragment
        return model
    }
}

interface MavenDependencyFragmentProviderI :
    DependencyFragmentProviderI<Node, Node> {
    override fun dependencyType() = DependencyType.MAVEN
}
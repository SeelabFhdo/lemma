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
        val (targetFilePath, generatedContent) = delegate.serialize(model, targetFolderPath, targetFilePath)
        MainState.addGeneratedLineCountInfo(LineCountInfo(targetFilePath, generatedContent.countLines()))
        return targetFilePath to generatedContent
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
        root merge projectIdentifier(group, artifact, if (version !== null) version else DEFAULT_VERSION)
        return root
    }

    fun serialize(model : Node, targetFolderPath : String, targetFilePath : String) : Pair<String, String> {
        val targetFilePath = "$targetFolderPath${File.separator}$targetFilePath"
        val generatedContent = model.toString(PrintOptions(singleLineTextElements = true))
        return targetFilePath to generatedContent
    }

    fun fragmentProviderClass() = MavenDependencyFragmentProviderI::class.java

    fun addFragment(model : Node, fragment : Node) : Node {
        model merge fragment
        return model
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
            "version" { -if (version !== DEFAULT_VERSION) version.toMavenVersionId() else version }
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
}

interface MavenDependencyFragmentProviderI :
    DependencyFragmentProviderI<Node, Node> {
    override fun dependencyType() = DependencyType.MAVEN
}
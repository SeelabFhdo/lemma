package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import java.io.File
import java.io.FileInputStream
import java.io.StringWriter
import java.util.Properties

/**
 * Represents a property file in Java's
 * [properties format](https://docs.oracle.com/javase/10/docs/api/java/util/Properties.html#load(java.io.Reader).
 * Essentially, this class assigns a [filePath] to a [Properties] instance and provides convenience, yet restricted,
 * access to the latter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class PropertyFile(val filePath: String, private val properties: SortableProperties) {
    companion object {
        /**
         * Load a [PropertyFile] at the specified [filePath]
         */
        internal fun loadFromFilePath(filePath: String) : PropertyFile {
            val properties = SortableProperties()
            properties.load(FileInputStream(filePath))
            return PropertyFile(filePath, properties)
        }
    }

    /**
     * Iterate over the entries of the [PropertyFile]
     */
    fun forEach(action: (String, String) -> Unit) {
        properties.forEach { (key, value) -> action(key as String, value as String) }
    }

    /**
     * Assign a new [propertyValue] String to the property named [propertyName]
     */
    operator fun set(propertyName: String, propertyValue: String) : String?
        = properties.setProperty(propertyName, propertyValue) as? String

    /**
     * Determine if this [PropertyFile] contains a property named [propertyName]
     */
    operator fun contains(propertyName: String) = properties.containsKey(propertyName)

    /**
     * Get the value String of the property named [propertyName] of this [PropertyFile] or null, if the property does
     * not exist in the file
     */
    operator fun get(propertyName: String) : String? = properties.getProperty(propertyName)

    /**
     * Serialize the property file. Note, that we are not relying directly on the store() method of the [Properties]
     * class (cf. [toString]).
     */
    internal fun serialize() : Int {
        val targetFile = filePath.asFile()
        targetFile.parentFile?.mkdirs()

        val thisContent = toString().lines().toMutableList()
        thisContent.insertCommentsFromExistingFile(targetFile)
        val serializedText = thisContent.joinToString("\n")
        targetFile.writeText(serializedText)
        return serializedText.length
    }

    /**
     * Helper to insert comments from a possibly existing property [file] to this [MutableList] instance
     */
    private fun MutableList<String>.insertCommentsFromExistingFile(file: File) {
        if (!file.exists())
            return

        val existingLines = file.readLines()
        var currentLineIndex = 0
        while (currentLineIndex < existingLines.size) {
            val currentLine = existingLines[currentLineIndex]

            if (currentLine.startsWith("#")) {
                // Preserve existing comments at their indices. However, in case properties got added by the user
                // without obeying to the alphabetical order of the properties, related comments will appear at the
                // wrong position. Currently, we accept this behavior, because we cannot tell from a comment if it
                // belongs to a subsequent property or not.
                if (currentLineIndex < size)
                    add(currentLineIndex, currentLine)
                else
                    add(currentLine)
            }

            currentLineIndex++
        }
    }

    /**
     * Obtain a String representation of this [PropertyFile]. Instead of using the store() method of the [Properties]
     * class for that purpose, we employ a [StringWriter] to obtain the content of the property file as a String. This
     * allows to, e.g., remove the creation information comment produced by store().
     */
    override fun toString() : String {
        val writer = StringWriter()
        properties.store(writer, null)
        var fileContent = writer.toString()
        return if (fileContent.startsWith("#"))
                fileContent.lines().drop(1).joinToString("\n")
            else
                fileContent
    }

    /**
     * Two [PropertyFile] instances are equal, if their [filePath] values are equal
     */
    override fun equals(other: Any?)
        = when {
            this === other -> true
            other == null -> false
            other !is PropertyFile -> false
            else -> filePath == other.filePath
        }

    /**
     * The hash code of a [PropertyFile] is equal to the hash code of its [filePath]
     */
    override fun hashCode() = filePath.hashCode()
}

/**
 * Store to keep track of all [PropertyFile] references being opened leveraging one of the [openPropertyFile] methods.
 * This allows for performing bulk actions like [serializeOpenedPropertyFiles] or [closeOpenedPropertyFiles] on all
 * property files produced during code generation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object OpenedPropertyFiles {
    val propertyFiles = mutableSetOf<PropertyFile>()

    /**
     * Add the given [propertyFile] to the store or replace it, if it already exists
     */
    fun addOrReplace(propertyFile: PropertyFile) {
        propertyFiles.remove(propertyFile)
        propertyFiles.add(propertyFile)
    }

    /**
     * Get the [PropertyFile] with the given [filePath] from the store
     */
    operator fun get(filePath: String) = propertyFiles.find { it.filePath == filePath }
}

/**
 * Open the property file at the given [filePath]. If the path does not represent an existing property file, a new
 * [PropertyFile] instance is created. In any case, the [PropertyFile] instance is stored in the [OpenedPropertyFiles].
 * These instances are reused upon calling this function, i.e., if the [OpenedPropertyFiles] contains an instance for
 * the given [filePath] it is returned by the function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun openPropertyFile(filePath: String) : PropertyFile {
    val propertyFile = OpenedPropertyFiles[filePath] ?:
        if (filePath.asFile().exists())
            PropertyFile.loadFromFilePath(filePath)
        else
            PropertyFile(filePath, SortableProperties())

    OpenedPropertyFiles.addOrReplace(propertyFile)
    return propertyFile
}

/**
 * Open a property file named [filename] at the given [folderPath].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun openPropertyFile(folderPath: String, filename: String)
    = openPropertyFile("$folderPath${File.separator}$filename")

/**
 * Open a property file named [filename] at the location represented by a [genletPathSpecifier]. Thus, this function
 * can be used by Genlets to generate property files.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun openPropertyFile(genletPathSpecifier: GenletPathSpecifier, filename: String) : PropertyFile {
    val filePath = "${GenletPathSpecifier.resolvePathSpecifier(genletPathSpecifier)}${File.separator}$filename"
    return PropertyFile(filePath, SortableProperties())
}

/**
 * Merge the given [propertyFile] into an existing one stored by [OpenedPropertyFiles]. By merging we mean that values
 * of the given [propertyFile] override values at the same key in the existing file.
 *
 * The [PropertyFile] instance returned by this function is always different than the passed [propertyFile]. If the
 * [propertyFile] does not exist in the [OpenedPropertyFiles], a new instance is created and stored in the
 * [OpenedPropertyFiles].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun mergePropertyFile(propertyFile: PropertyFile) : PropertyFile {
    val targetPropertyFile = openPropertyFile(propertyFile.filePath)
    propertyFile.forEach { key, value -> targetPropertyFile[key] = value }
    return targetPropertyFile
}

/**
 * Serialize all [OpenedPropertyFiles] at once.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun serializeOpenedPropertyFiles() {
    val writeLineCountInfo: Boolean by MainState
    OpenedPropertyFiles.propertyFiles.forEach {
        val lineCount = it.serialize()
        if (writeLineCountInfo)
            MainState.addOrUpdateGeneratedLineCountInfo(LineCountInfo(it.filePath, lineCount))
    }
}

/**
 * Close all [OpenedPropertyFiles]. Effectively, this corresponds to clearing the [OpenedPropertyFiles] store.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun closeOpenedPropertyFiles() = OpenedPropertyFiles.propertyFiles.clear()
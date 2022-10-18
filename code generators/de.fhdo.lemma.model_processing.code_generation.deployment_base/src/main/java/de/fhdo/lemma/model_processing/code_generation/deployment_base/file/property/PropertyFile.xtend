package de.fhdo.lemma.model_processing.code_generation.deployment_base.file.property

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.StringWriter
import java.util.function.BiConsumer
import java.nio.file.Files
import java.nio.file.Paths
import java.io.File
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Represents a property file in Java's
 * properties format(https://docs.oracle.com/javase/10/docs/api/java/util/Properties.html
 * #load(java.io.Reader). Essentially, this class assigns a filePath to a Properties instance
 * and provides convenience, yet restricted, access to the latter.
 *
 * This class is a translation from the PropertyFile Kotlin class in the Java Base Generator,
 * done by the coauthor.
 * //TODO Merge the Kotlin and Xtend implementation into a common jar archive.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 * @coauthor <a href="mailto:Florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class PropertyFile {
    @Accessors(PUBLIC_GETTER)
    val String filePath
    val SortableProperties properties

    /**
     * Constructor for creating a PropertyFile based on a filepath.
     */
    new(String filePath) {
        this.filePath = filePath
        properties = new SortableProperties
    }

    /**
     * Constructor for creating a PropertyFile based on a filepath and SortableProperties.
     */
    new(String filepath, SortableProperties properties) {
        this.filePath = filepath
        this.properties = properties
    }

    /**
     * Load a PropertyFile at the specified filePath.
     */
    static def PropertyFile loadFromFilePath(String filePath) {
        val loadedPropertiers = new SortableProperties()
        val reader = Files.newBufferedReader(Paths.get(filePath))
        loadedPropertiers.load(reader)
        return new PropertyFile(filePath, loadedPropertiers)
    }

    /**
     * Assign a new propertyValue String to the property named propertyName.
     */
    def set(String propertyName, String propertyValue) {
        properties.setProperty(propertyName, propertyValue)
    }

    /**
     * Determine if this PropertyFile contains a property named propertyName.
     */
    def boolean contains(String propertyName) {
        properties.containsKey(propertyName)
    }

    /**
     * Get the value String of the property named propertyName of this PropertyFile or null,
     * if the property does not exist in the file
     */
    def String get(String propertyName) {
        properties.getProperty(propertyName)
    }

    /**
     * Serialize the property file. Note, that we are not relying directly on the store() method
     * of the Properties class (cf. toString).
     */
    def int serialize() {
        var file = new File(filePath)
        file.parentFile.mkdirs
        val writer = new BufferedWriter(new FileWriter(filePath))
        var thisContent = toString.lines.toArray
        val serializedText = thisContent.join("\n")
        writer.write(serializedText.replace("\\", ""))
        writer.close
        return serializedText.length
    }

    /**
     * Obtain a String representation of this PropertyFile. Instead of using the store() method of
     * the Properties class for that purpose, we employ a StringWriter to obtain the content of
     * the property file as a String. This allows to, e.g., remove the creation information comment
     * produced by store().
     */
    override String toString() {
        val writer = new StringWriter()
        properties.store(writer, null)
        var fileContent = writer.toString()
        return fileContent.withoutFirstLine
    }

    /**
     * Remove the first line of the contents of a file
     */
    private def withoutFirstLine(String fileContent) {
        var String[] lines = fileContent.split(System.getProperty("line.separator"))
        lines.drop(1).join(System.getProperty("line.separator"))
    }

    /**
     * Iterate over the entries of the PropertyFile
     */
    def forEach(BiConsumer<? super Object, ? super Object> action) {
        properties.entrySet.forEach[entry |
            action.accept(entry.key, entry.value)]
    }

    /**
     * The hash code of a PropertyFile is equal to the hash code of its filePath
     */
    override hashCode() {
        filePath.hashCode
    }

    /**
     * Compare two PropertyFiles based on their file
     */
    override equals(Object object) {
       if (object === null || !(object instanceof PropertyFile))
          return false

        return filePath == (object as PropertyFile).filePath
    }

    /**
     * Build Spring-based application.properties file
     */
    def String buildPropertyFile() {
        val stringBuild = new StringBuilder
        properties.forEach[key, value |
            val property = '''«key»=«value»'''
            stringBuild.append(property + "\n")
        ]
        return stringBuild.toString
    }
}
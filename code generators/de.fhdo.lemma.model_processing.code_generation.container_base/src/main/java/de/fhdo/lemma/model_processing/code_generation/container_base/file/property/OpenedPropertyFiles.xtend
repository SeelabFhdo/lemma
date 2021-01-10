package de.fhdo.lemma.model_processing.code_generation.container_base.file.property

import java.io.File
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class manages several different application.properties files, used in the spring framework.
 * The class is implemented by the usage of the singleton design pattern.
 *
 * This class is a translation from the PropertyFile Kotlin class in the Java Base Generator,
 * done by the coauthor.
 * TODO Merge the Kotlin and Xtend implementation into a common jar archive.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 * @coauthor <a href="mailto:Florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class OpenedPropertyFiles {
    static OpenedPropertyFiles instance
    @Accessors(PUBLIC_GETTER)
    val propertyFiles = <PropertyFile> newHashSet

    static def OpenedPropertyFiles getInstance() {
        if (instance === null)
            instance = new OpenedPropertyFiles

        return instance
    }

    /**
     * Add the given propertyFile to the store or replace it, if it already exists
     */
    def add(PropertyFile propertyFile) {
        propertyFiles.add(propertyFile)
    }

    /**
     * Get the PropertyFile with the given filePath from the store
     */
    def PropertyFile get() {
        propertyFiles.findFirst[it.filePath == filePath]
    }

    /**
     * Open the property file at the given filePath. If the path does not represent an existing
     * property file, a new PropertyFile instance is created. In any case, the PropertyFile
     * instance is stored in the OpenedPropertyFiles. These instances are reused upon calling this
     * function, i.e., if the OpenedPropertyFiles contains an instance for the given filePath it
     * is returned by the function.
     */
    def PropertyFile openPropertyFile(String filePath) {
        val propertyFile = propertyFiles.findFirst[f | f.filePath == filePath]

        return switch(propertyFile) {
            case propertyFile !== null: propertyFile
            case new File(filePath).length > 0: PropertyFile.loadFromFilePath(filePath)
            default: new PropertyFile(filePath, new SortableProperties)
        }
    }

    /**
     * Open a property file named filename at the given folderPath.
     */
    def PropertyFile openPropertyFile(String folderPath, String filename) {
        openPropertyFile('''«folderPath»«File.separator»«filename»''')
    }

    /**
     * Merge the given propertyFile into an existing one stored by OpenedPropertyFiles.
     * By merging we mean that values of the given propertyFile override values at the same key in
     * the existing file.
     *
     * The PropertyFile instance returned by this function is always different than the passed
     * propertyFile. If the propertyFile does not exist in the OpenedPropertyFiles, a new
     * instance is created and stored in the OpenedPropertyFiles.
     */
    def PropertyFile mergePropertyFile(PropertyFile propertyFile) {
        val targetPropertyFile = openPropertyFile(propertyFile.filePath)

        propertyFile.forEach [key, value |
            targetPropertyFile.set(key.toString, value.toString)]

        return targetPropertyFile
    }

    /**
     * Serialize all OpenedPropertyFiles at once.
     */
    def serializeOpenedPropertyFiles() {
        propertyFiles.forEach [file | file.serialize]
    }

    /**
     * Close all OpenedPropertyFiles. Effectively, this corresponds to clearing the
     * OpenedPropertyFiles store.
     */
    def closeOpenedPropertyFiles() {
        propertyFiles.clear
    }
}
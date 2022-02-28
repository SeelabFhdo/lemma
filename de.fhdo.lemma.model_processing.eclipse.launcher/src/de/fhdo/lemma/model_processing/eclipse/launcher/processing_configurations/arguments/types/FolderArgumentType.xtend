package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import java.nio.file.Files
import java.nio.file.Paths
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Type of arguments representing existing folders.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class FolderArgumentType extends AbstractArgumentType {
    public static val IDENTIFIER = ArgumentTypeIdentifier.FOLDER

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Folder")
    }

    /**
     * Validate the type-specific argument value in its internal representation, i.e., the path to
     * the folder
     */
    final override validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String folderPath
    ) {
        if (folderPath.nullOrEmpty)
            throw new IllegalArgumentException("Please select a folder")
        else if (!Files.isDirectory(Paths.get(folderPath)))
            throw new IllegalArgumentException('''Folder "«folderPath»" does not exist''')
    }
}
package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import java.nio.file.Files
import java.nio.file.Paths
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Type of arguments representing existing, regular files.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class FileArgumentType extends AbstractArgumentType {
    public static val IDENTIFIER = ArgumentTypeIdentifier.FILE

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "File")
    }

    /**
     * Validate the type-specific argument value in its internal representation, i.e., the path to
     * the file
     */
    final override validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String filepath
    ) {
        if (filepath.nullOrEmpty)
            throw new IllegalArgumentException("Please select a file")
        else if (!Files.isRegularFile(Paths.get(filepath)))
            throw new IllegalArgumentException('''File "«filepath»" does not exist''')
    }
}
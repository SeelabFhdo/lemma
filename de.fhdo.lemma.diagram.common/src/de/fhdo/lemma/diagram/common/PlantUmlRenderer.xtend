package de.fhdo.lemma.diagram.common

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit

/**
 * Renders a PlantUML file into an image by running PlantUML.
 *
 * PlantUML is run as a command rather than linked as a library: the jar is some
 * twelve megabytes, third-party jars in this repository are resolved by Maven
 * rather than committed, and a research repository is the wrong place for a
 * binary that large. The cost is that the command has to be installed, which is
 * why its absence is reported as a condition to fix and not as a failure of the
 * model.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class PlantUmlRenderer {
    /**
     * Vector output: it scales in a PDF and its text stays selectable, which is
     * what a diagram in a thesis needs.
     */
    static val FORMAT = "-tsvg"
    static val IMAGE_EXTENSION = "svg"

    static val ENVIRONMENT_VARIABLE = "PLANTUML"

    /**
     * Where the command is looked for when the environment does not say.
     *
     * An Eclipse started from the Finder inherits a minimal PATH that holds
     * neither Homebrew prefix, so looking only there would find nothing however
     * well PlantUML is installed.
     */
    static val CANDIDATES = #[
        "/opt/homebrew/bin/plantuml",
        "/usr/local/bin/plantuml",
        "/usr/bin/plantuml"
    ]

    static val TIMEOUT_SECONDS = 120L

    val String executable

    new() {
        executable = findExecutable
    }

    /**
     * Whether an image can be rendered at all.
     */
    def boolean isAvailable() {
        return executable !== null
    }

    /**
     * What to do when it is not.
     */
    def String installationHint() {
        return "PlantUML was not found, so only the .puml files were written. "
            + "Install it with \"brew install plantuml graphviz\", or set the "
            + ENVIRONMENT_VARIABLE + " environment variable to the executable, "
            + "and generate again."
    }

    /**
     * Render a PlantUML file into an image beside it.
     *
     * @param source the .puml file to render
     * @return the image that was written
     * @throws IllegalStateException if PlantUML failed, with what it reported
     */
    def Path render(Path source) {
        if (!available) {
            throw new IllegalStateException(installationHint)
        }

        val process = new ProcessBuilder(executable, FORMAT, source.toString)
            .directory(source.parent.toFile)
            .redirectErrorStream(true)
            .start
        val output = new String(process.inputStream.readAllBytes, StandardCharsets.UTF_8)

        if (!process.waitFor(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
            process.destroyForcibly
            throw new IllegalStateException(
                '''PlantUML did not finish within «TIMEOUT_SECONDS» seconds'''.toString)
        }
        if (process.exitValue !== 0) {
            // PlantUML reports a missing Graphviz here, which is the likeliest
            // cause and worth passing on verbatim rather than summarising.
            throw new IllegalStateException(
                '''PlantUML failed: «output.trim»'''.toString)
        }

        val image = imageOf(source)
        if (!Files.exists(image)) {
            throw new IllegalStateException(
                '''PlantUML wrote no «IMAGE_EXTENSION»«IF !output.trim.empty»: «output.trim»«ENDIF»'''
                    .toString)
        }
        return image
    }

    /**
     * The image PlantUML writes for a source file: the same name, its own
     * extension, in the same folder.
     */
    private def Path imageOf(Path source) {
        val name = source.fileName.toString
        val separator = name.lastIndexOf(".")
        val base = if (separator > 0) name.substring(0, separator) else name
        return source.parent.resolve('''«base».«IMAGE_EXTENSION»'''.toString)
    }

    /**
     * The PlantUML command, or null when there is none.
     */
    private def String findExecutable() {
        val configured = System.getenv(ENVIRONMENT_VARIABLE)
        if (configured !== null && executableAt(configured)) {
            return configured
        }

        val path = System.getenv("PATH")
        if (path !== null) {
            for (entry : path.split(File.pathSeparator)) {
                val candidate = entry + File.separator + "plantuml"
                if (executableAt(candidate)) {
                    return candidate
                }
            }
        }

        for (candidate : CANDIDATES) {
            if (executableAt(candidate)) {
                return candidate
            }
        }
        return null
    }

    private def boolean executableAt(String path) {
        val file = new File(path)
        return file.isFile && file.canExecute
    }
}

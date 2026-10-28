package de.fhdo.lemma.reconstruction.test

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator
import de.fhdo.lemma.reconstruction.io.ReconstructionModelWriter
import de.fhdo.lemma.reconstruction.service.LemmaServiceGenerator
import de.fhdo.lemma.reconstruction.service.Microservice
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.ArrayList
import java.util.Arrays
import java.util.List
import java.util.stream.Collectors

/**
 * Regression test for the generation of LEMMA models from reconstructed
 * architecture information.
 *
 * The test replaces the database by a fixture: a JSON file holding exactly the
 * documents the Microservice Reconstruction Framework writes to MongoDB for a
 * known system. It runs the same generators and the same writer as the
 * reconstruction wizard and compares the resulting domain and service models
 * against models that were reviewed and accepted before.
 *
 * Run it from the IDE with "Run As -> Java Application". No database and no
 * running Eclipse application are needed.
 *
 * <pre>
 * test/
 *   fixtures/&lt;system&gt;/documents.json        the input, exported from MRF
 *   expected/&lt;system&gt;/domain/*.data         the accepted domain models
 *   expected/&lt;system&gt;/service/*.services    the accepted service models
 *   expected/&lt;system&gt;/technology/*.technology  copied, not compared
 * </pre>
 *
 * Arguments:
 * <ul>
 *   <li><code>--update</code> writes the generated models to the expected
 *       folder instead of comparing them. Never pass it to make a failing test
 *       pass: read the diff first and accept the new models deliberately.</li>
 *   <li>a path replacing the default test folder <code>test</code></li>
 * </ul>
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReconstructionRegressionTest {
    static val MAPPER = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    /**
     * Folder the technology models are copied into, beside the generated ones.
     * The generators build their imports from the same name.
     */
    static val TECHNOLOGY_FOLDER = "technology"

    def static void main(String[] args) {
        val arguments = Arrays.asList(args)
        val update = arguments.contains("--update")
        val testFolder = Paths.get(
            arguments.findFirst[!startsWith("--")] ?: "test")

        val fixtures = testFolder.resolve("fixtures")
        if (!Files.isDirectory(fixtures)) {
            System.err.println('''No fixtures found in «fixtures.toAbsolutePath».''')
            System.exit(2)
        }

        var failed = 0
        for (fixture : listDirectories(fixtures)) {
            if (!runFixture(fixture, testFolder, update)) {
                failed = failed + 1
            }
        }

        if (update) {
            println("Expected models updated. Review them before committing.")
        } else if (failed > 0) {
            System.err.println('''«failed» system(s) differ from the expected models.''')
            System.exit(1)
        } else {
            println("All systems match their expected models.")
        }
    }

    /**
     * Generate the models of a single system and compare them against the
     * expected ones. Returns whether the system matched.
     */
    private def static boolean runFixture(Path fixture, Path testFolder, boolean update) {
        val system = fixture.fileName.toString
        println('''=== «system» ===''')

        val documents = MAPPER.readTree(fixture.resolve("documents.json").toFile)
        val actualFolder = if (update)
                testFolder.resolve("expected").resolve(system)
            else
                Files.createTempDirectory("lemma-reconstruction-" + system)

        generateModels(documents, actualFolder)

        if (update) {
            println('''    written to «actualFolder.toAbsolutePath»''')
            return true
        }

        val expectedFolder = testFolder.resolve("expected").resolve(system)
        if (!Files.isDirectory(expectedFolder)) {
            System.err.println('''    no expected models yet - run with --update''')
            return false
        }
        return compareFolders(expectedFolder, actualFolder)
    }

    /**
     * Run both generators over the documents of a system and write the
     * resulting models the way the reconstruction wizard writes them.
     */
    private def static void generateModels(JsonNode documents, Path targetFolder) {
        val target = targetFolder.toAbsolutePath.toString

        // A generated model imports its technology model relative to itself, so
        // the models have to sit beside it here as well - the wizard copies
        // them for the folder it writes to, and this is that folder.
        ReconstructionModelWriter.copyTechnologyModels(target, TECHNOLOGY_FOLDER)

        documents.get("context")?.forEach[
            val context = MAPPER.treeToValue(it, Context)
            val model = new LemmaDomainGenerator().generateDataModel(context)
            ReconstructionModelWriter.writeDataModel(model, target)
        ]

        val microservices = newArrayList
        documents.get("microservice")?.forEach[
            microservices.add(MAPPER.treeToValue(it, Microservice))
        ]
        microservices.forEach[
            // One generator per microservice: a generator collects all of its
            // microservices in a single service model. Every microservice is
            // handed over all the same, because what one requires of another is
            // resolved against the callee's interfaces and operations.
            val model = new LemmaServiceGenerator().generateModelFrom(it,
                TECHNOLOGY_FOLDER, microservices)
            ReconstructionModelWriter.writeServiceModel(model, target)
        ]
    }

    /**
     * Compare every expected model against the generated one and report the
     * first difference per file.
     */
    private def static boolean compareFolders(Path expectedFolder, Path actualFolder) {
        var matched = true

        for (expectedFile : listModels(expectedFolder)) {
            val relative = expectedFolder.relativize(expectedFile)
            val actualFile = actualFolder.resolve(relative)

            if (!Files.isRegularFile(actualFile)) {
                System.err.println('''    MISSING  «relative» was not generated''')
                matched = false
            } else {
                val expected = readLines(expectedFile)
                val actual = readLines(actualFile)
                val difference = firstDifference(expected, actual)
                if (difference === null) {
                    println('''    ok       «relative»''')
                } else {
                    System.err.println('''    CHANGED  «relative»''')
                    System.err.println(difference)
                    System.err.println('''             generated model: «actualFile»''')
                    matched = false
                }
            }
        }

        for (actualFile : listModels(actualFolder)) {
            val relative = actualFolder.relativize(actualFile)
            if (!Files.isRegularFile(expectedFolder.resolve(relative))) {
                System.err.println('''    NEW      «relative» has no expected model''')
                matched = false
            }
        }

        return matched
    }

    /**
     * Describe the first line in which two models differ.
     */
    private def static String firstDifference(List<String> expected, List<String> actual) {
        val lines = Math.max(expected.size, actual.size)
        for (var i = 0; i < lines; i++) {
            val expectedLine = if (i < expected.size) expected.get(i) else null
            val actualLine = if (i < actual.size) actual.get(i) else null
            if (expectedLine != actualLine) {
                return '''
                             line «i + 1»
                             - expected: «expectedLine ?: "<end of model>"»
                             + actual:   «actualLine ?: "<end of model>"»'''.toString
            }
        }
        return null
    }

    private def static List<String> readLines(Path file) {
        return Files.readAllLines(file, StandardCharsets.UTF_8)
    }

    private def static List<Path> listDirectories(Path folder) {
        val stream = Files.list(folder)
        try {
            return stream.filter[Files.isDirectory(it)].sorted.collect(Collectors.toList)
        } finally {
            stream.close
        }
    }

    /**
     * All generated models of a folder, relative order stable.
     */
    private def static List<Path> listModels(Path folder) {
        val models = new ArrayList<Path>
        if (!Files.isDirectory(folder)) {
            return models
        }
        val stream = Files.walk(folder)
        try {
            models.addAll(stream
                .filter[Files.isRegularFile(it)]
                .filter[
                    toString.endsWith(".data") || toString.endsWith(".services")
                        || toString.endsWith(".operation")
                ]
                .sorted
                .collect(Collectors.toList))
        } finally {
            stream.close
        }
        return models
    }
}

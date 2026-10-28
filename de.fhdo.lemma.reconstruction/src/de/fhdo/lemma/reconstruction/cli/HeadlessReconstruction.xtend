package de.fhdo.lemma.reconstruction.cli

import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.reconstruction.MongoDbRepository
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator
import de.fhdo.lemma.reconstruction.io.ReconstructionModelWriter
import de.fhdo.lemma.reconstruction.operation.LemmaOperationGenerator
import de.fhdo.lemma.reconstruction.operation.OperationNode
import de.fhdo.lemma.reconstruction.service.LemmaServiceGenerator
import de.fhdo.lemma.reconstruction.service.Microservice
import java.util.List

/**
 * Generate the LEMMA models of a reconstructed system without the wizard.
 *
 * Reads the same database the wizard reads and runs the same generators and the
 * same writer, so the models are the ones the wizard produces. What the wizard
 * asks for in a dialog is given on the command line instead, and everything the
 * database holds is generated rather than a selection of it.
 *
 * There is no Eclipse here, so the two places that look for a bundle fall back to
 * the working directory: the technology models are read and copied relative to
 * it, which is why this has to run with the bundle as its working directory. See
 * the README beside the script that runs it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class HeadlessReconstruction {
    static val DEFAULT_HOST = "localhost"
    static val DEFAULT_PORT = 27017
    static val DEFAULT_TECHNOLOGY_FOLDER = "technology"
    static val OPERATION_MODEL_NAME = "architecture"

    static val USAGE = '''
        Generate the LEMMA models of a reconstructed system from the database.

        Usage:
          HeadlessReconstruction --target <folder> [options]

        Options:
          --target <folder>             Folder to write the models into (required)
          --host <host>                 MongoDB host (default: «DEFAULT_HOST»)
          --port <port>                 MongoDB port (default: «DEFAULT_PORT»)
          --technology-folder <name>    Sub folder for the technology models
                                        (default: «DEFAULT_TECHNOLOGY_FOLDER»)
          --no-technology-models        Do not copy the technology models
          --help                        Print this text
    '''

    def static void main(String[] args) {
        val options = Options.parse(args)
        if (options === null) {
            println(USAGE)
            System.exit(if (args.toList.contains("--help")) 0 else 1)
            return
        }

        new HeadlessReconstruction().run(options)
    }

    private def run(Options options) {
        val repository = new MongoDbRepository(options.host, options.port)
        val contexts = repository.reconstructedContexts
        val microservices = repository.reconstructedMicroservices
        val operationNodes = repository.reconstructedOperationNodes

        println('''Read from «options.host»:«options.port» - «contexts.size» context(s), ''' +
            '''«microservices.size» microservice(s), «operationNodes.size» operation node(s)''')

        if (contexts.empty && microservices.empty && operationNodes.empty) {
            println("The database holds no reconstruction. Run MRF first.")
            System.exit(1)
            return
        }

        if (options.copyTechnologyModels) {
            val copied = ReconstructionModelWriter.copyTechnologyModels(options.target,
                options.technologyFolder)
            if (copied.empty) {
                println('''
                    WARNING no technology model was copied, so the imports of the generated
                            models will not resolve until one is placed in
                            "«options.technologyFolder»". Looked for them in:
                            «ReconstructionModelWriter.lastLookupLocation»''')
            } else {
                println('''Copied «copied.size» technology model(s) into ''' +
                    '''«options.technologyFolder»/''')
            }
        }

        val written = newLinkedList
        written.addAll(writeDomainModels(contexts, options))
        written.addAll(writeServiceModels(microservices, options))
        written.addAll(writeOperationModel(operationNodes, options))

        println('''Wrote «written.size» model(s):''')
        written.sort.forEach[println('''  «it»''')]
    }

    private def List<String> writeDomainModels(List<Context> contexts, Options options) {
        val generator = new LemmaDomainGenerator
        val models = <DataModel>newLinkedList
        contexts.forEach[models.addAll(generator.generateDataModel(it))]
        return models.map[ReconstructionModelWriter.writeDataModel(it, options.target)].toList
    }

    private def List<String> writeServiceModels(List<Microservice> microservices,
        Options options) {
        val written = <String>newLinkedList
        microservices.forEach[
            // One generator per microservice, because a generator collects its
            // microservices in a single model and each belongs in its own file.
            // All of them are handed over so a dependency on another can be
            // resolved against the callee's interfaces and operations.
            val model = new LemmaServiceGenerator().generateModelFrom(it,
                options.technologyFolder, microservices)
            written.add(ReconstructionModelWriter.writeServiceModel(model, options.target))
        ]
        return written
    }

    private def List<String> writeOperationModel(List<OperationNode> nodes, Options options) {
        if (nodes.empty) {
            return emptyList
        }
        val generator = new LemmaOperationGenerator
        val model = generator.generateModelFrom(nodes, options.technologyFolder)
        val path = ReconstructionModelWriter.writeOperationModel(model, OPERATION_MODEL_NAME,
            options.target)

        if (!generator.skippedNodes.empty) {
            println('''Left out «generator.skippedNodes.size» node(s) that deploy no ''' +
                '''microservice: «generator.skippedNodes.join(", ")»''')
        }
        return #[path]
    }

    /**
     * What the wizard asks for in its dialogs.
     */
    static class Options {
        static val TAKE_A_VALUE = #{"--target", "--host", "--port", "--technology-folder"}

        public var String target
        public var String host = DEFAULT_HOST
        public var int port = DEFAULT_PORT
        public var String technologyFolder = DEFAULT_TECHNOLOGY_FOLDER
        public var boolean copyTechnologyModels = true

        /**
         * Read the options, or null when they are incomplete or unreadable.
         */
        def static Options parse(String[] args) {
            val options = new Options
            var i = 0
            while (i < args.length) {
                val option = args.get(i)
                if (TAKE_A_VALUE.contains(option) && i + 1 >= args.length) {
                    println('''«option» needs a value.''')
                    return null
                }
                switch (option) {
                    case "--help": return null
                    case "--no-technology-models": options.copyTechnologyModels = false
                    case "--target": {
                        i++
                        options.target = args.get(i)
                    }
                    case "--host": {
                        i++
                        options.host = args.get(i)
                    }
                    case "--port": {
                        i++
                        try {
                            options.port = Integer.parseInt(args.get(i))
                        } catch (NumberFormatException e) {
                            println('''«args.get(i)» is no port number.''')
                            return null
                        }
                    }
                    case "--technology-folder": {
                        i++
                        options.technologyFolder = args.get(i)
                    }
                    default: {
                        println('''Unknown option «option».''')
                        return null
                    }
                }
                i++
            }

            if (options.target.nullOrEmpty) {
                println("--target is required.")
                return null
            }
            return options
        }
    }
}

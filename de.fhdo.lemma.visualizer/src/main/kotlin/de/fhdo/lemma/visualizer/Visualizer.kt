package de.fhdo.lemma.visualizer

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import java.io.File

/**
 * This class is the entry point for the LEMMA Visualizer based upon the model processing framework.
 * Therefore, it extends AbstractModelProcessor and passes the package, in which to find language description providers,
 * code generation modules etc. LEMMA's Model Processing Framework (LMPF) relies on annotations to
 * find relevant implementations in the passed package at runtime.
 *
 * Model processing is the invoked by calling the run() method on an AbstractModelProcessor
 * instance. Valid commandline arguments are:
 *   - "-s": Source model file in LEMMA's concrete syntax representation.
 *   - "-i": Source model file in LEMMA's intermediate representation.
 *   - "-t": Target folder for code generation modules.
 *   - "--invoke_only_specified_phases": Invoke only those model processing phases explicitly
 *      specified via the commandline.
 *   - "--exit_on_error": Exit on any error occurring during model processing in any phase.
 *
 * Commands can be used like "-s=/my/absolute/path/to/file.xmi" (due to picocli used for the processor framework)
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
class Visualizer() : AbstractModelProcessor("de.fhdo.lemma.visualizer") {}

/**
 * Entrypoint to the Visualizer.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
fun main(args:Array<String>) {
    if(!args.isEmpty()) {
        Visualizer().run(args)
    } else {
        print("Error: no parameters given to execute model processing.")
    }
}


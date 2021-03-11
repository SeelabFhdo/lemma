package de.fhdo.lemma.visualizer.processor

import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * This class is the entry point for LEMMA model processors used by the main function. Therefore, it extends
 * AbstractModelProcessor and passes the package, in which to find language description providers,
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
 * Commands can be used like "-s=/my/absolute/path/to/file.xmi" (due to picocli used for the processor framework)
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
class ModelProcessor : AbstractModelProcessor("de.fhdo.lemma.visualizer") {
}
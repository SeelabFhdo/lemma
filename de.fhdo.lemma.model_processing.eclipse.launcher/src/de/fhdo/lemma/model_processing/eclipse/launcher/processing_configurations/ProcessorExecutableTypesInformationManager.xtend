package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.widgets.Shell

/**
 * Class to manage information about types of model processor executables.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProcessorExecutableTypesInformationManager {
    static val MANAGED_INFO
        = <ProcessorExecutableType, ProcessorExecutableTypeInformation>newHashMap

    /**
     * Domain concept to store coherent information about model processor executables
     */
    static class ProcessorExecutableTypeInformation {
        @Accessors(PUBLIC_GETTER)
        ProcessorExecutableType processorExecutableType

        @Accessors(PUBLIC_GETTER)
        String label

        @Accessors(PUBLIC_GETTER)
        String printableInSentenceString

        @Accessors(PUBLIC_GETTER)
        (Shell, ProcessingConfiguration)=>String inputSupportFunction

        /**
         * Constructor
         */
        new(
            ProcessorExecutableType processorExecutableType,
            String label,
            String printableInSentenceString,
            (Shell, ProcessingConfiguration)=>String inputSupportFunction
        ) {
            this.processorExecutableType = processorExecutableType
            this.label = label
            this.printableInSentenceString = printableInSentenceString
            this.inputSupportFunction = inputSupportFunction
        }
    }


    static val BiMap<ProcessorExecutableType, String> LABEL_VIEW = HashBiMap.create()

    /**
     * Register new information about model processor executables
     */
    static def register(ProcessorExecutableTypeInformation... info) {
        info.forEach[
            MANAGED_INFO.put(it.processorExecutableType, it)
            LABEL_VIEW.put(it.processorExecutableType, it.label)
        ]
    }

    /**
     * Get the text label of the given ProcessorExecutableType. Throw an IllegalArgumentException in
     * case no label was registered for the type.
     */
    static def label(ProcessorExecutableType literal) {
        val label = LABEL_VIEW.get(literal)
        return if (label !== null)
                label
            else
                throw new IllegalArgumentException("Unsupported processor executable type: " +
                    literal)
    }

    /**
     * Get the literal from the ProcessorExecutableType enumeration matching the given executable
     * type label. Throw an IllegalArgumentException in case no label was registered for the type.
     */
    static def literal(String label) {
        val literal = LABEL_VIEW.inverse().get(label)
        return if (literal !== null)
                literal
            else
                throw new IllegalArgumentException("Unsupported processor executable type label: " +
                    label)
    }

    /**
     * Get the string representation of the given ProcessorExecutableType which allows printing the
     * executable type within a sentence
     */
    static def printableInSentenceString(ProcessorExecutableType literal) {
        val info = MANAGED_INFO.get(literal)
        return info?.printableInSentenceString
    }

    /**
     * Check if the given ProcessorExecutableType has an input support function
     */
    static def hasInputSupport(ProcessorExecutableType literal) {
        val info = MANAGED_INFO.get(literal)
        return info !== null && info.inputSupportFunction !== null
    }

    /**
     * Get the input support function of the given ProcessorExecutableType. Throw an
     * IllegalArgumentException in case no input support function was registered for the type.
     */
    static def inputSupportFunction(ProcessorExecutableType literal) {
        val info = MANAGED_INFO.get(literal)
        if (info === null)
            throw new IllegalArgumentException("Unsupported processor executable type: " +
                literal)
        return info.inputSupportFunction
    }
}
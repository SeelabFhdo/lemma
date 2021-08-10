package de.fhdo.lemma.examples.model_processing.latest;

import de.fhdo.lemma.model_processing.UtilKt;
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule;
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateParameter;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LEMMA's model processing framework supports model-based structuring of code generators. This class implements a
 * code generation module as expected by the framework, i.e., the class receives the
 * {@link de.fhdo.lemma.model_processing.annotations.CodeGenerationModule} annotation and extends
 * {@link de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule}.
 */
@CodeGenerationModule(name = "main")
public class ExampleCodeGenerationModule extends AbstractCodeGenerationModule {
    /**
     * Return the namespace of the modeling language, from whose models code can be generated
     */
    @NotNull
    @Override
    public String getLanguageNamespace() {
        return IntermediatePackage.eNS_URI;
    }

    /**
     * This method performs the actual code generation. Note that LEMMA's model processing does not assume a specific
     * type of code generation. For instance, this simple implementation uses simple Java {@link String}s to store the
     * generated code. However, you may use any mechanism to facilitate code generation, e.g., template engines. The
     * only requirement posed by LEMMA's model processing framework is that the
     * {@link de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule#execute(String[], String[])}
     * implementation of a code generation module returns a map with entries as follows:
     *  - Key: Path of a generated file. By default, the file must reside in the folder passed to the model processor in
     *      the "--target_model" commandline option (see below).
     * - Value: A {@link kotlin.Pair} instance, whose first component contains the generated file's content and whose
     *      second component identifies the content's {@link java.nio.charset.Charset}.
     * From the map entries, LEMMA's code generation framework will write the generated files to the filesystem of the
     * model processor user.
     *
     * The method generates a file called "results.txt" in the given target folder (cf. the "run.sh" script). It will
     * contain:
     *  - Per modeled microservice the count of modeled interfaces
     *  - Per modeled microservice the count of interfaces, which are "fully synchronous" (i.e., that contain only
     *      operations with synchronous parameters)
     *  - Per modeled microservice the count of interfaces, which are "fully asynchronous" (i.e., that contain only
     *      operations with asynchronous parameters)
     * You can find the specifications for intermediate domain and service models here:
     *  - Intermediate Domain Model Specification:
     *      https://github.com/SeelabFhdo/lemma/tree/master/de.fhdo.lemma.data.intermediate.metamodel/doc/build/html
     *  - Intermediate Service Model Specification:
     *      https://github.com/SeelabFhdo/lemma/tree/master/de.fhdo.lemma.service.intermediate.metamodel/doc/build/html
     */
    @NotNull
    @Override
    public Map<String, Pair<String, Charset>> execute(@NotNull String[] phaseArguments,
        @NotNull String[] moduleArguments) {
        StringBuilder resultFileContents = new StringBuilder();

        /*
         * Retrieve the passed intermediate service model to work with (the above implementation of
         * {@link getLanguageNamespace} tells the framework that this module shall work on intermediate service
         * models). To retrieve the {@link org.eclipse.emf.ecore.resource.Resource} of the model, we can rely on
         * the {@link de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule#getResource}
         * method.
         */
        IntermediateServiceModel serviceModel = (IntermediateServiceModel) getResource().getContents().get(0);

        /* Iterate over all modeled microservices in the intermediate service model */
        for (IntermediateMicroservice m : serviceModel.getMicroservices()) {
            int syncCount = 0;
            int asyncCount = 0;

            /* Iterate over all interfaces of the current microservice */
            for (IntermediateInterface i : m.getInterfaces()) {
                // Get the communication types of all operations' parameters modeled for the current interface (cf. the
                // intermediate service model specification at
                // https://github.com/SeelabFhdo/lemma/tree/master/de.fhdo.lemma.service.intermediate.metamodel/doc/build/html
                // for information on the model structure
                List<String> paramTypes = i.getOperations()
                    .stream()
                    .map(IntermediateOperation::getParameters)
                    .flatMap(Collection::stream)
                    .map(IntermediateParameter::getCommunicationType)
                    .collect(Collectors.toList());

                // Decide if the interface is fully synchronous...
                if (paramTypes.isEmpty() || paramTypes.stream().noneMatch(t -> t.equals("ASYNCHRONOUS")))
                    syncCount++;
                // ... or asynchronous
                else if (paramTypes.stream().noneMatch(t -> t.equals("SYNCHRONOUS")))
                    asyncCount++;
            }

            /* Create the generated "code" */
            resultFileContents.append(String.format(
                "Interface count for microservice %s: %d\n" +
                    "\tSynchronous interface count: %d\n" +
                    "\tAsynchronous interface count: %d\n",
                m.getQualifiedName(), m.getInterfaces().size(), syncCount, asyncCount
            ));
        }

        /* Prepare the path of the generated file */
        String resultFilePath = getTargetFolder() + File.separator + "results.txt";

        /*
         * Return the generated file and its content to LEMMA's model processing framework. Note that we can rely on the
         * {@link de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule#withCharset}
         * helper method to collectively determine the {@link java.nio.charset.Charset} of all file contents in a map,
         * whose key identifies file paths and whose value comprises file contents.
         */
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put(resultFilePath , resultFileContents.toString());
        return withCharset(resultMap, StandardCharsets.UTF_8.name());
    }
}

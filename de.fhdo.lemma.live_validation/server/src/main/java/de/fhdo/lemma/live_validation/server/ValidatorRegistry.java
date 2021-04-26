package de.fhdo.lemma.live_validation.server;

import de.fhdo.lemma.live_validation.model.IssueDiagnostic;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationLanguageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

import static de.fhdo.lemma.live_validation.protocol.server.ServerProtocolImpl.identifier;
import static de.fhdo.lemma.live_validation.protocol.server.ServerProtocolImpl.logPrefix;

/**
 * Map implementation for the registration of validating Live Validation clients (validators). The map assigns
 * validators the extensions of the file formats they support (File extension -> [Validator list]).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ValidatorRegistry extends ConcurrentHashMap<String, Set<LiveValidationLanguageClient>> {
    private static final Logger LOGGER = LogManager.getRootLogger();

    /**
     * Add a new client to the map of registered validators and return the new count of validators per file extension
     * supported by the new client
     */
    public Map<String, Integer> registerValidator(LiveValidationLanguageClient client, Set<String> fileExtensions) {
        var clientsPerExtensionCount = new HashMap<String, Integer>();

        fileExtensions.forEach(ext -> {
            var clientSet = computeIfAbsent(ext, k -> ConcurrentHashMap.newKeySet());
            clientSet.add(client);
            clientsPerExtensionCount.put(ext, clientSet.size());
        });

        return clientsPerExtensionCount;
    }

    /**
     * Helper to run all registered and applicable validators on the given document and its source code
     */
    public List<IssueDiagnostic> runValidators(
        String documentUri,
        String sourceCode,
        Long timeoutThreshold,
        Consumer<LiveValidationLanguageClient> successfulValidationCallback,
        Consumer<LiveValidationLanguageClient> failedValidationCallback
    ) {
        var fileExtension = FilenameUtils.getExtension(documentUri);
        var clients = get(fileExtension);
        if (clients.isEmpty()) {
            LOGGER.error("No validators found for file extension " + fileExtension);
            return new ArrayList<>();
        }

        LOGGER.debug("Run validations");

        // Trigger all validators registered as being capable of handling the document's file format by asynchronously
        // sending them PerformValidation requests
        var validationResultFutures
            = new HashMap<LiveValidationLanguageClient, CompletableFuture<List<IssueDiagnostic>>>();
        var clientCounter = 0;
        for (LiveValidationLanguageClient client : clients) {
            clientCounter++;
            LOGGER.debug("Run validator {} ({} of {})", identifier(client), clientCounter, clients.size());
            try {
                // Collect the request futures to wait for them in the next step
                validationResultFutures.put(client, client.requestValidation(documentUri, sourceCode));
            } catch(Exception ex) {
                LOGGER.error("Validation request failed by client");
                failedValidationCallback.accept(client);
            }
        }

        // Collect the validation results as they were responded from the validation clients
        var validationResults = new ArrayList<IssueDiagnostic>();
        var resultCounter = 0;
        for (LiveValidationLanguageClient client : validationResultFutures.keySet()) {
            var future = validationResultFutures.get(client);
            resultCounter++;
            LOGGER.debug("{} Waiting for validation result {} of {}", logPrefix(client), resultCounter,
                validationResultFutures.size());
            try {
                // Retrieve the validation results blocking but grant each validator only a limited amount of time to
                // respond its results
                validationResults.addAll(future.orTimeout(timeoutThreshold, TimeUnit.MILLISECONDS).get());
                successfulValidationCallback.accept(client);
                LOGGER.debug("{} Received validation result {}", logPrefix(client), resultCounter);
            } catch(Exception ex) {
                if (ex.getCause() instanceof TimeoutException)
                    LOGGER.error("{} Timeout exception while waiting for result {}", logPrefix(client), resultCounter);
                else
                    LOGGER.error("{} Exception while waiting for result {}:\n{}", logPrefix(client), resultCounter,
                        ExceptionUtils.getStackTrace(ex));

                failedValidationCallback.accept(client);
            }
        }

        return validationResults;
    }

    /**
     * Deregister validator
     */
    public void deregisterValidator(LiveValidationLanguageClient client) {
        values().forEach(clients -> clients.remove(client));
    }
}

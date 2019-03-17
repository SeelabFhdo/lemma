package de.fhdo.ddmm.live_validation.server

import de.fhdo.ddmm.live_validation.True
import de.fhdo.ddmm.live_validation.asFile
import de.fhdo.ddmm.live_validation.common.IssueDiagnostic
import de.fhdo.ddmm.live_validation.protocol.LiveValidationLanguageClient
import de.fhdo.ddmm.live_validation.protocol.LiveValidationServer
import de.fhdo.ddmm.live_validation.protocol.clientInitializationResponse
import de.fhdo.ddmm.live_validation.protocol.identifier
import de.fhdo.ddmm.live_validation.protocol.logPrefix
import de.fhdo.ddmm.live_validation.protocol.publishIssues
import mu.KotlinLogging
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.InitializeError
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.InitializedParams
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageClientAware
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.lang.IllegalStateException
import java.nio.channels.AsynchronousSocketChannel
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

// Determines how often a client registered as a validator can fail until it won't be requested to perform validations
// anymore
private const val VALIDATION_CLIENT_FAILURE_THRESHOLD = 10

private val LOGGER = KotlinLogging.logger {}
private val VALIDATOR_CLIENTS = ConcurrentHashMap<String, MutableSet<LiveValidationLanguageClient>>()
private val FAILED_VALIDATION_CLIENTS = ConcurrentHashMap<LiveValidationLanguageClient, Int>()

/**
 * Concrete implementation of a Live Validation LSP language server. It is when the JAR archive is run standalone. As
 * intended by LSP4J, each client request leads to the creation of a new instance of this server implementation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class LiveValidationServerImpl : LiveValidationServer, LanguageClientAware {
    // Information shared across all server instances and not relevant to top-level helper functions
    companion object {
        var shutdownRequested = AtomicBoolean()
        private val ACTIVE_VALIDATIONS_COUNT = AtomicInteger()
    }

    // Internal object to reflect this server instance's connection information
    private object ConnectionInfo {
        lateinit var inputStream: InputStream
        lateinit var outputStream: OutputStream
        lateinit var socketChannel: AsynchronousSocketChannel
        lateinit var clientListener: Future<Void>
    }

    private var connectionInfoPassed = false
    private lateinit var client: LiveValidationLanguageClient

    /**
     * Set connection info (to be used by server runners using this server implementation)
     */
    fun setConnectionInfo(inputStream: InputStream, outputStream: OutputStream,
        socketChannel: AsynchronousSocketChannel, clientListener: Future<Void>) {
        ConnectionInfo.inputStream = inputStream
        ConnectionInfo.outputStream = outputStream
        ConnectionInfo.socketChannel = socketChannel
        ConnectionInfo.clientListener = clientListener

        connectionInfoPassed = true
    }

    /**
     * Used by LSP4J to pass the language client connected to this server instance
     */
    override fun connect(client: LanguageClient) {
        if (!connectionInfoPassed)
            throw IllegalStateException("Server connection information needs to be passed before client is allowed " +
                "to connect")

        this.client = client as LiveValidationLanguageClient
        LOGGER.info { "Client connected. Client identifier is ${this.client.identifier()}." }
    }

    /**
     * Handle client's Initialize request
     */
    override fun initialize(params: InitializeParams?) : CompletableFuture<InitializeResult> {
        // React with an InitializeError according to LSP in case the server is currently in the process of shutting
        // down
        if (shutdownRequested.True) {
            LOGGER.info { "Received an initialization request, but a shutdown request already occurred. " +
                "Initialization request will be ignored." }

            with(ResponseError()) {
                message = "Initialization request was rejected. Server is shutting down."
                setCode(ResponseErrorCode.InvalidRequest)
                data = InitializeError(false).toString()
                throw ResponseErrorException(this)
            }
        }

        LOGGER.debug { "${client.logPrefix()} Sending client initialization response" }
        return client.clientInitializationResponse()
    }

    /**
     * Handle client's Initialized notification
     */
    override fun initialized(params: InitializedParams?) {
        if (shutdownRequested.True) {
            LOGGER.info { "\"${client.logPrefix()} Received initialized notification, but a shutdown request " +
                "already occurred. Initialized notification will be ignored." }
            return
        }

        // Send RegisterValidator request to client
        LOGGER.debug { "${client.logPrefix()} Received client initialized notification. Requesting client " +
            "for validation registration." }
        client.requestValidatorRegistration()
            .completeOnTimeout(null, 500, TimeUnit.MILLISECONDS)
            .whenComplete { supportedFileExtensions, _ ->
                if (supportedFileExtensions != null && !supportedFileExtensions.isEmpty()) {
                    // The client registered as a validator by sending the file formats it supports for validation. Add
                    // the client to the internal list of validator clients.
                    val clientsPerExtensionCount = VALIDATOR_CLIENTS
                        .putNewValidator(supportedFileExtensions, client)

                    LOGGER.info { "${client.logPrefix()} Registered as validator for file extensions " +
                            "\"${supportedFileExtensions.joinToString()}\""}
                    LOGGER.debug { "New client count per extension:" }
                    clientsPerExtensionCount.forEach { fileExtension, clientCount ->
                        LOGGER.debug { "\t$fileExtension: $clientCount" }
                    }
                } else
                    LOGGER.debug { "${client.logPrefix()} Client is not a validator" }
            }
    }

    /**
     * Handle DidChangeTextDocument notification of a client acting as a Live Validation initiator. That is, the client
     * is an implementer of [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator].
     */
    override fun performValidations(params: DidChangeTextDocumentParams?) {
        if (shutdownRequested.True) {
            LOGGER.info { "${client.logPrefix()} Received didChange request, but a shutdown request already " +
                "occurred. didChange request will be ignored." }
            return
        }

        if (!params.isValid(client.logPrefix()))
            return

        val documentUri = params!!.textDocument.uri
        val sourceCode = params.contentChanges[0].text
        LOGGER.debug { "${client.logPrefix()} Received didChange request for file \"$documentUri\". Triggering " +
            "validations." }

        // Run registered validators on the changed source code. The execution of the validators is considered to happen
        // within a coherent "block", i.e., the number of active validations is increased/decreases by 1, even if more
        // than one validator execution is triggered by the DidChangeTextDocument notification.
        with(ACTIVE_VALIDATIONS_COUNT) {
            incrementAndGet()

            val validationResults = runValidators(documentUri, sourceCode)
            LOGGER.debug { "${client.logPrefix()} Publishing ${validationResults.size} validation results" }
            client.publishIssues(documentUri, validationResults)

            decrementAndGet()
        }
    }

    /**
     * Handle client's Shutdown request
     */
    override fun shutdown() : CompletableFuture<Any> {
        LOGGER.debug { "${client.logPrefix()} Received shutdown request" }

        shutdownRequested.set(true)
        return CompletableFuture.completedFuture(null)
    }

    /**
     * Handle client's Exit notification
     */
    override fun exit() {
        LOGGER.debug { "${client.logPrefix()} Received exit notification" }

        // Give active validations the possibility to finish
        val activeValidationsCount = ACTIVE_VALIDATIONS_COUNT.get()
        if (activeValidationsCount > 0) {
            LOGGER.debug { "$activeValidationsCount validations are active. Waiting a bit before exiting." }
            Thread.sleep(2000)
        }

        LOGGER.debug { "Will exit now" }

        // Shutdown the server with error code 1, as demanded by LSP, if no Shutdown request occurred prior to the Exit
        // notification
        if (!shutdownRequested.True)
            with(ResponseError()) {
                message = "Shutdown request was not received before exit notification"
                code = 1
                throw ResponseErrorException(this)
            }
    }

    /**
     * Handle a client's Disconnect request
     */
    override fun requestDisconnect() : CompletableFuture<Void> {
        with(LOGGER) {
            debug { "${client.logPrefix()} Received disconnect request" }
            VALIDATOR_CLIENTS.removeValidator(client)

            // Cancel LSP4J's internal concurrent message listener. No messages can be received from the client from now
            // on. Note that the listener is only canceled after this request was finished. This is the reason why
            // disconnecting a Live Validation client involves a Disconnect request and a subsequent Bye notification.
            // If the communication means were closed right after the listener is canceled, i.e., within the same
            // request, LSP4J's concurrent message listener will throw an exception, because it could not finish before
            // streams and channels got closed (see bye()).
            ConnectionInfo.clientListener.cancel(true)
            debug { "${client.logPrefix()} Client listener canceled" }
        }

        return CompletableFuture.completedFuture(null)
    }

    /**
     * Handle a client's Bye notification
     */
    override fun bye() {
        // Close all open communication means (streams and sockets). Note that it is necessary to cancel the concurrent
        // message listener before (see requestDisconnect()). Otherwise a concurrency exception will occur. Moreover,
        // is is necessary to
        with(ConnectionInfo) {
            LOGGER.debug { "${client.logPrefix()} Received bye notification" }

            inputStream.close()
            LOGGER.debug { "${client.logPrefix()} Input stream closed" }

            outputStream.close()
            LOGGER.debug { "${client.logPrefix()} Output stream closed" }

            socketChannel.close()
            LOGGER.debug { "${client.logPrefix()} Socket channel closed" }
        }
    }
}

/**
 * Helper to check if the parameter structure conveyed within a DidChangeTextDocument notification is usable for Live
 * Validation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun DidChangeTextDocumentParams?.isValid(clientLogPrefix: String) : Boolean {
    if (this == null) {
        LOGGER.debug { "$clientLogPrefix Received invalid didChange request without parameters" }
        return false
    }

    // URI of the changed document needs a file extension to determine, which validators are capable of dealing with the
    // document's file format
    val documentFileExtension = File(textDocument.uri).extension
    if (documentFileExtension.isEmpty()) {
        LOGGER.debug { "$clientLogPrefix Received invalid didChange request for file \"${textDocument.uri}\" (no " +
            "file extension)" }
        return false
    }

    if (contentChanges.isEmpty()) {
        LOGGER.debug { "$clientLogPrefix Received invalid didChange request for file \"${textDocument.uri}\" (no " +
            "content changes)" }
        return false
    }

    // Live Validation expects the whole document text to be sent within the "contentChanges.text" field of the
    // DidChangeTextDocument notification's parameter structure
    val sourceCode = contentChanges[0].text
    if (sourceCode.isEmpty()) {
        LOGGER.debug { "$clientLogPrefix Received invalid didChange request for file \"${textDocument.uri}\" (no " +
            "content)" }
        return false
    }

    return true
}

/**
 * Helper to put a new validator client to the map of registered validators. The map assigns validators to the
 * extensions of the file formats they support (File extension -> [Validator list]). The helper returns the new count of
 * validators per file extension the new validator is capable of handling, after the validator was added to the map of
 * registered validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ConcurrentHashMap<String, MutableSet<LiveValidationLanguageClient>>
        .putNewValidator(fileExtensions: Set<String>, client: LiveValidationLanguageClient) : Map<String, Int> {
    val clientsPerExtensionCount = mutableMapOf<String, Int>()

    fileExtensions.toSet().forEach {
        val existingClientSet = this[it]
        val clientExtensionCount = if (existingClientSet != null) {
            existingClientSet.add(client)
            existingClientSet.size
        } else {
            val newConcurrentClientSet = ConcurrentHashMap.newKeySet<LiveValidationLanguageClient>()
            newConcurrentClientSet.add(client)
            this[it] = newConcurrentClientSet
            1
        }

        clientsPerExtensionCount[it] = clientExtensionCount
    }

    return clientsPerExtensionCount
}

/**
 * Helper to remove a validator client from the map of registered validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ConcurrentHashMap<String, MutableSet<LiveValidationLanguageClient>>
        .removeValidator(client: LiveValidationLanguageClient) {
    this.values.forEach { it.remove(client) }
}

/**
 * Helper to run all registered and applicable validators on the given document and its source code.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun runValidators(documentUri: String, sourceCode: String) : List<IssueDiagnostic> {
    val fileExtension = documentUri.asFile().extension
    if (!VALIDATOR_CLIENTS.containsKey(fileExtension)) {
        LOGGER.error { """No validators found for file extension "$fileExtension"""" }
        return emptyList()
    }

    LOGGER.debug { "Run validations" }

    // Trigger all validators registered as being capable of handling the document's file format by asynchronously
    // sending them PerformValidation requests
    val validationResultFutures = mutableMapOf<LiveValidationLanguageClient, CompletableFuture<List<IssueDiagnostic>>>()
    val clients = VALIDATOR_CLIENTS[fileExtension]!!
    var clientCounter = 0
    clients.forEach {
        clientCounter++
        LOGGER.debug { "Run validator ${it.identifier()} ($clientCounter of ${clients.size})" }
        try {
            // Collect the request futures to wait for them in the next step
            validationResultFutures[it] = it.requestValidation(documentUri, sourceCode)
        } catch (ex: Exception) {
            LOGGER.error { "Validation request failed by client" }
            validationFailed(it)
        }
    }

    // Collect the validation results as they were responded from the validation clients
    val validationResults = mutableListOf<IssueDiagnostic>()
    var resultCounter = 0
    validationResultFutures.forEach { client, future ->
        resultCounter++
        LOGGER.debug { "${client.logPrefix()} Waiting for validation result $resultCounter of " +
            "${validationResultFutures.size}" }
        try {
            // Retrieve the validation results blocking, but grant each validator only a limited amount of time to
            // respond the results
            validationResults.addAll(future.orTimeout(500, TimeUnit.MILLISECONDS).get())
            FAILED_VALIDATION_CLIENTS.remove(client)
            LOGGER.debug { "${client.logPrefix()} Received validation result $resultCounter" }
        } catch(ex: Exception) {
            LOGGER.error { "${client.logPrefix()} Exception while waiting for result $resultCounter" }
            validationFailed(client)
        }
    }

    return validationResults
}

/**
 * Helper to handle failed validations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun validationFailed(client: LiveValidationLanguageClient) {
    var currentFailureCount = FAILED_VALIDATION_CLIENTS.putIfAbsent(client, 1)
    if (currentFailureCount != null) {
        // Check if the overall failure count of the failed validator exceeds a given threshold. If so, remove the
        // validator from the map of registered validators.
        if (currentFailureCount > VALIDATION_CLIENT_FAILURE_THRESHOLD) {
            LOGGER.debug { "${client.logPrefix()} Failure count of client is $currentFailureCount and above " +
                "threshold. Remove client from validator list." }
            VALIDATOR_CLIENTS.removeValidator(client)
        } else {
            FAILED_VALIDATION_CLIENTS[client] = ++currentFailureCount
            LOGGER.debug { "${client.logPrefix()} Failure count of client is now $currentFailureCount" }
        }
    } else
        LOGGER.debug { "${client.logPrefix()} Failure count of client is now 1" }
}
package de.fhdo.lemma.live_validation.server;

import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationLanguageClient;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer;
import de.fhdo.lemma.live_validation.util.ConnectionInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.lsp4j.DidChangeConfigurationParams;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.InitializeError;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.InitializedParams;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static de.fhdo.lemma.live_validation.protocol.server.ServerProtocolImpl.clientInitializationResponse;
import static de.fhdo.lemma.live_validation.protocol.server.ServerProtocolImpl.identifier;
import static de.fhdo.lemma.live_validation.protocol.server.ServerProtocolImpl.logPrefix;
import static de.fhdo.lemma.live_validation.protocol.server.ServerProtocolImpl.publishIssues;

/**
 * Concrete implementation of a Live Validation LSP language server. As intended by LSP4J, each client request leads to
 * the creation of a new instance of this server implementation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationServerImpl implements LiveValidationServer, LanguageClientAware {
    // Determines how often a client registered as a validator can fail until it won't be requested to perform
    // validations anymore
    private static final int VALIDATOR_FAILURE_THRESHOLD = 10;

    // Information shared across all server instances
    private static final AtomicInteger ACTIVE_VALIDATIONS_COUNT = new AtomicInteger();
    private static final AtomicBoolean SHUTDOWN_REQUESTED = new AtomicBoolean();
    private static final ValidatorRegistry VALIDATORS = new ValidatorRegistry();
    private static final ConcurrentHashMap<LiveValidationLanguageClient, Integer> FAILED_VALIDATORS
        = new ConcurrentHashMap<>();

    private static final Logger LOGGER = LogManager.getRootLogger();

    private ConnectionInfo connectionInfo;
    private LiveValidationLanguageClient client;

    /**
     * Set connection info (to be used by server runners using this server implementation)
     */
     public void setConnectionInfo(InputStream inputStream, OutputStream outputStream,
         AsynchronousSocketChannel socketChannel, Future<Void> clientListener) {
         connectionInfo = new ConnectionInfo(inputStream, outputStream, socketChannel, clientListener);
     }

    /**
     * Used by LSP4J to pass the language client connected to this server instance
     */
    @Override
    public void connect(LanguageClient client) {
        if (connectionInfo == null)
            throw new IllegalStateException("Server connection information needs to be passed before client is " +
                "allowed to connect");

        this.client = (LiveValidationLanguageClient) client;
        LOGGER.info("Client connected. Client identifier is {}.", identifier(client));
    }

    /**
     * Handle client's Initialize request
     */
    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        // React with an InitializeError according to LSP in case the server is currently in the process of shutting
        // down
        if (shutdownRequested()) {
            LOGGER.info("Received an initialization request but a shutdown request already occurred. Initialization " +
                "request will be ignored.");

            var responseError = new ResponseError();
            responseError.setMessage("Initialization request was rejected. Server is shutting down.");
            responseError.setCode(ResponseErrorCode.InvalidRequest);
            responseError.setData(new InitializeError(false).toString());
            throw new ResponseErrorException(responseError);
        }

        LOGGER.debug("{} Sending client initialization response", logPrefix(client));
        return clientInitializationResponse();
    }

    private boolean shutdownRequested() {
        return SHUTDOWN_REQUESTED.get();
    }

    /**
     * Handle client's Initialized notification
     */
    @Override
    public void initialized(InitializedParams params) {
        if (shutdownRequested()) {
            LOGGER.info("{} Received initialized notification but a shutdown request already occurred. Initialized " +
                "notification will be ignored.", logPrefix(client));
            return;
        }

        // Send RegisterValidator request to client
        LOGGER.debug("{} Received client initialized notification. Requesting client for validation registration.",
            logPrefix(client));
        client.requestValidatorRegistration()
            .completeOnTimeout(null, 500, TimeUnit.MILLISECONDS)
            .whenComplete((supportedFileExtensions, ex) -> {
                if (supportedFileExtensions != null && !supportedFileExtensions.isEmpty()) {
                    // The client registered as a validator by sending the file formats it supports for validation. Add
                    // the client to the internal list of validator clients.
                    var clientsPerExtensionCount = VALIDATORS.registerValidator(client, supportedFileExtensions);

                    LOGGER.info("{} Registered as validator for file extensions {}", logPrefix(client),
                        String.join(", ", supportedFileExtensions));

                    LOGGER.debug("New client count per extension:");
                    clientsPerExtensionCount.forEach((key, value) -> LOGGER.debug("\t{}: {}", key, value));
                } else
                    LOGGER.debug("{} Client is not a validator", logPrefix(client));
            });
    }

    /**
     * Handle DidChangeTextDocument notification of a client acting as a Live Validation initiator. That is, the client
     * is an implementer of AbstractLiveValidationInitiator.
     */
    @Override
    public void performValidations(DidChangeTextDocumentParams params) {
        if (shutdownRequested()) {
            LOGGER.info("{} Received didChange request but a shutdown request already occurred. didChange request " +
                "will be ignored.", logPrefix(client));
            return;
        }

        if (!usableForLiveValidation(params))
            return;

        var documentUri = params.getTextDocument().getUri();
        var sourceCode = params.getContentChanges().get(0).getText();
        LOGGER.info("{} Received didChange request for file \"{}\". Triggering validations.", logPrefix(client),
            documentUri);

        // Run registered validators on the changed source code. The execution of the validators is considered to happen
        // within a coherent "block", i.e., the number of active validations is increased/decreases by 1, even if more
        // than one validator execution is triggered by the DidChangeTextDocument notification.
        ACTIVE_VALIDATIONS_COUNT.incrementAndGet();
        var validationResults = VALIDATORS.runValidators(
            documentUri,
            sourceCode,
            LiveValidationCommandLine.instance().getTimeoutThreshold(),
            FAILED_VALIDATORS::remove,
            this::validationFailed
        );
        LOGGER.debug("{} Publishing {} validation results", logPrefix(client), validationResults.size());
        publishIssues(client, documentUri, validationResults);
        ACTIVE_VALIDATIONS_COUNT.decrementAndGet();
    }

    /**
     * Helper to check if the parameter structure conveyed within a DidChangeTextDocument notification is usable for
     * Live Validation
     */
    private boolean usableForLiveValidation(DidChangeTextDocumentParams params) {
        if (params == null) {
            LOGGER.debug("{} Received invalid didChange request without parameters", logPrefix(client));
            return false;
        }

        // URI of the changed document needs a file extension to determine, which validators are capable of dealing with
        // the document's file format
        var documentUri = params.getTextDocument().getUri();
        var documentFileExtension = FilenameUtils.getExtension(documentUri);
        if (documentFileExtension.isEmpty()) {
            LOGGER.debug("{} Received invalid didChange request for file \"{}\" (no file extension)", logPrefix(client),
                documentUri);
            return false;
        }

        var contentChanges = params.getContentChanges();
        if (contentChanges.isEmpty()) {
            LOGGER.debug("{} Received invalid didChange request for file \"{}\" (no content changes)",
                logPrefix(client), documentUri);
            return false;
        }

        // Live Validation expects the whole document text to be sent within the "contentChanges.text" field of the
        // DidChangeTextDocument notification's parameter structure
        var sourceCode = contentChanges.get(0).getText();
        if (sourceCode.isEmpty()) {
            LOGGER.debug("{} Received invalid didChange request for file \"{}\" (no content)", logPrefix(client),
                documentUri);
            return false;
        }

        return true;
    }

    /**
     * Helper to handle failed validations
     */
    private void validationFailed(LiveValidationLanguageClient client) {
        var currentFailureCount = FAILED_VALIDATORS.putIfAbsent(client, 1);
        if (currentFailureCount == null) {
            LOGGER.debug("{} Failure count of client is now 1", logPrefix(client));
            return;
        }

        // Check if the overall failure count of the failed validator exceeds a given threshold. If so, remove the
        // validator from the map of registered validators.
        if (currentFailureCount > VALIDATOR_FAILURE_THRESHOLD) {
            LOGGER.debug("{} Failure count of client is {} and above threshold ({}). Removing client from validator " +
                "list.", logPrefix(client), currentFailureCount, VALIDATOR_FAILURE_THRESHOLD);
            VALIDATORS.deregisterValidator(client);
        } else {
            FAILED_VALIDATORS.put(client, ++currentFailureCount);
            LOGGER.debug("{} Failure count of client is now {}", logPrefix(client), currentFailureCount);
        }
    }

    /**
     * Handle client's Shutdown request
     */
    @Override
    public CompletableFuture<Object> shutdown() {
        LOGGER.debug("{} Received shutdown request", logPrefix(client));

        SHUTDOWN_REQUESTED.set(true);
        return CompletableFuture.completedFuture(null);
    }

    /**
     * Handle client's Exit notification
     */
    @Override
    public void exit() {
        LOGGER.debug("{} Received exit notification", logPrefix(client));

        // Give active validations the possibility to finish
        var activeValidationsCount = ACTIVE_VALIDATIONS_COUNT.get();
        if (activeValidationsCount > 0) {
            LOGGER.debug("{} validations are active. Waiting a bit before exiting.", activeValidationsCount);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException ex) {
                // NOOP
            }
        }

        LOGGER.debug("Will exit now");

        // Shutdown the server with error code 1, as demanded by LSP, if no Shutdown request occurred prior to the Exit
        // notification
        if (!shutdownRequested()) {
            var responseError = new ResponseError();
            responseError.setMessage("Shutdown request was not received before exit notification");
            responseError.setCode(1);
            throw new ResponseErrorException(responseError);
        }
    }

    /**
     * Handle a client's Disconnect request
     */
    @Override
    public CompletableFuture<Void> requestDisconnect() {
        LOGGER.debug("{} Received disconnect request", logPrefix(client));
        if (connectionInfo == null)
            throw new IllegalStateException("No connection to client to disconnect from");

        VALIDATORS.deregisterValidator(client);

        // Cancel LSP4J's internal concurrent message listener. No messages can be received from the client from now on.
        // Note that the listener is only canceled after this request was finished. This is the reason why disconnecting
        // a Live Validation client involves a Disconnect request and a subsequent Bye notification. If the
        // communication means were closed right after the listener is canceled, i.e., within the same request, LSP4J's
        // concurrent message listener will throw an exception, because it could not finish before streams and channels
        // got closed (see bye()).
        connectionInfo.getListener().cancel(true);
        LOGGER.debug("{} Client listener canceled", logPrefix(client));

        return CompletableFuture.completedFuture(null);
    }

    /**
     * Handle a client's Bye notification
     */
    @Override
    public void bye() {
        LOGGER.debug("{} Received bye notification", logPrefix(client));
        if (connectionInfo == null)
            throw new IllegalStateException("No connection to client to say bye");

        // Close all open communication means (streams and sockets). Note that it is necessary to cancel the concurrent
        // message listener before (see requestDisconnect()). Otherwise a concurrency exception will occur.
        try {
            connectionInfo.getInputStream().close();
            LOGGER.debug("{} Input stream closed", logPrefix(client));

            connectionInfo.getOutputStream().close();
            LOGGER.debug("{} Output stream closed", logPrefix(client));

            connectionInfo.getSocketChannel().close();
            LOGGER.debug("{} Socket channel closed", logPrefix(client));
        } catch (IOException ex) {
            // NOOP
        }
    }

    /**
     * Implementation of TextDocumentService. Except for didChange all other notifications of the implementation are
     * NOOP implementations. didChange, however, trigger validations.
     */
    @Override
    public TextDocumentService getTextDocumentService() {
        return new TextDocumentService() {
            @Override
            public void didChange(DidChangeTextDocumentParams params) {
                performValidations(params);
            }

            @Override
            public void didOpen(DidOpenTextDocumentParams params) {
                // NOOP
            }

            @Override
            public void didSave(DidSaveTextDocumentParams params) {
                // NOOP
            }

            @Override
            public void didClose(DidCloseTextDocumentParams params) {
                // NOOP
            }
        };
    }

    /**
     * NOOP implementation of WorkspaceService for Live Validation server implementers' convenience
     */
    @Override
    public WorkspaceService getWorkspaceService() {
        return new WorkspaceService() {
            @Override
            public void didChangeConfiguration(DidChangeConfigurationParams params) {
                // NOOP
            }

            @Override
            public void didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
                // NOOP
            }
        };
    }
}
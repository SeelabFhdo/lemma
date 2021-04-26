package de.fhdo.lemma.live_validation.client;

import static de.fhdo.lemma.live_validation.protocol.client.ClientProtocolImpl.notifyClientInitialized;
import static de.fhdo.lemma.live_validation.protocol.client.ClientProtocolImpl.requestClientInitialization;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationLanguageClient;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer;
import de.fhdo.lemma.live_validation.util.ConnectionInfo;
import de.fhdo.lemma.live_validation.util.LiveValidationLauncherBuilder;
import org.eclipse.lsp4j.MessageActionItem;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.ShowMessageRequestParams;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Base class for Live Validation clients like AbstractLiveValidationInitiator and AbstractLiveValidator. The class
 * establishes the connection to a Live Validation server, listens to incoming messages from the server, and enables
 * Live Validation clients to disconnect and shutdown the server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class BaseClient implements LiveValidationLanguageClient {
    protected LiveValidationServer server;

    private ConnectionInfo connectionInfo;

    /**
     * Establish connection to Live Validation server
     */
    public void start(String hostname, int port, LiveValidationLanguageClient client, String rootUri,
        OutputStream traceStream) throws ExecutionException, InterruptedException, IOException {
        server = connectAndListen(hostname, port, client, traceStream);

        // Send LSP initialize request and initialized notification
        requestClientInitialization(server, rootUri);
        notifyClientInitialized(server);
    }

    /**
     * Connect to Live Validation server and start listening to incoming messages
     */
    private LiveValidationServer connectAndListen(String hostname, int port, LiveValidationLanguageClient client,
        OutputStream traceStream) throws ExecutionException, InterruptedException, IOException {
        var socketAddress = new InetSocketAddress(hostname, port);
        var socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(socketAddress).get();
        var inputStream = Channels.newInputStream(socketChannel);
        var outputStream = Channels.newOutputStream(socketChannel);
        var launcherBuilder = new LiveValidationLauncherBuilder<LanguageServer>()
            .setLocalService(client)
            .setRemoteInterface(LiveValidationServer.class)
            .setInput(inputStream)
            .setOutput(outputStream)
            .validateMessages(true);

        Launcher<LanguageServer> launcher;
        if (traceStream != null)
            launcher = launcherBuilder.traceMessages(new PrintWriter(traceStream)).create();
        else
            launcher = launcherBuilder.create();
        var serverListener = launcher.startListening();

        connectionInfo = new ConnectionInfo(inputStream, outputStream, socketChannel, serverListener);

        return (LiveValidationServer) launcher.getRemoteProxy();
    }

    /**
     * Establish connection to a Live Validation server using the concrete instance of BaseClient as communicating
     * client
     */
    public void start(String hostname, int port, String rootUri, OutputStream traceStream)
        throws IOException, ExecutionException, InterruptedException {
        start(hostname, port, this, rootUri, traceStream);
    }

    /**
     * Establish connection to a Live Validation server using the concrete instance of BaseClient as communicating
     * client and disabling tracing
     */
    public void start(String hostname, int port, String rootUri)
        throws IOException, ExecutionException, InterruptedException {
        start(hostname, port, this, rootUri, null);
    }

    /**
     * Establish connection to a Live Validation server using the concrete instance of BaseClient as communicating
     * client without a root URI and disabling tracing
     */
    public void start(String hostname, int port)
        throws IOException, ExecutionException, InterruptedException {
        start(hostname, port, this, null, null);
    }

    /**
     * Disconnect from server
     */
    public void disconnect() {
        if (connectionInfo == null)
            throw new IllegalStateException("No connection to server to disconnect from");

        server.requestDisconnect().orTimeout(500, TimeUnit.MILLISECONDS)
            .whenComplete((result, e) -> {
                connectionInfo.getListener().cancel(true);
                server.bye();
                try {
                    connectionInfo.getInputStream().close();
                    connectionInfo.getOutputStream().close();
                    connectionInfo.getSocketChannel().close();
                } catch (IOException ex) {
                    // NOOP
                }
        });
    }

    /**
     * Request server shutdown
     */
    public void shutdownServer() {
        server.shutdown().orTimeout(500, TimeUnit.MILLISECONDS).whenComplete((result, e) -> server.exit());
    }

    @Override
    public void telemetryEvent(Object object) {
        // NOOP default implementation for convenience
    }

    @Override
    public void publishDiagnostics(PublishDiagnosticsParams diagnostics) {
        // NOOP default implementation for convenience
    }

    @Override
    public void showMessage(MessageParams messageParams) {
        // NOOP default implementation for convenience
    }

    @Override
    public CompletableFuture<MessageActionItem> showMessageRequest(ShowMessageRequestParams requestParams) {
        // NOOP default implementation for convenience
        return null;
    }

    @Override
    public void logMessage(MessageParams message) {
        // NOOP default implementation for convenience
    }
}

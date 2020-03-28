package de.fhdo.lemma.live_validation.clients

import de.fhdo.lemma.live_validation.protocol.LiveValidationLanguageClient
import de.fhdo.lemma.live_validation.protocol.LiveValidationServer
import de.fhdo.lemma.live_validation.common.LiveValidationLauncherBuilder
import de.fhdo.lemma.live_validation.protocol.notifyClientInitialized
import de.fhdo.lemma.live_validation.protocol.requestClientInitialization
import org.eclipse.lsp4j.services.LanguageServer
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.Channels
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/**
 * Base class for Live Validation clients like [AbstractLiveValidationInitiator] and [AbstractLiveValidator]. The class
 * establishes the connection to a Live Validation server, listens to incoming messages from the server, and allows
 * Live Validation clients to disconnect and shutdown the server.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class BaseClient {
    protected lateinit var server: LiveValidationServer

    /**
     * Helper object that reflects information related to the current server connection
     */
    private object ConnectionInfo {
        lateinit var inputStream: InputStream
        lateinit var outputStream: OutputStream
        lateinit var socketChannel: AsynchronousSocketChannel
        lateinit var serverListener: Future<Void>
    }

    /**
     * Establish connection to Live Validation server
     */
    fun start(hostname: String, port: Int, client: LiveValidationLanguageClient, rootUri: String? = null,
              traceStream: OutputStream? = null) {
        server = connectAndListen(hostname, port, client, traceStream)

        // Send LSP initialize request and initialized notification
        server.requestClientInitialization(rootUri)
        server.notifyClientInitialized()
    }

    /**
     * Connect to Live Validation server and start listening to incoming messages
     */
    private fun connectAndListen(hostname: String, port: Int, client: LiveValidationLanguageClient,
                                 traceStream: OutputStream?) : LiveValidationServer {
        with(ConnectionInfo) {
            val socketAddress = InetSocketAddress(hostname, port)
            socketChannel = AsynchronousSocketChannel.open()
            socketChannel.connect(socketAddress).get()

            inputStream = Channels.newInputStream(socketChannel)
            outputStream = Channels.newOutputStream(socketChannel)
            val launcherBuilder = LiveValidationLauncherBuilder<LanguageServer>()
                .setLocalService(client)
                .setRemoteInterface(LiveValidationServer::class.java)
                .setInput(inputStream)
                .setOutput(outputStream)
                .validateMessages(true)

            val launcher = if (traceStream != null)
                launcherBuilder.traceMessages(PrintWriter(traceStream)).create()
            else
                launcherBuilder.create()

            serverListener = launcher.startListening()
            return launcher.remoteProxy as LiveValidationServer
        }
    }

    fun disconnect() {
        with(ConnectionInfo) {
            val disconnectRequest = server.requestDisconnect()
            disconnectRequest.orTimeout(500, TimeUnit.MILLISECONDS)
                .whenComplete { _, _ ->
                    serverListener.cancel(true)
                    server.bye()
                    inputStream.close()
                    outputStream.close()
                    socketChannel.close()
                }
        }
    }

    fun shutdownServer() {
        server.shutdown().orTimeout(500, TimeUnit.MILLISECONDS).whenComplete { _, _ -> server.exit() }
    }
}
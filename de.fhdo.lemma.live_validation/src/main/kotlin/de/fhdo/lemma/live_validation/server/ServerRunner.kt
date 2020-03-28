package de.fhdo.lemma.live_validation.server

import de.fhdo.lemma.live_validation.ApplicationProperties
import de.fhdo.lemma.live_validation.LiveValidationCommandLine
import de.fhdo.lemma.live_validation.common.LiveValidationLauncherBuilder
import de.fhdo.lemma.live_validation.protocol.LiveValidationLanguageClient
import mu.KotlinLogging
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.core.config.Configurator
import org.eclipse.lsp4j.services.LanguageClient
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.Channels

private val LOGGER = KotlinLogging.logger {}

/**
 * Run a Live Validation server by executing the default implementation of
 * [de.fhdo.lemma.live_validation.protocol.LiveValidationServer] ([LiveValidationServerImpl]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    LiveValidationCommandLine(args)

    if (LiveValidationCommandLine.debug)
        Configurator.setRootLevel(Level.DEBUG)
    else if (LiveValidationCommandLine.quiet)
        Configurator.setRootLevel(Level.ERROR)

    runServer(
        LiveValidationCommandLine.hostname,
        LiveValidationCommandLine.port
    )
}

/**
 * Internal helper to run the default server implementation by leveraging LSP4J
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun runServer(hostname: String, port: Int) {
    LOGGER.info { "Starting Live Validation Server version ${ApplicationProperties["application.version"]}" }
    LOGGER.info { "Listening at $hostname:$port" }
    val serverSocket = AsynchronousServerSocketChannel.open()
    val inetSocketAddress = InetSocketAddress(hostname, port)
    serverSocket.bind(inetSocketAddress)
    while(true) {
        val socketChannel = serverSocket.accept().get()
        val inputStream = Channels.newInputStream(socketChannel)
        val outputStream = Channels.newOutputStream(socketChannel)

        val server = LiveValidationServerImpl()
        val launcherBuilder = LiveValidationLauncherBuilder<LanguageClient>()
            .setLocalService(server)
            .setRemoteInterface(LiveValidationLanguageClient::class.java)
            .setInput(inputStream)
            .setOutput(outputStream)
            .validateMessages(true)

        if (LiveValidationCommandLine.trace)
            launcherBuilder.traceMessages(PrintWriter(System.out))

        val launcher = launcherBuilder.create()
        val clientListener = launcher.startListening()
        server.setConnectionInfo(inputStream, outputStream, socketChannel, clientListener)

        val newClient = launcher.remoteProxy
        server.connect(newClient)
    }
}
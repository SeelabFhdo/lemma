package de.fhdo.lemma.live_validation.common

import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.jsonrpc.RemoteEndpoint
import org.eclipse.lsp4j.jsonrpc.json.MessageJsonHandler
import org.eclipse.lsp4j.jsonrpc.json.StreamMessageConsumer
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints
import java.lang.reflect.InvocationTargetException
import java.util.function.Function

/**
 * A Live-Validation-specific launcher builder based on LSP4J's [Launcher.Builder]. It alters the way how Live
 * Validation [servers](de.fhdo.lemma.live_validation.server.ServerRunner) and
 * [clients]((de.fhdo.lemma.live_validation.clients.BaseClient) cope with runtime exceptions (cf.
 * [LIVE_VALIDATION_EXCEPTION_HANDLER]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class LiveValidationLauncherBuilder<T> : Launcher.Builder<T>() {
    override fun createRemoteEndpoint(jsonHandler: MessageJsonHandler) : RemoteEndpoint {
        val outgoingMessageStream = wrapMessageConsumer(StreamMessageConsumer(output, jsonHandler))
        val remoteEndpoint = RemoteEndpoint(outgoingMessageStream, ServiceEndpoints.toEndpoint(localServices),
            LIVE_VALIDATION_EXCEPTION_HANDLER
        )
        jsonHandler.methodProvider = remoteEndpoint
        return remoteEndpoint
    }
}

/**
 * A Live-Validation-specific exception handler used by [LiveValidationLauncherBuilder]. It alters the behavior of the
 * default exception handler used in [Launcher.Builder] (cf. [RemoteEndpoint.DEFAULT_EXCEPTION_HANDLER]). Exceptions
 * during message exchange between LSP servers and clients are handled by LSP4J in that they are returned as LSP error
 * messages. However, this does not work, if the exception is nested in the runtime exception's "cause" field. This
 * handler is capable of dealing with such nested exceptions.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val LIVE_VALIDATION_EXCEPTION_HANDLER : Function<Throwable, ResponseError> = Function {
    var throwable = if (it is RuntimeException && it.cause is InvocationTargetException)
            (it.cause as InvocationTargetException).targetException
        else
            it

    RemoteEndpoint.DEFAULT_EXCEPTION_HANDLER.apply(throwable)
}
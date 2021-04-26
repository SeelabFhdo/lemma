package de.fhdo.lemma.live_validation.util;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.jsonrpc.RemoteEndpoint;
import org.eclipse.lsp4j.jsonrpc.json.MessageJsonHandler;
import org.eclipse.lsp4j.jsonrpc.json.StreamMessageConsumer;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/**
 * A Live-Validation-specific launcher builder based on LSP4J's Launcher.Builder. It alters the way how Live Validation
 * clients and servers cope with runtime exceptions.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public final class LiveValidationLauncherBuilder<T> extends Launcher.Builder<T> {
    /*
     * Live-Validation-specific exception handler that alters the behavior of the default exception handler used in
     * Launcher.Builder. Exceptions during message exchange between LSP servers and clients are handled by LSP4J in that
     * they are returned as LSP error messages. However, this does not work if the exception is nested in the runtime
     * exception's "cause" field. This handler is capable of dealing with such nested exceptions.
     */
    private static Function<Throwable, ResponseError> LIVE_VALIDATION_EXCEPTION_HANDLER = inputThrowable -> {
        var throwable = inputThrowable;

        if (inputThrowable instanceof RuntimeException &&
            inputThrowable.getCause() instanceof InvocationTargetException)
            throwable = ((InvocationTargetException) inputThrowable.getCause()).getTargetException();

        return RemoteEndpoint.DEFAULT_EXCEPTION_HANDLER.apply(throwable);
    };

    @Override
    protected RemoteEndpoint createRemoteEndpoint(MessageJsonHandler jsonHandler) {
        var outgoingMessageStream = wrapMessageConsumer(new StreamMessageConsumer(output, jsonHandler));
        var remoteEndpoint = new RemoteEndpoint(outgoingMessageStream, ServiceEndpoints.toEndpoint(localServices),
            LIVE_VALIDATION_EXCEPTION_HANDLER);
        jsonHandler.setMethodProvider(remoteEndpoint);
        return remoteEndpoint;
    }
}

package de.fhdo.lemma.live_validation.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * Helper class to store information related to the current server/client connection of a client/server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public class ConnectionInfo {
    private InputStream inputStream;
    private OutputStream outputStream;
    private AsynchronousSocketChannel socketChannel;
    private Future<Void> listener;

    public ConnectionInfo(InputStream inputStream, OutputStream outputStream, AsynchronousSocketChannel socketChannel,
        Future<Void> listener) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.socketChannel = socketChannel;
        this.listener = listener;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public AsynchronousSocketChannel getSocketChannel() {
        return socketChannel;
    }

    public Future<Void> getListener() {
        return listener;
    }
}

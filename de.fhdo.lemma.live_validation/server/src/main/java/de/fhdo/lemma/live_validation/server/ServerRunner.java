package de.fhdo.lemma.live_validation.server;

import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationLanguageClient;
import de.fhdo.lemma.live_validation.util.LiveValidationLauncherBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.eclipse.lsp4j.services.LanguageClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.Channels;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Run a Live Validation server by executing the LiveValidationServerImpl implementation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public class ServerRunner {
    private static final Logger LOGGER = LogManager.getRootLogger();
    static final String PROPERTY_RESOURCE_FILE = "live_validation.properties";

    /**
     * Server entrypoint
     */
    public static void main(String[] args) {
        var commandline = LiveValidationCommandLine.instance();
        commandline.parse(args);

        if (commandline.isDebug())
            Configurator.setRootLevel(Level.DEBUG);
        else if (commandline.isQuiet())
            Configurator.setRootLevel(Level.ERROR);

        try {
            runServer(commandline.getHostname(), commandline.getPort());
        } catch (Exception ex) {
            System.out.println("Error during server execution");
            ex.printStackTrace();
            System.out.println("Exiting.");
            System.exit(1);
        }
    }

    /**
     * Run the LiveValidationServerImpl implementation leveraging LSP4J
     */
    private static void runServer(String hostname, int port)
        throws IOException, ExecutionException, InterruptedException {
        LOGGER.info("Starting Live Validation Server version {}",
            ApplicationProperties.instance().get("application.version"));
        LOGGER.info("Listening at {}:{}", hostname, port);
        var serverSocket = AsynchronousServerSocketChannel.open();
        var inetSocketAddress = new InetSocketAddress(hostname, port);
        serverSocket.bind(inetSocketAddress);
        while(true) {
            var socketChannel = serverSocket.accept().get();
            var inputStream = Channels.newInputStream(socketChannel);
            var outputStream = Channels.newOutputStream(socketChannel);

            var server = new LiveValidationServerImpl();
            var launcherBuilder = new LiveValidationLauncherBuilder<LanguageClient>()
                .setLocalService(server)
                .setRemoteInterface(LiveValidationLanguageClient.class)
                .setInput(inputStream)
                .setOutput(outputStream)
                .validateMessages(true);

            if (LiveValidationCommandLine.instance().isTrace())
                launcherBuilder.traceMessages(new PrintWriter(System.out));

            var launcher = launcherBuilder.create();
            var clientListener = launcher.startListening();
            var newClient = launcher.getRemoteProxy();

            server.setConnectionInfo(inputStream, outputStream, socketChannel, clientListener);
            server.connect(newClient);
        }
    }

    /**
     * Singleton to enable a uniform access to the application's properties at runtime
     */
    private static class ApplicationProperties {
        private static ApplicationProperties INSTANCE;

        private final Properties properties = new Properties();

        private ApplicationProperties(String filename) {
            try {
                properties.load(this.getClass().getClassLoader().getResourceAsStream(filename));
            } catch (IOException e) {
                System.out.printf("Application properties could not be loaded from resource \"%s\". Exiting.",
                    filename);
                System.exit(1);
            }
        }

        private static ApplicationProperties instance() {
            if (INSTANCE == null)
                INSTANCE = new ApplicationProperties(ServerRunner.PROPERTY_RESOURCE_FILE);

            return INSTANCE;
        }

        /**
         * Get property from the property resource file
         */
        public Object get(String propertyName) {
            return properties.get(propertyName);
        }
    }
}

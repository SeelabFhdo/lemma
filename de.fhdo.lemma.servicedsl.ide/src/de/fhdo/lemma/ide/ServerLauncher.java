package de.fhdo.lemma.ide;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
/**
 * In this code, a language server of the Domain Data Modeling Language will be created based upon Xtext implementations of the language server. Then, the a launcher for it will be started and will listen to either default or custom host and port from the execution arguments. 
 * The language server will be shipped as a Fat JAR created in the Maven build process with this launcher as the starting point.
 * This code is based upon the language server launcher from Ph.D. Edmundo Lopez Bobeda, described <a href="https://idiomaticsoft.com/post/2022-04-27-create-the-language/">here</a>.
 * @author <a href="mailto:marcel.mitas@fh-dortmund.de">Marcel Mitas</a>
 */
public class ServerLauncher {
	
	public static String host = "localhost";
	public static int port = 5009;
	private static int tooManyExceptionsCount = 0; // Simple counter for counting upcoming exceptions
	private static long timeout = 60000; // Time a ceration amount of exceptions should not be thrown
	private static long millisecondsCount = 0; //Time elapsed between the exception throw and "timeout"
	private static int maxTooManyExceptionsCount = 5; // Maximum number of exceptions that should be thrown in a certain amount of time
	
	public static void main(String[] args) {
		//Listen to execution arguments for the host and port the language server will listen to
		if(args.length > 0 && !args[0].isEmpty() && !args[0].isBlank()) {
			host = args[0];
		}
		
		if(args.length > 1 && !args[1].isEmpty() && !args[1].isBlank() && args[1].matches("[1-9][0-9]{0,4}")) {
			port = Integer.parseInt(args[1]);
		}
		System.out.printf("Language Server will listen to:\n Host: %s\n Port: %d\n", host, port);
		
		//Creating the language server based upon the Xtext implementation and the language definitions
		Injector injector = Guice.createInjector(new ServerModule());
		LanguageServerImpl languageServer = injector.getInstance(LanguageServerImpl.class);
		Function<MessageConsumer, MessageConsumer> wrapper = consumer -> {
			MessageConsumer result = consumer;
			return result;
		};
		
		long launcherStart = System.currentTimeMillis(); //For measuring the time an error occurs between launcher creation and an exception
		try {
			//Creating the socket launcher with the language server to be accessed, the language client as the interface for the access, the host and port to be listened to and other arguments
			Launcher<LanguageClient> launcher = createSocketLauncher(languageServer, LanguageClient.class,
					new InetSocketAddress(host, port), Executors.newCachedThreadPool(), wrapper);
			
			//Starting the launcher, if created
			if(launcher != null) {
				languageServer.connect(launcher.getRemoteProxy());
				Future<?> future = launcher.startListening();
				System.out.printf("Language Server started.\n");
				while (!future.isDone()) {
					Thread.sleep(10_000l);
				}
			}
			else {
				System.out.println("Error while creating the language server socket. Terminating.");
				System.exit(1);
			}
		}
		catch(IOException | InterruptedException error) {
			long launcherStop = System.currentTimeMillis();
			System.out.printf("Servere error detected: \n");
			error.printStackTrace();
			millisecondsCount += launcherStop - launcherStart;
			tooManyExceptionsCount++;
			if(tooManyExceptionsCount == maxTooManyExceptionsCount && millisecondsCount <= timeout) {
				System.out.printf("Too many errors detected in a short time. Terminating");
				System.exit(1);
			}
			if(millisecondsCount > timeout) {
				millisecondsCount = 0;
				tooManyExceptionsCount = 0;
			}
			System.out.printf("Restarting...\n");
			main(args);
		} 
	}

	/**
	 * Method creating the socket launcher.
	 * @param <T> Type of the object to be launched for the access of the language server, here the type "LanguageClient".
	 * @param localService The local service to be accessed, here the language server.
	 * @param remoteInterface The class of the remote interface for the access of the local service, here the class of the language client.
	 * @param socketAddress The socket address with the host and port to be listened to.
	 * @param executorService An executor service.
	 * @param wrapper The message consumer wrapper.
	 * @return The launcher for T, here the language client.
	 * @throws IOException
	 */
	static <T> Launcher<T> createSocketLauncher(Object localService, Class<T> remoteInterface,
			SocketAddress socketAddress, ExecutorService executorService,
			Function<MessageConsumer, MessageConsumer> wrapper) throws IOException {
		try (AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(socketAddress)) {
			AsynchronousSocketChannel socketChannel;
				socketChannel = serverSocket.accept().get();
				return Launcher.createIoLauncher(localService, remoteInterface, Channels.newInputStream(socketChannel),
						Channels.newOutputStream(socketChannel), executorService, wrapper);
		}	 
		catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		return null;
	}
}
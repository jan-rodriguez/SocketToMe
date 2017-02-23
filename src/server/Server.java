package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        // Start a server listening on port 9090
        try (ServerSocket listener = new ServerSocket(9090)) {
            System.out.println("Running server");
            // Run the server forever
            while (true) {
                // Make a connection with whatever client wants to connect
                try (Socket socket = listener.accept()) {
                    // Get the stream of input for the socket
                    final PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    // Send the current date to the client that connected
                    out.println(new Date().toString());
                }
            }
        }
    }
}

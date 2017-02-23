package client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException {
        // Type in localhost to connect to your curernt computer
        final String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                        "running the date service on port 9090:");
        // Connect to the specified address on the previous lin
        final Socket s = new Socket(serverAddress, 9090);
        // Receive the input from the socket connection
        final BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        final String answer = input.readLine();
        // Show a dialog with the message from the socket
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}

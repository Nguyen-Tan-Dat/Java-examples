package org.dat.javasample.socket;

import java.io.*;
import java.net.*;

public class MyServer extends MyClient {
    private final ServerSocket serverSocket;

    public MyServer() throws IOException {
        super(null);
        serverSocket = new ServerSocket(6666);
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void accept() {
        try {
            System.out.println("Waiting for clients to connect...");
            socket = serverSocket.accept();
            System.out.println("Connected to client " + socket.getInetAddress());
        } catch (IOException e) {
            System.out.println("Error accept");
        }
    }
}

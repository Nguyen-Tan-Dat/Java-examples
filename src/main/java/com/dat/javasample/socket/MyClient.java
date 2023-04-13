package com.dat.javasample.socket;

import java.io.*;
import java.net.*;

public class MyClient {
    protected Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
        System.out.println("Connected to the server");
    }

    public String receiveInfoString() {
        try {
            InputStream inputStream = socket.getInputStream();
            if (inputStream == null) return "";
            return (new DataInputStream(inputStream)).readUTF();
        } catch (IOException e) {
            System.out.println("Socket is closed");
            return null;
        }
    }

    public int receiveInfoInt() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            return input.readInt();
        } catch (IOException e) {
            return 0;
        }
    }

    public void sendInfo(int info) throws IOException {
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeInt(info);
        output.flush();
    }

    public void sendInfo(String info) throws IOException {
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF(info);
        output.flush();
    }
}
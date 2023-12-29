package org.dat.javasample.socket;

import java.io.IOException;

public class DictionaryServer {
    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer();
        server.accept();
        Dictionary dictionary = new Dictionary();
        try {
            String input = server.receiveInfoString();
            while (true) {
                assert input != null;
                if (input.equalsIgnoreCase("bye")) {
                    server.sendInfo(input);
                    break;
                }
                String[] data = input.split(";");
                if (data.length == 1) server.sendInfo(dictionary.translateWord(input));
                else if (data.length == 3 && data[0].equals("ADD"))
                    server.sendInfo(dictionary.addWord(data[1], data[2]));
                else if (data.length == 2 && data[0].equals("DEL"))
                    server.sendInfo(dictionary.deleteWord(data[1]));
                else server.sendInfo("Syntax error");
                input = server.receiveInfoString();
            }
        } catch (Exception ignored) {

        }
    }
}

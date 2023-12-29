package org.dat.javasample.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DictionaryClient {
    public static void main(String[] args) {
        try {
            MyClient client = new MyClient(new Socket("localhost", 6666));
            String input="";
            while (!input.equals("bye")) {
                input=new Scanner(System.in).nextLine();
                client.sendInfo(input);
                System.out.println(client.receiveInfoString());
            }
        } catch (IOException e) {
            System.out.println("Exited the program");
        }
    }
}

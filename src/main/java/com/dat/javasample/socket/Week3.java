package com.dat.javasample.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

class Week3_Exercise1 {
    public static void main(String[] args) {
        String input = (new Scanner(System.in)).nextLine();
        try {
            InetAddress inetAddress = InetAddress.getByName(input);
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not find: " + input);
        }
    }
}

class Week3_Exercise2 {
    public static void main(String[] args) {

    }
}
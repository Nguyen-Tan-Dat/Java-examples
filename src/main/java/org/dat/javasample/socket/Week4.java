package org.dat.javasample.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

class Week4_Exercise1_Server {
    public static String reverseString(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = string.length() - 1; i > -1; i--)
            result.append(string.charAt(i));
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        MyServer server =new MyServer();
        server.accept();
        while (true) {
            String input = server.receiveInfoString();
            assert input != null;
            if (input.equalsIgnoreCase("bye")) break;
            server.sendInfo( Week4_Exercise1_Server.reverseString(input));
        }
    }
}

class Week4_Exercise1_Client {

    public static void main(String[] args) throws IOException {
        try {

            Scanner scan = new Scanner(System.in);
            MyClient client=new MyClient(new Socket("localhost", 6666));
            while (true) {
                String input = scan.nextLine();
                client.sendInfo( input);
                if (input.equalsIgnoreCase("bye")) break;
                System.out.println(client.receiveInfoString());
            }
        } catch (IOException e) {
            System.out.println("Connect don't exit");
        }
    }
}

class Week4_Exercise2_Server {
    private static boolean isPerfect(long n) {
        long sum = 1;
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0)
                if (i * i != n) sum = sum + i + n / i;
                else sum = sum + i;
        return sum == n && n != 1;
    }

    public static long nextPerfect(int n) {
        for (long i = n + 1; i < Long.MAX_VALUE; i++)
            if (isPerfect(i)) return i;
        return 0;
    }

    public static long nearestPerfect(int a) {
        long n = a;
        for (int p = a; p > 0; p--) {
            if (isPerfect(p)) return p;
            if (isPerfect(n)) return n;
            n++;
        }
        for (; n < Long.MAX_VALUE; n++)
            if (isPerfect(n)) return n;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer();
        server.accept();
        while (true) {
            int input = server.receiveInfoInt();
            if (isPerfect(input)) server.sendInfo( true + "");
            else {
                String result = nextPerfect(input) + ";";
                result += nearestPerfect(input);
                server.sendInfo( result);
            }
        }
    }
}

class Week4_Exercise2_Client {
    public static void main(String[] args) throws IOException {
        try {
            MyClient client = new MyClient(new Socket("localhost", 6666));
            Scanner scan = new Scanner(System.in);
            while (true) {
                int input = scan.nextInt();
                client.sendInfo( input);
                StringTokenizer result = new StringTokenizer(Objects.requireNonNull(client.receiveInfoString()), ";");
                System.out.println("Số hoàn hảo lớn hơn " + result.nextToken());
                System.out.println("Số hoàn hảo gần nhất " + result.nextToken());
            }
        } catch (IOException e) {
            System.out.println("Connect don't exit");
        }
    }
}

class Week4_Exercise3_Server {
    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer();
        server.accept();
        while (true) {
            int input = server.receiveInfoInt();
            server.sendInfo( input + " = " + Week1.primeFactorization(input));
        }
    }
}

class Week4_Exercise3_Client {
    public static void main(String[] args) throws IOException {
        try {
            MyClient client = new MyClient(new Socket("localhost", 6666));
            Scanner scan = new Scanner(System.in);
            while (true) {
                int input = scan.nextInt();
                client.sendInfo( input);
                StringTokenizer result = new StringTokenizer(Objects.requireNonNull(client.receiveInfoString()), ";");
                System.out.println("Số hoàn hảo lớn hơn " + result.nextToken());
                System.out.println("Số hoàn hảo gần nhất " + result.nextToken());
            }
        } catch (IOException e) {
            System.out.println("Connect don't exit");
        }
    }
}

class Week4_Exercise4_Client {
    public static void main(String[] args) throws IOException {
        try {
            MyClient client = new MyClient(new Socket("localhost", 6666));
            Scanner scan = new Scanner(System.in);
            while (true) {
                int input = scan.nextInt();
                client.sendInfo( input);
                System.out.println(client.receiveInfoString());
            }
        } catch (IOException e) {
            System.out.println("Connect don't exit");
        }
    }
}

class Week4_Exercise4_Server {
    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer();
        server.accept();
        int number = new Random().nextInt(101);
        double start = System.nanoTime();
        while (true) {
            int input = server.receiveInfoInt();
            if (number > input) server.sendInfo( "Number > " + input);
            else if (number < input) server.sendInfo( "Number < " + input);
            else
                server.sendInfo( "Secret number is " + input + ". Search time is " + (int) ((System.nanoTime() - start) / 1000000000)+" seconds.");
        }
    }
}
class Week4_Exercise5_Server{
    public static void main(String[] args) throws IOException  {
        MyServer server = new MyServer();
        server.accept();
        while (true) {
            String input = server.receiveInfoString();
            try {
                server.sendInfo(Week2_Exercise1.calculate(input).toString());
            } catch (IOException e) {
                server.sendInfo("Syntax error");
            }
        }
    }
}
class Week4_Exercise5_Client{
    public static void main(String[] args) throws IOException {
        try {
            MyClient client = new MyClient(new Socket("localhost", 6666));
            Scanner scanner=new Scanner(System.in);
            while (true) {
                client.sendInfo(scanner.nextLine());
                System.out.println(client.receiveInfoString());
            }
        }catch(IOException e){
            System.out.println("Error connection");
        }
    }
}
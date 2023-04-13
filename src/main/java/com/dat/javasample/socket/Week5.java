package com.dat.javasample.socket;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Scanner;

class Week5_Exercise1_Server {
    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer();
        server.accept();
        Dictionary dictionary = new Dictionary();
        while (true) {
            String input = server.receiveInfoString();
            server.sendInfo(dictionary.translateWord(input));
        }
    }
}

class Week5_Exercise1_Client {
    public static void main(String[] args) {
        try {
            MyClient client= new MyClient(new Socket("localhost", 6666));
            while (true) {
                client.sendInfo((new Scanner(System.in)).nextLine());
                System.out.println(client.receiveInfoString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Week5_Exercise2_Server {

    static class IpInfo {
        private String city, country, continent;

        public IpInfo(String city, String country, String continent) {
            this.city = city;
            this.country = country;
            this.continent = continent;
        }

        @Override
        public String toString() {
            return "Thành phố: " + this.city + "\nQuốc gia: " + this.country + "\nChâu lục: " + this.continent;
        }
    }

    public static JSONObject getJSONObject(String url) {
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            StringBuilder stringBuilder = new StringBuilder();
            int cp;
            while ((cp = reader.read()) != -1)
                stringBuilder.append((char) cp);
            return new JSONObject(stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findInfoIp(String ip) {
        String url = "http://ip-api.com/json/" + ip + "?fields=status,message,continent,country,city";
        JSONObject jsonObject = getJSONObject(url);
        if (jsonObject.get("status").equals("success"))
            return (new IpInfo((String) jsonObject.get("city"),
                    (String) jsonObject.get("country"),
                    (String) jsonObject.get("continent"))).toString();
        return jsonObject.get("message").toString() + " ip!";
    }

    public static void main(String[] args) {
        try {
            MyServer server = new MyServer();
            server.accept();
            while (true) {
                String input = server.receiveInfoString();
                try {
                    if (input.equals("hello")) {
                        String publicIP = server.getServerSocket().getInetAddress().toString();
                        String privateIP = InetAddress.getLocalHost().getHostAddress();
                        server.sendInfo("Public ip : " + publicIP + "\nPrivate ip : " + privateIP);
                    } else {
                        String[] syntax = input.split(" ");
                        if (syntax[0].equals("req")) server.sendInfo(findInfoIp(syntax[1]));
                        else server.sendInfo("Syntax errors");
                    }
                } catch (Exception e) {
                    server.sendInfo("Syntax errors");
                }
            }
        } catch (Exception e) {
            System.out.println("Server not valid");
        }
    }
}

class Week5_Exercise2_Client {
    public static void main(String[] args) {
        try {
            MyClient client= new MyClient(new Socket("localhost", 6666));
            System.out.println("Connected server");
            while (true) {
                client.sendInfo((new Scanner(System.in)).nextLine());
                System.out.println(client.receiveInfoString());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Week5_Exercise3_Server {
    public static void main(String[] args) throws IOException {
        String url = "http://thongtindaotao.sgu.edu.vn/Default.aspx?page=xemdiemthi&id=3118410076";
        InputStream inputStream = new URL(url).openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1)
            stringBuilder.append((char) cp);
        Document html = Jsoup.parse(stringBuilder.toString());
        Elements tables=html.getElementsByTag("table");
        System.out.println(tables.get(0).text());
    }
}
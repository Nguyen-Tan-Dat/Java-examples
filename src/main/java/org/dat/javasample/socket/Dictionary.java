package org.dat.javasample.socket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dictionary {
    private HashMap<String, String> words = null;
    private final String pathFile = "src/main/java/NetworkProgramming/dictionary.txt";

    public Dictionary() {
        readData();
    }

    public void readData() {
        words = new HashMap<>();
        try {
            File myObj = new File(pathFile);
            Scanner myReader = new Scanner(myObj);
            try {
                while (myReader.hasNextLine()) {
                    StringTokenizer data = new StringTokenizer(myReader.nextLine(), ";");
                    words.put(data.nextToken(), data.nextToken());
                }
            } catch (Exception e) {
                System.out.println("Data file error");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary read error!");
        }
    }

    public HashMap<String, String> getWords() {
        return words;
    }

    private void writeData(String data, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, append);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error write data");
        }
    }

    public String addWord(String english, String vietnamese) {
        if (words.get(english) != null) return "The word is already in the dictionary";
        writeData(english.toLowerCase() + ";" + vietnamese.toLowerCase() + "\n", true);
        words.put(english, vietnamese);
        return "Add complete";
    }

    public String deleteWord(String english) {
        if(words.get(english) == null) return "Delete word does not exist";
        words.remove(english.toLowerCase());
        StringBuilder data = new StringBuilder();
        for (String key : words.keySet())
            data.append(key).append(";").append(words.get(key)).append("\n");
        this.writeData(data.toString(), false);
        return "Delete complete";
    }

    public String translateWord(String word) {
        try {
            String input = word.toLowerCase();
            if (words.get(input) != null) return words.get(input);
            if (words.containsValue(input))
                for (String key : words.keySet())
                    if (words.get(key).equals(input))
                        return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Not in the dictionary";
    }
}
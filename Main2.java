package ru.itis.inf304.lab6.dz;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main2{
    public static void main(String[] args) {
        Map<Character, Integer> charcount = new HashMap<>();
        try (FileReader reader = new FileReader("C:\\javaprojects\\firstyear\\2 chapter\\2) class\\lab6\\src\\main\\java\\ru\\itis\\inf304\\lab6\\dz\\file4.txt")){
            int c;
            while ((c = reader.read()) != -1) {
                char character = (char) c;
                if (charcount.containsKey(character)){
                    charcount.put(character, charcount.get(character) + 1);
                } else {
                    charcount.put(character, 1);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        for (Map.Entry<Character, Integer> entry : charcount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
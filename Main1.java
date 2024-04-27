package ru.itis.inf304.lab6.dz;
import java.io.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream file1 = new FileInputStream("C:\\javaprojects\\firstyear\\2 chapter\\2) class\\lab6\\src\\main\\java\\ru\\itis\\inf304\\lab6\\dz\\file1.txt");
             FileInputStream file2 = new FileInputStream("C:\\javaprojects\\firstyear\\2 chapter\\2) class\\lab6\\src\\main\\java\\ru\\itis\\inf304\\lab6\\dz\\file2.txt");
             FileOutputStream fileResult = new FileOutputStream("C:\\javaprojects\\firstyear\\2 chapter\\2) class\\lab6\\src\\main\\java\\ru\\itis\\inf304\\lab6\\dz\\fileResult.txt")) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = file1.read(buffer)) != -1) {
                fileResult.write(buffer, 0, bytesRead);
            }

            while ((bytesRead = file2.read(buffer)) != -1) {
                fileResult.write(buffer, 0, bytesRead);
            }

            System.out.println("Files merged successfully: " + fileResult);
        } catch (IOException e) {
            System.out.println("Error merging files: " + e.getMessage());
        }



    }
}

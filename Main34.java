package ru.itis.inf304.lab6.dz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Main34 {
    public static void main(String[] args) {
        String message = "Hello world";
        createMessageFile(message);
        readMessageFile();
    }

    public static void createMessageFile(String message) {
        byte[] messageBytes = message.getBytes();
        int messageLength = messageBytes.length;

        try (FileOutputStream fos = new FileOutputStream("message.bin")) {

            fos.write(ByteBuffer.allocate(4).putInt(messageLength).array());

            fos.write(messageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMessageFile() {
        try (FileInputStream fis = new FileInputStream("message.bin")) {

            byte[] lengthBytes = new byte[4];
            fis.read(lengthBytes);
            int messageLength = ByteBuffer.wrap(lengthBytes).getInt();
            System.out.println("Длина сообщения: " + messageLength);


            byte[] messageBytes = new byte[messageLength];
            fis.read(messageBytes);
            String message = new String(messageBytes);
            System.out.println("Сообщение: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

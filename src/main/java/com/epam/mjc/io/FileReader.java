package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0L;
        try (FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            String line = "";
            while (true) {
                int iByte = fileInputStream.read();
                if (iByte != -1) {
                    line += (char) iByte;
                } else {
                    break;
                }
            }
            String[] value = line.split("\\R");
            name = value[0].split(" ")[1];
            age = Integer.parseInt(value[1].split(" ")[1]);
            email = value[2].split(" ")[1];
            phone = Long.parseLong(value[3].split(" ")[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}

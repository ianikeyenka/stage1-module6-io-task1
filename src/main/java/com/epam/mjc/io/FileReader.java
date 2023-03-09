package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
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
            String name =  value[0].split(" ")[1];
            Integer age =  Integer.parseInt(value[1].split(" ")[1]);
            String email =  value[2].split(" ")[1];
            Long phone =  Long.parseLong(value[3].split(" ")[1]);
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

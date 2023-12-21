package com.example.geektrust.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInput {
    public FileInput() {
    }

    public String getInputDataFromFile(String filePath) {
        StringBuilder data = new StringBuilder();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                //Add your code here to process input commands
                data.append(sc.nextLine());
                data.append("\n");
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e);
        }

        return data.toString();
    }
}

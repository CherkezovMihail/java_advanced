package org.example.lab;

import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Set;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("resources/output.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String line = reader.readLine();

        int lineCnt = 1;

        while (line != null) {

            if (lineCnt % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            lineCnt++;
            line = reader.readLine();
        }

        writer.close();
    }
}
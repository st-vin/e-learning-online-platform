package io;
import java.io.*;

import java.io.FileReader;

public class FileProcessor {
    /*
    * reads input.txt
    * convert each line to uppercase
    * write output to output.txt using Character Streams
    *
    */
    public void processFile() {
        // try-with-resources for safe automatic closing
        try (BufferedReader reader = new BufferedReader(new FileReader("src/io/input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/io/output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String upper = line.toUpperCase();
                writer.write(upper);
                writer.newLine(); // preserve line structure
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }
            }
        }


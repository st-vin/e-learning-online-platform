package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CourseFileProcessor implements Runnable {

    private final File file;

    public CourseFileProcessor(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Processing file: " + file.getName());

            String line;
            while ((line = reader.readLine()) != null) {
                // Simulate "processing" the course file
                System.out.println(Thread.currentThread().getName() + " -> " + line);
            }

        } catch (IOException e) {
            System.err.println(file.getName() + ": " + e.getMessage());
        }
    }
}

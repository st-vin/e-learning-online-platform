package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCountTask implements Runnable {

    private final File file;

    private final SharedWordCounter counter;

    public WordCountTask(File file, SharedWordCounter counter) {
        this.file = file;
        this.counter = counter;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int words = line.split("\\s+").length;
                counter.increment(words);
            }

        } catch (IOException e) {
            System.err.println(file.getName() + ": " + e.getMessage());
        }
    }
}

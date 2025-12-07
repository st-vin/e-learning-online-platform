import io.CourseFileProcessor;
import io.FileProcessor;
import io.SharedWordCounter;
import io.WordCountTask;

import java.io.File;

public class IOMain {
    public static void main(String[] args) {

        // ---- PART 1: Character Stream Processing ----
        FileProcessor fp = new FileProcessor();
        fp.processFile();
        System.out.println("input.txt processed into output.txt\n");


        // ---- PART 2: Concurrency ----

        // Example course files directory (you must place sample text files here)
        File folder = new File("src/io/courses");
        File[] courseFiles = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (courseFiles == null || courseFiles.length == 0) {
            System.out.println("No course files found in /courses directory.");
            return;
        }

        // ---- TASK 1: Process multiple course files concurrently ----
        System.out.println("Starting concurrent course file processing...\n");

        for (File f : courseFiles) {
            Thread t = new Thread(new CourseFileProcessor(f), "Worker-" + f.getName());
            t.start();
        }

        // ---- TASK 2: Shared Word Count Across Multiple Files ----
        SharedWordCounter sharedCounter = new SharedWordCounter();

        System.out.println("\nStarting shared word counting across files...\n");

        Thread[] counters = new Thread[courseFiles.length];
        for (int i = 0; i < courseFiles.length; i++) {
            counters[i] = new Thread(new WordCountTask(courseFiles[i], sharedCounter));
            counters[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : counters) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }

        System.out.println("Total word count across all files: " + sharedCounter.getCount());
    }
}
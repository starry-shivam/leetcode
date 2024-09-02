package utils;

import java.util.logging.Logger;

/**
 * Utility class to measure and print the execution time of a function.
 */
public class ExecDuration {

    public static void measure(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();
        long durationInMs = (endTime - startTime) / 1_000_000;
        System.out.println("Execution Time: " + durationInMs + " ms");
    }

    public static void main(String[] args) {
        measure(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getGlobal().severe(e.getMessage());
            }
        });
    }
}

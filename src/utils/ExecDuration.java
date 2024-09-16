package utils;

/**
 * Utility class to measure and print the execution time of a function.
 */
public class ExecDuration {

    // Measure and print the execution time of a function in microseconds.
    public static void measure(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println("Execution time: " + duration + " microseconds");
    }

    public static void measureInMs(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Execution time: " + duration + " milliseconds");
    }
}

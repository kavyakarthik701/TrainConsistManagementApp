/**
 * ================================================================
 * MAIN CLASS – UseCase13TrainConsistMgmt
 * ================================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime().
 *
 * At this stage, the application:
 *  - Creates bogie test dataset
 *  - Measures loop execution time
 *  - Measures stream execution time
 *  - Calculates elapsed duration
 *  - Displays performance results
 *
 * This maps performance benchmarking using high-resolution timing.
 *
 * @author Developer
 * @version 13.0
 */

import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // ================================================================
    // Bogie Model
    // ================================================================
    static class Bogie {

        String type;   // Type of bogie
        int capacity;  // Capacity in tons

        // Constructor
        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // ================================================================
    // MAIN METHOD
    // ================================================================
    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=====================================================\n");

        // --------------------------------------------------------------
        // Step 1: Create large test dataset
        // --------------------------------------------------------------
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == 0) {
                bogies.add(new Bogie("Heavy", 80));
            } else {
                bogies.add(new Bogie("Light", 40));
            }
        }

        // --------------------------------------------------------------
        // Step 2: Loop-based filtering (capacity > 50)
        // --------------------------------------------------------------
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 50) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // --------------------------------------------------------------
        // Step 3: Stream-based filtering (capacity > 50)
        // --------------------------------------------------------------
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 50)
                .toList();

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // --------------------------------------------------------------
        // Step 4: Display performance results
        // --------------------------------------------------------------
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}
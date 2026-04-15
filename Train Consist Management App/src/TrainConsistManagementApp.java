import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * MAIN CLASS - UseCase20TrainConsistMgmnt
 * ============================================================================
 * * Use Case 20: Prevent Search on Empty Collection
 * * Description:
 * This class demonstrates defensive programming by throwing an 
 * IllegalStateException if a search is attempted on an empty bogie list.
 * * At this stage, the application:
 * - Initializes an empty bogie collection
 * - Validates the state of the collection before searching
 * - Throws IllegalStateException if empty
 * - Provides a meaningful error message
 * * This maps the Fail-Fast principle and robust state validation.
 * * @author Developer
 * @version 20.0
 */
public class UseCase20TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" UC20 - Defensive State Validation ");
        System.out.println("==============================================\n");

        // Step 1: Initialize an empty collection (simulating a train with no bogies)
        List<String> trainConsist = new ArrayList<>();
        String searchKey = "BG309";

        try {
            // Step 2: Perform the search operation
            performSearch(trainConsist, searchKey);
            
        } catch (IllegalStateException e) {
            // Step 5: User receives a meaningful error message
            System.err.println("CRITICAL ERROR: " + e.getMessage());
        }

        System.out.println("\nUC20 execution flow completed.");
    }

    /**
     * Searches for a bogie ID but validates the train state first.
     */
    public static void performSearch(List<String> consist, String key) {
        System.out.println("Initiating search for: " + key + "...");

        // ---- STATE VALIDATION (Defensive Programming) ----
        // Step 2 & 3: Check if empty and throw exception early
        if (consist.isEmpty()) {
            throw new IllegalStateException("Search failed: The train consist is empty. Please add bogies before searching.");
        }

        // This part of the code is never reached if the list is empty
        // (Fail-Fast Principle)
        for (String bogie : consist) {
            if (bogie.equals(key)) {
                System.out.println("Bogie found!");
                return;
            }
        }
        System.out.println("Bogie not found.");
    }
}

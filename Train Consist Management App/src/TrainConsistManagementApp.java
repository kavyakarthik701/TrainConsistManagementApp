import java.util.Arrays;

/**
 * ============================================================================
 * MAIN CLASS - UseCase17TrainConsistMgmnt
 * ============================================================================
 * * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * * Description:
 * This class demonstrates sorting of bogie type names
 * alphabetically using Java's built-in Arrays.sort() method.
 * * At this stage, the application:
 * - Creates an array of bogie names
 * - Uses Arrays.sort() for sorting
 * - Displays sorted results
 * * This maps optimized sorting using Java library utilities.
 * * @author Developer
 * @version 17.0
 */
public class UseCase17TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("==============================================\n");

        // Create an array of bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original bogie names
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Use Arrays.sort() for alphabetical sorting
        // This is an optimized Dual-Pivot Quicksort for primitives/objects
        Arrays.sort(bogieNames);

        // Display sorted results (Alphabetical)
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}

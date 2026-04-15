/**
 * ============================================================================
 * MAIN CLASS - UseCase19TrainConsistMgmnt
 * ============================================================================
 * * Use Case 19: Binary Search for Bogie ID
 * * Description:
 * This class demonstrates searching for a specific bogie ID
 * using an optimized Binary Search algorithm on sorted data.
 * * * At this stage, the application:
 * - Creates a sorted array of bogie IDs
 * - Accepts a search key
 * - Implements divide-and-conquer logic (low, high, mid)
 * - Uses compareTo() for String comparison
 * - Displays the search result
 * * * @author Developer
 * @version 19.0
 */
public class UseCase19TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("==============================================\n");

        // PRECONDITION: The data MUST be sorted
        String[] sortedBogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG412";

        System.out.println("Sorted Bogie IDs: ");
        for (String id : sortedBogieIds) System.out.print(id + " ");
        System.out.println("\nSearching for: " + searchKey + "\n");

        // ---- BINARY SEARCH LOGIC ----
        int low = 0;
        int high = sortedBogieIds.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // Compare searchKey with the middle element
            int comparison = searchKey.compareTo(sortedBogieIds[mid]);

            if (comparison == 0) {
                // Key found!
                foundIndex = mid;
                break;
            } else if (comparison > 0) {
                // Key is in the upper half
                low = mid + 1;
            } else {
                // Key is in the lower half
                high = mid - 1;
            }
        }

        // Display result
        if (foundIndex != -1) {
            System.out.println("SUCCESS: Bogie " + searchKey + " found at position " + (foundIndex + 1) + ".");
        } else {
            System.out.println("FAILURE: Bogie " + searchKey + " not found in the consist.");
        }

        System.out.println("\nUC19 binary search completed...");
    }
}

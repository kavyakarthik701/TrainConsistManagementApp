import java.util.LinkedList;
import java.util.List;

/**
 * =========================================================================
 * MAIN CLASS - UseCase4TrainConsistMgmnt
 * =========================================================================
 * * Use Case 4: Maintain Ordered Bogie Consist
 * * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 * * At this stage, the application:
 * - Adds bogies in sequence
 * - Inserts bogies at specific positions
 * - Removes bogies from front and rear
 * - Displays updated train structure
 * * This maps positional operations using LinkedList.
 * * @author Developer
 * @version 4.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("================================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        LinkedList<String> trainConsist = new LinkedList<>();

        // ---- ADD bogies in sequence ----
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        System.out.println();

        // ---- INSERT bogie at specific position ----
        // Inserting 'Pantry Car' at position 2 (index starts at 0)
        trainConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);
        System.out.println();

        // ---- REMOVE bogies from front and rear ----
        trainConsist.removeFirst(); // Removes Engine
        trainConsist.removeLast();  // Removes Guard

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("UC4 ordered consist operations completed...");
    }
}
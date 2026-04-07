import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ============================================================
 * MAIN CLASS - UseCase11TrainConsistMgmt
 * ============================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code
 *
 * Description:
 * This class validates input formats using Regular Expressions.
 *
 * At this stage, the application:
 * - Accepts Train ID input
 * - Accepts Cargo Code input
 * - Applies regex validation
 * - Displays validation result
 *
 * This maps format validation logic using Pattern matching.
 *
 * @author Developer
 * @version 11.0
 */

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("========================================\n");

        Scanner scanner = new Scanner(System.in);

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        Pattern trainIdPattern = Pattern.compile("^TRN-\\d{4}$");
        Pattern cargoCodePattern = Pattern.compile("^[A-Z]{3}-[A-Z]{2}$");

        // Validate inputs
        boolean trainIdValid = trainIdPattern.matcher(trainId).matches();
        boolean cargoCodeValid = cargoCodePattern.matcher(cargoCode).matches();

        // Display results
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + trainIdValid);
        System.out.println("Cargo Code Valid: " + cargoCodeValid);

        System.out.println("\nUC11 validation completed...");
        scanner.close();
    }
}

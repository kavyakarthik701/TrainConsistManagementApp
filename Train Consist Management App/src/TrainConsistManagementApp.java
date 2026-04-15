/**
 * ================================================================
 * MAIN CLASS – UseCase12TrainConsistMgmt
 * ================================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class enforces domain safety rules on goods bogies.
 *
 * At this stage, the application:
 *  - Creates goods bogie list
 *  - Converts list into stream
 *  - Applies safety validation rule
 *  - Checks compliance using allMatch()
 *  - Displays safety status
 *
 * This maps real-world cargo safety rules using Streams.
 *
 * @author Developer
 * @version 12.0
 */

import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmt {

    // ================================================================
    // Goods Bogie Model
    // ================================================================
    static class GoodsBogie {

        String type;   // Type of bogie (e.g., Closed, Open, Tanker)
        String cargo;  // Cargo carried (e.g., Coal, Chemicals)

        // Constructor
        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // ================================================================
    // MAIN METHOD
    // ================================================================
    public static void main(String[] args) {

        // Display heading
        System.out.println("=====================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("=====================================================\n");

        // --------------------------------------------------------------
        // Step 1: Create goods bogie list
        // --------------------------------------------------------------
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Closed", "Electronics"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Tanker", "Chemicals"));
        goodsBogies.add(new GoodsBogie("Closed", "Food"));

        // --------------------------------------------------------------
        // Step 2: Apply safety validation rule using Streams
        // Rule:
        // - Chemicals must be in Tanker
        // - Food must be in Closed
        // --------------------------------------------------------------
        boolean isSafe = goodsBogies.stream().allMatch(bogie -> {

            if (bogie.cargo.equalsIgnoreCase("Chemicals")) {
                return bogie.type.equalsIgnoreCase("Tanker");
            }

            if (bogie.cargo.equalsIgnoreCase("Food")) {
                return bogie.type.equalsIgnoreCase("Closed");
            }

            // Default: safe for other cargo types
            return true;
        });

        // --------------------------------------------------------------
        // Step 3: Display safety status
        // --------------------------------------------------------------
        if (isSafe) {
            System.out.println("All goods bogies are SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Safety violation detected ❌");
        }
    }
}
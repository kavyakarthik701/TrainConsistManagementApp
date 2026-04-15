/**
 * ========================================================
 * MAIN CLASS - UseCase15TrainConsistMgmnt
 * ========================================================
 * * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * * Description:
 * This class safely assigns cargo to goods bogies
 * while handling unsafe combinations using structured
 * exception handling blocks.
 */
public class TrainConsistManagementApp {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    // Extends RuntimeException so it doesn't require mandatory 'throws' declarations
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (this.shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                // Catches and handles the specific custom exception
                System.out.println("Error: " + e.getMessage());

            } finally {
                // Executes regardless of whether an exception occurred
                System.out.println("Cargo validation completed for " + this.shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("==========================================\n");

        // Scenario 1: Valid assignment (Cylindrical bogie with Petroleum)
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");

        System.out.println(); // For spacing

        // Scenario 2: Invalid assignment (Rectangular bogie with Petroleum)
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}
/**
 * =========================================================================
 * MAIN CLASS - UseCase14TrainConsistMgmnt
 * =========================================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Description:
 * This program prevents creation of passenger bogies with
 * invalid seating capacity using a custom exception.
 *
 * Features:
 * - Defines a custom exception
 * - Validates capacity inside constructor
 * - Throws exception if capacity <= 0
 * - Ensures safe execution (no crash)
 *
 * =========================================================================
 */

public class TrainConsistManagementApp {

    // ================================================================
    // CUSTOM EXCEPTION CLASS
    // ================================================================
    // This exception is thrown when invalid capacity is given
    static class InvalidCapacityException extends Exception {

        // Constructor to pass custom error message
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ================================================================
    // PASSENGER BOGIE CLASS
    // ================================================================
    static class PassengerBogie {

        String type;     // Type of bogie (e.g., Sleeper, AC)
        int capacity;    // Seating capacity

        // Constructor with validation
        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

            // Validate capacity
            if (capacity <= 0) {
                // Throw custom exception if invalid
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }

            // Assign values if valid
            this.type = type;
            this.capacity = capacity;
        }

        // Method to display bogie details
        public void display() {
            System.out.println("Created Bogie: " + type + " -> " + capacity);
        }
    }

    // ================================================================
    // MAIN METHOD
    // ================================================================
    public static void main(String[] args) {

        // Try block to handle exceptions safely
        try {
            // Valid bogie creation
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            b1.display();

            // Invalid bogie creation (will throw exception)
            PassengerBogie b2 = new PassengerBogie("AC", 0);
            b2.display(); // This line will not execute

        } catch (InvalidCapacityException e) {

            // Handle exception and print message
            System.out.println("Error: " + e.getMessage());
        }

        // Program continues normally
        System.out.println("UC14 exception handling completed...");
    }
}
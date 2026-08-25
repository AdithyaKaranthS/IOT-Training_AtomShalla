class ExeptionHandeling {
    public static void main(String[] args) {
        System.out.println("=== Runtime Error ===");
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Runtime error: Cannot divide by zero.");
        } finally {
            System.out.println("Runtime example completed.\n");
        }

        System.out.println("=== Logical Error ===");
        try {
            int length = 10;
            int width = 5;
            int expectedArea = length * width;
            int incorrectArea = length + width;

            System.out.println("Expected area: " + expectedArea);
            System.out.println("Incorrect area caused by logic error: " + incorrectArea);
        } catch (Exception e) {
            System.out.println("Logical example error: " + e.getMessage());
        } finally {
            System.out.println("Logical example completed.\n");
        }

        System.out.println("=== Syntax Error ===");
        try {
            System.out.println("The syntax-error line is commented out so this file can compile.");
            // int number = ;
        } catch (Exception e) {
            System.out.println("Syntax example error: " + e.getMessage());
        } finally {
            System.out.println("Syntax example completed.");
        }
    }
}
import java.util.*;
class Calculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            try {
                System.out.println("\n--- Calculator Menu ---");
                System.out.println("1. Add (+)");
                System.out.println("2. Subtract (-)");
                System.out.println("3. Multiply (*)");
                System.out.println("4. Divide (/)");
                System.out.println("5. Exit");
                System.out.println("Enter your choice (1-5):");
                int choice = scanner.nextInt();
                
                if (choice == 5) {
                    System.out.println("Thank you for using Calculator. Goodbye!");
                    running = false;
                    break;
                }
                
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    continue;
                }
                
                System.out.println("Enter first number:");
                double num1 = scanner.nextDouble();
                System.out.println("Enter second number:");
                double num2 = scanner.nextDouble();
                
                double result;
                switch (choice) {
                    case 1:
                        result = num1 + num2;
                        System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                        break;
                    case 2:
                        result = num1 - num2;
                        System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                        break;
                    case 3:
                        result = num1 * num2;
                        System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                        break;
                    case 4:
                        if (num2 != 0) {
                            result = num1 / num2;
                            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                        } else {
                            System.out.println("Error: Division by zero");
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter valid numbers.");
                System.out.println("Details: " + e.getMessage());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: An unexpected error occurred.");
                System.out.println("Details: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
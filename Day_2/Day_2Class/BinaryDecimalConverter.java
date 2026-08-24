import java.util.Scanner;

public class BinaryDecimalConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Binary to Decimal");
            System.out.println("2. Decimal to Binary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter binary number: ");
                    String binary = input.next();
                    try {
                        int decimal = Integer.parseInt(binary, 2);
                        System.out.println("Decimal value: " + decimal);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid binary number. Please enter only 0 and 1.");
                    }
                    break;

                case 2:
                    System.out.print("Enter decimal number: ");
                    int decimal = input.nextInt();
                    String binaryValue = Integer.toBinaryString(decimal);
                    System.out.println("Binary value: " + binaryValue);
                    break;

                case 3:
                    System.out.println("Program ended.");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }
}

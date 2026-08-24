import java.util.Scanner;

class Num_Of_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println("Enter 6 numbers:");
        for (int i = 1; i <= 6; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 6 valid numbers.");
                scanner.close();
                return;
            }

            int num = scanner.nextInt();
            if (num == 1) {
                count++;
            }
        }

        System.out.println("Number of 1s entered: " + count);
        scanner.close();
    }
}

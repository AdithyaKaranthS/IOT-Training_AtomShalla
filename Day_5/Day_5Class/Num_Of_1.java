import java.util.Scanner;

class Num_Of_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.print("Enter a number: ");
        if (!scanner.hasNext()) {
            System.out.println("Please enter a valid number.");
            scanner.close();
            return;
        }

        String number = scanner.next();
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) == '1') {
                count++;
            }
        }

        System.out.println("Number of 1s in the number: " + count);
        scanner.close();
    }
}


import java.util.Scanner;

class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a three-digit number: ");
        int n = sc.nextInt();

        int a = n % 10;
        int b = (n / 10) % 10;
        int c = n / 100;

        int reverse = a * 100 + b * 10 + c;

        System.out.println("Reverse = " + reverse);
    }
}
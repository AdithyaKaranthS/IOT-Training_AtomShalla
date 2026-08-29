
import java.util.Scanner;

class FibonaSum {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci sequence: ");
        int n = scanner.nextInt();

        int sum = 0;
        System.out.println("Fibonacci sequence:");
        for (int i = 0; i < n; i++) {
            int fib = fibonacci(i);
            System.out.print(fib + " ");
            sum += fib;
        }

        System.out.println("\nSum of Fibonacci sequence: " + sum);
    }
}

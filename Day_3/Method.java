import java.util.Scanner;

public class Method {
	static void checkEvenOrOdd(int number) {
		if (number % 2 == 0) {
			System.out.println(number + " is even");
		} else {
			System.out.println(number + " is odd");
		}
	}

	public static void main(String[] args) {
		Scanner Sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = Sc.nextInt();

		checkEvenOrOdd(number);
		Sc.close();
	}
}

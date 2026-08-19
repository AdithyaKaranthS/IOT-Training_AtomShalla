import java.util.Scanner;

public class greaterThan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        
        String result = (num > 1000) ? "greater than 1000" :
		(num > 500) ? "greater than 500" : 
                (num > 100) ? "greater than 100" : 
                (num > 50) ? "greater than 50" : "50 or less";
        System.out.println("The number is " + result + ".");
        
        scanner.close();
    }
}
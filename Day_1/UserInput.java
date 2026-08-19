import java.util.Scanner;
class UserInput{
        public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        System.out.println("First Num");
        int a = Sc.nextInt();
        System.out.println("Second Num");
        int b = Sc.nextInt();
        int sum = a + b;
        System.out.println("Sum is " + sum);
    }  
}
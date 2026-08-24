import java.util.Scanner;
class UserInfo{
        public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Name");
        String Name = Sc.nextLine();
        System.out.println("Age");
        int Age = Sc.nextInt();
	Sc.nextLine(); // Consume the newline character
	System.out.println("GPA");
        float GPA = Sc.nextFloat();
	Sc.nextLine(); // Consume the newline character
	System.out.println("Adhar Num");
        long Adhar_Num = Sc.nextLong();
	Sc.nextLine(); // Consume the newline character
        System.out.println("Enter Date of Birth");
        String DOB = Sc.nextLine();
        System.out.println("My name is " + Name + " and my age is " + Age + " and my GPA is " + GPA + " and my Adhar number is " + Adhar_Num + " and my Date of Birth is " + DOB);
    }  
}
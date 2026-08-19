import java.util.Scanner;
class StdInfo{
        public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Roll Number");
        int Roll_Num = Sc.nextInt();
        Sc.nextLine();
        System.out.println("Name");
        String Name = Sc.nextLine();
        System.out.println("Department");
        String Department = Sc.nextLine();
        System.out.println("My roll number is " + Roll_Num + " and my name is " + Name + " and I am from " + Department + " department.");
    }  
}
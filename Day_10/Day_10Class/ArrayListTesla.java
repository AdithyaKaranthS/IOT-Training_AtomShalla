import java.util.ArrayList;
import java.util.Scanner;

class ArrayListTesla {
    static class Car {
        String brand;
        String model;
        String color;
        int topSpeed;
        double range;
        int battery;

        Car(String brand, String model, String color, int topSpeed, double range, int battery) {
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.topSpeed = topSpeed;
            this.range = range;
            this.battery = battery;
        }

        void displayInfo() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Color: " + color);
            System.out.println("Top Speed: " + topSpeed + " km/h");
            System.out.println("Range: " + range + " km");
            System.out.println("Battery: " + battery + " kWh");
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Car> teslaCars = new ArrayList<>();
        teslaCars.add(new Car("Tesla", "Model S", "Red", 250, 652, 100));
        teslaCars.add(new Car("Tesla", "Model 3", "White", 225, 500, 82));
        teslaCars.add(new Car("Tesla", "Model X", "Black", 250, 580, 100));

        System.out.println("Choose a Tesla model:");
        System.out.println("1. Model S");
        System.out.println("2. Model 3");
        System.out.println("3. Model X");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                teslaCars.get(0).displayInfo();
                break;
            case 2:
                teslaCars.get(1).displayInfo();
                break;
            case 3:
                teslaCars.get(2).displayInfo();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
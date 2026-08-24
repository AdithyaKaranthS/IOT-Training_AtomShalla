import java.util.Scanner;

class Car {
    private String brand;
    private String model;
    private double speed;
    private double maxSpeed;
    private double acceleration;
    private String color;
    private boolean isOn;

    public Car(String brand, String model, double maxSpeed, double acceleration,
            String color) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getSpeed() {
        return speed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public String getColor() {
        return color;
    }

    public void start() {
        isOn = true;
        System.out.println(brand + " " + model + " started.");
    }

    public void stop() {
        speed = 0;
        isOn = false;
        System.out.println(brand + " " + model + " stopped.");
    }

    public void accelerate() {
        if (!isOn) {
            System.out.println("Start the car first.");
            return;
        }
        speed = Math.min(speed + acceleration, maxSpeed);
        System.out.println("Current speed: " + speed + " km/h");
    }

    public void brake() {
        if (!isOn) {
            System.out.println("Start the car first.");
            return;
        }
        speed = Math.max(speed - acceleration, 0);
        System.out.println("Current speed: " + speed + " km/h");
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 200, 10, "blue");
        Scanner Sc = new Scanner(System.in);
        String turnOn;

        System.out.print("Turn on the car? (yes/no): ");
        turnOn = Sc.next();

        if (turnOn.equalsIgnoreCase("y")) {
            car.start();
            int choice;

            do {
                System.out.println("\nChoose an action:");
                System.out.println("1. Accelerate");
                System.out.println("2. Brake");
                System.out.println("3. Stop");
                System.out.print("Enter your choice: ");
                choice = Sc.nextInt();

                switch (choice) {
                    case 1:
                        car.accelerate();
                        break;
                    case 2:
                        car.brake();
                        break;
                    case 3:
                        car.stop();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 3);
        } else {
            System.out.println("Car remains off.");
        }

        Sc.close();
    }
}

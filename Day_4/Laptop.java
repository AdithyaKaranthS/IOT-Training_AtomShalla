import java.util.ArrayList;
import java.util.Scanner;

class Laptop {
    String brand;
    String model;
    int ram;
    int storage;
    ArrayList<String> installedApps = new ArrayList<>();
    ArrayList<Integer> appSizes = new ArrayList<>();

    Laptop(String brand, String model, int ram, int storage) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
    }

    void displaySpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Storage: " + storage + "GB");
    }

    void startLaptop(Scanner scanner) {
        System.out.print("Start the laptop? (yes/no): ");
        String choice = scanner.nextLine();

        if (!choice.equalsIgnoreCase("yes")) {
            System.out.println("The laptop is turned off.");
            return;
        }

        System.out.println("The laptop is starting...");
        displaySpecs();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Install an app");
            System.out.println("2. Delete an app");
            System.out.println("3. Shut down");
            System.out.print("Enter your choice: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 1) {
                System.out.print("Enter the app name to install: ");
                String appName = scanner.nextLine();
                System.out.print("Enter the app size in GB: ");
                int appSize = scanner.nextInt();
                scanner.nextLine();
                installApp(appName, appSize);
            } else if (action == 2) {
                deleteApp(scanner);
            } else if (action == 3) {
                shutdownLaptop();
                isRunning = false;
            } else {
                System.out.println("Invalid action.");
            }
        }
    }

    void shutdownLaptop() {
        System.out.println("The laptop is shutting down...");
        System.out.println("The laptop is now off.");
    }

    void installApp(String appName, int appSize) {
        if (appSize <= 0) {
            System.out.println("App size must be greater than 0 GB.");
        } else if (appSize <= storage) {
            storage -= appSize;
            installedApps.add(appName);
            appSizes.add(appSize);
            System.out.println(appName + " installed successfully.");
            System.out.println("Remaining storage: " + storage + "GB");
        } else {
            System.out.println("Not enough storage to install " + appName + ".");
            System.out.println("Available storage: " + storage + "GB");
        }
    }

    void deleteApp(Scanner scanner) {
        if (installedApps.isEmpty()) {
            System.out.println("No apps are installed.");
            return;
        }

        System.out.println("Installed apps:");
        for (int index = 0; index < installedApps.size(); index++) {
            System.out.println((index + 1) + ". " + installedApps.get(index));
        }
        System.out.print("Enter the number of the app to delete: ");
        int appNumber = scanner.nextInt();
        scanner.nextLine();

        if (appNumber >= 1 && appNumber <= installedApps.size()) {
            int appIndex = appNumber - 1;
            String appName = installedApps.remove(appIndex);
            int appSize = appSizes.remove(appIndex);
            storage += appSize;
            System.out.println(appName + " deleted successfully.");
            System.out.println("Remaining storage: " + storage + "GB");
        } else {
            System.out.println("Invalid app choice.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Laptop l1 = new Laptop("Dell", "XPS 13", 32, 1024);
        Laptop l2 = new Laptop("HP", "Pavilion", 16, 512);

        System.out.println("Choose a laptop:");
        System.out.println("1. l1 - " + l1.brand + " " + l1.model);
        System.out.println("2. l2 - " + l2.brand + " " + l2.model);
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            l1.startLaptop(scanner);
        } else if (choice == 2) {
            l2.startLaptop(scanner);
        } else {
            System.out.println("Invalid laptop choice.");
        }

        scanner.close();
    }
}
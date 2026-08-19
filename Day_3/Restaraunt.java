import java.util.ArrayList;
import java.util.Scanner;

class Restaraunt {
	public static void main(String[] args) {
		Scanner Sc = new Scanner(System.in);
		ArrayList<String> selectedItems = new ArrayList<>();
		int total = 0;
		boolean running = true;

		while (running) {
			System.out.println("\n===== RESTAURANT MENU =====");
			System.out.println("1. Veg");
			System.out.println("2. Non-Veg");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int category = Sc.nextInt();

			switch (category) {
				case 1:
					total += showVegMenu(Sc, selectedItems);
					break;
				case 2:
					total += showNonVegMenu(Sc, selectedItems);
					break;
				case 3:
					running = false;
					System.out.println("\n===== YOUR ORDER =====");
					if (selectedItems.isEmpty()) {
						System.out.println("No items selected.");
					} else {
						for (String selectedItem : selectedItems) {
							System.out.println(selectedItem);
						}
						System.out.println("Total: Rs. " + total);
					}
					System.out.println("Thank you. Visit again!");
					break;
				default:
					System.out.println("Invalid option.");
			}
		}

		Sc.close();
	}

	static int showVegMenu(Scanner Sc, ArrayList<String> selectedItems) {
		System.out.println("\n--- VEG MENU ---");
		System.out.println("1. Starters");
		System.out.println("2. Mains");
		System.out.println("3. Desserts");
		System.out.print("Choose a category: ");
		int category = Sc.nextInt();

		switch (category) {
			case 1:
				return selectItem(Sc, selectedItems, "Veg Spring Rolls", 100, "Paneer Tikka", 150);
			case 2:
				return selectItem(Sc, selectedItems, "Paneer Biryani", 180, "Veg Pizza", 250);
			case 3:
				return selectItem(Sc, selectedItems, "Ice Cream", 80, "Gulab Jamun", 70);
			default:
				System.out.println("Invalid veg category.");
				return 0;
		}
	}

	static int showNonVegMenu(Scanner Sc, ArrayList<String> selectedItems) {
		System.out.println("\n--- NON-VEG MENU ---");
		System.out.println("1. Starters");
		System.out.println("2. Mains");
		System.out.println("3. Desserts");
		System.out.print("Choose a category: ");
		int category = Sc.nextInt();

		switch (category) {
			case 1:
				return selectItem(Sc, selectedItems, "Chicken Wings", 180, "Chicken 65", 160);
			case 2:
				return selectItem(Sc, selectedItems, "Chicken Biryani", 220, "Fish Curry", 280);
			case 3:
				return selectItem(Sc, selectedItems, "Ice Cream", 80, "Chocolate Cake", 140);
			default:
				System.out.println("Invalid non-veg category.");
				return 0;
		}
	}

	static int selectItem(Scanner Sc, ArrayList<String> selectedItems, String firstItem, int firstPrice, String secondItem, int secondPrice) {
		System.out.println("1. " + firstItem + " - Rs. " + firstPrice);
		System.out.println("2. " + secondItem + " - Rs. " + secondPrice);
		System.out.print("Choose an item: ");
		int item = Sc.nextInt();

		switch (item) {
			case 1:
				System.out.println("You selected " + firstItem + " - Rs. " + firstPrice);
				selectedItems.add(firstItem + " - Rs. " + firstPrice);
				return firstPrice;
			case 2:
				System.out.println("You selected " + secondItem + " - Rs. " + secondPrice);
				selectedItems.add(secondItem + " - Rs. " + secondPrice);
				return secondPrice;
			default:
				System.out.println("Invalid item.");
				return 0;
		}
	}
}

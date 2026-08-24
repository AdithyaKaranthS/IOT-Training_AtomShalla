import java.util.ArrayList;
import java.util.Scanner;

public class Food_Ordering {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<FoodItem> selectedItems = new ArrayList<>();
		boolean ordering = true;
		while (ordering) {
			displayMenu();
			int choice = readInt(scanner, "Enter your choice: ");

			if (choice == 3) {
				ordering = false;
				displayOrder(selectedItems);
			} else {
				switch (choice) {
					case 1:
						showCategoryMenu(scanner, selectedItems, true);
						break;
					case 2:
						showCategoryMenu(scanner, selectedItems, false);
						break;
					default:
						System.out.println("Invalid option.");
				}
			}
		}

		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("\n===== RESTAURANT MENU =====");
		System.out.println("1. Veg");
		System.out.println("2. Non-Veg");
		System.out.println("3. Exit");
	}

	private static void showCategoryMenu(Scanner scanner, ArrayList<FoodItem> selectedItems, boolean vegetarian) {
		System.out.println(vegetarian ? "\n--- VEG MENU ---" : "\n--- NON-VEG MENU ---");
		FoodItem[] items = vegetarian
				? new FoodItem[] {
						new CheesePizza("Cheese Pizza", 101, 250, 0),
						new VeggiePizza("Veggie Pizza", 102, 220, 0),
						new VeggieBurger("Veggie Burger", 202, 150, 0),
						new VegetableBiryani("Vegetable Biryani", 302, 240, 0)
				}
				: new FoodItem[] {
						new ChickenBurger("Chicken Burger", 201, 180, 0),
						new ChickenBiryani("Chicken Biryani", 301, 300, 0)
				};
		selectItem(scanner, selectedItems, items);
	}

	private static void selectItem(Scanner scanner, ArrayList<FoodItem> selectedItems, FoodItem... items) {
		for (int index = 0; index < items.length; index++) {
			System.out.println((index + 1) + ". " + items[index].itemName + " - Rs. " + items[index].price);
		}
		int itemChoice = readInt(scanner, "Choose an item: ");
		if (itemChoice < 1 || itemChoice > items.length) {
				System.out.println("Invalid item.");
				return;
		}
		FoodItem selectedItem = items[itemChoice - 1];

		int quantity;
		do {
			quantity = readInt(scanner, "Enter quantity: ");
			if (quantity <= 0) {
				System.out.println("Quantity must be greater than zero.");
			}
		} while (quantity <= 0);
		selectedItem.quantity = quantity;
		selectedItems.add(selectedItem);
		System.out.println("You selected " + selectedItem.itemName + " - Rs. " + String.format("%.2f", selectedItem.price));
	}

	private static void displayOrder(ArrayList<FoodItem> selectedItems) {
		System.out.println("\n===== YOUR ORDER =====");
		if (selectedItems.isEmpty()) {
			System.out.println("No items selected.");
		} else {
			double total = 0;
			double discount = 0;
			for (FoodItem item : selectedItems) {
				item.displayItemDetails();
				total += item.calculateTotalPrice();
				discount += item.calculateDiscount();
			}
			System.out.printf("Total price: Rs. %.2f%n", total);
			System.out.printf("Discount: Rs. %.2f%n", discount);
			System.out.printf("Final bill: Rs. %.2f%n", total - discount);
		}
		System.out.println("Thank you. Visit again!");
	}

	private static int readInt(Scanner scanner, String message) {
		System.out.print(message);
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid number.");
			scanner.next();
			System.out.print(message);
		}
		return scanner.nextInt();
	}
}

class FoodItem {
	protected String itemName;
	protected int itemId;
	protected double price;
	protected int quantity;

	FoodItem(String itemName, int itemId, double price, int quantity) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
	}

	void displayItemDetails() {
		System.out.println("Item: " + itemName);
		System.out.println("ID: " + itemId);
		System.out.println("Price: Rs. " + String.format("%.2f", price));
		System.out.println("Quantity: " + quantity);
	}

	double calculateTotalPrice() {
		return price * quantity;
	}

	double calculateDiscount() {
		return calculateTotalPrice() * 0.05;
	}

	void displayFinalBill() {
		displayItemDetails();
		double totalPrice = calculateTotalPrice();
		double discount = calculateDiscount();
		System.out.printf("Total price: Rs. %.2f%n", totalPrice);
		System.out.printf("Discount: Rs. %.2f%n", discount);
		System.out.printf("Final bill: Rs. %.2f%n%n", totalPrice - discount);
	}
}

class Pizza extends FoodItem {
	Pizza(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}

	@Override
	double calculateDiscount() {
		return calculateTotalPrice() * 0.10;
	}
}

class CheesePizza extends Pizza {
	CheesePizza(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class VeggiePizza extends Pizza {
	VeggiePizza(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class Burger extends FoodItem {
	Burger(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}

	@Override
	double calculateDiscount() {
		return calculateTotalPrice() * 0.05;
	}
}

class ChickenBurger extends Burger {
	ChickenBurger(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class VeggieBurger extends Burger {
	VeggieBurger(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class Biryani extends FoodItem {
	Biryani(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}

	@Override
	double calculateDiscount() {
		return calculateTotalPrice() * 0.08;
	}
}

class ChickenBiryani extends Biryani {
	ChickenBiryani(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class VegetableBiryani extends Biryani {
	VegetableBiryani(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

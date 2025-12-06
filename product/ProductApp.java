import java.util.Scanner;

public class ProductApp {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== PRODUCT MANAGER ===");
            System.out.println("1. Add product");
            System.out.println("2. Update product by id");
            System.out.println("3. Remove product by id");
            System.out.println("4. Display all products");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort by price ASC");
            System.out.println("7. Sort by price DESC");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    manager.addProduct(new Product(id, name, price));
                    System.out.println("Added.");
                    break;

                case 2:
                    System.out.print("Enter id to update: ");
                    int upId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new price: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());

                    if (manager.updateProductById(upId, newName, newPrice)) {
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter id to remove: ");
                    int rmId = Integer.parseInt(scanner.nextLine());
                    if (manager.removeProductById(rmId)) {
                        System.out.println("Removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    manager.displayProducts();
                    break;

                case 5:
                    System.out.print("Enter name keyword: ");
                    String keyword = scanner.nextLine();
                    manager.searchByName(keyword);
                    break;

                case 6:
                    manager.sortByPriceAscending();
                    System.out.println("Sorted by price ASC.");
                    manager.displayProducts();
                    break;

                case 7:
                    manager.sortByPriceDescending();
                    System.out.println("Sorted by price DESC.");
                    manager.displayProducts();
                    break;

                case 0:
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

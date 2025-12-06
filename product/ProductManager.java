import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductManager {

    // Change to: new LinkedList<>() if you want LinkedList
    private List<Product> products = new LinkedList<>();

    // Add new product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Update product info by id
    public boolean updateProductById(int id, String newName, double newPrice) {
        Product p = findById(id);
        if (p == null) {
            return false;
        }
        p.setName(newName);
        p.setPrice(newPrice);
        return true;
    }

    // Remove product by id
    public boolean removeProductById(int id) {
        Product p = findById(id);
        if (p == null) {
            return false;
        }
        return products.remove(p);
    }

    // Display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products.");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Search products by name (contains, ignore case)
    public void searchByName(String keyword) {
        String kw = keyword.toLowerCase();
        boolean found = false;
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(kw)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with name contains: " + keyword);
        }
    }

    // Sort products by price ascending
    public void sortByPriceAscending() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    // Sort products by price descending
    public void sortByPriceDescending() {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }

    // ===== helper method =====
    private Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}


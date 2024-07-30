import java.util.*;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    
    public Product() {
        this.productId = "";
        this.productName = "";
        this.quantity = 0;
        this.price = 0.0;
    }

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to retrieve a product
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    // Main method for testing
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        String productId;
        String productName;
        int quantity;
        double price;
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        while (choice != 5) {
            System.out.println("Enter 1 to enter product details");
            System.out.println("Enter 2 to update product details");
            System.out.println("Enter 3 to delete product details");
            System.out.println("Enter 4 to retrieve product details");
            System.out.println("Enter 5 to exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Product Id:");
                    productId = sc.next();
                    System.out.println("Enter the Product Name:");
                    productName = sc.next();
                    System.out.println("Enter the Quantity of Product:");
                    quantity = sc.nextInt();
                    System.out.println("Enter the Product Price:");
                    price = sc.nextDouble();
                    Product p1 = new Product(productId, productName, quantity, price);
                    ims.addProduct(p1);
                    System.out.println("Added Product Details");
                    break;

                case 2:
                    System.out.println("Enter the Product Id to be updated:");
                    productId = sc.next();
                    Product existingProduct = ims.getProduct(productId);
                    if (existingProduct != null) {
                        System.out.println("Enter the new Product Name:");
                        productName = sc.next();
                        System.out.println("Enter the new Quantity of Product:");
                        quantity = sc.nextInt();
                        System.out.println("Enter the new Product Price:");
                        price = sc.nextDouble();
                        existingProduct.setProductName(productName);
                        existingProduct.setQuantity(quantity);
                        existingProduct.setPrice(price);
                        ims.updateProduct(existingProduct);
                        System.out.println("Updated Product Details");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the Product Id to be deleted:");
                    productId = sc.next();
                    ims.deleteProduct(productId);
                    System.out.println("Deleted Product with Id: " + productId);
                    break;

                case 4:
                    System.out.println("Enter the Product Id to retrieve:");
                    productId = sc.next();
                    Product retrievedProduct = ims.getProduct(productId);
                    if (retrievedProduct != null) {
                        System.out.println("Product Details: ");
                        System.out.println("Product Id: " + retrievedProduct.getProductId());
                        System.out.println("Product Name: " + retrievedProduct.getProductName());
                        System.out.println("Quantity: " + retrievedProduct.getQuantity());
                        System.out.println("Price: " + retrievedProduct.getPrice());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        sc.close();
    }
}

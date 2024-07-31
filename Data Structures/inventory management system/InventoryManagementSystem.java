import java.util.HashMap;

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

HashMap<String, Product> products = new HashMap<>();
products.put("SKU12345", new Product("Product A", 10.99, 100));
products.put("SKU67890", new Product("Product B", 15.99, 50));

import java.util.TreeMap;

TreeMap<String, Integer> inventoryLevels = new TreeMap<>();
inventoryLevels.put("SKU12345", 100);
inventoryLevels.put("SKU67890", 50);
import java.util.LinkedList;
import java.util.Queue;

class Order {
    String orderId;
    String productId;
    int quantity;

    public Order(String orderId, String productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
}

Queue<Order> ordersQueue = new LinkedList<>();
ordersQueue.add(new Order("ORD001", "SKU12345", 10));
ordersQueue.add(new Order("ORD002", "SKU67890", 5));
import java.util.HashMap;
import java.util.LinkedList;

class WarehouseLocation {
    String locationId;
    LinkedList<String> adjacentLocations;

    public WarehouseLocation(String locationId) {
        this.locationId = locationId;
        this.adjacentLocations = new LinkedList<>();
    }

    public void addAdjacentLocation(String locationId) {
        adjacentLocations.add(locationId);
    }
}

HashMap<String, WarehouseLocation> warehouseGraph = new HashMap<>();
WarehouseLocation locA = new WarehouseLocation("A");
WarehouseLocation locB = new WarehouseLocation("B");
WarehouseLocation locC = new WarehouseLocation("C");

locA.addAdjacentLocation("B");
locB.addAdjacentLocation("A");
locB.addAdjacentLocation("C");
locC.addAdjacentLocation("B");

warehouseGraph.put("A", locA);
warehouseGraph.put("B", locB);
warehouseGraph.put("C", locC);
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Order {
    String orderId;
    String productId;
    int quantity;

    public Order(String orderId, String productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem {
    HashMap<String, Product> products = new HashMap<>();
    TreeMap<String, Integer> inventoryLevels = new TreeMap<>();
    Queue<Order> ordersQueue = new LinkedList<>();

    public void addProduct(String sku, String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        products.put(sku, product);
        inventoryLevels.put(sku, quantity);
    }

    public void placeOrder(String orderId, String sku, int quantity) {
        if (products.containsKey(sku) && inventoryLevels.get(sku) >= quantity) {
            Order order = new Order(orderId, sku, quantity);
            ordersQueue.add(order);
            inventoryLevels.put(sku, inventoryLevels.get(sku) - quantity);
        } else {
            System.out.println("Insufficient stock for SKU: " + sku);
        }
    }

    public void processOrder() {
        Order order = ordersQueue.poll();
        if (order != null) {
            System.out.println("Processing order: " + order.orderId);
            // further order processing logic
        } else {
            System.out.println("No orders to process.");
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.addProduct("SKU12345", "Product A", 10.99, 100);
        ims.addProduct("SKU67890", "Product B", 15.99, 50);

        ims.placeOrder("ORD001", "SKU12345", 10);
        ims.placeOrder("ORD002", "SKU67890", 5);

        ims.processOrder();
        ims.processOrder();
        ims.processOrder();
    }
}



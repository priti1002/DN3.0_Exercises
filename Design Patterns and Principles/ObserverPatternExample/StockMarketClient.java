public class StockMarketClient {
    public static void main(String[] args) {
        // Create a stock
        Stock appleStock = new Stock("AAPL", 150.00);

        // Create clients (observers)
        StockClient client1 = new StockClient("Client1");
        StockClient client2 = new StockClient("Client2");

        // Register clients as observers
        appleStock.registerObserver(client1);
        appleStock.registerObserver(client2);

        // Update stock price and notify observers
        appleStock.setPrice(155.00); // Both clients will be notified

        // Unregister a client
        appleStock.unregisterObserver(client2);

        // Update stock price and notify remaining observers
        appleStock.setPrice(160.00); // Only client1 will be notified
    }
}
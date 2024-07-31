public class StockClient implements Observer {
    private String name;

    public StockClient(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(name + " received update: " + stockSymbol + " new price: $" + price);
    }
}
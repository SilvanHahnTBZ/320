public class NewYorkStockExchange implements StockExchange {
    @Override
    public double getPrice(String stock) {
        switch (stock) {
            case "Microsoft":
                return 100.0;
            case "Apple":
                return 150.0;
            default:
                return 0.0;
        }
    }
}

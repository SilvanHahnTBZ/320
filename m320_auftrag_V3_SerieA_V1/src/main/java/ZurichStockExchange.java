public class ZurichStockExchange implements StockExchange {
    @Override
    public double getPrice(String stock) {
        switch (stock) {
            case "Microsoft":
                return 120.0;
            case "Apple":
                return 160.0;
            default:
                return 0.0;
        }
    }
}

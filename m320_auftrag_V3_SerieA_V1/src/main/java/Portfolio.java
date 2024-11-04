public class Portfolio {
    private final StockExchange stockExchange;

    public Portfolio(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public void showPortfolioPrices(Stock[] stocks) {
        for (Stock stock : stocks) {
            String stockName = stock.getName();
            double price = stockExchange.getPrice(stockName);
            System.out.println(stockName + " hat einen Preis von " + price + " in der Börse.");
        }
    }
}

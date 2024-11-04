public class Main {
    public static void main(String[] args) {
        // Erstelle Aktien
        Stock[] stocks = {
                new Stock("Microsoft"),
                new Stock("Apple")
        };

        // Portfolio mit der New Yorker Börse
        StockExchange nyse = new NewYorkStockExchange();
        Portfolio portfolioNY = new Portfolio(nyse);
        System.out.println("Preise in der New York Stock Exchange:");
        portfolioNY.showPortfolioPrices(stocks);

        // Portfolio mit der Züricher Börse
        StockExchange zse = new ZurichStockExchange();
        Portfolio portfolioZurich = new Portfolio(zse);
        System.out.println("\nPreise in der Zürich Stock Exchange:");
        portfolioZurich.showPortfolioPrices(stocks);
    }
}

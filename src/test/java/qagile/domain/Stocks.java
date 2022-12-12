package qagile.domain;

public enum Stocks {

    APPLE("APPL", "APPLE INC", 150.00);

    private final String stockCode;
    private final String stockName;
    private final double basePrice;

    Stocks(String stockCode, String stockName, double basePrice) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.basePrice = basePrice;
    }

    public String getStockCode() {
        return stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

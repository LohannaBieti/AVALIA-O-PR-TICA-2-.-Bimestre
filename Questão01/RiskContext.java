package Questão01;

public class RiskContext {
    private double portfolioValue;
    private double marketVolatility;
    private double interestRates;

    // Construtor, getters e setters
    public RiskContext(double portfolioValue, double marketVolatility, double interestRates) {
        this.portfolioValue = portfolioValue;
        this.marketVolatility = marketVolatility;
        this.interestRates = interestRates;
    }

    public double getPortfolioValue() {
        return portfolioValue;
    }

    public double getMarketVolatility() {
        return marketVolatility;
    }

    public double getInterestRates() {
        return interestRates;
    }
}

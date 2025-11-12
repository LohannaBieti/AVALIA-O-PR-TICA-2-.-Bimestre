package Questão01;

public class ValueAtRisk implements RiskAlgorithm {
    @Override
    public String calculateRisk(RiskContext context) {
        // Cálculo fictício de Value at Risk
        return "Value at Risk calculado: " + (context.getPortfolioValue() * 0.05);
    }
}

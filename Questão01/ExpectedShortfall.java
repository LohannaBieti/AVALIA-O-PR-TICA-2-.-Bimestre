package Questão01;

public class ExpectedShortfall implements RiskAlgorithm {
    @Override
    public String calculateRisk(RiskContext context) {
        // Cálculo fictício de Expected Shortfall
        return "Expected Shortfall calculado: " + (context.getPortfolioValue() * 0.10);
    }
}

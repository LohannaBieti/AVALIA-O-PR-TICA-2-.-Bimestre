package Questão01;

public class StressTesting implements RiskAlgorithm {
    @Override
    public String calculateRisk(RiskContext context) {
        // Cálculo fictício de Stress Testing
        return "Stress Testing calculado: " + (context.getPortfolioValue() * 0.15);
    }
}

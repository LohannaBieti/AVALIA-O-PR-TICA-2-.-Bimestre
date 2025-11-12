package Questão01;

public class RiskCalculatorContext {
     private RiskAlgorithm riskAlgorithm;

    public RiskCalculatorContext(RiskAlgorithm riskAlgorithm) {
        this.riskAlgorithm = riskAlgorithm;
    }

    public void setRiskAlgorithm(RiskAlgorithm riskAlgorithm) {
        this.riskAlgorithm = riskAlgorithm;
    }

    public String calculateRisk(RiskContext context) {
        return riskAlgorithm.calculateRisk(context);
    }
}

package Questão01;

public class Client {
    public static void main(String[] args) {
        RiskContext context = new RiskContext(1000000, 0.02, 0.03);

        // Inicializa com o algoritmo Value at Risk
        RiskCalculatorContext calculatorContext = new RiskCalculatorContext(RiskCalculatorFactory.getAlgorithm("VaR"));
        System.out.println(calculatorContext.calculateRisk(context));

        // Troca para Expected Shortfall
        calculatorContext.setRiskAlgorithm(RiskCalculatorFactory.getAlgorithm("ES"));
        System.out.println(calculatorContext.calculateRisk(context));

        // Troca para Stress Testing
        calculatorContext.setRiskAlgorithm(RiskCalculatorFactory.getAlgorithm("Stress"));
        System.out.println(calculatorContext.calculateRisk(context));
    }
}

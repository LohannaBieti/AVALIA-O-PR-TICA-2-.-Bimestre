package Questão01;

public class RiskCalculatorFactory {
    public static RiskAlgorithm getAlgorithm(String algorithmType) {
        switch (algorithmType) {
            case "VaR":
                return new ValueAtRisk();
            case "ES":
                return new ExpectedShortfall();
            case "Stress":
                return new StressTesting();
            default:
                throw new IllegalArgumentException("Algoritmo desconhecido");
        }
    }
}

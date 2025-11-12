package Questão03;

public class AlertaVermelho implements EstadoUsina {
    @Override
    public void transitarParaProximoEstado(Usina usina) {
        System.out.println("A transição de ALERTA_VERMELHO para outro estado não é permitida. A usina deve entrar em EMERGENCIA.");
    }

    @Override
    public void acionarEmergencia(Usina usina) {
        if (usina.getNivelRadiacao() > 1000) {
            System.out.println("Nível de radiação elevado. Emergência acionada.");
            usina.setEstadoAtual(new Emergencia());
        } else {
            System.out.println("Sistema de resfriamento falhou. Transição para EMERGENCIA.");
            usina.setEstadoAtual(new Emergencia());
        }
    }
}

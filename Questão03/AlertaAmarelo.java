package Questão03;

public class AlertaAmarelo implements EstadoUsina {
    @Override
    public void transitarParaProximoEstado(Usina usina) {
        if (usina.getTemperatura() > 400) {
            // Espera 30 segundos para transição
            // (Simulação simples aqui)
            System.out.println("Temperatura elevada por 30 segundos. Transição para ALERTA_VERMELHO.");
            usina.setEstadoAtual(new AlertaVermelho());
        } else {
            System.out.println("Temperatura dentro dos limites de ALERTA_AMARELO.");
        }
    }

    @Override
    public void acionarEmergencia(Usina usina) {
        System.out.println("A usina está em ALERTA_AMARELO. Emergência não pode ser acionada.");
    }
}

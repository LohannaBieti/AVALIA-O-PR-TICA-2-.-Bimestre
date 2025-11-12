package Questão03;

public class OperacaoNormal implements EstadoUsina {
    @Override
    public void transitarParaProximoEstado(Usina usina) {
        if (usina.getTemperatura() > 300) {
            usina.setEstadoAtual(new AlertaAmarelo());
            System.out.println("Transição para ALERTA_AMARELO.");
        } else {
            System.out.println("Temperatura dentro dos limites normais. Mantendo estado OPERACAO_NORMAL.");
        }
    }

    @Override
    public void acionarEmergencia(Usina usina) {
        System.out.println("A usina está em operação normal. Emergência não pode ser acionada.");
    }
}

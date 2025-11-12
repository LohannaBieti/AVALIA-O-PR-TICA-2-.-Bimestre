package Questão03;

public class Emergencia implements EstadoUsina {
    @Override
    public void transitarParaProximoEstado(Usina usina) {
        System.out.println("A usina está em estado de emergência. Não há transição possível.");
    }

    @Override
    public void acionarEmergencia(Usina usina) {
        System.out.println("A usina já está em emergência. Não pode ser acionada novamente.");
    }
}

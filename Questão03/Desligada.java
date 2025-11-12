package Questão03;

public class Desligada implements EstadoUsina {
    @Override
    public void transitarParaProximoEstado(Usina usina) {
        // Não há transição direta a partir do estado desligado
        System.out.println("A usina está desligada e não pode transitar para outros estados.");
    }

    @Override
    public void acionarEmergencia(Usina usina) {
        System.out.println("A usina está desligada. Emergência não pode ser acionada.");
    }
}

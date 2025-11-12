package Questão03;

public interface EstadoUsina {
    void transitarParaProximoEstado(Usina usina);
    void acionarEmergencia(Usina usina);
}

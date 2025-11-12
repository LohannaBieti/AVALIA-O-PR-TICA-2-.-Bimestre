package Questão03;

public class Main {
    public static void main(String[] args) {
        Usina usina = new Usina();
        
        usina.setTemperatura(320);  // Temperatura alta para transição
        usina.transitarParaProximoEstado();  // Deve transitar para ALERTA_AMARELO
        
        usina.setTemperatura(410);  // Temperatura ainda mais alta para transição
        usina.transitarParaProximoEstado();  // Deve transitar para ALERTA_VERMELHO
        
        usina.acionarEmergencia();  // Deve acionar emergência, já que a temperatura e radiação são altas
    }
}


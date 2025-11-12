package Questão02;

public class Client {
    public static void main(String[] args) {
        // Sistema legado
        SistemaBancarioLegado sistemaBancarioLegado = new SistemaBancarioLegadoImpl();
        
        // Adapter que adapta a interface moderna para a interface legada
        ProcessadorTransacoes processador = new ProcessadorTransacoesAdapter(sistemaBancarioLegado);
        
        // Chamar o método moderno, que internamente chama o legado
        processador.autorizar("1234-5678-9876-5432", 1000.50, "BRL");
    }
}

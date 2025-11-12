package Questão02;

import java.util.HashMap;

public class ProcessadorTransacoesAdapter implements ProcessadorTransacoes {
    private SistemaBancarioLegado sistemaBancarioLegado;

    public ProcessadorTransacoesAdapter(SistemaBancarioLegado sistemaBancarioLegado) {
        this.sistemaBancarioLegado = sistemaBancarioLegado;
    }

    @Override
    public void autorizar(String cartao, double valor, String moeda) {
        // Converter moeda para código compatível com o legado
        int codigoMoeda = codificarMoeda(moeda);
        
        // Criar um HashMap para representar os parâmetros no formato esperado pelo sistema legado
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("cartao", cartao);
        parametros.put("valor", valor);
        parametros.put("moeda", codigoMoeda);
        
        // Adicionar um campo obrigatório para o sistema legado, por exemplo, "dataTransacao"
        parametros.put("dataTransacao", System.currentTimeMillis());  // Exemplo de campo adicional
        
        // Processar transação no sistema legado
        sistemaBancarioLegado.processarTransacao(parametros);
    }
    
    // Método para codificar a moeda
    private int codificarMoeda(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD":
                return 1;
            case "EUR":
                return 2;
            case "BRL":
                return 3;
            default:
                throw new IllegalArgumentException("Moeda desconhecida: " + moeda);
        }
    }
}

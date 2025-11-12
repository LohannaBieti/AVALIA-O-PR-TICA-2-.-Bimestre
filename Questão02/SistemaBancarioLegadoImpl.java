package Questão02;

import java.util.HashMap;

public class SistemaBancarioLegadoImpl implements SistemaBancarioLegado {
    @Override
    public void processarTransacao(HashMap<String, Object> parametros) {
        // Exemplo de processamento no sistema legado
        String cartao = (String) parametros.get("cartao");
        Double valor = (Double) parametros.get("valor");
        Integer moeda = (Integer) parametros.get("moeda");
        Long dataTransacao = (Long) parametros.get("dataTransacao");

        System.out.println("Processando transação...");
        System.out.println("Cartão: " + cartao);
        System.out.println("Valor: " + valor);
        System.out.println("Moeda (Código): " + moeda);
        System.out.println("Data da transação: " + dataTransacao);
    }
}

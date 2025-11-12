package Questão02;

public interface ProcessadorTransacoes {
    void autorizar(String cartao, double valor, String moeda);
}

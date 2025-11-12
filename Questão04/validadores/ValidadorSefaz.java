package Questão04.validadores;

import java.util.List;

import Questão04.interfaces.IValidador;
import Questão04.modelos.DocumentoFiscal;

public class ValidadorSefaz extends ValidadorBase {
    @Override
    public boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        System.out.println("Consultando SEFAZ...");
        if (!doc.sefazOk || falhas > 0) {
            falhas++;
            System.out.println(falhas > 0 ? "Falhas anteriores impedem que o Validador Sefaz prossiga. Dando rollback..." : "SEFAZ rejeitou o documento.");
            rollbackTudo(historico, doc);
            return false;
        }
        System.out.println("SEFAZ aprovou.");
        historico.add(this);
        return continuar(doc, historico, falhas);
    }
}
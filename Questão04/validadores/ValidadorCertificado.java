package Questão04.validadores;

import java.util.List;

import Questão04.interfaces.IValidador;
import Questão04.modelos.DocumentoFiscal;

public class ValidadorCertificado extends ValidadorBase {

    public ValidadorCertificado() {
        this.setProximo(new ValidadorRegrasFiscais());
    }

    @Override
    public boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        System.out.println("Verificando certificado digital...");

        if (!doc.certificadoValido) {
            falhas++;
            // System.out.println("Certificado inválido.");
            // return false;
        }

        System.out.println(doc.certificadoValido ? "Certificado válido." : "Certificado inválido.");
        historico.add(this);
        return continuar(doc, historico, falhas);
    }
}
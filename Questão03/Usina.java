package Questão03;

public class Usina {
    private EstadoUsina estadoAtual;
    private boolean emModoManutencao;
    
    private double temperatura;
    private double pressao;
    private double nivelRadiacao;
    
    // Construtor
    public Usina() {
        this.estadoAtual = new Desligada();  // Estado inicial
        this.emModoManutencao = false;
    }

    // Métodos de acesso
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public void setNivelRadiacao(double nivelRadiacao) {
        this.nivelRadiacao = nivelRadiacao;
    }

    // Método para alternar o modo de manutenção
    public void ativarModoManutencao(boolean ativar) {
        this.emModoManutencao = ativar;
    }

    // Transição de estado
    public void transitarParaProximoEstado() {
        if (emModoManutencao) {
            System.out.println("Modo manutenção ativo. Transições desabilitadas.");
            return;
        }
        estadoAtual.transitarParaProximoEstado(this);
    }

    // Método de emergência
    public void acionarEmergencia() {
        if (emModoManutencao) {
            System.out.println("Modo manutenção ativo. Emergência desabilitada.");
            return;
        }
        estadoAtual.acionarEmergencia(this);
    }

    // Métodos para alterar o estado
    public void setEstadoAtual(EstadoUsina novoEstado) {
        this.estadoAtual = novoEstado;
    }

    // Métodos para obter condições
    public double getTemperatura() {
        return temperatura;
    }

    public double getPressao() {
        return pressao;
    }

    public double getNivelRadiacao() {
        return nivelRadiacao;
    }
}

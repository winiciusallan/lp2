package mr.bet;

/**
 * Representação de uma aposta.
 * @author Winicius Allan
 */
public class Aposta {

    private Time time;
    private Campeonato campeonato;
    private int colocacao;
    private double valorDaAposta;

    public Time getTime() {
        return time;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public int getColocacao() {
        return colocacao;
    }

    public double getValorDaAposta() {
        return valorDaAposta;
    }

    public Aposta(Time codigo, Campeonato campeonato, int colocacao, double valorDaAposta) {
        this.time = codigo;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valorDaAposta = valorDaAposta;
    }

    @Override
    public String toString() {
        return "[" + getTime().getCodigo() + "]"+ " "
                + getTime().getNome() + " / " + getTime().getMascote() + "\n"
                + getCampeonato().getNome() + "\n"
                + getColocacao() + "/" + getCampeonato().getTimes().length + "\n"
                + "R$ " + getValorDaAposta();
    }
}

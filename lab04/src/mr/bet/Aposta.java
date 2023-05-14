package mr.bet;

/**
 * Representação de uma aposta. A aposta contém o nome do time, o campeonato, a colocação que o time ficará e o valor
 * apostado. A aposta é armazenada no repositório do sistema.
 * @author Winicius Allan
 */
public class Aposta {

    /**
     * O time da aposta.
     */
    private Time time;

    /**
     * O campeonato da aposta.
     */
    private Campeonato campeonato;

    /**
     * A colocação que o time ficará no campeonato.
     */
    private int colocacao;

    /**
     * O valor apostado.
     */
    private double valorDaAposta;

    /**
     * Faz a criação de uma aposta.
     * @param time O time que será cadastrado na aposta.
     * @param campeonato O campeonato da aposta.
     * @param colocacao A colocação em que o dia ficará.
     * @param valorDaAposta O valor colocado na aposta.
     */
    public Aposta(Time time, Campeonato campeonato, int colocacao, double valorDaAposta) {
        this.time = time;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valorDaAposta = valorDaAposta;
    }

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

    @Override
    public String toString() {
        return "[" + getTime().getCodigo() + "]"+ " "
                + getTime().getNome() + " / " + getTime().getMascote() + "\n"
                + getCampeonato().getNome() + "\n"
                + getColocacao() + "/" + getCampeonato().getTimes().length + "\n"
                + "R$ " + getValorDaAposta();
    }
}

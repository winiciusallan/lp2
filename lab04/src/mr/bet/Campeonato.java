package mr.bet;

/**
 * Representação de um campeonato de esportivo.
 * @author Winicius Allan
 */
public class Campeonato {

    private String nome;
    private Time[] participantes;

    public Campeonato(String nome, int qntd) {
        this.nome = nome;
        participantes = new Time[qntd];
    }
}

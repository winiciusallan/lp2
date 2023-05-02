package mr.bet;

import java.util.Locale;
import java.util.Objects;

/**
 * Representação de um campeonato de esportivo.
 * @author Winicius Allan
 */
public class Campeonato {

    private String nome;
    private Time[] participantes;

    private int indexParticipantes;

    public Campeonato(String nome, int qntd) {
        this.nome = nome;
        participantes = new Time[qntd];
        indexParticipantes = qntd;
    }

    public String getNome() { return nome; }

    public Time[] getTimes() { return participantes; }

    public Time getTime(int pos) { return participantes[pos - 1]; }

    public void adicionaTime(Time time) {
        if (participantes.length == indexParticipantes) { throw new IndexOutOfBoundsException(); }
        for (int i = 0; i < participantes.length; i++) {
            if (participantes[i] == null) {
                participantes[i] = time;
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campeonato that = (Campeonato) o;
        return Objects.equals(nome.toLowerCase(), that.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

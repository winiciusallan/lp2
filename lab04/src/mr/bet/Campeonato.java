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

    public Campeonato(String nome, int qntd) {
        this.nome = nome;
        participantes = new Time[qntd];
    }

    public String getNome() { return nome; }

    public Time[] getTimes() { return participantes; }

    public Time getTime(int pos) { return participantes[pos - 1]; }

    public boolean containsTime(Time time) {
        for (Time iTime : getTimes()) {
            if (iTime == null) { return false; }
            if (iTime.equals(time)) { return true; }
        }
        return false;
    }

    public int contaTime() {
        int count = 0;
        for (int i = 0; i < participantes.length; i++) {
            if (participantes[i] != null) { count++; }
            else { return count; }
        }
        return count;
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

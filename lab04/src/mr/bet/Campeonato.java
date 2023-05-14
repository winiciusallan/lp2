package mr.bet;

import java.util.Locale;
import java.util.Objects;

/**
 * Representação de um campeonato esportivo.
 * @author Winicius Allan
 */
public class Campeonato {

    /**
     * Nome do campeonato.
     */
    private String nome;

    /**
     * Um vetor com todos os times que participam desse campeonato.
     */
    private Time[] participantes;

    /**
     * Cria um campeonato. A quantidade de participantes é iniciada de acordo com o passado como parâmetro.
     * @param nome Nome do campeonato.
     * @param qntd Número total de times do campeonato.
     */
    public Campeonato(String nome, int qntd) {
        this.nome = nome;
        participantes = new Time[qntd];
    }

    public String getNome() { return nome; }

    public Time[] getTimes() { return participantes; }

    /**
     * Verifica se um contém um time.
     * @param time O time que vai ser analizado.
     * @return Será retornado um valor indicando se o time está contido ou não.
     */
    public boolean containsTime(Time time) {
        for (Time iTime : getTimes()) {
            if (iTime == null) { return false; }
            if (iTime.equals(time)) { return true; }
        }
        return false;
    }

    /**
     * Faz a contagem de times que o vetor tem.
     * @return A quantidade de times do campeonato.
     */
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

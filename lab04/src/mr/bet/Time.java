package mr.bet;

import java.util.Objects;

/**
 * Representação de um time. Ele possui um código identificar, um nome e o seu mascote.
 * @author Winicius Allan - 122110397
 */
public class Time {

    /**
     * Nome do time.
     */
    private String nome;

    /**
     * Código identificador do time.
     */
    private String codigo;

    /**
     * Nome do mascote do time.
     */
    private String mascote;

    /**
     * Faz a criação de um time.
     * @param nome O nome do time.
     * @param codigo O código do time.
     * @param mascote O nome do mascote do time.
     */
    public Time(String nome, String codigo, String mascote) {
        this.nome = nome;
        this.codigo = codigo;
        this.mascote = mascote;
    }

    public String getNome() { return nome; }

    public String getCodigo() { return codigo; }

    public String getMascote() { return mascote; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(codigo, time.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "["
                + getCodigo()
                + "] "
                + getNome()
                + " / "
                + getMascote();
    }
}


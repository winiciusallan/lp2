package hughs.and.smiles;

import java.util.Objects;

public class Dog {

    private String nome;
    private String nomeDono;
    private final int racaoDiaria;
    private String restricao;

    public Dog(String nome, String nomeDono, int racaoDiaria) {
        this.nome = nome;
        this.nomeDono = nomeDono;
        this.racaoDiaria = racaoDiaria;
    }

    public Dog(String nome, String nomeDono, int racaoDiaria, String restricao) {
        this.nome = nome;
        this.nomeDono = nomeDono;
        this.racaoDiaria = racaoDiaria;
        this.restricao = restricao;
    }

    public String getNome() { return nome; }

    public String getNomeDono() { return nomeDono; }

    public double getRacaoDiaria() { return racaoDiaria; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(nome, dog.getNome()) && Objects.equals(nomeDono, dog.getNomeDono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nomeDono);
    }

    @Override
    public String toString() {
        return "hughs.and.smiles.Dog [nome="
                + getNome()
                + ", tutor="
                + getNomeDono()
                + "]";
    }
}

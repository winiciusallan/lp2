package agenda;

import java.util.Objects;

/**
 * Representação de um contato, sendo representado pelo seu nome, sobrenome e o seu número de telefone. Também,
 * há um status pra indicar se o contato é favorito ou não.
 */
public class Contato {

    /**
     * Nome do contato.
     */
    private String nome;

    /**
     * Sobrenome do contato.
     */
    private String sobrenome;

    /**
     * Número de telefone do contato.
     */
    private String numero;

    /**
     * Valor que indica se o contato é favorito ou não.
     */
    private boolean favorito;

    /**
     * Cria um novo contato.
     *
     * @param nome o nome do contato.
     * @param sobrenome o sobrenome do contato
     * @param numero o número do contato
     */
    public Contato(String nome, String sobrenome, String numero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    public String getNome() { return this.nome; }

    public String getSobrenome() { return this.sobrenome; }

    public String getNumero() { return this.numero; }

    public boolean isFavorito() { return this.favorito; }

    public void setFavorito(boolean favorito) { this.favorito = favorito; }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (!(obj instanceof Contato)) { return false; }

        Contato other = (Contato) obj;
        return this.getNome().trim().equals(other.getNome().trim())
                && this.getSobrenome().trim().equals(other.getSobrenome().trim());
    }

    @Override
    public String toString() {
        String fav = "";
        if (isFavorito()) { fav = "❤️ "; }

        return fav
                + getNome()
                + " " + getSobrenome()
                + "\n" + getNumero();
        }
}

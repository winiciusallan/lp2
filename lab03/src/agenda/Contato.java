package agenda;

public class Contato {

    private String nome;
    private String sobrenome;
    private String numero;
    private boolean favorito;

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

    public boolean equals(Contato contato) {
        return this.getNome().trim().equals(contato.getNome().trim())
                && this.getSobrenome().trim().equals(contato.getSobrenome().trim());
    }

    @Override
    public String toString() {
        return getNome()
                + " " + getSobrenome()
                + "\n" + getNumero();
    }
}

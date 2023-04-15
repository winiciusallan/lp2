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

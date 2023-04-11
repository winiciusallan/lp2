package agenda;

public class Contato {

    private String nome;
    private String sobrenome;
    private String numero;

    public Contato(String nome, String sobrenome, String numero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    public String getNome() { return this.nome; }

    public String getSobrenome() { return this.sobrenome; }

    public String getNumero() { return this.numero; }

    public boolean equals(Contato contato) {
        return this.getNome().equals(contato.getNome())
                && this.getSobrenome().equals(contato.getSobrenome());
    }
}

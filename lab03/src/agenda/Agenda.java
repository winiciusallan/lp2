package agenda;

import java.util.InputMismatchException;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 *
 * @author Winicius Allan
 */
public class Agenda {

    /**
     * Um vetor que armazena os contatos da agenda.
     */
    private Contato[] contatos; // Representação dos contatos.

    /**
     * Um vetor que armazena os contatos da agenda que são favoritos.
     */
    private Contato[] favoritos;

    /**
     * Cria uma agenda. O array de contatos inicia com 100 posições.
     */
    public Agenda() {
        this.contatos = new Contato[100];
        this.favoritos = new Contato[10];
    }

    /**
     * Acessa a lista de contatos mantida.
     * @return O array de contatos.
     */
    public Contato[] getContatos() {
        return this.contatos.clone();
    }

    /**
     * Acessa os dados de um contato específico.
     * @param posicao Posição do contato na agenda.
     * @return Dados do contato. Null se não há contato na posição.
     */
    public Contato getContato(int posicao) {
        return contatos[posicao - 1];
    }

    /**
     * Acessa o vetor que armazena os favoritos.
     * @return Array com contatos favoritados.
     */
    public Contato[] getFavoritos() { return this.favoritos; }

    public Contato getFavorito(int posicao) { return this.favoritos[posicao - 1]; }
    /**
     * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
     * @param posicao Posição do contato.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     */
    public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        // Verifica se algum campo é nulo.
        if (nome == null || sobrenome == null || telefone == null) {
            throw new NullPointerException();
        }
        // Verifica se todos os campos foram preenchidos.
        if (nome.equals("") || telefone.equals("")) {
            throw new IllegalArgumentException();
        }

        Contato contato = new Contato(nome.trim(), sobrenome.trim(), telefone.trim());

        if (!existeContato(contato)) {
            this.contatos[posicao - 1] = contato;
        } else {
            throw new InputMismatchException();
        }
    }

    /**
     * Adiciona o status de favorito em um contato já cadastrado e o coloca na lista.
     * @param posicao Posição em que o contato ficará armazenado no vetor de favoritos.
     * @param contato O contato que irá ser adicionado.
     */
    public void adicionaFavorito(int posicao, Contato contato) {
        if (!contato.isFavorito()) {
            favoritos[posicao - 1] = contato;
            contato.setFavorito(true);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Remove o status de favorito em um contato já cadastrado e o remove da lista.
     * @param posicao Posição do contato que será removido do vetor de favoritos.
     */
    public void removeFavorito(int posicao) {
        Contato contato = getFavorito(posicao);

        if (contato == null) {
            throw new IllegalArgumentException();
        }
        if (contato.isFavorito()) {
            favoritos[posicao - 1] = null;
            contato.setFavorito(false);
        }
    }

    /**
     * Verifica se o contato já existe na agenda.
     * @param contato que será verificado.
     * @return true caso o contato já esteja cadastrado e false caso contrário.
     */
    private boolean existeContato(Contato contato) {
        for (Contato pessoa : contatos) {
            if (pessoa == null) { continue; }
            if (contato.equals(pessoa)) { return true; }
        }
        return false;
    }
}
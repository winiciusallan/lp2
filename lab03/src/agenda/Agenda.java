package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 *
 * @author Winicius Allan
 */
public class Agenda {

    private static final int TAMANHO_AGENDA = 100;

    private Contato[] contatos; // Representação dos contatos.

    private Contato[] favoritos;

    /**
     * Cria uma agenda.
     */
    public Agenda() {
        this.contatos = new Contato[TAMANHO_AGENDA];
        this.favoritos = new Contato[10];
    }

    /**
     * Acessa a lista de contatos mantida.
     * @return O array de contatos.
     */
    public Contato[] getContatos() {
        return this.contatos.clone();
    }

    public Contato[] getFavoritos() { return this.favoritos; }

    /**
     * Acessa os dados de um contato específico.
     * @param posicao Posição do contato na agenda.
     * @return Dados do contato. Null se não há contato na posição.
     */
    public Contato getContato(int posicao) {
        return contatos[posicao - 1];
    }

    /**
     * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
     * @param posicao Posição do contato.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     */
    public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        try {
            Contato contato = new Contato(nome.trim(), sobrenome.trim(), telefone.trim());

            // Verifica se todos os campos foram preenchidos.
            if (nome.equals("") || telefone.equals("")) {
                throw new IllegalArgumentException();
            }
            if (!existeContato(contato)) {
                if (posicao < 1 || posicao > 100) { // Posição inválida
                    System.err.println("--> POSIÇÃO INVÁLIDA!");
                    return false;
                }

                this.contatos[posicao - 1] = contato;
                System.out.println("\nCADASTRO REALIZADO!");
                return true;
            } else {
                throw new Exception();
            }
        } catch (IllegalArgumentException err) {
            System.err.println("--> CONTATO INVÁLIDO!");
        } catch (Exception err) {
            System.err.println("--> CONTATO JÁ CADASTRADO!");
        }
        return false;
    }

    public boolean adicionaFavorito(int posicao, Contato contato) {
        if (!contato.isFavorito()) {
            favoritos[posicao - 1] = contato;
            contato.setFavorito(true);
            System.out.println("\nCONTATO FAVORITADO NA POSIÇÃO " + posicao);
            return true;
        }
        System.err.println("--> CONTATO JÁ FAVORITADO!");
        return false;
    }

    public boolean removeFavorito(int posicao) {
        Contato contato = getContato(posicao);
        if (contato.isFavorito()) {
            contato.setFavorito(false);
            return true;
        }
        System.err.println("--> CONTATO JÁ NÃO É FAVORITO!");
        return false;
    }

    public boolean exibeContato(int posicao) {
        try {
            Contato contato = this.getContato(posicao);

            if (contato != null) {
                System.out.println("\nDados do contato:\n"
                        + contato);
                return true;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException err) {
            System.err.println("--> POSIÇÃO INVÁLIDA!");
        }
        return false;
    }
    private boolean existeContato(Contato contato) {
        for (Contato pessoa : contatos) {
            if (pessoa == null) { continue; }
            if (contato.equals(pessoa)) { return true; }
        }
        return false;
    }
}
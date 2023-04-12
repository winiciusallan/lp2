package agenda;

import java.util.InputMismatchException;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 *
 * @author nazareno
 *
 */
public class Agenda {

    private static final int TAMANHO_AGENDA = 100;

    private Contato[] contatos; // Representação dos contatos.

    /**
     * Cria uma agenda.
     */
    public Agenda() {
        this.contatos = new Contato[TAMANHO_AGENDA];
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
        return contatos[posicao];
    }

    /**
     * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
     * @param posicao Posição do contato.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     */
    public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        try {
            Contato contato = new Contato(nome, sobrenome, telefone);

            // Verifica se os campos foram preenchidos.
            if (nome.trim().equals("") || sobrenome.trim().equals("") || telefone.trim().equals("")) {
                throw new IllegalArgumentException();
            }
            if (!existeContato(contato)) {
                this.contatos[posicao - 1] = contato;
                System.out.println("\nCADASTRO REALIZADO!");
            } else {
                throw new Exception();
            }

        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println("--> POSIÇÃO INVÁLIDA!");
        } catch (IllegalArgumentException err) {
            System.err.println("--> CONTATO INVÁLIDO!");
        } catch (Exception err) {
            System.err.println("--> CONTATO JÁ CADASTRADO!");
        }
    }

    private boolean existeContato(Contato contato) {
        for (Contato pessoa : contatos) {
            if (pessoa == null) { continue; }
            if (contato.equals(pessoa)) { return true; }
        }
        return false;
    }
}
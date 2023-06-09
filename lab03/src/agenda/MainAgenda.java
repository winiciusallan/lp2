package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma representação de um menu por meio de uma interface no console, onde o usuário é capaz de
 * fazer uso das funcionalidades uma agenda, podendo criar, exibir, listar e favoritar seus contatos.
 *
 * @author Winicius Allan - 122110397.
 */
public class MainAgenda {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        System.out.println("Carregando agenda inicial");
        try {
            /*
             * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
             */
            carregaAgenda("src/agenda/agenda_inicial.csv", agenda);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, agenda, scanner);
        }

    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(C)adastrar Contato\n" +
                        "(L)istar Contatos\n" +
                        "(E)xibir Contato\n" +
                        "(F)avoritos\n" +
                        "(A)dicionar Favorito\n" +
                        "(R)emover Favorito\n" +
                        "(S)air\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param opcao   Opção digitada.
     * @param agenda  A agenda que estamos manipulando.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void comando(String opcao, Agenda agenda, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastraContato(agenda, scanner);
                break;
            case "L":
                listaContatos(agenda);
                break;
            case "E":
                exibeContato(agenda, scanner);
                break;
            case "F":
                listaFavoritos(agenda);
                break;
            case "A":
                adicionaFavorito(agenda, scanner);
                break;
            case "R":
                removeFavorito(agenda, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    /**
     * Imprime lista de contatos da agenda.
     *
     * @param agenda A agenda sendo manipulada.
     */
    private static void listaContatos(Agenda agenda) {
        System.out.println("\nLista de contatos: ");
        Contato[] contatos = agenda.getContatos();
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                System.out.println(formataContato(i + 1, contatos[i]));
            }
        }
    }

    private static void listaFavoritos(Agenda agenda) {
        System.out.println("\nLista de favoritos: ");
        Contato[] favoritos = agenda.getFavoritos();
        for (int i = 0; i < favoritos.length; i++) {
            if (favoritos[i] != null) {
                System.out.println(formataContato(i + 1, favoritos[i]));
            }
        }
    }

    /**
     * Imprime os detalhes de um dos contatos da agenda.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para capturar qual contato.
     */
    private static void exibeContato(Agenda agenda, Scanner scanner) {
        System.out.print("\nQual contato> ");
        int posicao = scanner.nextInt();
        try {
            Contato contato = agenda.getContato(posicao);

            if (contato != null) {
                System.out.println("\nDados do contato: \n" + contato);
            }
        } catch (IndexOutOfBoundsException err) {
            System.err.println("--> POSIÇÃO INVÁLIDA!");
        }
    }

    /**
     * Formata um contato para impressão na interface.
     *
     * @param posicao A posição do contato (que é exibida)/
     * @param contato O contato a ser impresso.
     * @return A String formatada.
     */
    private static String formataContato(int posicao, Contato contato) {
        return posicao
                + " - " + contato.getNome() + " "
                + contato.getSobrenome();
    }

    /**
     * Cadastra um contato na agenda.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void cadastraContato(Agenda agenda, Scanner scanner) {
        System.out.print("\nPosição na agenda [1-100]> ");
        int posicao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nNome> ");
        String nome = scanner.nextLine();
        System.out.print("\nSobrenome> ");
        String sobrenome = scanner.nextLine();
        System.out.print("\nTelefone> ");
        String telefone = scanner.nextLine();
        try {
            agenda.cadastraContato(posicao, nome, sobrenome, telefone);

            System.out.println("USUARIO CADASTRADO NA POSIÇÃO " + posicao);
        } catch (IllegalArgumentException | NullPointerException err) {
            System.err.println("-> CONTATO INVÁLIDO");
        } catch (InputMismatchException err) {
            System.err.println("-> USUÁRIO JÁ CADASTRADO");
        } catch (IndexOutOfBoundsException err) {
            System.err.println("-> POSIÇÃO INVÁLIDA");
        }
    }

    private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
        System.out.print("\nPosicao> ");
        int posicao = scanner.nextInt();
        System.out.print("Contato> ");
        int numContato = scanner.nextInt();
        try {
            agenda.adicionaFavorito(posicao, agenda.getContato(numContato));

            System.out.println("\nCONTATO FAVORITADO NA POSIÇÃO " + posicao);
        } catch (IllegalArgumentException err) {
            System.err.println("--> CONTATO JÁ FAVORITADO!");
        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println("--> POSIÇÃO INVÁLIDA!");
        }
    }

    private static void removeFavorito(Agenda agenda, Scanner scanner) {
        System.out.print("\nPosição> ");
        int posicao = scanner.nextInt();
        try {
            agenda.removeFavorito(posicao);
            System.out.println("CONTATO REMOVIDO NA POSIÇÃO " + posicao);
        } catch (IllegalArgumentException err) {
            System.err.println("--> CONTATO JÁ NÃO É FAVORITO!");
        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println("--> POSIÇÃO INVÁLIDA!");
        }
    }
    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }

    /**
     * Lê uma agenda de um arquivo csv.
     *
     * @param arquivoContatos O caminho para o arquivo.
     * @param agenda A agenda que deve ser populada com os dados.
     * @throws IOException Caso o arquivo não exista ou não possa ser lido.
     */
    private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
        LeitorDeAgenda leitor = new LeitorDeAgenda();

        int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}
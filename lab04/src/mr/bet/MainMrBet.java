package mr.bet;

import java.util.Locale;
import java.util.Scanner;

public class MainMrBet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MrBetController sistemaBase = new MrBetController();

        while (true) {
            menu();
            opcoes(input, input.nextLine().toUpperCase(), sistemaBase);
        }
    }

    private static void menu() {
        System.out.print(
                "------ Sistema Mr.Bet ------\n" +
                "(M)inha inclusão de times\n" +
                "(R)ecuperar Time\n" +
                "(A)dicionar campeonato\n" +
                "(B)ora incluir time em campeonato e verificar se time está no campeonato\n" +
                "(E)xibir campeonatos que o time participa\n" +
                "(T)entar a sorte e status\n" +
                "(F)echar programa\n" +
                "\nOpção > "
        );
    }

    private static void opcoes(Scanner scanner, String escolha, MrBetController mrBetController) {
        switch (escolha) {
            // To be implemented
            case "M" -> incluirTime(scanner, mrBetController);
            case "R" -> recuperarTime(scanner, mrBetController);
            case "A" -> adicionarCampeonato(scanner, mrBetController);
            case "B" -> incluirTimeEmCampeonatoOuVerificar(scanner, mrBetController);
            case "F" -> sair();
        }
    }

    private static void incluirTime(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\nCódigo: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Mascote: ");
        String mascote = scanner.nextLine();

        try {
            mrBetController.incluirTime(nome, codigo, mascote);
            System.out.println("\nINCLUSÃO REALIZADA\n");
        } catch (IllegalArgumentException err) {
            System.err.println("\nTIME JÁ EXISTE!\n");
        }
    }

    private static void recuperarTime(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\nCódigo: ");
        String codigo = scanner.nextLine();

        try {
            Time timeRecuperado = mrBetController.recuperarTime(codigo);
            System.out.println("\n" + timeRecuperado);
        } catch (IllegalArgumentException err) {
            System.err.println("TIME NÃO EXISTE!");
        }
    }

    private static void adicionarCampeonato(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\nCampeonato: ");
        String nome = scanner.nextLine();
        System.out.print("\nParticipantes: ");
        int participantes = scanner.nextInt();

        try {
            mrBetController.adicionarCampeonato(nome, participantes);
        } catch (IllegalArgumentException err) {
            System.err.println("\nCAMPEONATO JÁ EXISTE!");
        }
    }

    private static void incluirTimeEmCampeonatoOuVerificar(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\n(I)ncluir time em campeonato ou\n (V)erificar se time está em campeonato? ");
        String opcao = scanner.nextLine();
        if (opcao.equals("I")) {
            System.out.print("\nCódigo: ");
            String codigo = scanner.nextLine();
            System.out.print("\nCampeonato: ");
            String nomeCampeonato = scanner.nextLine();
        }
    }
    private static void sair() {
        System.exit(0);
    }
}

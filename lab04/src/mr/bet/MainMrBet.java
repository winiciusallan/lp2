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
                "(I)ncluir time em campeonato e verificar se time está no campeonato\n" +
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
            System.out.println(timeRecuperado);
        } catch (IllegalArgumentException err) {
            System.err.println("TIME NÃO EXISTE!");
        }
    }

    private static void sair() {
        System.exit(0);
    }
}

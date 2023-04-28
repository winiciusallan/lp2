package mr.bet;

import java.util.Locale;
import java.util.Scanner;

public class MainMrBet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            menu();
            opcoes(input.nextLine().toUpperCase());
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

    private static void opcoes(String escolha) {
        switch (escolha) {
            // To be implemented
            case "F" -> sair();
        }

    }
    private static void sair() {
        System.exit(0);
    }
}

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
            """
                    ------ Sistema Mr.Bet ------
                    (M)inha inclusão de times
                    (R)ecuperar Time
                    (A)dicionar campeonato
                    (B)ora incluir time em campeonato e verificar se time está no campeonato
                    (E)xibir campeonatos que o time participa
                    (T)entar a sorte e status
                    (F)echar programa

                    Opção >\s"""
        );
    }

    private static void opcoes(Scanner scanner, String escolha, MrBetController mrBetController) {
        switch (escolha) {
            // To be implemented
            case "M" -> incluirTime(scanner, mrBetController);
            case "R" -> recuperarTime(scanner, mrBetController);
            case "A" -> adicionarCampeonato(scanner, mrBetController);
            case "B" -> incluirTimeEmCampeonatoOuVerificar(scanner, mrBetController);
            case "E" -> exibirCamepeonatosTimeParticipa(scanner, mrBetController);
            case "T" -> tentarSorteEStatus(scanner, mrBetController);
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
        scanner.nextLine();
        try {
            mrBetController.adicionarCampeonato(nome, participantes);
            System.out.println("\nCAMPEONATO ADICIONADO!");
        } catch (IllegalArgumentException err) {
            System.err.println("\nCAMPEONATO JÁ EXISTE!");
        }
    }

    private static void incluirTimeEmCampeonatoOuVerificar(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\n(I)ncluir time em campeonato ou\n(V)erificar se time está em campeonato? ");
        String opcao = scanner.nextLine().toUpperCase();
        System.out.print("\nCódigo: ");
        String codigo = scanner.nextLine();
        System.out.print("\nCampeonato: ");
        String nomeCampeonato = scanner.nextLine();
        try {
            if (opcao.equals("I")) {
                mrBetController.incluirTimeEmCampeonato(codigo, nomeCampeonato);
                System.out.println("\nTIME INCLUIDO NO CAMPEONATO");
            }
            if (opcao.equals("V")) {
                if (mrBetController.verificarTimeEmCampeonato(codigo, nomeCampeonato)) {
                    System.out.println("\nO TIME ESTÁ NO CAMPEONATO");
                } else {
                    System.out.println("\nO TIME NÃO ESTÁ NO CAMPEONATO");
                }
            }
        } catch (IndexOutOfBoundsException err) {
            System.err.println("\nTODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUIDOS!");
        } catch (IllegalArgumentException err) {
            System.err.println(err.getMessage());
        }
//        if (opcao.equals("I")) {
//            try {
//                mrBetController.incluirTimeEmCampeonato(codigo, nomeCampeonato);
//            } catch (IndexOutOfBoundsException err) {
//                System.err.println("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUIDOS!");
//            } catch (IllegalArgumentException err) {
//                System.err.println(err.getMessage());
//            }
//        }
//        if (opcao.equals("V")) {
//            try {
//                mrBetController.verificarTimeEmCampeonato(codigo, nomeCampeonato);
//            }
//        }
    }

    private static void exibirCamepeonatosTimeParticipa(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\nTime: ");
        String codigo = scanner.nextLine();
        try {
            System.out.println(
                    mrBetController.exibirCampeonatosTimeParticipa(codigo)
            );
        } catch (IllegalArgumentException err) {
            System.err.println(err.getMessage());
        }
    }

    private static void tentarSorteEStatus(Scanner scanner, MrBetController mrBetController) {
        System.out.print("\n(A)postar ou (S)tatus das Apostas? ");
        String opcao = scanner.nextLine().toUpperCase();
        try {
            if (opcao.equals("A")) {
                System.out.print("\nCódigo: ");
                String codigo = scanner.nextLine();
                System.out.print("Campeonato: ");
                String camp = scanner.nextLine();
                System.out.print("Colocação: ");
                int colocacao = scanner.nextInt();
                System.out.print("Valor da Aposta: R$");
                double valor = scanner.nextDouble();
                mrBetController.apostar(codigo, camp, colocacao, valor);
                System.out.println("APOSTA REGISTRADA!");
            }
            if (opcao.equals("S")) {
                System.out.println(mrBetController.statusApostas());
            }
        } catch (IllegalArgumentException err) {
            System.err.println(err.getMessage());
        }
    }
    private static void sair() {
        System.out.println("Por hoje é só pessoal!");
        System.exit(0);
    }
}

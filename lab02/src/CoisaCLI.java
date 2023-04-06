import java.util.Scanner;

public class CoisaCLI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menu();
        while (true) {
            realizaOpcao(args);
            System.out.println();
            System.out.println("----------");
            args = input.nextLine().split(" ");
        }
    }

    public static void menu() {
        System.out.println("-----------------");
        System.out.println("  Sistema CoiSa  ");
        System.out.println("-----------------");
        System.out.println("Adicionar tempo online - TEMPOONLINE");
        System.out.println("Adicionar resumo - RESUMO");
        System.out.println("Adicionar descanso - DESCANSO");
        System.out.println("    1. HORASDESCANSO\n    2. NUMEROSEMANAS");
        System.out.println("Adicionar disciplina - DISCIPLINA");
        System.out.println("    1. CADASTRAHORAS\n    2. CADASTRANOTA");
        System.out.println("Sair - X");
        System.out.println("----");
    }

    public static void realizaOpcao(String[] args) {
        MenuOpcoes opcao = MenuOpcoes.valueOf(args[0]);

        switch (opcao) {
            case TEMPOONLINE -> registrarTempoOnline(args);
            case RESUMO -> registrarResumos(args);
            case DESCANSO -> registrarDescanso(args);
            case DISCIPLINA -> controlarDisciplina(args);
            case X -> sair();
        }
    }

    private static void registrarTempoOnline(String[] args) {
        RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
        tempoLP2.adicionaTempoOnline(Integer.parseInt(args[2]));
        System.out.println(tempoLP2);
    }

    public static void registrarDescanso(String[] args) {
        Descanso descanso = new Descanso();

        if (args[1].equals("HORASDESCANSO")) {
            descanso.defineHorasDescanso(Integer.parseInt(args[2]));
        }
        if (args[1].equals("NUMEROSEMANAS")) {
            descanso.defineHorasDescanso(Integer.parseInt(args[2]));
        }

        System.out.println(descanso.getStatusGeral());
    }

    private static void controlarDisciplina(String[] args) {
        Disciplina prog2 = new Disciplina(args[1]);

        if (args[1].equals("CADASTRAHORAS")) {
            prog2.cadastraHoras(Integer.parseInt(args[2]));
        }
        if (args[1].equals("CADASTRANOTA")) {
            prog2.cadastraNota(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        }
    }

    private static void registrarResumos(String[] args) {
        RegistroResumos meusResumos = new RegistroResumos(100);  // 100 resumos

        meusResumos.adiciona(args[1], meuSlice(args, 2, args.length));

        System.out.println();
        System.out.println("Resumos: ");
        System.out.println(meusResumos.imprimeResumos());
        System.out.println(meusResumos.temResumo("Classes"));
        System.out.println(meusResumos.temResumo("Objetos"));
    }

    private static String meuSlice(String[] arr, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += arr[i];
        }

        return result;
    }

    private static void sair() {
        System.exit(0); // Status 0 -> O programa terminou bem.
    }
}
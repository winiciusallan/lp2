public class CoisaCLI {
    public static void main(String[] args) {
        menu();
        realizaOpcao(args[0]);

    }

    public static void menu() {
        System.out.println("---------------");
        System.out.println(" Sistema CoiSa ");
        System.out.println("---------------");
        System.out.println("Adicionar tempo online - TEMPOONLINE");
        System.out.println("Adicionar resumo - RESUMO");
        System.out.println("Adicionar descanso - DESCANSO");
        System.out.println("----");
    }

    public static void realizaOpcao(String args) {
        MenuOpcoes opcao = MenuOpcoes.valueOf(args);

        switch (opcao) {
            case TEMPOONLINE -> registrarTempoOnline();
            case RESUMO -> registrarResumos();
            case DESCANSO -> registrarDescanso();
            case DISCIPLINA -> controlarDisciplina();
//            case X -> sair();
        }
    }

//    public static String[] processaEntrada(String entrada) {
//        String[] convertido = entrada.split(" ");
//
//        if (entrada.equals("X")) { sair(); }
//
//        return convertido;
//    }

//    private static void sair() {
//        System.exit(1);
//    }

    private static void registrarTempoOnline() {
        System.out.println("works!");
    }

    public static void registrarDescanso() {
        System.out.println("works!");
    }

    private static void controlarDisciplina() {
        System.out.println("works!");
    }

    private static void registrarResumos() {
        RegistroResumos meusResumos = new RegistroResumos(100);  // 100 resumos

        meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
        meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");

        String[] resumos = meusResumos.pegaResumos();


        for (int i = 0; i < meusResumos.conta(); i++) {
            System.out.println(resumos[i]);
        }


        System.out.println();
        System.out.println("Resumos: ");
        System.out.println(meusResumos.imprimeResumos());
        System.out.println(meusResumos.temResumo("Classes"));
        System.out.println(meusResumos.temResumo("Objetos"));
    }
 }

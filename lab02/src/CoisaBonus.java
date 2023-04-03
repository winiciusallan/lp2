/**
 * Classe para testar implementação da seção "Bônus" do Lab 02
 *
 * @author Winicius Allan - 12211397
 */
public class CoisaBonus {
    public static void main(String[] args) {
        controlarDisciplina();
        System.out.println("----");
        registrarResumos();
        System.out.println("----");
        registrarDescanso();
        System.out.println("----");
    }

    public static void controlarDisciplina() {
        int[] pesos = {6, 4};
        Disciplina prog2 = new Disciplina("PROGRAMAÇÃO 2", 2, pesos);
        prog2.cadastraHoras(5);
        prog2.cadastraNota(1, 8.0);
        prog2.cadastraNota(2, 7.0);
        System.out.println(prog2.calculaMediaPonderada());
        System.out.println(prog2);
    }

    public static void registrarDescanso() {
        Descanso descanso = new Descanso();
        descanso.definirEmoji("<(^_^<)");
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        descanso.definirEmoji("");
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }

    private static void registrarResumos() {
        RegistroResumos meusResumos = new RegistroResumos(100);  // 100 resumos

        meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
        meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");

        String[] resumos = meusResumos.pegaResumos();
        String[] buscados = meusResumos.busca("um");

        for (int i = 0; i < buscados.length; i++) {
            if (i == 0) {
                System.out.print(buscados[i] + " | ");
            } else {
                System.out.print(buscados[i]);
            }
        }
        System.out.println();

    }
}

/**
 * Classe para testar implementação da seção "Bônus" do Lab 02
 *
 * @author Winicius Allan - 12211397
 */
public class CoisaBonus {
    public static void main(String[] args) {
        controlarDisciplina();
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
}

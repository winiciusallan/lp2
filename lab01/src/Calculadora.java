import java.util.Scanner;

public class Calculadora {
    /**
     * Laboratório de Programação 2 - Lab 1
     *
     * @author Winicius Allan - 122110397
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char operacao = input.next().charAt(0);

        if ( !meuIn(operacao, "+-*/")) { // método .equals() pode ser usado para comparar duas Strings
            System.out.println("ENTRADA INVALIDA");
        } else {
            float num01 = input.nextFloat();
            float num02 = input.nextFloat();

            if (operacao == '+') {
                System.out.println("RESULTADO: " + (num01 + num02));
                }
            else if (operacao == '-') {
                System.out.println("RESULTADO: " + (num01 - num02));
            }
            else if (operacao == '*') {
                System.out.println("RESULTADO: " + (num01 * num02));
            }
            else if (operacao == '/') {
                if (num02 == 0) {
                    System.out.println("ERRO");
                } else {
                    System.out.println("RESULTADO: " + (num01 / num02));
                }
            }
        }

    }

    public static boolean meuIn(char elem, String seq) {
        for (int i = 0; i < seq.length(); i++) {
            if (elem == seq.charAt(i)) { return true; }
        }
        return false;
    }
}


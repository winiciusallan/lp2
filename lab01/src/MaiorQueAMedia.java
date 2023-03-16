import java.util.Scanner;

public class MaiorQueAMedia {
    /**
     * Laboratório de Programação 2 - Lab 1
     *
     * @author Winicius Allan - 122110397
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] entrada = input.nextLine().split(" "); // Separar a entrada por espaço em branco

        int[] numeros = new int[entrada.length];
        int soma = 0;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]); // Converter a entrada em inteiro e adiciona em outro array
            soma += numeros[i];
        }

        String output = "";
        for (int num : numeros) {
            if (num > soma / numeros.length) {
                if (output.equals("")) {
                    output += num;
                } else {
                    output += " " + num;
                }
            }
        }

        System.out.println(output);
        input.close();
    }
}

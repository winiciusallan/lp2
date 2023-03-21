import java.util.Scanner;

/**
* Laboratório de Programação 2 - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class DiferencaMaiorEMenor {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
 
        int[] numeros = {input.nextInt(), input.nextInt(), input.nextInt(),
                         input.nextInt(), input.nextInt()};
        int maior = numeros[0];
        int menor = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > maior) { maior = numeros[i]; }
            if (numeros[i] < menor) { menor = numeros[i]; }
        }

        System.out.println(maior - menor);

        input.close();
    }
}


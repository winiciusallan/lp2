import java.util.Scanner;

/**
* @author Winicius Allan - 122110397
*/

public class QuatroSemanas {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] entrada;
        int[] gastos; int soma = 0;
        int maior = 0; int menor = 100;

        for (int i = 0; i < 4; i++) {
            soma = 0; maior = 0; menor = 100;
            entrada = input.nextLine().split(" ");
            gastos = converteInteiro(entrada);

            for (int j = 0; j < gastos.length; j++) {
                soma += gastos[j];
                if (gastos[j] > maior) { maior = gastos[j]; }
                if (gastos[j] < menor) { menor = gastos[j]; }
            }

            System.out.println(soma + " " + menor + " " + maior);
        }

        input.close();
    }

    public static int[] converteInteiro(String[] array) {
        int[] numeros = new int[array.length];   
        
        for (int j = 0; j < array.length; j++) { // Converte valores da entrada para inteiro
            numeros[j] = Integer.parseInt(array[j]);    
        }
        return numeros;
    }
}

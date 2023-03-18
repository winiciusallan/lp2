import java.util.Scanner;

public class GastosDaEmpresa {
    /**
     * Laboratorio de Programação 2 - Lab 1
     *
     * @author Winicius Allan - 122110397
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String[] entrada = input.nextLine().split(" ");
        int[] numeros = new int[entrada.length];

        int primeiroMaior = 0; int segundoMaior = 0;
        
        for (int i = 0; i < entrada.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]); // Converte os valores da entrada para inteiro
        }

        for (int i = 0; i < numeros.length; i++) { // Ordena a lista
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }

        primeiroMaior = numeros[numeros.length - 1];
        segundoMaior = numeros[numeros.length - 2];
 
        System.out.println(primeiroMaior + segundoMaior);
        input.close();
    }
}

import java.util.Scanner;

/**
* Laboratório de Programação 2 - Lab 1
*
* @author Winicius Allan - 122110397
*/

public class FiltroTemperatura {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int cont = 0;
        int valor;

        while (true) {
            valor = input.nextInt();       
            if (valor == 0) { break; }
            
            if (valor < 0) { cont++; }
        }
       
        System.out.println(cont);

        input.close();
    }
}        

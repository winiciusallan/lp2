import java.util.Scanner;

/**
* Laboratório de Programação 2 - Lab 1
*
* @author Winicius Allan - 122110397
*/

public class AbaixoAssinado {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int contPessoas = 0; int soma = 0;

        String[] assinatura;

        while (true) {
            assinatura = input.nextLine().split(" ");
            
            if (assinatura[0].equals("fim")) { break; }

            contPessoas++;
            soma += Integer.parseInt(assinatura[1]);

        }
        
        System.out.println(contPessoas);
        System.out.println(soma / contPessoas);

        input.close();
    }
}

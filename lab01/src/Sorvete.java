import java.util.Scanner;

/**
* Laboratório de Programação - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class Sorvete {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int posInit1; int velocidade1; int posInit2; int velocidade2; int tempo;

        posInit1 = input.nextInt();
        velocidade1 = input.nextInt();
        posInit2 = input.nextInt();
        velocidade2 = input.nextInt();
        tempo = input.nextInt();

        int distancia1 = posInit1 + velocidade1 * tempo;
        int distancia2 = posInit2 + velocidade2 * tempo;

        System.out.println(Math.abs(distancia1 - distancia2));
    }
}

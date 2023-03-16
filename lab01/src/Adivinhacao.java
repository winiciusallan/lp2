import java.util.Scanner;

public class Adivinhacao {
    /**
     * Laboratório de Programação - Lab 1
     *
     * @author Winicius Allan - 122110397
     * **/ 
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int numeroPensado = input.nextInt();
        int tentativa;

        while (true) {
            tentativa = input.nextInt();

            if (tentativa == numeroPensado) {
                System.out.println("ACERTOU");
                break;
            }
            if (tentativa > numeroPensado) {
                System.out.println("MAIOR");
            }
            if (tentativa < numeroPensado) {
                System.out.println("MENOR");
            }
        }
    }
}

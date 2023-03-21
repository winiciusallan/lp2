import java.util.Scanner;

/**
* Laboratório de Programação - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class RepresentarCores {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int red = input.nextInt();
        int green = input.nextInt();
        int blue = input.nextInt();

        if (red < 128 || green < 128 || blue < 128) { System.out.println("PRETO"); }
        else { System.out.println("BRANCO"); }
    }
}

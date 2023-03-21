import java.util.Scanner;

/**
* Laboratório de Programação 2 - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class InicioDaVogal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] palavras = {input.nextLine(), input.nextLine(), input.nextLine(),
                             input.nextLine(), input.nextLine()};

        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i].charAt(0) == 'a') { System.out.println('s'); }
            else { System.out.println('n'); }
        }
        
        input.close();
    }
}


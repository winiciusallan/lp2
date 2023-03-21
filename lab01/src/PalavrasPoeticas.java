import java.util.Scanner;

/**
* Laboratorio de Programação - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class PalavrasPoeticas {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        String primeiraPalavra = getFirstAndLastLetter(input.nextLine());
        String segundaPalavra = getFirstAndLastLetter(input.nextLine());

        if (primeiraPalavra.equals(segundaPalavra)) {
            System.out.println('S');
        } else {
            System.out.println('N');
          }

        input.close();
    }

    public static String getFirstAndLastLetter(String palavra) {
        
        String output = "";

        for (int i = 0; i < palavra.length(); i++) {
            if (i == 0 || i == palavra.length() - 1) {
                output += palavra.charAt(i);
            }
        }
        return output;
    }
}

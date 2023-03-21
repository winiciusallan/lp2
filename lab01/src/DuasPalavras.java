import java.util.Scanner;

/**
* Laboratório de Programação - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class DuasPalavras {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String primeiraPalavra = input.nextLine();
        String segundaPalavra = input.nextLine();

        if (primeiraPalavra.length() > segundaPalavra.length()) {
            System.out.println(segundaPalavra);
            System.out.println(primeiraPalavra);
        } else if (segundaPalavra.length() > primeiraPalavra.length()) {
            System.out.println(primeiraPalavra);
            System.out.println(segundaPalavra);
          } else {
            System.out.println(primeiraPalavra);
            System.out.println(primeiraPalavra);
            }
    }
}
        

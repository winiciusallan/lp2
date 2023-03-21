import java.util.Scanner;

/**
* Laboratório de Programação 2 - Lab 1
*
* @author Winicius Allan - 122110397
*/
public class MaiorMenorPalavra {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] palavras = {input.nextLine(), input.nextLine(),
                            input.nextLine(), input.nextLine(), input.nextLine()};
        String menorPalavra = palavras[0];
        String maiorPalavra = palavras[0];

        for (int i = 0; i < palavras.length; i++) {
            
            if (palavras[i].length() > maiorPalavra.length()) { maiorPalavra = palavras[i]; }
            if (palavras[i].length() < menorPalavra.length()) { menorPalavra = palavras[i]; }
        }

        System.out.println(menorPalavra);
        System.out.println(maiorPalavra);

        input.close();
    }
}

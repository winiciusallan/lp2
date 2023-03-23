import java.util.Scanner;

public class RepeticaoCondicao {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int entrada; int soma = 0;

        while (true) {
            entrada = input.nextInt();

            if (entrada == -1) { break; }
            if (entrada % 2 == 0) { soma += entrada; }
        }
        
        System.out.println(soma);

        input.close();
    }
}

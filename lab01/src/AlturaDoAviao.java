import java.util.Scanner;

public class AlturaDoAviao {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int alturaIdeal = input.nextInt();
        int alturaInicial = input.nextInt();

        int aproximacaoAtual = Math.abs(alturaIdeal - alturaInicial);

        int altura = 0; int aproximacao = 0;
        while (true) {
            
            altura = input.nextInt();
            aproximacao = Math.abs(alturaIdeal - altura);

            String msg = aproximacao < aproximacaoAtual ? "ADEQUADO" : "PERIGO";
            aproximacaoAtual = aproximacao;

            if (aproximacaoAtual == 0) { 
                System.out.println("OK");
                break;
            }

            System.out.println(msg);         
            
        }
   }
}

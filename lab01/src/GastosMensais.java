import java.util.Scanner;

public class GastosMensais {
    /**
    * Laboratório de Programação - Lab 1
    *
    * @author Winicius Allan - 122110397
    **/
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
            
        String mes;
        String[] meses = input.nextLine().split(" ");
        String[] valores = input.nextLine().split(" ");
        int[] gastos = new int[meses.length];


        for (int i = 0; i < valores.length; i++) {
            gastos[i] = Integer.parseInt(valores[i]); // Converte a lista de valores para inteiro
        }
        
        mes = input.nextLine();

        for (int i = 0; i < meses.length; i++) {
        
            if (meses[i].equals(mes)) {
                System.out.println(gastos[i]);
                break;
            }
        }
    }
}

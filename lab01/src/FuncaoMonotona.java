import java.util.Scanner;

public class FuncaoMonotona {
    /**
     * Laboratório de Programação 2 - Lab 1
     *
     * @author Winicius Allan - 122110397
     */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num01, num02, num03, num04;
        num01 = input.nextInt();
        num02 = input.nextInt();
        num03 = input.nextInt();
        num04 = input.nextInt();

        if (num01 < num02) {
            if (num02 < num03) {
                if (num03 < num04) {
                    System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
                } else {
                    System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
                }
            } else {
                System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
            }
        } else if (num01 > num02) {
            if (num02 > num03) {
                if (num03 > num04) {
                    System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
                } else {
                    System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
                }
            } else {
                System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
            }
        } else {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
}

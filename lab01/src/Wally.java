import java.util.Scanner;

public class Wally {
    /**
     * Laboratório de Programação - Lab 1
     *
     * @author Winicius Allan - 122110397
     * **/

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] nomes = input.nextLine().split(" ");

        while (true) {
            boolean exists = false;

            if (nomes[0].equals("wally")) { break; }

            for (int i = nomes.length - 1; i >= 0; i--) {
                if (nomes[i].length() == 5) {
                    System.out.println(nomes[i]);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                System.out.println("?");
            }

            nomes = input.nextLine().split(" ");
        }
    }
}



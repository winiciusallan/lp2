import java.util.Scanner;

/**
* @author Winicius Allan - 122110397
*/

public class UltimaVogal {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        String output = "";
        for (int i = 0; i < 5; i++) {
            String palavra = input.nextLine();

            if (temVogal(palavra)) {
               output += palavra.charAt(palavra.length() - 1); 
            }
        }
        
        System.out.println(output);

        input.close();
    }
    
    public static boolean temVogal(String palavra) {
        
        char letra = palavra.charAt(palavra.length() - 1); // Pega ultima letra
        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            return true;
        }
        return false;
    }
}

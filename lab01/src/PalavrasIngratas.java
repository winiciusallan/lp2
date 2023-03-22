import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Winicius Allan - 122110397
 */

public class PalavrasIngratas {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		String[] ingratas = new String[3];
		int cont = 0;
		

		do {
			String palavra = input.nextLine();
			
			if (!verificaVogal(palavra)) {
				ingratas[cont] = palavra;
				cont += 1;
			}
		} while (cont < 3);
		
		for (String ingrata : ingratas) {
			System.out.println(ingrata);
		}

		input.close();
	}

	public static boolean verificaVogal(String palavra) {
		
		for (int i = 0; i < palavra.length(); i++) {
			if (palavra.charAt(i) == 'a' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'i'
				|| palavra.charAt(i) == 'o' || palavra.charAt(i) == 'u') { return true; }
		}		
		
		return false;
	}
}

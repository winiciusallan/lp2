import java.util.Scanner;

public class PassouOuNao {
	/**
	 * Laboratório de Programação 2 - Lab 1
 	 * 
 	 * @author Winicius Allan - 122110397
 	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		float num1, num2;
		num1 = input.nextFloat();
		num2 = input.nextFloat();

		if ((num1 + num2) / 2 >= 7.0) {
			System.out.println("pass: True!");
		} else {
			System.out.println("pass: False!");
		}
	}
}

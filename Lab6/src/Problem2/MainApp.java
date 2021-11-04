package Problem2;

import java.util.Scanner;

import com.sun.tools.sjavac.server.SysInfo;

public class MainApp {

	public static void main(String[] args) throws wordsInsteadOfNumbers {
		Scanner input = new Scanner(System.in);
		String str_nr1 = "", str_nr2 = "";
		int nr1 = 0, nr2 = 0;
		boolean valid = false;
		do {

			System.out.print("Primul numar: ");
			str_nr1 = input.nextLine();
			System.out.print("Al doilea numar: ");
			str_nr2 = input.nextLine();
			try {
				nr1 = Integer.parseInt(str_nr1);
				nr2 = Integer.parseInt(str_nr2);
				try {
					if (nr2 == 0) {
						throw new divisionByZeroException();

					} else
						valid = true;
				} catch (divisionByZeroException ex) {
					System.out.println(ex.toString());
				}
			} catch (NumberFormatException e) {
				System.out.println(new wordsInsteadOfNumbers().toString());
			}
		} while (!valid);
		System.out.println("Rezultatul impartirii este: " + ((float) nr1 / nr2));
	}
}

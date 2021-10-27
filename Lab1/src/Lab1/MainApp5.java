package Lab1;

import java.util.Random;

public class MainApp5 {

	public static void main(String[] args) {
		Random rnd = new Random();
		int n1 = 0, n2 = 1, n3 = 0, nr = rnd.nextInt(20);
		Boolean apartine = false;
		System.out.print("Sirul lui Fibonacci: ");
		System.out.print(n1 + " " + n2);
		if (nr == 0)
			apartine = true;
		
		while (n3 <= nr && !apartine) {
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
			if (n3 == nr)
				apartine = true;
		}
		System.out.println("...");
		if (apartine)
			System.out.println("Numarul " + nr + " apartine sirului");
		else
			System.out.println("Numarul " + nr + " nu apartine sirului");

	}

}

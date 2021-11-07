package Problema1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		int nr1 = 0, nr2 = 0;
		boolean valid = false;
		do {
			try {
				System.out.print("Primul numar: ");
				nr1 = input.nextInt();
				System.out.print("Al doilea numar: ");
				nr2 = input.nextInt();
				if (nr1 > nr2) {
					throw new numarMaiMicException(nr1, nr2);

				} else
					valid = true;
			} catch (numarMaiMicException ex) {
				System.out.println(ex.toString());
			}
		} while (!valid);
		PrintStream writer = new PrintStream(args[0]);
		writer.println(nr1 + " " + nr2);
		System.out.println("Fisierul a fost scris cu succes!");
		input.close();
		writer.close();

	}

}

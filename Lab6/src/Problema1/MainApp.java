package Problema1;

import java.io.File;
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
					throw new numarMaiMic(nr1, nr2);

				} else
					valid = true;
			} catch (numarMaiMic ex) {
				System.out.println(ex.toString());
			}
		} while (!valid);
		PrintStream writer;
		writer = new PrintStream(new File(args[0]));
		writer.println(nr1 + " " + nr2);
		input.close();
		writer.close();

	}

}

class numarMaiMic extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nr1;
	private int nr2;

	public numarMaiMic(int nr1, int nr2) {// constructor
		this.nr1 = nr1;
		this.nr2 = nr2;
	}

	public String toString() {
		return "Primul numar [" + nr1 + "] este mai mare decat al doilea [" + nr2 + "]";
	}
}

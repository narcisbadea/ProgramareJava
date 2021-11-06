package Problema3;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		String nume, cnp;
		Scanner input = new Scanner(System.in);
		System.out.print("Nume: ");
		nume = input.nextLine();
		boolean valid = false;
		do {
			System.out.print("CNP: ");
			cnp = input.nextLine();
			try {
				if (cnp.length() != 13)
					throw new cnpExceptions("size");

				if (!"1256".contains(cnp.substring(0, 1)))
					throw new cnpExceptions("cifraSexului");
				
				int ziNastere = Integer.parseInt(cnp.substring(3, 5));
				if(ziNastere<1||ziNastere>31)
					throw new cnpExceptions("ziuaNasterii");
				
				int lunaNastere = Integer.parseInt(cnp.substring(5, 7));
				if(lunaNastere<1||lunaNastere>12)
					throw new cnpExceptions("lunaNasterii");
				
				valid = true;
			} catch (cnpExceptions ex) {
				System.out.println(ex.toString());
			}
		} while (!valid);
	}

}

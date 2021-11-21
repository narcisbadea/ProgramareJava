package Problema3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		String nume, cnp;
		Scanner input = new Scanner(System.in);
		System.out.print("Nume: ");
		nume = input.nextLine();
		boolean valid = false;
		do {
			System.out.print("CNP: ");
			cnp = input.nextLine();
			try {

				try {
					Long.parseLong(cnp);
				} catch (NumberFormatException e) {
					throw new cnpExceptions("cifre");
				}

				if (cnp.length() != 13)
					throw new cnpExceptions("size");

				if (!"1256".contains(cnp.substring(0, 1)))
					throw new cnpExceptions("cifraSexului");

				int ziNastere = Integer.parseInt(cnp.substring(3, 5));
				if (ziNastere < 1 || ziNastere > 31)
					throw new cnpExceptions("ziuaNasterii");

				int lunaNastere = Integer.parseInt(cnp.substring(5, 7));
				if (lunaNastere < 1 || lunaNastere > 12)
					throw new cnpExceptions("lunaNasterii");

				int codJudet = Integer.parseInt(cnp.substring(7, 9));
				if (codJudet < 1 || codJudet > 42)
					throw new cnpExceptions("codJudet");

				if (!cifraDeControl(cnp)) {
					throw new cnpExceptions("cifraContro");
				}

				if (cnp.substring(9, 12) == "000") {
					throw new cnpExceptions("nrOrdine");
				}

				valid = true;
			} catch (cnpExceptions ex) {
				System.out.println(ex.toString());
			}
		} while (!valid);

		// Anul nasterii
		int anNastere = cnp.charAt(0) - '0';
		anNastere = anNastere > 2 ? 2000 : 1900;
		anNastere += Integer.parseInt(cnp.substring(1, 3));
		LocalDate dataNasterii = LocalDate.of(anNastere, Integer.parseInt(cnp.substring(3, 5)),
				Integer.parseInt(cnp.substring(5, 7)));
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dataNasteriiFormatata = dataNasterii.format(myFormatObj);
		System.out.println("Data nasterii: " + dataNasteriiFormatata);

		// Varsta
		int varsta = Period.between(dataNasterii, LocalDate.now()).getYears();
		System.out.println("Varsta: " + varsta);

		input.close();
	}

	public static boolean cifraDeControl(String cnp) {
		String numarControl = "279146358279";
		int suma = 0;
		for (int i = 0; i < cnp.length() - 1; i++) {
			suma += ((cnp.charAt(i) - '0') * (numarControl.charAt(i) - '0'));
		}
		suma %= 11;

		if (suma == 10) {
			suma = 1;
		}
		if (suma == (cnp.charAt(12) - '0'))
			return true;

		return false;
	}

}

package Problema3;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
import java.util.zip.ZipEntry;

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
				valid = true;
			} catch (cnpExceptions ex) {
				System.out.println(ex.toString());
			}
		} while (!valid);
		int anNastere = cnp.charAt(0) - '0';
		anNastere = anNastere > 2 ? 2000 : 1900;
		anNastere += Integer.parseInt(cnp.substring(1, 3));
		LocalDate dataNasterii = LocalDate.of(anNastere, Integer.parseInt(cnp.substring(5, 7)),
				Integer.parseInt(cnp.substring(3, 5)));
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    String dataNasteriiFormatata = dataNasterii.format(myFormatObj);
		System.out.println("Data nasterii: " + dataNasteriiFormatata);
		int vartsa = Period.between(dataNasterii, LocalDate.now()).getYears();

		System.out.println("Varsta: " + vartsa);
	}

}

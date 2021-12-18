package Probleme;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		List<Angajat> angajati = citireAngajati();
		
		angajati
		.stream()
		.forEach(System.out::println);
	}

	public static List<Angajat> citireAngajati() {
		List<Angajat> angajati = new ArrayList<Angajat>();
		Scanner scann = null;

		try {
			scann = new Scanner(new File("ang.txt"));
		} catch (Exception e) {
			System.out.println("Nu s-a putut deschide fisierul 'ang.txt'");
			System.exit(0);
		}

		String input, aux[];

		while (scann.hasNextLine()) {
			input = scann.nextLine();
			aux = input.split(",");

			if (aux.length != 4) {
				System.out.println("Informatiile din fisier nu sunt valide");
				System.exit(0);
			}

			int zi, luna, an;
			String[] a = aux[2].split("\\.");

			zi = Integer.parseInt(a[0].trim());
			luna = Integer.parseInt(a[1].trim());
			an = Integer.parseInt(a[2].trim());
			LocalDate data = LocalDate.of(an, luna, zi);
			angajati.add(new Angajat(aux[0].trim(), aux[1].trim(), data, Float.parseFloat(aux[3].trim())));
		}

		scann.close();
		return angajati;
	}

}

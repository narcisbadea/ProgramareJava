package Probleme;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {

	public static void main(String[] args) {
		List<Angajat> angajati = citireAngajati();
		
		System.out.println("Angajatii: ");
		angajati
		.stream()
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Angajatii cu salariul > 2500: ");
		angajati
		.stream()
		.filter(angajat -> angajat.getSalariu() > 2500)
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Sefi si directorii angajati in aprilie: ");
		angajati
			.stream()
			.filter(angajat -> (angajat.getDataAngajare().getMonth()==Month.APRIL)&&(angajat.getPostul().toLowerCase().equals("sef")||angajat.getPostul().toLowerCase().equals("director")))
			.collect(Collectors.toList())
			.stream()
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Angajatii sortati care nu au functii de conducere sortati dupa salariu: ");
		angajati
			.stream()
			.filter(angajat -> !(angajat.getPostul().toLowerCase().equals("sef")||angajat.getPostul().toLowerCase().equals("director")))
			.sorted((Angajat a, Angajat b) -> -Float.compare(a.getSalariu(), b.getSalariu()))
			.collect(Collectors.toList())
			.stream()
			.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Numele angajatilor cu majuscule: ");
		
		
		angajati
			.stream()
			.map(Angajat::getNume)
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Salariile mai mici de 3000: ");
		angajati
			.stream()
			.map(Angajat::getSalariu)
			.filter(salariu -> salariu < 3000)
			.forEach(System.out::println);

		
		System.out.println();
	}

	public static List<Angajat> citireAngajati() {
		List<Angajat> angajati = new ArrayList<Angajat>();
		Scanner scan = null;

		try {
			scan = new Scanner(new File("ang.txt"));
		} catch (Exception e) {
			System.out.println("Fisierul nu a putut fii deschis!");
		}

		String aux[];

		while (scan.hasNextLine()) {
			aux = scan.nextLine().split(",");
			
			int zi, luna, an;
			String[] a = aux[2].split("\\.");
			zi = Integer.parseInt(a[0].trim());
			luna = Integer.parseInt(a[1].trim());
			an = Integer.parseInt(a[2].trim());
			LocalDate data = LocalDate.of(an, luna, zi);
			
			angajati.add(new Angajat(aux[0].trim(), aux[1].trim(), data, Float.parseFloat(aux[3].trim())));
		}

		scan.close();
		return angajati;
	}

}

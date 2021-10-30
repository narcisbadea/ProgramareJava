package Problema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));

		HashMap<Integer, Carte> Carti = new HashMap<Integer, Carte>();

		String splitWords[];
		while ( input.hasNext()) {
			splitWords = input.nextLine().split("; ");

			Carte carte = new Carte(Integer.parseInt(splitWords[0]), splitWords[1], splitWords[2],
					Integer.parseInt(splitWords[3]));

			Carti.put(Integer.parseInt(splitWords[0]), carte);
		}
		for (int key : Carti.keySet()) {
			System.out.println("key: " + key + " value: " + Carti.get(key));
		}
		
		List<Carte> listaCarti = new LinkedList<Carte>();

		for (int key : Carti.keySet()) {
			listaCarti.add(Carti.get(key));
		}

		System.out.println("\nLista cartilor: ");

		for (Carte c : listaCarti) {
			System.out.println(c.toString());
		}

		System.out.println("\nLista cartilor ordonate dupa titlu: ");

		listaCarti.sort(new comparatorCarte());

		for (Carte c : listaCarti) {
			System.out.println(c.toString());
		}

		input.close();
	}

}

class comparatorCarte implements Comparator<Carte> {

	@Override
	public int compare(Carte c1, Carte c2) {
		return (c1.getTitlu().compareTo(c2.getTitlu()));
	}

}


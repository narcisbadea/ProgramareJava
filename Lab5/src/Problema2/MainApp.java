package Problema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));

		HashMap<Integer, Carte> mapCarti = new HashMap<Integer, Carte>();

		String splitWords[];
		while ( input.hasNext()) {
			splitWords = input.nextLine().split("; ");

			Carte carte = new Carte(Integer.parseInt(splitWords[0]), splitWords[1], splitWords[2],
					Integer.parseInt(splitWords[3]));

			mapCarti.put(Integer.parseInt(splitWords[0]), carte);
		}
		for (int key : mapCarti.keySet()) {
			System.out.println("key: " + key + " value: " + mapCarti.get(key));
		}
		
		List<Carte> listCarti = new LinkedList<Carte>();

		for (int key : mapCarti.keySet()) {
			listCarti.add(mapCarti.get(key));
		}

		System.out.println("\nLista cartilor: ");

		for (Carte c : listCarti) {
			System.out.println(c.toString());
		}

		System.out.println("\nLista cartilor ordonate dupa titlu: ");

		listCarti.sort(new compCarti());

		for (Carte c : listCarti) {
			System.out.println(c.toString());
		}

		input.close();
	}

}

package javaCurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javaCurs.entity.Carte;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("in.txt"));
		Map<Integer, Carte> map = new HashMap<Integer, Carte>();
		String linie;
		String titlu = null, autor = null;
		int cheie, an = 0;
		Carte carte = new Carte(titlu, autor, an);
		while (scanner.hasNext()) {
			linie = scanner.nextLine();
			String[] delimitator = linie.split("; ");
			cheie = Integer.parseInt(delimitator[0]);
			titlu = delimitator[1];
			autor = delimitator[2];
			an = Integer.parseInt(delimitator[3]);
			carte = new Carte(titlu, autor, an);
			map.put(cheie, carte);
		}
		System.out.println("----------AFISARE HASHMAP----------");
		for (Integer cheie2 : map.keySet()) {
				System.out.println("Cheia: " + cheie2 + ", " + map.get(cheie2).toString());
		}

		List<Carte> list = new ArrayList<Carte>();
		for (Carte carte2 : map.values())
			list.add(carte2);
		System.out.println("\n----------AFISARE LISTA----------");
		System.out.println(list);
		System.out.println("\n----------LISTA SORTATA----------");
		Collections.sort(list, new comparaTitlu());
		System.out.println(list);
	}

}

class comparaTitlu implements Comparator<Carte> {

	@Override
	public int compare(Carte o1, Carte o2) {
		return (o1.getTitluCarte().compareTo(o2.getTitluCarte()));
	}

}

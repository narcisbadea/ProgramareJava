package Problema4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) throws IOException {
		boolean loop = true;
		Melodie[] melodii = new Melodie[20];
		int nrMelodii = 0;
		while (loop) {
			System.out.println("\n1. Incarca informatii despre melodii.");
			System.out.println("2. Afiseaza informatii melodii.");
			System.out.println("3. Afiseaza clasamentul melodiilor dupa vizualizari in ordine descrescatoare");
			System.out.println("4. Afiseaza toate melodiile unui artist.");
			System.out.println("0. IESIRE");
			int opt;
			BufferedReader readOpt = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Optiune aleasa: ");
			opt = Integer.parseInt(readOpt.readLine());
			switch (opt) {
			case 0: {
				loop = false;
				break;
			}
			case 1: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
				String linie;
				String[] mel = new String[4];
				while ((linie = reader.readLine()) != null) {
					mel = linie.split(";");
					melodii[nrMelodii] = new Melodie(mel[0], mel[1], Integer.parseInt(mel[2]),
							Integer.parseInt(mel[3]));
					nrMelodii++;
				}
				reader.close();
				System.out.println("Melodiile au fost incarcate cu succes!");
				System.out.println();
				break;
			}
			case 2: {
				for (int i = 0; i < nrMelodii; i++) {
					System.out.println(melodii[i].toString());
				}
				break;

			}
			case 3: {
				Arrays.sort(melodii,0,nrMelodii, Melodie::compareViz);
				for (int i = 0; i < nrMelodii; i++) {
					System.out.println(melodii[i].toString());
				}
				break;
			}
			case 4: {
				BufferedReader readArtist = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Nume artist: ");
				String numeArtist = readArtist.readLine();
				for (int i = 0; i < nrMelodii; i++) {
					if (melodii[i].getNume_artist().equals(numeArtist))
						System.out.println(melodii[i].toString());
				}
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}

		}
	}

}


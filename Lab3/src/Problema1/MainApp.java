package Problema1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("cantec_in.txt")));
		PrintStream write = new PrintStream("cantec_out.txt");
		Vers[] versuri = new Vers[100];
		int nrVersuri = 0;
		String linie;
		for (int i = 0; (linie = reader.readLine()) != null; i++) {
			versuri[i] = new Vers(linie);
			nrVersuri++;
		}
		BufferedReader readTerminatie = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Terminatie vers: ");
		String terminatie = readTerminatie.readLine();
		for (int i = 0; i < nrVersuri; i++) {
			write.printf("%-60s Cuvinte: %-3s Vocale: %-3s", versuri[i].toString(), versuri[i].nrCuvinte(),versuri[i].vocale());
			if (versuri[i].getVersul().endsWith(terminatie)) {
				write.printf(" *\n");
			} else {
				write.printf("\n");
			}
		}
		reader.close();
		write.close();
		System.out.println("Fisierul a fost scris cu succes!");

	}

}

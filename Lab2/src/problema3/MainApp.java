package problema3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		PrintStream write = new PrintStream("out.txt");
		String linie;
		Produs[] produse = new Produs[5];
		int nrProduse = 0;
		for (int i = 0; (linie = reader.readLine()) != null; i++) {
			produse[i] = new Produs(linie);
			nrProduse++;
		}
		Produs maxPret = new Produs("a;" + Double.MIN_VALUE + ";1");
		Produs minPret = new Produs("a;" + Double.MAX_VALUE + ";1");
		System.out.printf("+----------------+----------------+----------------+%n");
		System.out.printf("|%-15s |%-15s |%-15s |\n", "Denumire", "Pret", "Cantitate");
		System.out.printf("+----------------+----------------+----------------+%n");
		for (int i = 0; i < nrProduse; i++) {
			System.out.printf("|%-15s |%-15s |%-15s |\n", produse[i].getDenumire(), produse[i].getPret(),
					produse[i].getCantitate());
			if (produse[i].getPret() > maxPret.getPret()) {
				maxPret = produse[i];
			}
			if (produse[i].getPret() < minPret.getPret()) {
				minPret = produse[i];
			}
		}
		System.out.printf("+----------------+----------------+----------------+%n");
		write.println("Produsul cu cel mai mare pret este: " + maxPret.toString());
		write.println("Produsul cu cel mai mic pret este: " + minPret.toString());
		reader.close();
		write.close();

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Cantitate: ");
		int cantitate = Integer.parseInt(reader2.readLine());
		System.out.println("Produsele ce au cantitatea sub " + cantitate + " buc sunt: ");
		for (int i = 0; i < nrProduse; i++) {
			if (produse[i].getCantitate() < cantitate) {
				System.out.println(produse[i].getDenumire());
			}
		}

	}
}

package problema1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import problema1.Copiator.FormatCopiere;
import problema1.SistemCalcul.OS;
import problema1.Imprimanta.Mod_Scriere;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("echipamente.txt")));
		Echipament[] echipamente = new Echipament[100];
		int nrEchipamente = 0, id;
		String linie;
		while ((linie = flux_in.readLine()) != null) {
			String[] parts = linie.split(";");
			if (linie.contains("imprimanta")) {
				echipamente[nrEchipamente] = new Imprimanta(parts[0], Integer.parseInt(parts[1]),
						Float.parseFloat(parts[2]), parts[3], Status.valueOf(parts[4]), Integer.parseInt(parts[6]),
						parts[7], Integer.parseInt(parts[8]), Mod_Scriere.valueOf(parts[9]));
				;
				nrEchipamente++;
			}
			if (linie.contains("copiator")) {
				echipamente[nrEchipamente] = new Copiator(parts[0], Integer.parseInt(parts[1]),
						Float.parseFloat(parts[2]), parts[3], Status.valueOf(parts[4]), Integer.parseInt(parts[6]),
						Integer.parseInt(parts[7]), FormatCopiere.valueOf(parts[8]));
				nrEchipamente++;
			}
			if (linie.contains("sistem de calcul")) {
				echipamente[nrEchipamente] = new SistemCalcul(parts[0], Integer.parseInt(parts[1]),
						Float.parseFloat(parts[2]), parts[3], Status.valueOf(parts[4]), parts[6],
						Float.parseFloat(parts[7]), Integer.parseInt(parts[8]), OS.valueOf(parts[9]));
				nrEchipamente++;
			}
		}
		flux_in.close();
		int opt = -1;
		BufferedReader readOpt = new BufferedReader(new InputStreamReader(System.in));
		while (opt != 0) {
			System.out.println("\n\n1.  Afişarea imprimantelor");
			System.out.println("2.  Afişarea copiatoarelor");
			System.out.println("3.  Afişarea sistemelor de calcul");
			System.out.println("4.  Afişarea echipamentelor vândute");
			System.out.println("5.  Scriere fisier serializat");
			System.out.println("6.  Citire fisier serializat");
			System.out.println("7.  Modificare stare echipament");
			System.out.println("8.  Setare mod scriere imprimanta");
			System.out.println("9.  Instalare sistem de operare pe sistem de calcul");
			System.out.println("10. Setarea unui format de copiere pentru copiatoare");
			System.out.println("0. EXIT");
			System.out.print("Optiune aleasa: ");
			opt = Integer.parseInt(readOpt.readLine());
			switch (opt) {
			case 1:
				System.out.println("-----IMPRIMANTE------");
				for (int i = 0; i < nrEchipamente; i++) {
					String clasa = echipamente[i].getClass().getName();
					if (clasa == "problema1.Imprimanta") {
						System.out.println(echipamente[i]);
					}
				}
				break;
			case 2:
				System.out.println("\n\n-----COPIATOARE------");
				for (int i = 0; i < nrEchipamente; i++) {
					String clasa = echipamente[i].getClass().getName();
					if (clasa == "problema1.Copiator") {
						System.out.println(echipamente[i]);
					}
				}
				break;
			case 3:
				System.out.println("\n\n-----SISTEME DE CALCUL------");
				for (int i = 0; i < nrEchipamente; i++) {
					String clasa = echipamente[i].getClass().getName();
					if (clasa == "problema1.SistemCalcul") {
						System.out.println(echipamente[i]);
					}
				}
				break;
			case 4:
				System.out.println("\n\n-----ECHIPAMENTE VANDUTE------");
				for (int i = 0; i < nrEchipamente; i++) {
					if (echipamente[i].getStatus() == Status.valueOf("vandut"))
						System.out.println(echipamente[i]);
				}
				break;
			case 5:
				System.out.println("\n\n-----SCRIERE FISIER SERIALIZAT------");
				scrie(echipamente, "echi.bin");
				System.out.println("SCRIEREA A FosT REALIZATA CU SUCCES!");
				break;
			case 6:
				System.out.println("\n\n-----CITIRE FISIER SERIALIZAT------");
				Echipament[] echi = (Echipament[]) citeste("echi.bin");
				for (Echipament e : echi)
					if (e != null)
						System.out.println(e);
				break;
			case 7:
				for (int i = 0; i < nrEchipamente; i++) {
					System.out.println("[ID= " + i + " ] " + echipamente[i].toString());
				}
				System.out.println("Selectati id-ul echipamentului: ");
				id = Integer.parseInt(readOpt.readLine());
				System.out.println("Selectati noul status([1] vandut, [2] achizitionat, [3] expus) :");
				int status = Integer.parseInt(readOpt.readLine());
				switch (status) {
				case 1:
					echipamente[id].setStatus(Status.valueOf("vandut"));
					break;
				case 2:
					echipamente[id].setStatus(Status.valueOf("achizitionat"));
					break;
				case 3:
					echipamente[id].setStatus(Status.valueOf("expus"));
					break;
				}
				break;
			case 8:
				for (int i = 0; i < nrEchipamente; i++) {
					String clasa = echipamente[i].getClass().getName();
					if (clasa == "problema1.Imprimanta") {
						System.out.println("[ID= " + i + "]" + echipamente[i]);
					}
				}
				System.out.println("Selectati id-ul imprimantei: ");
				id = Integer.parseInt(readOpt.readLine());
				System.out.println("Selectati noul format([1] tiparireColor, [2] tiparireAlbNegru) :");
				int format = Integer.parseInt(readOpt.readLine());
				Imprimanta a = (Imprimanta) echipamente[id];
				switch (format) {
				case 1:
					a.setMod_scriere(Mod_Scriere.valueOf("tiparireColor"));
					break;
				case 2:
					a.setMod_scriere(Mod_Scriere.valueOf("tiparireAlbNegru"));
					break;
				}
				echipamente[id] = a;
				break;
			case 9:
				for (int i = 0; i < nrEchipamente; i++) {
					String clasa = echipamente[i].getClass().getName();
					if (clasa == "problema1.SistemCalcul") {
						System.out.println("[ID= " + i + "]" + echipamente[i]);
					}
				}
				System.out.println("Selectati id-ul imprimantei: ");
				id = Integer.parseInt(readOpt.readLine());
				System.out.println("Selectati noul sistem de operare([1] windows, [2] linux) :");
				int os = Integer.parseInt(readOpt.readLine());
				SistemCalcul s = (SistemCalcul) echipamente[id];
				switch (os) {
				case 1:
					s.setOS(OS.valueOf("windows"));
					break;
				case 2:
					s.setOS(OS.valueOf("linux"));
					break;
				}
				echipamente[id] = s;
				break;
			case 10:
				for (int i = 0; i < nrEchipamente; i++) {
					String clasa = echipamente[i].getClass().getName();
					if (clasa == "problema1.Copiator") {
						System.out.println("[ID= " + i + "]" + echipamente[i]);
					}
				}
				System.out.println("Selectati id-ul copiatorului: ");
				id = Integer.parseInt(readOpt.readLine());
				System.out.println("Selectati noul format de copiere([1] A4, [2] A3) :");
				int copiere = Integer.parseInt(readOpt.readLine());
				Copiator c = (Copiator) echipamente[id];
				switch (copiere) {
				case 1:
					c.setFormatCopiere(FormatCopiere.valueOf("A4"));
					break;
				case 2:
					c.setFormatCopiere(FormatCopiere.valueOf("A3"));
					break;
				}
				echipamente[id] = c;
				break;
			}

		}

	}

	static void scrie(Object o, String fis) {
		try {
			FileOutputStream f = new FileOutputStream(fis);
			ObjectOutputStream oos = new ObjectOutputStream(f);
			oos.writeObject(o);
			oos.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Object citeste(String fis) {
		try {
			FileInputStream f = new FileInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(f);
			Object o = ois.readObject();
			ois.close();
			f.close();
			return o;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}

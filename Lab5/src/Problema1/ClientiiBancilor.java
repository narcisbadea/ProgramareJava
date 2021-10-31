package Problema1;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ClientiiBancilor {
	private Vector<Banca> banci = new Vector<Banca>();
	Scanner input = new Scanner(System.in);

	public ClientiiBancilor() {
	}

	public void meniu() throws IOException {
		int opt = -1;

		while (opt != 0) {
			System.out.println("\n1. Adaugare banca");
			System.out.println("2. Adaugare client");
			System.out.println("3. Adaugare cont");
			System.out.println("4. Afisarea tuturor clientilor");
			System.out.println("5. Depunere in cont");
			System.out.println("6. Extragere din cont");
			System.out.println("7. Tranfer intre conturi");
			System.out.println("0. Iesire");
			System.out.print("Optiunea selectata: ");
			opt = input.nextInt();
			input.nextLine();
			switch (opt) {
			case 1:
				adaugareBanca();
				break;
			case 2:
				adaugareClient();
				break;
			case 3:
				adaugareCont();
				break;
			case 4:
				afisareDate();
				break;
			case 5:
				depunereInCOnt();
				break;
			case 6:
				extragereCont();
				break;
			case 7:
				transfer();
				break;
			default:
				System.out.println("Introduceti o optiune valida!");
				break;
			case 0:
				break;
			}
		}
		input.close();
	}

	public void adaugareCont() throws IOException {
		Banca b = selecteazaBanca();
		if (b != null) {
			Client c = selecteazaClient(b);
			if (c != null) {
				if (c != null) {
					ContBancar cb;
					String moneda = "";
					System.out.println("\t0. RON\t1. EURO");
					System.out.print("Moneda contului: ");
					int i = input.nextInt();
					boolean optiuneValida = true;
					do {
						switch (i) {
						case 0:
							moneda = "RON";
							break;
						case 1:
							moneda = "EURO";
							break;
						default:
							System.out.println("Optiune invalida!");
							optiuneValida = false;
							break;
						}
					} while (!optiuneValida);
					cb = new ContBancar(moneda);
					c.addCont(cb);
				}
			} else {
				System.out.println("Client invalid!");
			}
		} else {
			System.out.println("Banca invalida!");
		}
	}

	public Banca selecteazaBanca() throws IOException {
		System.out.println("Bancile aflate in gestiune: ");
		afisareBanci();
		System.out.print("Selectati banca: ");
		Banca b;
		int index = input.nextInt();
		if (index < banci.size()) {
			b = banci.get(index);

		} else {
			System.out.println("Nu ati selectast o banca valida!");
			b = null;
		}
		return b;
	}

	public Client selecteazaClient(Banca b) throws IOException {
		if (b.clienti.size() != 0) {

			System.out.println("Clientii aflati in gestiunea bancii " + b.getDenumire_banca());
			afisareClienti(b);
			System.out.print("Selectati clientul: ");
			Client c;
			int index = input.nextInt();
			if (index < b.getClienti().size()) {
				c = b.getClient(index);
			} else {
				c = null;
				System.out.println("Clientul selectat nu exista!");
			}
			return c;

		} else {

			System.out.println("Banca nu are clienti in gestiune!");
			return null;

		}
	}

	public void adaugareBanca() throws IOException {
		System.out.print("Numele bancii: ");
		Banca b = new Banca(input.nextLine());
		banci.add(b);

	}

	public void adaugareClient() throws IOException {

		String nume, adresa;

		System.out.print("Numele clientului: ");
		nume = input.nextLine();

		System.out.print("Adresa clientului: ");
		adresa = input.nextLine();

		Client c = new Client(nume, adresa);
		afisareBanci();

		System.out.print("Banca aleasa: ");
		int index = input.nextInt();
		if (index < banci.size()) {
			banci.elementAt(index).addClient(c);
		} else {
			System.out.println("Index invalid!");
		}
	}

	public void afisareBanci() {
		int i = 0;
		for (Banca b : banci) {
			System.out.println(i + ". " + b.getDenumire_banca());
			i++;
		}
	}

	public void afisareClienti(Banca bnc) {

		int i = 0;
		for (Client a : bnc.clienti) {
			System.out.println(i + ". " + a.getNume());
			i++;
		}

	}

	public void afisareDate() {
		int i = 0;
		for (Banca b : banci) {
			System.out.println(b.getDenumire_banca());
			i = 0;
			for (Client c : b.clienti) {
				System.out.print("\t" + i + ". Nume: " + c.getNume() + "\n\t   Adresa: " + c.getAdresa());
				System.out.print("\n\t   Conturi bancare:\n");
				for (ContBancar cntB : c.getConturi()) {
					System.out.println("\n\t   \t" + cntB.toString());
				}
				System.out.println();
				i++;
			}
		}
	}

	public ContBancar selecteazaCont(Client c) {
		ContBancar cb = null;
		int i = 0;
		for (ContBancar cntB : c.getConturi()) {
			System.out.println("\t" + i + ". " + cntB.toString());
			i++;
		}
		System.out.print("\tSelectati contul: ");
		int index = input.nextInt();
		i = 0;
		for (ContBancar cntB : c.getConturi()) {
			if (index == i) {
				cb = cntB;
				break;
			}
			i++;

		}
		return cb;
	}

	public void depunereInCOnt() throws IOException {
		Banca b = selecteazaBanca();
		if (b != null) {
			Client c = selecteazaClient(b);
			if (c != null) {
				ContBancar cntB = selecteazaCont(c);
				if (cntB != null) {
					System.out.print("\tSuma pentru depunere: ");
					float suma = input.nextFloat();
					cntB.depunere(suma);
				} else {
					System.out.println("Index invalid!");
				}
			}
		} else {
			System.out.println("Index invalid!");
		}
	}

	public void extragereCont() throws IOException {
		Banca b = selecteazaBanca();
		if (b != null) {
			Client c = selecteazaClient(b);
			if (c != null) {
				ContBancar cntB = selecteazaCont(c);
				if (cntB != null) {
					System.out.print("\tSuma pentru extragere: ");
					float suma = input.nextFloat();
					if (suma <= cntB.getSuma()) {
						cntB.extragere(suma);
					} else {
						System.out.println("Clientul are soldul prea mic!");
					}
				}
			}
		} else {
			System.out.println("Index invalid!");
		}

	}

	public void transfer() throws IOException {
		System.out.println("Primul client(de la care se transfera): ");
		Client c = selecteazaClient(selecteazaBanca());
		if (c != null) {
			ContBancar cntB = selecteazaCont(c);
			if (cntB != null) {
				System.out.println("Al doilea client(la care se transfera): ");
				Client c2 = selecteazaClient(selecteazaBanca());
				if (c2 != null) {
					ContBancar cntB2 = selecteazaCont(c2);
					if (cntB2 != null) {
						System.out.print("\tSuma pentru transfer: ");
						float suma = input.nextFloat();
						if (suma <= cntB.getSuma()) {
							cntB.extragere(suma);
							cntB2.depunere(suma);
						} else {
							System.out.println("Clientul de la care se transfera are soldul prea mic!");
						}
					}
				}
			}

		}
	}
}
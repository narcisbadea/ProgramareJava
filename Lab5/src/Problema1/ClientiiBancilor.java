package Problema1;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ClientiiBancilor {
	private Vector<Banca> banci;
	Scanner input;

	ClientiiBancilor() {
		input = new Scanner(System.in);		
		banci = new Vector<Banca>();
	}

	public void menu() throws IOException {
		int o;
	
		do {
			System.out.println();
			System.out.println("1. Adaugare banca");
			System.out.println("2. Adaugare client");
			System.out.println("0. Iesire");

			o = input.nextInt();
			input.nextLine();

			switch (o) {
			case 1:
				adaugareBanca();
				break;
			case 2:
				adaugareClient();
			
			default:
				System.out.println("Introduceti o optiune valida!");
				break;
			case 0:
				break;
			}

		} while (o != 0);

		input.close();
	}
	public Banca adaugareBanca() throws IOException
	{
		Banca b;
		
		System.out.print("Numele bancii: ");
		
		while (!input.hasNext());
		
		b = new Banca(input.nextLine());
		banci.add(b);
		
		return b;
	}
	public void adaugareClient() throws IOException
	{
		Client c;

		String nume, adresa;
		int aux;
		
		System.out.print("Numele clientului: ");
		nume = input.nextLine();
		
		System.out.print("Adresa clientului: ");
		adresa = input.nextLine();
		int i=0;
		c=new Client(nume, adresa);
		for(Banca b:banci) {
			System.out.println(i+". "+b.getDenumire_banca());
		}
		System.out.print("Banca ale1asa: ");
		banci.elementAt(input.nextInt()).addClient(c);
	}
}
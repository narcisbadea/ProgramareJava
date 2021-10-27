package Problema2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("INSERARE IN STRING");
		System.out.print("Stringul: ");
		StringBuilder s = new StringBuilder(reader.readLine());
		System.out.print("Pozitia: ");
		int pozitie = Integer.parseInt(reader.readLine());
		System.out.print("String de inserat: ");
		s.insert(pozitie, reader.readLine());
		System.out.println(s.toString());
		
		System.out.println("\n\n\nSTERGERE DIN STRING");
		System.out.print("Stringul: ");
		StringBuilder s2 = new StringBuilder(reader.readLine());
		System.out.print("Pozitia: ");
		pozitie = Integer.parseInt(reader.readLine());
		System.out.print("Nr caractere de sters : ");
		int pozitie2 = Integer.parseInt(reader.readLine());
		s2.delete(pozitie, pozitie + pozitie2);
		System.out.println(s2.toString());

	}

}

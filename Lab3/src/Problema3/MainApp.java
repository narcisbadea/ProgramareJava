package Problema3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("judete_in.txt")));
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		String linie;
		String[] judete = new String[41];
		for (int i = 0; (linie = reader.readLine()) != null; i++) {
			judete[i] = linie;
		}
		Arrays.sort(judete);
		System.out.print("Lista de judete sortata: ");
		for (int i = 0; i < 41; i++) {
			System.out.print("["+i + "] " + judete[i] + ", ");
		}
		System.out.println();
		System.out.print("Judetul cautat: ");
		
		String judetCautat = key.readLine();
		int poz = Arrays.binarySearch(judete, judetCautat);
		if(poz>-1)
			System.out.print("Judetul cautat se afla pe pozitia: " + poz);
		else
			System.out.println("Judetul cautat nu exista");
		reader.close();
	}

}

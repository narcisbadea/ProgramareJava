package Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		float lungime, latime;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Lungime= ");
		lungime = Float.parseFloat(reader.readLine());

		System.out.print("Latime= ");
		latime = Float.parseFloat(reader.readLine());

		System.out.println("Perimetrul= " + 2 * (lungime + latime));
		System.out.println("Aria= " + (lungime * latime));
		
		reader.close();
	}

}

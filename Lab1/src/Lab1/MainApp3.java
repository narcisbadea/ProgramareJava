package Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("N= ");
		int n = Integer.parseInt(reader.readLine());
		int nrDivizori = 0;
		System.out.print("Divizorii sunt: ");
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
				nrDivizori++;
			}
		}

		if (nrDivizori == 2) {
			System.out.println("\nNumar prim");
		}
		reader.close();
	}

}

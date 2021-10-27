package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainApp2 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		String linie;
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		float count = 0;
		
		while ((linie = reader.readLine()) != null) {
			int numar = Integer.parseInt(linie);
			sum += numar;
			if (numar < min)
				min = numar;
			if (numar > max)
				max = numar;
			
			count++;
		}
		
		PrintStream write = new PrintStream("out.txt");

		System.out.println("Suma= " + sum);
		write.println("Suma= " + sum);
		System.out.println("Media= " + (sum / count));
		write.println("Media= " + (sum / count));
		System.out.println("Maxim= " + max);
		write.println("Maxim= " + max);
		System.out.println("Minim= " + min);
		write.print("Minim= " + min);
		
		reader.close();
		write.close();
	}

}

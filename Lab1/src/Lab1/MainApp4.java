package Lab1;

import java.util.Random;

public class MainApp4 {

	public static void main(String[] args) {
		Random rnd = new Random();
		int firstNumber = rnd.nextInt(30);
		int secondNumber = rnd.nextInt(30);
		System.out.println("Primul numar: " + firstNumber + "\nAl doilea numar: " + secondNumber);
		int n = firstNumber, m = secondNumber;

		while (n != m) {
			if (n > m) {
				n -= m;
			} else {
				m -= n;
			}
		}
		System.out.println("cmmdc = " + n);
	}
}

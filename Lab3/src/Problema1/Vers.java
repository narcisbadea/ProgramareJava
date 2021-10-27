package Problema1;

import java.util.Random;

public class Vers {
	private String versul;
	private String[] cuvinte;

	public Vers(String linie) {
		this.cuvinte = linie.split(" ");
		this.versul = linie;
	}

	public String getVersul() {
		return this.versul;
	}

	public int nrCuvinte() {
		return cuvinte.length;
	}

	public int vocale() {
		int count = 0;
		String v = versul.toLowerCase();
		for (int i = 0; i < versul.length(); i++) {
			if (v.charAt(i) =='a' || v.charAt(i) == 'e' || v.charAt(i) == 'i' || v.charAt(i) == 'o'
					|| v.charAt(i) == 'u') {
				count++;
				
			}
		}
		return count;
	}

	public String toString() {
		String result = this.versul;
		if (this.majuscule())
			result = result.toUpperCase();
		return result;
	}

	public boolean majuscule() {
		Random rnd = new Random();
		double val = rnd.nextDouble();
		if (val < 0.1)
			return true;

		return false;
	}
	
}

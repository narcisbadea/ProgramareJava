package Problema1;

import java.util.Random;

public class Depunere extends Thread {
	ContBancar cb;
	Random random;

	public Depunere(String nume, ContBancar cb) {
		super(nume);
		this.cb = cb;
		random = new Random();
	}

	public void run() {
		while (true) {
			cb.Depunere(random.nextInt(500));
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {

			}
		}
	}

}

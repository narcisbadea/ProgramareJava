package Problema1;

import java.util.Random;

public class Extragere extends Thread {
	ContBancar cb;
	Random random;

	public Extragere(String nume, ContBancar cb) {
		super(nume);
		this.cb = cb;
		random = new Random();
	}

	public void run() {
		while (true) {
			cb.Extrage(random.nextInt(1000));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
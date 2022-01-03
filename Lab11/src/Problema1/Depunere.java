package Problema1;

import java.util.Random;

public class Depunere extends Thread {
	ContBancar cb;
	Random random = new Random();

	public Depunere(String nume, ContBancar cb) {
		super(nume);
		this.cb = cb;
	}

	public void run() {
		while (true) {
			cb.Depunere(random.nextInt(1000));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}

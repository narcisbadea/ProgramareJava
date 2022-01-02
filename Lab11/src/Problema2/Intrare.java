package Problema2;

import java.util.Random;

public class Intrare extends Thread {
	private Parcare p;
	private Random random = new Random();

	public Intrare(String nume, Parcare p) {
		super(nume);
		this.p = p;
	}

	public void run() {
		while (true) {
			p.Intra(getName());
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package Problema2;

import java.util.Random;

public class Iesire extends Thread {
	private Parcare p;
	private Random random = new Random();

	public Iesire(String nume, Parcare p) {
		super(nume);
		this.p = p;
	}

	public void run() {
		while (true) {
			p.Iasa();
			try {
				Thread.sleep(random.nextInt(1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
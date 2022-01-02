package Problema2;

import java.util.Random;

public class Intrare extends Thread {
	private Parcare p;
	private Random random;

	public Intrare(String nume, Parcare p) {
		super(nume);
		this.random = new Random();
		this.p = p;
	}

	public void run() {
		while (true) {
			p.Ocupa(getName());
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package Problema2;

import java.util.Random;

public class Intrare extends Thread {
	private Parcare parcare;
	private Random random = new Random();

	public Intrare(String nume, Parcare parcare) {
		super(nume);
		this.parcare = parcare;
	}

	public void run() {
		while (true) {
			parcare.Intra(getName());
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

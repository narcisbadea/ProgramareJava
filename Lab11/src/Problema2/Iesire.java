package Problema2;

import java.util.Random;

public class Iesire extends Thread {
	private Parcare parcare;
	private Random random = new Random();

	public Iesire(String nume, Parcare parcare) {
		super(nume);
		this.parcare = parcare;
	}

	public void run() {
		while (true) {
			parcare.Iasa();
			try {
				Thread.sleep(random.nextInt(1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
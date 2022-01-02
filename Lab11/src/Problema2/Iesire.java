package Problema2;

import java.util.Random;

public class Iesire extends Thread {
	private Parcare p;
	private Random random;

	public Iesire(String nume, Parcare p) {
		super(nume);
		this.random = new Random();
		this.p = p;
	}

	public void run() {
		while (true) {
			p.Pleaca();
			try {
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
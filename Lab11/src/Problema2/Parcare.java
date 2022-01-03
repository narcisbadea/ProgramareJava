package Problema2;

public class Parcare {

	private int locuriOcupate = 0;
	private boolean disponibil = true;
	private final int nrMaximLocuri = 10;

	synchronized public void Intra(String nume) {
		while (!disponibil || locuriOcupate == nrMaximLocuri) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		disponibil = false;
		locuriOcupate++;
		System.out
				.println("+ A intrat o masina pe intrarea " + nume + ". In parcare sunt " + locuriOcupate + " masini.");
		disponibil = true;

		notify();
	}

	synchronized public void Iasa() {
		while (!disponibil || locuriOcupate == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		disponibil = false;
		locuriOcupate--;
		System.out.println("- A iesit o masina. In parcare sunt " + locuriOcupate + " masini.");
		disponibil = true;

		notify();
	}

}

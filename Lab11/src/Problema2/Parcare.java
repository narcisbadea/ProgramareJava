package Problema2;

public class Parcare {

	private int locauriOcupate = 0;
	private boolean disponibil = true;
	private final int nrMaximLocuri = 10;

	public Parcare() {
	}

	synchronized public void Intra(String nume) {
		while (!disponibil || locauriOcupate == nrMaximLocuri) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		disponibil = false;

		locauriOcupate++;
		System.out.println(
				"+ A intrat o masina pe intrarea " + nume + ". In parcare sunt " + locauriOcupate + " masini.");
		disponibil = true;

		notify();
	}

	synchronized public void Iasa() {
		while (!disponibil || locauriOcupate == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		disponibil = false;

		locauriOcupate--;
		System.out.println("- A iesit o masina. In parcare sunt " + locauriOcupate + " masini.");

		disponibil = true;

		notify();
	}

}

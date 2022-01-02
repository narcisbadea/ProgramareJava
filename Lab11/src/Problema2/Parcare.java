package Problema2;

public class Parcare {

	private final int MAX_LOCURI = 10;
	private int locuri_ocupate;
	private boolean mutex;

	public Parcare() {
		this.locuri_ocupate = 0;
		mutex = true;
	}

	synchronized public void Ocupa(String nume) {
		while (!mutex || locuri_ocupate == MAX_LOCURI) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		mutex = false;

		locuri_ocupate++;
		System.out
				.println("A intrat o masina pe intrarea " + nume + ". In parcare sunt " + locuri_ocupate + " masini.");
		mutex = true;

		notify();
	}

	synchronized public void Pleaca() {
		while (!mutex || locuri_ocupate == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		mutex = false;

		locuri_ocupate--;
		System.out.println("A iesit o masina. In parcare sunt " + locuri_ocupate + " masini.");

		mutex = true;

		notify();
	}

}

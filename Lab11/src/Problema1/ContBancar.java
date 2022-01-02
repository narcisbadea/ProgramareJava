package Problema1;

public class ContBancar {

	private int suma;
	private boolean disponibil;

	public ContBancar() {
		disponibil = true;
		suma = 0;
	}

	synchronized void Depunere(int suma) {
		while (!disponibil) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		disponibil = false;

		this.suma = this.suma + suma;
		System.out.println("+ A fost depusa suma de " + suma + "RON, in cont sunt: " + this.suma + "RON");

		disponibil = true;

		notify();
	}

	synchronized void Extrage(int suma) {
		while (!disponibil || this.suma < suma) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		disponibil = false;

		this.suma = this.suma - suma;
		System.out.println("- A fost extrasa suma de " + suma + "RON si in cont au ramas: " + this.suma + "RON");

		disponibil = true;

		notify();
	}

}

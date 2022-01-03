package Problema1;

public class MainApp {

	public static void main(String[] args) {

		ContBancar cb = new ContBancar();
		Depunere depune = new Depunere("depunere", cb);
		Extragere extrage = new Extragere("extragere", cb);

		depune.start();
		extrage.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

}

package Problema1;

public class MainApp {

	public static void main(String[] args) {
		
		ContBancar cont = new ContBancar();
	
		Depunere depune = new Depunere("depunere", cont);
		Extragere extrage = new Extragere("extragere", cont);
		
		depune.start();
		extrage.start();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}

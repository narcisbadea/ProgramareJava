package Problema2;

public class MainApp {

	public static void main(String[] args) {
		Parcare parcare = new Parcare();

		Intrare intrare1 = new Intrare("1", parcare);
		Intrare intrare2 = new Intrare("2", parcare);
		Intrare intrare3 = new Intrare("3", parcare);
		Iesire iesire1 = new Iesire("Iesire", parcare);

		intrare1.start();
		intrare2.start();
		intrare3.start();
		iesire1.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(0);

	}

}

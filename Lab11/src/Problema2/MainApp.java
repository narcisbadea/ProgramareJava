package Problema2;

public class MainApp {

	public static void main(String[] args) {
		Parcare parcare = new Parcare();
		Intrare i1 = new Intrare("1", parcare);
		Intrare i2 = new Intrare("2", parcare);
		Intrare i3 = new Intrare("3", parcare);
		Iesire iesire = new Iesire("Iesire", parcare);

		i1.start();
		i2.start();
		i3.start();
		iesire.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(0);

	}

}

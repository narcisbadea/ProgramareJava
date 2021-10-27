package problema3;

public class Produs {
	private String denumire;
	private double pret;
	private int cantitate;

	public Produs(String denumire, double pret, int cantitate) {
		this.denumire = denumire;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public Produs(String linieFisier) {
		String[] v = linieFisier.split(";");
		this.denumire = v[0];
		this.pret = Double.parseDouble(v[1]);
		this.cantitate = Integer.parseInt(v[2]);
	}

	public String toString() {
		return this.denumire + " " + this.pret + " " + this.cantitate;
	}

	public double getPret() {
		return this.pret;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public int getCantitate() {
		return this.cantitate;
	}

}

package problema1;

public class Imprimanta extends Echipament {
	private int ppm;
	private String rezolutie;
	private int p_car;
	private Mod_Scriere mod_scriere;
	public Imprimanta(String denumire, int nr_inv, float pret, String zona_mag,
			Status status, int ppm, String rezolutie, int p_car,
			Mod_Scriere mod_scriere) {
		super(denumire, nr_inv, pret, zona_mag, status);
		this.ppm = ppm;
		this.rezolutie = rezolutie;
		this.p_car = p_car;
		this.mod_scriere = mod_scriere;
	}
	@Override
	public String toString() {
		return "Imprimanta [ " + super.toString() + ", ppm= " + ppm + ", rezolutie= " + rezolutie
				+ ", p_car= " + p_car + ", mod_scriere= " + mod_scriere + "]";
	}
	public int getPpm() {
		return ppm;
	}
	public void setPpm(int ppm) {
		this.ppm = ppm;
	}
	public String getRezolutie() {
		return rezolutie;
	}
	public void setRezolutie(String rezolutie) {
		this.rezolutie = rezolutie;
	}
	public int getP_car() {
		return p_car;
	}
	public void setP_car(int p_car) {
		this.p_car = p_car;
	}
	public Mod_Scriere getMod_scriere() {
		return mod_scriere;
	}
	public void setMod_scriere(Mod_Scriere mod_scriere) {
		this.mod_scriere = mod_scriere;
	}
	enum Mod_Scriere
	{
		tiparireColor,
		tiparireAlbNegru,
		Color,
		color
	};
}



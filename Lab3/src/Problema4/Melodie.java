package Problema4;


public class Melodie {
	private String nume_melodie;
	private String nume_artist;
	private int an_lansare;
	private int numar_viz;

	public Melodie(String Nume_melodie, String Nume_Artist, int An_lansare, int Numar_vizualizari_youtube) {
		this.nume_melodie = Nume_melodie;
		this.nume_artist = Nume_Artist;
		this.an_lansare = An_lansare;
		this.numar_viz = Numar_vizualizari_youtube;
	}
	public Melodie() {}
	public String getNume_melodie() {
		return nume_melodie;
	}

	public String getNume_artist() {
		return nume_artist;
	}

	public int getAn_lansare() {
		return an_lansare;
	}

	public int getNumar_viz() {
		return numar_viz;
	}

	public String toString() {
		return nume_melodie + ", " + nume_artist + ", " + an_lansare
				+ ", " + numar_viz;
	}
	public static int compareViz(Melodie a, Melodie b) {
	    return Integer.compare(b.getNumar_viz(), a.getNumar_viz());
	}
	
}

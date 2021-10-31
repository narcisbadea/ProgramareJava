package javaCurs.entity;

public class Carte {
	private String titluCarte;
	private String autor;
	private int anAparitie;

	public Carte(String titluCarte, String autor, int anAparitie) {
		this.titluCarte = titluCarte;
		this.autor = autor;
		this.anAparitie = anAparitie;
	}

	public String getTitluCarte() {
		return titluCarte;
	}

	public void setTitluCarte(String titluCarte) {
		this.titluCarte = titluCarte;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(int anAparitie) {
		this.anAparitie = anAparitie;
	}

	@Override
	public String toString() {
		return "Carte: " + titluCarte + ", autor: " + autor + ", an aparitie: " + anAparitie;
	}

}

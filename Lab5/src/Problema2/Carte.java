package Problema2;

public class Carte {
	private String titlu, autor;
	private int an_aparitie, ID;
	
	Carte(int ID,String titlu, String autor, int an_aparitie)
	{
		this.titlu = titlu;
		this.autor = autor;
		this.an_aparitie = an_aparitie;
		this.ID = ID;
	}
	
	
	
	public String getTitlu() {
		return titlu;
	}



	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public int getAn_aparitie() {
		return an_aparitie;
	}



	public void setAn_aparitie(int an_aparitie) {
		this.an_aparitie = an_aparitie;
	}



	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String toString()
	{
		return titlu + ", " + autor + ", " + an_aparitie;
	}
	
}

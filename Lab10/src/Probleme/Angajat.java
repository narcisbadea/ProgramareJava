package Probleme;

import java.time.LocalDate;

public class Angajat {
	private String nume;
	private String postul;
	private LocalDate dataAngajare;
	private float salariu;

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPostul() {
		return postul;
	}

	public void setPostul(String postul) {
		this.postul = postul;
	}

	public LocalDate getDataAngajare() {
		return dataAngajare;
	}

	public void setDataAngajare(LocalDate dataAngajare) {
		this.dataAngajare = dataAngajare;
	}

	public float getSalariu() {
		return salariu;
	}

	public void setSalariu(float salariu) {
		this.salariu = salariu;
	}

	public Angajat(String nume, String postul, LocalDate dataAngajare, float salariu) {
		this.nume = nume;
		this.postul = postul;
		this.dataAngajare = dataAngajare;
		this.salariu = salariu;
	}

	@Override
	public String toString() {
		return nume + ", " + postul + ", " + dataAngajare + ", " + salariu;
	}

}

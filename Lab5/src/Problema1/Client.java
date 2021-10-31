package Problema1;

import java.util.HashSet;
import java.util.Set;

public class Client {
	private String nume;
	private String adresa;
	private Set<ContBancar> conturi = new HashSet<ContBancar>();
	private int nrCont=0;
	
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public Set<ContBancar> getConturi() {
		return conturi;
	}
	
	public Client(String nume, String adresa) {
		this.nume = nume;
		this.adresa = adresa;
	}
	
	@Override
	public String toString() {
		return "Client [nume=" + nume + ", adresa=" + adresa + ", conturi=" + conturi + "]";
	}
	
	public void addCont(ContBancar cb) {
		cb.setNumarCont(Integer.toString(nrCont++));
		this.conturi.add(cb);
	}
}

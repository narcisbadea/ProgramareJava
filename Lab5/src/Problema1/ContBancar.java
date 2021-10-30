package Problema1;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ContBancar implements Operatiuni{
	private String numarCont;
	private float suma;
	private String moneda;
	private Calendar data_deschiderii;
	private Calendar data_ultimei_operatiuni;
	public String getNumarCont() {
		return numarCont;
	}
	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Calendar getData_deschiderii() {
		return data_deschiderii;
	}
	public void setData_deschiderii(Calendar data_deschiderii) {
		this.data_deschiderii = data_deschiderii;
	}
	public Calendar getData_ultimei_operatiuni() {
		return data_ultimei_operatiuni;
	}
	public void setData_ultimei_operatiuni(Calendar data_ultimei_operatiuni) {
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}
	public ContBancar(String numarCont, float suma, String moneda) {
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.data_deschiderii = Calendar.getInstance();;
	}
	
	public float calculeaza_dobanda() {
		long today = Calendar.getInstance().getTimeInMillis();
		int days = (int)TimeUnit.MILLISECONDS.toDays(Math.abs(today - data_ultimei_operatiuni.getTimeInMillis()));
		
		if (moneda == "EURO")
			return (float) (0.1 * days);
		else if (suma < 500)
				return (float) (0.3 * days);
			else
				return (float) (0.8*days);
	}
	
	
	public float actualizare_suma() {
		float dobanda = calculeaza_dobanda();
		data_ultimei_operatiuni = Calendar.getInstance();
		suma -= dobanda;
		return suma;
	}
	public void depunere(float suma) {
		this.suma = actualizare_suma() + suma;
	}
	public void extragere(float suma) {
		this.suma = actualizare_suma() - suma;
	}
	@Override
	public String toString() {
		return "ContBancar [numarCont=" + numarCont + ", suma=" + suma + ", moneda=" + moneda + ", data_deschiderii="
				+ data_deschiderii + ", data_ultimei_operatiuni=" + data_ultimei_operatiuni + "]";
	}
	
}

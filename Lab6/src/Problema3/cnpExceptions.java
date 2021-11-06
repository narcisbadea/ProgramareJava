package Problema3;

public class cnpExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ex;

	public cnpExceptions(String ex) {
		this.ex = ex;
	}

	public String toString() {
		switch (ex) {
		case "cifre":
			return "CNP-ul poate contine doar cifre!";
		case "size":
			return "CNP-ul trebuie sa aiba 13 cifre!";
		case "cifraSexului":
			return "Cifra sexului nu este valida!";
		case "ziuaNasterii":
			return "Ziua nasterii nu este valida!";
		case "lunaNasterii":
			return "Luna nasterii nu este valida!";
		case "codJudet":
			return "Codul judetului nu este valid!";
		case "cifraContro":
			return "CNP invalid, cifra de control gresita!";
		case "nrOrdine":
			return "Numarul de ordine este invalid!";
		default:
			return null;
		}

	}

}

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
		case "size":
			return "CNP-ul trebuie sa aiba 13 cifre!";
		case "cifraSexului":
			return "Cifra sexului nu este valida!";

		default:
			return null;
		}

	}

}

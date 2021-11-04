package Problem2;

public class divisionByZeroException extends Exception {

	public divisionByZeroException() {
	}

	public String toString() {
		return "Impartirea la zero[0] nu se poate realiza";
	}

	private static final long serialVersionUID = 1L;

}

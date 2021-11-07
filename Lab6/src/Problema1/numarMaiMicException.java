package Problema1;

class numarMaiMicException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nr1;
	private int nr2;

	public numarMaiMicException(int nr1, int nr2) {
		this.nr1 = nr1;
		this.nr2 = nr2;
	}

	public String toString() {
		return "Primul numar [" + nr1 + "] este mai mare decat al doilea [" + nr2 + "]";
	}
}

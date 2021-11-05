package Problema1;

class numarMaiMic extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nr1;
	private int nr2;

	public numarMaiMic(int nr1, int nr2) {// constructor
		this.nr1 = nr1;
		this.nr2 = nr2;
	}

	public String toString() {
		return "Primul numar [" + nr1 + "] este mai mare decat al doilea [" + nr2 + "]";
	}
}

package problema1;

public class Copiator extends Echipament {
	private static final long serialVersionUID = 1L;
	private int ppm;
	private int p_ton;
	private FormatCopiere formatCopiere;

	public Copiator(String denumire, int nr_inv, float pret, String zona_mag, Status status, int ppm, int p_ton,
			FormatCopiere formatCopiere) {
		super(denumire, nr_inv, pret, zona_mag, status);
		this.ppm = ppm;
		this.p_ton = p_ton;
		this.formatCopiere = formatCopiere;
	}

	public int getPpm() {
		return ppm;
	}

	public void setPpm(int ppm) {
		this.ppm = ppm;
	}

	public int getP_ton() {
		return p_ton;
	}

	public void setP_ton(int p_ton) {
		this.p_ton = p_ton;
	}

	public FormatCopiere getFormatCopiere() {
		return formatCopiere;
	}

	public void setFormatCopiere(FormatCopiere formatCopiere) {
		this.formatCopiere = formatCopiere;
	}

	@Override
	public String toString() {
		return "Copiator [" + super.toString() + ", ppm= " + ppm + ", p_ton= " + p_ton + ", formatCopiere= " + formatCopiere
				+ "]";
	}

	enum FormatCopiere {
		setFormatA4, setFormatA3, A4, A3
	};
}

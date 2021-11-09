package problema1;

public class SistemCalcul extends Echipament {
	private static final long serialVersionUID = 1L;
	private String tip_mon;
	private float vit_proc;
	private int c_hdd;
	private OS os;

	public SistemCalcul(String denumire, int nr_inv, float pret, String zona_mag, Status status, String tip_mon,
			float vit_proc, int c_hdd, OS oS) {
		super(denumire, nr_inv, pret, zona_mag, status);
		this.tip_mon = tip_mon;
		this.vit_proc = vit_proc;
		this.c_hdd = c_hdd;
		this.os = oS;
	}

	@Override
	public String toString() {
		return "SistemCalcul [" + super.toString() + ", tip_mon= " + tip_mon + ", vit_proc= " + vit_proc + ", c_hdd= "
				+ c_hdd + ", OS= " + os + "]";
	}

	public String getTip_mon() {
		return tip_mon;
	}

	public void setTip_mon(String tip_mon) {
		this.tip_mon = tip_mon;
	}

	public float getVit_proc() {
		return vit_proc;
	}

	public void setVit_proc(float vit_proc) {
		this.vit_proc = vit_proc;
	}

	public int getC_hdd() {
		return c_hdd;
	}

	public void setC_hdd(int c_hdd) {
		this.c_hdd = c_hdd;
	}

	public OS getOS() {
		return os;
	}

	public void setOS(OS os) {
		this.os = os;
	}

	enum OS {
		instalWin, instalLinux, windows, linux
	};

}

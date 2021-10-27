package problema2;

public class Parabola {
	private double a, b, c;

	public Parabola(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Parabola(Parabola parabola) {
		this.a = parabola.a;
		this.b = parabola.b;
		this.c = parabola.c;
	}

	public String toString() {
		return "f(x) = " + this.a + " x^2 + " + this.b + " x + " + this.c;
	}

	public Punct coordonateVarf() {
		double x = -b / (2 * a);
		double y = (-(b * b) + 4 * a * c) / (4 * a);
		return new Punct(x, y);
	}

	public static Punct mijSegm(Parabola p1, Parabola p2) {
		double x = (p1.coordonateVarf().getX() + p2.coordonateVarf().getX()) / 2;
		double y = (p1.coordonateVarf().getY() + p2.coordonateVarf().getY()) / 2;
		return new Punct(x, y);
	}

}

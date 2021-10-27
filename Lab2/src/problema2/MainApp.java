package problema2;

public class MainApp {

	public static void main(String[] args) {
		Parabola parabola1 = new Parabola(-1, 2, -5);
		System.out.println("Parabola1: " + parabola1.toString());

		Punct varfParaboala = parabola1.coordonateVarf();
		System.out.println("Varf parabola(x,y): (" + varfParaboala.getX() + ", " + varfParaboala.getY() + ")");
		System.out.println();
		
		Parabola parabola2 = new Parabola(2, -1, 6);
		System.out.println("Parabola2: " + parabola2.toString());
		Punct mijloc = Parabola.mijSegm(parabola1, parabola2);
		System.out.println("Mijlocului segmentului de dreptă care uneşte vârfurile(x,y): (" + mijloc.getX() + ", "
				+ mijloc.getY() + ")");
	}

}

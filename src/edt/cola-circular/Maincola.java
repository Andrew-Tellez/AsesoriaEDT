
/**
 * Maincola
 */
public class Maincola {

	public static void main(String[] args) {
		ColaCircular foo = new ColaCircular(3);
		foo.encolar(1);
		foo.encolar(5);
		foo.encolar(4);
		foo.encolar(8);
		foo.mostrar();
		foo.desEncolar();
		foo.mostrar();
		foo.desEncolar();
		foo.mostrar();
		foo.encolar(6);
		foo.mostrar();
		/*
		foo.desEncolar();
		foo.desEncolar();
		foo.mostrar();
		*/
	}
}

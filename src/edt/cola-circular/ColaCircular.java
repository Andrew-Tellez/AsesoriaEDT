
public class ColaCircular {
	Nodo[] nodos;
	int max;
	int tamaño;
	int fin;
	int inicio;

	ColaCircular() {
		nodos = new Nodo[3];
		max = 3;
		tamaño = 0;
		fin = 0;
		inicio = 0;
	}

	ColaCircular(int max) {
		nodos = new Nodo[max];
		this.max = max;
		tamaño = 0;
		fin = 0;
		inicio = 0;
	}

	public boolean esVacio() {
		if (tamaño == 0)
			return true;
		else
			return false;
	}

	public boolean esLleno() {
		if (tamaño == max)
			return true;
		else
			return false;
	}

	public void encolar(int numero) {
		Nodo nuevo = new Nodo(numero);
		if (!esLleno()) {
			nodos[fin] = nuevo;
			fin = (fin + 1) % max;
			tamaño++;

		} else {
			System.out.println("La cola esta llena debes desencolar para almacenar mas");
		}
	}

	public void desEncolar() {
		if (!esVacio()) {
			inicio = (inicio + 1) % max;
			tamaño--;
		} else {
			System.out.println("La cola está vacia debes encolar para desencolar");
		}
	}

	public void mostrar() {
		String cadena = "";
		if (tamaño == 0) {
			System.out.println("no hay ningun nodo");
		}
		int inicioCola = inicio;
		for (int i = 0; i < tamaño; i++) {
			cadena += nodos[inicioCola] + ", ";
			inicioCola = (inicioCola + 1) % max;
		}
		System.out.println(cadena);
	}
}

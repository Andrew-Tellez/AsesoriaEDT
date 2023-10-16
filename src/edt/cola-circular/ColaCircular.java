
public class ColaCircular {
	Nodo[] nodos;
	int max;
	int tamaño;
	int fin;

	ColaCircular(){
		nodos = new Nodo[3];
		max = 3;
		tamaño = 0;
		fin = -1;
	}

	ColaCircular(int max){
		nodos = new Nodo[max];
		this.max = max;
		tamaño = 0;
		fin = -1;
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
			fin++;
			nodos[fin] = nuevo;
			tamaño++;

		} else {
			System.out.println("La cola esta llena debes desencolar para almacenar mas");
			}
	}

	public void desEncolar() {
		if (!esVacio()){
			for (int i = 0; i < fin;) {
				
				nodos[i] = nodos[i+1];
				i++;
				
			}
			nodos[fin] = null;
			fin--;
			tamaño--;
		}else{
			System.out.println("La cola está vacia debes encolar para desencolar");
		}
	}

	public void mostrar() {
		String cadena = "";
		if (tamaño == 0) {
			System.out.println("no hay ningun nodo");
		}
		for (Nodo nodo : nodos) {
			cadena += nodo+", ";
		}
		System.out.println(cadena);
	}
}

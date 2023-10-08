
public class Cola {
	Nodo raiz;
	Nodo fondo;
	int max;
	int posicion;

	Cola(){
		raiz = null;
		fondo = null;
		max = 3;
		posicion = 0;
	}

	Cola(int max){
		raiz = null;
		fondo = null;
		this.max = max;
		posicion = 0;
	}
	
	public boolean esVacio() {
		if (raiz == null)
			return true;
		else
			return false;		
	}

	public boolean esLleno() {
		if (max == posicion)
			return true;
		else 
			return false;
	}

	public void encolar(int numero) {
		Nodo nuevo = new Nodo(numero);
		if (esLleno()){	
			System.out.println("La cola esta llena debes desencolar para almacenar mas");
		}else if(esVacio()){
			raiz = nuevo;
			System.out.println(raiz);
			fondo = nuevo;
			posicion++;
		}else{
			fondo.siguiente = nuevo;
			fondo = nuevo;
			System.out.print(raiz+ "\n");
			posicion++;
		}
	}

	public void desEncolar(){
		if (esVacio()){
			System.out.println("La cola está vacia debes encolar al menos uno para desencolar");
		}else{
			raiz = raiz.siguiente;	
			posicion--;
			if(esVacio()){
				raiz = null;
				fondo = null;
			}
		}	 
	}

	public void mostrar() {
		String cadena = "";
		Nodo actual = raiz;
		if(actual== null){
			System.out.println("no hay ningun nodo");
		}
		while (actual != null) {
			cadena += actual.informacion + " ";
			actual = actual.siguiente;
		}
		System.out.println(cadena); 
	}
}

 

 

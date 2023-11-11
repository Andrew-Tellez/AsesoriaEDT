
/**
 * Representa un árbol binario ordenado
 * 
 * @author Libardo
 * 
 */

public class ArbolBinarioOrdenado {
	/**
	 * Raiz del arbol binario
	 */
	private Nodo raiz;

	/**
	 * Constructor por defecto
	 */
	public ArbolBinarioOrdenado() {
		raiz = null;
	}

	/**
	 * Inserta un nodo en el arbol binario
	 * 
	 * @param valor valor a insertar
	 */
	public void insertar(Object valor) throws Exception {
		Comparable2 dato = (Comparable2) valor;
		Nodo nuevo = new Nodo();
		nuevo.setValor(dato);

		if (raiz == null)
			raiz = nuevo;
		else {
			// anterior: referencia al padre de aux
			Nodo anterior = null;
			// aux: auxiliar que va recorriendo los nodos, desde la raiz
			Nodo aux = raiz;
			while (aux != null) {
				anterior = aux;
				if (dato.esMenor(aux.getValor()))
					aux = aux.getIzquierdo();
				else if (dato.esMayor(aux.getValor()))
					aux = aux.getDerecho();
				else
					throw new Exception("Dato duplicado");
			}
			if (dato.esMenor(anterior.getValor()))
				anterior.setIzquierdo(nuevo);
			else
				anterior.setDerecho(nuevo);
		}
	}

	/**
	 * insertar2 es la interfaz de la operacion, llama al método insertarRecursivo
	 * que realiza la operación y devuelve la raiz del nuevo árbol. A este método
	 * interno se le pasa la raiz actual, a partir de la cual se describe el camino
	 * de búsqueda, y al final, se enlaza. En un arbol binario de búsqueda no hay
	 * nodos duplicados; por ello, si se encuentra un nodo igual que el que se desea
	 * insertar, se lanza una excepcion
	 * 
	 * @param valor valor del nodo a insertar
	 */
	public void insertar2(Object valor) throws Exception {
		Comparable2 dato = (Comparable2) valor;
		raiz = insertarRec(raiz, dato);
	}

	private Nodo insertarRec(Nodo raizSub, Comparable2 dato) throws Exception {
		if (raizSub == null) {
			// caso base, termina la recursividad
			raizSub = new Nodo(dato);
		} else {
			if (dato.esMenor(raizSub.getValor())) {
				Nodo iz = insertarRec(raizSub.getIzquierdo(), dato);
				raizSub.setIzquierdo(iz);
			} else {
				if (dato.esMayor(raizSub.getValor())) {
					Nodo dr = insertarRec(raizSub.getDerecho(), dato);
					raizSub.setDerecho(dr);
				} else {
					// Dato duplicado
					throw new Exception("Nodo duplicado");
				}
			}
		}
		return raizSub;
	}

	/**
	 * Busca un dato en el árbol comenzando desde la raiz
	 * 
	 * @param valor valor a buscar
	 * @return
	 */
	public Nodo buscar(Object valor) {
		Comparable2 dato = (Comparable2) valor;

		if (raiz == null)
			return raiz;
		else {
			// aux: auxiliar que va recorriendo los nodos, desde la raiz
			Nodo aux = raiz;
			while (aux != null) {
				if (dato.esIgual(aux.getValor()))
					return aux;
				if (dato.esMenor(aux.getValor()))
					aux = aux.getIzquierdo();
				else
					aux = aux.getDerecho();
			}
			return null;
		}
	}

	/**
	 * Interfaz de buscar que invoca al metodo recursivo localizar
	 * 
	 * @param buscado
	 * @return
	 */
	public Nodo buscar2(Object buscado) {
		Comparable2 dato = (Comparable2) buscado;
		if (raiz == null)
			return null;
		else
			return localizar(raiz, dato);
	}

	public Nodo localizar(Nodo raizSub, Comparable2 buscado) {
		if (raizSub == null)
			return null;
		else if (buscado.esIgual(raizSub.getValor()))
			return raizSub;
		else if (buscado.esMenor(raizSub.getValor()))
			return localizar(raizSub.getIzquierdo(), buscado);
		else
			return localizar(raizSub.getDerecho(), buscado);
	}

	/**
	 * Invoca al método recursivo
	 */
	public void preorden() {
		preorden(raiz);
	}

	/**
	 * Método recursivo de recorrido en pre-orden
	 * 
	 * @param aux referencia a un nodo
	 */
	private void preorden(Nodo aux) {
		if (aux != null) {
			visitar(aux);
			preorden(aux.getIzquierdo());
			preorden(aux.getDerecho());
		}
	}

	private void visitar(Nodo aux) {
		System.out.print(aux.getValor() + " ");
	}

	/**
	 * Invoca al método recursivo
	 */
	public void inorden() {
		inorden(raiz);
	}

	/**
	 * Método recursivo de entre-orden
	 * 
	 * @param aux referencia a un nodo
	 */
	private void inorden(Nodo aux) {
		if (aux != null) {
			inorden(aux.getIzquierdo());
			visitar(aux);
			inorden(aux.getDerecho());
		}
	}

	/**
	 * Invoca al método recursivo
	 */
	public void postorden() {
		postorden(raiz);
	}

	/**
	 * Método recursivo post-orden
	 * 
	 * @param aux referencia a un nodo
	 */
	private void postorden(Nodo aux) {
		if (aux != null) {
			postorden(aux.getIzquierdo());
			postorden(aux.getDerecho());
			visitar(aux);
		}
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public boolean eliminar(Object valor) {
		Comparable2 dato = (Comparable2) valor;
		// Buscar el nodo a eliminar y su antecesor

		Nodo antecesor = null;// antecesor del nodo a eliminar
		// aux: auxiliar que va recorriendo los nodos, desde la raiz
		Nodo aux = raiz;
		while (aux != null) {
			if (dato.esIgual(aux.getValor())) {
				break;
			}
			antecesor = aux;
			if (dato.esMenor(aux.getValor()))
				aux = aux.getIzquierdo();
			else
				aux = aux.getDerecho();
		}
		if (aux == null)
			return false; // dato no encontrado

		// Si llega a este punto, el nodo a eliminar existe y es aux, y su
		// antecesor es antecesor

		// Examinar cada caso
		// 1. Si tiene menos de dos hijos, incluso una hoja, reajustar los
		// enlaces de su antecesor
		if (aux.getIzquierdo() == null)
			if (aux.getValor().esMenor(antecesor.getValor()))
				antecesor.setIzquierdo(aux.getDerecho());
			else
				antecesor.setDerecho(aux.getDerecho());
		else if (aux.getDerecho() == null)
			if (aux.getValor().esMenor(antecesor.getValor()))
				antecesor.setIzquierdo(aux.getIzquierdo());
			else
				antecesor.setDerecho(aux.getIzquierdo());

		// El nodo a eliminar tiene rama izquierda y derecha
		reemplazarPorMayorIzquierdo(aux);

		aux = null;
		return true;
	}

	/**
	 * Reemplaza el nodo actual, por el mayor de la rama izquierda
	 * 
	 * @param act nodo actual o nodo a eliminar que tiene rama izquierda y derecha
	 */
	private void reemplazarPorMayorIzquierdo(Nodo act) {
		Nodo mayor = act;
		Nodo ant = act;
		mayor = act.getIzquierdo();
		// Buscar el mayor de la rama izquierda
		// ant es el antecesor de mayor
		while (mayor.getDerecho() != null) {
			ant = mayor;
			mayor = mayor.getDerecho();
		}
		act.setValor(mayor.getValor());// reemplaza
		// reajuste
		if (ant == act)
			ant.setIzquierdo(mayor.getIzquierdo());
		else
			ant.setDerecho(mayor.getIzquierdo());
	}

	/**
	 * Interfaz de eliminar que invoca el metodo recursivo
	 * 
	 * @param valor
	 * @throws Exception
	 */
	public void eliminar2(Object valor) throws Exception {
		Comparable2 dato = (Comparable2) valor;
		raiz = eliminarRec(raiz, dato);
	}

	/**
	 * Version de eliminar nodo recursivo
	 * 
	 * @param raizSub
	 * @param dato
	 * @return
	 * @throws Exception
	 */
	private Nodo eliminarRec(Nodo raizSub, Comparable2 dato) throws Exception {
		if (raizSub == null)
			throw new Exception("No se ha encontrado el nodo con la clave");
		else if (dato.esMenor(raizSub.getValor())) {
			Nodo iz = eliminarRec(raizSub.getIzquierdo(), dato);
			raizSub.setIzquierdo(iz);
		} else if (dato.esMayor(raizSub.getValor())) {
			Nodo dr = eliminarRec(raizSub.getDerecho(), dato);
			raizSub.setDerecho(dr);
		} else {
			// Nodo encontrado
			Nodo q = raizSub; // Nodo a quitar del arbol
			if (q.getIzquierdo() == null)
				raizSub = q.getDerecho();
			else if (q.getDerecho() == null)
				raizSub = q.getIzquierdo();
			else {
				q = reemplazar(q);
			}
			q = null;
		}
		return raizSub;
	}

	/**
	 * Método interno para sustituir por el mayor de los menores
	 * 
	 * @param act
	 * @return
	 */
	private Nodo reemplazar(Nodo act) {
		Nodo mayor, ant;
		ant = act;
		mayor = act.getIzquierdo();
		while (mayor.getDerecho() != null) {
			ant = mayor;
			mayor = mayor.getDerecho();
		}
		act.setValor(mayor.getValor());
		if (ant == act)
			ant.setIzquierdo(mayor.getIzquierdo());
		else
			ant.setDerecho(mayor.getIzquierdo());
		return mayor;
	}

	/**
	 * Busca el nodo padre de un nodo
	 * 
	 * @param valor valor del nodo
	 * @return nodo padre
	 */
	public Nodo buscarPadre(Object valor) {
		Comparable2 dato = (Comparable2) valor;
		Nodo aux = raiz;
		Nodo padre = raiz;
		while (aux != null) {
			if (dato.esMenor(aux.getValor())) {
				padre = aux;
				aux = aux.getIzquierdo();

			} else if (dato.esMayor(aux.getValor())) {
				padre = aux;
				aux = aux.getDerecho();
			} else
				return padre;

		}
		return null;
	}

	public void antecesor(Object valor) {
		Nodo a = buscarPadre(valor);
		while (a != raiz) {
			Entero num = (Entero) a.getValor();
			System.out.print(num.getDato() + ",");
			Object ax = (Object) a.getValor();
			a = buscarPadre(ax);
		}
		if (a == raiz) {
			Entero num = (Entero) a.getValor();
			System.out.print(num.getDato());
		}
	}
}

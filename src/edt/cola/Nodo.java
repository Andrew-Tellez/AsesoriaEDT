
public class Nodo {
	int informacion;
	Nodo siguiente;

	Nodo (int informacion){
		this.informacion = informacion;
		siguiente = null;
	}
	@Override
	public String toString() {
		return ("Nodo["+informacion+ " "+siguiente+ "]");
	}
}


public class Nodo {
	int informacion;

	Nodo (int informacion){
		this.informacion = informacion;
	}
	@Override
	public String toString() {
		return ("Nodo["+informacion+"]");
	}
}

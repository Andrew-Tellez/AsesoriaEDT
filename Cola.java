public class Cola <E> {
	
	private E dr;
	private E[] cola;
	private int frente;
	private int fin;
	private int max;

	public Cola() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public Cola(int max) {
		this.max = max;
		cola = (E[]) new Object[max];
		frente = fin = -1;
		
	}
	
	public boolean Vacia() {
		return frente == -1;
	}
	
	public boolean Llena() {
		return fin == max-1;
	}
	
	public boolean Insertar(E dato) {
		if (Llena())
			return false;
		if (Vacia())
			frente = 0;
		fin++;
		cola[fin] = dato;
		return true;
		
	}
	
	public boolean Retirar() {
		if (Vacia())
			return false;
		dr = cola[frente];
		cola[frente] = null;
		if (frente == fin) {
			frente = fin = -1;
		}else {
			frente++;
		}
		return true;
	}
	
	public E getDr() {
		return dr;
	}
	
	

}

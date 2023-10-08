package listas;

public class Nodo<T> {
    private T valor;
    Nodo<T> siguiente;
    private int posicion;

    public Nodo() {
        valor = null;
        siguiente = null;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public T getValor() {
        return valor;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public String toString() {
        // TODO Auto-generated method stub
        return "Valor:" + valor + " Posicion:" + posicion;
    }

}

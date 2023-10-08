package listas;

public class Lista<T> {

    private Nodo<T> cabeza;
    private int tamaño;

    public Lista() {
        cabeza = null;
        tamaño = 0;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Nodo<T> buscarPorClavePosicion(T v, int pos) throws PosicionIlegalException {
        Nodo<T> aux = new Nodo<T>();
        pos = tamaño - 1;
        int j = 0;
        aux = cabeza;

        if (getValor(pos) != v) {
            System.out.println("No se encontro el nodo: " + -1);
        }
        while (getValor(j) != v) {
            aux = aux.getSiguiente();
            j++;
        }
        aux.setPosicion(j);

        return aux;
    }

    public boolean esVacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }

    }

    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setValor(valor);
        if (esVacia()) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        tamaño++;
    }

    public void insertar(T valor, int pos) throws PosicionIlegalException {
        if (pos >= 0 && pos <= tamaño) {
            Nodo<T> nuevo = new Nodo<T>();
            nuevo.setValor(valor);
            if (pos == 0) {
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;

            } else {
                if (pos == tamaño) {
                    Nodo<T> aux = cabeza;
                    while (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo);
                } else {
                    Nodo<T> aux = cabeza;
                    for (int i = 0; i < pos - 2; i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodo<T> siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
            }
            tamaño++;
        } else {
            throw new PosicionIlegalException();
        }

    }

    public void remover(int pos) throws PosicionIlegalException {
        if (pos >= 0 && pos < tamaño) {
            if (pos == 0) {
                cabeza = cabeza.getSiguiente();
                tamaño--;
            } else {
                Nodo<T> aux = cabeza;
                for (int i = 0; i < pos - 2; i++) {
                    aux = aux.getSiguiente();
                }
                Nodo<T> prox = aux.getSiguiente();
                aux.setSiguiente(prox.getSiguiente());
                tamaño--;
            }
        } else {
            throw new PosicionIlegalException();
        }
    }

    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }

    public T getValor(int pos) throws PosicionIlegalException {
        if (pos >= 0 && pos < tamaño) {
            T valor;
            if (pos == 0) {
                valor = cabeza.getValor();
                return valor;
            } else {
                Nodo<T> aux = cabeza;
                for (int i = 0; i <= pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                valor = aux.getValor();
            }
            return valor;
        } else {
            throw new PosicionIlegalException();
        }
    }
}

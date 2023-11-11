
public class Nodo {
    private Comparable2 valor;

    private Nodo izquierdo;

    private Nodo derecho;

    private int fe;// factor equilibrio

    public Nodo() {

        valor = null;

        izquierdo = null;

        derecho = null;

        fe = 0;

    }

    public Nodo(Comparable2 valor) {

        this.valor = valor;

        izquierdo = null;

        derecho = null;

        fe = 0;

    }

    public int getFe() {

        return fe;

    }

    public void setFe(int fe) {

        this.fe = fe;

    }

    public Comparable2 getValor() {

        return valor;

    }

    public void setValor(Comparable2 valor) {

        this.valor = valor;

    }

    public Nodo getIzquierdo() {

        return izquierdo;

    }

    public Nodo getDerecho() {

        return derecho;

    }

    public void setIzquierdo(Nodo izquierdo) {

        this.izquierdo = izquierdo;

    }

    public void setDerecho(Nodo derecho) {

        this.derecho = derecho;

    }
}

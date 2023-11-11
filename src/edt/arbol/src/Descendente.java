public class Descendente implements Comparable<Descendente> {
    int numero;

    public Descendente(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Descendente o) {
        int resultado = 0;
        if (this.numero > o.numero) {
            resultado = -1;
        }
        if (this.numero < o.numero) {
            resultado = 1;
        }
        if (this.numero == o.numero) {
            resultado = 0;
        }
        return resultado;
    }
}

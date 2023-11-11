public class Ascendente implements Comparable<Ascendente> {
    int numero;

    public Ascendente(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Ascendente o) {
        int resultado = 0;
        if (this.numero > o.numero) {
            resultado = 1;
        }
        if (this.numero < o.numero) {
            resultado = -1;
        }
        if (this.numero == o.numero) {
            resultado = 0;
        }
        return resultado;
    }

}

package listas;

public class TestBuscar {
    public static void main(String[] args) {
        try {
            Lista<Integer> lista1 = new Lista<Integer>();
            lista1.agregar(30);
            lista1.agregar(2);
            lista1.agregar(15);
            lista1.agregar(4);

            System.out.println(lista1.buscarPorClavePosicion(2, 3));
            System.out.println("<--------------------------------->");
            System.out.println(lista1.buscarPorClavePosicion(4, 3));
            System.out.println("<--------------------------------->");
            System.out.println(lista1.buscarPorClavePosicion(30, -1));

        } catch (PosicionIlegalException e) {
            e.printStackTrace();
        }
    }
}


public class ClienteMainOperacionesSencillas {
    public static void main(String[] args) {
        ArbolBinarioOrdenado arbol = new ArbolBinarioOrdenado();
        try {
            arbol.insertar(new Entero(10));
            arbol.insertar(new Entero(15));
            arbol.insertar(new Entero(30));
            arbol.insertar(new Entero(5));
            arbol.insertar(new Entero(2));
            arbol.insertar(new Entero(1));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Imprimir
        BTreePrinter.printNode(arbol.getRaiz());
        System.out.print("Nodos antecesores del 1: ");
        arbol.antecesor(new Entero(1));
        System.out.print("\nNodos antesesores del 30: ");
        arbol.antecesor(new Entero(30));
    }
}

import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        TreeSet<Ascendente> ArbolAscendente = new TreeSet<Ascendente>();
        ArbolAscendente.add(new Ascendente(10));
        ArbolAscendente.add(new Ascendente(15));
        ArbolAscendente.add(new Ascendente(30));
        ArbolAscendente.add(new Ascendente(5));
        ArbolAscendente.add(new Ascendente(2));
        ArbolAscendente.add(new Ascendente(1));

        for (Ascendente ascendente : ArbolAscendente) {
            System.out.println(ascendente.numero);
        }

        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("**********************************");

        TreeSet<Descendente> arbolDescendentes = new TreeSet<Descendente>();
        arbolDescendentes.add(new Descendente(20));
        arbolDescendentes.add(new Descendente(40));
        arbolDescendentes.add(new Descendente(45));
        arbolDescendentes.add(new Descendente(30));
        arbolDescendentes.add(new Descendente(50));
        arbolDescendentes.add(new Descendente(5));

        for (Descendente EDes : arbolDescendentes) {
            System.out.println(EDes.numero);
        }

    }
}

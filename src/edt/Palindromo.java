import java.util.Stack;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) throws Exception {

        char espacio = ' ';

        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");

        // Introduzca el el string en la entrada
        String entrada = "Dábale arroz a la zorra el abad";

        String original = entrada;
        String nueva_entrada = removerTildes(entrada);
        nueva_entrada = nueva_entrada.toUpperCase();

        Stack<Character> cadena = new Stack<Character>();

        eliminarEspacios(nueva_entrada, espacio, cadena);

        String reversa = "";

        while (!cadena.isEmpty()) {
            reversa += cadena.pop();
        }

        if (esPalindrome(reversa))
            System.out.println("La palabra (" + original + ") es palindrome");
        else
            System.out.println("La palabra (" + original + ") no es palindrome");
    }

    static boolean esPalindrome(String reversa) {

        int i = 0, j = reversa.length() - 1;

        while (i < j) {

            if (reversa.charAt(i) != reversa.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    static void eliminarEspacios(String nueva_entrada, char espacio, Stack<Character> cadena) {
        for (int i = 0; i < nueva_entrada.length(); i++) {
            if (!(nueva_entrada.charAt(i) == espacio)) {
                cadena.push(nueva_entrada.charAt(i));
            }

        }
    }

    static String removerTildes(String entrada) {
        return (entrada.replace('Á', 'A').replace('É', 'E').replace('Í', 'I').replace('Ó', 'O').replace('Ú', 'U')
                .replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u'));
    }
}

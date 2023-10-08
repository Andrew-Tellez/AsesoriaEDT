import java.util.Hashtable;

public class Recursividad {
	static Hashtable<Integer,Long> ht = new Hashtable<>();

	public static int factorial(int n) {
		// caso base
		if (n == 0 || n == 1) {
			return 1;
		} else {
			// lamada recursiva
			return n * factorial(n - 1); 
		}

	}

	static int fibonacci(int n) {
		// Caso base
		if (n <= 1) {
			return n;
		} else {
			// Llamadas recursivas para los dos números anteriores en la secuencia
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	static Long fibonacciMemo(int n){
		if (n <= 1){
			long aux = n;
			return aux;
		}
		if (ht.containsKey(n)){
			return ht.get(n);
		}
		long result =  fibonacciMemo(n-1) + fibonacciMemo(n-2);
		ht.put(n, result);
		return result;
	}
}

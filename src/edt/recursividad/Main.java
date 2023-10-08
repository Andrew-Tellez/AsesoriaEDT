import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("1: factorial");
		for (String string : args) {	
			System.out.println(Recursividad.factorial(Integer.parseInt(string)));	
		}			
		System.out.println("2: fibonacci");
		for (String string : args) {	
			System.out.println(Recursividad.fibonacci(Integer.parseInt(string)));	
		}
		System.out.println("3: fibnacciMemo");
		for (String string : args) {	
			System.out.println(Recursividad.fibonacciMemo(Integer.parseInt(string)));	
		}
	}
}
 

package examples.e005;

import java.util.List;

/**
 * Modul 323, Lazy Evaluation
 */
public class Main {
	public static boolean mod3(int number) {
		System.out.println("mod3 wurde aufgerufen");
		return number % 3 == 0;
	}

	public static int mult3(int number) {
		System.out.println("mult3 wurde aufgerufen");
		return number * 3;
	}

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.stream().filter(Main::mod3).map(Main::mult3)
		// .findFirst() // unkommentiere diese Zeile, was passiert?
		;

		System.out.println("Erledigt");
	}
}

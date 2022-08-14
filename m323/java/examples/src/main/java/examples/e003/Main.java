package examples.e003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		// Fixe Grösse versus dynamische Grösse einer Liste
		// Mutable versus immutable Listen.
		
		// Dynamisch und Mutable
		List<Integer> numbers = new ArrayList<>();
		// Fix und Mutable
		List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
		// Fix und Immutable
		List<Integer> numbers10 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Imperativer Ansatz
		double res = 0;
		for (Integer number : numbers10) {
			if (number % 2 == 0) {
				res += Math.sqrt(res);
			}
		}
	}
}

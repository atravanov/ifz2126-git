package examples.e001;

import java.util.List;

/**
 * Modul 323, Imperativer und Deklarativer Ansatz.
 * <p>
 * Demonstriert den Unterschied zwischen dem imperativen Ansatz (WAS und WIE)
 * und dem deklarativen Ansatz (WAS und nicht WIE)
 */
public class Main {
	public static void main(String[] args) {
		List<String> languages = List.of("Java", "Javascript", "Go", "Scala", "C");

		// Imperativer Ansatz
		for (int i = 0; i < languages.size(); i++) {
			if (languages.get(i).equals("Java")) {
				System.out.println("I like Java");
			}
		}

		// Deklarativer Ansatz
		if (languages.contains("Java")) {
			System.out.println("I like Java");
		}
	}
}

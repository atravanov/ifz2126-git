package m323sq2a;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import m323sq2a.model.Book;
import m323sq2a.model.Library;

/**
 * Ausfuehrendes Programm des Projektes
 * 
 * @author Patrick Meier
 *
 */
public class Programm {

	public static void main(String[] args) {

		System.out.println("\nAnpassung der Eintr�ge der Bibliothek mittels for-Schleife");
		List<Book> standardBooks = standardUpper(Library.getBooks());
		standardBooks.forEach(b -> System.out.println(b.getTitle() + " (" + b.getReleaseYear() + ")"));

		System.out.println("\nAnpassung der Eintr�ge der Bibliothek mittels funktionaler Befehle");
		List<Book> mappedBooks = mapUpper(Library.getBooks());
		mappedBooks.forEach(b -> System.out.println(b.getTitle() + " (" + b.getReleaseYear() + ")"));
	}

	/**
	 * Diese Methode erzeugt eine neue Liste mit Buechern und aendert deren Titel in
	 * Grossbuchstaben. Hierbei wird eine forEach-Schleife eingesetzt.
	 * 
	 * @param books Liste mit Buechern
	 * @return Liste mit angepassten Buechern
	 */
	private static List<Book> standardUpper(List<Book> books) {
		List<Book> newBooks = new ArrayList<Book>();

		for (Book book : books) {
			newBooks.add(new Book(
					book.getTitle().toUpperCase(), 
					book.getAuthor(), 
					book.getSoldCopies(),
					book.getReleaseYear()));
		}

		return newBooks;
	}

	/**
	 * Diese Methode erzeugt eine neue Liste mit Buechern und aendert deren Titel in
	 * Grossbuchstaben. Hierbei wird der map-Befehl eingesetzt.
	 * 
	 * @param books Liste mit Buechern
	 * @return Liste mit angepassten Buechern
	 */
	private static List<Book> mapUpper(List<Book> books) {
		return books.stream()
				.map(b -> new Book(
						b.getTitle().toUpperCase(), 
						b.getAuthor(), 
						b.getReleaseYear(), 
						b.getReleaseYear()))
				.collect(Collectors.toList());
	}
}
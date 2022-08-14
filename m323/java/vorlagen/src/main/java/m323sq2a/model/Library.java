package m323sq2a.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper-Klasse um Buecher bereitzustellen
 * 
 * @author Patrick Meier
 *
 */
public class Library {

	private static List<Book> books = new ArrayList<Book>();

	public Library() {

	}

	/**
	 * Gibt eine Liste mit Buechern zur�ck. Falls der interene Speicher f�r
	 * Buecher noch nicht initialisiert wurde, wird dies zuerst ausgef�hrt.
	 * 
	 * @return Eine Liste mit Buechern
	 */
	public static List<Book> getBooks() {
		if (books.size() == 0) {
			initializeBooks();
		}

		return books;
	}

	/**
	 * Methode zum initialisieren der Bibliothek. Neue Buecher sollen darin erfasst
	 * werden.
	 */
	private static void initializeBooks() {
		books.add(new Book("A Game of Thrones", "George R. R. Martin", 90, 1996));
		books.add(new Book("The Hobbit", "J. R. R. Tolkien", 100, 1937));
		books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 120, 1997));
		books.add(new Book("The Lion, the Witch and the Wardrobe", "C. S. Lewis", 85, 1950));
		books.add(new Book("The Da Vinci Code", "Dan Brown", 80, 2003));
		books.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 77, 1998));
		books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 65, 1999));
		books.add(new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling", 65, 2000));
		books.add(new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", 65, 2003));
		books.add(new Book("Harry Potter and the Half-Blood Prince", "J. K. Rowling", 65, 2005));
		books.add(new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling", 65, 2007));
		books.add(new Book("Heidi", "Johanna Spyri", 50, 1880));
		books.add(new Book("Watership Down", "Richard Adams", 50, 1972));
		books.add(new Book("Angels & Demons", "Dan Brown", 39, 2000));
		books.add(new Book("1984", "George Orwell", 30, 1949));
		books.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 30, 2005));
		books.add(new Book("The Hunger Games", "Suzanne Collins", 29, 2008));
		books.add(new Book("Dune", "Frank Herbert", 20, 1965));
		books.add(new Book("Animal Farm", "George Orwell", 20, 1945));
		books.add(new Book("The Lost Symbol", "Dan Brown", 30, 2009));
		books.add(new Book("Catching Fire", "Suzanne Collins", 21, 2009));
		books.add(new Book("Mockingjay", "Suzanne Collins", 20, 2010));
		books.add(new Book("The Colour of Magic", "Terry Pratchett", 11, 1983));
		books.add(new Book("Jonathan Strange & Mr Norrel", "Susanna Clarke", 22, 2004));
		books.add(new Book("The Name of the Wind", "Patrick Rothfuss", 33, 2007));
		books.add(new Book("The Lies of Locke Lamora", "Scott Lynch", 44, 2006));
		books.add(new Book("American Gods", "Neil Gaiman", 55, 2001));
		books.add(new Book("The Fifth Season", "N. K. Jemisin", 66, 2015));
		books.add(new Book("The Earthsea Quartet", "Ursula Le Guin", 77, 1993));
		books.add(new Book("Assassin's Apprentice", "Robin Hobb", 88, 1995));
		books.add(new Book("Throne of Glass", "Sarah J. Maas", 99, 2012));
	}
}

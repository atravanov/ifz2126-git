package m323sq2a.model;

/**
* Modelklasse f�r Buch Objekte. Diese enth�lt Titel, Author, Ver�ffentlichungsdatum sowie
* Anzahl verkaufter Kopien (in Millionen)
* 
* @author Patrick Meier
*
*/
public class Book {
	private String title;
	private String author;
	private int releaseYear;
	private int soldCopies;

	public Book(String title, String author, int soldCopies, int releaseYear) {
		this.title = title;
		this.setAuthor(author);
		this.releaseYear = releaseYear;
		this.soldCopies = soldCopies;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSoldCopies() {
		return soldCopies;
	}

	public void setSoldCopies(int soldCopies) {
		this.soldCopies = soldCopies;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

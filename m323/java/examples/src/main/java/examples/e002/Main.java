package examples.e002;

import java.util.List;
import java.util.function.Consumer;

/**
 * Modul 323, Externen und interne Iteration, Lambdas,
 * Interface Consumer, Funktionale Interfaces.
 */
public class Main {
	public static void main(String[] args) {
		List<String> languages = List.of("Java", "Javascript", "Go", "Scala", "C");
		
		// Externe Iteration
		for (int i = 0; i < languages.size(); i++) {
			System.out.println(languages.get(i));
		}
		
		for (String lang: languages) {
			System.out.println(lang);
		}
		
		// Interne Iteration
		Printer<String> printer = new Printer<>();
		languages.forEach(printer);

		// Consumer Interface ist ein Funtionales Interface. (= darf nur eine
		// abstrakte Methode beinhalten).
		languages.forEach(new Consumer<String>() {
			public void accept(String t) {
				System.out.println(t);
			}	
		});
		
		// Verwendung von Lambdas
		languages.forEach((String lang)-> {
			System.out.println(lang);
		});
		
		// Bei einem Statemet kann auf die geschweifte Klammer verzichtet werden.
		languages.forEach((String lang)-> System.out.println(lang));
		
		// Compiler hat alle Information, Typ String muss nicht angegeben werden.
		languages.forEach((lang)-> System.out.println(lang));
		
		// Falls nur ein Parameter übergeben wird, wird Klammer nicht benötigt.
		// Falls kein Parameter oder mehrere Parameter benutzt werden, muss
		// Klammer verwendet werden.
		languages.forEach(lang-> System.out.println(lang));
		
		// Wird der Parameter nur durchgereicht kann Referenz auf die Methode
		// übergeben werden.
		languages.forEach(System.out::println);
	}
}

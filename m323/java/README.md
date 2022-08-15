# Beispiele
## Package e001
Demonstriert den Unterschied zwischen dem **Imperativen** (WAS und WIE) und dem **Deklarativen** (WAS und nicht WIE) Progammier-Paradigma.
```Java
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
```

## Package e002
Übersicht: Externe und Interne Iterationen, **Consumer**, **Lambda Expressions**, Funktionen höherer Ordnung.
```Java
package examples.e002;

import java.util.List;
import java.util.function.Consumer;

/**
 * Modul 323, Iteration, Consumer, Lambda Expressions
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
		
		// Verwendung von Lambda Expressions
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
		
		// oder
		Consumer<String> consumer = lang -> System.out.println(lang);
		languages.forEach(consumer);
		
		// Wird der Parameter nur durchgereicht kann Referenz auf die Methode
		// übergeben werden.
		languages.forEach(System.out::println);
		
	}
}
```
```Java
package examples.e002;

import java.util.function.Consumer;

public class Printer<T> implements Consumer<T> {
	@Override
	public void accept(T t) {
		System.out.println(t);
	}
}
```
## Package e003
Demonstriert den Unterschied zwischen dem **Imperativen** und **Funktionalen** Programmier Paradigma. Zusätzlich werden **mutable** und **immutable** Listen präsentiert. 

```Java
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
			if (number % 3 == 0) {
				res += Math.sqrt(number);
			}
		}
		
		System.out.println(res);
		
		// Funktionaler Ansatz
		
		res =numbers10.stream()
			.filter(number -> number % 3 == 0 ) //Funktional (inkl.Deklarativ)
			.mapToDouble(Math::sqrt) // Funktional (inkl. Deklarativ)
			.sum();
		
		System.out.println(res);
	}
}
```

## Package e004
Demonstriert die Anwendung von **Streams** (`filter`-Methode, `map`-Methode, `reduce`-Methode) und IntStreams (`mapToInt`-Methode, `sum`-Methode etc.)

```Java
package examples.e004;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Modul 323, Anwenung von Streams
 * <p>
 * Demonstriert die Anwendung von Streams (filter, map, reduce) 
 * und IntStreams (mapToInt, sum, max, min etc.)
 */
public class Main {
	
	public static void main(String[] args) {
		List<String> languages = List.of("Java", "Javascript", "Go", "Scala", "C");

		// filter
		languages.stream()
		.filter(str -> str.contains("Java"))
		.forEach(System.out::println);
		
		// map
		languages.stream()
		.filter(str -> str.contains("Java"))
		.map(String::length)
		.forEach(System.out::println);
		
		// reduce
		var res = languages.stream()
		.filter(str -> str.contains("Java"))
		.map(String::length)
		.reduce(0,(total, i) -> total + i );
		
		System.out.println(res);
		
		// sum
		res = languages.stream()
		.filter(str -> str.contains("Java"))
		.mapToInt(String::length)
		.sum();
		
		System.out.println(res);
		
		// Bemerkung: streams von primitiven Typen
		System.out.println(IntStream.range(0,100).sum());
		System.out.println(IntStream.range(0,100).max().orElse(0));
		System.out.println(IntStream.range(0,100).min().orElse(0));
	}
}
```
## Package e005 
**Lazy Evaluation**
```Java
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
```

# Setup eines Projektes
## Setup Git Repositoy
1. Installiere [Git](https://git-scm.com/).
1. Starte die git bash shell.
1. Kreiere dein Arbeitsverzeichnis.
1. Wechsle in dein Arbeitsverzeichnis.
1. Klone das Repository mit folgendem Befehl:
```Bash
git clone https://github.com/atravanov/ifz2126-git.git
```

## Import des gewünschten Projekts nach Eclipse 
1. File -> Import -> Existing Maven Projects -> Next
1. Selektiere das Root Verzeichnis des Projekts example (beinhaltet die Datei pom.xml) -> Finish

### Aktualisierung der lokalen Files
```Bash
git pull
```
# SQ2A - Map und Reduce

## Zeit - 90 Minuten

* 15 Minuten Einführung
* 60 Minuten Bearbeitung der Aufgabe
* 15 Minuten Besprechung

## Lernart bzw. Sozialform

* praktische Einzelarbeit

## HANOKs & Lernziele

HANOKs: 1.1, 1.3, 1.4, 2.2, 3.2

* Kennt den Unterschied zwischen imperativer und deklarativer/funktionaler Programmierung (deklaratives Programmierparadigma).
* Kennt Vor- und Nachteile funktionaler Programmierung.
* Kennt die Begriffe aus dem funktionalen Programmieren (z.B. Pure-Function, Immutable Data, Lambda-Expression, Function, Closure, Callback, Functor) und versteht diese, um sie korrekt anzuwenden.
* Kennt funktionale Programmierkonzepte (z.B. Filter-Map-Reduce) und passende Entwurfsmuster (z.B. Builder-Pattern).
* Kennt die funktionalen Elemente einer Programmiersprache und kann so Applikationen mit imperativen und deklarativen Programmierparadigma entwickeln.

Lernziele:

* Du kannst auf komplexen Objekten mittels funktionaler Operationen Auswertungen durchführen

## Einführung LP in das Basiswissen

* Arbeiten mit komplexen Objekten bei Streams (Projekt im Unterrichtsmaterial als Orientierung)
* Elementare Terminal-Operationen kurz vorstellen:
  * count
  * sum
  * min
  * max
  * average

### Beispiel Objekt _User_

```java
public class User{
  private String firstname;
  private String lastname;
  private int age;

  // ... here be getters and setters ...
}
```

Wir gehen davon aus, dass eine Variable `users` des Typs `List<User>` existiert.

### `count`-Methode

Zählt alle Elemente eines Streams.

```java
int anzahlUser = users.stream().count();
```

### `sum`-Methode

Summiert die selektieren Elemente eines Streams.

```java
int alterAllerUser = users.stream().mapToInt(u -> u.getAge()).sum();
```

1. Mit `mapToInt` wird aus dem Übergebenen Attribut eine Zahlenliste generiert.
1. Diese wird wiederum mit `sum` zusammengezählt.

### `min`-Methode

Gibt das Element mit dem kleinsten Wert aus einem Stream zurück.

```java
int geringstesAlter = users.stream().mapToInt(u -> u.getAge()).min();
```

1. Mit `mapToInt` wird aus dem Übergebenen Attribut eine Zahlenliste generiert.
1. Aus dieser wird mittels `min` der kleinste Wert gesucht.

### `max`-Methode

Gibt das Element mit dem grössten Wert aus einem Stream zurück.

```java
int hoechstesAlter = users.stream().mapToInt(u -> u.getAge()).max();
```

1. Mit `mapToInt` wird aus dem Übergebenen Attribut eine Zahlenliste generiert.
1. Aus dieser wird mittels `max` der höchste Wert gesucht.

### `average`-Methode

Gibt den Durchschnittswert eines Elements aus einem Stream zurück.

```java
int durchschnittsAlter = users.stream().mapToInt(u -> u.getAge()).average();
```

1. Mit `mapToInt` wird aus dem Übergebenen Attribut eine Zahlenliste generiert.
1. Aus dieser wird mittels `average` der Durchschnittswert ermittelt.

### Kombination mit `filter`

_Beispiel_: Durchschnittsalter aller User älter als 10 Jahre

```java
int durchschnittsAlter = users.stream()
                          .filter(u -> u.getAge() > 10)
                          .mapToInt(u -> u.getAge())
                          .average();
```

1. Mit `filter` werden alle User herausgefiltert, die 10 Jahre alt und jünger sind.
1. Mit `mapToInt` wird aus dem Übergebenen Attribut eine Zahlenliste generiert.
1. Aus dieser wird mittels `average` der Durchschnittswert ermittelt.

### Literatur zum Thema

* [Java 8 Stream Interface Methods](https://www.javatpoint.com/java-8-stream)
* Praehofer "Funktionale Programmierung" Kapitel 4.1, 7

## Ausgangslage

Du hast das Projekt aus dem Unterrichtsmaterial in deine IDE importiert und dieses konnte erfolgreich ausgeführt werden.

## Ziele / erwartete Lernergebnisse

Die Applikation soll so erweitert werden, dass mittels gängiger funktionaler Befehle einfache Auswertungen gemacht werden.

## Auftrag

Erweitere dein Programm soweit, dass bei den folgenden Anforderungen die Auswertung jeweils in der Konsole ausgegeben wird.

1. Analysiere den Code des Beispielprojektes und beachte dabei den Umgang mit dem komplexen Objekt **Book**
1. Gib die **Anzahl** aller Bücher aus
1. Gib die **Anzahl** aller Bücher aus, welche nach dem _Jahr 2000_ veröffentlicht wurden
1. Gib an wie viele Bücher **insgesamt** verkauft wurden
1. Gib an wie viele Bücher im **Durchschnitt** verkauft wurden
1. Gib an welches Buch am **wenigsten Verkäufe** hat, inklusive Zahl
1. Gib an welches Buch am **meisten Verkäufe** hat, inklusive Zahl
1. Gib an wie viele Bücher die Autorin _J. K. Rowling_ insgesamt verkauft hat
1. Gib an **wie viele Kopien** der Bücher, welche _zwischen den Jahren 1990 & 2000_ veröffentlicht wurden, abgesetzt wurden
1. Gib das an welches Buch das **älteste** ist und wann es veröffentlicht wurde
1. Gib an, in welchem Jahr **zuletzt** ein Buch veröffentlicht wurde

## Evaluation Lernende

Peer-to-Peer Austausch zwischen den Lernenden (z.B. Tischnachbarn oder in Kleingruppen) 

## Benötigte Software

aktuelles Eclipse + JDK17

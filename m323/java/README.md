# Beispiele
## Inhalt
- e001:Demonstriert den Unterschied zwischen dem **Imperativen** (WAS und WIE) und dem **Deklarativen** (WAS und nicht WIE) Progammier-Paradigma.
- e002: Übersicht Externe und Interne Iterationen, **Consumer**, **Lambda Expressions**, Funktionen höherer Ordnung.
- e003: Demonstriert den Unterschied zwischen dem **Imperativen** und **Funktionalen** Programmier Paradigma. Zusätzlich werden **mutable** und **immutable** Listen gezeigt. 
- e004: Demonstriert die Anwendung von **Streams** (filter, map, reduce) und IntStreams (mapToInt, sum, max, min etc.)
- e005 **Lazy Evaluation**

## Setup des Projekts
### Setup Git Repositoy
1. Installiere [Git](https://git-scm.com/).
1. Starte die git bash shell.
1. Kreiere dein Arbeitsverzeichnis.
1. Wechsle in dein Arbeitsverzeichnis.
1. Klone das Repository.
```Bash
git clone https://github.com/atravanov/ifz2126-git.git
```

### Import des example Projekts nach Eclipse 
1. File -> Import -> Existing Maven Projects -> Next
1. Selektiere das Root Verzeichnis des Projekts example (beinhaltet die Datei pom.xml) -> Finish

### Aktualisierung des Repository
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

aktuelles Eclipse + JDK17 + Zeal

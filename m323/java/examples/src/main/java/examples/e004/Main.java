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


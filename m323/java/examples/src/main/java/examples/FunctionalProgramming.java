package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalProgramming {

	public static void main(String[] args) {
		example_1();
//		example_2();
//		example_3();
//		example_4();
//		example_5();
	}

	private static void example_1() {
		Thread th = new Thread(new Runnable() {
			public void run() {
				System.out.println("In another thread");
			}
		});
		th.start();

		System.out.println("In main");
	}

	private static void example_2() {
		// function has 4 things
		// 1. name - anonymous
		// 2. parameter list
		// 3. body
		// 4. return type - inferred

		Thread th = new Thread(() -> System.out.println("In another thread"));
		th.start();

		System.out.println("In main");
	}

	// From external to internal iterators
	// -----------------------------------
	private static void example_3() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//		// external iterators
//		for (int i = 0; i < numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
//
//		// external iterators also
//		for (int e : numbers) {
//			System.out.println(e);
//		}
//
//		// internal iterators
//		numbers.forEach(new Consumer<Integer>() {
//			public void accept(Integer value) {
//				System.out.println(value);
//			}
//		});
//
//		numbers.forEach((Integer value) -> System.out.println(value));
//
//		numbers.forEach((value) -> System.out.println(value));
//		// Java 8 has type inference, finally, hold your tweets, but only for
//		// lambda expressions.
//
//		numbers.forEach(value -> System.out.println(value));
//		// parenthesis is optional, but only for one parameter lambdas.

		numbers.forEach(System.out::println);
	}

	// Method references: different options
	private static void example_4() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// numbers.forEach(e -> System.out.println(e));
		// numbers.forEach(System.out::println);

		// numbers.stream()
		// // .map(e -> String.valueOf(e))
		// .map(String::valueOf)
		// .forEach(System.out::println);

		// numbers.stream()
		// .map(e -> String.valueOf(e))
		// // .map(e -> e.toString())
		// .map(String::toString)
		// .forEach(System.out::println);

		// System.out.println(
		// numbers.stream()
		// // .reduce(0, (total, e) -> Integer.sum(total, e)));
		// .reduce(0, Integer::sum));

		System.out.println(numbers.stream().map(String::valueOf)
				// .reduce("", (carry, str) -> carry.concat(str)));
				.reduce("", String::concat));
	}

	// Function composition
	private static void example_5() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// given the values, double the even numbers and total.

		int result = 0;

		for (int e : numbers) {
			if (e % 2 == 0) {
				result += e * 2;
			}
		}

		System.out.println(result);

		System.out.println(
				numbers.stream()
				.filter(e -> e % 2 == 0)
				.mapToInt(e -> e * 2)
				.sum());
	}
}

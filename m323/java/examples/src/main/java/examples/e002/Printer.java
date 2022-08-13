package examples.e002;

import java.util.function.Consumer;

public class Printer<T> implements Consumer<T> {
	@Override
	public void accept(T t) {
		System.out.println(t);
	}
}

package org.me.design.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Define a family of algorithms, encapsulate each one, and make them
 * interchangeable. Strategy lets the algorithm vary independently from clients
 * that use it.
 * 
 * @author kekannag
 *
 */
public class StrategyPatternTest {

	public static void main(String[] args) {
		System.out.println("* Define a family of algorithms, encapsulate each one, and make them\r\n"
				+ " * interchangeable. Strategy lets the algorithm vary independently from clients\r\n"
				+ " * that use it.\r\n");
		Context ctx = new Context();

		ctx.setSortingStrategy(new ShellSort());
		ctx.sort();

		ctx.setSortingStrategy(new QuickSort());
		ctx.sort();
	}

}

interface SortingStrategy {
	void sort(List<String> list);
}

class ShellSort implements SortingStrategy {

	@Override
	public void sort(List<String> list) {
		// shellSort is not implemented
		System.out.println("Shell sort used");
	}

}

class QuickSort implements SortingStrategy {

	@Override
	public void sort(List<String> list) {
		// QuickSort is not implemented
		System.out.println("Quick Sort used");
	}

}

class Context {
	private List<String> list = new ArrayList<>();
	private SortingStrategy sortingStrategy;

	public void setSortingStrategy(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}

	public void sort() {
		sortingStrategy.sort(list);
	}
}

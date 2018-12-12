package org.me.design.pattern.singleton;

/**
 * Initialization on demand holder class concept
 * 
 * using private static singleton holder class
 * 
 * @author kekannag
 *
 */
public class LazyLoadedSingletonTest {

	public static void main(String[] args) {
		LazyLoadedSingleton singleton = LazyLoadedSingleton.getInstance();
		System.out.println(singleton);
	}

}

class LazyLoadedSingleton {
	private LazyLoadedSingleton() {
	}

	private static final class LazySingletonHolder {
		private static final LazyLoadedSingleton INSTANCE = new LazyLoadedSingleton();
	}

	public final static LazyLoadedSingleton getInstance() {
		return LazySingletonHolder.INSTANCE;
	}
}
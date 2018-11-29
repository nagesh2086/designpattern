package org.me.design.pattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.naming.OperationNotSupportedException;

/**
 * Singleton pattern example with Double checked Locking
 * 
 * @author kekannag
 *
 */
public class DoubleCheckedLockingSingleton implements Serializable {
	private static volatile DoubleCheckedLockingSingleton INSTANCE;

	private DoubleCheckedLockingSingleton() throws Exception {
		if (INSTANCE != null) {
			throw new Exception("DoubleCheckedLockingSingleton -> already initialized");
		}
	}

	public static DoubleCheckedLockingSingleton getInstance() throws Exception {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				// double checking Singleton instance
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return INSTANCE;
	}

	public static void main(String... args) throws Exception {
		printHeaderOfClass();

		DoubleCheckedLockingSingleton instance1 = DoubleCheckedLockingSingleton.getInstance();
		System.out.println("instance1 -> " + instance1.hashCode());

		// Sigleton testing for reflection API
		/*
		 * DoubleCheckedLockingSingleton instance2 = null;
		 * 
		 * Constructor<?>[] declaredConstructors =
		 * DoubleCheckedLockingSingleton.class.getDeclaredConstructors(); for
		 * (Constructor<?> constructor : declaredConstructors) {
		 * constructor.setAccessible(true); Object newInstance =
		 * constructor.newInstance(args); instance2 = (DoubleCheckedLockingSingleton)
		 * newInstance; }
		 * 
		 * System.out.println("instance2 -> " + instance2.hashCode());
		 */

		// Singleton testing for serialization and de-serialization pipeline
		System.out.println("\nTesting Singleton for serialization and de-serialization pipline");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(instance1);
		oos.flush();
		oos.close();
		byte[] serBytes = baos.toByteArray();

		ByteArrayInputStream bais = new ByteArrayInputStream(serBytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		DoubleCheckedLockingSingleton o = (DoubleCheckedLockingSingleton) ois.readObject();
		ois.close();
		System.out.println("instance1 after de-ser -> " + o.hashCode());
	}

	private static void printHeaderOfClass() {
		System.out.println("* Singleton pattern example with Double checked Locking");
		final StringBuffer _buffer = new StringBuffer();
		final Random r = new Random();
		int bound = r.nextInt(10) * 10;
		for (int i = 0; i < bound; i++) {
			_buffer.append('-');
		}
		System.out.println(_buffer + "\n");
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("readResolve");
		// 1ST Way: return INSTANCE
		// return INSTANCE;
		// 2ND Way: throw exception
		throw new NotSerializableException("Singleton cannot be de-serialized and restricted");
	}
}
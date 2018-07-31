package com.justcode.breaking.singleton.bymultithreading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class BreakSingletonByMultithreading {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(BreakSingletonByMultithreading::useSingleton);
		executorService.submit(BreakSingletonByMultithreading::useSingleton);
		executorService.shutdown();
	}

	static void print(String string, Singleton singleton) {
		System.out.println(String.format("Object: %s,hashcode: %d", string, singleton.hashCode()));
	}

	static void useSingleton() {
		Singleton singleton = Singleton.getInstance();
		print("singleton", singleton);
	}
}

class Singleton implements Serializable {
	private static Singleton soleInstance = null;// we can instantiate here
													// itself and it is called
	// early or eager

	public static  Singleton getInstance() {
		if (soleInstance == null)
			soleInstance = new Singleton();
		return soleInstance;
	}

	private Singleton() {
		System.out.println("creating.....");
	}

}
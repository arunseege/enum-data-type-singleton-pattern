package com.justcode.singleton.enumway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//the most elegant and sytlish way of creating singleton --by using enum
//it  saves sigleton from reflexion,cloning,multithreading,serialization

enum Singleton{INSTANCE;
String getConfiguration(){
	return "asp get configuration";
}	
}
public class TestClass {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(TestClass::useSingleton);
		executorService.submit(TestClass::useSingleton);
		executorService.shutdown();
	}
	static void print(String string, Singleton singleton) {
		System.out.println(String.format("Object: %s,hashcode: %d", string, singleton.hashCode()));
	}

	static void useSingleton() {
		Singleton singleton = Singleton.INSTANCE;
		System.out.println(singleton.getConfiguration());
		print("singleton", singleton);
	}
}

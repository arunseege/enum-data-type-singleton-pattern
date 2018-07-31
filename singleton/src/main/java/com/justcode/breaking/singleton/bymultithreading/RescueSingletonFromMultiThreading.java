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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Hello world!
 *
 */
public class RescueSingletonFromMultiThreading 
{
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(RescueSingletonFromMultiThreading::useSingleton);
		executorService.submit(RescueSingletonFromMultiThreading::useSingleton);
		executorService.shutdown();
	}

	static void print(String string, Singletonmake singleton) {
		System.out.println(String.format("Object: %s,hashcode: %d", string, singleton.hashCode()));
	}

	static void useSingleton() {
		Singletonmake singleton = Singletonmake.getInstance();
		print("singleton", singleton);
	}
}

class Singletonmake{
	private static volatile Singletonmake soleInstance=null;//we can instantiate here itself and it is called
	private static boolean isInstanceCreated = false;		
	//early or eager
			public static  Singletonmake getInstance(){
				//Double check locking
				if(soleInstance==null){ //check 1
					synchronized (RescueSingletonFromMultiThreading.class) {
					//by the time t1 gets the lock another thread may instantiates class
						//how to avoid this?
						//add one more null check
					isInstanceCreated=true;
					if(soleInstance==null){ //check 2 this approach is called double check locking
				soleInstance = new Singletonmake();
					}
					isInstanceCreated=false;
				}
				}
				return soleInstance;
			}
			
			private Singletonmake(){
				/*if(soleInstance!=null){
					System.out.println("first fail");
					throw new RuntimeException("use getInstance() to create the instance");
				}
				else if(isInstanceCreated==false){
					System.out.println("second fail");
					throw new RuntimeException("use getInstance() to create the instance");
				}*/
				System.err.println("creating.....");
			}
			
			
			
}
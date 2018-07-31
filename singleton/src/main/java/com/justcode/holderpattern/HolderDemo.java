package com.justcode.holderpattern;

//yet another way of fight threats posed by multiple threads
public class HolderDemo {

	public static void main(String[] args) {

		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		print("singleton1",singleton1);
		print("singleton2",singleton2);
		
	}
	static void print(String string, Singleton singleton) {
		System.out.println(String.format("Object: %s,hashcode: %d", string, singleton.hashCode()));
	}

}

class Singleton{
	private Singleton(){
		System.out.println("creating....");
	}
	public static Singleton getInstance(){
		return Holder.INSTANCE;
	}
	
	static class Holder{
		static final Singleton INSTANCE = new Singleton();
	}
}
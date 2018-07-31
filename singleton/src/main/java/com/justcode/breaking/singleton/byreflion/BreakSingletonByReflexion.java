package com.justcode.breaking.singleton.byreflion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class BreakSingletonByReflexion 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Singleton s1= Singleton.getInstance();
        System.out.println("s1 hashcode==="+s1.hashCode());
        
        //break by cloning
        try {
			Class clazz = Class.forName("com.justcode.breaking.singleton.byreflion.Singleton");
			Constructor<Singleton> singleton = clazz.getDeclaredConstructor(null);
			singleton.setAccessible(true);
			Singleton s2=singleton.newInstance();
			System.out.println("s2 hashcode==="+s2.hashCode());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

class Singleton {
	private static Singleton soleInstance=null;//we can instantiate here itself and it is called
			//early or eager
			public static Singleton getInstance(){
				
				soleInstance = new Singleton();
				return soleInstance;
			}
			
			private Singleton(){
				System.err.println("creating.....");
			}
			
}
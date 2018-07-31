package com.justcode.breaking.singleton.byreflion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class RescueSingletonFromReflexion 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //make by cloning
        try {
			Class clazz = Class.forName("com.justcode.breaking.singleton.byreflion.Singletonmake");
			Constructor<Singletonmake> singleton = clazz.getDeclaredConstructor(null);
			singleton.setAccessible(true);
			Singletonmake s2=singleton.newInstance();
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
        
        Singletonmake s1= Singletonmake.getInstance();
        System.out.println("s1 hashcode==="+s1.hashCode());
        Singletonmake s3= Singletonmake.getInstance();
        System.out.println("s3 hashcode==="+s1.hashCode()); 
        
    }
}

class Singletonmake {
	private static Singletonmake soleInstance=null;//we can instantiate here itself and it is called
	private static boolean isInstanceCreated = false;		
	//early or eager
			public static Singletonmake getInstance(){
				if(soleInstance==null){
					isInstanceCreated=true;
				soleInstance = new Singletonmake();
					isInstanceCreated=false;
				}
				return soleInstance;
			}
			
			private Singletonmake(){
				if(soleInstance!=null){
					System.out.println("first fail");
					throw new RuntimeException("use getInstance() to create the instance");
				}
				else if(isInstanceCreated==false){
					System.out.println("second fail");
					throw new RuntimeException("use getInstance() to create the instance");
				}
				System.err.println("creating.....");
			}
			
}
package com.justcode.breaking.singleton.bycloneing;

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

/**
 * Hello world!
 *
 */
public class BreakSingletonByCloning 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Singleton s1= Singleton.getInstance();
        Singleton s2= Singleton.getInstance();
        System.out.println("s1 hashcode==="+s1.hashCode());
        System.out.println("s2 hashcode==="+s2.hashCode());
        
       Singleton s3 = (Singleton) s2.clone();
       System.out.println("s3 hashcode==="+s3.hashCode());
      
    }
}

class Singleton implements Cloneable {
	private static Singleton soleInstance=null;//we can instantiate here itself and it is called
			//early or eager
			public static Singleton getInstance(){
				if(soleInstance==null)
				soleInstance = new Singleton();
				return soleInstance;
			}
			
			private Singleton(){
				System.err.println("creating.....");
			}
			
			@Override
			protected Object clone() throws CloneNotSupportedException {
				// TODO Auto-generated method stub
				return super.clone();
			}
}
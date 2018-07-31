package com.justcode.breaking.singleton.byserializing;

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
public class BreakSingletonBySerializing 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Singleton s1= Singleton.getInstance();
        Singleton s2= Singleton.getInstance();
        System.out.println("s1 hashcode==="+s1.hashCode());
        System.out.println("s2 hashcode==="+s2.hashCode());
        
        try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/javabrains-videos/s2.ser"));
			oos.writeObject(s2);
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/javabrains-videos/s2.ser"));
			Singleton s3 = (Singleton)ois.readObject();
			 System.out.println("s3 hashcode==="+s3.hashCode());
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      
    }
}

class Singleton implements Serializable {
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
			
}
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
public class RescueSingletonFromCloning 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Singletonmake s1= Singletonmake.getInstance();
        Singletonmake s2= Singletonmake.getInstance();
        System.out.println("s1 hashcode==="+s1.hashCode());
        System.out.println("s2 hashcode==="+s2.hashCode());
        
        Singletonmake s3= (Singletonmake) s2.clone();
        System.out.println("s3 hashcode==="+s3.hashCode());
      
      
    }
}

class Singletonmake implements Cloneable {
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
			
			private Object readResolve(){
				System.out.println("read resolve");
				return soleInstance;
			}
			@Override
			protected Object clone() throws CloneNotSupportedException {
				throw new RuntimeException("cant clone,use getInstance() bcz it's singleton");
			}
			
}
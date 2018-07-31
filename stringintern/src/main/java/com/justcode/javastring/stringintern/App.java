package com.justcode.javastring.stringintern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String s1 = "hello";//string literals are interned by default no need to call .intern() externally
        String s2 = new String("hello").intern();
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));//equals is overriden to check content
        System.out.println(s2.hashCode());
        System.out.println(String.format("hashcode of s1 is %s and hashcode of s2 is %s",s1.hashCode(),s2.hashCode()));
    }
}

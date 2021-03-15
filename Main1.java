package com.practise;

import java.util.EnumMap;

class Abc implements Runnable
{
    public void run()
    {
        try
        {
            System.out.println (Thread.currentThread().getId());
        }
        catch (Exception e)
        {
            System.out.println ("Exception");
        }
    }
}

interface Try {
    public void getA();
}



public class Main1
{

    public static void main (String[] args)
    {
        HackClass <Integer> hackobj1 = new HackClass<Integer>(15);
        System.out.println(hackobj1.hackfunc());
        HackClass <String> hackobj2 = new HackClass<String>("Hello HackerEarth");
        System.out.println(hackobj2.hackfunc());
    }

//    enum MyFruits
//    {
//        Apple, Mango, Banana, Strawberry
//    }
//    public static void main(String[] args)
//    {
//        EnumMap<MyFruits, String> myhackobj1 = new EnumMap<>(MyFruits.class);
//        myhackobj1.put(MyFruits.Apple, "Red");
//        myhackobj1.put(MyFruits.Mango, "Green");
//        System.out.println("Set 1: " + myhackobj1);
//        EnumMap<MyFruits, String> myhackobj2 = new EnumMap<>(MyFruits.class);
//        myhackobj2.putAll(myhackobj1);
//        myhackobj2.put(MyFruits.Banana, "Yellow");
//        System.out.println("Set 2: " + myhackobj2);
//    }
}

//import java.util.*;
//import java.lang.*;
class HackClass<T>
{
    T hackobj;
    HackClass(T hackobj) { this.hackobj = hackobj; }
    public T hackfunc()
    {
        return this.hackobj;

    }
}
//public class Main
//{
//	public static void main (String[] args)
//	{
//		HackClass <Integer> hackobj1 = new HackClass<Integer>(15);
//		System.out.println(hackobj1.hackfunc());
//		HackClass <String> hackobj2 = new HackClass<String>("Hello HackerEarth");
//		System.out.println(hackobj2.hackfunc());
//	}
//}

//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//public class Main
//{
//	enum MyFruits
//	{
//	    Apple, Mango, Banana, Strawberry
//	}
//	public static void main(String[] args)
//	{
//		EnumMap<MyFruits, String> myhackobj1 = new EnumMap<>(MyFruits.class);
//		myhackobj1.put(MyFruits.Apple, "Red");
//		myhackobj1.put(MyFruits.Mango, "Green");
//		System.out.println("Set 1: " + myhackobj1);
//		EnumMap<MyFruits, String> myhackobj2 = new EnumMap<>(MyFruits.class);
//		myhackobj2.putAll(myhackobj1);
//		myhackobj2.put(MyFruits.Banana, "Yellow");
//		System.out.println("Set 2: " + myhackobj2);
//	}
//}



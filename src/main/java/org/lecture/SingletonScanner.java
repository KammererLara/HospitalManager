package org.lecture;

import java.util.Scanner;

//Lazy Initialization
public class SingletonScanner {
    private static Scanner instance;

    private SingletonScanner(){}

    public static synchronized Scanner getInstance() {
        if (instance == null)
            instance = new Scanner(System.in);
        return instance;
    }
}


//Eager Initialization
//public class SingletonScanner {
//    private final static Scanner instance = new Scanner(System.in);
//
//    private SingletonScanner(){}
//
//    public static Scanner getInstance() {
//        return instance;
//    }
//}

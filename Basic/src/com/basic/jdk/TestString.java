package com.basic.jdk;

/**
 * JDK 6 return false. JDK 7 return true. In Jdk6, will copy the string to the permanent area and
 * generate new address. so false
 * <p>
 * Created on Jan 20, 2014
 * 
 * @author Allen Yan
 */
class TestString {
    public static void main(String... args) {
        String s1 = "Good";
        s1 = s1 + "morning";
        System.out.println(s1.intern());

        String s2 = "Goodmorning";
        if (s1 == s2) {
            System.out.println("both are equal");
        }
        String a = "a";
        switch (a) {
        case "a":
            System.out.println("A");
            break;
        case "B":
            System.out.println("B");
            break;
        default:
            System.out.println("Default");
            break;
        }
    }
}
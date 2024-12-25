package org.example;

public class ReverseString {


    public static String reverseString(String a) {
        StringBuilder str = new StringBuilder(a);
        char s;

        return str.reverse().toString();
    }


}

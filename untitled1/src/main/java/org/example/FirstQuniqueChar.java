package org.example;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class FirstQuniqueChar {
    public static int firstUniqChar(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int less = s.length();
        int lessIndex = -1;
        int most = 0;
        int mostIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            int count = arr[s.charAt(i) - 'a'];
            if( count < less){
                less = count;
                lessIndex = i;
            }else if(count > most){
                most = count;
                mostIndex = i;
            }
        }
        System.out.println("Less index: " + lessIndex + ", Character: " + s.charAt(lessIndex) + ", Value: " + less);
        System.out.println("Most index: " + mostIndex + ", Character: " + s.charAt(mostIndex) + ", Value: " + most);

        return -1;
    }
    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return isPalindorme(s,start,end-1) || isPalindorme(s, start+1, end);
            }
        }
        return true;
    }
    private static boolean isPalindorme(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void findOccurence(String s) {
        int[] arr = new int[26];
        for (Character ch : s.toCharArray()) {
            arr[ch - 'a'] = arr[ch - 'a']+1;
        }
        int least = Integer.MAX_VALUE;
        char leastChar = 0;
        char highestChar = 0;
        int highest = 0;
        for (Character ch : s.toCharArray()) {
            if (arr[ch - 'a'] < least) {
                least = arr[ch - 'a'];
                leastChar = ch;
            }
            if (arr[ch - 'a'] > highest) {
                highest = arr[ch - 'a'];
                highestChar = ch;
            }
        }
        System.out.println("highest char : "+highestChar+" count : "+highest);
        System.out.println("Lessest char : "+leastChar+" count : "+least);

    }

}

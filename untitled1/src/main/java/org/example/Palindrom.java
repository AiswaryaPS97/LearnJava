package org.example;

public class Palindrom {
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int temp = x;
        int reverse = 0;
        while(temp > 0){
            int d = temp%10;
            temp = temp/10;
            reverse = (reverse*10)+d;
        }
        if(x == reverse){
            return true;
        }else{
            return false;
        }

    }
}

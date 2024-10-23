package BinarySearch;

import java.sql.SQLOutput;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char target = 'e';
        System.out.println(findLetter(letters,target));
    }
    private static char findLetter(char[] letters, char target){
        int start =0;
        int end = letters.length-1;
        if(letters[end] <= target)
            return letters[start];
        if(letters[start] > target)
            return letters[start];
        while(start <= end){
            int mid = start +(end - start)/2;
            if(mid < end && letters[mid] == target && letters[mid+1] < target )
                return letters[mid+1];
            else if( letters[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return letters[start];
    }
}



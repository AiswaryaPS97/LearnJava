package org.example;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int[] m = Arrays.stream(nums).sorted().toArray();
        int size = nums.length;
        int newSize = 0;
        for(int i=1; i< size; i++){
            if(nums[newSize] != nums[i]){
                newSize++;
                nums[newSize] = nums[i];
            }
        }
        String a;
        StringBuilder b;
        b.
        return newSize;
    }
}

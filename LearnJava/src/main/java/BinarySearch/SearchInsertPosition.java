package BinarySearch;

import java.util.Scanner;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the
 * index where it would be if it were inserted in order.
 * <a href="https://leetcode.com/problems/search-insert-position/description/">...</a>
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i=0 ; i< n ; i++){
            nums[i] = s.nextInt();
        }
        int target = s.nextInt();
        System.out.println(findPosition(nums,target));
    }

    private static int findPosition(int[] nums, int target){
        int start =0;
        int end = nums.length;
        while( start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid -1;
        }
        return start;
    }


}

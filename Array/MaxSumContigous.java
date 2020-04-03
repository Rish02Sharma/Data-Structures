package Array;

import java.util.*;

public class MaxSumContigous{

    //Best method to solve this is KADANE ALGORITHM which solves this in o(n) time
    static int maxSum(int[] nums){
        int localSum = nums[0] , globalSum = nums[0];
        
        for(int i=1; i< nums.length; i++){
            localSum = Math.max(nums[i], localSum + nums[i]);
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }

    public static void main(String args[]){
        int[] nums = new int[5];
        maxSum(nums);
    }

}
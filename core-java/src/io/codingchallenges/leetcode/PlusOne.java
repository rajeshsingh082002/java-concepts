package io.codingchallenges.leetcode;

import java.util.Arrays;

/**
 * @author rajesh
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 *  Example 2:
 * * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

public class PlusOne {
    public static void main(String[] args) {
     int[] input = {4,3,9,9}  ;
        System.out.println(Arrays.toString(plusOne(input)));
    }

    public static int[] plusOne(int[] numbers){

        for(int i = numbers.length-1 ; i>=0;i--){
            if(numbers[i] < 9){
                numbers[i] = numbers[i] + 1;
                return numbers;
            }
                numbers[i]=0;
        }

        int[] newArray = new int[numbers.length+1];
        newArray[0] = 1;
        return newArray;
    }
}

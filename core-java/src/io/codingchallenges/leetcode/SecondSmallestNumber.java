package io.codingchallenges.leetcode;

public class SecondSmallestNumber {
    public static void main(String[] args) {
        int[] numbers = {4,5,2,8,5,6,3};

        System.out.println("Second Smallest Number is  = " + getSecondSmallestNumber(numbers));

    }

    private  static int getSecondSmallestNumber(int[] numbers){
        int smallestNumber = Integer.MAX_VALUE;
        int secondSmallestNumber = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (smallestNumber > number) {
                secondSmallestNumber = smallestNumber;
                smallestNumber = number;
            }
            if (secondSmallestNumber > number && smallestNumber != number) {
                secondSmallestNumber = number;
            }
        }

        return secondSmallestNumber;


    }
}

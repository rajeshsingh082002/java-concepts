package io.codingchallenges.leetcode;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1456;
        int reverseNumber = 0;
        System.out.println("num="+num );
        while(num> 0){
            reverseNumber = reverseNumber*10 + num%10;
            num=num/10;
        }
        System.out.println("reverse is="+reverseNumber);
    }
}

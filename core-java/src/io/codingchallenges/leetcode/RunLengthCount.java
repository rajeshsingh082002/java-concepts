package io.codingchallenges.leetcode;

public class RunLengthCount {
    public static void main(String[] args) {
         String input = "aaabbbaacc";
        RLE(input);

    }

    private static void RLE(String test){
        int count;
        int length = test.length();
        for (int i = 0 ; i < length; i++){
            count=1;
                while ( i < length-1 && test.charAt(i) == test.charAt(i+1)){
                    count++;
                    i++;
                }
            System.out.print(String.valueOf(test.charAt(i)) + count);
        }


    }
}

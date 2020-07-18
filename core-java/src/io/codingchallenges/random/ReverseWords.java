package io.codingchallenges.random;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        String input = "   the sky    is blue   ";
        System.out.println("input =" +input);
        System.out.println("reverse word ="+ reverseWords(input));
    }

    public static String reverseWords(String s){
        int i = 0;
        int j = 0;
        int n = s.length();
        String word = "";
        String reversedWrords = "";



        while(i < n) {
            while ( i < n && s.charAt(i) == ' ') {
                i++;
            }
            if(i > n-1){
                break;
            }
            j = i+1;
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }


            word = s.substring(i, j);
           i=j+1;
           if(reversedWrords.length()==0){
               reversedWrords = word;
           } else {
               reversedWrords = word + " "+reversedWrords;
           }

        }

        return reversedWrords;
    }
}

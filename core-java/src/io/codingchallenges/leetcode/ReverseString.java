package io.codingchallenges.leetcode;

public class ReverseString {

	public static void main(String[] args) {
		String input = "Hello";
		System.out.println("Reverse of " + input + "is " + reverseString(input.toCharArray())) ;
	}
	
	public static char[] reverseString(char[] s) {
		
		int i = 0;
		int j = s.length-1;
		char c = '\0';
		while(i < j) {
			c = s[i];
			s[i] = s[j] ;
			s[j] = c;
			
		}
		return s;
	}

}

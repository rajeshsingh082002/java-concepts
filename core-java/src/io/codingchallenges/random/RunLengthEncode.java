package io.codingchallenges.random;

/**
 * @author rajesh
 *	Given an input string, write a function that returns the Run Length Encoded string for the input string.
 *
	For example, if the input string is “aaabbbaacc”, then the function should return “a3b3a2c2”.
 */

public class RunLengthEncode {

	public static void main(String[] args) {
		String input = "aaabbbaacc";
		RLE(input);
	}

	public static void RLE(String input) {
		int count;
		int n = input.length();
		
		for(int i = 0; i < n ; i++) {
			count = 1;
			while(i < n-1 && input.charAt(i) == input.charAt(i+1)) {
				count++;
				i++;
			}
			System.out.print(String.valueOf(input.charAt(i)) + count);
		}
		
	}
}

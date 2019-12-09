package io.codingchallenges.random;

public class SecondLargestNumberInArray {

	public static void main(String[] args) {
		int[] test = {4,5,2,8,5,6};
		int largest = 0;
		int secondLargest = 0;
		largest = secondLargest= 0;
		for (int i = 0; i < test.length; i++) {
			
			if(largest < test[i]) {
				secondLargest = largest;
				largest = test[i];
			}
			
			if(secondLargest < test[i] && test[i]!= largest) {
				secondLargest = test[i];
			}
		}
		System.out.println("largest: "+largest +" secondLargest"+secondLargest);
	}

}

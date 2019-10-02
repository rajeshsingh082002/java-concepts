package io.algo.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] sample = {7,4,3,9,1,78,34};
		int temp;
		boolean isSwapped = true;
		
			while(isSwapped) {
			isSwapped = false;
			
			for(int i =0 ; i < sample.length-1; i++) {
			
				if(sample[i] > sample[i+1]) {
					temp = sample[i];
					sample[i] = sample[i+1];
					sample[i+1] =temp;
					isSwapped =true;
					
				}
				System.out.println(Arrays.toString(sample));
			}
			
		}
		
	}

}

package io.algo.sorting;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		
		int[] sample = {7,4,3,9,1,78,34};
		insertSort(sample);
		System.out.println(Arrays.toString(sample));

	}
	
	private static int [] insertSort(int[] sample) {
		
		int temp,key,j;
			
		for(int i =1; i < sample.length; i++) {
			j=i;
			key = sample[j];
			while( j > 0 &&  key < sample[j-1]) {
					temp = sample[j];
					sample[j] = sample[j-1];
					sample[j-1] = temp;
					
				j--;
			}
			
		}
		
		return sample;
	}
	
	private static int [] insertSort1(int[] sample) {
		
		int temp,k,j;
		
		for(int i =1; i < sample.length; i++) {
			j=i;
			while( j > 0 && j<sample.length) {
				if(sample[j] < sample[j-1]) {
					temp = sample[j];
					sample[j] = sample[j-1];
					sample[j-1] = temp;
					
				}
				j--;
			}
			
		}
		
		return sample;
	}

}

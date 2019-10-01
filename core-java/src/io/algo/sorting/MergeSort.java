package io.algo.sorting;

import java.util.Arrays;

/**
 * Merge Sort Using recursion.
 * @author rajesh
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] sample = {7,4,3,9,1,78,34};
	//	int[] left = {4,5,7};
	//	int[] right = {8,9};
		System.out.println(" Array"+ Arrays.toString(sample));
		System.out.println(" Sorted Array"+ Arrays.toString(sort(sample)));
	}
	
	private  static int[] sort(int[] array) {
		if(array.length ==1 ) {
			return array;
		}
		int mid = array.length/2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
		int counter = 0;
		for(int i = 0; i < mid; i++) {
			left[counter++] = array[i];
		}
		counter =0;
		for(int i = mid; i < array.length; i++) {
			right[counter++] = array[i];
		}
		
		left = sort(left);
		right = sort(right);
		return merge(left,right);
		
	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0 ;
		int rightIndex = 0 ;
		int resultIndex = 0;
		while(leftIndex < left.length || rightIndex < right.length) {
			if(leftIndex < left.length && rightIndex < right.length) {
				if(left[leftIndex] <= right[rightIndex]) {
					result[resultIndex++] = left[leftIndex++];
				} else {
					result[resultIndex++] = right[rightIndex++];
				}
				
			} else if(leftIndex < left.length) {
				result[resultIndex++] = left[leftIndex++];
			} else if( rightIndex < right.length) {
				result[resultIndex++] =  right[rightIndex++];
			}
			
		}
		return result;
	}

}

package io.algo.sorting;

import java.util.Arrays;
/**
 * Program showing Binary Search using recursion. Sorted Data is pre-requisite  for Binary search.
 * It uses merge sort to sort data before performing binary search
 * @author rajesh
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
			int[] sample = {7,4,3,9,1,78,34};
//			int[] left = {2,4,6,8};
//			int[] right = {1,3,5,7,9,10};
//			int[] result = merge(left,right);
			int[] result = sort(sample);
			System.out.println(Arrays.toString(result));
			
			binarySearch(result, 50);
		
	}
	
	private static void binarySearch(int[] sample, int target ) {
		int mid = sample.length/2;
		int[] reducedSample;
		int index = 0;
		if(target == sample[mid]) {
			System.out.println(target +" is presnt ");
			return ;
		} else if(sample.length == 1) {
			System.out.println(target +" is Not presnt ");
			return;
		}
		if(target < sample[mid]) {
			reducedSample = new int[mid];
			for(int i=0; i< mid ; i++) {
				reducedSample[index++] = sample[i];
			}
		} else {
			reducedSample = new int[sample.length - mid];
			for (int i = mid; i < sample.length; i++) {
				reducedSample[index++] = sample[i];
			}
		}
		 binarySearch(reducedSample, target);
	}
	
	private static int[]  sort(int[] sample) {
		if(sample.length ==1 ) {
			return sample;
		}
		int sampleSize = sample.length;
		int mid = sampleSize/2;
		
		int[] left = new int[mid];
		int[] right = new int[sampleSize - mid];
		int leftIndex = 0;
		int rightIndex = 0;
		
		for(int i =0 ; i < mid; i++) {
			left[leftIndex++] = sample[i];
		}
		for(int i = mid ; i < sampleSize; i++) {
			right[rightIndex++] = sample[i];
		}
		left = sort(left);
		right = sort(right);
		return merge(left,right);
	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] result =  new int[left.length + right.length];
		int resultIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		int leftLenght = left.length;
		int rightLength = right.length;
		while(leftIndex < leftLenght || rightIndex < rightLength) {
			if(leftIndex < leftLenght && rightIndex < rightLength) {
				if(left[leftIndex] < right[rightIndex]) {
					result[resultIndex++] = left[leftIndex++];
				} else {
					result[resultIndex++] = right[rightIndex++];
				}
			} else if(leftIndex < leftLenght) {
				result[resultIndex++] = left[leftIndex++];
			}else if(rightIndex < rightLength) {
				result[resultIndex++] = right[rightIndex++];
			}
		}
		return result;
		
	}
	
}

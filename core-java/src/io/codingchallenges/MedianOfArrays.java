package io.codingchallenges;

import java.util.Arrays;

/**
 * Median of Sorted Array
 * @author rajesh
 *
 */
public class MedianOfArrays {

	public static void main(String[] args) {
		int[] array1 = {4,5,7,10};
		int[] array2 = {3,8,9};
		System.out.println("Median : "+Median(array1, array2));
	
	}
	
	private static double Median(int[] array1 , int[] array2) {
		double med = 0.0;
		int[] result = new int[array1.length+array2.length];
		int array1Index = 0;
		int array2Index = 0;
		int resultIndex = 0;
		
		while(array1Index < array1.length || array2Index < array2.length){
			if(array1Index < array1.length && array2Index < array2.length) {
				if(array1[array1Index] <= array2[array2Index]) {
					result[resultIndex++] = array1[array1Index++];
				} else {
					result[resultIndex++] = array2[array2Index++];
				}
			} else if(array1Index < array1.length ) {
				result[resultIndex++] = array1[array1Index++];
			} else if(array2Index < array2.length) {
				result[resultIndex++] = array2[array2Index++];
			}
		}
		System.out.println("Merged Array "+ Arrays.toString(result));
		if (result.length % 2 !=0 ) {
			med = result[(result.length/2)];
		} else {
			med =  (Double.valueOf(result[result.length/2]) + Double.valueOf(result[result.length/2 -1]))/2;
		}
		return  med;
		
	}
}

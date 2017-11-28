package section2.radixsort;

import java.util.stream.IntStream;

public class RadixSort {
	public int[] radixSort(int[] arr, int digitNumbers) {
		for(int i = digitNumbers - 1; i >= 0 ; i--) {
			arr = countingSortByDigit(arr, i);
		}
		return arr;
	}
	
	public int[] countingSortByDigit(int[] arr, int digit) {
		int[] countByNumber = new int[10];
		int[] result = new int[arr.length];
		
		for(int num : arr) {
			int digitNumber = getDigitNumber(num, digit);
			countByNumber[digitNumber]++;
		}
		
		for(int i = 1 ; i < 10 ; i++) {
			countByNumber[i] = countByNumber[i] + countByNumber[i - 1];
		}
		
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			result[countByNumber[getDigitNumber(arr[i], digit)] - 1] = arr[i];
			countByNumber[getDigitNumber(arr[i], digit)]--;
		}
		return result;
	}
	
	public int getDigitNumber(int number, int digit) {
		return Character.getNumericValue(String.valueOf(number).toCharArray()[digit]);
	}
	
	public boolean isSorted(int[] arr) {
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i] < arr[i-1]) {
				return false;
			}
		}
		return true;
	}
}

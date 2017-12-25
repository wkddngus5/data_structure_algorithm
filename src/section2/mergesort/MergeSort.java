package section2.mergesort;

public class MergeSort {
	
	public void mergeSort(int[] arr, int front, int back) {
		if(front < back) {
			int middle = front + (back - front) / 2;
			mergeSort(arr, front, middle);
			mergeSort(arr, middle + 1, back);
			merge(arr, front, middle, back);
		}
	}
	
	public void merge(int[] arr, 
			int firstBegin, int firstLast, int secondLast) {
		int[] bufferArr = new int[arr.length];
		
		System.arraycopy(arr, firstBegin, 
				bufferArr, firstBegin, secondLast - firstBegin + 1);
		
		int arr1Idx = firstBegin;
		int arr2Idx = firstLast + 1;
		
		for(int i = firstBegin ; i <= secondLast ; i++) {
			if(arr1Idx > firstLast) {
				arr[i] = bufferArr[arr2Idx++];
			} else if(arr2Idx > secondLast) {
				arr[i] = bufferArr[arr1Idx++];
			} else if(bufferArr[arr1Idx] < bufferArr[arr2Idx]) {
				arr[i] = bufferArr[arr1Idx++];
			} else {
				arr[i] = bufferArr[arr2Idx++];
			}
		}
	}
}

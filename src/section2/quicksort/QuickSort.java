package section2.quicksort;

public class QuickSort {
//	1. partiotion() 함수 구현
	public int partition(int[] array, int start, int end) {
		int nowIdx = start;
		int smallLastIdx = start - 1;
		int pivot = array[end];
		
		// partition을 실행할 가장 앞 부분부터 끝까지 하나씩 비교해가면서
		// pivot보다 작으면 작은수들의 배열 가장 뒤에 추가하고
		// pivot보다 크면 그냥 넘어간다
		while(nowIdx < end) {
			if(array[nowIdx] < pivot) {
				swap(array, ++smallLastIdx, nowIdx);
			}
			nowIdx++;
		}
		
		//마지막에 pivot과 작은수 배열 다음과 swap
		swap(array, smallLastIdx + 1, end);
		return smallLastIdx + 1;
	}
	
//	2. quickSort() 함수 구현
	public void quickSort(int[] array, int start, int end) {
		if(start < end) {
			int pivotIdx = partition(array, start, end);
			//partition한 앞부분과 뒷부분을 다시 재귀적으로 partition
			quickSort(array, start, pivotIdx - 1);
			quickSort(array, pivotIdx + 1, end);
		}
	}
	
	public void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}
	
	public void print(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

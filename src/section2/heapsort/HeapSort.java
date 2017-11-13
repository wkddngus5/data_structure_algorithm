package section2.heapsort;

public class HeapSort {
	MaxHeapify maxHeapify = new MaxHeapify();
	
	//5. buildMaxHeap 함수 구현
	public void buildMaxHeap(int[] array) {
		for(int i = array.length ; i > 0 ; i--) {
			maxHeapify.maxHeapify(array, i);
		}
	}
	
	//6. heapSort() 함수 구현
	public void heapSort(int[] array) {
		buildMaxHeap(array);
		for(int i = array.length - 1 ; i > 1 ;) {
			maxHeapify.exchange(array, 1, i--);
			maxHeapify.maxHeapify(array, 1, i);
		}
	}
}

package section2.heapsort;

import java.util.Random;

public class MaxHeapify {
	//1. max_heapify() 함수 구현
	public void maxHeapify(int[] maxHeap, int rootIdx) {
		int leftIdx = rootIdx * 2;	//left child index는 parent index * 2 + 1
		int rightIdx = leftIdx + 1;	//right child index는 left child + 1
		int largest = rootIdx;
		
		//heap의 크기 내에 있는 left child가 parent보다 크다면 largest는 left child
		if(leftIdx < maxHeap.length && maxHeap[leftIdx] > maxHeap[rootIdx]) {
			largest = leftIdx;
		} else {
			largest = rootIdx;
		}
		
		//heap의 크기 내에 있는 right child가 parent보다 크다면 largest는 right child
		if(rightIdx < maxHeap.length && maxHeap[rightIdx] > maxHeap[largest]) {
			largest = rightIdx;
		}
		
		//largest가 갱신되면 parent와 largest의 자리를 바꿔주고 largest를 root로 하는 maxHeap을 재귀적으로 호출하여 sort.
		if(largest != rootIdx) {
			exchange(maxHeap, largest, rootIdx);
			maxHeapify(maxHeap, largest);
		}
	}
	
	//endIdx가 있는 max_heapify() 함수(공간복잡도를 늘리지 않고 heapSort하기 위해)
	public void maxHeapify(int[] maxHeap, int rootIdx, int endIdx) {
		int leftIdx = rootIdx * 2;	//left child index는 parent index * 2 + 1
		int rightIdx = leftIdx + 1;	//right child index는 left child + 1
		int largest = rootIdx;
		
		//endIdx범위 내에 있는 left child가 parent보다 크다면 largest는 left child
		if(leftIdx < endIdx + 1 && maxHeap[leftIdx] > maxHeap[rootIdx]) {
			largest = leftIdx;
		} else {
			largest = rootIdx;
		}
		
		//endIdx범위 내에 있는 right child가 parent보다 크다면 largest는 right child
		if(rightIdx < endIdx + 1 && maxHeap[rightIdx] > maxHeap[largest]) {
			largest = rightIdx;
		}
		
		//largest가 갱신되면 parent와 largest의 자리를 바꿔주고 largest를 root로 하는 maxHeap을 재귀적으로 호출하여 sort.
		if(largest != rootIdx) {
			exchange(maxHeap, largest, rootIdx);
			maxHeapify(maxHeap, largest, endIdx);
		}
	}
	
	//1-1. 두 원소 위치 변경 
	public void exchange(int[] maxHeap, int idx1, int idx2) {
		int tmp = maxHeap[idx1];
		maxHeap[idx1] = maxHeap[idx2];
		maxHeap[idx2] = tmp;
	}
}

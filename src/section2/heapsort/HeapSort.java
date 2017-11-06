package section2.heapsort;

import java.util.Random;

//heap sort: heap 자료 구조를 사용하여 정렬하는 알고리즘
//Max heap:각 노드의 값이 children의 값보다 크거나 같은 complete binary tree이다.
//time complexity: O(nlgn)
//in-place algorithm: O(1)

public class HeapSort {
	Random generator = new Random();
	
	//1. max_heapify() 함수 구현
	public void maxHeapify(int[] maxHeap, int rootIdx) {
		int leftIdx = rootIdx * 2 + 1;	//left child index는 parent index * 2 + 1
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
	
	//1-1. 두 원소 위치 변경 
	public void exchange(int[] maxHeap, int idx1, int idx2) {
		int tmp = maxHeap[idx1];
		maxHeap[idx1] = maxHeap[idx2];
		maxHeap[idx2] = tmp;
	}
	
	
	//3. makeSampleHeap() 함수 구현
	public int[] makeSampleHeap(int n) {
		int[] heap = new int[n];
		int nowIdx = 0;
		
		//큰 이유는 없고 적당한 root 값을 만들기 위해 만든 값
		//+보충) height하나당 최대 10씩 감소하기 때문에 음수가 나오지 않으면서 너무 크지 않은 적당한 값
		int seed = (int) ((Math.log(n) / Math.log(2)) + 1) * 10;	 
		makeSubHeap(heap, nowIdx, seed);	//재귀적으로 subHeap을 만들어줌
		return heap;
	}
	
	//3-1. makeSampleHeap() 함수를 보조하는 sub-heap생성 함수
	public void makeSubHeap(int[] heap, int nowIdx, int max) {
		heap[nowIdx] = max - (generator.nextInt(10) + 1);	//paraent node값에서 1이상의 random값을 빼줌
		int leftIdx = nowIdx * 2 + 1;
		int rightIdx = leftIdx + 1;
		
		if(leftIdx < heap.length) {	//leftIdx와 rightIdx값이 heap안의 유효한 값이면 sub-heap생성
			makeSubHeap(heap, leftIdx, heap[nowIdx]);
			if(rightIdx < heap.length) {
				makeSubHeap(heap, rightIdx, heap[nowIdx]);
			}
		}
	}
	
	//4. isMaxHeap() 함수 구현
	public boolean isMaxHeap(int[] heap) {
		int parentIdx = 0;
		for(int i = 0 ; i < heap.length ; i++) {
			parentIdx = (i - 1) / 2;
			if(parentIdx >= 0) {
				if(heap[parentIdx] < heap[i]) {	//parent value가 child value보다 작으면 유효하지 않음
					System.out.println("parent value is " + heap[parentIdx] + " child is " + heap[i]);
					return false;
				}
			}
		}
		return true;
	}
	
	
	//5. printHeap() 함수 구현
	public void print(int[] maxHeap) {
		for(int i : maxHeap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

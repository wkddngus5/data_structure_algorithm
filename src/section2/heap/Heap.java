package section2.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	int size = 0;
	List<Integer> elements = new ArrayList<Integer>();
	
	public Heap(int[] array) {
		size = array.length;
		for(int element : array) {
			elements.add(element);
		}
	}
	
	// 1. Max heap에서 최대값 제거 함수
	public int deleteMax() {
		int max = elements.get(1);
		swap(1, this.size - 1);	//max element와 마지막 element swap 
		elements.remove(size - 1);
		size--;
		maxHeapify(this, 1);		//마지막 element가 root가 되었기 때문에 heapify로 재정렬
		return max;
	}
	
	// 2. Max heap에 새로운 값 추가 함수
	public void maxHeapInsert(int key) {
		size++;
		elements.add(Integer.MIN_VALUE);
		heapIncreaseKey(size - 1, key);
	}
	
	// 2-1.Max-Heap에서 값 증가
	public void heapIncreaseKey(int index, int key) {
		if(key < elements.get(index)) {
			System.err.println("new key is smaller than current key");
		}
		elements.set(index, key);
		int parentIndex = index / 2;
		while(index > 1 && elements.get(parentIndex) < elements.get(index)) {
			swap(parentIndex, index);
			index = parentIndex;
			parentIndex = index / 2;
		}
	}
	
	public void swap(int idx1, int idx2) {
		int tmp = elements.get(idx1);
		elements.set(idx1, elements.get(idx2));
		elements.set(idx2, tmp);
	}
	
	public void maxHeapify(Heap maxHeap, int rootIdx) {
		int leftIdx = rootIdx * 2;
		int rightIdx = leftIdx + 1;			
		int largest = rootIdx;
		
		if(leftIdx < maxHeap.size && maxHeap.elements.get(leftIdx) > maxHeap.elements.get(rootIdx)) {
			largest = leftIdx;
		} else {
			largest = rootIdx;
		}
		
		if(rightIdx < maxHeap.size && maxHeap.elements.get(rightIdx) > maxHeap.elements.get(largest)) {
			largest = rightIdx;
		}
		
		if(largest != rootIdx) {
			swap(largest, rootIdx);
			maxHeapify(maxHeap, largest);
		}
	}
	
	public boolean isMaxHeap() {
		int parentIdx = 1;
		for (int i = 2; i < size; i++) {
			parentIdx = i / 2;
			if (parentIdx >= 0) {
				if (elements.get(parentIdx) < elements.get(i)) {
					System.err.println("parent value is " + elements.get(parentIdx) 
					+ ". child is " + elements.get(i));
					return false;
				}
			}
		}
		return true;
	}
	
	public void print() {
		for (int i : elements) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

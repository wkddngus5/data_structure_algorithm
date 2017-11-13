package section2.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import section2.heapsort.HeapUtils;

public class HeapTest {
	Heap heap;

	@Test
	public void deleteMax() {
		heap = new Heap(HeapUtils.makeSampleHeap(11));
		heap.print();
		int max = heap.elements.get(1);
		assertEquals(max, heap.deleteMax());
		assertEquals(true, heap.isMaxHeap());
	}
	
	@Test
	public void heapIncreaseKey() {
		heap = new Heap(HeapUtils.makeSampleHeap(10));
		heap.print();
		heap.heapIncreaseKey(9, 40);
		heap.print();
		assertEquals(true, heap.isMaxHeap());
	}
	
	@Test
	public void maxHeapInsert() {
		heap = new Heap(HeapUtils.makeSampleHeap(14));
		heap.print();
		heap.maxHeapInsert(33);
		heap.print();
	}
}

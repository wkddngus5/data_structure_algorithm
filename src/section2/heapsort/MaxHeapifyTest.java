package section2.heapsort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxHeapifyTest {
	MaxHeapify heapSort;

	@Before
	public void init() {
		heapSort = new MaxHeapify();
	}

	@Test
	public void exchange() {
		int[] maxHeap = {-1, 4, 14, 7, 2, 8, 1};
		heapSort.exchange(maxHeap, 1, 3);
		assertEquals(7, maxHeap[1]);
		assertEquals(4, maxHeap[3]);
	}
	
	//2. test_heapify() 함수 구현
	@Test
	public void maxHeapify() {
		int[] maxHeap = {-1, 4, 14, 7, 2, 8, 1};
		heapSort.maxHeapify(maxHeap, 1);
		assertEquals(14, maxHeap[1]);
		assertEquals(8, maxHeap[2]);
		assertEquals(7, maxHeap[3]);
		assertEquals(2, maxHeap[4]);
		assertEquals(4, maxHeap[5]);
		assertEquals(1, maxHeap[6]);
	}
	
	@Test
	public void makeSampleHeap() {
		heapSort.print(heapSort.makeSampleHeap(10));
	}
	
	@Test
	public void isMaxHeap_validate() {
		int[] maxHeap = heapSort.makeSampleHeap(10); 
		assertEquals(true, heapSort.isMaxHeap(maxHeap));
	}
	
	@Test
	public void isMaxHeap_not_validate() {
		int[] maxHeap = heapSort.makeSampleHeap(10); 
		maxHeap[1] = 1;
		assertEquals(false, heapSort.isMaxHeap(maxHeap));
	}
}

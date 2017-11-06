package section2.heapsort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {
	HeapSort heapSort;

	@Before
	public void init() {
		heapSort = new HeapSort();
	}

	@Test
	public void exchange() {
		int[] maxHeap = {4, 14, 7, 2, 8, 1};
		heapSort.exchange(maxHeap, 0, 2);
		assertEquals(7, maxHeap[0]);
		assertEquals(4, maxHeap[2]);
	}
	
	//2. test_heapify() 함수 구현
	@Test
	public void maxHeapify() {
		int[] maxHeap = {4, 14, 7, 2, 8, 1};
		heapSort.maxHeapify(maxHeap, 0);
		assertEquals(14, maxHeap[0]);
		assertEquals(8, maxHeap[1]);
		assertEquals(7, maxHeap[2]);
		assertEquals(2, maxHeap[3]);
		assertEquals(4, maxHeap[4]);
		assertEquals(1, maxHeap[5]);
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
		maxHeap[0] = 1;
		assertEquals(false, heapSort.isMaxHeap(maxHeap));
	}
}

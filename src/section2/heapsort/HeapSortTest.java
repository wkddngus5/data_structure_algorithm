package section2.heapsort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {
	HeapSort heapSort;
	int[] array = {-1, 2, 3, 4, 5, 6, 7, 8};
	
	@Before
	public void init() {
		heapSort = new HeapSort();
	}

	@Test
	public void buildMaxHeap() {
		heapSort.buildMaxHeap(array);
		assertEquals(8, array[1]);
		assertEquals(6, array[2]);
		assertEquals(7, array[3]);
		assertEquals(5, array[4]);
		assertEquals(3, array[5]);
		assertEquals(2, array[6]);
		assertEquals(4, array[7]);
	}
	
	@Test
	public void heapSort() {
		heapSort.heapSort(array);
		assertEquals(2, array[1]);
		assertEquals(3, array[2]);
		assertEquals(4, array[3]);
		assertEquals(5, array[4]);
		assertEquals(6, array[5]);
		assertEquals(7, array[6]);
		assertEquals(8, array[7]);
	}
}

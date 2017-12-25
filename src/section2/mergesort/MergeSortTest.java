package section2.mergesort;

import static org.junit.Assert.*;

import org.junit.Test;

import section2.Utils;

public class MergeSortTest {
	MergeSort mergeSort = new MergeSort();
	int[] arr = {5, 1, 9, 3, 0, 2, 4, 5};

	@Test
	public void test() {
		mergeSort.mergeSort(arr, 0, 7);
		assertEquals(true, Utils.isSorted(arr));
	}

}

package section2.insertionsort;

import static org.junit.Assert.*;

import org.junit.Test;

import section2.Utils;

public class InsertionSortTest {
	InsertionSort insertionSort = new InsertionSort();
	
	int[] array = {2, 8, 7, 1, 3, 5, 6, 4};

	@Test
	public void test() {
		insertionSort.insertionSort(array);
		assertEquals(true, Utils.isSorted(array));
	}

}

package section2.quicksort;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {
	QuickSort quickSort = new QuickSort();
	int[] array = {2, 8, 7, 1, 3, 5, 6, 4};
	
	@Test
	public void partition() {
		assertEquals(3, quickSort.partition(array, 0, 7));
		quickSort.print(array);
	}
	
	@Test
	public void quickSort() {
		quickSort.quickSort(array, 0, array.length - 1);
		quickSort.print(array);
	}

}

package section2.radixsort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RadixSortTest {
	int[] element10 = {133, 252, 316, 231, 820, 712, 522, 154, 792, 119};
	RadixSort radixSort;
	
	@Before
	public void init() {
		radixSort = new RadixSort();
	}


	@Test
	public void countingSortByDigit() {
		int[] arr = radixSort.countingSortByDigit(element10, 2);
		
		for(int num : arr) {
			System.out.print(num + "   ");
		}
	}
	
	@Test
	public void radixSort() {
		int[] arr = radixSort.radixSort(element10, 3);
		
		assertEquals(true, radixSort.isSorted(arr));
	}
}

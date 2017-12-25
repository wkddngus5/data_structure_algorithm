package section2.countingsort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import section2.Utils;

public class CountingSortTest {

	CountingSort countingSort;
	int[] element0 = {};
	int[] element1 = {13};
	int[] element20 = {13, 3, 25, 20, 3, 16, 23, 18, 20, 7, 12, 5, 22, 15, 4, 7, 9, 2, 11, 19};

	
	@Before
	public void init() {
		countingSort = new CountingSort();
	}
	
	@Test
	public void test20() {
		int[] result = countingSort.countingSort(element20, 100);
		assertEquals(true, Utils.isSorted(result));
	}
	
	@Test
	public void test1() {
		int[] result = countingSort.countingSort(element1, 100);
		assertEquals(true, Utils.isSorted(result));
	}
	
	@Test
	public void test0() {
		int[] result = countingSort.countingSort(element0, 100);
		assertEquals(true, Utils.isSorted(result));
	}
}

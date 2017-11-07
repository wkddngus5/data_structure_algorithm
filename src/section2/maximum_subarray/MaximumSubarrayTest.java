package section2.maximum_subarray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaximumSubarrayTest {
	int[] testData = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
	int[] testData2 = {-3, -5, -2, -3};
	
	int[] element0 = {};
	int[] element1 = {5};
	int[] element2 = {9, 2};
	int[] element4 = {3, 5, 9, 8};
	int[] element20 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, 9, -2, 11, -19};
	
	MaximumSubarray ms;
	
	@Before
	public void init() {
		ms = new MaximumSubarray();
	}

	@Test
	public void findMaxBasicMethod_valid() {
		ReturnData rd = ms.findMaxBasicMethod(testData);
		assertEquals(7, rd.getStartIdx());
		assertEquals(10, rd.getEndIdx());
		assertEquals(43, rd.getValue());
	}
	
	@Test
	public void findMaxBasicMethod_unValid() {
		ReturnData rd = ms.findMaxBasicMethod(testData2);
		assertEquals(0, rd.getStartIdx());
		assertEquals(-1, rd.getEndIdx());
		assertEquals(0, rd.getValue());
	}
	
	@Test
	public void findMaxCrossingSubarray() {
		ReturnData rd = ms.findMaxCrossingSubarray(testData, 0, 8, 15);
		assertEquals(7, rd.getStartIdx());
		assertEquals(10, rd.getEndIdx());
		assertEquals(43, rd.getValue());
	}
	
	@Test
	public void findMaxCrossingSubarray_unValid() {
		ReturnData rd = ms.findMaxCrossingSubarray(testData2, 0, 3, 2);
		assertEquals(0, rd.getStartIdx());
		assertEquals(-1, rd.getEndIdx());
		assertEquals(0, rd.getValue());
	}
	
	//findMaxBasicMethod()와 findMaximumSubarray()비교
	@Test
	public void findMaximumSubarray0() {
		ReturnData rd = ms.findMaximumSubarray(element0, 0, 0);
		ReturnData rd2 = ms.findMaxBasicMethod(element0);
		assertEquals(true, rd.equals(rd2));
	}
	
	@Test
	public void findMaximumSubarray1() {
		ReturnData rd = ms.findMaximumSubarray(element1, 0, 0);
		ReturnData rd2 = ms.findMaxBasicMethod(element1);
		assertEquals(true, rd.equals(rd2));
	}
	
	@Test
	public void findMaximumSubarray2() {
		ReturnData rd = ms.findMaximumSubarray(element2, 0, 1);
		ReturnData rd2 = ms.findMaxBasicMethod(element2);
		assertEquals(true, rd.equals(rd2));
	}
	
	@Test
	public void findMaximumSubarray4() {
		ReturnData rd = ms.findMaximumSubarray(element4, 0, 3);
		ReturnData rd2 = ms.findMaxBasicMethod(element4);
		assertEquals(true, rd.equals(rd2));
	}
	
	@Test
	public void findMaximumSubarray20() {
		ReturnData rd = ms.findMaximumSubarray(element20, 0, 19);
		ReturnData rd2 = ms.findMaxBasicMethod(element20);
		assertEquals(true, rd.equals(rd2));
	}

}

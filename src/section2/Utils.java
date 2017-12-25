package section2;

public class Utils {
	public static boolean isSorted(int[] arr) {
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i] < arr[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		for(int num : arr) {
			System.out.print(num + "    ");
		}
	}
}

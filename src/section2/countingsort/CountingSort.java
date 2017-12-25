package section2.countingsort;

public class CountingSort {
	public int[] countingSort(int[] arr, int maxNumber) {
		// 각 숫자당 들어가야 할 위치. 엄밀히 말하면 위치 + 1
		int[] countByNumber = new int[maxNumber + 1];
		
		int[] result = new int[arr.length];
		
		// 각 숫자당 몇 개가 중복되는지 카운팅
		for(int num : arr) {
			countByNumber[num]++;
		}
		
		// 앞에서 부터 누적 카운팅으로 조정
		for(int i = 1 ; i < maxNumber + 1 ; i++) {
			countByNumber[i] = countByNumber[i] + countByNumber[i - 1];
		}
		
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			result[countByNumber[arr[i]] - 1] = arr[i];
			
			// countByNumber는 해당 인덱스 값을 가진 숫자들 중 마지막 인덱스를 나타내기에
			// 연산 이후동일한 숫자는 -1 값으로 조정 
			countByNumber[arr[i]]--;
		}
		return result;
	}
}

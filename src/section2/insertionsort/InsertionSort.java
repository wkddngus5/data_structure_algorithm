package section2.insertionsort;

public class InsertionSort {
	public void insertionSort(int[] arr) {
		int key = 0;
		for(int i = 1 ; i < arr.length ; i++) {
			key = arr[i];
			int subIdx = i - 1;
			while(subIdx >= 0 && arr[subIdx] > key) {
				// key값보다 작은 수가 나올 때까지 한 칸씩 뒤로 밀기
				arr[subIdx + 1] = arr[subIdx];
				subIdx--;
			}
			arr[subIdx + 1] = key;
		}
	}
}

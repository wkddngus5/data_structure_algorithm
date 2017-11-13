package section2.heapsort;

import java.util.Random;

public class HeapUtils {
	public static Random generator = new Random();

	// 2. makeSampleHeap() 함수 구현
	public static int[] makeSampleHeap(int n) {
		int[] heap = new int[n + 1];
		heap[0] = -1;
		int nowIdx = 1;

		// 큰 이유는 없고 적당한 root 값을 만들기 위해 만든 값
		// +보충) height하나당 최대 10씩 감소하기 때문에 음수가 나오지 않으면서 너무 크지 않은 적당한 값
		int seed = (int) ((Math.log(n) / Math.log(2)) + 1) * 10;
		makeSubHeap(heap, nowIdx, seed); // 재귀적으로 subHeap을 만들어줌
		return heap;
	}

	// 2-1. makeSampleHeap() 함수를 보조하는 sub-heap생성 함수
	public static void makeSubHeap(int[] heap, int nowIdx, int max) {
		heap[nowIdx] = max - (generator.nextInt(10) + 1); // paraent node값에서 1이상의 random값을 빼줌
		int leftIdx = nowIdx * 2;
		int rightIdx = leftIdx + 1;

		if (leftIdx < heap.length) { // leftIdx와 rightIdx값이 heap안의 유효한 값이면 sub-heap생성
			makeSubHeap(heap, leftIdx, heap[nowIdx]);
			if (rightIdx < heap.length) {
				makeSubHeap(heap, rightIdx, heap[nowIdx]);
			}
		}
	}

	// 3. isMaxHeap() 함수 구현
	public static boolean isMaxHeap(int[] heap) {
		int parentIdx = 1;
		for (int i = 2; i < heap.length; i++) {
			parentIdx = i / 2;
			if (parentIdx >= 0) {
				if (heap[parentIdx] < heap[i]) { // parent value가 child value보다 작으면 유효하지 않음
					System.err.println("parent value is " + heap[parentIdx] + ". child is " + heap[i]);
					return false;
				}
			}
		}
		return true;
	}

	// 4. printHeap() 함수 구현
	public static void print(int[] maxHeap) {
		for (int i : maxHeap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

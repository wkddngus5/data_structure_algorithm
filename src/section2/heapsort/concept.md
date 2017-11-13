heap sort: heap 자료 구조를 사용하여 정렬하는 알고리즘
Max heap:각 노드의 값이 children의 값보다 크거나 같은 complete binary tree이다.
time complexity: O(nlgn)
in-place algorithm: O(1)

1. max_heapify() 함수 구현
	- 노드의 subtrees는 모두 max heap라고 가정. test_heapify() 함수 구현
	- 아래의 함수들을 활용해서 max_heapify() 함수 동작 여부 검증하는 함수
	-> MaxHeapify class 


2. makeSampleHeap(int n)
	- 테스트 용도의 max heap 생성 함수
	-> HeapUtils class

3. isMaxHeap(heap_t *heap)
	- 주어진 heap이 max heap인지 여부를 판단하는 함수
	-> HeapUtils class


4. printHeap() 함수 구현
	- heap의 내용을 출력하는 함수
	-> HeapUtils class
	
	
5. buildMaxHeap() 함수 구현
	-> HeapSort class


6. heapSort() 함수 구현
	- Max-heap 생성: O(n)
	- Max-Heapify 호출 횟수: O(n)
	- Max-Heapify 시간 복잡도: O(lgn)
	-> HeapSort class

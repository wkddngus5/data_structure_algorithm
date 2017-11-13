### Priority Queues
- 삽입 순서와 관계없이 우선순위가 높은 것부터 출력하는 자료구조
- 삽입/삭제가 빈번히 발생해도 우선순위가 높은 원소를 효율적으로 삭제
- Heap 자료구조 사용

### Max-priority queue
- 제일 큰 값부터 삭제
- Job-scheduling: OS에서 우선순위 높은 job부터 처리. 처리가 완료되면 남아있는 작업 중 우선순위가 제일 높은 작업 진행
- 최대값 읽기: O(1)
- 최대값 제거: O(lgn). 

* Queue: FIFO(선입선출) 자료구조
 
1. Max heap에서 최대값 제거 함수
	- 최대값이 제거된 max heap과 최대값 출력
	- root노드 제거 후 그 자리에 마지막 노드를 넣고 Heapify
	-> Heap class
	
	
2. Max heap에서 새로운 값 추가 함수
	- 2.1 HeapIncreaseKey()함수를 이용. key값으로 커진 노드를 재귀적으로 parent와 비교하며 바꾸어나감
	- Heap의 마지막 node다음에 -∞값을 갖는 노드를 추가한 다음 HeapIncreaseKey(key)실행
	-> Heap class
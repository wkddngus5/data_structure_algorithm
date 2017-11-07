# N개의 원소로 구성된 배열에서 첫 번째 원소부터 시작해서 합이 최대가 되는 위치 찾기

## Divide-and-Conquer solution
	
	- divide
		* Array를 두 개의 subarray로 분할
	
	- conquer
		* 분할된 subarray에서의 maximum subarray 계산
		* Subarray에서의 maximum subarray계산은 재귀적으로 수행
	
	- combine
		* 중간 왼쪽, 중간 오른쪽, 중간에 걸쳐 있는 세 경우중 값이 제일 큰 subarray를 return
			
1. O(n^2)알고리즘 구현
2. O(nlogn)알고리즘 구현(find_max_subaary()함수도 구현)
3. 위 두 개의 결과가 같은지 확인하는 함수 구현

테스트 방법: 원소 개수: 0개, 1개, 2개, 4개, 20개
출력 결과가 correct한지 확인하는 방법
	- O(n^2)알고리즘과 O(nlogn)알고리즘 결과 비교
	0 주어진 원소 개수별로 사람이 직접 결과 계산한 후 함수 결과값이 직접 계산된 결과값과 같은지 확인

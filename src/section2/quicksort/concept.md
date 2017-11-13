### Partition Problem
- 배열의 마지막 원소를 기준으로 작은 원소들과 큰 원소들로 분리된 배열과 기준이 되는 원소의 위치 찾기

### Quicksort
- Divide-and-Conquer기법의 알고리즘
- 가장 실용적인 sort기법
- Worst case: Θ(n^2)
- Expected running time: Θ(nlgn)
- Time complexity에 들어가는 constant factor가 작아서 Θ(n^2)인데도 속도가 빠름
- In-place: O(1)

1. partiotion() 함수 구현
- partition() 함수 구현 이후 test() 함수 구현
-> QuickSort class

2. quicksort() 함수 구현
-> QuickSort class
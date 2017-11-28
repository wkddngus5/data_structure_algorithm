### 비교 방식의 정렬 알고리즘
- Insertion sort, Quicksort, Heapsort, Mergesort 등
- Worst case의 lower bound는 Ω(nlgn)
- 원소 개수가 n개일 때 나올 수 있는 순서 종류의 수 n! (Leaf node개수)
- Height가 h인 binary tree의 최대 leaf node 개수는 2^h보다 작거나 같음

### 비교 방식이 아닌 정렬 알고리즘
- Counting sort, Radix sort, Bucket sort
- Ω(nlgn)이 적용되지 않음 
- Linear time, O(n) 

### Counting sort
- 값이 x인 원소에 대해서 x보다 작은 원소의 개수를 센 후 x가 출력 배열에 들어갈 위치에 바로 저장한다
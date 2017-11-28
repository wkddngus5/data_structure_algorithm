### Radix
- [수학] 근, 기수
- 10진수의 radix는 10
- 직관적인 방법
	* 가장 상위 자리의 수가 같은 숫자들끼리 모아서 그 다음 상위 자리의 수를 비교하는 과정을 맨 하위 자리까지 반복한다.
	* 주어진 자리의 수 기준으로 정렬한 상태에서 하위 자리의 수를 추가 비교하기 위해서 자리의 수가 같은 값끼리 취합히야 함.
- 가장 낮은 자리의 수부터 비교하는 방법
	* 가장 낮은 자리의 수를 기준으로 stable sort 적용 
- stable sort(counting sort등)를 1번 수행하는데 Θ(𝑛+𝑘) 소요되고 이 작업을 d번 반복하므로 Θ(𝑑(𝑛 + 𝑘))이다.
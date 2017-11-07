package section2.maximum_subarray;

public class MaximumSubarray {
	//1. O(n^2)알고리즘 구현
	public ReturnData findMaxBasicMethod(int[] arr) {
		if(arr.length == 0) {
			return new ReturnData(0, -1, 0);
		}
		int nowSum = 0;
		ReturnData returnData = new ReturnData(0, -1, 0);
		
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = i ; j < arr.length ; j++) {
				
				//매 번 arr[i]~arr[j]까지 하나씩 합하기보다는 이전 연산에서 사용했던 데이터를 이용
				if(i == j) {
					nowSum = 0;
				}
				nowSum += arr[j];
				
				//이전까지 최대값과 현재 arr[i]~arr[j]까지의 합을 비교하여 최대값 갱신 
				returnData = returnData.isBiggerThanInputValue(nowSum) ?
						returnData : new ReturnData(i, j, nowSum);
			}
		}
		return returnData;
	}
	
	//2. O(nlogn)알고리즘 구현
	public ReturnData findMaximumSubarray(int[] arr, int low, int high) {
		if(arr.length == 0) {
			return new ReturnData(0, -1, 0);
		}
		if(low == high) {
			return new ReturnData(low, high, arr[low]);
		}
		int mid = low + ((high - low) / 2);
		ReturnData leftMax = findMaximumSubarray(arr, low, mid);
		ReturnData rightMax = findMaximumSubarray(arr, mid + 1, high);	//주의: mid에 +1을 해주지 않으면 무한히 반복됨
		ReturnData midMax = findMaxCrossingSubarray(arr, low, mid, high);
		
		//leftMax, midMax, rightMax중 최대값 반환
		ReturnData result = leftMax.isBiggerThanInputReturnData(rightMax) ? 
				leftMax : rightMax;
		result = result.isBiggerThanInputReturnData(midMax) ?
				result : midMax;
		return result;
	}
	
	//2-1. low~high범위 중 mid에 걸쳐있는 maxSubarray찾기
	public ReturnData findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
		ReturnData leftMax = new ReturnData(0, -1, 0);
		ReturnData rightMax = new ReturnData(0, -1, 0);
		
		//mid중심으로 왼쪽으로 최대값
		int sum = 0;
		for(int i = mid ; i >= low ; i--) {
			sum += arr[i];
			leftMax = leftMax.isBiggerThanInputValue(sum) ? leftMax : new ReturnData(i, mid, sum);
		}

		//mid중심으로 오른쪽으로 최대값
		sum = 0;
		for(int j = mid + 1 ; j <= high ; j++) {
			sum += arr[j];
			rightMax = rightMax.isBiggerThanInputValue(sum) ? rightMax : new ReturnData(mid + 1, j, sum);
		}
		if(leftMax.isUnValid()) {
			return rightMax;
		} else if(rightMax.isUnValid()) {
			return leftMax;
		} else {
			return leftMax.mergeReturnData(rightMax);
		}
	}
}

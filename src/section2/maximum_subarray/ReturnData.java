package section2.maximum_subarray;

public class ReturnData {
	private int startIdx;
	private int endIdx;
	private int value;
	
	public ReturnData(int startIdx, int endIdx, int value) {
		this.startIdx = startIdx;
		this.endIdx = endIdx;
		this.value = value;
	}
	
	public boolean isBiggerThanInputValue(int inputValue) {
		return this.value > inputValue;
	}
	
	public boolean isBiggerThanInputReturnData(ReturnData returnData) {
		return this.value > returnData.value;
	}
	
	public int getStartIdx() {
		return startIdx;
	}

	public int getEndIdx() {
		return endIdx;
	}

	public int getValue() {
		return value;
	}
	
	public boolean isUnValid() {
		return endIdx == -1;
	}
	
	public ReturnData mergeReturnData(ReturnData right) {
		if(this.endIdx + 1 != right.startIdx) {
			return null;
		}
		return new ReturnData(this.startIdx, right.endIdx, this.value + right.value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endIdx;
		result = prime * result + startIdx;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReturnData other = (ReturnData) obj;
		if (endIdx != other.endIdx)
			return false;
		if (startIdx != other.startIdx)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReturnData [startIdx=" + startIdx + ", endIdx=" + endIdx + ", value=" + value + "]";
	}
}

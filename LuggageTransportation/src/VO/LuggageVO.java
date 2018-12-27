package VO;

public class LuggageVO {
	int sizeA;
	int sizeB;
	int sizeC;
	
	int totalSize;
	int weight;
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	

	public int getSizeA() {
		return sizeA;
	}
	public void setSizeA(int sizeA) {
		this.sizeA = sizeA;
	}
	public int getSizeB() {
		return sizeB;
	}
	public void setSizeB(int sizeB) {
		this.sizeB = sizeB;
	}
	public int getSizeC() {
		return sizeC;
	}
	public void setSizeC(int sizeC) {
		this.sizeC = sizeC;
	}
	public void setTotalSize() {
		totalSize = sizeA + sizeB + sizeC;
	}
	public int getTotalSize() {
		return totalSize;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int checkLuggage(){
		if(sizeA <=0||sizeB <=0||sizeC <=0||totalSize <=0||weight <=0)
			return 0;
		else
			return 1;
	}
}

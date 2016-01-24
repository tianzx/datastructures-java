package datastructures.recursive;

public class OperateOrderNoIndexBinarySearch {

	private int[] datas;
	
	public OperateOrderNoIndexBinarySearch(int[] datas) {
		this.datas = datas;
	}
	private int binarySearch(int data,int lowIndex,int highIndex) {
		int index = -1;
			 index = (lowIndex+highIndex)/2;
			 if(lowIndex > highIndex) {
				 return -1;
			 }else if(datas[index] == data) {
				 return index;
			 }else{
				 if(data <datas[index]) {
					 highIndex = index-1;
				 }else{
					 lowIndex = index+1;
				 }
				 return binarySearch(data,lowIndex,highIndex);
			 }
	}
	
}

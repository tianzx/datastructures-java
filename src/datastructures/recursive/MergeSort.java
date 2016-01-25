package datastructures.recursive;

public class MergeSort {

	public void mergeSort(int[] theArray) {
		int[] temp = new int[theArray.length];
		this.doMergeSort(theArray, temp, 0, theArray.length-1);
	}
	private void doMergeSort(int[] theArray,int[] temp,int lowerBound,int highBound){
		
		if(lowerBound >=highBound) {
			return ;
		}
		//1:calc  index 
		int mid = (lowerBound+highBound)/2;
		//2:sort left
		doMergeSort(theArray, temp, lowerBound, mid);
		//3:sort right
		doMergeSort(theArray, temp, mid+1, highBound);
		//4:merge result
		this.merge(theArray, temp, lowerBound, mid+1, highBound);
	}
	
	private void merge(int[] theArray,int[] temp,int lowIndex,int highIndex,int highBound){
		//the final index
		int count = 0;
		//the left lowest index
		int lowerBound = lowIndex;
		//the left highest index
		int mid = highIndex-1;
		 
		//1:compare each left value to each right value
		while(lowIndex<=mid && highIndex<=highBound){
		//1.1: if left<right ,temp.put(left)
			if(theArray[lowIndex] < theArray[highIndex]) {
				temp[count++] = theArray[lowIndex++];
			}else{
		//1.2: if left>right ,temp.put(right)
				temp[count++] = theArray[highIndex++];
			}
		}
		//2: process left data
		while(lowIndex<=mid) {
			temp[count++] = theArray[lowIndex++];
		}
		while(highIndex<=highBound){
			temp[count++] = theArray[highIndex++];
		}
		//3: copy the sorted data
		for(int i=0;i<(highBound-lowerBound+1);i++){
			theArray[lowerBound+i]= temp[i];
		}
		
	}
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] as = new int[]{4,5,7,9};
		m.mergeSort(as);
		for(int a:as) {
			System.err.println(a);
		}
	}
}

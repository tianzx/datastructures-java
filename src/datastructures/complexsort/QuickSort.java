/**
 * 2016年1月26日
 */
package datastructures.complexsort;

/**
 * @author tianzx
 *
 */
public class QuickSort {
	/**
	 * 
	 * @param as
	 * @param left
	 * @param right
	 */
	public void quickSort(int []as,int left,int right) {
		//exit 
		//operate dataItem
		int size = right-left+1;
		if(size<= 3) {
			//sort directly
			this.manualSort(as, left, right);
		}
		//1:get mid 
		int mv = this.medianValue(as, left, right);
		//2:sort by group
		this.partition(as, left, right, mv);
		//3:repeat excute left array
		this.quickSort(as, left, mv-1);
		//4:repeat excute right array
		this.quickSort(as, mv+1, right);
		
	}
	private int partition(int[]as,int left,int right,int mv){
		
		//1:define two pointers position
		//left position
		int leftIndex = left;
		//right position
		int rightIndex = right-1;
		while(true){
			while(as[++left] < mv){
				//
			}
			while(as[--right]>mv) {
				
			}
			if(leftIndex>=rightIndex) {
				break;
			}else{
				this.swap(as, leftIndex, rightIndex);
			}
		}
		this.swap(as, leftIndex, right-1);
		return leftIndex;
	}
	private int medianValue(int[]as,int left,int right) {
		int center = (left+right)/2;
		if(as[left] > as[center]) {
			this.swap(as, left, center);
		}
		if(as[left] > as[right]) {
			this.swap(as, left, right);
		}
		if(as[center]>as[right]){
			this.swap(as, center, right);
		}
		this.swap(as, center, right-1);
		return as[right-1];
	}
	private void manualSort(int[]as ,int left,int right) {
		
	}
	private void swap(int[]as,int index1,int index2){ 
		int temp = as[index1];
		as[index1] = as[index2];
		as[index2] = as[index1];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

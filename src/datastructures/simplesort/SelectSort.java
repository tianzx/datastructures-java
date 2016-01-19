package datastructures.simplesort;

public class SelectSort {

	public void selectSort(int as[]) {
		int min=0;
		for(int i=0;i<as.length-1;i++) {
			//init the min position
			min  = i;
			for(int j=i+1;j<as.length;j++) {
				if(as[min]>as[j]) {
					min = j;
				}
			}
			swap(as,min,i);
		}
	}
	
	private void swap(int[]as ,int aIndex, int bIndex) {
		int temp = as[aIndex];
		as[aIndex] = as[bIndex];
		as[bIndex] = temp;
	}
	
	public static void main(String[] args) {
		SelectSort ss = new SelectSort();
		int[] as = {1,4,12,8,2,6,9,5,10};
		ss.selectSort(as);
		for(int i :as )
			System.err.print(i+" ");
	}
}

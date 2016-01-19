package datastructures.simplesort;

public class BubbleSort {

	public void bubbleSort(int[] as) {
		/***
		 * i 用来控制比较次数
		 */
		for(int  i=as.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(as[j] > as[j+1]){
					//如果前面的数据比后面的大，应该交换
					swap(as,j,j+1);
				}
			}
		}
	}
	
	
	public void bubbleSort2(int[] as) {
		for(int i=0;i<as.length-1;i++) {
			 for(int j=i+1;j<as.length;j++) {
				 if(as[i]>as[j]) {
					 swap(as,i,j);
				 }
			 }
		}
	}
	private void swap(int[]as ,int aIndex, int bIndex) {
		int temp = as[aIndex];
		as[aIndex] = as[bIndex];
		as[bIndex] = temp;
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] as = {1,4,12,8,2,6,9,5,10};
		bs.bubbleSort2(as);
		for(int i :as )
			System.err.print(i+" ");
	}
}

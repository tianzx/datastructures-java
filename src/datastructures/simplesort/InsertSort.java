package datastructures.simplesort;

public class InsertSort {

	public void insertSort(int[] as) {
		int j = 0;
		//第一个位置已经排好序
		for(int i=1;i<as.length;i++) {
			int temp= as[i];
			for( j=i;j>0;j--) {
				if(as[j-1]>=temp){
					as[j]=as[j-1];
				}else {
					break;
				}
			}
			as[j] =temp;
		}
	}
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		int[] as = {1,4,12,8,2,6,9,5,10};
		is.insertSort(as);
		for(int i :as )
			System.err.print(i+" ");
	}

}

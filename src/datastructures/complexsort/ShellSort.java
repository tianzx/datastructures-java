package datastructures.complexsort;

public class ShellSort {

	public void shellSort(int []as) {

		int increment = 1;
		//1: calc each group increment
		while(increment<=as.length/3){
			increment = increment*3+1;
		}
		int j=0; int temp=0;
		for(;increment>0;increment=(increment-1)/3){
			//each group insertsort
			for(int i=increment;i<as.length;i++){
				temp = as[i];
				for(j=i;j>=increment;j-=increment) {
					if(temp < as[j-increment]){
						as[j] = as[j-increment] ;
					}else{
						break;
					}
				}
				as[j] = temp;
			}
		}
	}
	public static void main(String[] args) {
		
		ShellSort ss = new ShellSort();
		int[] as = new int[] {3,5,4,8,7};
		ss.shellSort(as);
		for(int a:as) {
			System.err.println(a);
		}
	}
}

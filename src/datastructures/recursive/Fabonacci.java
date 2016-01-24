package datastructures.recursive;

public class Fabonacci {

	
	public int getN(int num) {
		if(num==1){
			return 0;
		}else if(num==2){
			return 1;
		}
		return getN(num-1)+getN(num-2);
	}
	
	public int sum(int num){
		if(num==1) {
			return 0;
		}
		return getN(num)+sum(num-1);
	}
	
	public static void main(String[] args) {
		Fabonacci t = new Fabonacci();
		int ret = t.getN(7);
		System.err.println(ret);
		int sum = t.sum(7);
		System.err.println(sum);
	}
}

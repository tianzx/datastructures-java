package datastructures.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tianzx
 *
 */
public class Bags {

	/**
	 * 
	 * @param as :weight dataArray
	 * @param targetWeight: target wight 
	 * @param nowIndex:now index
	 * @param result: result
	 */
	public void bag(int[] as,int targetWeight,int nowIndex,List<Integer> result){
		if(nowIndex ==as.length) {
			return;
		}
		if(as[nowIndex] > targetWeight) {
			this.bag(as, targetWeight, ++nowIndex, result);
		}else if(as[nowIndex] ==targetWeight) {
			result.add(as[nowIndex]);
			System.out.println(result);
			result.clear();
		}else{
			result.add(as[nowIndex]);
			this.bag(as, targetWeight-as[nowIndex], ++nowIndex, result);
		}
	}
	
	public static void main(String[] args) {
		
		Bags bag = new Bags();
		int[] as = new int[]{11,8,7,5};
		
		for(int i=0;i<as.length;i++) {
			bag.bag(as, 20, 1, new ArrayList<Integer>());
		}
	}
}

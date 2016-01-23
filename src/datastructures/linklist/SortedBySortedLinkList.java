package datastructures.linklist;

public class SortedBySortedLinkList {

	public int[] sort(int[] as) {
		int[] ret = new int[as.length];
		//1:put the data in linklist
		SortedLinkList list =  new SortedLinkList();
		for(int a: as){
			list.insertFirst(a);
		}
		//2:get data from sortedList
		int index = 0;
		while(!list.isEmpty()){
			ret[index] = list.removeFirst().getId();
			index++;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		SortedBySortedLinkList t = new SortedBySortedLinkList();
		
		int[] ret = t.sort(new int[] {5,3,7,6});
		for(int val : ret) {
			System.err.println(val);
		}
	}
}

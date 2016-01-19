package datastructures.arrays.noorder;
/**
 * 无序数组
 * @author tianzx
 *
 */
public class OperateNoIndex {

	private int[] datas = null;
	private int currentIndex = 0;
	
	public OperateNoIndex(int length){
		this.datas= new int[length];
	}
	public int insert(int data){
		this.datas[currentIndex] =data;
		this.currentIndex++;
		return this.currentIndex-1;
	}
	public void remove(int data) {
		int index = this.getIndex(data);
		for(int i=index;i<this.currentIndex;i++) {
			datas[i] = datas[i+1];
		}
	}
	public int get(int data){
		int index = this.getIndex(data);
		if(index>=0){
			return datas[index];
		}
		return 0;
	}
	
	private int getIndex(int data) {
		int index= -1;
		for(int i=0;i<currentIndex;i++) {
			if(this.datas[i]==data) {
				index = i;
				break;
			}
		}
		return index;
	}
	public void printDatas() {
		for(int i : this.datas){
			System.err.println(i);
		}
	}
	
	public static void main(String[] args) {
		OperateNoIndex oni= new OperateNoIndex(20);
		oni.insert(3);
		oni.insert(1);
		oni.insert(2);
		oni.insert(7);
		oni.insert(0);
		oni.printDatas();
		oni.remove(3);
		oni.printDatas();
	}
}

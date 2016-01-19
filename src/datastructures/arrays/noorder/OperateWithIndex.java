package datastructures.arrays.noorder;

/***
 * 
 * @author tianzx
 *
 */
public class OperateWithIndex {

	private int[] datas = null;
	private int currentIndex = 0;
	
	public OperateWithIndex(int length){
		this.datas= new int[length];
	}
	public int insert(int data){
		this.datas[currentIndex] =data;
		this.currentIndex++;
		return this.currentIndex-1;
	}
	public void remove(int index) {
		for(int i=index;i<this.currentIndex;i++) {
			datas[i] = datas[i+1];
		}
	}
	public int get(int index){
		return datas[index];
	}
	
	public void printDatas() {
		for(int i : this.datas){
			System.err.println(i);
		}
	}
	
	public static void main(String[]args) {
		OperateWithIndex ow= new OperateWithIndex(20);
		ow.insert(3);
		ow.insert(6);
		ow.insert(9);
		ow.insert(0);
		ow.insert(1);
		ow.insert(35);
		ow.printDatas();
		int ret = ow.get(4);
		System.err.println(ret);
	}
}

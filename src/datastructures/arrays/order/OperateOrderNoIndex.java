package datastructures.arrays.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 可存放不重复值
 * @author tianzx
 *
 */
public class OperateOrderNoIndex {
	private int[] datas = null;
	private int currentIndex = 0;
	
	public OperateOrderNoIndex(int length){
		this.datas= new int[length];
	}
	public int insert(int data){
		int index = 0 ;
		for(index=0;index<this.currentIndex;index++) {
			if(datas[index]>data) {
				break;
			}
		}
		for(int i=this.currentIndex;i>index;i--){
			datas[i]=datas[i-1];
		}
		datas[index] = data;
		this.currentIndex++;
		this.datas[currentIndex] =data;
		this.currentIndex++;
		return this.currentIndex-1;
	}
	public void remove(int data) {
		int index = this.getIndex(0,data);
		while(index>=0){
			for(int i=index;i<this.currentIndex;i++) {
				datas[i] = datas[i+1];
			}
			this.currentIndex--;
			index= this.getIndex(index, data);
		}
		
	}
	public List<Integer> get(int data){
		List<Integer> retList = new ArrayList<Integer>();
		int index = this.getIndex(0,data);
		while(index>=0) {
			retList.add(datas[index]);
			index = this.getIndex(index+1, data);
		}
		return retList;
	}
	
	private int getIndex(int begin,int data) {
		int index= -1;
		for(int i=begin;i<this.currentIndex;i++) {
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
		OperateOrderNoIndex oni= new OperateOrderNoIndex(20);
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

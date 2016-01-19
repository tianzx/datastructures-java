package datastructures.arrays.object;

import java.util.ArrayList;
import java.util.List;

/**
 * 可存放不重复值
 * @author tianzx
 *
 */
public class OperateOrderNoIndexObject {
	private UserModel[] datas = null;
	private int currentIndex = 0;
	
	public OperateOrderNoIndexObject(int length){
		this.datas= new UserModel[length];
	}
	public int insert(UserModel data){
		int index = 0 ;
		for(index=0;index<this.currentIndex;index++) {
			if(datas[index].getUuid()>data.getUuid()) {
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
	public void remove(int uuid) {
		int index = this.getIndex(uuid);
		while(index>=0){
			for(int i=index;i<this.currentIndex;i++) {
				datas[i] = datas[i+1];
			}
			this.currentIndex--;
		}
		
	}
	public UserModel get(int uuid){
		List<Integer> retList = new ArrayList<Integer>();
		int index = this.getIndex(uuid);
		while(index>=0) {
			return this.datas[index];
		}
		return null;
	}
	
	private int getIndex(int uuid) {
		int index= -1;
		for(int i=uuid;i<this.currentIndex;i++) {
			if(this.datas[i].getUuid()==uuid) {
				index = i;
				break;
			}
		}
		return index;
	}
	public void printDatas() {
		for(UserModel i : this.datas){
			System.err.println(i);
		}
	}
	
	public static void main(String[] args) {
	}
}

package datastructures.simplesort;

import datastructures.arrays.object.UserModel;

public class ObjectSort {

	public void ObjectSort(UserModel[] ums){
		int j = 0;
		//第一个位置已经排好序
		for(int i=1;i<ums.length;i++) {
			UserModel temp= ums[i];
			for( j=i;j>0;j--) {
				if(ums[j-1].getUuid()>=temp.getUuid()){
					ums[j]=ums[j-1];
				}else {
					break;
				}
			}
			ums[j] =temp;
		}
	}
	
	private void printData(UserModel[] ums) {
		for(UserModel d: ums) {
			System.err.println(d.getUuid());
		}
	}
	
	public static void main(String[] args) {
		ObjectSort os= new ObjectSort();
		UserModel[] umds = new UserModel[]{
//				new UserModel()
		};
 	}
}

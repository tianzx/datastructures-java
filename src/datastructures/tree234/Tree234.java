package datastructures.tree234;

public class Tree234 {

	private Node234 root =  new Node234();
	/**
	 * according keys to  search object 
	 * @param key
	 * @return
	 */
	public int find(int key) {
		Node234 current = root;
		int childIndex = -1;
		while(true) {
			childIndex= current.findKeyItem(key);
			if(childIndex>=0) {
				return childIndex;
			}else if(current.isLeaf()) {
				return -1;
			}else {
				current = this.getNext(current, key);
			}
		}
	}
	
	private Node234 getNext(Node234 node,int key) {
		int i = 0;
		for(i=0;i<node.getNumItems();i++) {
			if(key<node.getItems()[i].getId()) {
				return node.getChild(i);
			}
		}
		return node.getChild(i);
	}
	/**
	 * insert a distinguish data
	 * @param id
	 */
	public void insert(int id) {
		
	}
}

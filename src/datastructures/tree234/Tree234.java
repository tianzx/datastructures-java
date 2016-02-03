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
		Node234 current = root;
		KeyItem newItem =  new KeyItem(id);
		
		while(true) {
			if(current.isFull()) {
				//if it is full
				//1: node division
				
				//2: search current
				//2.1: get current parent,because node divised
				//2.2: again search new node
				current = this.getNext(current.getParent(), id);
			}else {
				if(current.isLeaf()) {
					break;
				}else {
					current = this.getNext(current, id);
				}
			}
		}
		current.insertKeyItem(newItem);
	}
	/**
	 * split node 
	 * @param node
	 */
	private void splitNode(Node234 node) {
		KeyItem key2,key3;
		Node234 parent,child3,child4;
		key3 = node.removeKeyItem();
		key2 = node.removeKeyItem();
		
		child3 = node.disConnectChild(2);
		child3 = node.disConnectChild(3);
	}
}

package datastructures.tree234;
/**
 * encapsulation 2-3-4 node object
 * @author tianzx
 *
 */
public class Node234 {

	private KeyItem[] items = new KeyItem[3];
	
	private Node234[] children = new Node234[4];
	
	private Node234 parent = null;
	/**
	 * how many items .eg:3
	 */
	private int numItems;
	
	
	public int insertKeyItem(KeyItem newItem) {
		//maintain numItems 
		this.numItems++;
		//from end to front 
		for(int i=2;i>=0;i--) {
			if(this.items[i]==null) {
				continue;
			}else {
				if(newItem.getId() > items[i].getId()) {
					this.items[i+1] = newItem;
					return i+1;
				}else {
					this.items[i+1] = this.items[i];
				}
			}
		}
		items[0] = newItem;
		return 0;
	}
	
	public KeyItem removeKeyItem() {
		KeyItem ret = this.items[this.numItems-1];
		items[this.numItems-1] = null;
		this.numItems--;
		return ret;
	}
	
	public int findKeyItem(int key) {
		for(int i=0;i<3;i++) {
			if(this.items[i] == null) {
				break;
			}else if(this.items[i].getId()==key){
				return i;
			}
		}
		return -1;
	}
	
	public void connectChild(int childIndex,Node234 childNode) {
		this.children[childIndex] = childNode;
		if(childNode!=null) {
			childNode.setParent(this);
		}
	}
	/**
	 * disconnect node childnode
	 * @param childIndex
	 */
	public Node234 disConnectChild(int childIndex) {
		Node234 ret = this.children[childIndex];
		this.children[childIndex] = null;
		return ret;
	}
	/**
	 * get a childNode
	 * @param childIndex
	 * @return
	 */
	public Node234 getChild(int childIndex) {
		
		return this.children[childIndex];
	}
	/**
	 * get parent node
	 * @return
	 */
	public Node234 getParent() {
		
		return this.parent;
	}
	
	public boolean isLeaf() {
		return this.children[0]==null;
	}
	
	public boolean isFull() {
		return this.numItems==3;
	}
	
	public  void setParent(Node234 node) {
		this.parent = node;
	}
	
	/**
	 * @return the items
	 */
	public KeyItem[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(KeyItem[] items) {
		this.items = items;
	}

	/**
	 * @return the children
	 */
	public Node234[] getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Node234[] children) {
		this.children = children;
	}

	public void displayNode() {
		for(int i=0;i<this.numItems;i++) {
			System.err.println(this.items[i].getId()+",");
		}
		System.err.println("----");
	}
	public static void main(String[] args) {
//		int[] data = {1,2,3};
//		System.err.println(data[2]);
		
	}

	/**
	 * @return the numItems
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * @param numItems the numItems to set
	 */
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
}

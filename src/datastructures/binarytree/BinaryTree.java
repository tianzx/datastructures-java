package datastructures.binarytree;
/***
 * show how to operate BT
 * @author tianzx
 *
 */
public class BinaryTree {
	/**
	 * root node
	 */
	private Node root;
	/**
	 * find a node 
	 * @param key id
	 * @return
	 */
	public Node find(int key) {
		Node current = this.root;
		while(current.getId()!=key) {
			if(current.getId()>key) {
				current =  current.getLeftChild();
			}else if(current.getId()<key){
				current = current.getRightChild();
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}
	/**
	 * insert a node
	 * @param id
	 * @param data
	 */
	public void insert(int id,int data) {
		//1:create a new node
		Node newNode = new Node(id,data);
		//2:search the insert position
		if(root==null){
			this.root = newNode;
		}else {
			Node current = this.root;
			Node parent = null;
			while(true) {
				parent = current;
				if(id < current.getId()){
					current = current.getLeftChild();
					// if dont have left child
					if(current == null){
						//3:edit relation node
						parent.setLeftChild(newNode);
						return ;
					}
				}else {
					current = current.getRightChild();
					if(current ==null){
						parent.setRightChild(newNode);
						return;
					}
				}
			}
			
		}
	
		
		
	}
	/**
	 * 
	 * @param node
	 */
	public void preOrder(Node node){
		if(node!=null){
			System.err.print(node.getId()+",");
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	public void inOrder(Node node ){
		if(node!=null){
			inOrder(node.getLeftChild());
			System.err.print(node.getId()+",");
			inOrder(node.getRightChild());
		}
	}
	public void postOrder(Node node) {
		if(node!=null){
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			System.err.print(node.getId()+",");
			
		}
	}
	/**
	 * the min node
	 * @return
	 */
	public Node getMinNode() {
		Node current = this.root;
		Node lastNode = null;
		while(current!=null){
			lastNode = current;
			current = current.getLeftChild();
		}
		return lastNode;
	}
	public Node getMaxNode() {
		Node current = this.root;
		Node lastNode = null;
		while(current!=null){
			lastNode = current;
			current = current.getRightChild();
		}
		return lastNode;
	}
	
	public boolean deleteNode(){
		return false;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(6, 5);
		bt.insert(5, 2);
		bt.insert(8, 22);
		bt.insert(3, 7);
		bt.insert(7, 20);
		bt.insert(9, 56);
		
//		System.err.println(bt.root.toString());
		bt.preOrder(bt.find(6));
		System.err.println();
		bt.inOrder(bt.find(6));
		System.err.println();
		bt.postOrder(bt.find(6));
		System.err.println();
	}
}

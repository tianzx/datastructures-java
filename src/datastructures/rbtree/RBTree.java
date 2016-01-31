package datastructures.rbtree;
/***
 * show how to operate BT
 * @author tianzx
 *
 */
public class RBTree {
	/**
	 * root RBNode
	 */
	private RBNode root;
	/**
	 * find a RBNode 
	 * @param key id
	 * @return
	 */
	public RBNode find(int key) {
		RBNode current = this.root;
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
	 * insert a RBNode
	 * @param id
	 * @param data
	 */
	public void insert(int id,int data) {
		//1:create a new RBNode
		RBNode newRBNode = new RBNode(id,data);
		//2:search the insert position
		if(root==null){
			this.root = newRBNode;
		}else {
			RBNode current = this.root;
			RBNode parent = null;
			while(true) {
				parent = current;
				if(id < current.getId()){
					current = current.getLeftChild();
					// if dont have left child
					if(current == null){
						//3:edit relation RBNode
						parent.setLeftChild(newRBNode);
						return ;
					}
				}else {
					current = current.getRightChild();
					if(current ==null){
						parent.setRightChild(newRBNode);
						return;
					}
				}
			}
			
		}
	
		
		
	}
	/**
	 * 
	 * @param RBNode
	 */
	public void preOrder(RBNode RBNode){
		if(RBNode!=null){
			System.err.print(RBNode.getId()+",");
			preOrder(RBNode.getLeftChild());
			preOrder(RBNode.getRightChild());
		}
	}
	public void inOrder(RBNode RBNode ){
		if(RBNode!=null){
			inOrder(RBNode.getLeftChild());
			System.err.print(RBNode.getId()+",") ;
			inOrder(RBNode.getRightChild());
		}
	}
	public void postOrder(RBNode RBNode) {
		if(RBNode!=null){
			postOrder(RBNode.getLeftChild());
			postOrder(RBNode.getRightChild());
			System.err.print(RBNode.getId()+",");
			
		}
	}
	/**
	 * the min RBNode
	 * @return
	 */
	public RBNode getMinRBNode() {
		RBNode current = this.root;
		RBNode lastRBNode = null;
		while(current!=null){
			lastRBNode = current;
			current = current.getLeftChild();
		}
		return lastRBNode;
	}
	public RBNode getMaxRBNode() {
		RBNode current = this.root;
		RBNode lastRBNode = null;
		while(current!=null){
			lastRBNode = current;
			current = current.getRightChild();
		}
		return lastRBNode;
	}
	
	public boolean deleteRBNode(){
		return false;
	}
	
	public static void main(String[] args) {
	}
}

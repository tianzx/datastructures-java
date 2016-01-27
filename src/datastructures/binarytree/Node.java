package datastructures.binarytree;

public class Node {
	private int id;
	private int data;
	private Node leftChild;
	private Node rightChild;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the leftChild
	 */
	public Node getLeftChild() {
		return leftChild;
	}
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	/**
	 * @return the rightChild
	 */
	public Node getRightChild() {
		return rightChild;
	}
	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node(int id, int data) {
		super();
		this.id = id;
		this.data = data;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [id=" + id + ", data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}

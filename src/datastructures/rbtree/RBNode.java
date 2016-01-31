package datastructures.rbtree;
/**
 * red、black node
 * @author tianzx
 *
 */
public class RBNode {
	private int id;
	private int data;
	private RBNode leftChild;
	private RBNode rightChild;
	//add
	private boolean red =true;
	private RBNode parent;
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
	public RBNode getLeftChild() {
		return leftChild;
	}
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(RBNode leftChild) {
		this.leftChild = leftChild;
	}
	/**
	 * @return the rightChild
	 */
	public RBNode getRightChild() {
		return rightChild;
	}
	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(RBNode rightChild) {
		this.rightChild = rightChild;
	}
	/**
	 * @return the red
	 */
	public boolean isRed() {
		return red;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RBNode [id=" + id + ", data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild
				+ ", red=" + red + ", parent=" + parent + "]";
	}
	/**
	 * @param red the red to set
	 */
	public void setRed(boolean red) {
		this.red = red;
	}
	/**
	 * @return the parent
	 */
	public RBNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(RBNode parent) {
		this.parent = parent;
	}
	public RBNode(int id, int data) {
		super();
		this.id = id;
		this.data = data;
	}
}

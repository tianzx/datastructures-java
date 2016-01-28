package datastructures.binarytree;

public class HuffmanNode {
	/**
	 * charactor
	 */
	private char c;
	/**
	 * quanlity
	 */
	private int count;
	
	HuffmanNode(char c,int count){
		super();
		this.c = c;
		this.count = count;
	}
	/**
	 * @return the c
	 */
	public char getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(char c) {
		this.c = c;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the leftChild
	 */
	public HuffmanNode getLeftChild() {
		return leftChild;
	}
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(HuffmanNode leftChild) {
		this.leftChild = leftChild;
	}
	/**
	 * @return the rightChild
	 */
	public HuffmanNode getRightChild() {
		return rightChild;
	}
	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(HuffmanNode rightChild) {
		this.rightChild = rightChild;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HuffmanNode [c=" + c + ", count=" + count + ", leftChild=" + leftChild + ", rightChild=" + rightChild
				+ "]";
	}
	private HuffmanNode leftChild;
	private HuffmanNode rightChild;
	
}

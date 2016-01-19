package datastructures.stack;

/**
 * show basic myStack
 * @author tianzx
 *
 */
public class MyStack {
	private int[] datas;
	private int topIndex = -1 ;
	
	public MyStack(int length) {
		datas = new int[length];
	}
	
	public void push(int d) {
		topIndex++;
		datas[topIndex]=d;
	}
	public int pop(){
		int ret = datas[this.topIndex];
		this.topIndex--;
		return ret;
	}
	public  int peek(){
		return datas[this.topIndex];
	}
	public boolean isEmpty(){
		return topIndex==-1;
	}
	public boolean isFull(){
		return topIndex==(datas.length-1);
	}
	
	public void printStack() {
		for(int i=0;i<=topIndex;i++){
			System.err.print(datas[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack(10);
		
		myStack.push(1);
		myStack.push(3);
		myStack.push(2);
		myStack.push(16);
		myStack.push(12);
		myStack.push(7);
		
		int ret1 = myStack.peek();
		System.err.println(ret1);
		
		myStack.pop();
		int ret2 = myStack.pop();
		System.err.println(ret2);
		
		myStack.printStack();
	}
}

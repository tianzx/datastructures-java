package datastructures.queue;

public class MyQueue {
	//data array
	private int[] queue;
	//the head position
	private int front;
	//the end position
	private int end;
	//the number of item
	private int nItems;
	
	public MyQueue(int length){ 
		queue = new int[length];
		this.front = 0;
		this.end =-1;
		this.nItems = 0;
	}
	public void insert(int data){
		//
		if(this.end==this.queue.length-1){
			this.end=-1;
		}
		this.end++;
		this.queue[end]=data;
		this.nItems++;
		if(this.nItems>this.queue.length){
			this.nItems = this.queue.length;
		}
	}
	public int remove(){
		if(this.nItems==0)
			return 0;
		int temp = this.queue[this.front];
		this.queue[this.front]=0;
		if(this.front==this.queue.length-1){
			this.front=0;
		}
		this.front++;
		this.nItems--;
		return 0;
	}
	public int peekFront(){
		return this.queue[this.front];
	}
	public boolean isEmpty(){
		return this.nItems==0;
	}
	public boolean isFull(){
		return this.nItems==this.queue.length;
	}
	private void printQueue(){
		for(int q: queue){
			System.err.print(q+" ");
		}
		System.err.println();
	}
	
	public static void main(String[] args) {
		MyQueue t = new MyQueue(20);
		t.insert(1);
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		t.insert(7);
		t.printQueue();
		t.remove();
		t.printQueue();
	}
}

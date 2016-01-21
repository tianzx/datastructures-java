package datastructures.queue;

public class PriorityQueue {

	private int[] queue;
	private int nItems;

	public PriorityQueue(int length) {
		queue = new int[length];
		this.nItems = 0;
	}

	public void insert(int data) {
		//1.if no items , assignment directly
		if(this.nItems==0) {
			this.queue[this.nItems]= data;
			this.nItems++;
		}else{
			//2.else need compare &&sort
			int i=0;
			for(i=this.nItems-1;i>=0;i--) {
				if(data>this.queue[i]){
					this.queue[i+1] = this.queue[i];
				}else{
					break;
				}
			}
			this.queue[i+1] = data;
			this.nItems++;
		}
		
		
	}

	public int remove() {
		this.nItems--;
		int temp = this.queue[this.nItems];
		return temp;
	}

	public int peekFront() {
		return this.queue[this.nItems-1];
	}

	public boolean isEmpty() {
		return this.nItems == 0;
	}

	public boolean isFull() {
		return this.nItems == this.queue.length;
	}

	private void printQueue() {
		for (int q : queue) {
			System.err.print(q + " ");
		}
		System.err.println();
	}
	
	public static void main(String[] args) {
		PriorityQueue t = new PriorityQueue(20);
		t.insert(1);
		t.insert(3);
		t.insert(2);
//		t.printQueue();
		int i = 0;
		for(i=10;i>=0;i--) {
			System.err.println(i);
		}
		System.err.println(i);
	}
}

package datastructures.binarytree;

public class HuffmanPriorityQueue {

	private HuffmanNode[] queue;
	//most like index
	private int nItems;

	private int length;
	
	public HuffmanPriorityQueue(int length) {
		this.length = length;
		queue = new HuffmanNode[length];
		this.nItems = 0;
	}

	public void insert(HuffmanNode data) {
		//1.if no items , assignment directly
		if(this.nItems==0) {
			this.queue[this.nItems]= data;
			this.nItems++;
		}else{
			//2.else need compare &&sort
			int i=0;
			for(i=this.nItems-1;i>=0;i--) {
				if(data.getCount()<this.queue[i].getCount()){
					this.queue[i+1] = this.queue[i];
				}else{
					break;
				}
			}
			this.queue[i+1] = data;
			this.nItems++;
		}
		
		
	}

	public HuffmanNode remove() {
		this.nItems--;
		HuffmanNode temp = this.queue[this.nItems];
		this.queue[nItems] = null;
		return temp;
	}

	public HuffmanNode peekFront() {
		return this.queue[this.nItems-1];
	}

	public boolean isEmpty() {
		return this.nItems == 0;
	}

	public boolean isFull() {
		return this.nItems == this.queue.length;
	}

	private void printQueue() {
		System.err.println("success");
		for (HuffmanNode q : queue) {
			System.err.println(q + " ");
		}
		System.err.println();
	}
	
	public static void main(String[] args) {
		System.err.println("test");
		HuffmanPriorityQueue t = new HuffmanPriorityQueue(20);
		t.insert(new HuffmanNode('a',5));
		t.insert(new HuffmanNode('b',6));
		t.insert(new HuffmanNode('c',3));
		t.insert(new HuffmanNode('d',4));
		t.insert(new HuffmanNode('e',1));
		t.printQueue();
	}
}

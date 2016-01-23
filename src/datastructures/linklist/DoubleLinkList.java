package datastructures.linklist;

/**
 * show two directions linklist
 * have bug
 * @author tianzx
 *
 */
public class DoubleLinkList {

	private LinkNode2 first;
	private LinkNode2 last;
	public void insertFirst(int id) {
		LinkNode2 newLink = new LinkNode2(id);
		
		if(this.isEmpty()) {
			last = newLink;
		}else{
			this.first.setPrevious(newLink);
		}
		newLink.setNext(this.first);
		this.first = newLink;
	}
	
	public void insertLast(int id){
		LinkNode2 newLink = new LinkNode2(id);
		if(isEmpty()) {
			first = newLink;
		}else {
			last.setPrevious(newLink);
			newLink.setPrevious(last);
		}
		last = newLink;
	}

	public LinkNode2 removeFirst() {
		LinkNode2 temp = first;
		if(first.getNext()==null){
			last = null;
		}else{
			first.getNext().setPrevious(null);
		}
		first = first.getNext();
		return temp;
	}

	public LinkNode2 find(int id) {
		LinkNode2 node = first;
		while (node.getId() != id) {
			if (node.getNext() == null) {
				return null;
			} else {
				node = node.getNext();
			}
		}
		return node;
	}
	
	public boolean isEmpty() {
		return this.first==null;
	}
	
	public LinkNode2 removeLast() {
		LinkNode2 temp = last;
		if(last.getPrevious() == null) {
			first = null;
		}else {
			last.getPrevious().setNext(null);
		}
		last = last.getPrevious();
		return temp;
	}
	public boolean insertAfter(int key,int id) {
		//1.search the node 
		LinkNode2 node = this.find(key);
		//2.set the three nodes,key key->next new
		LinkNode2 newLink = new LinkNode2(id);
		if(node == last) {
			newLink.setNext(null);
			last = newLink;
		}else {
			newLink.setNext(node.getNext());
			node.getNext().setPrevious(newLink);
		}
		newLink.setPrevious(node);
		node.setNext(newLink);
		return true;
	}
	public LinkNode2 remove(int key) {
		//1.find the delete node
		LinkNode2 node = this.find(key);
		//2.if it is the first node,then modify it next as new first 
		//2.1 .else this.node.previous.next = this.node.next
		if(node == first ){
			this.first = node.getNext();
		}else {
			node.getPrevious().setNext(node.getNext());
		}
		//3.if it is the last node,then last = this.id.previous
		//3.1.else this.node.next.previous = this.node.previous
		if(node == last ){
			last = node.getPrevious();
		}else {
			node.getNext().setPrevious(node.getPrevious());
		}
		return node;
	}
	public void displayListForward() {
		LinkNode2 tempNode = first;
		while (tempNode != null) {
			tempNode.printLink();
			tempNode = tempNode.getNext();
		}
	}
	public void displayBackward() {
		LinkNode2 tempNode = last;
		while (tempNode != null) {
			tempNode.printLink();
			tempNode = tempNode.getPrevious();
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkList t = new DoubleLinkList();
		t.insertFirst(1);
		t.insertFirst(3);
		t.insertFirst(42);
		t.insertFirst(32);
		t.insertFirst(54);
		t.displayListForward();
		t.displayBackward();
		t.insertLast(23);
		t.insertLast(12);
		t.insertLast(26);
		t.insertLast(43);
		t.removeFirst();
		t.displayListForward();
		t.displayBackward();
		t.removeLast();
		t.displayListForward();
		t.displayBackward();
		t.remove(3);
		t.insertAfter(32, 99);
		t.displayListForward();
		t.displayBackward();
	}
}

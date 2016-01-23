package datastructures.linklist;
/**
 * ordered linklist
 * @author tianzx
 *
 */
public class SortedLinkList {

	private LinkNode firstNode;
	
	public void insertFirst(int id) {
		LinkNode newLink = new LinkNode(id);
		// search the new node need insert position
		LinkNode previous = null;
		LinkNode current = firstNode;
		// 1.search the first > current
		while(current!=null &&id>current.getId()) {
			previous = current;
			current = current.getNext();
		}
		// 2. set the new node
		if(previous ==null) {
			firstNode = newLink;
		}else {
			previous.setNext(newLink);
		}
		newLink.setNext(current);
	}
	
	public LinkNode removeFirst(){
		LinkNode temp = firstNode;
		firstNode = firstNode.getNext();
		return temp;
	}
	
	public LinkNode find(int id) {
		LinkNode node = firstNode;
		while(node.getId()!=id){
			if(node.getNext()==null){
				return null;
			}else{
				node = node.getNext();
			}
		}
		return node;
	}
	
	public LinkNode remove(int id){
		LinkNode needDelete =  firstNode;
		LinkNode previous = firstNode;
		//search need delete node and its previous node
		while(needDelete.getId()!=id) {
			if(needDelete.getNext()==null){
				return null;
			}else{
				previous = needDelete;
				needDelete = needDelete.getNext();
			}
		}
		//set node relation
		if(needDelete.equals((firstNode))){
			firstNode = firstNode.getNext();
		}else{
			previous.setNext(needDelete.getNext());
		}
		return needDelete;
	}
	public void displayList(){
		LinkNode tempNode = firstNode;
		while(tempNode!=null){
			tempNode.printLink();
			tempNode = tempNode.getNext();
		}
	}
	
	public static void main(String[] args) {
		SortedLinkList t =  new SortedLinkList();
		t.insertFirst(1);
		t.insertFirst(3);
		t.insertFirst(2);
		t.insertFirst(15);
		t.insertFirst(7);
		t.displayList();
		
		LinkNode ret1 = t.find(2);
		System.err.println(ret1);
		
		t.remove(15);
		t.displayList();
	}
}

package datastructures.linklist;
/**
 * only one direct link basic operate
 * @author tianzx
 *
 */
public class SingleLinkList {

	private LinkNode firstNode;
	
	public void insertFirst(int id) {
		LinkNode newLink = new LinkNode(id);
		newLink.setNext(firstNode);
		firstNode = newLink;
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
		SingleLinkList t =  new SingleLinkList();
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

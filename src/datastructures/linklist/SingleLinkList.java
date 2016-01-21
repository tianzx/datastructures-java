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
		return null;
	}
	
	public LinkNode remove(int id){
		return null;
	}
	public void displayList(){
		
	}
}

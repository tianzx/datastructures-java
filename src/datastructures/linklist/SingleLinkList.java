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
		return null;
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
		
	}
}

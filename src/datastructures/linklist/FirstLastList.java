package datastructures.linklist;

public class FirstLastList {

	private LinkNode firstNode;
	
	private LinkNode lastNode;

	public void insertFirst(int id) {
		LinkNode newLink = new LinkNode(id);
		//check if has node
		if(firstNode==null) {
			lastNode = newLink;
		}
		newLink.setNext(firstNode);
		firstNode = newLink;
	}
	
	public void insertLast(int id){
		LinkNode newLink = new LinkNode(id);
		if(firstNode == null) {
			firstNode =  newLink;
		}else{
			lastNode.setNext(newLink);
		}
	}

	public LinkNode removeFirst() {
		LinkNode temp = firstNode;
		//check if reach the last node
		if(firstNode.getNext()==null){
			lastNode = null;
		}
		firstNode = firstNode.getNext();
		return temp;
	}

	public LinkNode find(int id) {
		LinkNode node = firstNode;
		while (node.getId() != id) {
			if (node.getNext() == null) {
				return null;
			} else {
				node = node.getNext();
			}
		}
		return node;
	}

	/**
	 * 1.check if first or last
	 * 2.if last 
	 * @param id
	 * @return
	 */
//	public LinkNode remove(int id) {
//		LinkNode needDelete = firstNode;
//		LinkNode previous = firstNode;
//		// search need delete node and its previous node
//		while (needDelete.getId() != id) {
//			if (needDelete.getNext() == null) {
//				return null;
//			} else {
//				previous = needDelete;
//				needDelete = needDelete.getNext();
//			}
//		}
//		// set node relation
//		if (needDelete.equals((firstNode))) {
//			firstNode = firstNode.getNext();
//		} else {
//			previous.setNext(needDelete.getNext());
//		}
//		return needDelete;
//	}

	public void displayList() {
		LinkNode tempNode = firstNode;
		while (tempNode != null) {
			tempNode.printLink();
			tempNode = tempNode.getNext();
		}
	}
}

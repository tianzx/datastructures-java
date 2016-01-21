package datastructures.linklist;

public class LinkNode {

	private int id;
	private LinkNode next;
	public LinkNode getNext() {
		return next;
	}
	public int getId() {
		return id;
	}
	public LinkNode(int id) {
		super();
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "LinkNode [id=" + id + ", next=" + next + "]";
	}
	
	public void printLink(){
		String s= "{id="+this.id;
		if(this.next!=null) {
			s+=" , next="+this.next.getId();
		}
		s+="}";
		System.err.println(s);
		
	}
	
}

package datastructures.linklist;

public class LinkNode2 {

	private int id;
	private LinkNode2 next ;
	private LinkNode2 previous;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LinkNode2 getNext() {
		return next;
	}
	public void setNext(LinkNode2 next) {
		this.next = next;
	}
	public LinkNode2 getPrevious() {
		return previous;
	}
	public void setPrevious(LinkNode2 previous) {
		this.previous = previous;
	}
	public void printLink(){
		String s= "{id="+this.id;
		if(this.previous!=null) {
			s+=" , previous="+this.previous.getId();
		}
		if(this.next!=null) {
			s+=" , next="+this.next.getId();
		}
		if(this.next!=null) {
			s+=" , next="+this.next.getId();
		}
		s+="}";
		System.err.println(s);
		
	}
	public LinkNode2(int id) {
		super();
		this.id = id;
	}
}

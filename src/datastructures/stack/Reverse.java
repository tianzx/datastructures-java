package datastructures.stack;
/**
 * String reverse by stack
 * @author tianzx
 *
 */
public class Reverse {

	public String doRev(String str){
		StringBuffer retStr = new StringBuffer();
		MyStack myStack = new MyStack(20);
		//1: read String
		char[] cs = str.toCharArray();
		//2: push(char)
		for(char c:cs) {
			myStack.push(c);
		}
		//3: pop()
		while(!myStack.isEmpty()) {
			char c = (char)myStack.pop();
			retStr.append(c);
		}
		return retStr.toString();
	}
	
	public static void main(String[] args) {
		Reverse rv = new Reverse();
		String str = rv.doRev("this is a reverse");
		System.err.println(str);
	}
}

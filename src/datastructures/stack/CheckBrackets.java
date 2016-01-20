package datastructures.stack;
/**
 * check express brackets is right
 * @author tianzx
 *
 */
public class CheckBrackets {

	public void check(String str) {
		MyStack myStack =  new MyStack(20);
		//1:convert string to char[]
		char[] cs = str.toCharArray();
		//2:if left bracket push()
		//3:if right bracket pop(),check
		int i=0;
		for(char c :cs) {
			if(c=='{'|| c=='[' ||c=='('){
				myStack.push(c);
			}else if(c=='}'||c==']'||c==')'){
				char msc = (char)myStack.pop();
				if((msc=='{'&&c!='}')|| (msc=='['&&c!=']') ||(msc=='('&&c!=')')) {
					System.err.println("匹配失败"+"位置为: "+i);
				}else{
					System.err.println("匹配成功");
				}
			}
			i++;
		}
	}
	public static void main(String[] args) {
		CheckBrackets cb = new CheckBrackets();
		cb.check("{}{]");
	}
}

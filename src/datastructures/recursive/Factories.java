package datastructures.recursive;

import java.math.BigInteger;

/**
 * show n!
 * 
 * @author tianzx
 *
 */
public class Factories {

	// 5!=5 * 4!
	// 4!=4 * 3!
	// ...
	// 1!=1 * 0!
	// 0!=1
	// N!= N *(N-1)!

	public int factories(int n) {

		// pay attention to when to exit
		if (n == 1) {
			return 1;
		}
		return n * factories(n - 1);
	}

	public BigInteger factories2(BigInteger n) {
		if (n.intValue() == 1) {
			return BigInteger.ONE;
		}
		return n.multiply(factories2(n.subtract(BigInteger.ONE)));
	}

	public int mySum(int n) {
		if(n==1) {
			return 1;
		}
		return n+mySum(n-1);
	}
	public static void main(String[] args) {
		Factories fx = new Factories();
		BigInteger ret = fx.factories2(new BigInteger("100"));
		int ret2 = fx.factories(5);
		int ret3 = fx.mySum(10);
		System.err.println(ret3);
		
	}

}

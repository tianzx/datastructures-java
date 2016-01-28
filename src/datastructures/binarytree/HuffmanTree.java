package datastructures.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * show huffman compress decompress
 * @author tianzx
 *
 */
public class HuffmanTree {

	public void compress(String str) {
		//1: statistics
		HuffmanPriorityQueue queue = this.statistics(str);
		//2: buildTree
		HuffmanNode tree = this.buidHuffmanTree(queue);
		//3: encode,tree left 0,tree right 1
		Map<String,String> map = new HashMap<String,String>();
		this.buildHuffmanCode(map,tree,"");
		//4： output
		this.outputData(str,map);
	}
	
	private void outputData(String str, Map<String, String> map) {
		
	}

	private void buildHuffmanCode(Map<String, String> map, HuffmanNode tree, String string) {
		
	}

	private HuffmanNode buidHuffmanTree(HuffmanPriorityQueue queue) {
		return null;
	}

	private HuffmanPriorityQueue statistics(String s) {
		return null;
	}
}

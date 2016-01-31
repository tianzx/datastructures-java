package datastructures.binarytree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * show huffman compress decompress
 * @author tianzx
 *
 */
public class HuffmanTree {

	public void compress(String str,String outFile) {
		//1: statistics
		HuffmanPriorityQueue queue = this.statistics(str);
		//2: buildTree
		HuffmanNode tree = this.buidHuffmanTree(queue);
		//3: encode,tree left 0,tree right 1
		Map<String,String> map = new HashMap<String,String>();
		this.buildHuffmanCode(map,tree,"");
		System.err.println(map);
		//4： output
		this.outputData(str,map,outFile);
	}
	/**
	 * output data to file
	 * @param str
	 * @param map
	 * @param outFile
	 */
	private void outputData(String str, Map<String, String> map,String outFileName) {
		File outFile = new File(outFileName);
		DataOutputStream os =null;
		try{
			os = new DataOutputStream(new FileOutputStream(outFile));
			this.outCodes(os, map);
			String dataHuffmanCode = this.source2HuffmanStr(str, map);
			this.outDataHuffmanCode(os, dataHuffmanCode);
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			try {
				os.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		//1:output code
		//2:
	}
	/**
	 * output source content conver to huffman encode list
	 * @param os
	 * @param dataHuffmanCode
	 * @throws IOException 
	 */
	private void outDataHuffmanCode(DataOutputStream os,String dataHuffmanCode) throws IOException {
		//1:convert to byte[]
		byte[] bs = this.string2byteArrays(dataHuffmanCode);
		//2:byte[] nums
		os.writeInt(bs.length);
		//3:output byte[]
		os.write(bs);
	}
	/**
	 * convert binary sys string to real byte array
	 * @param dataHuffmanCode
	 * @return
	 */
	private byte[] string2byteArrays(String dataHuffmanCode) {
		byte[] retBytes = null;
		char[] cs = dataHuffmanCode.toCharArray();
		int len = cs.length;
		int lenByte = 0;
		//1:
		if(len%8 ==0) {
			lenByte = len/8 +1;
			retBytes = new byte[lenByte];
			for(int i=0;i<lenByte-1;i++){
				String s="";
				for(int j=i*8;j<(i+1)*8;j++){
					s+=cs[j];
				}
				retBytes[i] = this.chars2byte(s);
			}
			//set 
			retBytes[lenByte-1] = 0;
		}else {
			// supplement 0 mark 0 nums
			lenByte = len/8 +2;
			retBytes = new byte[lenByte];
			int zeroNum = 8-len%8;
			for(int i=0;i<zeroNum;i++) {
				dataHuffmanCode+=0+"";
			}
			cs = dataHuffmanCode.toCharArray();
			for(int i=0;i<lenByte-1;i++){
				String s="";
				for(int j=i*8;j<(i+1)*8;j++){
					s+=cs[j];
				}
				retBytes[i] = this.chars2byte(s);
			}
			
			retBytes[lenByte-1] = (byte)zeroNum;
		}
		return retBytes;
	}
	/**
	 * char[] to byte
	 * @param s
	 * @return
	 */
	private byte chars2byte(String s){
		byte ret = 0;
		char[] cs =s.toCharArray();
		
		for(int i=0;i<cs.length;i++){
			//cal each char represent byte value
			byte tmepB = (byte)(Byte.parseByte(""+cs[i])*Math.pow(2, cs.length-i-1));
			ret =(byte)(ret +tmepB);
		}
		return ret;
	}
	private String source2HuffmanStr(String str,Map<String,String> map) {
		StringBuffer buffer = new StringBuffer();
		char[] cs = str.toCharArray();
		for(char c:cs) {
			buffer.append(map.get(""+c));
		}
		return buffer.toString();
	}
	/**
	 * output code
	 * @param os
	 * @param map
	 * @throws IOException 
	 */
	private void outCodes(DataOutputStream os,Map<String,String> map) throws IOException{
		//output code number
		os.writeInt(map.size());
		for(String key:map.keySet()) {
			//2:output each char,encode length
			os.writeChar(key.charAt(0));
			os.writeInt(map.get(key).length());
			//3:output each char huffman encode
			os.writeChars(map.get(key));
		}
	}
	/**
	 * according to huffman build each char to huffman node
	 * @param map
	 * @param tree
	 * @param string
	 */
	private void buildHuffmanCode(Map<String, String> map, HuffmanNode tree, String zeroOrOneStr) {
		//1:tree dont hava children
		if(tree.getLeftChild()==null &&tree.getRightChild()==null){
			map.put(""+tree.getC(), zeroOrOneStr);
		}
		//2:left child node
		if(tree.getLeftChild()!=null){
			this.buildHuffmanCode(map, tree.getLeftChild(), zeroOrOneStr+"0");
		}
		//3:right child node
		if(tree.getRightChild()!=null){
			this.buildHuffmanCode(map, tree.getRightChild(), zeroOrOneStr+"1");
		}
	}
	/**
	 * construct huffman tree
	 * @param queue
	 * @return
	 */
	private HuffmanNode buidHuffmanTree(HuffmanPriorityQueue queue) {
		while(queue.size()-1>0) {
			//1:the lightest weight node
			HuffmanNode n1= queue.remove();
			HuffmanNode n2= queue.remove();
			//2:construct n1 n2 parent
			HuffmanNode n3 = new HuffmanNode((char)0,n1.getCount()+n2.getCount());
			n3.setLeftChild(n1);
			n3.setRightChild(n2);
			//3:put parent object in queue
			queue.insert(n3);
		}

		return queue.peekFront();
	}
	/**
	 * statistics char frequency, 
	 * @param s source
	 * @return
	 */
	private HuffmanPriorityQueue statistics(String s) {
		//1：statistics count
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] cs = s.toCharArray();
		for(char c:cs) {
			Object obj = map.get(c);
			if(obj==null){
				map.put(c, 1);
			}else{
				map.put(c,(Integer)obj+1);
			}
		}
		//2: construct priority queue
		HuffmanPriorityQueue queue = new HuffmanPriorityQueue(map.size());
		for(char c:map.keySet()){
			HuffmanNode node = new HuffmanNode(c, map.get(c));
			queue.insert(node);
			
		}
		return queue;
	}
	/**
	 * read file get compressed file
	 * @param fileName
	 * @return
	 */
	public String readFile(String fileName) {
		StringBuffer  buffer = new StringBuffer();
		DataInputStream in  =null;
		try {
				in = new DataInputStream(new FileInputStream(new File(fileName)));
				String tempStr = "";
				while((tempStr = in.readLine())!=null){
					buffer.append(tempStr+"\n");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		System.err.println("welcome ...");
		HuffmanTree t = new HuffmanTree();
		t.compress(t.readFile("HuffmanTree.java"),"temp.txt");
	}
}

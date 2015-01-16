import java.io.*;
import java.util.*;

public class PracticeHashTableChaining {
	private class HashtableNode{
		private Object key;
		private Object data;

		public HashtableNode(){
			this.key = null;
			this.data = null;
		}

		public HasthableNode(Object inKey, Object inData){
			this.key = inKey;
			this.data = inData;
		}

		public Object getData(){
			return data;
		}

		public Object getKey(){
			return key;
		}

		public void setData(Object data){
			this.data = data;
		}

		public void setKey(Object key){
			this.key = key;
		}

		public boolean equals(Object obj){
			if(obj instanceof HashtableNode){
				Hashtable node = (HashtableNode)obj;
				return this.key.equals(node.getKey());
			}
			else{
				return false;
			}
		}

		public String toString(){
			return "Key: ["+this.key+"] data: ["+this.data+"]";
	
		}
	}

	private final int tableSize = 20;
	private int numElements;
	private Object [] table;

	private int hash(Object key){
		
		/* Start with a base, just so that it's not 0 for empty strings */
		int result = 35;

		String intputString = key.toString().toLowerCase();
		char[] characters = inputString.toCharArray();
		for(int i = 0; i < characters.length; i++){
			char currentChar = characters[i];

			int j = (int)currentChar;
			result += j;
		}

		return (result % this.tableSize);
	}

	public void add(Object key, Object data){
		if(data == null || key == null){
			System.err.println("ERROR: Either the Key or the data are null");
			return;
		}
		
		int index = hash(key);
		if(table[index]==NULL){
			LinkedList <HashtableNode> nodeList = new  LinkedList<HashtableNode>();
			nodeList.add(new HashtableNode(key,data));
			table[index] = nodeList;
		}
		else{
			if()
		}


		/" don't add"
	}

	
}
import java.io.*;
import java.util.*;

public class PracticeHashtableChaining {
	private class LinkedHashtableNode{
		private Object key;
		private Object data;
		private LinkedHashtableNode next;
		public LinkedHashtableNode(){
			this.key = null;
			this.data = null;
			this.next = null;
		}

		public LinkedHashtableNode(Object inKey, Object inData){
			this.key = inKey;
			this.data = inData;
			this.next = null;
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

		public LinkedHashtableNode getNext() {
            return this.next;
      	}
		public void setNext(LinkedHashtableNode next){
			this.next = next;
		}
		public String toString(){
			return "Key: ["+this.key+"] data: ["+this.data+"]";
	
		}
	}

	private final static int TABLE_SIZE = 128;
	private LinkedHashtableNode[] table;

	PracticeHashtableChaining (){
		table = new LinkedHashtableNode[TABLE_SIZE];
		for(int i = 0; i < TABLE_SIZE; i++){
			table[i] = null;
		}
	}
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

		return (result % TABLE_SIZE);
	}

	public void put(Object key, Object data){
		if(data == null || key == null){
			System.err.println("ERROR: Either the Key or the data are null");
			return;
		}
		
		int index = hash(key);
		if(table[index]== null){
			table[index] = new LinkedHashtableNode;
		}
		else{
			LinkedHashtableNode e = table[index];
			while(e.getNext()!=null && ee.getKey() != key){
				e = e.getNext();
			}
			if(e.getKey() == key){
				e.setValue(value);
			}
			else{
				e.setNext(new LinkedHashtableNode(key,value));
			}
		}
	}

	public void remove(int key){
		if( key == null){
			System.err.println("ERROR: Either the Key or the data are null");
			return;
		}
		int index = hash(key);

		if(table[index] == null){
			System.err.println("ERROR: Table index is empty");
		}
		else{
			LinkedHashtableNode prevNode = null;
            LinkedHashtableNode node = table[index];
			while(node.getNext() != null && node.getKey() != key){
				prevNode = node;
				node = nod.getNext();
			}

			if(node.getKey() == key){
				if(prevNode == null){
					table[index] = node.getNext();
				}
				else{
					prevNode.setNext(node.getNext());
				}
			}
		} 



	}



	
}
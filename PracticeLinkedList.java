import java.io.*;
import java.util.*;

public class PracticeLinkedList{
	public static void main(String[] args){
		PracticeLinkedList lList = new PracticeLinkedList();

		// add elements to LinkedList
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");

		/*
         * Please note that primitive values can not be added into LinkedList
         * directly. They must be converted to their corresponding wrapper
         * class.
         */
 
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList.size() - print linkedlist size: " + lList.size);
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.remove(2) - remove 2nd element: " + lList.remove(2));
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.size() - print linkedlist size: " + lList.size);
        System.out.println("lList - print linkedlist: " + lList);
        lList.printElements();
	}

	Node head;
	Node tail;
	int size;
	public PracticeLinkedList(){
		head = new Node(null, null);
		tail = head;
		size = 0;
	} 

	

	public void printElements(){
		Node temp = head;
		System.out.println("Values ");
		int i = 0;
		while(temp!=tail){
			System.out.println("Value " + i + ": " + temp.next.value);
			i++;
			temp = temp.next;
		}
	}

	public void add(Object value){
		tail.next = new Node(value, null);
		tail.next.value = value;
		tail = tail.next;
		size++; 
	}

	public boolean remove(int index){
		Node temp = head;
		if(temp==tail){
			return false;
		}

		if(index+1<=size){
			for( int i = 0; i <index-1; i++){
				temp = temp.next;
				if(temp==tail){
					return false;
				}		
			}

			temp.next.value = null;
			temp.next = temp.next.next;
			size--;
			return true;
		}
		else{
			return false;
		}
	}



	public Object get(int index){
		Node temp = head;
		if(temp==tail){
			return null;
		}

		if(index+1<=size){
			for( int i = 0; i <index-1; i++){
				temp = temp.next;
				if(temp==tail){
					return false;
				}		
			}

			return temp.next.value;
		}
		else{
			return null;
		}

	}

	private class Node{
		Object value;
		Node next;

		public Node(Object value, Node next){
			this.value = value;
			this.next  = next;
		}
	}
	
}

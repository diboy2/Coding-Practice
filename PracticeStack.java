import java.io.*;
import java.util.*;

public class PracticeStack{
	public static void main(String[] args){
		PracticeStack p= new PracticeStack();

		// add elements to LinkedList
        p.push(0);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);

		/*
         * Please note that primitive values can not be added into LinkedList
         * directly. They must be converted to their corresponding wrapper
         * class.
         */
 		p.printElements();
        System.out.println("print practice: " + p);
        System.out.println("p.size : print size (Should be size 5) : " + p.size);
        System.out.println("p.top() : get top element: " + p.top());
        System.out.println("p.pop() : remove top element: " + p.pop());
        System.out.println("p.top() : get top element after removal: " + p.top());
        System.out.println("p.size: get size after removal: " + p.size);
        System.out.println("print practice:  " + p);
        p.printElements();
	}

	private class Node{
		Node next;
		Object element; 
		public Node(Node n, Object e){
			this.next = n;
			this.element = e;
		}
	}

	Node top;
	int size;

	public PracticeStack(){
		top = new Node(null, null);
		size = 0;
	}

	public void push(Object e){
		Node oldTop = top;
		top = new Node(oldTop,e);
		size++;	
	}

	public Object pop(){
		if(size==0 || top.next == null){
			return false;
		}
		Node oldTop = top;
		top = top.next;
		size--;
		return oldTop.element;

	}

	public Object top(){
		return top.element;
	}

	public void printElements(){
		Node temp = top;
		System.out.println("Values ");
		int i = size-1;
		while(temp.next!=null){
			System.out.println("Value " + i + ": " + temp.element);
			i--;
			temp = temp.next;
		}
	}
}
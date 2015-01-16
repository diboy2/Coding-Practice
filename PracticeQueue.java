import java.io.*;
import java.util.*;

public class PracticeQueue{
	public static void main(String[] args){
		PracticeQueue p= new PracticeQueue();

		// add elements to LinkedList
        p.enqueue(0);
        p.enqueue(1);
        p.enqueue(2);
        p.enqueue(3);
        p.enqueue(4);

		/*
         * Please note that primitive values can not be added into LinkedList
         * directly. They must be converted to their corresponding wrapper
         * class.
         */
 		p.printElements();
        System.out.println("print practice: " + p);
        System.out.println("p.size : print size (Should be size 5) : " + p.size);
        System.out.println("p.peek() : get first element: " + p.peek());
        System.out.println("p.dequeue() : remove first element: " + p.dequeue());
        System.out.println("p.peek() : get first element after removal: " + p.peek());
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
	Node last;
	Node first;
	int size;
	PracticeQueue(){
		first = null;
		last = null;
		size = 0;
	}

	public void enqueue(Object e){
		Node oldLast = last;
		last = new Node(null, e);
		if (size==0){
			first = last;
		}else{
			oldLast.next = last;
		}
		size++;
	}

	public Object dequeue(){
		Node oldFirst = first;
		if(size!=0){
			first = first.next;
		}else{
			return false;
		}
		size--;
		return oldFirst.element;
	}

	public Object peek(){
		if(size!=0){
			return first.element;
		}
		else{
			return false;
		}
	}

	public void printElements(){
		System.out.println("Values ");
		int i = 0;
		Node temp = first;

		while(temp!=null){
			System.out.println("Value " + i + ": " + temp.element);
			i++;
			temp = temp.next;
		}
	}




}
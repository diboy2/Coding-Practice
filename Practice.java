import java.io.*;
import java.util.*;

public class Practice{
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

	public class PracticeBinarySearchTree{
		Node root;

		public PracticeBinarySearchTree(){
			root = NULL;
		}

		public boolean insert(Object value){
			if(root==NULL){
				root.value  = value;
			}else{
				Node current = root;
				Node parent = current;
				boolean isLeft = true;
				while(current!=NULL){
					if(value<current.value){
						parent = current;
						current = current.leftNode;
						isLeft = true;
					}
					else if(value>current.value){
						parent = current;
						current = current.rightNode;
						isLeft = false;
					}
					else{
						return false;
					}
				} 
				if(isLeft){
					parent.leftNode = new Node(value, null, null);
				}
				else{
					parent.rightNode = new Node(value, null, null);
				}
				return true;
			}
		}

		public boolean search(Object value){
			if(root==NULL){
				return false;
			}else{
				Node current = root;
				Node parent = current;
				while(current!=NULL){
					if(value<current.value){
						current = current.leftNode;
					}
					else if(value>current.value){
						current = current.rightNode;
					}
					else{
						return true;
					}
				} 
				return false;
			}
		}

		public boolean remove(Object value){
			if(search(value)){
				Node current = root;
				Node parent = current;
				while(current!=NULL){
					if(value<current.value){
						parent = current
						current = current.leftNode;
					}
					else if(value>current.value){
						parent = current;
						current = current.rightNode;
					}
					else{
						if(current.value){
							if(current.leftNode == null){
								current = current.rightNode;
								return true;
							}
							else if(current.rightNode  == null ){
								current = current.leftNode;
								return true;
							}
							else{
								Node temp = current.leftNode;
								Node tempParent = temp;
								while(temp.rightNode!=null){
									temp = temp.rightNode;
								}
								current.value = temp.value;
								tempParent.rightNode = temp.leftNode;
								return true;

							}
						}
					}
				} 
			}
		}
	}

	private class Node{
		Object value;
		Node leftNode;
		Node rightValue;

		public Node(Object value, Node leftNode, Node rightNode){
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}

	
}

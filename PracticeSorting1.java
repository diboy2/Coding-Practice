import java.io.*;
import java.util.*;

public class PracticeSorting1{
	ArrayList<Integer> pList;
	Random randomGenerator;
		
	public static void main(String[] args){
		

	}


	public void bubbleSort(){
		pList = new ArrayList<Integer>();
		fillArrayList(pList);

		for (int k = 1; k  < pList.size(); i++){
			for(int i = 0; i < pList.size(); i++){
				if(pList[i] > pList[i+1]){
					int temp = pList[i];
					pList[i] = pList[i+1];
					pList[i+1] = temp;
				}
			}
		}


	}



	public void fillArrayList(ArrayList<Integer> arrList){
		
		randomGenerator = new Random();
		Integer next;
		for(int i = 0; i<16; i++){
			 next = randomGenerator.nextInt(100);
			 arrList.add(next);
		}
	}

	public void printArray(ArrayList<Integer> arrList){

	}

	public void mergeSort(){
		pList = new ArrayList<Integer>();
		fillArrayList(pList);

		

		return 
	}


	public ArrayList<Integer> sort(ArrayList<Integer> arrList){
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int center;
		if(arrList.size() > 1){
			center = arrList.size()/2;

			for(int i=0; i < center; i++){
				left.add(arrList[i]);
			}

			for( int i=center; i<arrList.size(); i++){
				right.add(arrList[i]);
			}

			sort(left);
			sort(right);
			return merge(left, right,arrList.size());
		}
		return arrList;

	}

	public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, int size){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int leftIndex = 0;
		int rightIndex = 0;

		for(int i=0; i<size; i++){
			if(left[leftIndex]<right[rightIndex] || rightIndex>=right.size(){
				arrList.add(left[leftIndex]);
				leftIndex++;
			}
			else{
				arrList.add(right[rightIndex]);
				rightIndex++;
			}
		}

		return arrList;

	}

	

}
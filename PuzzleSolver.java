import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuffer;
import java.util.Scanner;
 
public class PuzzleSolver{

    public static String[] DICTIONARY = {"OX","CAT","TOY","AT","DOG","CATAPULT","T"};
    //Change to determine input. All strings must be the same length.
    public static String[] STRINGARRAY = { "CATAPULT", "XZTTOYOO","YOTOXTXX" };
    
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> occurrences = new ArrayList<String>();
    

    public static void main(String[] args){
        char[][] char2D = convertStrArrToChar(STRINGARRAY); 
        PuzzleSolver p = new PuzzleSolver();

        int numOccurrences = p.findWords(char2D);        

        p.printOccurrences();
        System.out.println("Number of occurrences: " + numOccurrences);
        
    }
    // Change array of strings to char 2D array
    public static char[][] convertStrArrToChar(String[] strArr){
        char[][] char2D = new char[strArr.length][];

        for (int i = 0; i < strArr.length; i++) {
            char2D[i] = strArr[i].toCharArray();
        }

        for (char[] char1D : char2D) {
            for (char c : char1D){
                System.out.print(c + " ");
            }
             System.out.println();
        }
        System.out.println();
        return char2D;
    }

    private boolean isWord(String testWord){

        if (Arrays.asList(DICTIONARY).contains(testWord)){
            return true;
        }
        return false;

    }

    public  int findWords(char[][] c2D){
        //fill words array with all words from 2d char array
        getHorizontalWords(c2D);
        getVerticalWords(c2D);
        getDiagonalWords(c2D);

        System.out.print("Words: ");
        for(int i = 0; i < words.size(); i++){
            System.out.print(words.get(i) + " ");
        }
        System.out.println();
        
        addOccurrencesPerWord(occurrences);
        addOccurrencesPerChar(occurrences,c2D);
        return occurrences.size();
    }

    public void printOccurrences(){
        System.out.print("Values: ");
        for(int i = 0; i < occurrences.size(); i++){
            System.out.print(occurrences.get(i) + " ");
        }
        System.out.println();
    }
   
  

    private void getHorizontalWords(char[][] c2D){
        for(char[] horChar:c2D){ //Add all rows of words to arraylist
            String tempString = new String(horChar);
            words.add(tempString);
        } 
    }

    private void getVerticalWords(char[][] c2D){
        String tempString; 
        for(int i = 0; i < c2D[0].length;i++){
            tempString = new String(); //Add all columns of words to arraylist
            for(int j = 0; j < c2D.length; j++){
                tempString += c2D[j][i]; //Start at top and add each char to bottom
            }
            words.add(tempString);
        }
    }
    //Find all diagonal words by scouring perimeter of array
    private void getDiagonalWords(char[][] c2D){
        String tempString;
        // Start at [0,0] to [0,n] and get all words in / direction 
        for(int i = 0; i < c2D[0].length;i++){
            tempString = new String();
            for(int j = 0, k=i; j < c2D.length && k >= 0; j++, k--){
                tempString += c2D[j][k];
            }
            if(tempString.length()>1){
                words.add(tempString);
            }
        }
        // Start at [0,n] to [n,n] and get all the words in / direction
        for(int i = 1; i < c2D.length;i++){
            tempString = new String();
            for(int j = c2D[0].length-1, k=i; j >= 0  &&  k < c2D.length ; j--, k++){
                tempString += c2D[k][j];
            }
            if(tempString.length()>1){
                words.add(tempString);
            }
        }

        // Start at [n,0] to [n,n] and get all the words in \ direction
        for(int i = 0; i < c2D[0].length; i++){
            tempString = new String();
            for(int j = c2D.length-1, k = i; j >= 0 && k >= 0; j--, k--){
                tempString += c2D[j][k];
            }
            if(tempString.length()>1){
                words.add(tempString);
            }
        }
        // Start at [n,n] to [0,n] and get all the words in \ direction
        for(int i = 1; i >=0 ;i--){
            tempString = new String();
            for(int j = c2D[0].length-1, k=i; j >= 0  &&  k >=0 ; j--, k--){
                tempString += c2D[k][j];
            }
            if(tempString.length()>1){
                words.add(tempString);
            }
        }
        
    }
    // add occurences of size greater than 1
    private void addOccurrencesPerWord(ArrayList<String> oC){
        String wReverse;
        for(int i = 0; i<words.size(); i++){
            getOccurrences(oC, words.get(i)); 
            wReverse = new StringBuffer(words.get(i)).reverse().toString();
            getReverseOccurrences(oC, wReverse); 
        }
    }
    // add occurences of size 1
    private void  addOccurrencesPerChar(ArrayList<String> oC, char[][] char2D){
        for (char[] char1D : char2D) {
            for (char c : char1D){
                String charString = ""+c;
                if(isWord(charString )){
                    oC.add(charString );
                }
            }
        }
    }
    // Example: CATAPULT 
    // CATAPU is checked for occurences which is passed to addOccurrences. 
    private void getOccurrences(ArrayList<String> oC, String w){
        while(w.length() >1){
            addOccurrences(oC,w);  // find all occurrences for every iteration
            w = removeLastChar(w); //every iteration remove last char
        }
    }

    // It's different cause I have to check for palindromes
    private void getReverseOccurrences(ArrayList<String> oC, String w){
        while(w.length() >1){
            addReverseOccurrences(oC,w); // find all occurrences for every iteration
            w = removeLastChar(w); //every iteration remove last char
        }
    }

    private String removeLastChar(String w){
        return (w.substring(0, w.length()-1)); //Remove the last char of string and return substring
    }

    //Use recursion to find occurrences in by checking every substring of w
    // Example: CATAPU. Checks CATAPU, ATAPU, TAPU, APU, PU 
    private void addOccurrences(ArrayList<String> oC, String w){
        if(w.length() > 1){ 
           if(isWord(w)){
            oC.add(w); //add to occurrences arraylist
            }
            addOccurrences(oC,w.substring(1));  // Shrink string by removing first char    
        }

    }

    //Necessary Function to check for palindromes so they don't count twice but works similar to above function
    private void addReverseOccurrences(ArrayList<String> oC, String w){
        String reverseString = new StringBuffer(w).reverse().toString();
        if(!reverseString.equals(w) && isWord(w)){
            oC.add(w);
        }

        if(w.length() > 1){ 
            
            addReverseOccurrences(oC,w.substring(1)); // Shrink string by removing first char     
        } 
    }

   



}
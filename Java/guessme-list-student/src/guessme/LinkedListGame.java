package guessme;

/********************************************************
* NOTE: for this project you must use linked lists
* implemented by yourself. You are NOT ALLOWED to use
* Java arrays of any type, or any class in the java.util
* package (such as ArrayList).
*******************************************************/
/********************************************************	 
*NOTE: you are allowed to add new methods if necessary,
* but DO NOT remove any provided method, and do NOT add
* new files (as they will be ignored by the autograder).
*******************************************************/

// LinkedListGame constructor method  

public class LinkedListGame { 
	int numguesses;
	boolean gameOver;
	LinkedList candidate;
	LinkedList guessed;	
	private	int guess;
	
   public LinkedListGame() {      
       reset();    
   }
  
  
   
   public void reset() {
	   this.guess = 1000;     
       this.numguesses = 0;
       this.gameOver = false;
       this.guessed = new LinkedList();
      
       this.candidate = new LinkedList();
      
       for(int i = 1000; i < 10000; i++){
           candidate.append(i);
       }
   }


   public boolean isPriorGuess(int n) {
       if(guessed == null){
           return false;
       }
           //LLIntegerNode current = guessed;
       if(guessed.contains(n)){
           return true;
       }
      
       return false;
   }
  

   public int numGuesses() {
       // TODO
       return numguesses;
   }
   
   /**
    * Returns the number of matches between integers a and b.
    * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
    * The return value must be between 0 and 4.
    * 
    * <p>A match is the same digit at the same location. For example:
    *   1234 and 4321 have 0 match;
    *   1234 and 1114 have 2 matches (1 and 4);
    *   1000 and 9000 have 3 matches (three 0's).
    */
   
   public static int numMatches(int a, int b) { 
	   // DO NOT remove the static qualifier
	    // TODO
	    int count=0;
	    if(a/1000==b/1000) {
	      count++;
	    }
	    if((a/100)%10==(b/100)%10) {
	      count++;
	    }
	    if((a/10)%10==(b/10)%10) {
	      count++;
	    }
	    if(a%10==b%10) {
	      count++;
	    }
	    return count;
	  }

  
   public boolean isOver() {
       return gameOver;
   }
  
   public int getGuess() {
       numguesses++;
      
       if(guessed == null){
           guessed = new LinkedList();
       }
       guessed.append(guess);
      
       return guess;
   }
   public boolean updateGuess(int nmatches) {  
       if(nmatches == 4){
           gameOver = true;
           return true;
       }
      
       LinkedList updated = new LinkedList();
       LLIntegerNode newnode = candidate.head();
      
       while(newnode != null){      	   
           if(numMatches(newnode.getInfo(), guess) == nmatches){
               updated.append(newnode.getInfo());
           }         
           newnode = newnode.getLink();
       }   
             
       candidate = updated;
       
       /* LLIntegerNode current=candidate.head();
      while(current!=null) {   	   
    	   System.out.println(current.getInfo());
    	  current=current.getLink();
    	   }*/
       
       
       if(candidate.head() != null){
       guess = candidate.head().getInfo();
       return true;
       }
       
   return false;
   }

   public LLIntegerNode priorGuesses() {
       if(guessed == null){
           return null;
       }    
       return guessed.head();  
       
       }
   
   public String priorGuessesString() {
       String answer= "";
       
       if(guessed.head() == null){
           return "";
       }
       LLIntegerNode current = guessed.head();
       while(current.getLink()!= null){
    	   answer += current.getInfo() + ", ";
           current = current.getLink();
       }
       answer = answer + current.getInfo();
       return answer;
   }
   
   
   
}
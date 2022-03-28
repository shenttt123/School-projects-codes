package guessme;

public class LinkedList {
	
   private LLIntegerNode head;
   private LLIntegerNode tail;
      
   public LinkedList() {
       this.head=null;
       this.tail=null;
   }
  
   public LLIntegerNode head(){
       return head;
   }
   public LLIntegerNode tail(){
       return tail;
   }
   public void append(Integer n) {
       LLIntegerNode newnode = new LLIntegerNode(n, null);
       if(tail == null) {
           head = newnode;
       }
       else{
       tail.setLink(newnode);  
   }
       tail=newnode;
   }
   
   public boolean contains(int n) {
       LLIntegerNode current = head;
       while (current != null) {
           if (current.getInfo() == n) {
               return true;
           }
           current = current.getLink();
       }
       return false;
   }
   
   
}

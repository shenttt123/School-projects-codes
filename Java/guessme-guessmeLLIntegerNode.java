package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
  // TODO
	 int info;
	 private LLIntegerNode link;
	 private LLIntegerNode prev;
	
	
	public LLIntegerNode(int info, LLIntegerNode link) {
		this.info=info;
		this.link=link;
		prev=this;
	}
	
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info=info;
		prev.info=this.info;
	}
	
	public LLIntegerNode getLink() {
		return link;
	}
	public void setLink(LLIntegerNode link) {
		prev=this;
		this.link=link;
	}
	public LLIntegerNode getPrev() {
		return prev;
	}
	
	
}


package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RecursiveList<T> implements ListInterface<T> {


	
	class LLNode {
	    private T data;
	    private LLNode link;
	    
	    public LLNode(T data) { 
	      this.data = data;
	    }
	    
	    public LLNode(T data, LLNode next) {
	      this.data = data; 
	      this.link = next;
	    }
	    public void setData(T data) {
	           this.data = data;
	        }
	    public void setLink(LLNode link) {
	           this.link = link; 
	        }
	    public T getData() {
	           return this.data;
	        }
	    public LLNode getLink() {
	           return link;
	        }
	    
	    
	  } 
	
	private LLNode head;
	private int size = 0;
	


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		// TODO Auto-generated method stub
		if(elem==null) {
			throw new NullPointerException();}
		
			LLNode newNode = new LLNode(elem);
			newNode.setLink(head);	
			head=newNode;	
		    size++;
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		
		insertAt(size,elem);
		
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		if(elem==null) {
			throw new NullPointerException();}
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException();}
		if(index==0) {
			insertFirst(elem);
		}
		else {
			LLNode prev = findNode(index-1,0,head);
			LLNode next=prev.getLink();
			LLNode newNode = new LLNode(elem);
			
			prev.setLink(newNode);
			newNode.setLink(next);
			
		size++;}
		return this;
	}

	@Override
	public T removeFirst() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		T removed=head.getData();
		if(size!=1) {
		head=head.getLink();}
		size--;
		return removed;
		
	}

	@Override
	public T removeLast() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}		
		if(size==1) {
			return removeFirst();
		}
		
		LLNode lasttwo=findNode(size-2,0,head);
		T removed=lasttwo.getLink().getData();
		lasttwo.setLink(null);
		size--;
		return removed;
	}

	@Override
	public T removeAt(int i) {
		// TODO Auto-generated method stub
		if(i<0||i>=size) {
			throw new IndexOutOfBoundsException();
		}
		
		else if(i==0) {
			return removeFirst();
		}
		else if (i==size-1) {
			return removeLast();
		}
		
			LLNode prev=findNode(i-1,0,head);	
			T removed=prev.getLink().getData();
			LLNode next=prev.getLink().getLink();		
			prev.setLink(next);
			size--;
			
		return removed;
		
	}

	@Override
	public T getFirst() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		
	  return head.getData();
	}

	@Override
	public T getLast() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		
		T a=get(size-1);
	  return a;
	}

	@Override
	public T get(int i) {
		
		if(i<0||i>=size) {
			throw new IndexOutOfBoundsException();
		}
		return  findNode(i,0,head).getData();
	}
	
	
	public LLNode findNode(int index, int count, LLNode curr) {
		if(index==count) {
			return curr;
		}
		else 
			{count++;
			curr=curr.getLink();
		return findNode(index,count,curr);}
	}

	@Override
	public boolean remove(T elem) {
		
		if(elem==null) {
			throw new NullPointerException();}
		
		int i=indexOf(elem);
		if(i==-1) {
			return false;
		}else {
			removeAt(i);
			return true;
		}
		
		
	}

	@Override
	public int indexOf(T elem) {
		if(elem==null) {
			throw new NullPointerException();}
		
		return indexOfhelper(elem,0,head);
	}
	
	public int indexOfhelper(T elem, int index, LLNode curr) {
		if(curr==null) {
			return -1;
		}
		else if(curr.getData()==elem) {
			
			return index;
		}else {
			curr=curr.getLink();
			index++;
			return indexOfhelper(elem,index,curr);
		}	
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size==0);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

package sets;

import java.util.Iterator;

/**
 * A LinkedList-based implementation of Set
 */

/********************************************************
 * NOTE: Before you start, check the Set interface in
 * Set.java for detailed description of each method.
 *******************************************************/

/********************************************************
 * NOTE: for this project you must use linked lists
 * implemented by yourself. You are NOT ALLOWED to use
 * Java arrays of any type, or any Collection-based class 
 * such as ArrayList, Vector etc. You will receive a 0
 * if you use any of them.
 *******************************************************/ 

/********************************************************
 * NOTE: you are allowed to add new methods if necessary,
 * but do NOT add new files (as they will be ignored).
 *******************************************************/

public class LinkedSet<E> implements Set<E> {
  
  private LinkedNode<E> head = null;
  int count=0;
  
  // Constructors
  public LinkedSet() {
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  }

  @Override
  public int size() {
    // TODO (1)
	  
	  Iterator<E> iter = this.iterator();
  	  while(iter.hasNext()) {
  		iter.next();
  		  count++;
  	  }
    return count;
  }

  @Override
  public boolean isEmpty() {
    // TODO (2)
    return (count==0);
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
	  
	  Iterator<E> iter = this.iterator();
	  	  while(iter.hasNext()) {
		  Object obj = iter.next();	
		  
		  if(obj.equals(o)) { 		  
			  return true;
		  }
	  }
    return false;
 // TODO (3)
  }

  @Override
  public boolean isSubset(Set<E> that) {
	  
	  
	  for ( E elem :this ) {
	     if( !that.contains(elem)) {
	    	return false;}  
	    }   
    return true;
    // TODO (4)
  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)
	  if(that.isSubset(this)) {
		  return true;
	  }
    return false;
  }

  @Override
  public Set<E> adjoin(E e) {
	  
	  if(!this.contains(e))
      {   			  
		  return new LinkedSet<E>(new LinkedNode<E>(e, this.head));		    
      }
		  return this;  
    // TODO (6) 
  }

  @Override
  public Set<E> union(Set<E> that) {
	   Set<E> newSet=new LinkedSet<E>(head);
       Iterator<E> itr=that.iterator();
          while(itr.hasNext()) {newSet=newSet.adjoin(itr.next());}
      return newSet;
    // TODO (7)
  }

  @Override
  public Set<E> intersect(Set<E> that) {
	  Set<E> newSet=new LinkedSet<E>();
	  for(E e:that) {
          if (this.contains(e))
           newSet=newSet.adjoin(e);  }
    // TODO (8)
    return newSet;
  }

  @Override
  public Set<E> subtract(Set<E> that) {
	  Set<E> newSet=new LinkedSet<E>();
	  for(E e:this) {
		  if (!that.contains(e))
             newSet = newSet.adjoin(e);}
    // TODO (9)
    return newSet;
  }

  @Override
  public Set<E> remove(E e) {
	  Set<E> newSet=new LinkedSet<E>();
	  for(E a:this) {
		  if(!e.equals(a)) {
			  newSet=newSet.adjoin(a);
		  }  
	  }    // TODO (10)
    return newSet;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
  public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
}

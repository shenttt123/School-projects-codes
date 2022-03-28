package structures;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {
	
	class Node<T> {
	    public T data;
	    public Node<T> next;
	    
	    public Node(T data) { 
	      this.data = data;
	    }
	    
	    public Node(T data, Node<T> next) {
	      this.data = data; 
	      this.next = next;
	    }
	    
	  }

    private Node<T> front; 
	private Node<T> rear;
	private int size = 0;

  public Queue() {
    // TODO 1
	  front = null;
	  rear = front;
	  
  }

  public Queue(Queue<T> other) {
    // TODO 2
	 
	  if(!other.isEmpty()) {
			for(int i = 0; i < other.size; i++) {
				T a = other.dequeue();
				other.enqueue(a);
				this.enqueue(a);			
			} 
		}
  }

  @Override
  public boolean isEmpty() {
    // TODO 3
    return (size==0);
  }

  @Override
  public int size() {
    // TODO 4
    return  size;
  }

  @Override
  public void enqueue(T element) { 
    // TODO 5
	  Node<T> newNode = new Node<T>(element);
	  if (rear == null) {
	  front = newNode;
	  rear = newNode;
	  } else {
	  rear.next = newNode;
	  rear = newNode;
	  }
	  size++;
	  
  }

  @Override
  public T dequeue() throws NoSuchElementException {
    // TODO 6
	  	if(front == null || isEmpty()) {
				throw new NoSuchElementException("empty queue");
			}
		  else {
		  T element = front.data;
		  front = front.next;
		  size--;
		  if (front == null)
		  rear = null;
		  return element;
		  }

  }

  @Override
  public T peek() throws NoSuchElementException {
    // TODO 7
	  if(isEmpty()) {
			throw new NoSuchElementException();
		}
	  return front.data;
  }


  @Override
  public UnboundedQueueInterface<T> reversed() {
    // TODO 8
	  Queue<T> rev=new Queue<T>();
      T[] array=(T[])new Object[this.size()];
      Node<T> temp=this.front;
      int count=0;
      while(temp!=null)
      {
      	array[count++]=temp.data;
      	temp=temp.next;
      }
      	for(int i=count-1;i>=0;--i)
      		rev.enqueue(array[i]);
      	return rev;
	}
}



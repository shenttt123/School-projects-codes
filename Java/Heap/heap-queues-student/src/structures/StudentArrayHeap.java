package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	

	

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override	
	protected int getLeftChildOf(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		return (index * 2) + 1;
	}

	@Override	
	protected int getRightChildOf(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		return (index * 2) + 2;
	}

	@Override	
	protected int getParentOf(int index) {
		if (index < 1)
			throw new IndexOutOfBoundsException();
		return (index - 1) / 2;
	}

@Override
	protected void bubbleUp(int index) {
		
		 		
		if (index == 0)
			return;
		
		while (comparator.compare(  heap.get(this.getParentOf(index)).getPriority(),  heap.get(index).getPriority()) < 0) {
			
			int parent = this.getParentOf(index);
			swap(parent,index);
			index = parent;
			if (index == 0) return;
		}
		
	}

@Override
	protected void bubbleDown(int index) {		
		int largerchild;		
		while (index<heap.size()/2) {
			
					
			if (getRightChildOf(index) >= heap.size()) {
					if (comparator.compare(  
							heap.get(this.getLeftChildOf(index)).getPriority(), 
							heap.get(index).getPriority()) > 0) 
					{
						largerchild = getLeftChildOf(index);
					} 
					else {
						return;
					}
			} 
			
			
			else if (comparator.compare(heap.get(this.getLeftChildOf(index)).getPriority(),heap.get(index).getPriority())>0|| 
						
					 comparator.compare(heap.get(this.getRightChildOf(index)).getPriority(),heap.get(index).getPriority())>0) {
				
						if (comparator.compare(heap.get(this.getLeftChildOf(index)).getPriority(), heap.get(this.getRightChildOf(index)).getPriority()) >= 0) {
						largerchild = this.getLeftChildOf(index);
						} else {
						largerchild = this.getRightChildOf(index);
						}
						
			} 
			else {return;}
			
			swap(largerchild,index);
			index = largerchild;
		}
		
	}
	
	public Iterator<Entry<P, V>> iterator() {
		return heap.iterator();
	}
}


package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
ReverseIntegerComparator comp = new ReverseIntegerComparator();
	
	StudentArrayHeap<Integer, V> heap = new StudentArrayHeap<Integer, V>(comp);

	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		
		heap.add(priority, value);
		
		return this;
	}

	@Override
	public V dequeue() {
		
		return heap.remove();
	}

	@Override
	public V peek() {
		
		return heap.peek();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		
		return heap.iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		return comp;
	}

	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}
}


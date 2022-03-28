package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	 
	
  /**
   * QueueBasedBreadthFirstSearcher.
   * @param searchProblem : search problem
   */
  public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
	super(searchProblem);
	
  }

  @Override
  public List<T> findSolution() {
	   ArrayList<T> solutions = new ArrayList<T>();
	  
	   Stack<T> queue = new Stack<T>();
	   queue.add(searchProblem.getInitialState());
	      visited.add(searchProblem.getInitialState());
	      T b = null;
	      while (!queue.isEmpty()) {
	    	  
	          b = getNextUnvisitedNeighbor(queue.peek());
	          if (searchProblem.isGoal(b)){
	        	  queue.add(b);
	              return queue;
	          }
	          if (b == null) queue.pop();
	          else {
	              visited.add(b);
	              queue.add(b);
	          }
	      }
	      return queue;
	   
  }
}
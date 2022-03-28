package search;

import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	private Stack<T> stack;
  /**
   * StackBasedDepthFirstSearcher.
   * @param searchProblem : search problem
   */
  public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
   
	super(searchProblem);
	
  }

  @Override
  public List<T> findSolution() {
    // TODO
      Stack<T> stack = new Stack<T>();
      stack.push(searchProblem.getInitialState());
      visited.add(searchProblem.getInitialState());
      T b = null;
      while (!stack.isEmpty()) {
    	  
          b = getNextUnvisitedNeighbor(stack.peek());
          if (searchProblem.isGoal(b)){
              stack.push(b);
              return stack;
          }
          if (b == null) stack.pop();
          else {
              visited.add(b);
              stack.push(b);
          }
      }
      return stack;
  }

  
}


package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;


/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 */
public class LevelOrderIterator extends FileIterator<File> {

	File root;
	Queue<File> files = new Queue<File>();
	
  /**
   * Instantiate a new LevelOrderIterator, rooted at the rootNode.
   * @param rootNode : node of the root.
   * @throws FileNotFoundException if the rootNode does not exist.
   */
  public LevelOrderIterator(File rootNode) throws FileNotFoundException {
    // TODO 1
	  if(!rootNode.exists()) {
			throw new FileNotFoundException("File Not Found Exception");
		}
		
		files.enqueue(rootNode);
  }

  @Override
  public boolean hasNext() {
    // TODO 2
	  return(!(files.isEmpty()));
  }

  @Override
  public File next() throws NoSuchElementException {
    // TODO 3
	  	File t;
		File[] array;
		if(!this.hasNext()) {
			throw new NoSuchElementException();
		}
		t = files.dequeue();
		array = t.listFiles();
		if(array != null) {
			Arrays.sort(array);
			for(int i = 0; i < array.length; i++) {
				files.enqueue(array[i]);
			}
		}	
      return t;   
  }

  @Override
  public void remove() {
    // Leave this one alone.
    throw new UnsupportedOperationException();
  }

}

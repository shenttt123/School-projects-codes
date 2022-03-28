package structures;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class PublicListInterfaceTest {

  private ListInterface<String> list;

  @Before
  public void setup() {
    list = new RecursiveList<String>();
  }

  @Test (timeout = 500)
  public void testInsertFirstIsEmptySizeAndGetFirst1() {
    assertTrue("Newly constructed list should be empty.", list.isEmpty());
    assertEquals("Newly constructed list should be size 0.", 0, list.size());
    assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
    assertFalse("List should now have elements.", list.isEmpty());
    assertEquals("List should now have 1 element.", 1, list.size());
    assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
    list.insertFirst("world");
    assertEquals(2, list.size());
    list.insertFirst("foo");
    assertEquals(3, list.size());
    assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
    assertEquals("3 should equal","foo",list.get(0));
    assertEquals("2 should equal","world",list.get(1));
    
    list.insertAt(0,"pig1");
    list.insertAt(1,"pig2");
    list.insertAt(2,"pig3");
    list.insertAt(3,"pig4");
    list.insertAt(2,"pig5");
    list.removeLast();
    list.insertLast("gg");
    list.indexOf("pig5");
    assertFalse(list.remove("pig6"));
    list.removeFirst();
    list.removeFirst();
    list.removeFirst();
    list.removeLast();
    list.removeLast();
    list.removeLast();
   
    list.insertLast("pig2");
    list.insertAt(2,"pig5");
    list.removeLast();
    list.removeLast();
    list.removeLast();
    list.removeFirst();
    System.out.print(list.size());
    list.insertAt(0,"pig3");
    
  
    
    
    
    System.out.println("size is: "+ list.size());
    for(int i=0;i<list.size();i++) {
    	
    	System.out.println("elements are "+ list.get(i).toString());
    }
    System.out.println("First is "+ list.getFirst().toString());
    System.out.println("last is "+ list.getLast().toString());
    System.out.println("index of pig2 is "+ list.indexOf("pig2"));
  }
  
  
  
}

package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PublicListInterfaceTest {

	private ListInterface<String> list;

	@Before
	public void setup(){
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
	}
	
	@Test
	public void testinsertFirst(){
		assertTrue(list.isEmpty());
		list.insertFirst("hello");
		assertEquals(1, list.size());
		list.insertFirst("hi");
		assertEquals(2, list.size());
		assertEquals("hi", list.getFirst());
	}
	
	@Test
	public void testinsertLast(){
		assertTrue(list.isEmpty());
		list.insertLast("hellooo");
		list.insertLast("yo");
		assertEquals(2, list.size());
		assertEquals("yo", list.getLast());
	}
	
	@Test
	public void testinsertAt(){
		assertTrue(list.isEmpty());
		list.insertLast("1");
		list.insertLast("2");
		list.insertAt(1, "3");
		assertEquals("3", list.get(1));
		list.insertAt(2, "4");
		assertEquals("4", list.get(2));
		list.insertAt(2, "6");
		assertEquals("6", list.get(2));
		assertEquals("4", list.get(3));
		
	}
	
	@Test
	public void testRemoveFirst(){
		list.insertFirst("3");
		list.insertLast("2");
		list.insertFirst("1");
		list.removeFirst();
		assertEquals(2, list.size());
		assertEquals("3", list.getFirst());
		assertEquals("3", list.removeFirst());
	}
	
	@Test
	public void testremovelast(){
		assertTrue(list.isEmpty());
		list.insertFirst("1");
		list.insertLast("2");
		list.insertLast("4");
		assertEquals(3, list.size());
		list.removeLast();
		assertEquals("2", list.getLast());
		
	}
	
	@Test
	public void testremoveat(){
		list.insertLast("1");
		list.insertLast("2");
		list.insertLast("3");
		list.removeAt(1);
		assertEquals(2, list.size());
		assertEquals("3", list.get(1));
		list.insertLast("4");
		list.insertLast("5");
		list.removeAt(2);
		assertEquals("5", list.get(2));
		
	}
	
	@Test
	public void testremove(){
		list.insertLast("1");
		list.insertLast("2");
		list.insertLast("3");
		list.remove("2");
		assertEquals(2, list.size());
		assertEquals(false, list.remove("a"));
	}

	@Test
	public void testindexof(){
		list.insertLast("2");
		list.insertLast("3");
		list.insertLast("1");
		list.insertLast("4");
		assertEquals(1, list.indexOf("3"));
		assertEquals(0, list.indexOf("2"));
		assertEquals(3, list.indexOf("4"));
	}
	
	@Test
	public void testInsertsRemovesAndIndexOf() {
		list = new RecursiveList<String>();
		list.insertAt(0, "umass");
		list.insertAt(1, "amherst");
		list.insertAt(1, "cs187");
		assertEquals(3, list.size());
		assertEquals(list.indexOf("amherst"), 2);
		assertEquals(list.indexOf("cs187"), 1);
		assertEquals(list.indexOf("umass"), 0);
		list.removeAt(1);
		assertEquals(2, list.size());
		assertEquals(list.indexOf("amherst"), 1);
		assertEquals(list.indexOf("cs187"), -1);
		assertTrue(list.remove("umass")); //changed. This should return true and remove it too.
		assertEquals(1, list.size());
		System.out.println(list.get(0));
		assertEquals(list.indexOf("amherst"), 0);
		assertEquals(list.indexOf("umass"), -1);
		list.removeLast();
		assertFalse(list.remove("amherst")); //added this. This should return false.
		assertEquals(list.indexOf("amherst"), -1);
	}
	

	
}

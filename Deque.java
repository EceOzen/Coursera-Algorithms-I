import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Deque<Item> implements Iterable<Item> {

	private class Node {
	    Item item;
	    Node next;
	    Node prev;

	    public Node() {
	        this.item = null;
	        this.next = null;
	        this.prev = null;
	    }
	}
	
	private Node first, last;
	private int size = 0;
	
    // construct an empty deque
    public Deque() 
    {
    	Item item;
    	Node next;
    	Node prev;
    }

    // is the deque empty?
    public boolean isEmpty() 
    {
    	return size == 0;
    }

    // return the number of items on the deque
    public int size() 
    {
    	return size;
    }

    // add the item to the front
    public void addFirst(Item item) 
    {
    	checkIfNull(item);
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        
        if (size > 0) {
        	oldFirst.prev = first;
        }
        else {
        	last = first;
        }
       
        size++;
    	
    }
    
    // add the item to the back
    public void addLast(Item item) 
    {
    	checkIfNull(item);
        Node oldLast = last;
        last = new Node();
        last.prev = oldLast;
        last.item = item;
        
        if (size > 0) {
        	oldLast.next = last;
        }
        else {
        	first = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() 
    {
    	checkIfEmpty();
        Item item = first.item;
        if (size > 1) {
            first = first.next;
            first.prev = null;
        }
        else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() 
    {
    	checkIfEmpty();
        Item item = last.item;
        if (size > 1) {
            last = last.prev;
            last.next = null;
        }
        else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() 
    {
    	return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {
	    private Node current = first;
	    @Override
	    public boolean hasNext() {
		return current != null;
	    }

	    @Override
	    public Item next() {
		if (!hasNext()) {
		    throw new NoSuchElementException();
		}
		Item item = current.item;
		current = current.next;
		return item;
	    }
	    
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
    }
    
    private void checkIfNull(Item item) {
        if (item == null) throw new NullPointerException();
    }
    
    private void checkIfEmpty() {
    	if (isEmpty()) throw new NoSuchElementException();
    }

    // unit testing (required)
    public static void main(String[] args) 
    {
    	Deque<Integer> deque = new Deque<>();

        // Test isEmpty and size on empty deque
        assert deque.isEmpty();
        assert deque.size() == 0;

        // Test addFirst and addLast
        deque.addFirst(1);
        assert !deque.isEmpty();
        assert deque.size() == 1;

        deque.addLast(2);
        assert deque.size() == 2;

        // Test iterator
        Iterator<Integer> iterator = deque.iterator();
        assert iterator.hasNext();
        assert iterator.next() == 1;
        assert iterator.next() == 2;
        assert !iterator.hasNext();

        // Test removeFirst
        assert deque.removeFirst() == 1;
        assert deque.size() == 1;

        // Test removeLast
        assert deque.removeLast() == 2;
        assert deque.isEmpty();

        // Test exceptions
        boolean caughtException = false;
        try {
            deque.removeFirst();
        } catch (NoSuchElementException e) {
            caughtException = true;
        }
        assert caughtException;

        caughtException = false;
        try {
            deque.removeLast();
        } catch (NoSuchElementException e) {
            caughtException = true;
        }
        assert caughtException;

        caughtException = false;
        try {
            deque.addFirst(null);
        } catch (NullPointerException e) {
            caughtException = true;
        }
        assert caughtException;

        caughtException = false;
        try {
            deque.addLast(null);
        } catch (NullPointerException e) {
            caughtException = true;
        }
        assert caughtException;

        StdOut.println("All tests passed!");
    }


}

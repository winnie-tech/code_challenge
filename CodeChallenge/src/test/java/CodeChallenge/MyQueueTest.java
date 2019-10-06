package CodeChallenge;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Unit test for MyQueue Class
 */
public class MyQueueTest
{
	// Create a String-typed instance of MyQueue.
	MyQueue<String> q = new MyQueue<String>(0);

	// MyQueue is empty when size is 0.
	@Test
	public void testEmpty() {
		q = new MyQueue<String>(0);
		assertTrue(q.isEmpty());
		
		q = new MyQueue<String>(1);
		assertFalse(q.isEmpty());
	}
	
	// Head is the first element got enqueued.
	// Cannot get the head from MyQueue when there is no element.
	@Test(expected = NoSuchElementException.class)
	public void testHead() {
		q = new MyQueue<String>(2);
		q.enQueue("1");
		q.enQueue("2");
		assertEquals("1", q.head());

		q = new MyQueue<String>(0);
		assertNull(q.head());
	}
	
	// The first element got enqueued is the head of the queue.
	// Cannot enqueue to MyQueue beyond its size.
	@Test(expected = IllegalArgumentException.class)
	public void testEnqueue(){
		q = new MyQueue<String>(2);
		q.enQueue("1");
		assertEquals("1", q.head());

		q.enQueue("2");
		assertEquals("1", q.head());

		//MyQueue is full at this point, throws exception.
	    q.enQueue("3");
	}
		
	// MyQueue is immutable because the original queue is not changed after dequeuing.
	// Cannot dequeue from MyQueue when there is no element.
	@Test(expected = NoSuchElementException.class)
	public void testDequeue() {
		q = new MyQueue<String>(2);
		q.enQueue("1");
		q.enQueue("2");
		assertEquals("1", q.head());
		
		// The new queue is without the first element.
		MyQueue<String> q1 = q.deQueue();
		assertEquals("2", q1.head());

		// While the original queue remain unchanged.
		assertEquals("1", q.head());
		
		// No element after dequeue from q1
		MyQueue<String> q2 = q1.deQueue();
		assertNull(q2.deQueue());
	}
}

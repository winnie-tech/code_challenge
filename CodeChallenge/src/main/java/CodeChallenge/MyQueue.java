package CodeChallenge;

import java.util.NoSuchElementException;

/**
 * The class for my immutable queue implementation
 *
 */
public final class MyQueue<T> implements Queue<T>{
	
	private T[] myQueue;
	private int size = 0;
	private int rear = -1;

	@SuppressWarnings("unchecked")
	// Constructor to initialize
	MyQueue(int size) {
		this.myQueue = (T[]) new Object[size];	
		this.size = size;
	}
	
	// This constructor should only be used by dequeue() function.
	private MyQueue(int size, int rear, T[] myQueue){
		if(size == 0) {
			this.myQueue = null;
		} else {
			this.size = size;
			this.rear = rear;
			@SuppressWarnings("unchecked")
			T[] newQueue = (T[]) new Object[size];
			// Move elements to newQueue
			for(int i = 0 ; i < rear ; i++){
				newQueue[i] = myQueue[i+1];
			}
			this.myQueue = newQueue;
		}
	}

	// Push the element into MyQueue
	public MyQueue<T> enQueue(T t) {
		if(size == rear + 1){
			throw new IllegalArgumentException("Could not enqueue because MyQueue is already full.");
		}
		myQueue[++rear] = t;
		return this;
	}

	// Return a new queue without the first element of the original queue.
	@SuppressWarnings("unchecked")
	public MyQueue<T> deQueue() {
		if(isEmpty() || myQueue[0] == null){
			throw new NoSuchElementException("Could not dequeue because MyQueue is empty.");
		}
		@SuppressWarnings("rawtypes")
		MyQueue<T> newQueue = new MyQueue(size - 1, rear, myQueue);
		return newQueue;
	}

	// Get the first element of the queue.
	public T head() {
		if(isEmpty() || myQueue[0] == null){
			throw new NoSuchElementException("Could not get the head because MyQueue is empty.");
		}
		return myQueue[0];
	}

	// Check if the queue is empty of not.
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}
}

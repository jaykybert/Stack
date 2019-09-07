package queue;

import general.*;

class StaticQueue<T> implements StackQueueInterface<T> {
	private T[] queue;
	private int queueFront;
	
	// Constructors
	StaticQueue(T[] arr) {
		queue = arr;
		queueFront = 0;
		
		// Consider incrementing queueFront for existing values?
	}
	
	
	
	
	public void push(T o) throws FullArrayException {
	
	}
	
	public T pop() throws EmptyArrayException {
		// Check if queueFront is equal to length here. If it is, queue is empty. Think reverse of stack!
		
		T itm = queue[queueFront]; // Get item.
		queueFront++; // Increment front of queue to next item.
		return itm; // Return item.		
	}
}

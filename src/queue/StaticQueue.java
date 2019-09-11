package queue;

import general.*;

class StaticQueue<T> implements StackQueueInterface<T> {
	private T[] queue;
	private int qGet, qPut;
	
	// Constructors
	StaticQueue(T[] arr) {
		queue = arr;
		qGet = qPut = 0; 
		// Find the correct put index for initialised arrays.
		for(int i=0; i < queue.length; i++) {
			if(queue[i] == null) {
				qPut = i;
				return;
			}
		}
	}
	
	StaticQueue(StaticQueue<T> o) {
		queue = o.queue;
		qGet = o.qGet;
		qPut = o.qPut;
	}
	
	// Access Methods
	public int getLength() { return queue.length; }
	public int getItemCount() { return queue.length - qGet; } // ?
	
	// Interaction Methods
	public void push(T o) throws FullArrayException {
		if(qPut == queue.length)
			throw new FullArrayException();
		
		queue[qPut++] = o;
	}
	
	public T pop() throws EmptyArrayException {
		if(qGet == qPut)
			throw new EmptyArrayException();

		return queue[qGet++];
	}
}

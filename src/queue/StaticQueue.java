package queue;

import general.*;

class StaticQueue<T> implements StackQueueInterface<T> {
	private T[] queue;
	private int qGet, qPut;
	
	// Constructors
	StaticQueue(T[] arr) {
		queue = arr;
		
		qGet = qPut = 0;
		// Consider incrementing qGet and qPut for existing values?
		// qGet would be start of queue (0), qPut would be first null.
	}
	
	StaticQueue(StaticQueue<T> o) {
		queue = o.queue;
		qGet = o.qGet;
		qPut = o.qPut;
	}
	
	// Access Methods
	public int getLength() { return queue.length; }
	public int getItemCount() { return qPut - 1; } // ?
	
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

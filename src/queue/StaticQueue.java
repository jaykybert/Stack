package queue;

import general.*;

class StaticQueue<T> implements StackQueueInterface<T> {
	private T[] queue;
	private int qGet, qPut;
	private int qCount;
	
	// Constructors
	StaticQueue(T[] arr) {
		queue = arr;
		qGet = qPut = qCount = 0; 
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
		qCount = o.qCount;
	}
	
	// Access Methods
	public int getLength() { return queue.length; }
	public int getItemCount() { return qCount; }
	
	// Interaction Methods
	public void push(T o) throws FullArrayException {
		if(qPut == queue.length)
			throw new FullArrayException();
		qCount++;
		queue[qPut++] = o;
	}
	
	public T pop() throws EmptyArrayException {
		if(qGet == qPut)
			throw new EmptyArrayException();
		qCount--;
		return queue[qGet++];
	}
}

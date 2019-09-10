package queue;

import general.*;

public class DynamicQueue<T> implements StackQueueInterface<T> {
	private T[] queue;
	private int qGet, qPut;
	
	// Constructors
	DynamicQueue(T[] arr) {
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
}

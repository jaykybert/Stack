package queue;

import java.util.Arrays;
import general.*;

public class DynamicQueue<T> implements StackQueueInterface<T> {
	private T[] queue;
	private int qGet, qPut;
	private int qCount;
	private int array_multiplier = 3;
	
	// Constructors
	DynamicQueue(T[] arr) {
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
	
	DynamicQueue(DynamicQueue<T> o) {
		queue = o.queue;
		qGet = o.qGet;
		qPut = o.qPut;
		qCount = o.qCount;
	}
	
	// Access Methods
	private void setQueue(T[] o) { queue = o; }
	public int getLength() { return queue.length; }
	public int getItemCount() { return qCount; }
	int getArrayMultiplier() { return array_multiplier; }
	void setArrayMultiplier(int n) { array_multiplier = n; }
	
	// Interaction  Methods
	public void push(T o) {
		if (qPut == queue.length) // Increase array size.
			setQueue(Arrays.copyOf(queue, queue.length * getArrayMultiplier()));
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

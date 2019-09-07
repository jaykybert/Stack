package stack;

import general.*;

class CircularStack<T> implements StackQueueInterface<T> {
	private T[] stk;
	private int stkTop;
	
	// Constructors
	CircularStack(T[] arr) {
		stk = arr;
		stkTop = 0;
		// Increment stack top for arrays with values.
		for(T item: stk) {
			if(item != null)
				stkTop++;
		}
	}
	
	CircularStack(CircularStack<T> o) {
		stk = o.stk;
		stkTop = o.stkTop;
	}
	
	// Access Methods
	public int getLength() { return stk.length; }
	public int getItemCount() { return stkTop; }
	
	
	// Interaction Methods
	public void push(T o) {
		if(stkTop == stk.length) // Return to beginning.
			stkTop = 0;
		
		stk[stkTop++] = o;
	}
	
	public T pop() throws EmptyArrayException {
		if (stkTop == 0) // Stack empty.
				throw new EmptyArrayException();

		return stk[--stkTop];
	}
	
	

}

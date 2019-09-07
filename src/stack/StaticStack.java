package stack;

import general.*;

class StaticStack<T> implements StackQueueInterface<T> {
	private T[] stk;
	private int stkTop;
	
	// Constructors
	StaticStack(T[] arr) {
		stk = arr;
		stkTop = 0;
		// Increment stack top for arrays with values.
		for(T item: stk) {
			if(item != null)
				stkTop++;
		}
	}
	
	StaticStack(StaticStack<T> o) {
		stk = o.stk;
		stkTop = o.stkTop;
	}
	
	// Access Methods
	public int getLength() { return stk.length; }
	public int getItemCount() { return stkTop; }
	
	// Interaction Methods
	public void push(T o) throws FullArrayException {
		if (stkTop == stk.length) // Array is Full.
			throw new FullArrayException();
		
		stk[stkTop++] = o;		
	}
	
	public T pop() throws EmptyArrayException {
		if(stkTop == 0)  // Array is empty.
			throw new EmptyArrayException();
		
		return stk[--stkTop];	
	}
}

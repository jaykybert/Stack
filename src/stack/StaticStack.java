package stack;

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
	public void push(T o) throws FullStackException {
		if (stkTop == stk.length) // Array is Full.
			throw new FullStackException();
		
		stk[stkTop++] = o;		
	}
	
	public T pop() throws EmptyStackException {
		if(stkTop == 0)  // Array is empty.
			throw new EmptyStackException();
		
		return stk[--stkTop];	
	}
}

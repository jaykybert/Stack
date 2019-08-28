package stack;

class CircularStack<T> implements StackInterface<T> {
	private T[] stk;
	private int stkTop;
	
	// Constructors
	CircularStack(T[] arr) {
		stk = arr;
		stkTop = 0;
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
	
	public T pop() {
		if (stkTop == 0) // Stack empty.
			throw new ArrayIndexOutOfBoundsException();
		
		return stk[--stkTop];
	}
	
	

}

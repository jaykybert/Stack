package stack;

class StaticStack<T> implements StackInterface<T> {
	private T[] stk;
	private int stkTop;
	
	
	// Constructors
	
	StaticStack(T[] arr) {
		stk = arr;
		stkTop = 0;
	}
	
	
	// Access Methods
	public int getLength() { return stk.length; }	
	
	
	// Interaction Methods
	public void push(T ob) throws ArrayIndexOutOfBoundsException {
		if (stkTop == stk.length) // Array is Full.
			throw new ArrayIndexOutOfBoundsException();
		else {
			stk[stkTop] = ob;
			stkTop++;
		}
	}
	
	public T pop() throws ArrayIndexOutOfBoundsException {
		if(stkTop == 0)
			throw new ArrayIndexOutOfBoundsException();
		else {
		stkTop--;
		return stk[stkTop];
		}
	}
	
}

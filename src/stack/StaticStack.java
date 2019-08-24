package stack;

class StaticStack<T> implements StackInterface<T> {
	private T[] stk;
	private int stkTop;
	
	
	// Constructors
	
	StaticStack(T[] arr) {
		stk = arr;
		stkTop = 0;
	}
	
	
	StaticStack(StaticStack<T> o) {
		stk = o.stk;
		stkTop = o.stkTop;
	}
	
	
	// Access Methods
	public int getLength() { return stk.length; }
	
	public T[] getStack() { return stk; }
	
	
	// Interaction Methods
	public void push(T ob) {
		if (stkTop == stk.length) // Array is Full.
			throw new ArrayIndexOutOfBoundsException();
		else {
			stk[stkTop] = ob;
			stkTop++;
		}
	}
	
	public T pop() {
		if(stkTop == 0)  // Array is empty.
			throw new ArrayIndexOutOfBoundsException();
		else {
		stkTop--;
		return stk[stkTop];
		}
	}
	
}

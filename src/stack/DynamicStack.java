package stack;

import java.util.Arrays;

public class DynamicStack<T> implements StackInterface<T> {
	private T[] stk;
	private int stkTop;
	
	// Constructors
	DynamicStack(T[] arr) {
		stk = arr;
		stkTop = 0;
	}
	
	private void setStack(T[] o) { stk = o; }
	
	public int getLength() { return stk.length; }
	public int getItemCount() { return stkTop; }
	
	// Interaction Methods
	public void push(T o) {
		if(stkTop == stk.length)  // Increase array size.
			setStack(Arrays.copyOf(stk, stk.length * 5));
		
		stk[stkTop++] = o;
			
	}
	
	public T pop() {
		if(stkTop == 0) // Array is empty.
			throw new ArrayIndexOutOfBoundsException();
		
		return stk[--stkTop];
	}
}

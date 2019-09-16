package stack;

import java.util.Arrays;
import general.*;

public class DynamicStack<T> implements StackQueueInterface<T> {
	private T[] stk;
	private int stkTop;
	private int array_multiplier = 3;
	
	// Constructors
	DynamicStack(T[] arr) {
		stk = arr;
		stkTop = 0;
		// Increment stack top for arrays with values.
		for(T item: stk) {
			if(item != null)
				stkTop++;
		}
	}
	
	DynamicStack(DynamicStack<T> o) {
		stk = o.stk;
		stkTop = o.stkTop;
	}
	
	// Access Methods
	private void setStack(T[] o) { stk = o; }
	public int getLength() { return stk.length; }
	public int getItemCount() { return stkTop; }
	int getArrayMultiplier() { return array_multiplier; }
	void setArrayMultiplier(int n) { array_multiplier = n; }
	
	// Interaction Methods
	public void push(T o) {
		if(stkTop == stk.length)  // Increase array size.
			setStack(Arrays.copyOf(stk, stk.length * getArrayMultiplier()));
		
		stk[stkTop++] = o;		
	}
	
	public T pop() throws EmptyArrayException {
		if(stkTop == 0) // Array is empty.
			throw new EmptyArrayException();
		
		return stk[--stkTop];
	}
}

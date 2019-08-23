package stack;

class StaticStack<T> implements StackInterface<T> {
	private T[] stk;
	private int top;
	
	
	public void push(T ob) {
		
		// Check for index-out-of-bounds.
		stk[top] = ob;
		top++;
		
		
	}
	
	public T pop() {
		
	
	}
	
	
	

}

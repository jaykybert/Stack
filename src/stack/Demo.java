package stack;

public class Demo {

	public static void main(String[] args) {
		
		// 3-length Integer Array. Catch Out-Of-Bounds.
		Integer[] intArr = new Integer[3];
		
		StaticStack<Integer> sStack = new StaticStack<Integer>(intArr);
		sStack.push(5);
		sStack.push(6);
		sStack.push(7);
		try { // No space for item.
			sStack.push(5);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		sStack.pop();
		sStack.pop();
		sStack.pop();
		try { // Retrieve non-existent item.
			sStack.pop();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		System.out.println(sStack.getLength());
		
		
		
		
		

	}
}

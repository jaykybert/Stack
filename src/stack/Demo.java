package stack;

public class Demo {

	public static void main(String[] args) {
		
		// 3-length Integer Array. Catch Out-Of-Bounds.
		Integer[] intArr = new Integer[3];
		
		StaticStack<Integer> sStack = new StaticStack<Integer>(intArr);
		System.out.println("Length of Array: " + sStack.getLength());
		sStack.push(5);
		System.out.println("Item Count: " + sStack.getCount());
		sStack.push(6);
		System.out.println("Item Count: " + sStack.getCount());
		sStack.push(7);
		System.out.println("Item Count: " + sStack.getCount());
		
		System.out.println("\nRemoving Items\n");
		sStack.pop();
		System.out.println("Item Count: " + sStack.getCount());
		sStack.pop();
		System.out.println("Item Count: " + sStack.getCount());
		sStack.push(12);
		System.out.println("Item Count: " + sStack.getCount());
		
		// Constructor Test - Two objects with the same reference.
	
		
		
		

	}
}

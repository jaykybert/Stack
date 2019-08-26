package stack;

public class Demo {

	public static void main(String[] args) {
		
		/*
		// 3-length Integer Array. Catch Out-Of-Bounds.
		Integer[] intArr = new Integer[3];
		
		StaticStack<Integer> sStack = new StaticStack<Integer>(intArr);
		System.out.println("Length of Array: " + sStack.getLength());
		sStack.push(5);
		System.out.println("Item Count: " + sStack.getItemCount());
		sStack.push(6);
		System.out.println("Item Count: " + sStack.getItemCount());
		sStack.push(7);
		System.out.println("Item Count: " + sStack.getItemCount());
		
		System.out.println("\nRemoving Items\n");
		sStack.pop();
		System.out.println("Item Count: " + sStack.getItemCount());
		sStack.pop();
		System.out.println("Item Count: " + sStack.getItemCount());
		sStack.push(12);
		System.out.println("Item Count: " + sStack.getItemCount());
		
		// Constructor Test - Two objects with the same reference.
		*/
		
		// Dynamic Stack:
		Double[] dArr = new Double[5];
		DynamicStack<Double> dStack = new DynamicStack<Double>(dArr);
		
		dStack.push(1.0);
		dStack.push(2.0);
		dStack.push(3.0);
		dStack.push(4.0);
		dStack.push(5.0);
		System.out.println("Stack Count: " + dStack.getItemCount());
		System.out.println("Stack Size: " + dStack.getLength());
		dStack.push(6.0);
		System.out.println("Stack Count: " + dStack.getItemCount());
		System.out.println("Stack Size: " + dStack.getLength());
		
		System.out.println("Removing two items...");
		dStack.pop();
		dStack.pop();
		
		System.out.println("Stack Size: " + dStack.getLength());
		System.out.println("Stack Count: " + dStack.getItemCount());
		
		
		

	}
}

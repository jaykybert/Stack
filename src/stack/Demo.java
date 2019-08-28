package stack;

public class Demo {

	public static void main(String[] args) {
		
		
		
		// 3-length Integer Array. Catch Out-Of-Bounds.
		Integer[] intArr = new Integer[3];
		
		// is stkTop 0 by default when passing an array argumement?
		// What happens if the array passed already contains values?
		
		StaticStack<Integer> sStack = new StaticStack<Integer>(intArr);
		
		System.out.print("Pushing: ");
		for(int i=0; i < 3; i++) {
			System.out.print((i*10) + " ");
			sStack.push(i*10);
		}
		
		// Over-push stack.
		System.out.println("\nPushing...");
		try {
			sStack.push(30);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Array Length: " + sStack.getLength());
		System.out.println("Item Count: " + sStack.getItemCount());
		
		System.out.println("Popping 1 Item...");
		System.out.println("Item Popped: " + sStack.pop());
		System.out.println("Item Count: " + sStack.getItemCount());
		 
		System.out.println();
		
		for(int i=0; i < 3; i++) { // Over-pop stack.
			System.out.println("Popping...");
			try {
				sStack.pop();
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
			System.out.println("Item Count: " + sStack.getItemCount());
		}
		
		
		/*
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
		*/
		
		
		/*
		// Circular Stack:
		Character[] cArr = new Character[10];
		CircularStack<Character> cStack = new CircularStack<Character>(cArr);
		
		System.out.print("Pushing: ");
		for(int i=0; i < 10; i++) {
			System.out.print(i + " ");
			cStack.push((char) i);
		}
		
		System.out.println();
		
		System.out.println("Array Length: " + cStack.getLength());
		System.out.println("Item Count: " + cStack.getItemCount());
		
		

		System.out.println("Item Count: " + cStack.getItemCount());
		*/
		

	}
}

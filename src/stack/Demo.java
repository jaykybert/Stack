package stack;

public class Demo {
	
	static StaticStack<Integer> createStaticStack(int len) {
		Integer[] intArray = new Integer[len];
		StaticStack<Integer> stk = new StaticStack<Integer>(intArray);
		return stk;
	}
	
	static DynamicStack<Double> createDynamicStack(int len) {
		Double[] doubleArray = new Double[len];
		DynamicStack<Double> stk = new DynamicStack<Double>(doubleArray);
		return stk;
	}
	
	static CircularStack<Character> createCircularStack(int len) {
		Character[] charArray = new Character[len];
		CircularStack<Character> stk = new CircularStack<Character>(charArray);
		return stk;
	}

	static void demoStaticStack(StaticStack<Integer> stk) {
		for(int i=0; i < stk.getLength() + 1; i++) {
			System.out.println("Adding: " + i * 10);
			try {
				stk.push(i*10);
				System.out.println("Item Count: " + stk.getItemCount() + "\n");
			}
			catch(FullStackException e) {
				System.out.println("Exception Raised: " + e);
			}
		}
		System.out.println("Stack Length: " + stk.getLength());
		
		for(int i=0; i < stk.getLength() + 1; i++) {
			System.out.println("Popping...");
			try {
				stk.pop();
				System.out.println("Item Count: " + stk.getItemCount() + " \n");
			}
			catch(EmptyStackException e) {
				System.out.println("Exception Raised: " + e);
			}
		}
	}
	
	static void demoDynamicStack(DynamicStack<Double> stk) {
		for(int i=0; i < 5; i++) {
			System.out.println("Adding: " + i * 0.1);
			stk.push(i * 0.1);			
		}
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("Stack Length: " + stk.getLength());
		
		System.out.println("\nPushing to full stack:\nAdding: " + 0.5);
		stk.push(0.5);
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("New Stack Length: " + stk.getLength() + "\n");
		
		for(int i=6; i < 25; i++) {
			System.out.println("Adding: " + i * 0.1);
			stk.push(i * 0.1);
		}
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("Stack Length: " + stk.getLength());
		
		System.out.println();
		
		for(int i=0; i < 26; i++) {
			try {
			System.out.println("Popping: " + stk.pop());
			}
			catch(EmptyStackException e) {
				System.out.println("Exception Raised: " + e);
			}
		}
	}
	
	static void demoCircularStack(CircularStack<Character> stk) {
		for(int i=0; i < 3; i++) {
			System.out.println("Adding: " + (char) ('A' + i));
			stk.push((char) ('A' + i));
		}
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("Stack Length: " + stk.getLength());
		
		System.out.println();
				
		// Overwrite stack.
		for(int i=3; i < 6; i++) {
			System.out.println("Adding: " + (char) ('A' + i));
			stk.push((char) ('A' + i));
		}
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("Stack Length: " + stk.getLength());
		
		System.out.println();
		
		// Popping.
		for(int i=0; i < 4; i++) {

			try {
				System.out.println("Popping: " + stk.pop());
			}
			catch(EmptyStackException e) {
				System.out.println("Exception Raised: " + e);
			}
		}
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("Stack Length: " + stk.getLength());
	}
	
	public static void main(String[] args) {		
		StaticStack<Integer> staticStack = Demo.createStaticStack(10);
		//Demo.demoStaticStack(staticStack);
		
		DynamicStack<Double> dynamicStack = Demo.createDynamicStack(5);
		//demo.DemoDynamicStack(dynamicStack);
		
		/* CircularStack Notes:
		 * Item Count resets to 1 once push() restarts at the start of the array.
		 * Should you be able to pop() at index 0, making you go to the very end (think full-duplex)?
		 */
		CircularStack<Character> circularStack = Demo.createCircularStack(3);
		Demo.demoCircularStack(circularStack);
	}
}

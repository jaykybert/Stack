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

	static void DemoStaticStack(StaticStack<Integer> stk) {
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
	
	static void DemoDynamicStack(DynamicStack<Double> stk) {
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
	
	public static void main(String[] args) {
		
		/* Notes:
		 * Improve demo system.
		 * Create factory method that creates a chosen stack of a chosen size (excluding dynamic).
		 * Put everything into call-able methods, clean up code. Run extraneous data, handle exceptions.
		 */	
		
		StaticStack<Integer> staticStack = Demo.createStaticStack(10);
		//Demo.DemoStaticStack(staticStack);
		
		DynamicStack<Double> dynamicStack = Demo.createDynamicStack(5);
		Demo.DemoDynamicStack(dynamicStack);
		CircularStack<Character> circularStack = Demo.createCircularStack(3);
		

	}
}

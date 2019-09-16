package stack;

import general.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DemoStack {

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
		System.out.println("\nItem Count\t\t" + stk.getItemCount());
		System.out.println("Queue Length\t\t" + stk.getLength());

		System.out.println("\nPush items to the stack...");
		for(int i=0; i < stk.getLength() + 1; i++) {
			try {
				stk.push(i * 10);
				System.out.println("... adding " + i * 10 + "\tItem Count - " + stk.getItemCount());
			}
			catch(FullArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}
		System.out.println("Item Count\t" + stk.getItemCount());
		System.out.println("Queue Length\t" + stk.getLength());

		System.out.println("\nPop items from the stack...");
		for(int i=0; i < stk.getLength() + 1; i++) {
			try {
				System.out.println("... popping " + stk.pop() + "\tItem Count - " + stk.getItemCount());
			}
			catch(EmptyArrayException e) { 
				System.out.println("Exception Caught: " + e);
			}
		}	
		System.out.println("Item Count\t" + stk.getItemCount());
		System.out.println("Queue Length\t" + stk.getLength());
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
			catch(EmptyArrayException e) {
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
			catch(EmptyArrayException e) {
				System.out.println("Exception Raised: " + e);
			}
		}
		System.out.println("Item Count: " + stk.getItemCount());
		System.out.println("Stack Length: " + stk.getLength());
	}

	public static void main(String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number corresponding to the type of stack you wish to demo.");
		System.out.println(" - 1: Static Stack\n - 2: Dynamic Stack\n - 3: Circular Stack");
		System.out.print(" > ");
		try {
			String input = r.readLine();

			switch(input) {
			case "1":
				StaticStack<Integer> staticStack = DemoStack.createStaticStack(5);
				DemoStack.demoStaticStack(staticStack);
				break;

			case "2":
				DynamicStack<Double> dynamicStack = DemoStack.createDynamicStack(2);
				DemoStack.demoDynamicStack(dynamicStack);
				break;

			case "3":
				CircularStack<Character> circularStack = DemoStack.createCircularStack(5);
				DemoStack.demoCircularStack(circularStack);

			default:
				break;
			}
		}
		catch(IOException e) {
			System.out.println("Exception Caught: " + e);
		}
	}
}



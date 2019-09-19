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
		System.out.println("\nItem Count\t" + stk.getItemCount());
		System.out.println("Stack Length\t" + stk.getLength());

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
		System.out.println("\nPop items from the stack...");
		for(int i=0; i < stk.getLength() + 1; i++) {
			try {
				System.out.println("... popping " + stk.pop() + "\tItem Count - " + stk.getItemCount());
			}
			catch(EmptyArrayException e) { 
				System.out.println("Exception Caught: " + e);
			}
		}	
	}

	static void demoDynamicStack(DynamicStack<Double> stk) {
		System.out.println("\nArray Multiplier\t" + stk.getArrayMultiplier());		
		System.out.println("Initial Item Count\t" + stk.getItemCount());
		System.out.println("Initial Stack Length\t" + stk.getLength());

		System.out.println("\nPush items to the stack...");

		for(int i=0; i < stk.getLength(); i++) {
			stk.push(i * 1.0);
			System.out.println("... adding " + i * 1.0 + "\tItem Count - " + stk.getItemCount());	
		}
		System.out.println("\nIncrease array size when pushing to a full stack...");

		int qLimit = stk.getLength() * stk.getArrayMultiplier();

		for(int i=stk.getLength(); i < qLimit; i++) {
			stk.push(i * 1.0);
			System.out.println("... adding " + i * 1.0 + "\tItem Count - " + stk.getItemCount());
		}
		System.out.println("New Stack Length\t" + stk.getLength());
		System.out.println("\nPop items from the stack...");

		for(int i=0; i < stk.getLength() + 1; i++) {
			try {
				System.out.println("... popping " + stk.pop() + "\tItem Count - " + stk.getItemCount());
			}
			catch(EmptyArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}
	}

	static void demoCircularStack(CircularStack<Character> stk) {
		System.out.println("Initial Item Count\t" + stk.getItemCount());
		System.out.println("Stack Length\t\t" + stk.getLength());

		System.out.println("\nPush items to the stack...");

		for(int i=0; i < stk.getLength(); i++) {
			stk.push((char) ('A' + i));
			System.out.println("... adding " + (char) ('A' + i) + "\tItem Count - " + stk.getItemCount());
		}
		System.out.println("\nOverwrite items in the stack...");

		// Overwrite stack.
		for(int i=stk.getLength(); i < stk.getLength() * 2; i++) {
			stk.push((char) ('A' + i));
			System.out.println("... adding " + (char) ('A' + i) + "\tItem Count - " + stk.getItemCount());
		}		
		System.out.println("\nPop items from the stack...");

		// Popping.
		for(int i=0; i < stk.getLength() + 1; i++) {
			try {
				System.out.println("... popping " + stk.pop() + "\tItem Count - " + stk.getItemCount());
			}
			catch(EmptyArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		do {
			System.out.println("Enter the number corresponding to the type of stack you wish to demo.");
			System.out.println(" - 1: Static Stack\n - 2: Dynamic Stack\n - 3: Circular Stack");
			System.out.print(" > ");
			try {
				input = r.readLine();

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
					System.out.println("Invalid Option.");
					break;
				}
			}
			catch(IOException e) {
				System.out.println("Exception Caught: " + e);
			}
			System.out.println("\n-----------------------------------\nWould you like to demo another stack? (Y/N)");
			System.out.print(" > ");
			try {
				input = r.readLine();
			}
			catch(IOException e) {
				System.out.println("Exception Caught: " + e);
			}
		} while(input.contentEquals("y"));
	}
}



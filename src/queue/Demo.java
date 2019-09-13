package queue;

import general.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Demo {

	static StaticQueue<Character> createStaticQueue(int len) {
		Character[] chArray = new Character[len];
		StaticQueue<Character> q = new StaticQueue<Character>(chArray);
		return q;
	}
	
	static DynamicQueue<Integer> createDynamicQueue(int len) {
		Integer[] intArray = new Integer[len];
		DynamicQueue<Integer> q = new DynamicQueue<Integer>(intArray);
		return q;
	}

	static void demoStaticQueue(StaticQueue<Character> queue) {
		System.out.println("Item Count: " + queue.getItemCount());
		System.out.println("Queue Length: " + queue.getLength());
		for(int i=0; i < 6; i++) {
			try {
				queue.push((char) ('a' + i));
				System.out.println("Adding: " + (char) ('a' + i));
			}
			catch(FullArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}

		System.out.println("Item Count: " + queue.getItemCount());
		System.out.println("Queue Length: " + queue.getLength());

		System.out.println();
		for(int i=0; i < 6; i++) {
			try {
				System.out.println("Popped: " + queue.pop() + "\t - Item Count: " + queue.getItemCount());
			}
			catch(EmptyArrayException e) { 
				System.out.println("Exception Caught: " + e);
			}
		}	
		System.out.println("Item Count: " + queue.getItemCount());
		System.out.println("Queue Length: " + queue.getLength());
	}
	
	static void demoDynamicQueue(DynamicQueue<Integer> queue) {
		System.out.println("\nInitial Item Count: " + queue.getItemCount());
		System.out.println("Initial Queue Length: " + queue.getLength());
		for(int i=0; i < 3; i++) {
			queue.push(i * 5);
			System.out.println("Adding: " + i * 5);	
		}
		System.out.println("Item Count: " + queue.getItemCount());
		System.out.println("Queue Length: " + queue.getLength());
		
		System.out.println("\nIncrease array size when pushing to a full queue...");
		
		for(int i=3; i < 15; i++) {
			queue.push(i*5);
			System.out.println("Adding: " + i * 5);
		}
		System.out.println("Item Count: " + queue.getItemCount());
		System.out.println("Queue Length: " + queue.getLength());
		
		System.out.println();
		
		for(int i=0; i < 16; i++) {
			try {
				System.out.println("Popping: " + queue.pop());
			}
			catch(EmptyArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}
		System.out.println("Item Count: " + queue.getItemCount());
		System.out.println("Queue Length: " + queue.getLength());
			
		

	}

	// TODO: Don't hardcode values for demo, use length of queue relatively.
	// Create constant for array multiplier. i.e. const = 2; (array gets twice as big).
	public static void main(String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number corresponding to the type of stack you wish to demo.");
		System.out.println(" - 1: Static Stack\n - 2: Dynamic Stack\n - 3: Circular Stack");
		System.out.print(" > ");
		try {
			String input = r.readLine();
				
			switch(input) {
			case "1":
				StaticQueue<Character> staticQueue = Demo.createStaticQueue(5);
				Demo.demoStaticQueue(staticQueue);
				break;
			
			case "2":
				DynamicQueue<Integer> dynamicQueue = Demo.createDynamicQueue(3);
				Demo.demoDynamicQueue(dynamicQueue);
				break;
				
			default:
				break;
			
			}
	
		}
		catch(IOException e) {
			System.out.println("Exception Caught: " + e);
		}
	}
}

package queue;

import general.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class DemoQueue {

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

	static CircularQueue<Double> createCircularQueue(int len) {
		Double[] doubArray = new Double[len];
		CircularQueue<Double> q = new CircularQueue<Double>(doubArray);
		return q;
	}

	static void demoStaticQueue(StaticQueue<Character> queue) {
		System.out.println("\nItem Count\t\t" + queue.getItemCount());
		System.out.println("Queue Length\t\t" + queue.getLength());

		System.out.println("\nPush items to the queue...");
		for(int i=0; i < queue.getLength() + 1; i++) {
			try {
				queue.push((char) ('a' + i));
				System.out.println("... adding " + (char) ('a' + i) + " \tItem Count - " + queue.getItemCount());
			}
			catch(FullArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}

		System.out.println("\nPop items from the queue...");
		for(int i=0; i < queue.getLength() + 1; i++) {
			try {
				System.out.println("... popping " + queue.pop() + "\tItem Count - " + queue.getItemCount());
			}
			catch(EmptyArrayException e) { 
				System.out.println("Exception Caught: " + e);
			}
		}	
	}

	static void demoDynamicQueue(DynamicQueue<Integer> queue) {
		System.out.println("\nArray Multiplier\t" + queue.getArrayMultiplier());		
		System.out.println("Initial Item Count\t" + queue.getItemCount());
		System.out.println("Initial Queue Length\t" + queue.getLength());

		System.out.println("\nPush items to the queue...");

		for(int i=0; i < queue.getLength(); i++) {
			queue.push(i * 5);
			System.out.println("... adding " + i * 5 + "\tItem Count - " + queue.getItemCount());	
		}

		System.out.println("\nIncrease array size when pushing to a full queue...");

		int qLimit = queue.getLength() * queue.getArrayMultiplier();

		for(int i=queue.getLength(); i < qLimit; i++) {
			queue.push(i*5);
			System.out.println("... adding " + i * 5 + "\tItem Count - " + queue.getItemCount());
		}
		System.out.println("New Queue Length\t" + queue.getLength());
		System.out.println("\nPop items from the queue...");

		for(int i=0; i < queue.getLength() + 1; i++) {
			try {
				System.out.println("... popping " + queue.pop() + "\tItem Count - " + queue.getItemCount());
			}
			catch(EmptyArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}
	}

	static void demoCircularQueue(CircularQueue<Double> queue) {
		System.out.println("\nInitial Item Count\t" + queue.getItemCount());
		System.out.println("Queue Length\t\t" + queue.getLength());

		System.out.println("\nPush items to the queue...");
		for(int i=0; i < queue.getLength(); i++) {
			queue.push(i * 1.0);
			System.out.println("... adding " + i * 1.0 + "\tItem Count - " + queue.getItemCount());
		}

		System.out.println("\nOverwrite items in the queue...");
		for(int i=queue.getLength(); i < (queue.getLength() * 2) - 1; i++) {
			queue.push(i * 1.0);
			System.out.println("... adding " + i * 1.0 + "\tItem Count - " + queue.getItemCount());
		}

		System.out.println("\nPop items from the queue...");
		for(int i=0; i < queue.getLength() - 1; i++) {
			try {
				System.out.println("... popping " + queue.pop() + "\tItem Count - " + queue.getItemCount());
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
			System.out.println("Enter the number corresponding to the type of queue you wish to demo.");
			System.out.println(" - 1: Static Queue\n - 2: Dynamic Queue\n - 3: Circular Queue");
			System.out.print(" > ");
			try {
				input = r.readLine();

				switch(input) {
				case "1":
					StaticQueue<Character> staticQueue = DemoQueue.createStaticQueue(5);
					DemoQueue.demoStaticQueue(staticQueue);
					break;

				case "2":
					DynamicQueue<Integer> dynamicQueue = DemoQueue.createDynamicQueue(2);
					DemoQueue.demoDynamicQueue(dynamicQueue);
					break;

				case "3":
					CircularQueue<Double> circularQueue = DemoQueue.createCircularQueue(3);
					DemoQueue.demoCircularQueue(circularQueue);

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

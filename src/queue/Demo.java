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

	static void demoStaticQueue(StaticQueue<Character> queue) {
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

	public static void main(String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number corresponding to the type of stack you wish to demo.");
		System.out.println(" - 1: Static Stack\n - 2: Dynamic Stack\n - 3: Circular Stack");
		System.out.println(" > ");
		try {
			String input = r.readLine();
				
			switch(input) {
			case "1":
				StaticQueue<Character> staticQueue = Demo.createStaticQueue(5);
				Demo.demoStaticQueue(staticQueue);
				break;
			
			case "2":
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

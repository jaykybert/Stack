package queue;

import general.*;

public class Demo {

	static StaticQueue<Character> createStaticQueue(int len) {
		Character[] chArray = new Character[len];
		StaticQueue<Character> q = new StaticQueue<Character>(chArray);
		return q;
	}

	static void demoStaticQueue(StaticQueue<Character> queue) {
		for(int i=0; i < 27; i++) {
			try {
				queue.push((char) ('A' + i));
				System.out.println("Adding: " + (char) ('A' + i));
			}
			catch(FullArrayException e) {
				System.out.println("Exception Caught: " + e);
			}
		}
		
		System.out.println("Queue Length: " + queue.getLength());
		System.out.println("Item Count: " + queue.getItemCount());
		try {
			queue.pop();
			queue.pop();
			queue.push('G');
		}
		catch(EmptyArrayException | FullArrayException e) {
			System.out.println("Exception Caught: " + e);
		}
		System.out.println("Queue Length: " + queue.getLength());
		System.out.println("Item Count: " + queue.getItemCount());

	}

	public static void main(String[] args) {
		StaticQueue<Character> staticQueue = Demo.createStaticQueue(26);
		Demo.demoStaticQueue(staticQueue);



	}

}

package general;

public interface StackQueueInterface<T> {
	void push(T o) throws FullArrayException; // Add item to array.
	T pop() throws EmptyArrayException; // Remove item from array.
	int getLength(); // Length of array.
	int getItemCount(); // Number of items currently stored.
}

package general;

public interface StackQueueInterface<T> {
	void push(T o) throws FullArrayException;
	T pop() throws EmptyArrayException;
	int getLength(); // Length of array.
	int getItemCount(); // Number of items currently stored.
}
